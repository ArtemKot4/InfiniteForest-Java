package com.artemkot4.infinite_forest.utils;

import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.common.Texture;
import ru.koshakmine.icstd.item.event.IOverrideIcon;

import java.util.HashMap;
import java.util.Map;

public class FItem extends Item {
    public static Map<Integer, IItemHand> handFunctions = new HashMap<>();

    private final String id;
    private final Texture texture;
    private final int stack;
    private CreativeCategory category;

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

    public FItem setOnHand(IItemHand lambda) {
         handFunctions.put(this.getNumId(), lambda);
         return this;
    };

    public FItem setTooltype(IOverrideIcon lambda) {
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
    public CreativeCategory getCreativeCategory() {
        return category != null ? category : CreativeCategory.TOOLS;
    }
}
