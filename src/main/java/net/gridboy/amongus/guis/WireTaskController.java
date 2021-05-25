package net.gridboy.amongus.guis;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.LiteralText;

public class WireTaskController extends SyncedGuiDescription {

    public WireTaskController(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 256);


        //WToggleButton wire_1 = new WToggleButton(new LiteralText("Wire 1"));
        //root.add(wire_1, 5, 5);

        WTextField text_box = new WTextField(new LiteralText("Replace me!"));
        root.add(text_box, 3, 8, 6, 2);

        root.validate(this);
    }


}