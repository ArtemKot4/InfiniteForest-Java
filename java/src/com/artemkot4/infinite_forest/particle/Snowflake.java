package com.artemkot4.infinite_forest.particle;

import com.zhekasmirnov.innercore.api.particles.ParticleRegistry;
import ru.koshakmine.icstd.level.particle.Particle;

public class Snowflake extends Particle {
    public static final String id = "snowflake";

    @Override
    public String getTexture() {
        return id;
    };

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getRenderType() {
        return 1;
    };

    @Override
    public int[] getLifetime() {
        return new int[]{120, 180};
    };

    @Override
    public int[] getSize() {
        return new int[]{(int)0.5, 1};
    }


    @Override
    public void onInit() {
        getParticleType().setAnimator("alpha",
                new ParticleRegistry.ParticleAnimator(
                        -1,
                        1f,
                        0.5f,
                        0.5f,
                        0.1f)
        );

        getParticleType().setAnimator("size",
                new ParticleRegistry.ParticleAnimator(-1, 0.4f, 1f, 0f, 0f));

    }
}
