package com.artemkot4.infinite_forest.events;

import com.artemkot4.infinite_forest.AllCurses;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.event.Events;

public class LevelDisplayed {
    public static void init() {
        Event.onCall(Events.LevelDisplayed, (args) -> {
            AllCurses.COLD.init();
        });
    }
}
