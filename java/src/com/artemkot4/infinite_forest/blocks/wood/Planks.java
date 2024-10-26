package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.SoundType;

public abstract class Planks extends Block {
    public String ID;
    public Block LOG;

    @Override
    public String getId() {
        return ID;
    };

    @Override
    public String getSoundType() {
        return SoundType.WOOD;
    };

    public Planks(String id, Block log) {
        ID = id;
        LOG = log;
//        Mod.getFactory().add(new ShapelessRecipe(new ItemCraft(log.getNumId(), 0)).setEntries(new PatternData[]{
//                new PatternData()
//        }))
    };

    @Override
    public String[] getTextures() {
        return new String[]{ID};
    }

    @Override
    public String getName() {
        return "block.infinite_forest." + ID;
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.NATURE;
    }
}
