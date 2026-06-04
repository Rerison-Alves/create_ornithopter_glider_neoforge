package net.lulaboludo.createornithopterglider.integration.curios;

import net.lulaboludo.createornithopterglider.client.renderer.OrnithopterGliderCurioRenderer;
import net.lulaboludo.createornithopterglider.item.ModItems;
import net.lulaboludo.createornithopterglider.item.custom.OrnithopterGliderItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class CuriosLoaded implements CuriosHelper {

    @Override
    public void registerRenderers() {
        ModItems.ORNITHOPTER_ITEMS.forEach((color, item) -> {
            CuriosRendererRegistry.register(
                    item.get(),
                    () -> new OrnithopterGliderCurioRenderer(
                            Minecraft.getInstance().getEntityModels()
                    )
            );
        });
    }

    @Override
    public boolean hasOrnithopter(Player player) {
        return !getOrnithopter(player).isEmpty();
    }

    @Override
    public ItemStack getOrnithopter(Player player) {

        return CuriosApi.getCuriosInventory(player)
                .flatMap(inv -> inv.findFirstCurio(
                        stack -> stack.getItem() instanceof OrnithopterGliderItem
                ))
                .map(SlotResult::stack)
                .orElse(ItemStack.EMPTY);
    }
}
