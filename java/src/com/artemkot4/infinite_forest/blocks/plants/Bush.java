package com.artemkot4.infinite_forest.blocks.plants;

import ru.koshakmine.icstd.block.IRandomTicking;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.item.event.IClickable;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.BlockPosition;
import ru.koshakmine.icstd.type.common.ItemStack;
import ru.koshakmine.icstd.type.common.Position;

import java.util.Random;

public abstract class Bush extends Plant implements IClickable, IRandomTicking {

    public final String berry;

    abstract int getCount();
    abstract int getGrowChance();

    public Bush(String id, String berry) {
        super(id);
        this.berry = berry;
    };


    @Override
    public void onInit() {
        addVariant(getName(), new String[]{id + "_full"});
    };

    @Override
    public void onClick(BlockPosition pos, ItemStack stack, BlockData data, Player player) {

        if(data.data > 0) {

          Level level = player.getRegion();

          level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, data.id, 0);

          level.spawnDroppedItem(
                  pos,
                  new ItemStack(ItemID.getModId(berry),
                  new Random().nextInt(getCount()) + 1,
                  0)
          );

        };

    };

    @Override
    public void onRandomTick(Position pos, BlockData data, Level level) {
           if(Math.random() < getGrowChance() && data.data <= 0) {
                 level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, data.id, data.data + 1);
           }
    }
}
