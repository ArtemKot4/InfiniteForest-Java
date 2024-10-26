package com.artemkot4.infinite_forest.dimension;


import com.zhekasmirnov.innercore.api.dimensions.CustomDimension;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.Dimensions;

public class Forest {

    public static CustomDimension dimension = new Dimensions.CustomDimension("infinite_forest", 75)
            .setSkyColor(21 / 255, 96 / 255, 189 / 255)
            .setFogColor(0 / 255, 128 / 255, 0 / 255)
            .setHasSkyLight(false);

    public static void addLayer() {
     //  dimension.setGenerator(new Dimensions.CustomGenerator("infinite_forest_generator")
           //    .setTerrainGenerator())
    };

    public static void init() {};

}
