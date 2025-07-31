package net.lulaboludo.createornithopterglider.client.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;

public class FlapAnimationManager {
    private static final Map<Player, AnimationData> animationMap = new HashMap<>();

    public static void playAnimation(Player player, AnimationDefinition animation) {
        animationMap.put(player, new AnimationData(animation, System.currentTimeMillis()));
    }

    public static AnimationDefinition getAnimation(Player player) {
        AnimationData data = animationMap.get(player);
        if (data == null) return null;

        long elapsed = System.currentTimeMillis() - data.startTime;
        if (elapsed < data.animation.lengthInSeconds() * 1000) {
            return data.animation;
        } else {
            animationMap.remove(player);
            return null;
        }
    }

    public static long getElapsedTicks(Player player) {
        AnimationData data = animationMap.get(player);
        if (data == null) return 0;

        long elapsedMillis = System.currentTimeMillis() - data.startTime;
        return (elapsedMillis * 20) / 1000; // converte ms para ticks
    }

    private static class AnimationData {
        AnimationDefinition animation;
        long startTime;

        public AnimationData(AnimationDefinition animation, long startTime) {
            this.animation = animation;
            this.startTime = startTime;
        }
    }
}