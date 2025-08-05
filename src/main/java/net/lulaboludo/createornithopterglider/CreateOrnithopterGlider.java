package net.lulaboludo.createornithopterglider;

import net.lulaboludo.createornithopterglider.item.ModCreativeModTabs;
import net.lulaboludo.createornithopterglider.item.ModItems;
import net.lulaboludo.createornithopterglider.sounds.ModSounds;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(CreateOrnithopterGlider.MOD_ID)
public class CreateOrnithopterGlider {
    public static final String MOD_ID = "createornithopterglider";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateOrnithopterGlider(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
