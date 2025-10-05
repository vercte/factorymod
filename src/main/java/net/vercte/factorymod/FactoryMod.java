package net.vercte.factorymod;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.vercte.factorymod.registry.ModBlockEntities;
import net.vercte.factorymod.registry.ModBlocks;
import net.vercte.factorymod.registry.ModItems;
import org.slf4j.Logger;

@Mod(FactoryMod.ID)
public class FactoryMod {
    public static final String ID = "factorymod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FactoryMod(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModItems.register(modEventBus);
    }

    @SuppressWarnings("unused")
    public static Logger getLogger() { return LOGGER; }
}
