package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.block.IPlaceBlock;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.SoundType;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.BlockPosition;
import ru.koshakmine.icstd.type.common.ItemStack;
import ru.koshakmine.icstd.type.common.Position;

public abstract class RotatableLog extends Block implements IPlaceBlock {
    public String id;

    public final String textureTop;
    public final String textureSide;

    public RotatableLog(String id) {
        this.id = id;

        textureTop = id + "_top";
        textureSide =  id + "_side";

    };

    @Override
    public Position onPlace(BlockPosition pos, ItemStack stack, BlockData data, Player player, Level level) {
        short _data = 0;

        switch (pos.side) {
            case 5:
                _data = 2;
                break;
            case 4:
                _data = 2;
                break;
            case 2:
                _data = 1;
                break;
            case 3:
                _data = 1;
                break;
        };

        level.setBlock((int)pos.relative.x, (int)pos.relative.y, (int)pos.relative.z, getNumId(), _data );

        return pos;
    }

    @Override
    public void onInit() {
        addVariant(getName(), new String[]{textureSide, textureSide, textureTop, textureTop, textureSide, textureSide});
        addVariant(getName(), new String[]{textureSide, textureSide, textureSide, textureSide, textureTop, textureTop});
    };

    @Override
    public String[] getTextures() {
        return new String[]{
                textureTop, textureTop, textureSide, textureSide, textureSide, textureSide
        };
    };


    @Override
    public String getId() {
        return id;
    };

    @Override
    public String getName() {
        return "block.infinite_forest." + id;
    };


    @Override
    public String getSoundType() {
        return SoundType.WOOD;
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.NATURE;
    }

}
