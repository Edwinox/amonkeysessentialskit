package net.edwinox.monkeykit.item.custom;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class DrillSpinSoundInstance extends AbstractTickableSoundInstance {

    private static final float MIN_PITCH    = 0.5f;
    private static final float MAX_PITCH    = 1.0f;
    private static final float RAMP_SPEED   = 0.05f;
    private static final float FADE_SPEED   = 0.25f; // how fast ambient fades out per tick

    private final LocalPlayer player;
    private float currentPitch;
    private final boolean rampUp;
    private final float targetVolume;
    private boolean fading = false;

    public DrillSpinSoundInstance(LocalPlayer player, SoundEvent soundEvent, float volume, boolean rampUp) {
        super(soundEvent, SoundSource.PLAYERS, player.level().getRandom());
        this.player = player;
        this.rampUp = rampUp;
        this.targetVolume = volume;
        this.looping = true;
        this.delay = 0;
        this.volume = volume;
        this.currentPitch = rampUp ? MIN_PITCH : MAX_PITCH;
        this.pitch = currentPitch;
        this.attenuation = Attenuation.NONE;
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();
    }

    // Call this to trigger a fade-out instead of stopping instantly
    public void fadeOut() {
        fading = true;
    }

    public boolean isFading() {
        return fading;
    }

    @Override
    public void tick() {
        if (!player.isAlive() || player.isRemoved()) {
            stop();
            return;
        }
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();

        if (rampUp) {
            currentPitch = Math.min(MAX_PITCH, currentPitch + RAMP_SPEED);
            this.pitch = currentPitch;
        }

        if (fading) {
            this.volume = Math.max(0f, this.volume - FADE_SPEED);
            if (this.volume <= 0f) {
                stop();
            }
        }
    }
}