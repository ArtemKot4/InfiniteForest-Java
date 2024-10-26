package com.artemkot4.infinite_forest.blocks.wood;

import com.zhekasmirnov.innercore.api.unlimited.IDRegistry;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.ItemStack;


public abstract class Log extends RotatableLog {
    public Block hewn;

    public Log(String id, Block hewn) {
        super(id);

        this.hewn = hewn;

        cut();
    };

    public void cut() {

        Block.registerClick(getNumId(), (pos, stack, data, player) -> {
            Level level = Level.getForActor(player.getUid());

            if (IDRegistry.getNameByID(stack.id).contains("axe")) {

                level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, this.hewn.getNumId(), level.getBlockData(pos));
                player.setCarriedItem(new ItemStack(stack.id, stack.count, stack.data++, stack.extra));
            };
        });

    }

}
