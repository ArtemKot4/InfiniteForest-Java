package com.artemkot4.infinite_forest;

import com.zhekasmirnov.apparatus.modloader.LegacyInnerCoreMod;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;
import ru.koshakmine.icstd.utils.TranslationLoader;

public class InfiniteForest extends Mod {
    public static String WINDOWS;

    public InfiniteForest(String dir, LegacyInnerCoreMod mod) {
        super(dir, mod);

        WINDOWS = dir + "windows/";
    }

    @Override
    public void runMod(ObjectFactory objectFactory) {
        TranslationLoader.loadTranslation(getDir()+"lang", "en");
        AllBlocks.init();
    }
}
