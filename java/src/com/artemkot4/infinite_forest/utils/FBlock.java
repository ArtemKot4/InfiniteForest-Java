package com.artemkot4.infinite_forest.utils;

import com.artemkot4.infinite_forest.InfiniteForest;
import com.zhekasmirnov.apparatus.api.common.Vector3;
import com.zhekasmirnov.innercore.api.NativeBlockModel;
import com.zhekasmirnov.innercore.api.NativeBlockRenderer;
import com.zhekasmirnov.innercore.api.NativeICRender;
import com.zhekasmirnov.innercore.api.NativeRenderMesh;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.RenderMesh;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.common.Texture;

public class FBlock extends Block {
    protected final String id;
    protected final String[] textures;
    protected CreativeCategory category;

    public FBlock(String id, String[] textures) {
          this.id = id;
          this.textures = textures;
    };

    public FBlock(String id) {
        this(id, new String[]{id});
    };

    @Override
    public String[] getTextures() {
        return textures;
    };

    @Override
    public String getId() {
        return id;
    };

    @Override
    public String getName() {
        return "block.infinite_forest." + id;
    };

    public FBlock setCreativeCategory(CreativeCategory category) {
        this.category = category;
        return this;
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return category != null ? category : CreativeCategory.MATERIAL;
    };

    public FBlock setModel(String model, Texture texture, Vector3 scale, Vector3 translate, byte data) {

        final NativeRenderMesh mesh = new NativeRenderMesh();

        mesh.importFromFile(InfiniteForest.DIR + "/resources/assets/models/" + model + ".obj","obj", null);
        mesh.scale(scale.x, scale.y, scale.z);
        mesh.translate(translate.x, translate.y, translate.z);

        mesh.setBlockTexture(texture.texture, texture.meta);

        final NativeICRender.Model render = new NativeICRender.Model();
        render.addEntry(new NativeBlockModel(mesh));
        NativeBlockRenderer.setStaticICRender(getNumId(), data, render);

        return this;
    }
}
