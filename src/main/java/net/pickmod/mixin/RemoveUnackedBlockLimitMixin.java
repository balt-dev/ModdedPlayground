package net.pickmod.mixin;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.util.math.BlockPos;
import net.pickmod.PickMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ClientPlayerInteractionManager.class)
public class RemoveUnackedBlockLimitMixin {
    @Redirect(at = @At(value = "INVOKE", target="Lit/unimi/dsi/fastutil/objects/Object2ObjectLinkedOpenHashMap;size()I", ordinal=0), method = "processPlayerActionResponse(Lnet/minecraft/client/world/ClientWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/network/packet/c2s/play/PlayerActionC2SPacket$Action;Z)V")
    public int fakeSize(Object2ObjectLinkedOpenHashMap instance) {
        return PickMod.config.disableUnackedError ? 0 : instance.size();
    }
}
