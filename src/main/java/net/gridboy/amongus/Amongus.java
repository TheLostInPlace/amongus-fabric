package net.gridboy.amongus;

import net.fabricmc.api.ModInitializer;
import net.gridboy.amongus.item.AmongUsItems;
import net.gridboy.amongus.util.init.Initable;
import net.minecraft.util.Identifier;

public class Amongus implements ModInitializer {

	public static final String MOD_ID = "among_us";

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Initable.initClasses(AmongUsItems.class);

		System.out.println("Hello Fabric world!");
	}

}
