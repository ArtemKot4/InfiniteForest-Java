package com.artemkot4.infinite_forest.particle.glowworm;

import ru.koshakmine.icstd.level.particle.Particle;

public class Glowworm extends Particle {

    public final String id;
    public final float[] rgba;

    public Glowworm(int r, int g, int b) {
        this.id = "glowworm_" + r + g + b;
        this.rgba = new float[]{r / 256, g / 256, b / 256, 1};
    };

    @Override
    public String getTexture() {
        return "part_color";
    };

    @Override
    public String getId() {
        return id;
    };

    @Override
    public float[] getColor() {
        return rgba;
    };

    @Override
    public int getRenderType() {
        return 2;
    };

    @Override
    public int[] getLifetime() {
        return new int[]{40, 100};
    };

    @Override
    public int[] getSize() {
        return new int[]{1, 3};
    }

    @Override
    public void onInit() {
        //getParticleType().setAnimator("alpha", new ParticleRegistry.ParticleAnimator(0.4, 0.2));
    }

}
