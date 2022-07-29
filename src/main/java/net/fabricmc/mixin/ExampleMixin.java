package net.fabricmc.mixin;

import net.fabricmc.ExampleMod;
import net.minecraft.client.resource.metadata.TextureResourceMetadata;
import net.minecraft.client.texture.ResourceTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(ResourceTexture.class)
public class ExampleMixin {
	@Redirect(at=@At(value="INVOKE",target="Lnet/minecraft/client/texture/ResourceTexture$TextureData;getMetadata()Lnet/minecraft/client/resource/metadata/TextureResourceMetadata;"),method="Lnet/minecraft/client/texture/ResourceTexture;load(Lnet/minecraft/resource/ResourceManager;)V")
	public TextureResourceMetadata getMetadata(@Coerce Object instance) {
		return new TextureResourceMetadata(true,false);
	}
}
