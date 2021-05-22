package net.gridboy.amongus.block;

import net.gridboy.amongus.block.entity.EmergencyButtonBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.gridboy.amongus.Amongus.id;

public class AmongusBlocks {

    public static Block TEST_BLOCK;

    public static BlockEntityType<EmergencyButtonBlockEntity> EMERGENCY_BUTTON_BLOCK_ENTITY;

    static {
        TEST_BLOCK = register("test_block", new AmongusTestBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.IRON).requiresTool().strength(1f, 1f).sounds(BlockSoundGroup.METAL)));
        //System.out.println("static was called!");
    }

    private static Block register(String id, Block block) {
       // System.out.println("register was called!");
        return Registry.register(Registry.BLOCK, id(id), block);
    }


}
