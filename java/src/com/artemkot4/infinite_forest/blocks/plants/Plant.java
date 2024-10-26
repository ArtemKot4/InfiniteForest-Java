package com.artemkot4.infinite_forest.blocks.plants;

import com.artemkot4.infinite_forest.utils.FBlock;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.block.SoundType;

import java.util.ArrayList;


public abstract class Plant extends FBlock {

  public Plant(String id) {
      super(id);
      this.setCreativeCategory(CreativeCategory.NATURE);

      Block.registerNeighbourChanged(getNumId(), (pos, changePos, data, level) -> {

          if(!isPlaceBlockAt(pos.x, pos.y - 1, pos.z, level)) {

              level.destroyBlock(pos);
          }
      });

      Block.registerPlace(getNumId(), (pos, stack, data, player, level) -> {

          if(isPlaceBlockAt(pos.x, pos.y, pos.z, level)) {

              level.setBlock((int)pos.x, (int)pos.y + 1, (int)pos.z, getNumId(), 0);

          };

      });
  }

  private boolean isPlaceBlockAt(float x, float y, float z, Level level) {
      return placeList.contains(level.getBlockId((int)x, (int)y, (int)z));
  }

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

}
