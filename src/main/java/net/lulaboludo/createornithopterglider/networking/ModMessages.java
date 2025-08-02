package net.lulaboludo.createornithopterglider.networking;

import net.lulaboludo.createornithopterglider.networking.payloads.BoostGliderPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import static net.lulaboludo.createornithopterglider.CreateOrnithopterGlider.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class ModMessages {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1.0");

        registrar.playToServer(
            BoostGliderPayload.TYPE,
            BoostGliderPayload.STREAM_CODEC,
            BoostGliderPayload::handle
        );
    }

    public static void sendToServer(BoostGliderPayload payload) {
        PacketDistributor.sendToServer(payload);
    }

    public static void sendToPlayer(BoostGliderPayload payload, net.minecraft.server.level.ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, payload);
    }
}
