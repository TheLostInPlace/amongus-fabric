package net.gridboy.amongus.block;

import net.gridboy.amongus.block.entity.EmergencyButtonBlockEntity;
import net.gridboy.amongus.block.entity.VentBlockEntity;
import net.gridboy.amongus.block.entity.WireTaskBlockEntity;
import net.gridboy.amongus.guis.EButtonController;
import net.gridboy.amongus.guis.WireTaskController;
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

    public static Block WIRE_TASK_BLOCK;

    public static Block STORAGE_BLOCK;

    public static BlockEntityType<EmergencyButtonBlockEntity> EMERGENCY_BUTTON_BLOCK_ENTITY;

    public static BlockEntityType<VentBlockEntity> VENT_BLOCK_ENTITY;

    public static BlockEntityType<WireTaskBlockEntity> WIRE_TASK_BLOCK_ENTITY;

    public static ScreenHandlerType<EButtonController> ebuttonBlockScreen;

    public static ScreenHandlerType<WireTaskController> wireTaskControllerScreenHandler;

    static {
        STORAGE_BLOCK = register("storage_block", new StorageBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.WHITE).dropsNothing().requiresTool()));
        TEST_BLOCK = register("test_block", new AmongusTestBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.IRON).requiresTool().strength(1f, 1f).sounds(BlockSoundGroup.METAL)));
        EMERGENCY_BUTTON_BLOCK = register("emergency_button", new EmergencyButtonBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.RED).requiresTool().strength(1f, 1f).sounds((BlockSoundGroup.LODESTONE)).nonOpaque()));
        EMERGENCY_BUTTON_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + "emergency_button", BlockEntityType.Builder.create(EmergencyButtonBlockEntity::new, EMERGENCY_BUTTON_BLOCK).build(null));
        VENT_BLOCK = register("vent_block", new VentBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.WHITE).dropsNothing().strength(10f, 10f).sounds(BlockSoundGroup.METAL)));
        VENT_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + "vent_block", BlockEntityType.Builder.create(VentBlockEntity::new, VENT_BLOCK).build(null));
        WIRE_TASK_BLOCK = register("wire_task_block", new WireTaskBlock(AbstractBlock.Settings.of(Material.METAL, MaterialColor.WHITE).dropsNothing().requiresTool()));
        WIRE_TASK_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + "wire_task_block", BlockEntityType.Builder.create(WireTaskBlockEntity::new, WIRE_TASK_BLOCK).build(null));
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, id(id), block);
    }


}
