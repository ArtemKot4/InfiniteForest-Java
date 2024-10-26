package com.artemkot4.infinite_forest.items;

import com.artemkot4.infinite_forest.dimension.Forest;
import com.zhekasmirnov.innercore.api.constants.DimensionId;

public class BlueCrystal extends TransferCrystal {
    public BlueCrystal() {
        super("blue_crystal", DimensionId.OVERWORLD, Forest.dimension.id);
    }
}
