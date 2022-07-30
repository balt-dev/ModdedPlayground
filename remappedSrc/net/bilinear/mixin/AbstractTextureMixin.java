package net.bilinear.mixin;

import net.minecraft.client.texture.AbstractTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(AbstractTexture.class)
public class AbstractTextureMixin {
    @ModifyVariable(method = "Lnet/minecraft/client/texture/AbstractTexture;setFilter(ZZ)V", at = @At("HEAD"), ordinal = 0)
    private boolean injected(boolean bilinear) {
        return true;
    }
}
