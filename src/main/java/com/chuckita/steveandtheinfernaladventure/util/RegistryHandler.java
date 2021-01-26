package com.chuckita.steveandtheinfernaladventure.util;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;
import com.chuckita.steveandtheinfernaladventure.blocks.BlockCrate;
import com.chuckita.steveandtheinfernaladventure.items.ItemCrate;
import com.chuckita.steveandtheinfernaladventure.items.ItemRevolver;
import com.chuckita.steveandtheinfernaladventure.items.ItemRevolverAmmo;
import com.chuckita.steveandtheinfernaladventure.tileentity.CrateTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SteveAndTheInfernalAdventure.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SteveAndTheInfernalAdventure.MOD_ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SteveAndTheInfernalAdventure.MOD_ID);
	
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//ITEMS
	//REVOLVER
	public static final RegistryObject<Item> REVOLVER = ITEMS.register("revolver", () -> new ItemRevolver(new Item.Properties()
																											.group(SteveAndTheInfernalAdventure.TAB)
																											.maxStackSize(1)));
	//REVOLVER AMMO
	public static final RegistryObject<Item> REVOLVER_AMMO = ITEMS.register("revolver_ammo", () -> new ItemRevolverAmmo(new Item.Properties().group(SteveAndTheInfernalAdventure.TAB)
																																			.maxStackSize(1)
																																			, 18));

	//END ITEMS
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//BLOCKS
	//CRATE
	public static final RegistryObject<Block> CRATE = BLOCKS.register("crate", () -> new BlockCrate( 
																							AbstractBlock.Properties.create(Material.WOOD)));
	//END BLOCKS
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//BLOCK ITEMS
	//CRATE
	public static final RegistryObject<Item> CRATE_ITEM = ITEMS.register("crate", () -> new ItemCrate( CRATE.get() ));
	//END BLOCK ITEMS
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//TILE ENTITIES
	
	//public static final RegistryObject<TileEntity<CrateTileEntity>> CRATE_TILE_ENTITY = TILE_ENTITY_TYPES.register("crate", () -> TileEntityType.Builder.create(CrateTileEntity::new, CRATE).build(null));
	//public static final RegistryObject<TileEntity<CrateTileEntity>> CRATE_TILE_ENTITY = TILE_ENTITY_TYPES.register("crate", () -> new CrateTileEntity());
	
	//END TILE ENTITIES
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
}
