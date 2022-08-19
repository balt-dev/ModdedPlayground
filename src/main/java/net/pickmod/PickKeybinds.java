package net.pickmod;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class PickKeybinds {
    private static KeyBinding quickUpKeyBinding;
    public static void register(){
        quickUpKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.pickmod.quickup", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_U, // The keycode of the key
                "category.pickmod.binds" // The translation key of the keybinding's category.
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (quickUpKeyBinding.wasPressed()) {
                assert client.player != null;
                client.player.sendChatMessage("@up");
            }
        });
    }
}
