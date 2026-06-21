package net.edwinox.monkeykit.events;

import net.edwinox.monkeykit.MonkeyKit;
import net.edwinox.monkeykit.item.packages.IOnBlockBreak;
import net.minecraft.world.InteractionHand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = MonkeyKit.MOD_ID)
public class ServerEvents {
    @SubscribeEvent
    public static void onBlockDestroyed(BlockEvent.BreakEvent event) {
        var player = event.getPlayer();
        var level = event.getLevel();
        var pos = event.getPos();
        var state = event.getState();
        var held = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (held.getItem() instanceof IOnBlockBreak ext) ext.onBlockBreak(held, level, pos, state, player);
    }
}