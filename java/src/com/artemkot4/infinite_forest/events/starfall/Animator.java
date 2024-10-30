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

    public void init() {

        ArrayList<AnimationBase> animations = new ArrayList<>();

        for(StarObjectGenerator star : starList.toArray(new StarObjectGenerator[0])) {
            AnimationBase animation = new AnimationBase(position.x - ThreadLocalRandom.current().nextInt(5, 30),
                    position.y + ThreadLocalRandom.current().nextInt(15,  60),
                    position.z + ThreadLocalRandom.current().nextInt(45, 80));

            animation.setMesh(star.getMesh(), "terrain-atlas/star.png");

            animation.load();

        }

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
