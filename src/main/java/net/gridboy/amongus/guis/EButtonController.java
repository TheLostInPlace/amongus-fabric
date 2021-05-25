package net.gridboy.amongus.guis;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.gridboy.amongus.Amongus;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class EButtonController extends SyncedGuiDescription {
    public EButtonController(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);

        WSprite icon = new WSprite(new Identifier("among_us:textures/item/emergency_icon.png"));
        root.add(icon, 3, 0, 2, 2);

        WButton button = new WButton(new TranslatableText("gui.among_us.callemergency"));
        root.add(button, 3, 6, 8, 1);
        button.setOnClick(() -> {
            // This code runs on the client when you click the button.
            System.out.println("Button clicked!");
            playerInventory.player.sendMessage(new LiteralText("Sus"), false);
            playerInventory.player.playSound(Amongus.EME_EVENT, 1.0F, 1.0F);
        });

        root.validate(this);
    }
}
