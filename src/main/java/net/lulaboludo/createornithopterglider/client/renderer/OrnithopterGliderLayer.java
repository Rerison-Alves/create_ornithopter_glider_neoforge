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
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class OrnithopterGliderLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {

    private final OrnithopterGliderModel<T> model;

    public OrnithopterGliderLayer(RenderLayerParent<T, M> parent, EntityModelSet models) {
        super(parent);
        this.model = new OrnithopterGliderModel<>(models.bakeLayer(OrnithopterGliderModel.LAYER_LOCATION));
    }

    @Override
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int light, T entity,
                       float limbSwing, float limbSwingAmount, float partialTicks,
                       float ageInTicks, float netHeadYaw, float headPitch) {

        ItemStack stack = entity.getItemBySlot(EquipmentSlot.CHEST);

        if (!entity.isInvisible() && stack.getItem() instanceof OrnithopterGliderItem gliderItem) {
            poseStack.pushPose();

            poseStack.translate(0.0D, 0.0D, 0.125D);

            ResourceLocation texture = gliderItem.getEntityTexture();

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(texture));

            this.getParentModel().copyPropertiesTo(this.model);
            this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

            this.model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

            poseStack.popPose();
        }
    }
}
