package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.blocks.plants.Fironia;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusBark;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusHewn;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusLog;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusPlanks;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;

public class AllBlocks {
    private static final ObjectFactory factory = Mod.getFactory();

    public static final Block FIRONIA = factory.addBlock(Fironia::new);

    public static final Block EucalyptusHewn = factory.addBlock(EucalyptusHewn::new);
    public static final Block EucalyptusBark = factory.addBlock(EucalyptusBark::new);
    public static final Block EucalyptusLog = factory.addBlock(EucalyptusLog::new);
    public static final Block EucalyptusPlanks = factory.addBlock(EucalyptusPlanks::new);

    public static void init() {}
}
