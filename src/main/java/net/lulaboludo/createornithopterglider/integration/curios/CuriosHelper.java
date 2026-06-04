package net.lulaboludo.createornithopterglider.integration.curios;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface CuriosHelper {
    void registerRenderers();

    boolean hasOrnithopter(Player player);

    ItemStack getOrnithopter(Player player);
}
