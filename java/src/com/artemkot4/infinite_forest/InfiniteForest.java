package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.dimension.Forest;
import com.artemkot4.infinite_forest.events.ForestTick;
import com.artemkot4.infinite_forest.events.LevelDisplayed;
import com.artemkot4.infinite_forest.events.ServerPlayerTick;
import com.artemkot4.infinite_forest.events.starfall.Animator;
import com.zhekasmirnov.apparatus.modloader.LegacyInnerCoreMod;
import com.zhekasmirnov.innercore.api.mod.TagRegistry;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;
import ru.koshakmine.icstd.utils.TranslationLoader;

public class InfiniteForest extends Mod {
    public static String WINDOWS;
    public static String DIR;

    public InfiniteForest(String dir, LegacyInnerCoreMod mod) {
        super(dir, mod);
        DIR = dir;

        WINDOWS = dir + "windows/";
    }

    @Override
    public void runMod(ObjectFactory objectFactory) {

        TranslationLoader.loadTranslation(getDir()+"lang", "en");

        AllParticles.init();

        AllBiomes.init();
        Forest.init();

        AllItems.init();
        AllBlocks.init();

        AllCurses.init();

        LevelDisplayed.init();
        ServerPlayerTick.init();
        ForestTick.init();

        Animator.init2();
    };



}
