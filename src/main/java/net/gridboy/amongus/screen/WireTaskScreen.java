package net.gridboy.amongus.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.gridboy.amongus.guis.WireTaskController;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.TickableElement;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class WireTaskScreen extends CottonInventoryScreen<WireTaskController> implements Drawable, TickableElement {


    public WireTaskScreen(WireTaskController description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}
