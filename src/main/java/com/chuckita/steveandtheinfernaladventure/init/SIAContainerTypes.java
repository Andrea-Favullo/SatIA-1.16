package com.chuckita.steveandtheinfernaladventure.init;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SIAContainerTypes {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, SteveAndTheInfernalAdventure.MOD_ID);
	
	
	public static void init() {
		CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	// CRATE
	//public static final RegistryObject<ContainerType<CrateContainer>> CRATE = CONTAINER_TYPES.register("crate", () -> IForgeContainerType.create(CrateContainer::new));
}
