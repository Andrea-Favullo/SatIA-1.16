package com.chuckita.steveandtheinfernaladventure.tileentity;

import com.chuckita.steveandtheinfernaladventure.init.SIATileEntityTypes;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CrateTileEntity extends TileEntity {

	public CrateTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public CrateTileEntity() {
		this(SIATileEntityTypes.CRATE.get());
	}
	/*
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.put("content", NBTHelper.toNBT(this));
		return super.write(compound);
	}*/
}
