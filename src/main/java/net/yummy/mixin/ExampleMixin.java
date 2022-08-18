package net.yummy.mixin;

import net.yummy.ExampleMod;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "isFood()Z", cancellable = true)
    public void isFood(CallbackInfoReturnable<Boolean> cir) {
        if (ExampleMod.config.toggleA) {
            cir.setReturnValue(true);
        }
    }
    @Shadow
    public FoodComponent foodComponent;
    @Inject(at = @At("HEAD"), method = "getFoodComponent()Lnet/minecraft/item/FoodComponent;", cancellable = true)
    public void getFoodComponent(CallbackInfoReturnable<FoodComponent> cir) {
        if (ExampleMod.config.toggleA) {
            if (foodComponent == null) {
                cir.setReturnValue((new FoodComponent.Builder()).hunger(0).saturationModifier(0F).build());
            }
        }
    }
}
