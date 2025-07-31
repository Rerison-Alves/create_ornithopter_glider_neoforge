package net.lulaboludo.createornithopterglider.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lulaboludo.createornithopterglider.client.model.OrnithopterGliderModel;
import net.lulaboludo.createornithopterglider.item.custom.OrnithopterGliderItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class OrnithopterGliderCurioRenderer implements ICurioRenderer {

    private final OrnithopterGliderModel<LivingEntity> model;

    public OrnithopterGliderCurioRenderer(EntityModelSet modelSet) {
        this.model = new OrnithopterGliderModel<>(modelSet.bakeLayer(OrnithopterGliderModel.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
            PoseStack poseStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource buffer,
            int light,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch) {

        LivingEntity entity = slotContext.entity();

        if (!entity.isInvisible() && stack.getItem() instanceof OrnithopterGliderItem gliderItem) {
            poseStack.pushPose();
            poseStack.translate(0.0D, 0.0D, 0.125D);

            ResourceLocation texture = gliderItem.getEntityTexture(stack);

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(texture));

            this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1);

            poseStack.popPose();
        }
    }
}