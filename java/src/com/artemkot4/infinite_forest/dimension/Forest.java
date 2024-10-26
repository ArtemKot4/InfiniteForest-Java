package com.artemkot4.infinite_forest.dimension;


import com.zhekasmirnov.innercore.api.dimensions.CustomDimension;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.Dimensions;

import ru.koshakmine.icstd.network.Network;
import ru.koshakmine.icstd.network.NetworkSide;

import java.util.HashMap;
import java.util.Map;

public class Forest {

    public static Map<String, Object> flags = new HashMap<>();

    public static <T> void setFlag(NetworkSide side, String name, T value) {
       if(side == NetworkSide.SERVER) {
           flags.put(name, value);
       } else {

       }
       };

    public static <T> T getFlag(NetworkSide side, String name, Object fallback) {
        Object flag = flags.get(name);

        if(side == NetworkSide.SERVER) {
            return flag != null ? (T)flag : (T)fallback;
        } else {

        };

        return (T)flag;
    };

    public static <T> T getFlag(NetworkSide side, String name) {
        return getFlag(side, name, null);
    };

    public static CustomDimension dimension = new Dimensions.CustomDimension("infinite_forest", 75)
            .setSkyColor(21 / 255, 96 / 255, 189 / 255)
            .setFogColor(0 / 255, 128 / 255, 0 / 255)
            .setHasSkyLight(false);

    public static void addLayer() {
     //  dimension.setGenerator(new Dimensions.CustomGenerator("infinite_forest_generator")
           //    .setTerrainGenerator())
    };

    public static void init() {
        //Network.registerPacket();
    };

    public static int getId() {
        return dimension.id;
    }

}
