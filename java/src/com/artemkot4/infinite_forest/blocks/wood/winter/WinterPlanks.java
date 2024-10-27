package com.artemkot4.infinite_forest.blocks.wood.winter;

import com.artemkot4.infinite_forest.AllBlocks;
import com.artemkot4.infinite_forest.blocks.wood.Planks;
import com.artemkot4.infinite_forest.dimension.biome.ForestBiome;
import com.artemkot4.infinite_forest.utils.EBiomeState;
import ru.koshakmine.icstd.block.RandomTickingComponent;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.Position;

public class WinterPlanks extends Planks implements RandomTickingComponent {

    public WinterPlanks() {
        super("winter_planks");
    }

    @Override
    public void onRandomTick(Position position, BlockData blockData, Level level) {
        EBiomeState state = ForestBiome.getState(position, level);

        if(state != EBiomeState.COLD) {

            level.setBlock(position, BlockID.getModId("eucalyptus_planks"), 0);
        }

    }
}
