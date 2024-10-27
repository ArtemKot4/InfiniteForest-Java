package com.artemkot4.infinite_forest.blocks.blockentity.bottle;

import com.artemkot4.infinite_forest.AllParticles;
import com.artemkot4.infinite_forest.InfiniteForest;
import com.artemkot4.infinite_forest.dimension.Forest;
import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.block.blockentity.BlockEntityLocal;
import ru.koshakmine.icstd.block.blockentity.ticking.TickingBlockEntityComponent;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.level.particle.Particle;
import ru.koshakmine.icstd.type.common.Position;

public class FirefliesBottleLocalBlockEntity extends BlockEntityLocal implements TickingBlockEntityComponent {

    FirefliesBottleLocalBlockEntity(String type, int id, Position position, NetworkEntity network, JSONObject data) throws JSONException {
        super(type, id, position, network, data);
    };

    @Override
    public void onTick() {
         int color = networkData.getInt("color", AllParticles.YELLOW_GLOWWORM.getNumId());

         Level level = Level.getForDimension(Forest.getId());

         if(level == null) {
             return;
         };

         if(level.getTime() % 20 == 0) {

             Position pos = new Position(position.x + 0.5f,position.y + 0.4f,position.z + 0.5f);
             Position vec = new Position(0.001f,0.001f,0.001f);

             level.spawnParticle(
                     Particle.getParticleById(color), pos, vec );
         }
    }

}
