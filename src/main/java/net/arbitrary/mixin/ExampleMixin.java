package net.arbitrary.mixin;

import net.arbitrary.Arbitrary;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ChatHud.class)
public class ExampleMixin {
    @Inject(at = @At("HEAD"), method = "addMessage(Lnet/minecraft/text/Text;IIZ)V")
    public void onAddMessage(Text message, int messageId, int timestamp, boolean refresh, CallbackInfo ci) {
        Arbitrary.LOGGER.error(Text.Serializer.toJson(message));
    }
}
