package net.vercte.factorymod.content.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.vercte.factorymod.registry.ModBlockEntities;

public class AwesomeBlockEntity extends SimpleTickingBlockEntity {
    int ticksLeft = 20;

    public AwesomeBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.AWESOME_BLOCK.get(), pos, blockState);
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state) {
        if(level.isClientSide()) return;

        ticksLeft -= 1;
        if(ticksLeft <= 0) {
            level.removeBlock(pos, false);
            level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 8, Level.ExplosionInteraction.BLOCK);
        }
    }
}
