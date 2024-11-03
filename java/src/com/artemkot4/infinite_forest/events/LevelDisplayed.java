package com.artemkot4.infinite_forest.events;

import com.artemkot4.infinite_forest.AllCurses;
import com.artemkot4.infinite_forest.dimension.Forest;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.event.Events;

public class LevelDisplayed {

    public static void init() {

        Event.onCall(Events.LevelDisplayed, (args) -> {
            Forest.init();

            AllCurses.COLD.init();
            AllCurses.LIGHTNING.init();
            AllCurses.DUNGEON.init();

        });
    }
}
