package net.vercte.factorymod.data.assets;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.vercte.factorymod.FactoryMod;
import net.vercte.factorymod.registry.ModBlocks;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FactoryMod.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleBlockItem(ModBlocks.AWESOME_BLOCK.get());
        simpleBlockItem(ModBlocks.BLOCK_OF_STATIC_MATERIAL.get());
    }
}
