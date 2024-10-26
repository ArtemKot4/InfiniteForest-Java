package com.artemkot4.infinite_forest.events;

import com.artemkot4.infinite_forest.utils.FItem;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.ItemStack;

public class ServerPlayerTick {
    public static void init() {
        Event.onServerPlayerTick((player, b) -> {

            if(Level.getForActor(player.getUid()).getTime() % 8 == 0) {

                ItemStack stack = player.getInventorySlot(player.getSelectedSlot());

                if(FItem.handFunctions.containsKey(stack.id)) {

                    FItem.handFunctions.get(stack.id).init(player, stack);

                }
            }

        });
    }
}
