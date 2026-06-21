package net.edwinox.monkeykit.datagen;

import com.tterrag.registrate.providers.ProviderType;
import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.register.client.MonkeyKeys;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@EventBusSubscriber(modid = MonkeyKit.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    // Must run before Registrate's own GatherDataEvent listener so addDataGenerator
    // calls below actually get picked up when providers are generated.
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerRegistrateProviders(GatherDataEvent event) {
        if (!event.getMods().contains(MonkeyKit.MOD_ID)) return;

        DatagenTags.addGenerators();

        MonkeyKit.REG.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;
            MonkeyKeys.provideLang(langConsumer);
        });
    }

    @SubscribeEvent
    public static void gatherdata(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput, lookupProvider));
    }
}