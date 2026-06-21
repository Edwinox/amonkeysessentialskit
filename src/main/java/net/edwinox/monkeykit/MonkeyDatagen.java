package net.edwinox.monkeykit;

import com.google.gson.JsonElement;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.register.client.MonkeyKeys;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static net.edwinox.monkeykit.MonkeyKit.MOD_ID;

public class MonkeyDatagen {
    public static void gatherDataHighPriority(GatherDataEvent event) {
        if (event.getMods().contains(MOD_ID)) addExtraRegistrateData();
    }

    @SuppressWarnings("all")
    public static void gatherData(GatherDataEvent event) {
        if (!event.getMods().contains(MOD_ID)) return;
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();;
    }


    private static void addExtraRegistrateData() {
        net.edwinox.monkeykit.datagen.DatagenTags.addGenerators();
        MonkeyKit.REG.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;

            //provideDefaultLang("interface", langConsumer);*
            //provideDefaultLang("tooltips", langConsumer);*
            MonkeyKeys.provideLang(langConsumer);
        });
    }

    @SuppressWarnings("unused")
    private static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
        var path = "assets/"+ MOD_ID +"/lang/default/" + fileName + ".json";
        var jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) consumer.accept(entry.getKey(), entry.getValue().getAsString());
    }
}