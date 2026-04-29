package net.edwinox.monkeykit.item;

import net.edwinox.monkeykit.MonkeyKit;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MonkeyKit.MODID);

    public static final DeferredItem<Item> COPPERKRONA = ITEMS.register("copper_krona",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVERKRONA = ITEMS.register("silver_krona",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GOLDKRONA = ITEMS.register("gold_krona",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));
    public static final DeferredItem<Item> BANANAPULP = ITEMS.register("banana_pulp",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANAPULP)));
    public static final DeferredItem<Item> BANANAPULPDUST = ITEMS.register("banana_pulp_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BANANAPEEL = ITEMS.register("banana_peel",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }
}
