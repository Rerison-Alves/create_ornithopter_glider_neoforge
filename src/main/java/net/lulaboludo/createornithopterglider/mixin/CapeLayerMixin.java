package net.lulaboludo.createornithopterglider.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lulaboludo.createornithopterglider.integration.curios.CuriosCompat;
import net.lulaboludo.createornithopterglider.item.custom.OrnithopterGliderItem;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CapeLayer.class)
public class CapeLayerMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void hideCapeIfGlider(
            PoseStack poseStack,
            MultiBufferSource buffer,
            int light,
            AbstractClientPlayer player,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch,
            CallbackInfo ci) {

        if (
            player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof OrnithopterGliderItem ||
            CuriosCompat.getInstance().hasOrnithopter(player))
        {
            ci.cancel();
        }
    }
}
