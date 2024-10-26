package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.SoundType;

public abstract class Planks extends Block {
    public String id;
    public Block log;

    @Override
    public String getId() {
        return id;
    };

    @Override
    public String getSoundType() {
        return SoundType.WOOD;
    };

    public Planks(String id, Block log) {
        this.id = id;
        this.log = log;
//        Mod.getFactory().add(new ShapelessRecipe(new ItemCraft(log.getNumId(), 0)).setEntries(new PatternData[]{
//                new PatternData()
//        }))
    };

    @Override
    public String[] getTextures() {
        return new String[]{id};
    }

    @Override
    public String getName() {
        return "block.infinite_forest." + id;
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.NATURE;
    }
}
