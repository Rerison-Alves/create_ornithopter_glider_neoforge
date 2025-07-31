package net.lulaboludo.createornithopterglider.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_ORNITOPTHER = "key.category.createornithopterglider.ornithopter";
    public static final String KEY_BOOST_GLIDER = "key.createornithopterglider.boost_glider";

    public static final KeyMapping BOOST_KEY = new KeyMapping(KEY_BOOST_GLIDER, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_SPACE, KEY_CATEGORY_ORNITOPTHER);
}
