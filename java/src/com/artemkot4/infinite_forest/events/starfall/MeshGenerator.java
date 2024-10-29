package com.artemkot4.infinite_forest.events.starfall;

import com.zhekasmirnov.innercore.api.NativeRenderMesh;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MeshGenerator {

    public static Integer[] definedSizes = new Integer[]{1, 3, 5, 8, 14, 18, 20, 22, 14};

    public NativeRenderMesh mesh;
    public final int size;

    public MeshGenerator() {

      this.size = definedSizes[(int)Math.random() * definedSizes.length + 1];

        this.mesh = new NativeRenderMesh();

        this.mesh.addVertex(0, 0, 0, 0, 0);
        this.mesh.addVertex(0, 0, size, size, 0);
        this.mesh.addVertex(0, size, 0, 0, 1);
        this.mesh.addVertex(0, 0, size, 1, 0);
        this.mesh.addVertex(0, size, 0, 0, 1);
        this.mesh.addVertex(0, size, size, 1, 1);

        this.mesh.setBlockTexture("star", 0);

        float min = 0.1f;
        float max = 0.9f;

        Random random = new Random();

        float rotation = min + (max - min) * random.nextFloat();

        this.mesh.rotate(0, 0, 0, 0, (float) rotation, 0);

    };

    public NativeRenderMesh getMesh() {
        return mesh;
    };

    public int getSize() {
        return size;
    };

    public static NativeRenderMesh concatMeshes(MeshGenerator[] meshes) {
        NativeRenderMesh empty = new NativeRenderMesh();

        for(MeshGenerator mesh : meshes) {

            Boolean x = new Random().nextBoolean();
            Boolean z = new Random().nextBoolean();

            int randomX = new Random().nextInt(30);
            int randomZ =  new Random().nextInt(30);

            empty.addMesh(
                    mesh.getMesh(),
                    mesh.getSize() + (x == true ? randomX : -randomX),
                    ThreadLocalRandom.current().nextInt(15, 50),
                    mesh.getSize() + randomZ
            );
        };

        return empty;
    }

}
