package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.dimension.curse.ColdCurse;
import com.artemkot4.infinite_forest.dimension.curse.Curse;
import com.artemkot4.infinite_forest.dimension.curse.DungeonCurse;
import com.artemkot4.infinite_forest.dimension.curse.LightningCurse;

public class AllCurses {
   public static final Curse COLD = new ColdCurse();
   public static final Curse LIGHTNING = new LightningCurse();
   public static final Curse DUNGEON = new DungeonCurse();

   public static void init() {};
}
