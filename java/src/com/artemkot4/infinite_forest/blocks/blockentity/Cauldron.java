package com.artemkot4.infinite_forest.blocks.blockentity;

import com.artemkot4.infinite_forest.utils.BlockModel;
import com.artemkot4.infinite_forest.utils.FBlock;
import com.artemkot4.infinite_forest.utils.IBlockModeled;

public class Cauldron extends FBlock implements IBlockModeled {
    public Cauldron() {
        super("iron_cauldron", "salt");
    };

    @Override
    public BlockModel getBlockModel() {
        return new BlockModel("block/iron_cauldron", "iron_cauldron");
    }
}
