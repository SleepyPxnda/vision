package net.fabricmc.vision.toast

import net.minecraft.client.MinecraftClient
import net.minecraft.client.toast.SystemToast.Type
import net.minecraft.text.Text
import net.minecraft.util.Identifier

class ToastManager {

    var visionToast: VisionToast = VisionToast(Text.of(""),Text.of(""));

    /**
     * Adds a title to the toast
     */
    fun title(title: Text): ToastManager {
        visionToast.title = title;
        return this;
    }

    /**
     * Adds a description to the toast
     */
    fun description(description: Text): ToastManager {
        visionToast.description = description;
        return this;
    }

    /**
     * Adds a custom duration to the toast
     */
    fun duration(duration: Double): ToastManager {
        visionToast.duration = duration;
        return this;
    }

    /**
     * Creates the toast with a given type

     */
    fun type(type: ToastType): VisionToast {
        visionToast.type = type;
        return visionToast;
    }

    /**
     * Creates the toast with a custom texture
     * Icon should be 64x64 but gets cropped down to 16x16
     */
    fun texture(texture: Identifier): VisionToast {
        visionToast.texture = texture;
        return visionToast;
    }
}