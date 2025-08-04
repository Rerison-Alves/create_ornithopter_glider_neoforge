package net.lulaboludo.createornithopterglider.networking.payloads;

import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static net.lulaboludo.createornithopterglider.CreateOrnithopterGlider.MOD_ID;

public record BoostGliderPayload(int force) implements CustomPacketPayload {

    public static final Type<BoostGliderPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "boost_glider"));

    public static final StreamCodec<FriendlyByteBuf, BoostGliderPayload> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, BoostGliderPayload::force,
                    BoostGliderPayload::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Handler executado no servidor quando o payload chega
    public static void handle(final BoostGliderPayload data, final IPayloadContext context) {
        context.enqueueWork(() -> {
            var player = context.player();

            // Aplica impulso proporcional à força (0.0–1.0)
            float strength = Math.min(data.force(), 40) / 40f;
            float boostPower = 0.2f + strength * 1.8f;

            // Delay de 400ms antes de aplicar o movimento
            requireNonNull(player.level().getServer()).execute(() -> {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                var look = player.getLookAngle();
                player.addDeltaMovement(new Vec3(
                        look.x * boostPower,
                        look.y * boostPower + 0.2,
                        look.z * boostPower
                ));
                player.hurtMarked = true;
            });
        });
    }
}
