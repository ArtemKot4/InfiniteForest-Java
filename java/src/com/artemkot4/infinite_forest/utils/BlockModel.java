package com.artemkot4.infinite_forest.utils;

import com.artemkot4.infinite_forest.InfiniteForest;
import com.zhekasmirnov.innercore.api.NativeRenderMesh;
import ru.koshakmine.icstd.type.common.Texture;

public class BlockModel {
    protected final NativeRenderMesh mesh;
    protected final byte data;

    public BlockModel(String model, Texture texture, byte data) {

         this.mesh = new NativeRenderMesh();

         mesh.importFromFile(InfiniteForest.DIR + "/resources/assets/models/" + model + ".obj","obj", null);
         mesh.setBlockTexture(texture.texture, texture.meta);

         this.data = data;
    };

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

    public byte getBlockData() {
        return data;
    }

}
