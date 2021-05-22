package net.gridboy.amongus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.client.render.EmergencyButtonBlockRenderer;
import net.gridboy.amongus.screen.EButtonInvScreen;

public class AmongusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockEntityRendererRegistry.INSTANCE.register(AmongusBlocks.EMERGENCY_BUTTON_BLOCK_ENTITY, EmergencyButtonBlockRenderer::new);

        ScreenRegistry.register(AmongusBlocks.ebuttonBlockScreen, (gui, inventory, title) -> new EButtonInvScreen(gui, inventory.player, title));

    }
}