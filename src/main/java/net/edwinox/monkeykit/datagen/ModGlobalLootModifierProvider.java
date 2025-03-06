package net.edwinox.monkeykit.datagen;

import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.item.ModItems;
import net.edwinox.monkeykit.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, MonkeyKit.MODID);
    }

    @Override
    protected void start() {
        this.add("copper_krona_from_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_zombie",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_skeleton",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/skeleton")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_husk",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/husk")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_stray",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/stray")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_wither_skeleton",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/wither_skeleton")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_zombified_piglin",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombified_piglin")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_stray",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/stray")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_zombie_villager",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie_villager")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_slime",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/slime")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_drowned",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/drowned")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_guardian",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/guardian")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_bogged",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/bogged")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_pillager",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/pillager")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_vindicator",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/vindicator")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_witch",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/witch")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_spider",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/spider")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_cave_spider",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/cave_spider")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_verdant",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("variantsandventures/entities/verdant")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_thicket",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("variantsandventures/entities/thicket")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_murk",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("variantsandventures/entities/murk")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_gelid",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("variantsandventures/entities/gelid")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_jungle_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/jungle_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_bamboo_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/bamboo_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_desert_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/desert_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_badlands_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/badlands_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_hills_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/hills_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_savannah_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/savannah_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_mushroom_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/mushroom_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_swamp_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/swamp_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_dripstone_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/dripstone_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_cave_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/cave_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_dark_oak_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/dark_oak_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_spruce_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/spruce_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_beach_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/beach_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_snowy_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/snowy_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_ocean_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/ocean_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));

        this.add("copper_krona_from_birch_creeper",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("creeperoverhaul/entities/birch_creeper")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build()
                }, ModItems.COPPERKRONA.get()));
    }
}
