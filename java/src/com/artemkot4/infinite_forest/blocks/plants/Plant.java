package com.artemkot4.infinite_forest.blocks.plants;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.block.SoundType;

import java.util.ArrayList;


public abstract class Plant extends Block {

  public static ArrayList<Integer> placeList = new ArrayList<>();

  @Override
  public int getRenderType() {
      return 1;
  };

  @Override
  public float getTranslucency() {
      return 0;
  };

  @Override
  public int getLightOpacity() {
      return 0;
  };

  @Override
  public int getRenderLayer() {
      return 3;
  };

  @Override
  public float getDestroyTime() {
      return 0;
  };

  @Override
  public String getSoundType() {
      return SoundType.GRASS;
  };

  static {
      Plant.placeList.add(BlockID.GRASS);
      Plant.placeList.add(BlockID.GRASS_PATH);
      Plant.placeList.add(BlockID.PODZOL);
      Plant.placeList.add(BlockID.MYCELIUM);
      Plant.placeList.add(BlockID.DIRT);
  };

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.NATURE;
    }

}
