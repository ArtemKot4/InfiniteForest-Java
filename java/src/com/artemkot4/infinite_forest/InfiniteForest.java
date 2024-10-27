package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.dimension.Forest;
import com.artemkot4.infinite_forest.events.ForestTick;
import com.artemkot4.infinite_forest.events.LevelDisplayed;
import com.artemkot4.infinite_forest.events.ServerPlayerTick;
import com.zhekasmirnov.apparatus.modloader.LegacyInnerCoreMod;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;
import ru.koshakmine.icstd.utils.TranslationLoader;

public class InfiniteForest extends Mod {
    public static String WINDOWS;
    public static Mod INSTANCE;
    public static final String DIR = getInstance().getDir();

    public InfiniteForest(String dir, LegacyInnerCoreMod mod) {
        super(dir, mod);

        WINDOWS = dir + "windows/";
    }

    public static Mod getInstance() {
        return INSTANCE;
    };

    @Override
    public void runMod(ObjectFactory objectFactory) {

        INSTANCE = this;

        TranslationLoader.loadTranslation(getDir()+"lang", "en");

        Forest.init();

        AllBlocks.init();
        AllItems.init();
        AllParticles.init();
        AllCurses.init();

        LevelDisplayed.init();
        ServerPlayerTick.init();
        ForestTick.init();

    }
}
