package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.dimension.biome.FirefliesForestBiome;
import com.artemkot4.infinite_forest.dimension.biome.ForestBiome;
import com.artemkot4.infinite_forest.dimension.biome.WinterForestBiome;

public class AllBiomes {

    public static ForestBiome FIREFLIES_FOREST = new FirefliesForestBiome();
    public static ForestBiome WINTER_FOREST = new WinterForestBiome();

    public static void init() {};
}
