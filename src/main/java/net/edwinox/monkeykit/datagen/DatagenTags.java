package net.edwinox.monkeykit.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.edwinox.monkeykit.register.MonkeyTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import static net.edwinox.monkeykit.MonkeyKit.REG;

@SuppressWarnings("deprecation")
public class DatagenTags {
    public static void addGenerators() {
        REG.addDataGenerator(ProviderType.BLOCK_TAGS, DatagenTags::genBlockTags);
        REG.addDataGenerator(ProviderType.ITEM_TAGS, DatagenTags::genItemTags);
    }
    private static void genItemTags(RegistrateTagsProvider<Item> provIn) {
        var prov = new TagGen.CreateTagsProvider<>(provIn, Item::builtInRegistryHolder);
        for (var tag : MonkeyTags.ItemTags.values()) if (tag.alwaysDatagen) prov.getOrCreateRawBuilder(tag.tag);
    }

    private static void genBlockTags(RegistrateTagsProvider<Block> provIn) {
        TagGen.CreateTagsProvider<Block> prov = new TagGen.CreateTagsProvider<>(provIn, Block::builtInRegistryHolder);

        prov.tag(MonkeyTags.BlockTags.MINEABLE_WITH_DRILL.tag)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_HOE)
                .addTag(BlockTags.SWORD_EFFICIENT)
        ;

        prov.tag(MonkeyTags.BlockTags.EXCAVATION_DRILL_VEIN_LARGE.tag)
                .addTag(MonkeyTags.commonBlockTag("ores"))
        ;
        prov.tag(MonkeyTags.BlockTags.EXCAVATION_DRILL_VEIN_VALID.tag)
                .addTag(MonkeyTags.commonBlockTag("ores"))
        ;

        for (var tag : MonkeyTags.BlockTags.values()) if (tag.alwaysDatagen) prov.getOrCreateRawBuilder(tag.tag);
    }
}