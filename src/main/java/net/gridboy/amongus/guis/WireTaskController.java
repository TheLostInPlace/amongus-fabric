package net.gridboy.amongus.guis;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import net.gridboy.amongus.Amongus;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class WireTaskController extends SyncedGuiDescription {

    public BackgroundPainter TEXTURE = BackgroundPainter.createNinePatch(new Identifier(Amongus.MOD_ID, "textures/gui/wire_task_texture"));

    public WireTaskController(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        root.setBackgroundPainter(TEXTURE);
        root.validate(this);

    }
}
