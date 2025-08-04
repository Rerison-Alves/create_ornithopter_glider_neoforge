package net.lulaboludo.createornithopterglider.datagen;

import net.lulaboludo.createornithopterglider.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.lulaboludo.createornithopterglider.CreateOrnithopterGlider.MOD_ID;
import static net.minecraft.tags.ItemTags.DURABILITY_ENCHANTABLE;
import static net.minecraft.tags.ItemTags.EQUIPPABLE_ENCHANTABLE;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        for (DyeColor color : DyeColor.values()) {
            tag(EQUIPPABLE_ENCHANTABLE)
                    .add(ModItems.ORNITHOPTER_ITEMS.get(color).get());
            tag(DURABILITY_ENCHANTABLE)
                    .add(ModItems.ORNITHOPTER_ITEMS.get(color).get());
        }
    }
}