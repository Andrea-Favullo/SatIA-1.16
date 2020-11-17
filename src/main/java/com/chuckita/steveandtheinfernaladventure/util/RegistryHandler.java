package com.chuckita.steveandtheinfernaladventure.util;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;
import com.chuckita.steveandtheinfernaladventure.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SteveAndTheInfernalAdventure.MOD_ID);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static final RegistryObject<Item> REVOLVER = ITEMS.register("revolver", ItemBase::new);
}
