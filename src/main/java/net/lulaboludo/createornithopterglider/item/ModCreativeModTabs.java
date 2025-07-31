package net.lulaboludo.createornithopterglider.item;

import net.lulaboludo.createornithopterglider.CreateOrnithopterGlider;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateOrnithopterGlider.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATEORNITHOPTERGLIDER_TAB =
            CREATIVE_MODE_TABS.register("createornithopterglider_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.ORNITHOPTER_ITEMS.get(DyeColor.WHITE).get()))
                            .title(Component.translatable("creativetab.createornithopterglider_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                for (DyeColor color : DyeColor.values()) {
                                    pOutput.accept(ModItems.ORNITHOPTER_ITEMS.get(color).get());
                                }
                                for (DyeColor color : DyeColor.values()) {
                                    pOutput.accept(ModItems.WING_MESHES.get(color).get());
                                }
                                pOutput.accept(ModItems.ELYTRA_PIECE.get());
                                pOutput.accept(ModItems.ROPE.get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
