package net.fabricmc.vision

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.vision.toast.ToastManager
import java.util.*

class VisionModClient: ClientModInitializer {

    companion object {
        //Retrieve global reference of client
        var toastManager = ToastManager();
    }

    override fun onInitializeClient() {
        //Initialize client
        println("Initializing VisionModClient")
        Timer().schedule(object: TimerTask() {
            override fun run() {
                println("Showing Toast")
                toastManager.createSystemToast("Test");
                toastManager.showCustomToast("Test","Description");
            }
        }, 20000L);
    }
}