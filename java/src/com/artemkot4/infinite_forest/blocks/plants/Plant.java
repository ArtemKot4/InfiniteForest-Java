package com.artemkot4.infinite_forest.blocks.plants;

import com.artemkot4.infinite_forest.utils.FBlock;
import ru.koshakmine.icstd.block.NeighbourChangeComponent;
import ru.koshakmine.icstd.block.PlaceComponent;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.block.SoundType;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.BlockPosition;
import ru.koshakmine.icstd.type.common.ItemStack;
import ru.koshakmine.icstd.type.common.Position;
import ru.koshakmine.icstd.type.tools.BlockMaterials;
import ru.koshakmine.icstd.type.tools.ToolLevel;

import java.util.ArrayList;


public abstract class Plant extends FBlock implements PlaceComponent, NeighbourChangeComponent {

  public static ArrayList<Integer> placeList = new ArrayList<>();

  public Plant(String id) {
      super(id);
      this.setCreativeCategory(CreativeCategory.NATURE);
  }

    @Override
    public Position onPlace(BlockPosition pos, ItemStack itemStack, BlockData blockData, Player player, Level level) {
        if(isPlaceBlockAt(pos.x, pos.y, pos.z, level)) {

            level.setBlock((int)pos.x, (int)pos.y + 1, (int)pos.z, getNumId(), 0);
        };

        return pos;
    }

    @Override
    public void onNeighbourChanged(Position pos, Position pos1, BlockData blockData, Level level) {

        if(!isPlaceBlockAt(pos.x, pos.y - 1, pos.z, level)) {

            level.destroyBlock(pos);
        }
    }

    private boolean isPlaceBlockAt(float x, float y, float z, Level level) {
        return placeList.contains(level.getBlockId((int)x, (int)y, (int)z));
    };

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

    @Override
    public boolean isSolid() {
        return false;
    };

    @Override
    public int getMaterialBase() {
        return BlockID.LEAVES;
    }

    @Override
    public int getToolLevel() {
        return ToolLevel.ARM;
    }

    @Override
    public String getBlockMaterial() {
        return BlockMaterials.PLANT;
    }

    static {
      Plant.placeList.add(BlockID.GRASS);
      Plant.placeList.add(BlockID.GRASS_PATH);
      Plant.placeList.add(BlockID.PODZOL);
      Plant.placeList.add(BlockID.MYCELIUM);
      Plant.placeList.add(BlockID.DIRT);
  };

}
