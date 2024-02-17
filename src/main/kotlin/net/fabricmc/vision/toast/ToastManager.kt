package net.fabricmc.vision.toast

import net.minecraft.client.MinecraftClient
import net.minecraft.client.toast.SystemToast
import net.minecraft.client.toast.SystemToast.Type
import net.minecraft.text.Text

class ToastManager {

    val client: MinecraftClient = MinecraftClient.getInstance();
    fun showSystemToast(message: String) {
        SystemToast.add(client.toastManager, Type(), Text.of("Test"), Text.of("Not very important message"))
    }

    fun showCustomToast(title: String, message: String){
        CustomToast(title, message).queue(client.toastManager);
    }
}