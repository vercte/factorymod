package net.vercte.factorymod.data;

import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.vercte.factorymod.data.assets.BlockModelGen;
import net.vercte.factorymod.data.assets.ItemModelGen;
import net.vercte.factorymod.data.assets.LangGen;

@EventBusSubscriber
public class FactoryModDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if(event.includeClient()) {
            event.addProvider(new BlockModelGen(output, existingFileHelper));
            event.addProvider(new ItemModelGen(output, existingFileHelper));
            event.addProvider(new LangGen(output));
        }
    }
}
