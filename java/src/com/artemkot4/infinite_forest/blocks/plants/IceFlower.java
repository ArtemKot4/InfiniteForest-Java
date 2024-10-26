package com.artemkot4.infinite_forest.blocks.plants;

public class IceFlower extends Plant {

    public IceFlower() {
        super("ice_flower");
    };

    @Override
    public int getLightLevel() {
        return 5;
    }
}
