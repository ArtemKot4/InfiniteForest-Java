package com.artemkot4.infinite_forest.utils;

import com.zhekasmirnov.innercore.api.NativeBlockModel;
import com.zhekasmirnov.innercore.api.NativeBlockRenderer;
import com.zhekasmirnov.innercore.api.NativeICRender;
import com.zhekasmirnov.innercore.api.NativeItem;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.type.CreativeCategory;

public class FBlock extends Block {
    protected final String id;
    protected final String[] textures;
    protected CreativeCategory category = CreativeCategory.NONE;

    public FBlock(String id, String[] textures) {
          this.id = id;
          this.textures = textures;
    };

    public FBlock(String id, String texture) {
        this.id = id;
        this.textures = new String[]{texture};
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

    public FBlock setModel(BlockModel model) {

        final NativeICRender.Model render = new NativeICRender.Model();

        render.addEntry(new NativeBlockModel(model.getRenderMesh()));
        NativeBlockRenderer.setStaticICRender(getNumId(), model.getBlockData(), render);

        return this;
    };

    @Override
    public void onInit() {

        if(this instanceof IBlockModelSetter) {

            final BlockModel model = ((IBlockModelSetter) this).getBlockModel();

            setModel(model);

        };

        if (category != null) {

            NativeItem.addToCreative(this.getNumId(), 1, 0, (Object)null);
            NativeItem.setCategoryForId(this.getNumId(), category.ordinal());

        }
    }
}
