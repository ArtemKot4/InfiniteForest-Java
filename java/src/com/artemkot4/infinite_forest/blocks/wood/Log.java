package com.artemkot4.infinite_forest.blocks.wood;

import com.zhekasmirnov.innercore.api.unlimited.IDRegistry;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.ItemStack;


public class Log extends Block {
    public final String ID;

    public final String textureTop;
    public final String textureSide;

    Log(String id) {
        super();

        ID = id;
        textureTop = ID + "_top";
        textureSide =  ID + "_side";

        rotateRegistry();

        Block.registerClick(getNumId(), (pos, stack, data, player) -> {
           Level level = Level.getForActor(player.getUid());

            if (IDRegistry.getNameByID(stack.id).contains("axe")) {

                   level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, getNumId() /*сюда нужно будет поместить в будущем очищенный от коры вариант*/, level.getBlockData(pos));
                       player.setCarriedItem(new ItemStack(stack.id, stack.count, stack.data++, stack.extra));
            };
        });

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

    @Override
    public String[] getTextures() {
        return new String[]{
           textureTop, textureTop, textureSide, textureSide, textureSide, textureSide
        };
    };

    public void rotateRegistry() {
        addVariant(getName(), new String[]{textureSide, textureSide, textureTop, textureTop, textureSide, textureSide});
        addVariant(getName(), new String[]{textureSide, textureSide, textureSide, textureSide, textureTop, textureTop});
    };

    @Override
    public String getName() {
        return "block.infinite_forest." + ID;
    };

    @Override
    public String getId() {
        return ID;
    };

    @Override
    public String getSoundType() {
        return "wood";
    }
}
