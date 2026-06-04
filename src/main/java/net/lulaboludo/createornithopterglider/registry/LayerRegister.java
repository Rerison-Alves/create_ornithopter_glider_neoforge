package net.lulaboludo.createornithopterglider.registry;

import net.lulaboludo.createornithopterglider.client.renderer.OrnithopterGliderLayer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.List;

public class LayerRegister {

    public static void registerPlayerLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : List.of("default", "slim")) {
            PlayerRenderer renderer = event.getSkin(PlayerSkin.Model.byName(skin));
            if (renderer != null) {
                renderer.addLayer(new OrnithopterGliderLayer<>(renderer, event.getEntityModels()));
            }
        }
    }

    public static void registerArmorStandLayer(EntityRenderersEvent.AddLayers event) {
        var renderer = event.getRenderer(EntityType.ARMOR_STAND);

        if (renderer instanceof ArmorStandRenderer standRenderer) {
            standRenderer.addLayer(new OrnithopterGliderLayer<>(standRenderer, event.getEntityModels()));
        }
    }
}
