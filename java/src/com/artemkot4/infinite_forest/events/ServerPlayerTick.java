package com.artemkot4.infinite_forest.events;

import com.artemkot4.infinite_forest.utils.FItem;
import com.artemkot4.infinite_forest.utils.HandItemComponent;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.ItemStack;

public class ServerPlayerTick {
    public static void init() {
        Event.onServerPlayerTick((player, b) -> {

            if(player.getRegion().getTime() % 8 == 0) {

                ItemStack stackRight = player.getInventorySlot(player.getSelectedSlot());

                ItemStack stackLeft = player.getOffhandItem();

                HandItemComponent rightAttempt = FItem.handFunctions.get(stackRight.id);
                HandItemComponent leftAttempt = FItem.handFunctions.get(stackLeft.id);

                if(rightAttempt != null) {

                    rightAttempt.onHand(player, stackRight);

                };

                if(leftAttempt != null) {

                    leftAttempt.onHand(player, stackLeft);

                }
            }

        });
    }
}
