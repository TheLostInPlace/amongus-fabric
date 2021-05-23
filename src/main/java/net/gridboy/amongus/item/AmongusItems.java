package net.gridboy.amongus.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.util.init.Initable;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.gridboy.amongus.Amongus.AMONGUS_GROUP;
import static net.gridboy.amongus.Amongus.id;

public class AmongusItems implements Initable {

    public static Item TEST_BLOCK;
    public static Item EMERGENCY_BUTTON;
    public static Item EMERGENCY_ITEM;
    public static Item TEST_ITEM;
    public static Item VENT_BLOCK;


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
        TEST_BLOCK = register(new BlockItem(AmongusBlocks.TEST_BLOCK, new Item.Settings().group(AMONGUS_GROUP).fireproof()));
        EMERGENCY_BUTTON = register(new BlockItem(AmongusBlocks.EMERGENCY_BUTTON_BLOCK, new Item.Settings().fireproof().group(AMONGUS_GROUP).maxCount(1)));
        EMERGENCY_ITEM = register(id("emergency_icon"), new EmergencyItem(new FabricItemSettings()
                .fireproof()
                .rarity(Rarity.EPIC)
                .maxCount(1)
                .group(AMONGUS_GROUP)
        ));
        TEST_ITEM = register(id("test_item"), new AmongusTestItem(new FabricItemSettings()
        .group(AMONGUS_GROUP)
        .maxCount(1)));
        VENT_BLOCK = register(new BlockItem(AmongusBlocks.VENT_BLOCK, new Item.Settings().group(AMONGUS_GROUP).fireproof()));
    }
}
