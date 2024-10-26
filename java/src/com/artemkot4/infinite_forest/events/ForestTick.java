package com.artemkot4.infinite_forest.events;

import com.artemkot4.infinite_forest.dimension.Forest;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.level.particle.Particle;

public class ForestTick {

    public static void init() {

        Event.onLocalPlayerTick((player, b) -> {

            if(player.getDimension() != Forest.getId()) {
                return;
            };

        });
    }
}
