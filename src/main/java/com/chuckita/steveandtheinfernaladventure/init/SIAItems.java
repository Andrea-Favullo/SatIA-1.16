package com.chuckita.steveandtheinfernaladventure.init;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;
import com.chuckita.steveandtheinfernaladventure.items.ItemCrate;
import com.chuckita.steveandtheinfernaladventure.items.ItemRevolver;
import com.chuckita.steveandtheinfernaladventure.items.ItemRevolverAmmo;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SIAItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SteveAndTheInfernalAdventure.MOD_ID);

	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// REVOLVER
	public static final RegistryObject<Item> REVOLVER = ITEMS.register("revolver", () -> new ItemRevolver(new Item.Properties()
			.group(SteveAndTheInfernalAdventure.TAB)
			.maxStackSize(1)));
	// REVOLVER AMMO
	public static final RegistryObject<Item> REVOLVER_AMMO = ITEMS.register("revolver_ammo", () -> new ItemRevolverAmmo(new Item.Properties()
			.group(SteveAndTheInfernalAdventure.TAB)
			.maxStackSize(1)));
	// CRATE
	public static final RegistryObject<Item> CRATE_ITEM = ITEMS.register("crate", () -> new ItemCrate(SIABlocks.CRATE.get()));
}
