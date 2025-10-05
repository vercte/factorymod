package net.vercte.factorymod.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vercte.factorymod.FactoryMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FactoryMod.ID);

    public static final DeferredItem<BlockItem> BLOCK_OF_STATIC_MATERIAL = ITEMS.registerSimpleBlockItem(ModBlocks.BLOCK_OF_STATIC_MATERIAL);
    public static final DeferredItem<BlockItem> AWESOME_BLOCK = ITEMS.registerSimpleBlockItem(ModBlocks.AWESOME_BLOCK);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
