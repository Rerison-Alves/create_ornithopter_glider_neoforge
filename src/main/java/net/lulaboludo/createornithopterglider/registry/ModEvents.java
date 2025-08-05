package net.lulaboludo.createornithopterglider.registry;

import com.illusivesoulworks.caelus.api.CaelusApi;
import net.lulaboludo.createornithopterglider.CreateOrnithopterGlider;
import net.lulaboludo.createornithopterglider.item.custom.OrnithopterGliderItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(modid = CreateOrnithopterGlider.MOD_ID)
public class ModEvents {

    public static final ResourceLocation ORNITHOPTER_FLIGHT_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(CreateOrnithopterGlider.MOD_ID, "ornithopter_flight");
    public static final AttributeModifier ORNITHOPTER_FLIGHT = new AttributeModifier(ORNITHOPTER_FLIGHT_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE);

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        var attributeInstance = player.getAttribute(CaelusApi.getInstance().getFallFlyingAttribute());

        if (attributeInstance != null) {
            boolean hasOrnithopter = isOrnithopterInCurios(player);

            if (attributeInstance.hasModifier(ORNITHOPTER_FLIGHT.id())) {
                if (!hasOrnithopter) {
                    attributeInstance.removeModifier(ORNITHOPTER_FLIGHT_MODIFIER_ID);
                }
            } else {
                if (hasOrnithopter) {
                    attributeInstance.addTransientModifier(ORNITHOPTER_FLIGHT);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        var attributeInstance = player.getAttribute(CaelusApi.getInstance().getFallFlyingAttribute());
        if (attributeInstance != null && isOrnithopterInCurios(player) && !attributeInstance.hasModifier(ORNITHOPTER_FLIGHT.id())) {
            attributeInstance.addTransientModifier(ORNITHOPTER_FLIGHT);
        }
    }

    private static boolean isOrnithopterInCurios(Player player) {
        return CuriosApi.getCuriosInventory(player)
                .map(inv -> inv.isEquipped(stack -> stack.getItem() instanceof OrnithopterGliderItem))
                .orElse(false);
    }
}
