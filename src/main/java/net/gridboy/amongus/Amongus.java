package net.gridboy.amongus;

import net.fabricmc.api.ModInitializer;
import net.gridboy.amongus.block.AmongusBlocks;
import net.gridboy.amongus.util.init.Initable;
import net.minecraft.util.Identifier;

public class Amongus implements ModInitializer {

	public static final String MOD_ID = "amongus";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Initable.initClasses(AmongusBlocks.class);

		System.out.println("Hello Fabric world!");
	}

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}
}
