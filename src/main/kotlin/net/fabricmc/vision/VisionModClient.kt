package net.fabricmc.vision

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.vision.toast.ToastManager
import net.fabricmc.vision.toast.ToastType
import net.minecraft.client.MinecraftClient
import java.util.*

class VisionModClient: ClientModInitializer {

    override fun onInitializeClient() {
        //Initialize client
        println("Initializing VisionModClient")
        Timer().schedule(object: TimerTask() {
            override fun run() {
                println("Showing Toast")
                ToastManager()
                    .title("test")
                    .description("test description")
                    .duration(5.0)
                    .type(ToastType.INFO)
                    .queue();
            }
        }, 15000L);
    }
}