package net.edwinox.monkeykit;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.edwinox.monkeykit.block.ModBlocks;
import net.edwinox.monkeykit.item.ModCreativeModeTabs;
import net.edwinox.monkeykit.item.ModItems;
import net.edwinox.monkeykit.loot.ModLootModifiers;
import net.edwinox.monkeykit.register.MonkeyItems;
import net.edwinox.monkeykit.register.MonkeyPackets;
import net.edwinox.monkeykit.register.MonkeyTags;
import net.edwinox.monkeykit.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MonkeyKit.MOD_ID)
public class MonkeyKit
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "monkeykit";
    public static final String NAME = "MonkeyKit";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public static CreateRegistrate REG = CreateRegistrate.create(MOD_ID);


    public MonkeyKit(IEventBus modEventBus, ModContainer modContainer)

    {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModSounds.register(modEventBus);

        MonkeyItems.register();

        REG.registerEventListeners(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        MonkeyTags.init();

        MonkeyPackets.register();


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }
    public static ResourceLocation loc(String loc) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, loc);
    }
    public static ResourceLocation emptyLoc() {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "empty");
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}