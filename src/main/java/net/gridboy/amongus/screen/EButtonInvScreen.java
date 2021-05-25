package net.gridboy.amongus.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.gridboy.amongus.guis.EButtonController;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class EButtonInvScreen extends CottonInventoryScreen<EButtonController> {
    public EButtonInvScreen(EButtonController description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}
