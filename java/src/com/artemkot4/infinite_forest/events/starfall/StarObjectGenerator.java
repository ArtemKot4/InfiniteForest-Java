package com.artemkot4.infinite_forest.events.starfall;

import com.artemkot4.infinite_forest.utils.MathHelper;
import com.zhekasmirnov.innercore.api.NativeRenderMesh;
import ru.koshakmine.icstd.type.common.Position;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StarObjectGenerator {

    public static Integer[] definedSizes = new Integer[]{1, 3, 5, 8, 14, 12};

    public NativeRenderMesh mesh;

    protected final int size;

    protected final boolean rotated;

    protected final float speed;

    protected final EStarSide side;


    public StarObjectGenerator() {

      this.rotated = new Random().nextBoolean();

      this.size = MathHelper.randomValue(definedSizes);

      this.speed = this.size > 10 ? this.size / 20 : this.size / 10;

        this.mesh = new NativeRenderMesh();

        this.mesh.addVertex(0, 0, 0, 0, 0);
        this.mesh.addVertex(0, 0, size, 1, 0);
        this.mesh.addVertex(0, size, 0, 0, 1);
        this.mesh.addVertex(0, 0, size, 1, 0);
        this.mesh.addVertex(0, size, 0, 0, 1);
        this.mesh.addVertex(0, size, size, 1, 1);

        Position rotation = defineStarRotation();

        this.mesh.rotate(rotation.x,
                rotation.y,
                rotation.z,
                (float)((ThreadLocalRandom.current().nextInt(45, 90) * 180) / Math.PI),
                0,
                0);

        this.side = isRotated() ?
                MathHelper.randomValue(EStarSide.LEFT, EStarSide.RIGHT) :
                MathHelper.randomValue(EStarSide.BEHIND, EStarSide.FORWARD);
    };

    public Position defineStarRotation() {

       return new Position(0, rotated == true ? MathHelper.gradus90 : 0, 0);

    };

    public NativeRenderMesh getMesh() {
        return mesh;
    };

    public int getSize() {
        return size;
    };

    public boolean isRotated() {
        return rotated;
    };

    public EStarSide getSide() {
        return side;
    };

    public float getSpeed() {
        return speed;
    }

//    public static NativeRenderMesh concatMeshes(MeshGenerator[] meshes) {
//        NativeRenderMesh empty = new NativeRenderMesh();
//
//        for(MeshGenerator mesh : meshes) {
//
//            Boolean x = new Random().nextBoolean();
//            Boolean z = new Random().nextBoolean();
//
//            int randomX = new Random().nextInt(30);
//            int randomZ =  new Random().nextInt(30);
//
//            empty.addMesh(
//                    mesh.getMesh(),
//                    mesh.getSize() + (x == true ? randomX : -randomX),
//                    ThreadLocalRandom.current().nextInt(15, 50),
//                    mesh.getSize() + randomZ
//            );
//        };
//
//        return empty;
//    };


}
