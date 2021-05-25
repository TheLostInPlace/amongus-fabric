package net.gridboy.amongus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.client.render.EmergencyButtonBlockRenderer;
import net.gridboy.amongus.guis.EButtonController;
import net.gridboy.amongus.guis.WireTaskController;
import net.gridboy.amongus.screen.EButtonInvScreen;
import net.gridboy.amongus.screen.WireTaskScreen;

public class AmongusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockEntityRendererRegistry.INSTANCE.register(AmongusBlocks.EMERGENCY_BUTTON_BLOCK_ENTITY, EmergencyButtonBlockRenderer::new);

        ScreenRegistry.<EButtonController, EButtonInvScreen>register(AmongusBlocks.ebuttonBlockScreen, (gui, inventory, title) -> new EButtonInvScreen(gui, inventory.player, title));
        ScreenRegistry.<WireTaskController, WireTaskScreen>register(AmongusBlocks.wireTaskControllerScreenHandler, (gui, inventory, title) -> new WireTaskScreen(gui, inventory.player, title));
    }
}