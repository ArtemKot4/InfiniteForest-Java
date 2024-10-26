package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.recipes.workbench.ItemCraft;
import ru.koshakmine.icstd.recipes.workbench.PatternData;
import ru.koshakmine.icstd.recipes.workbench.ShapedRecipe;

public abstract class Bark extends RotatableLog {
    public Block LOG;

    public Bark(String id, Block log) {
        super(id);

        LOG = log;

        Mod.getFactory().add(new ShapedRecipe(new ItemCraft(getNumId(),0)).setPattern(new String[]{
              "aa ",
              "aa ",
              "   "
      }, new PatternData[]{
        new PatternData('a', LOG.getNumId())
      }));

    }
}
