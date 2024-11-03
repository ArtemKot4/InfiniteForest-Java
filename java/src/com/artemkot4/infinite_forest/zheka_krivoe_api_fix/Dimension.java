package com.artemkot4.infinite_forest.zheka_krivoe_api_fix;

import com.zhekasmirnov.innercore.api.biomes.CustomBiome;
import com.zhekasmirnov.innercore.api.dimensions.*;

public abstract class Dimension {
    public CustomBiome biome = null;

    public int id;
    public String stringId;

    public CustomDimension dimension;
    public CustomDimensionGenerator generator;
    public TerrainLayer[] layers;

    public NoiseConversion buildNoiseConversion(float[][] yConversion) {
        NoiseConversion conversion = new NoiseConversion();
      for(float[] current : yConversion) {
         conversion.addNode(current[0], current[1]);
      };

      return conversion;
    };

    public NoiseGenerator buildNoiseGenerator(TerrainLayer layer) {
        NoiseGenerator generator = new NoiseGenerator();
        //TODO: потом доделать
        return generator;
    };

    public void setLayers(MonoBiomeTerrainGenerator generator) {
        for(TerrainLayer layer : layers) {
            generator.addTerrainLayer(layer.getMaxY(), layer.getMinY())
                    .setYConversion(buildNoiseConversion(layer.yConversion));
            //.;
        }
    }

    public Dimension() {

      this.dimension = new CustomDimension(stringId, id);
      this.generator = new CustomDimensionGenerator(stringId + "_generator");

      if(this.biome != null) {
          MonoBiomeTerrainGenerator biomeGenerator = new MonoBiomeTerrainGenerator();
          biomeGenerator.setBaseBiome(this.biome.id);

          this.generator.setTerrainGenerator(biomeGenerator);
      };



    };

}
