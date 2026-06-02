package net.lulaboludo.createornithopterglider.mixin;

import net.lulaboludo.createornithopterglider.util.HasOrnithopterInCurios;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Redirect(
            method = "updateFallFlying",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;canElytraFly(Lnet/minecraft/world/entity/LivingEntity;)Z"
            )
    )
    private boolean createornithopterglider$canElytraFly(ItemStack stack, LivingEntity entity) {
        if (entity instanceof Player player) {
            if (HasOrnithopterInCurios.verify(player)) {
                return true;
            }
        }
        return stack.canElytraFly(entity);
    }

    @Redirect(
            method = "updateFallFlying",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;elytraFlightTick(Lnet/minecraft/world/entity/LivingEntity;I)Z"
            )
    )
    private boolean createornithopterglider$elytraFlightTick(
            ItemStack stack,
            LivingEntity entity,
            int flightTicks) {
        if (entity instanceof Player player) {
            if (HasOrnithopterInCurios.verify(player)) {
                return true;
            }
        }

        return stack.elytraFlightTick(entity, flightTicks);
    }
}
