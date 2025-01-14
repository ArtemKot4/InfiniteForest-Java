package com.artemkot4.infinite_forest.dimension.biome;

import ru.koshakmine.icstd.level.CustomBiome;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractBiome extends CustomBiome {
    public static HashMap<Integer, EForestState> stateList = new HashMap<>();
    public static ArrayList<AbstractBiome> biomeList = new ArrayList<>();

    public AbstractBiome() {
        biomeList.add(this);
    };

    public static EForestState getStateFor(int biome) {
        EForestState state = stateList.get(biome);

        return state != null ? state : EForestState.BALANCE;
    };

    abstract EForestState getState();

    /**
     * Method for world generation, must returns list of plant id's and they chances.
     * @return HashMap<Integer, Float>
     */
    abstract HashMap<Integer, Float> getPlantList();

    /**
     * Method for world generation, must returns list of small structures and they chances;
     * @return HashMap<String, Float>
     */
    abstract HashMap<String, Float> getFeatureList();
}
