package com.artemkot4.infinite_forest.utils;

import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.type.common.ItemStack;

public interface IItemHand {
    public void init(Player player, ItemStack stack);
}