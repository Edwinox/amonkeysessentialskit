package net.edwinox.monkeykit.events;

import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.item.packages.DrillKeyHandlerClient;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = MonkeyKit.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (Minecraft.getInstance().screen != null) return;
        int key = event.getKey();
        boolean pressed = !(event.getAction() == 0);
        DrillKeyHandlerClient.onKeyInput(key, pressed);
    }
}