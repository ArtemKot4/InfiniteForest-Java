package com.artemkot4.infinite_forest.utils;

import com.zhekasmirnov.innercore.api.mod.TagRegistry;

public class DimensionUtils {
    public static boolean isSpaceDimension(int dimension) {
        return TagRegistry.getOrCreateGroup("dimension").getAllWithTag("space").contains(dimension);
    };
}
