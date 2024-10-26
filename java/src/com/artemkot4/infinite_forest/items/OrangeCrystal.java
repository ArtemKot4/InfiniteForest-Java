package com.artemkot4.infinite_forest.items;

import com.artemkot4.infinite_forest.dimension.Forest;
import com.zhekasmirnov.innercore.api.constants.DimensionId;

public class OrangeCrystal extends TransferCrystal {
    public OrangeCrystal() {
        super("orange_crystal", Forest.dimension.id, DimensionId.OVERWORLD);
    }
}
