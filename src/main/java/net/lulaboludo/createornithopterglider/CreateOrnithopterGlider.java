package net.lulaboludo.createornithopterglider;

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

//        ModCreativeModTabs.register(modEventBus);
//        ModItems.register(modEventBus);
//        ModSounds.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        // modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
