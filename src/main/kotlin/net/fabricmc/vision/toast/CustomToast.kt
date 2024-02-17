package net.fabricmc.vision.toast

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.toast.Toast
import net.minecraft.client.toast.ToastManager
import net.minecraft.util.Colors

class CustomToast(title: String, description: String) : Toast {

    val title: String = title;
    val description: String = description;
    val displayDuration: Double = 5.0;
    val startTime: Long = System.currentTimeMillis();

    /**
     * ToDo: "Toast is not disappering after 5 seconds. Fix it."
     * ToDo: "Toast is not styled. Fix it."
     */
    override fun draw(context: DrawContext?, manager: ToastManager?, startTime: Long): Toast.Visibility {
        context!!.drawText(manager!!.client.textRenderer, this.title, 18, 12, Colors.YELLOW, false)
        context!!.drawText( manager!!.client.textRenderer, this.description, 18, 20, Colors.RED, false)

        val displayTime: Double = this.displayDuration * manager.notificationDisplayTimeMultiplier
        val timeLeft = startTime - this.startTime
        return if ( timeLeft.toDouble() < displayTime ) Toast.Visibility.SHOW else Toast.Visibility.HIDE
    }

    fun queue(manager: ToastManager) {
        manager.add(this)
    }
}