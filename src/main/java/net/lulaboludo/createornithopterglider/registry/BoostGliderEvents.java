package net.lulaboludo.createornithopterglider.registry;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lulaboludo.createornithopterglider.client.animations.FlapAnimationManager;
import net.lulaboludo.createornithopterglider.item.custom.OrnithopterGliderItem;
import net.lulaboludo.createornithopterglider.networking.payloads.BoostGliderPayload;
import net.lulaboludo.createornithopterglider.sounds.ModSounds;
import net.lulaboludo.createornithopterglider.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

import static net.lulaboludo.createornithopterglider.CreateOrnithopterGlider.MOD_ID;
import static net.lulaboludo.createornithopterglider.client.animations.OrnithoptergGliderAnimation.OG_GLIDING_FLAP;
import static net.lulaboludo.createornithopterglider.networking.ModMessages.sendToServer;

@EventBusSubscriber(
        modid = MOD_ID,
        value = Dist.CLIENT)
public class BoostGliderEvents {
    public static boolean charging = false;
    public static int chargeTicks = 0;
    public static int overflowTicks = 0;
    public static final int MAX_CHARGE = 30;
    public static final int DECAY_TIME = 2;
    public static final int DECAY_PIXELS = 30;

    public static final int COOLDOWN_TICKS = 2 * 20; // 2 Segundos
    public static int cooldownTicks = 0;
    public static int cooldownDisplayDelay = 0;

    static final ResourceLocation BOOST_BAR = ResourceLocation.fromNamespaceAndPath(MOD_ID, "boost_charge");
    static final ResourceLocation FILL = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/boost_bar.png");
    static final ResourceLocation BG   = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/boost_bar_background.png");
    static final ResourceLocation ICON = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/boost_icon.png");


    static final int BG_WIDTH = 186;
    static final int BG_HEIGHT = 22;

    static final int FILL_WIDTH = 182;
    static final int FILL_HEIGHT = 5;

    static final float TEXT_SCALE = 0.6f;

    static final int ICON_SIZE = 8;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Pre event) {
        var mc = Minecraft.getInstance();
        if (cooldownTicks > 0) {
            cooldownTicks--;
            cooldownDisplayDelay++;

            if (cooldownTicks == 0) {
                cooldownDisplayDelay = 0;
            }
            return;
        }

        if (!OrnithopterGliderItem.isFlying(mc.player)) return;

        if (KeyBinding.BOOST_KEY.isDown()) {
            if (!charging) {
                charging = true;
                chargeTicks = 0;
                overflowTicks = 0;
            }
            if (chargeTicks < MAX_CHARGE) {
                chargeTicks++;
            } else {
                overflowTicks = Math.min(overflowTicks + 1, DECAY_TIME);
            }
        }
        else if (charging) {
            float percent = getFilled() / (float)FILL_WIDTH;
            float curve = (float) Math.pow(percent, 2);
            int force = Math.round(curve * MAX_CHARGE);
            sendToServer(new BoostGliderPayload(force));
            FlapAnimationManager.playAnimation(mc.player, OG_GLIDING_FLAP);
            Level level = mc.player.level();
            level.playSound(mc.player, mc.player.getX(), mc.player.getY(), mc.player.getZ(),
                    ModSounds.WING_FLAPPING.get(), SoundSource.PLAYERS, 10f, 1f);
            charging = false;
            cooldownTicks = COOLDOWN_TICKS;
        }
    }

    @SubscribeEvent
    public static void onOverlayPre(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if ((event.getName().equals(VanillaGuiLayers.EXPERIENCE_BAR)
                || event.getName().equals(VanillaGuiLayers.EXPERIENCE_LEVEL))
                && OrnithopterGliderItem.isFlying(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onRegisterGuiOverlays(RegisterGuiLayersEvent event) {

        event.registerAbove(
                VanillaGuiLayers.JUMP_METER,
                BOOST_BAR,
                (guiGraphics, deltaTracker) -> {
                    var mc = Minecraft.getInstance();
                    int screenWidth = guiGraphics.guiWidth();
                    int screenHeight = guiGraphics.guiHeight();
                    if (!OrnithopterGliderItem.isFlying(mc.player) || mc.options.hideGui) return;

                    int x = (screenWidth - BG_WIDTH) / 2;
                    int y = screenHeight - 42;

                    guiGraphics.blit(BG, x, y, 0, 0, BG_WIDTH, BG_HEIGHT, BG_WIDTH, BG_HEIGHT);

                    int xIcon = (screenWidth - ICON_SIZE) / 2;
                    int yIcon = y + 4;
                    if (cooldownTicks > 0) {
                        if (cooldownDisplayDelay >= 8) {
                            float secondsLeft = cooldownTicks / 20f;
                            String text = String.format("%.1f", secondsLeft);
                            int textW = mc.font.width(text);
                            int xText = ((screenWidth - textW) / 2) + 3;
                            int yText = y + 6;

                            drawString(guiGraphics, mc, text, xText, yText);
                        } else {
                            guiGraphics.blit(ICON, xIcon, yIcon, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);
                        }
                        return;
                    } else {
                        guiGraphics.blit(ICON, xIcon, yIcon, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);
                    }
                    if (charging) {
                        int filled = getFilled();
                        if (filled > 0) {
                            int fillX = x + (BG_WIDTH - FILL_WIDTH) / 2;
                            int fillY = y + 14;
                            guiGraphics.blit(FILL, fillX, fillY, 0, 0, filled, FILL_HEIGHT, FILL_WIDTH, FILL_HEIGHT);
                        }
                    }

                }
        );
    }

    private static void drawString(GuiGraphics guiGraphics, Minecraft mc, String text, int xText, int yText) {
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.scale(TEXT_SCALE, TEXT_SCALE, 1.0f);
        guiGraphics.drawString(mc.font, text, xText / TEXT_SCALE, yText / TEXT_SCALE, 0xFFFFFFFF, true);
        poseStack.popPose();
    }

    private static int getFilled() {
        int filled;
        if (chargeTicks < MAX_CHARGE) {
            filled = (int)((chargeTicks / (float)MAX_CHARGE) * FILL_WIDTH);
        } else {
            float t = overflowTicks / (float) DECAY_TIME;
            int decay = Math.round(t * DECAY_PIXELS);
            filled = FILL_WIDTH - decay;
        }
        return filled;
    }
}
