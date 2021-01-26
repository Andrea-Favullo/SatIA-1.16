package com.chuckita.steveandtheinfernaladventure.tileentity;

import com.chuckita.steveandtheinfernaladventure.blocks.BlockCrate;
import com.chuckita.steveandtheinfernaladventure.util.RegistryHandler;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;

public class CrateTileEntity extends TileEntity {

	public CrateTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
/*
	public CrateTileEntity() {
		this(RegistryHandler.CRATE_TILE_ENTITY.get().create());
	}*/

}
