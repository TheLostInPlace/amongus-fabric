package net.gridboy.amongus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.block.EmergencyButtonBlock;
import net.gridboy.amongus.block.WireTaskBlock;
import net.gridboy.amongus.guis.EButtonController;
import net.gridboy.amongus.guis.WireTaskController;
import net.gridboy.amongus.item.AmongusItems;
import net.gridboy.amongus.util.init.Initable;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Amongus implements ModInitializer {

	public static final String MOD_ID = "among_us";

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}

	public static final ItemGroup AMONGUS_GROUP = FabricItemGroupBuilder.create(
			id("among_us"))
			.icon(() -> new ItemStack(AmongusItems.TEST_ITEM))
			.build();

	public static final Identifier SUS_ID = new Identifier("among_us:amogus");
	public static SoundEvent SUS_EVENT = new SoundEvent(SUS_ID);

	public static final Identifier EME_ID = new Identifier(("among_us:emergency"));
	public static SoundEvent EME_EVENT = new SoundEvent(EME_ID);



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Initable.initClasses(AmongusItems.class);

		Registry.register(Registry.SOUND_EVENT, SUS_ID, SUS_EVENT);
		Registry.register(Registry.SOUND_EVENT, EME_ID, EME_EVENT);

		AmongusBlocks.wireTaskControllerScreenHandler = ScreenHandlerRegistry.registerSimple(WireTaskBlock.ID, (syncId, inventory) -> new WireTaskController(AmongusBlocks.wireTaskControllerScreenHandler, syncId, inventory));

		AmongusBlocks.ebuttonBlockScreen = ScreenHandlerRegistry.registerSimple(EmergencyButtonBlock.ID, (syncId, inventory) -> new EButtonController(AmongusBlocks.ebuttonBlockScreen, syncId, inventory));

		System.out.println("Sus");
	}

}
