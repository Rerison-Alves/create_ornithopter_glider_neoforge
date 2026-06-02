package net.lulaboludo.createornithopterglider.util;

import net.lulaboludo.createornithopterglider.item.custom.OrnithopterGliderItem;
import net.minecraft.world.entity.player.Player;
import top.theillusivec4.curios.api.CuriosApi;

public class HasOrnithopterInCurios {
     public static boolean verify(Player player) {
        return CuriosApi.getCuriosInventory(player)
                .map(inv -> inv.isEquipped(
                        s -> s.getItem() instanceof OrnithopterGliderItem))
                .orElse(false);
    }
}
