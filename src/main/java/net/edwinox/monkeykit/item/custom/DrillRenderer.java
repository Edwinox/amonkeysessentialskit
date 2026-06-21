package net.edwinox.monkeykit.item.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.animation.LerpedFloat;
import net.edwinox.monkeykit.MonkeyKit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class DrillRenderer extends CustomRenderedItemModelRenderer {

    protected static final PartialModel COG = PartialModel.of(MonkeyKit.loc("item/drill/cog"));
    protected static final PartialModel DRILL = PartialModel.of(MonkeyKit.loc("item/drill/drill"));

    LerpedFloat lerpSpeed;
    float rotation;

    public DrillRenderer() {
        lerpSpeed = LerpedFloat.linear();
    }

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer,
                          ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        renderer.render(model.getOriginalModel(), light);
        var angle = 0f;
        var mc = Minecraft.getInstance();

        if (mc.player instanceof LocalPlayer player) {
            var hand = player.getMainHandItem();
            var inMainHand = ItemStack.isSameItemSameComponents(hand, stack) && stack.equals(hand) && stack.hashCode() == hand.hashCode();
            var held = mc.options.keyAttack.isDown() || mc.options.keyAttack.consumeClick();
            boolean playerHeldKey = player.getPersistentData().getBoolean("DrillKey");

            float targetSpeed = 0f;
            if (inMainHand && held) {
                targetSpeed = 5f;
                if (playerHeldKey) targetSpeed *= 2f;
            }

            // Smoothly ramp the speed itself toward the target (0 when idle, full RPM when mining)
            lerpSpeed.chase(targetSpeed, 1f / 40f, LerpedFloat.Chaser.EXP);
            lerpSpeed.tickChaser();

            // Accumulate rotation using the current (ramped) speed each tick
            rotation = (rotation + lerpSpeed.getValue(AnimationTickHolder.getPartialTicks())) % 36000f;

            angle = rotation % 360;
            angle *= -2;
        }

        ms.pushPose();
        ms.mulPose(Axis.ZP.rotationDegrees(angle));
        renderer.render(COG.get(), light);
        ms.popPose();
        ms.pushPose();
        ms.mulPose(Axis.ZP.rotationDegrees(-angle));
        renderer.render(DRILL.get(), light);
        ms.popPose();
    }
}