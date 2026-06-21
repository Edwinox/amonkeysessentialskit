package net.edwinox.monkeykit.item.packages;

import net.edwinox.monkeykit.item.custom.DrillKeyPacket;
import net.edwinox.monkeykit.register.client.MonkeyKeys;
import net.createmod.catnip.platform.CatnipServices;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.GameType;

public class DrillKeyHandlerClient {

    public static void onKeyInput(int key, boolean pressed) {
        Minecraft mc = Minecraft.getInstance();
        var player = mc.player;
        if (player == null || mc.gameMode == null || mc.gameMode.getPlayerMode() == GameType.SPECTATOR) return;

        if (MonkeyKeys.DRILL_ACTIVATION.doesModifierAndCodeMatch(key)) {
            CatnipServices.NETWORK.sendToServer(new DrillKeyPacket(pressed));
            player.getPersistentData().putBoolean("DrillKey", pressed);
        }
    }
}