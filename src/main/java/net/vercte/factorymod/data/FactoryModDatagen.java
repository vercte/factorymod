package net.vercte.factorymod.data;

import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.vercte.factorymod.data.assets.LangGen;

@EventBusSubscriber
public class FactoryModDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        PackOutput output = event.getGenerator().getPackOutput();

        if(event.includeClient()) {
            event.addProvider(new LangGen(output));
        }
    }
}
