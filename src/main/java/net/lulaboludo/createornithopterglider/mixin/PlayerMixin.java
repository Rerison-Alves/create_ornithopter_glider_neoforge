package net.lulaboludo.createornithopterglider.mixin;

import net.lulaboludo.createornithopterglider.integration.curios.CuriosCompat;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(
            method = "tryToStartFallFlying",
            at = @At("HEAD"),
            cancellable = true
    )
    private void createornithopter$tryToStartFallFlying(CallbackInfoReturnable<Boolean> cir) {

        Player player = (Player)(Object)this;

        if (!CuriosCompat.getInstance().hasOrnithopter(player)) {
            return;
        }

        if (player.onGround()
                || player.isFallFlying()
                || player.isInWater()
                || player.hasEffect(MobEffects.LEVITATION)) {
            cir.setReturnValue(false);
            return;
        }

        player.startFallFlying();
        cir.setReturnValue(true);
    }
}
