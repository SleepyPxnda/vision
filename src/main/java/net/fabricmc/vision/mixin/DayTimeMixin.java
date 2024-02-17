package net.fabricmc.vision.mixin;

import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.Properties.class)
public abstract class DayTimeMixin {
    private static long setTimeOfDay = 6000L;
    private static boolean enableTime = false;

    @Inject(at = @At("RETURN"), method = "getTimeOfDay", cancellable = true)
    public void getTimeOfDay(CallbackInfoReturnable<Long> cir) {
        if (enableTime) {
            cir.setReturnValue(setTimeOfDay);
        } else {
            cir.setReturnValue(cir.getReturnValue());
        }
    }
}
