package com.artemkot4.infinite_forest.blocks.wood;

import ru.koshakmine.icstd.block.Block;

public abstract class Hewn extends RotatableLog {
    public final String log;

    public Hewn(String id, String log) {
         super(id);
         this.log = log;
    }
}
