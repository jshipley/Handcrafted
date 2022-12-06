package earth.terrarium.handcrafted.block.chair.couch;

import earth.terrarium.handcrafted.block.chair.CushionBenchBlockEntity;
import earth.terrarium.handcrafted.registry.ModBlockEntities;
import earth.terrarium.handcrafted.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CouchBlockEntity extends CushionBenchBlockEntity {
    public CouchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COUCH.get(), blockPos, blockState);
        this.setCushion(ModItems.WHITE_CUSHION.get().getDefaultInstance());
    }
}