package com.artemkot4.infinite_forest;

import com.artemkot4.infinite_forest.particle.Cloud;
import com.artemkot4.infinite_forest.particle.Rain;
import com.artemkot4.infinite_forest.particle.Snowflake;
import com.artemkot4.infinite_forest.particle.glowworm.*;
import ru.koshakmine.icstd.level.particle.Particle;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;

import java.util.concurrent.ThreadLocalRandom;

public class AllParticles {
    public static ObjectFactory factory = Mod.getFactory();

    public static final Particle YELLOW_GLOWWORM = factory.addParticle(YellowGlowworm::new);
    public static final Particle LIGHT_BLUE_GLOWWORM = factory.addParticle(LightBlueGlowworm::new);
    public static final Particle DARK_GREEN_GLOWWORM = factory.addParticle(DarkGreenGlowworm::new);
    public static final Particle GREEN_GLOWWORM = factory.addParticle(GreenGlowworm::new);
    public static final Particle GOLDEN_GLOWWORM = factory.addParticle(GoldenGlowworm::new);
    public static final Particle RED_GLOWWORM = factory.addParticle(RedGlowworm::new);

    public static final Particle CLOUD = factory.addParticle(Cloud::new);
    public static final Particle RAIN = factory.addParticle(Rain::new);
    public static final Particle SNOWFLAKE = factory.addParticle(Snowflake::new);

    public static void init() {}

    public static Particle[] glowwormList = new Particle[]{
            YELLOW_GLOWWORM,
            LIGHT_BLUE_GLOWWORM,
            DARK_GREEN_GLOWWORM,
            GREEN_GLOWWORM,
            GOLDEN_GLOWWORM,
            RED_GLOWWORM
    };

    public static Particle getRandomGlowworm() {
        int random = ThreadLocalRandom.current().nextInt(glowwormList.length-1);
        return glowwormList[random];
    };
}
