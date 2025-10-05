package net.vercte.factorymod.content.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.lwjgl.system.NonnullDefault;

public abstract class SimpleTickingBlockEntity extends BlockEntity {
    public SimpleTickingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @NonnullDefault
    @SuppressWarnings("unused")
    public static <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return ((l, p, s, be) -> ((SimpleTickingBlockEntity)be).tick(l, p, s));
    }

    public abstract void tick(Level level, BlockPos pos, BlockState state);
}
