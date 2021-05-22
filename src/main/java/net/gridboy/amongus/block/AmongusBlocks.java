package net.gridboy.amongus.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.gridboy.amongus.Amongus.id;

public class AmongusBlocks {
    public static Block AMONGUS_TEST_BLOCK;

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, id(id), block);
    }

    static {
        AMONGUS_TEST_BLOCK = register("test_block", new AmongusTestBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.BLUE).requiresTool().strength(1f, 1f).sounds(BlockSoundGroup.METAL)));

    }



}
