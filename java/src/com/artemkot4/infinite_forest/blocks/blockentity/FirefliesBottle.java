package com.artemkot4.infinite_forest.blocks.blockentity;

import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.block.BlockEntityLocalHolderComponent;
import ru.koshakmine.icstd.block.blockentity.BlockEntityLocal;
import ru.koshakmine.icstd.type.common.Position;

public class FirefliesBottle extends Bottle implements BlockEntityLocalHolderComponent {

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

}
