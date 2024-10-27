package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.blocks.blockentity.Cauldron;
import com.artemkot4.infinite_forest.blocks.blockentity.bottle.EmptyBottle;
import com.artemkot4.infinite_forest.blocks.blockentity.bottle.FirefliesBottle;
import com.artemkot4.infinite_forest.blocks.plants.Fironia;
import com.artemkot4.infinite_forest.blocks.plants.IceFlower;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusBark;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusHewn;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusLog;
import com.artemkot4.infinite_forest.blocks.wood.eucalyptus.EucalyptusPlanks;
import com.artemkot4.infinite_forest.blocks.wood.pink.PinkHewn;
import com.artemkot4.infinite_forest.blocks.wood.pink.PinkBark;
import com.artemkot4.infinite_forest.blocks.wood.pink.PinkLog;
import com.artemkot4.infinite_forest.blocks.wood.pink.PinkPlanks;
import com.artemkot4.infinite_forest.blocks.wood.winter.WinterHewn;
import com.artemkot4.infinite_forest.blocks.wood.winter.WinterLog;
import com.artemkot4.infinite_forest.blocks.wood.winter.WinterPlanks;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;

public class AllBlocks {
    private static final ObjectFactory factory = Mod.getFactory();

    public static final Block FIRONIA = factory.addBlock(Fironia::new);
    public static final Block ICE_FLOWER = factory.addBlock(IceFlower::new);

    public static final Block EucalyptusLog = factory.addBlock(EucalyptusLog::new);
    public static final Block EucalyptusHewn = factory.addBlock(EucalyptusHewn::new);
    public static final Block EucalyptusBark = factory.addBlock(EucalyptusBark::new);
    public static final Block EucalyptusPlanks = factory.addBlock(EucalyptusPlanks::new);

    public static final Block PinkLog = factory.addBlock(PinkLog::new);
    public static final Block PinkHewn = factory.addBlock(PinkHewn::new);
    public static final Block PinkBark = factory.addBlock(PinkBark::new);
    public static final Block PinkPlanks = factory.addBlock(PinkPlanks::new);

    public static final Block WinterLog = factory.addBlock(WinterLog::new);
    public static final Block WinterHewn = factory.addBlock(WinterHewn::new);
    public static final Block WinterPlanks = factory.addBlock(WinterPlanks::new);

    public static final Block CAULDRON = factory.addBlock(Cauldron::new);

    public static final Block EMPTY_BOTTLE = factory.addBlock(EmptyBottle::new);
    public static final Block FIREFLIES_BOTTLE = factory.addBlock(FirefliesBottle::new);

    public static void init() {}
}
