package com.artemkot4.infinite_forest.items;

import com.artemkot4.infinite_forest.utils.DimensionUtils;
import com.artemkot4.infinite_forest.utils.FItem;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.Dimensions;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.item.event.ClickableComponent;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.BlockPosition;
import ru.koshakmine.icstd.type.common.ItemStack;
import ru.koshakmine.icstd.type.common.Texture;

public abstract class TransferCrystal extends FItem implements ClickableComponent {

    private final int dimensionFrom;
    private final int dimensionTo;

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

        this.dimensionFrom = from;
        this.dimensionTo = to;

    };

    @Override
    public void onClick(BlockPosition blockPosition, ItemStack itemStack, BlockData blockData, Player player) {

        int dimension = player.getDimension();

        if(dimension == dimensionFrom) {

            if(DimensionUtils.isSpaceDimension(dimension) || DimensionUtils.isSpaceDimension(dimensionTo)) {
                return;
            };

            Dimensions.transfer(player.getUid(), dimensionTo);
        };

    }
}
