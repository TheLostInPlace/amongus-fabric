package net.gridboy.amongus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.client.render.EmergencyButtonBlockRenderer;

public class AmongusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockEntityRendererRegistry.INSTANCE.register(AmongusBlocks.EMERGENCY_BUTTON_BLOCK_ENTITY, EmergencyButtonBlockRenderer::new);

    }
}
