package net.pickmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PickMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("pickmod");
	public static ModConfig config;

	@Override
	public void onInitialize() {
		PickKeybinds.register();
		AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
	}
}
