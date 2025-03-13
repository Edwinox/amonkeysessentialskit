package net.edwinox.monkeykit.villager;

import com.google.common.collect.ImmutableSet;
import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.block.ModBlocks;
import net.edwinox.monkeykit.sound.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, MonkeyKit.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, MonkeyKit.MODID);

    public static final Holder<PoiType> MONKEY_POI = POI_TYPES.register("monkey_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.BANANA_CRATE.get().getStateDefinition().getPossibleStates()),1,1));

    public static final Holder<VillagerProfession> GORILLAGER = VILLAGER_PROFESSIONS.register("gorillager",
            () -> new VillagerProfession("gorillager", holder -> holder.value() == MONKEY_POI.value(),
                        poiTypeHolder -> poiTypeHolder.value() == MONKEY_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                        ModSounds.GORILLAGER_NOISE.get()));

    public static void register (IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
