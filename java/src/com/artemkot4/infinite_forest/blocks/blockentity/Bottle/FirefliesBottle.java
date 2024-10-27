package com.artemkot4.infinite_forest.blocks.blockentity.bottle;

import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.block.BlockEntityHolderComponent;
import ru.koshakmine.icstd.block.BlockEntityLocalHolderComponent;
import ru.koshakmine.icstd.block.blockentity.BlockEntity;
import ru.koshakmine.icstd.block.blockentity.BlockEntityLocal;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.Position;

public class FirefliesBottle extends Bottle implements BlockEntityLocalHolderComponent, BlockEntityHolderComponent {

    public FirefliesBottle() {
        super("fireflies_bottle");
    };

    @Override
    public int getLightLevel() {
        return 10;
    };

    @Override
    public BlockEntityLocal createLocalBlockEntity(Position position, NetworkEntity networkEntity, JSONObject jsonObject) throws JSONException {
        return new FirefliesBottleLocalBlockEntity(getBlockEntityType(), getNumId(), position, networkEntity, jsonObject);
    };

    @Override
    public BlockEntity createBlockEntity(Position position, Level level) {
        return new FirefliesBottleBlockEntity(getBlockEntityType(), getBlockEntityType(), getNumId(), position, level);
    }

}
