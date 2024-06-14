package earth.terrarium.handcrafted.datagen.provider.base;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.datagen.provider.server.registry.ModPaintingVariantProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModRegistryProvider extends DatapackBuiltinEntriesProvider {

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.PAINTING_VARIANT, ModPaintingVariantProvider::bootstrap);

    public ModRegistryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Handcrafted.MOD_ID));
    }
}
