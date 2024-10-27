package com.artemkot4.infinite_forest.blocks.plants;

import com.artemkot4.infinite_forest.utils.FBlock;
import ru.koshakmine.icstd.block.RandomTickingComponent;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.item.event.ClickableComponent;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.common.*;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public abstract class Bush extends Plant implements ClickableComponent, RandomTickingComponent {

    public final String berry;
    public final String textureLast;

    abstract int getCount();

    public int getGrowChance() {
        return 1;
    };

    public String[] getStageTextures() {
          return new String[]{
                  "sweet_berry_bush_stage0",
                  "sweet_berry_bush_stage1",
                  "sweet_berry_bush_stage2",
                  textureLast
          };
    };

    public int getMaxStage() {
        return getStageTextures().length;
    }

    public Bush(String id, String texture, String berry) {
        super(id);
        this.berry = berry;
        this.textureLast = texture;
    };

    public Bush(String id, String berry) {
        this(id, id, berry);
    }

    @Override
    public void onInit() {
        String[] textures = Arrays.copyOfRange(getStageTextures(), 1, getStageTextures().length - 1);

        for(String item : textures) {

            addVariant(getName(), new String[]{item});

        }

        Item.registerClick(ItemID.getModId(berry), (pos, stack, data, player) -> {

            Level level = player.getRegion();

            if(isPlaceBlockAt(pos.x, pos.y, pos.z, level)) {

                level.setBlock((int)pos.x, (int)pos.y + 1, (int)pos.z, getNumId(), 0);

                player.setCarriedItem(stack.decrease(1));
            };

        });

    };

    @Override
    public void onClick(BlockPosition pos, ItemStack stack, BlockData data, Player player) {

        if(data.data >= getMaxStage()) {

          Level level = player.getRegion();

          level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, data.id, 0);

          level.spawnDroppedItem(
                  pos,
                  new ItemStack(ItemID.getModId(berry),
                  new Random().nextInt(getCount()) + 1,
                  0)
          );

        };

    };

    @Override
    public void onRandomTick(Position pos, BlockData data, Level level) {

           if(Math.random() < getGrowChance() && data.data < getMaxStage()) {

                 level.setBlock((int)pos.x, (int)pos.y, (int)pos.z, data.id, data.data + 1);
           }
    };

    @Override
    public String[] getTextures() {
        return new String[]{getStageTextures()[0]};
    }

}
