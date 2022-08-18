package net.lobster.mixin;

import net.minecraft.text.Style;
import net.lobster.LessObfuscated;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Style.class)
public class ExampleMixin {
    @Shadow
    Boolean obfuscated;
	@Inject(at = @At(value = "HEAD"), method = "isObfuscated()Z", cancellable = true)
    public void isObfuscated(CallbackInfoReturnable<Boolean> cir) {
        if (LessObfuscated.config.showChance != 100) {
            cir.setReturnValue(Math.random() < (((float)LessObfuscated.config.showChance)/100) && (obfuscated != null && obfuscated));
        }
    }
}
