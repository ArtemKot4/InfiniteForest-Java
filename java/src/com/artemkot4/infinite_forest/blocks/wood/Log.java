package com.artemkot4.infinite_forest.blocks.wood;

import com.zhekasmirnov.innercore.api.unlimited.IDRegistry;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.item.event.IClickable;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.BlockPosition;
import ru.koshakmine.icstd.type.common.ItemStack;


public abstract class Log extends RotatableLog implements IClickable {
    public final String hewn;

    public Log(String id, String hewn) {
        super(id);

        this.hewn = hewn;
    };


    @Override
    public void onClick(BlockPosition pos, ItemStack stack, BlockData data, Player player) {
        Level level = player.getRegion();

        player.message("stack id -> " + stack.id);
        player.message(hewn + " -> " + BlockID.getModId(this.hewn) );


        if (((String)IDRegistry.getStringIdForItemId(stack.id)).contains("axe")) {

            level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, BlockID.getModId(this.hewn), level.getBlockData(pos));
            player.setCarriedItem(new ItemStack(stack.id, stack.count, stack.data++, stack.extra));
        };
    }
}
