package net.pickmod.mixin;

import net.pickmod.PickMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;


@Mixin(ChatHud.class)
public class ChestCooldownMixin {
    String chestMessageAsJson = "{\"extra\":[{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"dark_gray\",\"text\":\"[\"},{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"#99552E\",\"text\":\"✉\"},{\"italic\":false,\"color\":\"dark_gray\",\"text\":\"] \"},{\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false,\"color\":\"#CC893D\",\"text\":\"You found a chest!\"}],\"text\":\"\"}";
    MinecraftClient client = MinecraftClient.getInstance();
    @Inject(at = @At("HEAD"), method = "addMessage(Lnet/minecraft/text/Text;IIZ)V")
    public void onAddMessage(Text message, int messageId, int timestamp, boolean refresh, CallbackInfo ci) {
        if (Objects.equals(Text.Serializer.toJson(message), chestMessageAsJson)) {
            PickMod.LOGGER.info("Chest found!");
            new Thread(() -> {
                try {
                    Thread.sleep(480000); //8 minutes in milliseconds
                    client.getToastManager().add(new SystemToast(SystemToast.Type.PERIODIC_NOTIFICATION,Text.of("⛏"), new TranslatableText("text.pickmod.chest_notification")));
                } catch (InterruptedException e) {
                    PickMod.LOGGER.warn("Chest thread interrupted!");
                }
            }).start();
        }
    }
}
