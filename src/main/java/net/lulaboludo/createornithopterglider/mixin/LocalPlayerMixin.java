package net.lulaboludo.createornithopterglider.mixin;

import net.lulaboludo.createornithopterglider.util.HasOrnithopterInCurios;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {

    @Redirect(
            method = "aiStep",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;canElytraFly(Lnet/minecraft/world/entity/LivingEntity;)Z"
            )
    )
    private boolean createornithopter$canElytraFly(ItemStack stack, LivingEntity entity) {
        if (entity instanceof Player player) {
            if (HasOrnithopterInCurios.verify(player)) {
                return true;
            }
        }
        return stack.canElytraFly(entity);
    }
}
