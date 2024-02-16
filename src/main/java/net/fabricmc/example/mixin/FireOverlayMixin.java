package net.fabricmc.example.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameOverlayRenderer.class)
public abstract class FireOverlayMixin {

    private static float fireOverlayY = -1.0f; //This should be customizable

    @Inject(method = "renderFireOverlay",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"))
    private static void onRenderFireOverlay(MinecraftClient client, MatrixStack matrices, CallbackInfo ci) {
        matrices.translate(0.0, fireOverlayY, 0.0);
    }

    @Inject(method = "renderFireOverlay",
            at = @At("HEAD"),
            cancellable = true)
    private static void onRenderFireOverlay2(MinecraftClient client, MatrixStack matrices, CallbackInfo ci) {
        ci.cancel();
    }
}
