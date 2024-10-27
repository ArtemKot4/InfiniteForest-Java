package com.artemkot4.infinite_forest.utils;

import com.zhekasmirnov.innercore.api.NativeItem;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.item.event.OverrideIconComponent;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.common.Texture;
import java.util.HashMap;
import java.util.Map;

public class FItem extends Item {
    public static Map<Integer, HandItemComponent> handFunctions = new HashMap<>();

    private final String id;
    private final Texture texture;
    private final int stack;
    private CreativeCategory category = CreativeCategory.NONE;

    public FItem(String id, Texture texture, int stack) {
        this.id = id;
        this.texture = texture;
        this.stack = stack;
    };

    public FItem(String id, Texture texture) {
        this(id, texture, 64);
    };

    public FItem(String id) {
        this(id, new Texture(id, 0), 64);
    };

    public FItem setOnHand(HandItemComponent lambda) {
         handFunctions.put(this.getNumId(), lambda);
         return this;
    };

    public FItem setTooltype(OverrideIconComponent lambda) {
        Item.registerOverrideIcon(this.getNumId(), lambda);
        return this;
    };


    public int getMaxStack() {
        return this.stack;
    };

    public FItem setCreativeCategory(CreativeCategory category) {
        this.category = category;
        return this;
    }


    @Override
    public Texture getTexture() {
        return texture;
    };

    @Override
    public String getId() {
        return id;
    };

    @Override
    public String getName() {
        return "item.infinite_forest." + id;
    }

    @Override
    public void onInit() {
          if(this instanceof HandItemComponent) {
              handFunctions.put(getNumId(), (HandItemComponent) this);

          };

          if (category != null) {
              NativeItem.addToCreative(getNumId(), 1, 0, (Object)null);

              getItem().setCreativeCategory(category.ordinal());
          }

    }
}
