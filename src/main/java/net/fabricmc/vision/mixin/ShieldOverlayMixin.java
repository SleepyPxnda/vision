package net.fabricmc.vision.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(HeldItemRenderer.class)
public abstract class ShieldOverlayMixin {

    private boolean evenHeightEnabled = true;
    private float evenHeightFactor = 1.05263157895f; //Main Hand Value / Off Hand Value

    private float mainHandValue = 0.5f;
    private float offHandValue = 0.5f;

    @ModifyArgs(method = "renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderFirstPersonItem(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/util/Hand;FLnet/minecraft/item/ItemStack;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"))
    public void lowerShieldPosition(Args args) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        assert player != null;

        if(evenHeightEnabled){
            offHandValue = mainHandValue / evenHeightFactor;
        }

        if (player.getMainHandStack().isOf(Items.SHIELD) && args.get(3).equals(Hand.MAIN_HAND)) {
            args.set(6, (float) args.get(6) + mainHandValue); //This should be customizable
        } else if (player.getOffHandStack().isOf(Items.SHIELD) && args.get(3).equals(Hand.OFF_HAND)) {
            args.set(6, (float) args.get(6) + offHandValue); //This should be customizable
        }
    }
}
