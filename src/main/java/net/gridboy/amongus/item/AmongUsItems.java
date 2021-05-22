package net.gridboy.amongus.item;

import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.util.init.Initable;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AmongUsItems implements Initable {

    public static Item TEST_BLOCK;

    protected static Item register(Block block, Item item) {
        return register(Registry.BLOCK.getId(block), item);
    }

    private static Item register(BlockItem item) {
        return register(item.getBlock(), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registry.ITEM, id, item);
    }

    public static void init() {
        TEST_BLOCK = register(new BlockItem(AmongusBlocks.TEST_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).fireproof()));
    }


}
