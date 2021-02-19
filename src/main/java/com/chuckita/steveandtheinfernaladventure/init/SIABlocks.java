package com.chuckita.steveandtheinfernaladventure.init;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;
import com.chuckita.steveandtheinfernaladventure.blocks.BlockCrate;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SIABlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SteveAndTheInfernalAdventure.MOD_ID);
	
	
	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//CRATE
	public static final RegistryObject<Block> CRATE = BLOCKS.register("crate", () -> new BlockCrate( AbstractBlock.Properties.create(Material.WOOD)));
}
