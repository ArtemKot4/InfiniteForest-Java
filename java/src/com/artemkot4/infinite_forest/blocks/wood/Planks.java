package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.SoundType;

public abstract class Planks extends Block {
    public String id;
    public String log;

    public Planks(String id) {
        this.id = id;
        this.log =  (id.split("_")[0] + "_log");;
//        Mod.getFactory().add(new ShapelessRecipe(new ItemCraft(log.getNumId(), 0)).setEntries(new PatternData[]{
//                new PatternData()
//        }))
    };

    @Override
    public String getId() {
        return id;
    };

    @Override
    public String getSoundType() {
        return SoundType.WOOD;
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
