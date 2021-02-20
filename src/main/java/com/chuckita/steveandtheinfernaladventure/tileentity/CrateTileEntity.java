package com.chuckita.steveandtheinfernaladventure.tileentity;

import com.chuckita.steveandtheinfernaladventure.init.SIATileEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CrateTileEntity extends TileEntity {

	
	private ItemStack item_stack = ItemStack.EMPTY;
	
	
	public CrateTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public CrateTileEntity() {
		this(SIATileEntityTypes.CRATE.get());
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		
		
		/*
		String id = compound.get("id").getString();
		int count = compound.getInt("count");
		*/
		
		super.write(compound);
		
		if(!item_stack.isEmpty()) {
			item_stack.write(compound);
		}
		return compound;
	}
	
	public void read(BlockState blockState, CompoundNBT compound) {
		super.func_230337_a_(blockState, compound);
		
		ItemStack item_stack = new ItemStack(Items.COOKED_CHICKEN, 23);
		
		CompoundNBT itemStackNBT = compound.getCompound("item");
		ItemStack readItemStack = ItemStack.read(itemStackNBT);
		if (ItemStack.areItemStacksEqual(item_stack, readItemStack)) {
			ItemStack.read(itemStackNBT);
		}
		
	}
}
