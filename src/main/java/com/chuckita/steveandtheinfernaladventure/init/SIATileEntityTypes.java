package com.chuckita.steveandtheinfernaladventure.init;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;
import com.chuckita.steveandtheinfernaladventure.tileentity.CrateTileEntity;
import com.chuckita.steveandtheinfernaladventure.util.RegistryHandler;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SIATileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SteveAndTheInfernalAdventure.MOD_ID);
	
	
	public static void init() {
		TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//CRATE
	public static final RegistryObject<TileEntityType<CrateTileEntity>> CRATE = TILE_ENTITY_TYPES.register("crate", () -> TileEntityType.Builder.create(CrateTileEntity::new, RegistryHandler.CRATE.get()).build(null)
			//makeType( CrateTileEntity::new, () -> RegistryHandler.CRATE.get())
	);
	
	
	
	/*
	//codice misterioso 
	private static <T extends TileEntity> Supplier<TileEntityType<T>> makeType(Supplier<T> create, Supplier<Block> valid){
		return makeTypeMultipleBlocks(create, () -> ImmutableSet.of(valid.get()));
	}
	private static <T extends TileEntity> Supplier<TileEntityType<T>> makeType( Supplier<T> create, Supplier<Block> valid){
		return () -> new TileEntityType<>(create, ImmutableSet.of(valid.get()), null);
	}*/
}
