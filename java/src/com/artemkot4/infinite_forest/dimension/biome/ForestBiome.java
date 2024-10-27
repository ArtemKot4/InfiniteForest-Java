package com.artemkot4.infinite_forest.dimension.biome;


import com.artemkot4.infinite_forest.utils.EBiomeState;
import com.zhekasmirnov.innercore.api.biomes.CustomBiome;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.Position;
import java.util.HashMap;
import java.util.Map;

public abstract class ForestBiome {

    public static final Map<Integer, EBiomeState> states = new HashMap<>();

    public final String id;

    public final float[] skyColor;

    protected final CustomBiome biome;

    public final EBiomeState state;

    public ForestBiome(String id, float[] skyColor, EBiomeState state) {
        this.id = id;
        this.skyColor = skyColor;
        this.biome = new CustomBiome(id);
        this.biome.setSkyColor(skyColor[0], skyColor[1], skyColor[2]);
        this.state = state;

        ForestBiome.states.put(this.biome.id, state);
    };

    public ForestBiome(String id) {
        this(id, new float[]{21 / 255, 96 / 255, 189 / 255}, EBiomeState.BALANCE);
    };

    public ForestBiome(String id, EBiomeState state) {
        this(id, new float[]{21 / 255, 96 / 255, 189 / 255}, state);
    };

    public ForestBiome(String id, float[] skyColor) {
        this(id, skyColor, EBiomeState.BALANCE);
    };

    public String getId() {
        return id;
    };

    public int getNumId() {
        return biome.id;
    };

    public EBiomeState getState() {
        return state;
    };

    public static EBiomeState getState(Position pos, Level level) {

        int biome = level.getBiome((int)pos.x, (int)pos.z);

        EBiomeState state = ForestBiome.states.get(biome);

        return state != null ? state : EBiomeState.BALANCE;
    };


};
