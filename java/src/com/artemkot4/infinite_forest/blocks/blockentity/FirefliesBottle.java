package com.artemkot4.infinite_forest.blocks.blockentity;

public class FirefliesBottle extends Bottle {

    public FirefliesBottle() {
        super("fireflies_bottle");
    };

    @Override
    public int getLightLevel() {
        return 10;
    };

}
