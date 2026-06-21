package net.edwinox.monkeykit.events;

import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.item.custom.DrillSpinSoundInstance;
import net.edwinox.monkeykit.item.packages.DrillKeyHandlerClient;
import net.edwinox.monkeykit.register.MonkeyItems;
import net.edwinox.monkeykit.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = MonkeyKit.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    // Adjust these to change volume (0.0 = silent, 1.0 = full volume)
    private static final float DRILL_SPIN_VOLUME    = 0.5f;
    private static final float DRILL_AMBIENT_VOLUME = 1.0f;
    private static final float DRILL_STOP_VOLUME    = 1.0f;

    private static DrillSpinSoundInstance drillSound;
    private static DrillSpinSoundInstance drillAmbient;
    private static boolean wasMining = false;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (Minecraft.getInstance().screen != null) return;
        int key = event.getKey();
        boolean pressed = !(event.getAction() == 0);
        DrillKeyHandlerClient.onKeyInput(key, pressed);
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) {
            stopAll(mc);
            return;
        }

        var held = player.getMainHandItem();
        boolean holdingDrill = MonkeyItems.DRILL.isIn(held) && mc.screen == null;
        boolean mining = mc.options.keyAttack.isDown();

        // Play stop sound on release
        if (wasMining && !mining && holdingDrill) {
            mc.getSoundManager().play(SimpleSoundInstance.forUI(ModSounds.DRILL_STOP.get(), DRILL_STOP_VOLUME));
        }
        wasMining = mining && holdingDrill;

        boolean shouldPlaySpin = holdingDrill && mining;
        boolean shouldPlayAmbient = holdingDrill;

        if (shouldPlaySpin) {
            if (drillSound == null || !mc.getSoundManager().isActive(drillSound)) {
                drillSound = new DrillSpinSoundInstance(player, ModSounds.DRILL_SPIN.get(), DRILL_SPIN_VOLUME, true);
                mc.getSoundManager().play(drillSound);
            }
        } else {
            if (drillSound != null) {
                mc.getSoundManager().stop(drillSound);
                drillSound = null;
            }
        }

        if (shouldPlayAmbient) {
            if (drillAmbient == null || !mc.getSoundManager().isActive(drillAmbient)) {
                drillAmbient = new DrillSpinSoundInstance(player, ModSounds.DRILL_AMBIENT.get(), DRILL_AMBIENT_VOLUME, false);
                mc.getSoundManager().play(drillAmbient);
            }
        } else {
            if (drillAmbient != null) {
                mc.getSoundManager().stop(drillAmbient);
                drillAmbient = null;
            }
        }
    }

    private static void stopAll(Minecraft mc) {
        if (drillSound != null) {
            mc.getSoundManager().stop(drillSound);
            drillSound = null;
        }
        if (drillAmbient != null) {
            mc.getSoundManager().stop(drillAmbient);
            drillAmbient = null;
        }
    }
}