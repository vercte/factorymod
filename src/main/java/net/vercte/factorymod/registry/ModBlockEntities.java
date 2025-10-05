package net.vercte.factorymod.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vercte.factorymod.FactoryMod;
import net.vercte.factorymod.content.block.entity.AwesomeBlockEntity;

import java.util.function.Supplier;

@SuppressWarnings("DataFlowIssue")
public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, FactoryMod.ID);

    public static final Supplier<BlockEntityType<AwesomeBlockEntity>> AWESOME_BLOCK = BLOCK_ENTITY_TYPES.register("awesome_block",
            () -> BlockEntityType.Builder.of(AwesomeBlockEntity::new, ModBlocks.AWESOME_BLOCK.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITY_TYPES.register(bus);
    }
}
