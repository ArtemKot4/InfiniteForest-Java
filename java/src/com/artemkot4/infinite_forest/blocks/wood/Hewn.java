package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;

public abstract class Hewn extends RotatableLog {
    public int log;

    public Hewn(String id, int log) {
         super(id);
         this.log = log;
    }
}
