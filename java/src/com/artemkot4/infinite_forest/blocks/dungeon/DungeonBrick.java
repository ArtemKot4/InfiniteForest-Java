package com.artemkot4.infinite_forest.blocks.dungeon;

import com.artemkot4.infinite_forest.AllCurses;
import com.artemkot4.infinite_forest.utils.FBlock;
import com.zhekasmirnov.innercore.api.NativeGameController;
import com.zhekasmirnov.innercore.api.constants.GameMode;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.network.NetworkSide;

import java.util.ArrayList;

public abstract class DungeonBrick extends FBlock {

    private static final ArrayList<Integer> list = new ArrayList<>();

    DungeonBrick(String id) {
        super(id);
        list.add(getNumId());
    };

    static {
        Event.onDestroyBlockContinue((pos, state, f) -> {

            AllCurses.DUNGEON.subscribe(NetworkSide.LOCAL, () -> {

                if(Player.getLocal().getGameMode() == GameMode.CREATIVE) {
                    return;
                };

                NativeGameController.stopDestroyBlock((int)pos.x, (int)pos.y, (int)pos.z);

               return;
            });

        });
    }
}
