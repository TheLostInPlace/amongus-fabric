package net.gridboy.amongus.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.WanderingTraderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WanderingTraderManager.class)
abstract class EliminateWanderingTraderMixin {

    @Inject(at = @At("HEAD"), method = "method_18018", cancellable = true)
    public void eliminateWanderingTrader(ServerWorld serverWorld, CallbackInfoReturnable<Boolean> cir)
    {
        System.out.println("Wandering trader has been eliminated.");
        cir.cancel();
    }

}
