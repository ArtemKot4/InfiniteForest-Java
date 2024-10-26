package com.artemkot4.infinite_forest.dimension.curse;

import com.artemkot4.infinite_forest.dimension.Forest;
import com.zhekasmirnov.innercore.api.constants.GameMode;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.network.NetworkSide;

import java.util.HashMap;
import java.util.Map;

public abstract class Curse {
    public String id;

    public Curse(String id) {
      this.id = id;
    };

    public void init() {
       Map<String, Boolean> flag = Forest.getFlag(NetworkSide.LOCAL, "curse");

        if(flag == null) {

            Map<String, Boolean> map = new HashMap<>();

              map.put(id, true);

            Forest.setFlag(NetworkSide.LOCAL, "curse", map);
        };

        if ((flag instanceof HashMap) && !(flag.get(id) instanceof Boolean)) {

            flag.put(id, true);
            
        }

    }

    public boolean hasWorld(NetworkSide side) {
        Map<String, Boolean> flag = Forest.getFlag(side, "curse");

        if(flag == null || flag.get(id) == null) {

           throw new NullPointerException("hasWorld: Key does not exists");

        };

        return flag.get(id);
    };

    public boolean hasForGameMode(NetworkSide side, Player player) {

        if(player.getGameMode() == GameMode.CREATIVE) {
            return false;
        };

        return hasWorld(side);
     };


    public void destroy(NetworkSide side){
        Map<String, Boolean> flag = Forest.getFlag(side, "curse");

        if(flag == null || flag.get(id) == null) {

            throw new NullPointerException("Destroy: Key does not exists");

        };

            flag.put(id, false);

          Forest.setFlag(side, "curse", flag);
        }


        public void subscribe(NetworkSide side, ICurseSubscriber lambda, Player player) {

               if(player != null) {

                   if(hasForGameMode(side, player)) {

                       lambda.init();
                       return;
                   }
               };

               if(hasWorld(side)) {

                   lambda.init();
               }
               return;

        };

        public void subscribe(NetworkSide side, ICurseSubscriber lambda) {
            subscribe(side, lambda, null);
        }



}
