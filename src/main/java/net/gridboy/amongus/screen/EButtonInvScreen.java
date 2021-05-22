package net.gridboy.amongus.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.gridboy.amongus.guis.EButtonSyncGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class EButtonInvScreen extends CottonInventoryScreen<EButtonSyncGui> {
    public EButtonInvScreen(EButtonSyncGui description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}
