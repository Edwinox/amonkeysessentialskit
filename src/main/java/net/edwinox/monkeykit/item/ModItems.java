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






    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }
}
