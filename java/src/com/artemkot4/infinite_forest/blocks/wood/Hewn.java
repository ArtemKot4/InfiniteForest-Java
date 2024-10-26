package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;

public abstract class Hewn extends RotatableLog {
    public Block LOG;

    public Hewn(String id, Block log) {
         super(id);
         LOG = log;
    }
}
