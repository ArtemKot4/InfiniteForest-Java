package com.artemkot4.infinite_forest.utils;

import ru.koshakmine.icstd.block.Block;

public class FBlock extends Block {
    private final String id;
    private final String[] textures;


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
    }
}
