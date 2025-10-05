package net.vercte.factorymod.data.assets;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.vercte.factorymod.FactoryMod;
import net.vercte.factorymod.registry.ModBlocks;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.system.NonnullDefault;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LangGen extends LanguageProvider {
    private final List<String> keysRegistered = new ArrayList<>();

    public LangGen(PackOutput output) {
        super(output, FactoryMod.ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(ModBlocks.BLOCK_OF_STATIC_MATERIAL, "Block of Static Material");

        // scan blocks registry and generate names
        BuiltInRegistries.BLOCK.stream()
                .filter(b -> BuiltInRegistries.BLOCK.getKey(b).getNamespace().equals(FactoryMod.ID))
                .filter(b -> keyIsNotRegistered(b.getDescriptionId()))
                .forEach(b -> {
                    String name = generateName(() -> b, Registries.BLOCK);
                    addBlock(() -> b, name);
                });

        // and then that, with items
        BuiltInRegistries.ITEM.stream()
                .filter(i -> BuiltInRegistries.ITEM.getKey(i).getNamespace().equals(FactoryMod.ID))
                .filter(i -> keyIsNotRegistered(i.getDescriptionId()))
                .forEach(i -> {
                    String name = generateName(() -> i, Registries.ITEM);
                    addItem(() -> i, name);
                });
    }

    @Override
    @NonnullDefault
    public void add(String key, String value) {
        keysRegistered.add(key);
        super.add(key, value);
    }

    protected boolean keyIsNotRegistered(String key) {
        return !keysRegistered.contains(key);
    }

    @SuppressWarnings("unchecked")
    protected <R, T extends R> String generateName(Supplier<T> object, ResourceKey<? extends Registry<R>> registryKey) {
        Registry<R> registry = (Registry<R>) BuiltInRegistries.REGISTRY.get(registryKey.location());
        assert registry != null;

        ResourceLocation location = registry.getKey(object.get());
        assert location != null;

        // I took this from Registrate. Thank you Registrate
        String[] nameElements = location.getPath()
                .toLowerCase(Locale.ROOT)
                .split("_");
        return Arrays.stream(nameElements)
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(" "));
    }
}
