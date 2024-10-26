package com.artemkot4.infinite_forest.particle;

import com.zhekasmirnov.innercore.api.particles.ParticleRegistry;
import ru.koshakmine.icstd.level.particle.Particle;

public class Rain extends Particle {
    public static final String id = "green_rain";

    @Override
    public String getTexture() {
        return "weather";
    };

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getRenderType() {
        return 2;
    };

    @Override
    public int[] getLifetime() {
        return new int[]{80, 100};
    };

    @Override
    public int[] getSize() {
        return new int[]{3, 4};
    }


    @Override
    public void onInit() {
        getParticleType().setAnimator("alpha",
                new ParticleRegistry.ParticleAnimator(
                        -1,
                        0.4f,
                        0f,
                        0.4f,
                        0f)
        );

        getParticleType().setAnimator("size",
                new ParticleRegistry.ParticleAnimator(
                        -1,
                        0f,
                        1f,
                        0f,
                        0f)
        );
    }
}
