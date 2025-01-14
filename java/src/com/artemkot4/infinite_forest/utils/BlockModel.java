package com.artemkot4.infinite_forest.utils;

import com.artemkot4.infinite_forest.InfiniteForest;
import com.zhekasmirnov.innercore.api.NativeRenderMesh;
import ru.koshakmine.icstd.type.common.Texture;

public class BlockModel {
    protected final NativeRenderMesh mesh;
    protected final int data;

    public BlockModel(String model, Texture texture, int data) {

         this.mesh = new NativeRenderMesh();

         mesh.importFromFile(InfiniteForest.DIR + "/resources/assets/models/" + model + ".obj","obj", null);
         mesh.setBlockTexture(texture.texture, texture.meta);
         mesh.translate(0.5f, 0f, 0.5f);

         this.data = data;
    };

    public BlockModel(String model, Texture texture) {
        this(model, texture, -1);
    };

    public BlockModel(String model, String texture) {
        this(model, new Texture(texture, 0), -1);
    };

    public BlockModel(String model, String texture, int data) {
        this(model, new Texture(texture, 0), data);
    }

    public BlockModel(String model) {
        this(model, new Texture(model.split("/")[model.split("/").length - 1], 0), -1);
    }

    public NativeRenderMesh getRenderMesh() {
        return mesh;
    };

    public BlockModel setScale(float x, float y, float z) {
        mesh.scale(x, y, z);
        return this;
    };

    public BlockModel setTranslate(float x, float y, float z) {
        mesh.translate(x, y, z);
        return this;
    };

    public BlockModel setRotation(float x, float y, float z) {
        mesh.rotate(x, y, z);
        return this;
    };

    public int getBlockData() {
        return data;
    };

}
