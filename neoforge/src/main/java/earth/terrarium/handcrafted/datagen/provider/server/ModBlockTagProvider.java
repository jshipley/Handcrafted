package earth.terrarium.handcrafted.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.blocks.trims.CornerTrimBlock;
import earth.terrarium.handcrafted.common.blocks.trims.PillarTrimBlock;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import earth.terrarium.handcrafted.common.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends TagsProvider<Block> {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
        super(output, Registries.BLOCK, completableFuture, Handcrafted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        addMineableTags();
        ModBlocks.FANCY_BEDS.stream().forEach(b -> tag(BlockTags.BEDS).add(TagEntry.element(b.getId())));

        ModBlocks.TABLES.stream().forEach(b -> tag(ModBlockTags.TABLE_CONNECTABLE).add(TagEntry.element(b.getId())));
        ModBlocks.DESKS.stream().forEach(b -> tag(ModBlockTags.TABLE_CONNECTABLE).add(TagEntry.element(b.getId())));
        ModBlocks.NIGHTSTANDS.stream().forEach(b -> tag(ModBlockTags.TABLE_CONNECTABLE).add(TagEntry.element(b.getId())));

        addSet(ModBlocks.CUSHIONS, "cushions");
        addSet(ModBlocks.BENCHES, "benches");
        addSet(ModBlocks.WOODEN_BENCHES, "wooden_benches");
        addSet(ModBlocks.METAL_BENCHES, "metal_benches");
        addSet(ModBlocks.COUCHES, "couches");
        addSet(ModBlocks.CHAIRS, "chairs");
        addSet(ModBlocks.DINING_BENCHES, "dining_benches");
        addSet(ModBlocks.SIDE_TABLES, "side_tables");
        addSet(ModBlocks.DESKS, "desks");
        addSet(ModBlocks.NIGHTSTANDS, "nightstands");
        addSet(ModBlocks.TABLES, "tables");
        addSet(ModBlocks.FANCY_BEDS, "fancy_beds");
        addSet(ModBlocks.COUNTERS, "counters");
        addSet(ModBlocks.CUPBOARDS, "cupboards");
        addSet(ModBlocks.DRAWERS, "drawers");
        addSet(ModBlocks.SHELVES, "shelves");
        addSet(ModBlocks.POTS, "pots");
        addSet(ModBlocks.TRIMS, "trims");
        addSet(ModBlocks.PILLAR_TRIMS, "pillar_trims");
        addSet(ModBlocks.CORNER_TRIMS, "corner_trims");
        addSet(ModBlocks.TROPHIES, "trophies");
        addSet(ModBlocks.WALL_TROPHIES, "wall_trophies");
        addSet(ModBlocks.HANGING_TROPHIES, "hanging_trophies");
        addSet(ModBlocks.STATUE_TROPHIES, "statue_trophies");
        addSet(ModBlocks.CROCKERY, "crockery");
        addSet(ModBlocks.CUPS, "cups");
        addSet(ModBlocks.PLATES, "plates");
        addSet(ModBlocks.BOWLS, "bowls");
        addSet(ModBlocks.CROCKERY_COMBOS, "crockery_combos");

        tag(Tags.Blocks.DYED_BLACK).add(TagEntry.element(ModBlocks.BLACK_CUSHION.getId()));
        tag(Tags.Blocks.DYED_BLUE).add(TagEntry.element(ModBlocks.BLUE_CUSHION.getId()));
        tag(Tags.Blocks.DYED_BROWN).add(TagEntry.element(ModBlocks.BROWN_CUSHION.getId()));
        tag(Tags.Blocks.DYED_CYAN).add(TagEntry.element(ModBlocks.CYAN_CUSHION.getId()));
        tag(Tags.Blocks.DYED_GRAY).add(TagEntry.element(ModBlocks.GRAY_CUSHION.getId()));
        tag(Tags.Blocks.DYED_GREEN).add(TagEntry.element(ModBlocks.GREEN_CUSHION.getId()));
        tag(Tags.Blocks.DYED_LIGHT_BLUE).add(TagEntry.element(ModBlocks.LIGHT_BLUE_CUSHION.getId()));
        tag(Tags.Blocks.DYED_LIGHT_GRAY).add(TagEntry.element(ModBlocks.LIGHT_GRAY_CUSHION.getId()));
        tag(Tags.Blocks.DYED_LIME).add(TagEntry.element(ModBlocks.LIME_CUSHION.getId()));
        tag(Tags.Blocks.DYED_MAGENTA).add(TagEntry.element(ModBlocks.MAGENTA_CUSHION.getId()));
        tag(Tags.Blocks.DYED_ORANGE).add(TagEntry.element(ModBlocks.ORANGE_CUSHION.getId()));
        tag(Tags.Blocks.DYED_PINK).add(TagEntry.element(ModBlocks.PINK_CUSHION.getId()));
        tag(Tags.Blocks.DYED_PURPLE).add(TagEntry.element(ModBlocks.PURPLE_CUSHION.getId()));
        tag(Tags.Blocks.DYED_RED).add(TagEntry.element(ModBlocks.RED_CUSHION.getId()));
        tag(Tags.Blocks.DYED_WHITE).add(TagEntry.element(ModBlocks.WHITE_CUSHION.getId()));
        tag(Tags.Blocks.DYED_YELLOW).add(TagEntry.element(ModBlocks.YELLOW_CUSHION.getId()));

        tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("farmersdelight", "heat_sources"))).add(TagEntry.element(ModBlocks.OVEN.getId()));
    }

    private void addMineableTags() {
        addPickaxe(ModBlocks.BERRY_JAM_JAR);
        addPickaxe(ModBlocks.OVEN);
        addPickaxe(ModBlocks.KITCHEN_HOOD);
        addPickaxe(ModBlocks.KITCHEN_HOOD_PIPE);

        ModBlocks.CORNER_TRIMS.stream()
            .forEach(b -> tag(((CornerTrimBlock) b.get()).isWood() ?
                BlockTags.MINEABLE_WITH_AXE :
                BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TagEntry.element(b.getId())));
        ModBlocks.PILLAR_TRIMS.stream()
            .forEach(b -> tag(((PillarTrimBlock) b.get()).isWood() ?
                BlockTags.MINEABLE_WITH_AXE :
                BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TagEntry.element(b.getId())));

        addAxe(ModBlocks.WOODEN_BENCHES);
        addPickaxe(ModBlocks.METAL_BENCHES);
        addAxe(ModBlocks.COUCHES);
        addAxe(ModBlocks.CHAIRS);
        addAxe(ModBlocks.DINING_BENCHES);
        addAxe(ModBlocks.SIDE_TABLES);
        addAxe(ModBlocks.DESKS);
        addAxe(ModBlocks.NIGHTSTANDS);
        addAxe(ModBlocks.TABLES);
        addAxe(ModBlocks.FANCY_BEDS);
        addAxe(ModBlocks.COUNTERS);
        addAxe(ModBlocks.CUPBOARDS);
        addAxe(ModBlocks.DRAWERS);
        addAxe(ModBlocks.SHELVES);
        addPickaxe(ModBlocks.POTS);
        addAxe(ModBlocks.WALL_TROPHIES);
        addAxe(ModBlocks.HANGING_TROPHIES);
        addPickaxe(ModBlocks.STATUE_TROPHIES);
        addPickaxe(ModBlocks.CROCKERY);
    }

    private void addSet(ResourcefulRegistry<Block> registry, String name) {
        registry.stream().forEach(b -> tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Handcrafted.MOD_ID, name))).add(TagEntry.element(b.getId())));
    }

    private void addPickaxe(ResourcefulRegistry<Block> registry) {
        registry.stream().forEach(this::addPickaxe);
    }

    private void addAxe(ResourcefulRegistry<Block> registry) {
        registry.stream().forEach(this::addAxe);
    }

    private void addPickaxe(RegistryEntry<Block> block) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TagEntry.element(block.getId()));
    }

    private void addAxe(RegistryEntry<Block> block) {
        tag(BlockTags.MINEABLE_WITH_AXE).add(TagEntry.element(block.getId()));
    }
}
