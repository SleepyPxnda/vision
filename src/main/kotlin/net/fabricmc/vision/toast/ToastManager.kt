package net.fabricmc.vision.toast

import net.minecraft.client.MinecraftClient
import net.minecraft.client.toast.SystemToast.Type
import net.minecraft.text.Text

class ToastManager {

    val client: MinecraftClient = MinecraftClient.getInstance();

    fun createSystemToast(title: String, message: String){
        CustomToast(title, message, null).queue(client.toastManager);
    }

    fun createContextToast(title: String, message: String, context: String){
        CustomToast(title, message, context).queue(client.toastManager);
    }
}