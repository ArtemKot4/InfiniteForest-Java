package com.artemkot4.infinite_forest.events.starfall;

import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.render.animation.AnimationBase;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.common.Position;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Animator {

    public final ArrayList<StarObjectGenerator> starList;

    public final Position position;

    public Animator(Player player) {

        int starCount = ThreadLocalRandom.current().nextInt(3, 15);

        ArrayList<StarObjectGenerator> list = new ArrayList<>();

        for(int i = 0; i < starCount; i++) {
            StarObjectGenerator star = new StarObjectGenerator();

            list.add(star);
        };

        this.starList = list;

     this.position = player.getPosition();

    };

    private int timer = 0;

    public Position definePosition(StarObjectGenerator star) {

        int multiplier = star.size * 10;

        float x = position.x +
                ((star.side.ordinal() >= 2) ?
                        ((star.side == EStarSide.BEHIND ? -multiplier : multiplier)) :
                        ThreadLocalRandom.current().nextInt(-10, 10));

        float y = ThreadLocalRandom.current().nextInt(15, 60);

        float z = position.z +
                ((star.side.ordinal() < 2) ?
                        ((star.side == EStarSide.LEFT ? -multiplier : multiplier)) :
                        ThreadLocalRandom.current().nextInt(-10, 10));

      return new Position(x, y, z);

    };

    public void init() {

        ArrayList<AnimationBase> animations = new ArrayList<>();

        starList.forEach((element) -> {

            Position resultPosition = definePosition(element);

            AnimationBase animation = new AnimationBase(resultPosition.x, resultPosition.y, resultPosition.z);
            animation.setMesh(element.getMesh(), "terrain-atlas/star.png");

            animation.loadCustom((arg) -> {

               timer+=0.005;

               animation.getTransform().lock().translate(0d, -((double)(element.speed)), 0d).unlock();

               if(timer >= 500) {

                   animation.destroy();
                   return;
               };

            });
        });

    };

    static {
    //TODO: debug here
        Event.onItemUse((pos, stack, data, player) -> {

            if(stack.id == ItemID.STICK) {

                new Animator(player).init();
                player.message("Анимация создана!");
            };

            if(stack.id == ItemID.DIAMOND) {
              AnimationBase test = new AnimationBase<>(pos.x, pos.y + 3, pos.z);
              test.setMesh(new StarObjectGenerator().getMesh(), "terrain-atlas/star.png");
              test.load();
            }

        });
    };


    public static void init2() {} //TODO: DELETE IN FUTURE
}
