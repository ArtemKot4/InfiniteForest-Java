package com.artemkot4.infinite_forest.blocks.wood;

import com.zhekasmirnov.innercore.api.unlimited.IDRegistry;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.item.event.ClickableComponent;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.BlockPosition;
import ru.koshakmine.icstd.type.common.ItemStack;


public abstract class Log extends RotatableLog implements ClickableComponent {
    public final String hewn;

    public Log(String id) {
        super(id);

        this.hewn = (id.split("_")[0] + "_hewn");
    };


    @Override
    public void onClick(BlockPosition pos, ItemStack stack, BlockData data, Player player) {
        Level level = player.getRegion();

        if (IDRegistry.getStringIdForItemId(stack.id).contains("axe")) {

            level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, BlockID.getModId(this.hewn), level.getBlockData(pos));
            player.setCarriedItem(new ItemStack(stack.id, stack.count, stack.data++, stack.extra));
        };
    }
}
