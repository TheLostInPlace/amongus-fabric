package net.gridboy.amongus.block;

import net.gridboy.amongus.block.entity.EmergencyButtonBlockEntity;
import net.gridboy.amongus.block.entity.VentBlockEntity;
import net.gridboy.amongus.guis.EButtonSyncGui;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.gridboy.amongus.Amongus.MOD_ID;
import static net.gridboy.amongus.Amongus.id;

public class AmongusBlocks {

    public static Block TEST_BLOCK;

    public static Block EMERGENCY_BUTTON_BLOCK;

    public static Block VENT_BLOCK;

    public static BlockEntityType<EmergencyButtonBlockEntity> EMERGENCY_BUTTON_BLOCK_ENTITY;

    public static BlockEntityType<VentBlockEntity> VENT_BLOCK_ENTITY;

    public static ScreenHandlerType<EButtonSyncGui> ebuttonBlockScreen;

    static {
        TEST_BLOCK = register("test_block", new AmongusTestBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.IRON).requiresTool().strength(1f, 1f).sounds(BlockSoundGroup.METAL)));
        EMERGENCY_BUTTON_BLOCK = register("emergency_button", new EmergencyButtonBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.RED).requiresTool().strength(1f, 1f).sounds((BlockSoundGroup.LODESTONE))));
        EMERGENCY_BUTTON_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + "emergency_button", BlockEntityType.Builder.create(EmergencyButtonBlockEntity::new, EMERGENCY_BUTTON_BLOCK).build(null));
        VENT_BLOCK = register("vent_block", new VentBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.WHITE).dropsNothing().strength(10f, 10f).sounds(BlockSoundGroup.METAL)));
        VENT_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + "vent_block", BlockEntityType.Builder.create(VentBlockEntity::new, VENT_BLOCK).build(null));
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, id(id), block);
    }


}
