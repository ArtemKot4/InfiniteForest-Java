package com.artemkot4.infinite_forest.dimension;


import com.zhekasmirnov.innercore.api.dimensions.CustomDimension;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.Dimensions;

import com.zhekasmirnov.innercore.utils.FileTools;
import ru.koshakmine.icstd.network.Network;
import ru.koshakmine.icstd.network.NetworkClient;
import ru.koshakmine.icstd.network.NetworkPacket;
import ru.koshakmine.icstd.network.NetworkSide;
import ru.koshakmine.icstd.runtime.saver.Saver;

import java.nio.ByteBuffer;
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

    public static int getId() {
        return dimension.id;
    }

    public static class FromClientSetFlagPacket <T> extends NetworkPacket {
        public String name;
        public String collection;
        public T value;

        public FromClientSetFlagPacket(String collection, String name, T value) {
           this.name = name;
           this.value = value;
           this.collection = collection;
        }

        @Override
        public String getName() {
            return "packet.infinite_forest.add_flag_from_client";
        };

        @Override
        protected void decode(NetworkClient networkClient) {
          String[] str = getString().split(":");

          byte type = getByte();

          if(type == -1) {
              throw new IllegalArgumentException("Wrong type!");
          }

          Object value = null;

          switch (type) {
              case 0: value = str[2];
              break;

              case 1: value = getInt();
              break;

              case 2: value = getBoolean();
              break;
          };

          Map<String, Object> map = (HashMap)flags.get(str[0]);
          map.put(str[1], value);
        }

        @Override
        protected void encode() {

            byte type = -1;

            String str = collection + ":" + name;

            if(value instanceof String) {

                type = 0;
                str += ":" + value;

            } else if(value instanceof Integer) {

                type = 1;
                putInt((int)value);

            } else if(value instanceof Boolean) {

                type = 2;
                putBoolean((boolean)value);

            };

                putString(str);
                putByte(type);
        }



    };

    public static void init () {
        Object curse = getFlag(NetworkSide.LOCAL, "curse");
        flags.put("curse", curse instanceof HashMap ? curse : new HashMap<>());
    };

    static {

    }
}
