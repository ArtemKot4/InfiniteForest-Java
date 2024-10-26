package com.artemkot4.infinite_forest.utils;

import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.RenderMesh;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.type.CreativeCategory;

public class FBlock extends Block {
    private final String id;
    private final String[] textures;
    private CreativeCategory category;

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

    public void setModel() {
        RenderMesh mesh = new RenderMesh();
        //mesh.importFromFile(dir? + "/resources/assets/models/" + obj.model + ".obj");
    }
}
