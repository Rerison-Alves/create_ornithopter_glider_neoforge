package net.lulaboludo.createornithopterglider.registry;

import net.lulaboludo.createornithopterglider.client.model.OrnithopterGliderModel;
import net.lulaboludo.createornithopterglider.client.renderer.OrnithopterGliderCurioRenderer;
import net.lulaboludo.createornithopterglider.client.renderer.OrnithopterGliderLayer;
import net.lulaboludo.createornithopterglider.item.ModItems;
import net.lulaboludo.createornithopterglider.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin.Model;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import java.util.List;

import static net.lulaboludo.createornithopterglider.CreateOrnithopterGlider.MOD_ID;

@EventBusSubscriber(
        modid = MOD_ID,
        value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : List.of("default", "slim")) {
            PlayerRenderer renderer = event.getSkin(Model.byName(skin));
            if (renderer != null) {
                renderer.addLayer(new OrnithopterGliderLayer<>(renderer, event.getEntityModels()));
            }
        }
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(
                OrnithopterGliderModel.LAYER_LOCATION,
                OrnithopterGliderModel::createBodyLayer
        );
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ModItems.ORNITHOPTER_ITEMS.forEach((color, item) -> {
                CuriosRendererRegistry.register(
                        item.get(),
                        () -> new OrnithopterGliderCurioRenderer(Minecraft.getInstance().getEntityModels())
                );
            });
        });

    }

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KeyBinding.BOOST_KEY);
    }
}