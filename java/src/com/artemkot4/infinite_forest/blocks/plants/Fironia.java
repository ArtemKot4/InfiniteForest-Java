package com.artemkot4.infinite_forest.blocks.plants;

public class Fironia extends Plant {

    public final String ID = "fironia";

    @Override
    public String[] getTextures() {
        return new String[]{ID};
    };

    @Override
    public String getId() {
        return ID;
    };

    @Override
    public String getName() {
        return "block.infinite_forest." + ID;
    };

    @Override
    public int getLightLevel() {
        return 5;
    }

}
