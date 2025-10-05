package net.vercte.factorymod.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.vercte.factorymod.content.block.entity.AwesomeBlockEntity;
import net.vercte.factorymod.registry.ModBlockEntities;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NonnullDefault;

public class AwesomeBlock extends Block implements EntityBlock {
    public AwesomeBlock(Properties properties) {
        super(properties);
    }

    @Override
    @NonnullDefault
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AwesomeBlockEntity(pos, state);
    }

    @Override
    @NonnullDefault
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return blockEntityType == ModBlockEntities.AWESOME_BLOCK.get() ? AwesomeBlockEntity.getTicker(level, state, blockEntityType) : null;
    }
}
