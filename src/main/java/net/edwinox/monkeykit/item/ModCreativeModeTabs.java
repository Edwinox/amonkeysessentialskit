package net.edwinox.monkeykit.item;

import net.edwinox.monkeykit.MonkeyKit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonkeyKit.MODID);

public static final Supplier<CreativeModeTab> MONKEYKIT_ITEMS_TAB = CREATIVE_MODE_TAB.register("monkeykit_items_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPERKRONA.get()))
            .title(Component.translatable("creativetab.monkeykit.monkeykit_items"))
                .displayItems((itemDisplayParameters, output) -> {
                     output.accept(ModItems.COPPERKRONA);
                     output.accept(ModItems.SILVERKRONA);
                     output.accept(ModItems.GOLDKRONA);
                }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
