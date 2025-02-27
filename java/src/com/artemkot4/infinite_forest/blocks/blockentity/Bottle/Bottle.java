package com.artemkot4.infinite_forest.blocks.blockentity.bottle;

import com.artemkot4.infinite_forest.utils.BlockModel;
import com.artemkot4.infinite_forest.dimension.biome.;
import com.artemkot4.infinite_forest.utils.DimensionUtils;
import com.artemkot4.infinite_forest.utils.FBlock;
import com.artemkot4.infinite_forest.utils.IBlockModel;
import com.zhekasmirnov.innercore.api.NativeBlock;
import ru.koshakmine.icstd.block.NeighbourChangeComponent;
import ru.koshakmine.icstd.block.RandomTickingComponent;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.block.SoundType;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.Position;

public abstract class Bottle extends FBlock implements IBlockModel, NeighbourChangeComponent, RandomTickingComponent {

    public Bottle(String id) {
        super(id, "glass");
    };

    @Override
    public BlockModel getBlockModel() {
        return new BlockModel("block/bottle", "forest_bottle");
    };

    @Override
    public String getSoundType() {
        return SoundType.GLASS;
    };

    @Override
    public void onNeighbourChanged(Position pos, Position pos1, BlockData blockData, Level level) {

        int blockUnder = level.getBlockId((int)pos.x, (int)pos.y - 1, (int)pos.z);

        int blockUpper = level.getBlockId((int)pos.x, (int)pos.y + 1, (int)pos.z);

        if(blockUpper != -227 && (!NativeBlock.isSolid(blockUnder) || blockUnder == BlockID.AIR)) { //chain
            level.destroyBlock(pos);
        }

    };

    @Override
    public void onRandomTick(Position position, BlockData blockData, Level level) {

        if(DimensionUtils.getStateFor(position.x, position.z) != EForestState.BALANCE) {

            level.destroyBlock(position);
        }

    }

}
