package net.lulaboludo.createornithopterglider.client.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;

import static net.minecraft.client.animation.AnimationChannel.Interpolations.LINEAR;
import static net.minecraft.client.animation.AnimationChannel.Targets.*;
import static net.minecraft.client.animation.KeyframeAnimations.*;

public class OrnithoptergGliderAnimation {
	public static final AnimationDefinition OG_DEFAULT = AnimationDefinition.Builder.withLength(11.0F).looping()
			.addAnimation("all", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-90.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 15.0F, -8.0F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.8F, 0.8F, 0.8F), LINEAR)
			))
			.addAnimation("spine", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(10.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("spine", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, 0.0F), LINEAR)
			))
			.addAnimation("rope1", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("rope2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, -75.0F, 0.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(5.0F, -4.7F, 3.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.25F, 0.25F, 0.25F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 75.0F, 0.0F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(-5.0F, -4.7F, 3.0F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.25F, 0.25F, 0.25F), LINEAR)
			))
			.addAnimation("backwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-15.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("backwing", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, -6.0F), LINEAR)
			))
			.addAnimation("backwing", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.4F, 0.4F, 0.4F), LINEAR)
			))
			.addAnimation("column2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(90.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("column2", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 23.7F, -15.6F), LINEAR)
			))
			.addAnimation("column2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 1.0F, 1.0F), LINEAR)
			))
			.addAnimation("support", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 12.0F, -8.6F), LINEAR)
			))
			.addAnimation("support", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.45F, 0.45F, 0.45F), LINEAR)
			))
			.addAnimation("column1", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(90.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("column1", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.8F, 2.0F), LINEAR)
			))
			.addAnimation("column1", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.8F, 0.8F, 0.8F), LINEAR)
			))
			.addAnimation("uperspine", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-10.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("uperspine", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, -3.2F, 5.7F), LINEAR)
			))
			.addAnimation("uperspine", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.7F, 0.7F, 0.7F), LINEAR)
			))
			.addAnimation("gear", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, -0.6F, 0.0F), LINEAR)
			))
			.addAnimation("gear", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.3F, 0.6F, 0.3F), LINEAR)
			))
			.addAnimation("rope3", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("rope4", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, 0.0F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 0.6F, 1.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, 0.0F), LINEAR),
					new Keyframe(11.0F, degreeVec(0.0F, 360.0F, 0.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.5F, 0.6F, 0.5F), LINEAR)
			))
			.addAnimation("backspine", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 2.0F, -9.0F), LINEAR)
			))
			.addAnimation("backspine", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.8F, 0.8F, 0.8F), LINEAR)
			))
			.addAnimation("leftwingsup", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("rightwingsup", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.build();

	public static final AnimationDefinition OG_DEFAULT_SHIFITING = AnimationDefinition.Builder.withLength(11.0F).looping()
			.addAnimation("all", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-65.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 10.0F, -3.5F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.8F, 0.8F, 0.8F), LINEAR)
			))
			.addAnimation("spine", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(10.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("spine", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, 0.0F), LINEAR)
			))
			.addAnimation("rope1", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("rope2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, -45.0F, 0.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(3.0F, -4.7F, 4.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.25F, 0.25F, 0.25F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 45.0F, 0.0F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(-3.0F, -4.7F, 4.0F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.25F, 0.25F, 0.25F), LINEAR)
			))
			.addAnimation("backwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-15.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("backwing", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, -6.0F), LINEAR)
			))
			.addAnimation("backwing", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.4F, 0.4F, 0.4F), LINEAR)
			))
			.addAnimation("column2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(90.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("column2", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 23.7F, -15.6F), LINEAR)
			))
			.addAnimation("column2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 1.0F, 1.0F), LINEAR)
			))
			.addAnimation("support", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 12.0F, -8.6F), LINEAR)
			))
			.addAnimation("support", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.45F, 0.45F, 0.45F), LINEAR)
			))
			.addAnimation("column1", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(90.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("column1", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.8F, 2.0F), LINEAR)
			))
			.addAnimation("column1", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.8F, 0.8F, 0.8F), LINEAR)
			))
			.addAnimation("uperspine", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-10.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("uperspine", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, -3.2F, 5.7F), LINEAR)
			))
			.addAnimation("uperspine", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.7F, 0.7F, 0.7F), LINEAR)
			))
			.addAnimation("gear", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, -0.6F, 0.0F), LINEAR)
			))
			.addAnimation("gear", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.3F, 0.6F, 0.3F), LINEAR)
			))
			.addAnimation("rope3", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("rope4", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, 0.0F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 0.6F, 1.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, 0.0F), LINEAR),
					new Keyframe(11.0F, degreeVec(0.0F, 360.0F, 0.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.5F, 0.6F, 0.5F), LINEAR)
			))
			.addAnimation("backspine", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 2.0F, -9.0F), LINEAR)
			))
			.addAnimation("backspine", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.8F, 0.8F, 0.8F), LINEAR)
			))
			.addAnimation("leftwingsup", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("rightwingsup", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.0F, 0.0F, 0.0F), LINEAR)
			))
			.build();

	public static final AnimationDefinition OG_GLIDING = AnimationDefinition.Builder.withLength(11.0F).looping()
			.addAnimation("all", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-90.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 8.0F, -7.0F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.1F, 1.1F, 1.1F), LINEAR)
			))
			.addAnimation("rope1", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, 2.5F), LINEAR),
					new Keyframe(5.4583F, degreeVec(0.0F, 0.0F, -0.18F), LINEAR),
					new Keyframe(11.0F, degreeVec(0.0F, 0.0F, 2.0F), LINEAR)
			))
			.addAnimation("rope1", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 0.9F, 1.0F), LINEAR),
					new Keyframe(5.4583F, scaleVec(1.0F, 1.0264F, 1.0F), LINEAR),
					new Keyframe(11.0F, scaleVec(1.0F, 0.9F, 1.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, -7.0F), LINEAR),
					new Keyframe(5.4583F, degreeVec(3.33F, 0.0F, 2.11F), LINEAR),
					new Keyframe(11.0F, degreeVec(0.0F, 0.0F, -7.0F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, 7.0F), LINEAR),
					new Keyframe(5.4583F, degreeVec(3.33F, 0.0F, -2.11F), LINEAR),
					new Keyframe(11.0F, degreeVec(0.0F, 0.0F, 7.0F), LINEAR)
			))
			.addAnimation("rope2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, -2.5F), LINEAR),
					new Keyframe(5.4583F, degreeVec(0.0F, 0.0F, 2.42F), LINEAR),
					new Keyframe(11.0F, degreeVec(0.0F, 0.0F, -2.0F), LINEAR)
			))
			.addAnimation("rope2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 0.9F, 1.0F), LINEAR),
					new Keyframe(5.4583F, scaleVec(1.0F, 1.0188F, 1.0F), LINEAR),
					new Keyframe(11.0F, scaleVec(1.0F, 0.9F, 1.0F), LINEAR)
			))
			.addAnimation("gear", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.3F, 0.6F, 0.3F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, 0.0F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 0.6F, 1.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, 0.0F), LINEAR),
					new Keyframe(11.0F, degreeVec(0.0F, 360.0F, 0.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.5F, 0.6F, 0.5F), LINEAR)
			))
			.build();

	public static final AnimationDefinition OG_GLIDING_FLAP = AnimationDefinition.Builder.withLength(0.8333F).looping()
			.addAnimation("all", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(-90.0F, 0.0F, 0.0F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 8.0F, -7.0F), LINEAR)
			))
			.addAnimation("all", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.1F, 1.1F, 1.1F), LINEAR)
			))
			.addAnimation("rope1", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, -0.02F), LINEAR),
					new Keyframe(0.25F, degreeVec(0.0F, 0.0F, 5.1F), LINEAR),
					new Keyframe(0.375F, degreeVec(0.0F, 0.0F, 5.0F), LINEAR),
					new Keyframe(0.5F, degreeVec(0.0F, 0.0F, 4.9F), LINEAR),
					new Keyframe(0.75F, degreeVec(0.0F, 0.0F, -2.8F), LINEAR),
					new Keyframe(0.8333F, degreeVec(0.0F, 0.0F, -0.18F), LINEAR)
			))
			.addAnimation("rope1", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 1.0F, 1.0F), LINEAR),
					new Keyframe(0.25F, scaleVec(1.0F, 0.5939F, 1.0F), LINEAR),
					new Keyframe(0.375F, scaleVec(1.0F, 0.5038F, 1.0F), LINEAR),
					new Keyframe(0.5F, scaleVec(1.0F, 0.717F, 1.0F), LINEAR),
					new Keyframe(0.75F, scaleVec(1.0F, 1.0296F, 1.0F), LINEAR),
					new Keyframe(0.8333F, scaleVec(1.0F, 1.0264F, 1.0F), LINEAR)
			))
			.addAnimation("leftwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(3.33F, 0.0F, 2.11F), LINEAR),
					new Keyframe(0.25F, degreeVec(-30.0F, 0.0F, -24.85F), LINEAR),
					new Keyframe(0.375F, degreeVec(-30.0F, 0.0F, -32.5F), LINEAR),
					new Keyframe(0.5F, degreeVec(10.0F, 0.0F, -19.17F), LINEAR),
					new Keyframe(0.75F, degreeVec(10.0F, 0.0F, 7.5F), LINEAR),
					new Keyframe(0.8333F, degreeVec(3.33F, 0.0F, 2.11F), LINEAR)
			))
			.addAnimation("rightwing", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(3.33F, 0.0F, -2.11F), LINEAR),
					new Keyframe(0.25F, degreeVec(-30.0F, 0.0F, 24.85F), LINEAR),
					new Keyframe(0.375F, degreeVec(-30.0F, 0.0F, 32.5F), LINEAR),
					new Keyframe(0.5F, degreeVec(10.0F, 0.0F, 19.17F), LINEAR),
					new Keyframe(0.75F, degreeVec(10.0F, 0.0F, -7.5F), LINEAR),
					new Keyframe(0.8333F, degreeVec(3.33F, 0.0F, -2.11F), LINEAR)
			))
			.addAnimation("rope2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, -0.22F), LINEAR),
					new Keyframe(0.25F, degreeVec(0.0F, 0.0F, -5.33F), LINEAR),
					new Keyframe(0.375F, degreeVec(0.0F, 0.0F, -5.22F), LINEAR),
					new Keyframe(0.5F, degreeVec(0.0F, 0.0F, -5.11F), LINEAR),
					new Keyframe(0.75F, degreeVec(0.0F, 0.0F, 5.1F), LINEAR),
					new Keyframe(0.8333F, degreeVec(0.0F, 0.0F, 2.42F), LINEAR)
			))
			.addAnimation("rope2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 0.9904F, 1.0F), LINEAR),
					new Keyframe(0.25F, scaleVec(1.0F, 0.5849F, 1.0F), LINEAR),
					new Keyframe(0.375F, scaleVec(1.0F, 0.4951F, 1.0F), LINEAR),
					new Keyframe(0.5F, scaleVec(1.0F, 0.7086F, 1.0F), LINEAR),
					new Keyframe(0.75F, scaleVec(1.0F, 1.0218F, 1.0F), LINEAR),
					new Keyframe(0.8333F, scaleVec(1.0F, 1.0188F, 1.0F), LINEAR)
			))
			.addAnimation("gear", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.3F, 0.6F, 0.3F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(POSITION,
					new Keyframe(0.0F, posVec(0.0F, 1.0F, 0.0F), LINEAR)
			))
			.addAnimation("axis", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(1.0F, 0.6F, 1.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(ROTATION,
					new Keyframe(0.0F, degreeVec(0.0F, 0.0F, 0.0F), LINEAR),
					new Keyframe(0.8333F, degreeVec(0.0F, 28.0F, 0.0F), LINEAR)
			))
			.addAnimation("gear2", new AnimationChannel(SCALE,
					new Keyframe(0.0F, scaleVec(0.5F, 0.6F, 0.5F), LINEAR)
			))
			.build();
}