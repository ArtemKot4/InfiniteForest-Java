package com.artemkot4.infinite_forest.items;

import com.artemkot4.infinite_forest.utils.FItem;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.Dimensions;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.type.common.Texture;

public abstract class TransferCrystal extends FItem {

    private final int dimension;

    public boolean isShouldDespawn() {
        return false;
    }

    public boolean isFireResistant() {
        return true;
    }

    public boolean isExplodable() {
        return false;
    }

    public TransferCrystal(String id, int from, int to) {

        super(id, new Texture(id, 0), 1);

        this.dimension = to;

        Item.registerClick(this.getNumId(), (pos, stack, data, player) -> {

            if(player.getDimension() == from) {

                Dimensions.transfer(player.getUid(), to);
            };

        });
    }



}
