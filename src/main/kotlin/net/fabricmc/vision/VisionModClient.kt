package net.fabricmc.vision

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.vision.toast.ToastManager
import net.fabricmc.vision.toast.ToastType
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import java.util.*

class VisionModClient: ClientModInitializer {

    override fun onInitializeClient() {
        //Initialize client
        println("Initializing VisionModClient")
        Timer().schedule(object: TimerTask() {
            override fun run() {
                println("Showing Toast")
                ToastManager()
                    .title(Text.of("Titel"))
                    .description(Text.of("test"))
                    .type(ToastType.INFO)
                    .queue();

                ToastManager()
                    .title(Text.of("test"))
                    .description(Text.of("Description"))
                    .type(ToastType.ERROR)
                    .queue();

                ToastManager()
                    .title(Text.of("test"))
                    .description(Text.of("test"))
                    .texture(Identifier("vision","toasts/default.png"))
                    .queue();
            }
        }, 15000L);
    }
}