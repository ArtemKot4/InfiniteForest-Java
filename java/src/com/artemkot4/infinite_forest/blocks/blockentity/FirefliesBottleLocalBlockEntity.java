package com.artemkot4.infinite_forest.blocks.blockentity;

import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import com.zhekasmirnov.innercore.api.mod.ui.window.IWindow;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.block.blockentity.BlockEntityLocal;
import ru.koshakmine.icstd.block.blockentity.ticking.TickingBlockEntityComponent;
import ru.koshakmine.icstd.type.common.Position;

public class FirefliesBottleLocalBlockEntity extends BlockEntityLocal implements TickingBlockEntityComponent {

    FirefliesBottleLocalBlockEntity(String type, int id, Position position, NetworkEntity network, JSONObject data) throws JSONException {
        super(type, id, position, network, data);
    };

    @Override
    public void onTick() {
     
    }

}
