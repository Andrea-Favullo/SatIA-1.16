package com.chuckita.steveandtheinfernaladventure.tileentity;

import com.chuckita.steveandtheinfernaladventure.util.RegistryHandler;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CrateTileEntity extends TileEntity{

	public CrateTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public CrateTileEntity() {
		this(RegistryHandler.CRATE.get().create());
	}

}
