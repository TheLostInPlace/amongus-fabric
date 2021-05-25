package net.gridboy.amongus.guis;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerType;

public class WireTaskController extends SyncedGuiDescription {

    public WireTaskController(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 256);
        root.validate(this);

    }
}
