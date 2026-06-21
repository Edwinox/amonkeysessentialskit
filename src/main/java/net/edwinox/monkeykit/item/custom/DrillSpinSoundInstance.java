package net.edwinox.monkeykit.item.custom;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class DrillSpinSoundInstance extends AbstractTickableSoundInstance {

    // Adjust these to tune the spin-up/down feel
    private static final float MIN_PITCH    = 0.5f;  // pitch when starting
    private static final float MAX_PITCH    = 1.0f;  // pitch at full speed
    private static final float RAMP_SPEED   = 0.05f; // how fast pitch changes per tick

    private final LocalPlayer player;
    private float currentPitch;
    private final boolean rampUp;

    // rampUp = true for spin sound, false for ambient (no ramping)
    public DrillSpinSoundInstance(LocalPlayer player, SoundEvent soundEvent, float volume, boolean rampUp) {
        super(soundEvent, SoundSource.PLAYERS, player.level().getRandom());
        this.player = player;
        this.rampUp = rampUp;
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
    }
}