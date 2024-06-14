package earth.terrarium.handcrafted.datagen.provider.server;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.datagen.provider.server.registry.ModPaintingVariantProvider;
import earth.terrarium.handcrafted.common.tags.ModPaintingVariantTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends TagsProvider<PaintingVariant> {

    public ModPaintingVariantTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
        super(output, Registries.PAINTING_VARIANT, completableFuture, Handcrafted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.PRIDE_STEVE.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.BEACH_SUNRISE_MID.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.APPLE.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.SMALL_SAFARI_SUNSET.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.MARIGOLD_MEADOWS.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.AD_ASTRA.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.LOVE_FLOWERS.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.MISTY_MOUNTAINS.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.CORAL_DEPTHS.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.BROKEN_BIRCHES.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.MYSTERIOUS_MANGROVES.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.MY_MAN_DIORITE.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.COOKIES_ON_A_PLATE.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.LAVA_PUDDLES.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.THE_CAT_AND_THE_CUP.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.TERRARIUM.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.GREEN_WOODS.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.SAFARI_SUNSET.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.ROCKY_BEACH.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.MISTY_MOUNTAIN_LEFT_SIDEPANEL.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.MISTY_MOUNTAIN_RIGHT_SIDEPANEL.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.BROKEN_BIRCHES_LEFT_SIDEPANEL.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.BROKEN_BIRCHES_RIGHT_SIDEPANEL.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.FLOWER_IN_THE_DARKNESS.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.DESERT_PLATEAU.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.BEACH_SUNRISE_RIGHT.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.BEACH_SUNRISE_LEFT.location());
        this.tag(ModPaintingVariantTags.PAINTINGS).addOptional(ModPaintingVariantProvider.NIAN_CAT.location());
    }
}
