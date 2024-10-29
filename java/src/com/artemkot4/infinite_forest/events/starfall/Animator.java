package com.artemkot4.infinite_forest.events.starfall;

import com.zhekasmirnov.innercore.api.NativeRenderMesh;
import com.zhekasmirnov.innercore.api.NativeRenderer;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.render.animation.AnimationBase;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.common.Position;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Animator {

    public final NativeRenderMesh resultMesh;
    public final AnimationBase animation;

    public Animator(Player player) {

        int starCount = ThreadLocalRandom.current().nextInt(3, 15);

        ArrayList<MeshGenerator> list = new ArrayList<>();

        for(int i = 0; i < starCount; i++) {
            MeshGenerator mesh = new MeshGenerator();

            list.add(mesh);
        };

     this.resultMesh = MeshGenerator.concatMeshes(list.toArray(new MeshGenerator[0]));

     Position position = player.getPosition();

     this.animation = new AnimationBase(position.x, position.y, position.z);

     this.animation.setMesh(resultMesh, "terrain-atlas/star.png");
     this.animation.setIgnoreBlocklight(true);
    };

    private double len = 0d;
    private int timer = 0;

    public void init() {

     this.animation.loadCustom((animation) -> {
         Position pos = this.animation.getPosition();

         this.animation.getTransform().lock().translate(pos.x, -len, pos.z);
         this.animation.updateRender();

         len+=0.00001;

         timer++;

         if(timer >= 1000) {
             this.animation.destroy();
             return;
         };
     });

    };

    static {
    //TODO: debug here
        Event.onItemUse((pos, stack, data, player) -> {

            if(stack.id == ItemID.STICK) {

                new Animator(player).init();
            }

        });
    };

}
