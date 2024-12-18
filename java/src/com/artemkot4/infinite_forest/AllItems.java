package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.items.BlueCrystal;
import com.artemkot4.infinite_forest.items.OrangeCrystal;
import com.artemkot4.infinite_forest.utils.FItem;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;
import ru.koshakmine.icstd.type.CreativeCategory;

public class AllItems {
    public static ObjectFactory factory = Mod.getFactory();

    public static Item BLUE_CRYSTAL = factory.addItem(BlueCrystal::new);
    public static Item ORANGE_CRYSTAL = factory.addItem(OrangeCrystal::new);

    public static Item BLUE_BERRY_CRYSTAL = factory.addItem(() -> new FItem("blue_berry_crystal")
    );

    public static void init() {};
}
