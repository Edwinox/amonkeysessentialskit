package net.edwinox.monkeykit.item.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.edwinox.monkeykit.MonkeyKit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class DrillRenderer extends CustomRenderedItemModelRenderer {

    protected static final PartialModel COG = PartialModel.of(MonkeyKit.loc("item/drill/cog"));
    protected static final PartialModel DRILL = PartialModel.of(MonkeyKit.loc("item/drill/drill"));

    private static final float SHAKE_INTENSITY = 0.02f;
    private static final float TARGET_SPEED = 40f;
    private static final float RAMP_FACTOR  = 1f/15f;

    private static float prevRotation = 0f;
    private static float rotation = 0f;
    private static float speed = 0f;
    private static float prevSpeed = 0f;

    public static void tickRotation(boolean mining, boolean boosted) {
        float targetSpeed = 0f;
        if (mining) {
            targetSpeed = TARGET_SPEED;
            if (boosted) targetSpeed *= 2f;
        }

        prevSpeed = speed;
        speed += (targetSpeed - speed) * RAMP_FACTOR;

        prevRotation = rotation;
        rotation = (rotation + speed) % 36000f;
    }

    private float shakeAmount = 0f;
    private float prevShakeAmount = 0f;

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer,
                          ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        var mc = Minecraft.getInstance();
        float partialTicks = AnimationTickHolder.getPartialTicks();

        float interpolatedRotation = prevRotation + (rotation - prevRotation) * partialTicks;
        float angle = (interpolatedRotation % 360) * -2f;

        boolean isMining = false;
        if (mc.player instanceof LocalPlayer player) {
            var hand = player.getMainHandItem();
            var inMainHand = ItemStack.isSameItemSameComponents(hand, stack) && stack.equals(hand) && stack.hashCode() == hand.hashCode();
            var held = mc.options.keyAttack.isDown() || mc.options.keyAttack.consumeClick();
            isMining = inMainHand && held;
        }

        prevShakeAmount = shakeAmount;
        float targetShake = isMining ? 1f : 0f;
        shakeAmount += (targetShake - shakeAmount) * (1f / 20f);
        float interpolatedShake = prevShakeAmount + (shakeAmount - prevShakeAmount) * partialTicks;

        ms.pushPose();
        if (interpolatedShake > 0.001f && mc.player instanceof LocalPlayer player) {
            float dx = (player.level().getRandom().nextFloat() - 0.5f) * SHAKE_INTENSITY * interpolatedShake;
            float dy = (player.level().getRandom().nextFloat() - 0.5f) * SHAKE_INTENSITY * interpolatedShake;
            ms.translate(dx, dy, 0);
        }

        renderer.render(model.getOriginalModel(), light);

        ms.pushPose();
        ms.mulPose(Axis.ZP.rotationDegrees(angle));
        renderer.render(COG.get(), light);
        ms.popPose();

        ms.pushPose();
        ms.mulPose(Axis.ZP.rotationDegrees(-angle));
        renderer.render(DRILL.get(), light);
        ms.popPose();

        ms.popPose();
    }
}