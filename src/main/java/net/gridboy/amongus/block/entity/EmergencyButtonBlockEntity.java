package net.gridboy.amongus.block.entity;

import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.guis.EButtonSyncGui;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;

public class EmergencyButtonBlockEntity extends BlockEntity implements Tickable, NamedScreenHandlerFactory {

    public EmergencyButtonBlockEntity()
    {
        super(AmongusBlocks.EMERGENCY_BUTTON_BLOCK_ENTITY);
    }

    int i = 0;

    @Override
    public Text getDisplayName() {
        // Using the block name as the screen title
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new EButtonSyncGui(AmongusBlocks.ebuttonBlockScreen, syncId, inventory);
    }

    @Override
    public void tick()
    {
        //System.out.println((i++) + " ticks elapsed");
    }
}
