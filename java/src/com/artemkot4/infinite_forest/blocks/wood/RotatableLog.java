package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.block.SoundType;

public abstract class RotatableLog extends Block {
    public String ID;

    public final String textureTop;
    public final String textureSide;

    public RotatableLog(String id) {
        ID = id;

        rotateRegistry();
        setRotatable();

        textureTop = ID + "_top";
        textureSide =  ID + "_side";

    };

    public void setRotatable() {
        Block.registerPlace(getNumId(), (pos, stack, data, player, level) -> {
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

            level.setBlock(
                    (int)pos.relative.x,
                    (int)pos.relative.y,
                    (int)pos.relative.z,
                    getNumId(),
                    _data
            );
            return pos;
        });
    };

    public void rotateRegistry() {
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
        return ID;
    };

    @Override
    public String getName() {
        return "block.infinite_forest." + ID;
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
