package net.vercte.factorymod.data.assets;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.vercte.factorymod.FactoryMod;
import net.vercte.factorymod.registry.ModBlocks;

public class BlockModelGen extends BlockStateProvider {
    public BlockModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FactoryMod.ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.AWESOME_BLOCK.get());
        simpleBlock(ModBlocks.BLOCK_OF_STATIC_MATERIAL.get());
    }
}
