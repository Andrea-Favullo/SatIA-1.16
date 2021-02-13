package com.chuckita.steveandtheinfernaladventure.util;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;
import com.chuckita.steveandtheinfernaladventure.tileentity.CrateTileEntity;
import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.function.Supplier;

public class SIATileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SteveAndTheInfernalAdventure.MOD_ID);
	
	public static final RegistryObject<TileEntityType<CrateTileEntity>> CRATE = TILE_ENTITY_TYPES.register(
			"crate",
			makeType( CrateTileEntity::new, () -> RegistryHandler.CRATE.get())
	);
	
	//codice misterioso 
	private static <T extends TileEntity> Supplier<TileEntityType<T>> makeType(Supplier<T> create, Supplier<Block> valid){
		return makeTypeMultipleBlocks(create, () -> ImmutableSet.of(valid.get()));
	}
	private static <T extends TileEntity> Supplier<TileEntityType<T>> makeTypeMultipleBlocks( Supplier<T> create, Supplier<Collection<Block>> valid){
		return () -> new TileEntityType<>(create, ImmutableSet.copyOf(valid.get()), null);
	}
}
