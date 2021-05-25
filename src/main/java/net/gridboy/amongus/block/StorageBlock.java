package net.gridboy.amongus.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockView;

import java.util.List;

public class StorageBlock extends Block {

    public static Identifier ID = new Identifier("amongus", "storage_block");

    public StorageBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("block.among_us.storage_block.tooltip").formatted(Formatting.GOLD) );
    }

}
