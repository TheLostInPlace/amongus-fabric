package net.gridboy.amongus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.gridboy.amongus.item.AmongusItems;
import net.gridboy.amongus.util.init.Initable;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Amongus implements ModInitializer {

	public static final String MOD_ID = "among_us";

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}

	public static final ItemGroup AMONGUS_GROUP = FabricItemGroupBuilder.create(
			id("among_us"))
			.icon(() -> new ItemStack(AmongusItems.TEST_ITEM))
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Initable.initClasses(AmongusItems.class);

		System.out.println("Sus");
	}

}
