package com.artemkot4.infinite_forest.utils;

import com.artemkot4.infinite_forest.dimension.biome.AbstractBiome;
import com.artemkot4.infinite_forest.dimension.biome.EForestState;
import com.zhekasmirnov.innercore.api.mod.TagRegistry;
import ru.koshakmine.icstd.level.Level;

public class DimensionUtils {
    public static boolean isSpaceDimension(int dimension) {
        return TagRegistry.getOrCreateGroup("dimension").getAllWithTag("space").contains(dimension);
    };

    public static EForestState getStateFor(float x, float z) {
        Level level = Level.getForDimension(75);

        if(level == null) {
            return null;
        };

        return AbstractBiome.getStateFor(level.getBiome(x, z));
    }
}
