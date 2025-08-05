package net.lulaboludo.createornithopterglider.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lulaboludo.createornithopterglider.client.animations.FlapAnimationManager;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import static net.lulaboludo.createornithopterglider.client.animations.OrnithoptergGliderAnimation.*;

public class OrnithopterGliderModel<T extends Entity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("createornithopterglider", "ornithopterglider"), "main");

	private final Vector3f vecCache = new Vector3f();

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart all;
	private final ModelPart frame;
	private final ModelPart support;
	private final ModelPart column1;
	private final ModelPart column2;
	private final ModelPart spine;
	private final ModelPart backspine;
	private final ModelPart backwing;
	private final ModelPart gear2;
	private final ModelPart uperspine;
	private final ModelPart gear;
	private final ModelPart axis;
	private final ModelPart rope1;
	private final ModelPart rope2;
	private final ModelPart rope3;
	private final ModelPart rope4;
	private final ModelPart leftwing;
	private final ModelPart leftwingsup;
	private final ModelPart rightwing;
	private final ModelPart rightwingsup;

	public OrnithopterGliderModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.all = this.body.getChild("all");
		this.frame = this.all.getChild("frame");
		this.support = this.frame.getChild("support");
		this.column1 = this.frame.getChild("column1");
		this.column2 = this.frame.getChild("column2");
		this.spine = this.frame.getChild("spine");
		this.backspine = this.spine.getChild("backspine");
		this.backwing = this.backspine.getChild("backwing");
		this.gear2 = this.spine.getChild("gear2");
		this.uperspine = this.spine.getChild("uperspine");
		this.gear = this.uperspine.getChild("gear");
		this.axis = this.gear.getChild("axis");
		this.rope1 = this.frame.getChild("rope1");
		this.rope2 = this.frame.getChild("rope2");
		this.rope3 = this.frame.getChild("rope3");
		this.rope4 = this.frame.getChild("rope4");
		this.leftwing = this.frame.getChild("leftwing");
		this.leftwingsup = this.leftwing.getChild("leftwingsup");
		this.rightwing = this.frame.getChild("rightwing");
		this.rightwingsup = this.rightwing.getChild("rightwingsup");
	}

	@Override
	public ModelPart root() {
		return root;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition all = body.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -2.0F));

		PartDefinition frame = all.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, 16.0F));

		PartDefinition support = frame.addOrReplaceChild("support", CubeListBuilder.create().texOffs(0, 36).addBox(7.0F, 1.0F, -32.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 51).addBox(-8.0F, 1.0F, -33.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(38, 52).addBox(-9.0F, 1.0F, -32.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(36, 31).addBox(-5.0F, 0.0F, -29.0F, 10.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -3.0F));

		PartDefinition frame_r1 = support.addOrReplaceChild("frame_r1", CubeListBuilder.create().texOffs(56, 52).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 2.0F, -19.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition frame_r2 = support.addOrReplaceChild("frame_r2", CubeListBuilder.create().texOffs(72, 52).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 2.0F, -19.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition column1 = frame.addOrReplaceChild("column1", CubeListBuilder.create().texOffs(74, 43).addBox(-6.9782F, 9.3127F, -2.4568F, 14.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 60).addBox(-2.9782F, -4.3873F, -2.4568F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(93, 27).addBox(7.0218F, -0.6873F, -2.4568F, 1.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(105, 27).addBox(-7.9782F, -0.6873F, -2.4568F, 1.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0218F, 2.1376F, -27.375F));

		PartDefinition frame_r3 = column1.addOrReplaceChild("frame_r3", CubeListBuilder.create().texOffs(0, 25).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9218F, -3.0197F, -0.1727F, 0.0F, 0.0F, 0.7854F));

		PartDefinition frame_r4 = column1.addOrReplaceChild("frame_r4", CubeListBuilder.create().texOffs(0, 23).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0782F, -3.0197F, -0.1727F, 0.0F, 0.0F, -0.7854F));

		PartDefinition frame_r5 = column1.addOrReplaceChild("frame_r5", CubeListBuilder.create().texOffs(88, 52).addBox(-0.5F, -1.6F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6371F, -3.1533F, -1.4568F, 0.0F, 0.0F, 1.1781F));

		PartDefinition frame_r6 = column1.addOrReplaceChild("frame_r6", CubeListBuilder.create().texOffs(95, 49).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7782F, 1.2127F, -1.4568F, 0.0F, 0.0F, 0.6545F));

		PartDefinition frame_r7 = column1.addOrReplaceChild("frame_r7", CubeListBuilder.create().texOffs(81, 32).addBox(-0.5F, -1.6F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6629F, -3.1533F, -1.4568F, 0.0F, 0.0F, -1.1781F));

		PartDefinition frame_r8 = column1.addOrReplaceChild("frame_r8", CubeListBuilder.create().texOffs(74, 35).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.8218F, 1.2127F, -1.4568F, 0.0F, 0.0F, -0.6545F));

		PartDefinition column2 = frame.addOrReplaceChild("column2", CubeListBuilder.create().texOffs(0, 55).addBox(-5.5F, -7.0F, -14.0F, 11.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -3.0F));

		PartDefinition spine = frame.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.0F, -20.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition spine_r1 = spine.addOrReplaceChild("spine_r1", CubeListBuilder.create().texOffs(70, 67).addBox(-2.0F, -1.5F, -4.5F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(70, 80).addBox(6.0F, -1.5F, -4.5F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -0.7235F, -0.3978F, 0.0873F, 0.0F, 0.0F));

		PartDefinition backspine = spine.addOrReplaceChild("backspine", CubeListBuilder.create().texOffs(4, 6).addBox(-1.0F, -10.2235F, -7.8978F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(26, 56).addBox(-2.0F, -10.2235F, -13.8978F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 17.0F));

		PartDefinition backwing = backspine.addOrReplaceChild("backwing", CubeListBuilder.create().texOffs(0, 31).addBox(-9.0F, -7.0F, -9.0F, 18.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 4.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition gear2 = spine.addOrReplaceChild("gear2", CubeListBuilder.create().texOffs(24, 67).addBox(-8.9286F, -1.5F, -1.3276F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 81).addBox(-5.9286F, -1.45F, -5.8276F, 12.0F, 2.9F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 69).addBox(-3.9286F, -2.0F, -3.8276F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0714F, 0.4F, -0.7724F, 3.1416F, 1.4835F, 1.5708F));

		PartDefinition Gear4_r1 = gear2.addOrReplaceChild("Gear4_r1", CubeListBuilder.create().texOffs(24, 67).addBox(-9.0F, -1.5F, -1.5F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 0.0F, 0.1724F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Gear3_r1 = gear2.addOrReplaceChild("Gear3_r1", CubeListBuilder.create().texOffs(24, 67).addBox(-9.0F, -1.5F, -1.5F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 0.0F, 0.1724F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Gear2_r1 = gear2.addOrReplaceChild("Gear2_r1", CubeListBuilder.create().texOffs(24, 67).addBox(-9.0F, -1.5F, -1.5F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 0.0F, 0.1724F, 0.0F, -0.7854F, 0.0F));

		PartDefinition uperspine = spine.addOrReplaceChild("uperspine", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.75F, -0.1F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.6824F, -11.1159F, 0.2618F, 0.0F, 0.0F));

		PartDefinition gear = uperspine.addOrReplaceChild("gear", CubeListBuilder.create().texOffs(24, 67).addBox(-8.9286F, -1.5F, -1.3276F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 81).addBox(-5.9286F, -1.45F, -5.8276F, 12.0F, 2.9F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 69).addBox(-3.9286F, -2.0F, -3.8276F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0714F, -0.3176F, -1.0566F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Gear4_r2 = gear.addOrReplaceChild("Gear4_r2", CubeListBuilder.create().texOffs(24, 67).addBox(-9.0F, -1.5F, -1.5F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 0.0F, 0.1724F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Gear3_r2 = gear.addOrReplaceChild("Gear3_r2", CubeListBuilder.create().texOffs(24, 67).addBox(-9.0F, -1.5F, -1.5F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 0.0F, 0.1724F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Gear2_r2 = gear.addOrReplaceChild("Gear2_r2", CubeListBuilder.create().texOffs(24, 67).addBox(-9.0F, -1.5F, -1.5F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0714F, 0.0F, 0.1724F, 0.0F, -0.7854F, 0.0F));

		PartDefinition axis = gear.addOrReplaceChild("axis", CubeListBuilder.create().texOffs(36, 73).addBox(-10.0F, -12.0F, 5.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0714F, 4.0F, -6.8276F));

		PartDefinition rope1 = frame.addOrReplaceChild("rope1", CubeListBuilder.create().texOffs(2, 5).addBox(0.0F, -17.0F, 0.0F, 0.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 11.6F, -32.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition rope2 = frame.addOrReplaceChild("rope2", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -17.0F, 0.0F, 0.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 11.6F, -31.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition rope3 = frame.addOrReplaceChild("rope3", CubeListBuilder.create().texOffs(2, 5).addBox(-0.95F, -6.0F, -8.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 12.6F, -23.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition rope4 = frame.addOrReplaceChild("rope4", CubeListBuilder.create().texOffs(2, 5).addBox(-0.95F, -6.0F, -9.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 12.6F, -23.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition leftwing = frame.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(-10, 0).addBox(16.0F, 0.0F, -2.0F, 56.0F, 0.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.4659F, -31.2588F));

		PartDefinition leftwingsup = leftwing.addOrReplaceChild("leftwingsup", CubeListBuilder.create().texOffs(0, 29).addBox(-32.9F, -0.5F, 1.0F, 30.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(17.9F, 0.0F, -1.0F));

		PartDefinition leftwing_r1 = leftwingsup.addOrReplaceChild("leftwing_r1", CubeListBuilder.create().texOffs(62, 29).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition leftwing_r2 = leftwingsup.addOrReplaceChild("leftwing_r2", CubeListBuilder.create().texOffs(78, 29).addBox(-5.0F, -0.5F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9F, 0.0F, -1.3F, 0.0F, -0.0436F, 0.0F));

		PartDefinition rightwing = frame.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(-10, 0).mirror().addBox(-72.0F, 0.0F, -3.0F, 56.0F, 0.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -4.4659F, -31.2588F));

		PartDefinition rightwingsup = rightwing.addOrReplaceChild("rightwingsup", CubeListBuilder.create().texOffs(0, 27).addBox(9.9F, -0.5F, 2.3F, 30.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.9F, 0.0F, -3.3F));

		PartDefinition rightwing_r1 = rightwingsup.addOrReplaceChild("rightwing_r1", CubeListBuilder.create().texOffs(78, 27).addBox(-4.5F, -0.5F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition rightwing_r2 = rightwingsup.addOrReplaceChild("rightwing_r2", CubeListBuilder.create().texOffs(62, 27).addBox(-3.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, 0.0F, 1.0F, -0.09F, -0.48F, 0.0089F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(@NotNull Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		AnimationDefinition anim = getAnimation(entity);
		long tickTime;
		if (
				entity instanceof Player player
				&& player.isFallFlying()
				&& anim == FlapAnimationManager.getAnimation(player)
		) {
			tickTime = FlapAnimationManager.getElapsedTicks(player);
		} else {
			tickTime = (long) ageInTicks;
		}
		KeyframeAnimations.animate(
				this,
				anim,
				tickTime * 40,
				1.0F,
				vecCache
		);

	}

	private AnimationDefinition getAnimation(Entity entity) {
		if (entity instanceof Player player) {
			if (player.isFallFlying()) {
				AnimationDefinition current = FlapAnimationManager.getAnimation(player);
				if (current != null)
					return current;
				return OG_GLIDING;
			}
			if (player.isCrouching())
				return OG_DEFAULT_SHIFITING;
		}
		return OG_DEFAULT;
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}