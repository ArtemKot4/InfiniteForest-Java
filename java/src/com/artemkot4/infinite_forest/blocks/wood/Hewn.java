package com.artemkot4.infinite_forest.blocks.wood;

public abstract class Hewn extends RotatableLog {
    public final String log;

    public Hewn(String id, String log) {
         super(id);
         this.log = log;
    }
}
