package net.edwinox.monkeykit.datagen;

import net.edwinox.monkeykit.MonkeyKit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MonkeyKit.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
      @SubscribeEvent
      public static void gatherdata(GatherDataEvent event) {
          DataGenerator generator = event.getGenerator();
          PackOutput packOutput = generator.getPackOutput();
          ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
          CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

          generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput, lookupProvider));
    }
}
