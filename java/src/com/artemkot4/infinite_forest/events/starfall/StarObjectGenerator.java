package com.artemkot4.infinite_forest.events.starfall;

import com.artemkot4.infinite_forest.utils.MathHelper;
import com.zhekasmirnov.innercore.api.NativeRenderMesh;
import java.util.HashMap;
import java.util.Map;

public class StarObjectGenerator {

    public static Integer[] definedSizes = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};

    public static Map<Integer, NativeRenderMesh> meshList = new HashMap<>();

    protected final int size;

    protected final float speed;

    public StarObjectGenerator() {

      this.size = MathHelper.randomValue(definedSizes);

      this.speed = this.size > 10 ? this.size / 20 : this.size / 10;

    };


    public NativeRenderMesh getMesh() {
        return meshList.get(size);
    };

    public int getSize() {
        return size;
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

   static {

        for(int size : definedSizes) {

            NativeRenderMesh mesh = new NativeRenderMesh();

            mesh.addVertex(0, 0, 0, 0, 0);
            mesh.addVertex(0, 0, size, 1, 0);
            mesh.addVertex(0, size, 0, 0, 1);
            mesh.addVertex(0, 0, size, 1, 0);
            mesh.addVertex(0, size, 0, 0, 1);
            mesh.addVertex(0, size, size, 1, 1);

            meshList.put(size, mesh);

        }
   }

}
