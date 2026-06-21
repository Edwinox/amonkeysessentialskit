package net.edwinox.monkeykit.sound;

import net.edwinox.monkeykit.MonkeyKit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MonkeyKit.MOD_ID);

    public static final Supplier<SoundEvent> DRILL_SPIN = registerSoundEvent("drill_spin");
    public static final Supplier<SoundEvent> DRILL_AMBIENT = registerSoundEvent("drill_ambient");
    public static final Supplier<SoundEvent> DRILL_STOP = registerSoundEvent("drill_stop");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MonkeyKit.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}