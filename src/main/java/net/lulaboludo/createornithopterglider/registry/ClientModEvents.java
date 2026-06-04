package net.lulaboludo.createornithopterglider.registry;

import net.lulaboludo.createornithopterglider.client.model.OrnithopterGliderModel;
import net.lulaboludo.createornithopterglider.client.renderer.OrnithopterGliderLayer;
import net.lulaboludo.createornithopterglider.integration.curios.CuriosCompat;
import net.lulaboludo.createornithopterglider.util.KeyBinding;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin.Model;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

import java.util.List;

import static net.lulaboludo.createornithopterglider.CreateOrnithopterGlider.MOD_ID;

@EventBusSubscriber(
        modid = MOD_ID,
        value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        LayerRegister.registerPlayerLayers(event);
        LayerRegister.registerArmorStandLayer(event);
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
            if (ModList.get().isLoaded("curios")) {
                CuriosCompat.getInstance().registerRenderers();
            }
        });
    }

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KeyBinding.BOOST_KEY);
    }
}
