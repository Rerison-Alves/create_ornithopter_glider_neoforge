package net.lulaboludo.createornithopterglider.integration.curios;

import net.neoforged.fml.ModList;

public class CuriosCompat {

    private static final CuriosHelper INSTANCE;

    public static CuriosHelper getInstance(){
        return INSTANCE;
    }

    static {
        if (ModList.get().isLoaded("curios")) {
            INSTANCE = new CuriosLoaded();
        } else {
            INSTANCE = new CuriosNotLoaded();
        }
    }
}
