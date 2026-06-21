package net.edwinox.monkeykit.register;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.item.custom.DrillItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;
import static net.edwinox.monkeykit.MonkeyKit.REG;

public class MonkeyItems {

    public static final ItemEntry<DrillItem> DRILL = REG.item("drill", p -> new DrillItem(Tiers.DIAMOND, p))
            .properties(p -> p.attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 1.0F, 1.0F)))
            .model(AssetLookup.itemModelWithPartials())
            .recipe((c, p) -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, c.get(), 1)
                    .pattern("BGA")
                    .pattern("CA ")
                    .define('A', AllItems.ANDESITE_ALLOY)
                    .define('B', MonkeyTags.commonItemTag("ingots/brass"))
                    .define('G', AllBlocks.COGWHEEL.get())
                    .define('C', AllBlocks.BRASS_CASING.get())
                    .unlockedBy("has_" + c.getName(), has(c.get()))
                    .save(p, MonkeyKit.loc("crafting/" + c.getName())))
            .tag(ItemTags.MINING_ENCHANTABLE, ItemTags.MINING_LOOT_ENCHANTABLE, ItemTags.DURABILITY_ENCHANTABLE, ItemTags.BREAKS_DECORATED_POTS, Tags.Items.TOOLS)
            .register();


    protected static String getItemName(ItemLike pItemLike) {
        return BuiltInRegistries.ITEM.getKey(pItemLike.asItem()).getPath();
    }

    public static void register() {}
}