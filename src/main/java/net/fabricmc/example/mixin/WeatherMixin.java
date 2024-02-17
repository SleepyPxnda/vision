package net.fabricmc.example.mixin;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Supplier;

@Mixin(ClientWorld.class)
public abstract class WeatherMixin extends World {

    private static boolean disableWeather = true;

    private WeatherMixin(MutableWorldProperties properties,
                         RegistryKey<World> registryRef,
                         DynamicRegistryManager registryManager,
                         RegistryEntry<DimensionType> dimensionEntry,
                         Supplier<Profiler> profiler,
                         boolean isClient,
                         boolean debugWorld,
                         long biomeAccess,
                         int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    @Override
    public float getRainGradient(float delta) {
        return disableWeather ? 0 : super.getRainGradient(delta);
    }

    @Override
    public float getThunderGradient(float delta) {
        return disableWeather ? 0 : super.getThunderGradient(delta);
    }
}
