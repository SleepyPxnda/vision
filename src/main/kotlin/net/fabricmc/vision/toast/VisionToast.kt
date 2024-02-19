package net.fabricmc.vision.toast

import net.minecraft.client.MinecraftClient
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.toast.Toast
import net.minecraft.client.toast.ToastManager
import net.minecraft.text.OrderedText
import net.minecraft.text.Text
import net.minecraft.util.Colors
import net.minecraft.util.Identifier
import kotlin.math.max

data class VisionToast(
    var title: Text,
    var description: Text?,
    var titleColor: Int = Colors.WHITE,
    var descriptionColor: Int = Colors.WHITE,
    var duration: Double = 500000.0,
    var texture: Identifier? = null,
    var type: ToastType? = null
) : Toast {

    val client = MinecraftClient.getInstance();
    var startTime: Long = 0;
    var wasDisplayed: Boolean = true;

    override fun draw(context: DrawContext?, manager: ToastManager?, startTime: Long): Toast.Visibility {
        if(wasDisplayed){
            this.wasDisplayed = false;
            this.startTime = startTime
        }
        context!!.drawTexture(Identifier("vision","toasts/background.png"), 32, 0, 0F, 0F,130,32,130,32)

        var textStartingX = 60;

        if(getToastIcon(type, texture) == null){
            textStartingX = 40;
        } else {
            context.drawTexture(getToastIcon(type, texture), 40, 8,0F,0F,16,16, 16,16)
        }

        if(this.description?.string.isNullOrEmpty()){
            context.drawText( manager!!.client.textRenderer, this.title, textStartingX, 13,titleColor, false)
        } else {
            context.drawText( manager!!.client.textRenderer, this.title, textStartingX, 7, titleColor, false)
            context.drawText( manager!!.client.textRenderer, this.description,
                textStartingX, 18, descriptionColor, false)
        }

        val displayTime: Double = this.duration * manager.notificationDisplayTimeMultiplier
        val timeLeft = startTime - this.startTime
        return if ( timeLeft.toDouble() < displayTime ) Toast.Visibility.SHOW else Toast.Visibility.HIDE
    }

    fun queue() {
        client.toastManager.add(this)
    }

    /**
     * Returns an icon for the toast based on the given type or texture
     */
    private fun getToastIcon(type: ToastType?, texture: Identifier?): Identifier? {
        if(type != null){
            return getIdentifierForType(type);
        }
        if(texture != null){
            return texture;
        }

        return Identifier("vision","toasts/default.png");
    }

    /**
     * Returns the right identifier based on a given toasttype
     */
    private fun getIdentifierForType(type: ToastType): Identifier? {
        return when (type) {
            ToastType.INFO -> Identifier("vision","toasts/info.png")
            ToastType.ERROR -> Identifier("vision","toasts/error.png")
            ToastType.NO_ICON -> null;
        }
    }
}