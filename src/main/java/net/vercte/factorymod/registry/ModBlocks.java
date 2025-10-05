package net.vercte.factorymod.registry;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vercte.factorymod.FactoryMod;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FactoryMod.ID);

    public static final DeferredBlock<Block> BLOCK_OF_STATIC_MATERIAL = BLOCKS.registerSimpleBlock("static_material_block");
    public static final DeferredBlock<Block> AWESOME_BLOCK = BLOCKS.registerSimpleBlock("awesome_block");

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
