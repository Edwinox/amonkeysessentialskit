package net.edwinox.monkeykit.item.custom;

import io.netty.buffer.ByteBuf;
import net.createmod.catnip.net.base.ServerboundPacketPayload;
import net.edwinox.monkeykit.register.MonkeyPackets;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;

public record DrillKeyPacket(boolean activated) implements ServerboundPacketPayload {
    public static final StreamCodec<ByteBuf, DrillKeyPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, DrillKeyPacket::activated,
            DrillKeyPacket::new
    );

    @Override
    public PacketTypeProvider getTypeProvider() {
        return MonkeyPackets.DRILL_KEY;
    }

    @Override
    public void handle(ServerPlayer player) {
        player.getPersistentData().putBoolean("DrillKey", activated);
    }
}