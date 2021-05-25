package net.gridboy.amongus.block.entity;

import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.guis.EButtonController;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class EmergencyButtonBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {

    public EmergencyButtonBlockEntity()
    {
        super(AmongusBlocks.EMERGENCY_BUTTON_BLOCK_ENTITY);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new EButtonController(AmongusBlocks.ebuttonBlockScreen, syncId, inventory);
    }

}
