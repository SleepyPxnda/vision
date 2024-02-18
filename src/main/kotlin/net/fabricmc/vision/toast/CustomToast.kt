package net.fabricmc.vision.toast

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.toast.Toast
import net.minecraft.client.toast.ToastManager
import net.minecraft.util.Identifier

class CustomToast(title: String, description: String) : Toast {

    val title: String = title;
    val description: String = description;
    val displayDuration: Double = 5.0;
    val startTime: Long = System.currentTimeMillis();

    override fun draw(context: DrawContext?, manager: ToastManager?, startTime: Long): Toast.Visibility {
        context!!.drawTexture(Identifier("vision","toasts/background.png"), 32, 0, 0F, 0F,129,33,129,33)
        context.drawTexture(Identifier("vision","toasts/warning.png"), 40, 8,0F,0F,16,16, 16, 16)


        val displayTime: Double = this.displayDuration * manager!!.notificationDisplayTimeMultiplier
        val timeLeft = startTime - this.startTime
        return if ( timeLeft.toDouble() < displayTime ) Toast.Visibility.SHOW else Toast.Visibility.HIDE
    }

    fun queue(manager: ToastManager) {
        manager.add(this)
    }
}