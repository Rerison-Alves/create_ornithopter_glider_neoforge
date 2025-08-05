package net.lulaboludo.createornithopterglider.item.custom;

import net.lulaboludo.createornithopterglider.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import javax.annotation.Nonnull;

public class OrnithopterGliderItem extends ElytraItem implements ICurioItem {

    public OrnithopterGliderItem(Properties properties) {
        super(properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot(@NotNull ItemStack stack) {
        return EquipmentSlot.CHEST;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        int ticks = livingEntity.getFallFlyingTicks();
        if (ticks > 0 && livingEntity.isFallFlying()) {
            stack.elytraFlightTick(livingEntity, ticks);
        }
    }

    @Override
    public boolean isValidRepairItem(@Nonnull ItemStack toRepair, ItemStack repairCandidate) {
        // Verifica se está reparando com a wing mesh correspondente
        if (repairCandidate.getItem() instanceof Item) {
            Item expectedWingMesh = getCorrespondingWingMesh(toRepair.getItem());
            return repairCandidate.is(expectedWingMesh);
        }
        return false;
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
        var maybeCurios = CuriosApi.getCuriosInventory(player);
        if (maybeCurios.isPresent()) {
            ICuriosItemHandler handler = maybeCurios.get();
            return handler.isEquipped(stack -> stack.getItem() instanceof OrnithopterGliderItem);
        }

        return false;
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
