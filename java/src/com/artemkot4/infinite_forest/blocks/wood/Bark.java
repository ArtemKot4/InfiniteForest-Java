package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.recipes.workbench.ItemCraft;
import ru.koshakmine.icstd.recipes.workbench.PatternData;
import ru.koshakmine.icstd.recipes.workbench.ShapedRecipe;
import ru.koshakmine.icstd.type.block.BlockID;

public abstract class Bark extends RotatableLog {
    public final String log;

    public Bark(String id, String log) {
        super(id);

        this.log = log;

    };

    @Override
    public void onInit() {
        super.onInit();
//        Mod.getFactory().add(new ShapedRecipe(new ItemCraft(getNumId(),0)).setPattern(new String[]{
//                "aa ",
//                "aa ",
//                "   "
//        }, new PatternData[]{
//                new PatternData('a', BlockID.getModId(log))
//        }));
    }
}
