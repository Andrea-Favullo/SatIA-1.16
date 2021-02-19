package com.chuckita.steveandtheinfernaladventure.tileentity;

import com.chuckita.steveandtheinfernaladventure.init.SIATileEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
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
		super.write(compound);
		
		if(testItemStack != null) {
			CompoundNBT itemStackNBT = new CompoundNBT();
			testItemStack.write(itemStackNBT);
			compound.put("item", itemStackNBT);
		}
		
		return compound;
	}
	
	public void read(BlockState blockState, CompoundNBT compound) {
		super.func_230337_a_(blockState, compound);
		
		CompoundNBT itemStackNBT = compound.getCompound("item");
		ItemStack readItemStack = ItemStack.read(itemStackNBT);
		if (ItemStack.areItemStacksEqual(testItemStack, readItemStack)) {
			
		}
		
	}*/
}
