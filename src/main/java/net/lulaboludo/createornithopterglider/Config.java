package net.lulaboludo.createornithopterglider;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue COOLDOWN_TICKS = BUILDER
            .comment("Number of cooldown ticks after the glider flaps its wings.")
            .defineInRange("coolDownBoostTicks", 40, 20, 1200);

    static final ModConfigSpec SPEC = BUILDER.build();
}
