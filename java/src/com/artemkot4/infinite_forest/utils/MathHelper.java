package com.artemkot4.infinite_forest.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MathHelper {
    public static final float gradus90 = (float)Math.PI / 2;

    public static <T> T randomValueFrom(T[] valueList) {

        return valueList[(int)Math.floor(Math.random() * valueList.length)];
    };

    @SafeVarargs
    public static <T> T randomValue(T ...args) {

        return args[(int)Math.floor(Math.random() * args.length)];
    };

}
