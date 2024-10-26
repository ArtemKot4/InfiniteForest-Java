package com.artemkot4.infinite_forest.blocks.plants;


import com.zhekasmirnov.innercore.api.constants.ParticleType;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI.Particles;
import ru.koshakmine.icstd.block.IAnimateTicking;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.Position;

public class Fironia extends Plant implements IAnimateTicking {

    public Fironia() {
        super("fironia");

    };

    @Override
    public int getLightLevel() {
        return 5;
    }

    @Override
    public void onAnimateTick(Position pos, BlockData data) {
        Particles.addParticle(ParticleType.flame, (pos.x + 0.5), (pos.y + 0.8), (pos.z + 0.5),
                0, 0.05, 0, 0);
    }
}
