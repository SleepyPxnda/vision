package net.fabricmc.vision.toast

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.toast.Toast
import net.minecraft.client.toast.ToastManager
import net.minecraft.util.Colors
import net.minecraft.util.Identifier

data class VisionToast(
    var title: String,
    var description: String,
    var duration: Double = 5.0,
    var texture: Identifier? = null,
    var type: ToastType? = null
) : Toast {
    val startTime: Long = System.currentTimeMillis();
    override fun draw(context: DrawContext?, manager: ToastManager?, startTime: Long): Toast.Visibility {
        context!!.drawTexture(Identifier("vision","toasts/background.png"), 32, 0, 0F, 0F,129,33,129,33)
        context.drawTexture(Identifier("vision","toasts/warning.png"), 40, 8,0F,0F,16,16, 16,16)

        context.drawText( manager!!.client.textRenderer, this.title, 60, 7, Colors.RED, false)
        context.drawText( manager.client.textRenderer, this.description, 60, 17, Colors.GRAY, false)

        val displayTime: Double = this.duration * manager!!.notificationDisplayTimeMultiplier
        val timeLeft = startTime - this.startTime
        return if ( timeLeft.toDouble() < displayTime ) Toast.Visibility.SHOW else Toast.Visibility.HIDE
    }

    fun queue() {
        MinecraftClient.getInstance().toastManager.add(this)
    }
}