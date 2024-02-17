package net.fabricmc.example.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.world.ClientWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.Properties.class)
public abstract class DayTimeMixin {
    private static long timeOfDay = 6000L;
    private static boolean enableTime = true;

    @Inject(at = @At("RETURN"), method = "getTimeOfDay", cancellable = true)
    @Environment(EnvType.CLIENT)
    public void getTimeOfDay(CallbackInfoReturnable<Long> cir) {
        if (enableTime) {
            cir.setReturnValue(timeOfDay);
        } else {
            cir.cancel();
        }
    }
}
