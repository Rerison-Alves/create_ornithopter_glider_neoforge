package net.lulaboludo.createornithopterglider.integration.curios;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CuriosNotLoaded implements CuriosHelper {
    @Override
    public void registerRenderers() {}

    @Override
    public boolean hasOrnithopter(Player player) {
        return false;
    }

    @Override
    public ItemStack getOrnithopter(Player player) {
        return null;
    }
}
