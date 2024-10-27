package com.artemkot4.infinite_forest.blocks.plants;

import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.item.event.IClickable;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.BlockPosition;
import ru.koshakmine.icstd.type.common.ItemStack;

import java.util.Random;

public abstract class Bush extends Plant implements IClickable {

    public final String berry;
    public final int count;

    public Bush(String id, String berry, int count) {
        super(id);
        this.berry = berry;
        this.count = count;
    };

    public Bush(String id, String berry) {
        this(id, berry, 3);
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
                  new Random().nextInt(2) + 1,
                  0)
          );

        };

    }
}
