package net.fabricmc.vision

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

class VisionMod : ModInitializer {
    companion object {
        val MODID = "vision"
        val LOGGER = LoggerFactory.getLogger(MODID);
    }

    override fun onInitialize() {
        LOGGER.info("Initializing VisionMod")
    }
}