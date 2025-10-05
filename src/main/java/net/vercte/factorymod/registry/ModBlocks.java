package net.vercte.factorymod.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vercte.factorymod.FactoryMod;
import net.vercte.factorymod.content.block.AwesomeBlock;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FactoryMod.ID);

    public static final DeferredBlock<Block> BLOCK_OF_STATIC_MATERIAL = BLOCKS.registerSimpleBlock("static_material_block");
    public static final DeferredBlock<Block> AWESOME_BLOCK = BLOCKS.register("awesome_block", () -> new AwesomeBlock(BlockBehaviour.Properties.of().explosionResistance(1000)));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
