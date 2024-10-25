package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.blocks.plants.Fironia;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;

public class AllBlocks {
    private static final ObjectFactory factory = Mod.getFactory();
    public static final Block FIRONIA = factory.addBlock(Fironia::new);
}
