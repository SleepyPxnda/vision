package net.fabricmc.vision.toast

import net.minecraft.client.MinecraftClient
import net.minecraft.client.toast.SystemToast.Type
import net.minecraft.util.Identifier

class ToastManager {

    var visionToast: VisionToast = VisionToast("","");

    fun title(title: String): ToastManager {
        visionToast.title = title;
        return this;
    }

    fun description(description: String): ToastManager {
        visionToast.description = description;
        return this;
    }

    fun duration(duration: Double): ToastManager {
        visionToast.duration = duration;
        return this;
    }

    fun type(type: ToastType): VisionToast {
        visionToast.type = type;
        return visionToast;
    }

    fun texture(texture: Identifier): VisionToast {
        visionToast.texture = texture;
        return visionToast;
    }
}