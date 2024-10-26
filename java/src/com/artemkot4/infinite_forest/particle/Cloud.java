package com.artemkot4.infinite_forest.particle;

import com.zhekasmirnov.innercore.api.particles.ParticleRegistry;
import ru.koshakmine.icstd.level.particle.Particle;

public class Cloud extends Particle {
    public static final String id = "cloud";

    @Override
    public String getTexture() {
        return "flame";
    };

    @Override
    public String getId() {
        return id;
    }

    @Override
    public float[] getColor() {
        return new float[]{125/256, 125/256, 125/256, 1};
    };

    @Override
    public int getRenderType() {
        return 2;
    };

    @Override
    public int[] getLifetime() {
        return new int[]{30, 40};
    };

    @Override
    public int[] getSize() {
        return new int[]{6, 9};
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
                        0.5f,
                        0f,
                        0.4f,
                        0f)
        );
    }
}