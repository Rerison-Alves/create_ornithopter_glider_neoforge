package net.lulaboludo.createornithopterglider.item.custom;

import net.lulaboludo.createornithopterglider.integration.curios.CuriosCompat;
import net.lulaboludo.createornithopterglider.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class OrnithopterGliderItem extends ElytraItem {

    public OrnithopterGliderItem(Properties properties) {
        super(properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot(@NotNull ItemStack stack) {
        return EquipmentSlot.CHEST;
    }

    @Override
    public boolean isValidRepairItem(@Nonnull ItemStack toRepair, ItemStack repairCandidate) {
        // Verifica se está reparando com a wing mesh correspondente
        Item expectedWingMesh = getCorrespondingWingMesh(toRepair.getItem());
        return repairCandidate.is(expectedWingMesh);
    }

    public ResourceLocation getEntityTexture() {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(this);
        return ResourceLocation.fromNamespaceAndPath("createornithopterglider", "textures/entity/" + id.getPath() + ".png");
    }

    public static boolean isFlying(Player player) {
        if (player == null) return false;

        if (!player.isFallFlying()) return false;

        // Verifica peitoral
        ItemStack chestStack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (chestStack.getItem() instanceof OrnithopterGliderItem) {
            return true;
        }

        // Verifica curios
        return CuriosCompat.getInstance().hasOrnithopter(player);
    }

    private Item getCorrespondingWingMesh(Item glider) {
        for (var entry : ModItems.ORNITHOPTER_ITEMS.entrySet()) {
            if (entry.getValue().get() == glider) {
                DyeColor color = entry.getKey();
                return ModItems.WING_MESHES.get(color).get();
            }
        }
        throw new IllegalArgumentException("Glider não corresponde a nenhuma wing mesh conhecida: " + glider);
    }
}
