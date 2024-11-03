package com.artemkot4.infinite_forest.zheka_krivoe_api_fix;

import com.zhekasmirnov.innercore.api.dimensions.NoiseLayer;

public class TerrainLayer {
    protected int minY;
    protected int maxY;
    protected float[][] yConversion;
    protected int[] material;
    protected int[] octaves;

    public TerrainLayer(int minY, int maxY) {
        this.minY = minY;
        this.maxY = maxY;

        if(minY < 0 || maxY > 256) {
            throw new RuntimeException("minY or maxY can't might be as defined range");
        };

    };

    public void setYConversion(float[][] yConversion) {
        this.yConversion = yConversion;
    };

    public void setMaterial(int base, int[] surface, int cover) {
        material = new int[]{cover, base, surface[0], surface[1], surface[2]};
    };

    public void setOctaves(int count, int scale) {
        octaves = new int[]{count, scale};
    };

    public float[][] getYConversion() {
        return yConversion;
    };

    public int[] getMaterial() {
        return material;
    }

    public int getMaxY() {
        return maxY;
    };

    public int getMinY() {
        return minY;
    };

    public int[] getOctaves() {
        return octaves;
    }
}
