package com.chuckita.steveandtheinfernaladventure.tileentity;

import com.chuckita.steveandtheinfernaladventure.init.SIATileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CrateTileEntity extends TileEntity/*LockableLootTileEntity*/ {

	
	private ItemStack item_stack = ItemStack.EMPTY;
	private NonNullList<ItemStack> chestContents = NonNullList.withSize(27, ItemStack.EMPTY);

	public CrateTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public CrateTileEntity() {
		this(SIATileEntityTypes.CRATE.get());
	}

	@Override
	public void read(BlockState stateIn, CompoundNBT nbtIn) {
		super.read(stateIn, nbtIn);
		this.readCustomNBT(nbtIn, false);
	}
	public abstract void readCustomNBT(CompoundNBT nbt, boolean descPacket);

	@Override
	public CompoundNBT write(CompoundNBT nbt)
	{
		super.write(nbt);
		this.writeCustomNBT(nbt, false);
		return nbt;
	}
	public abstract void writeCustomNBT(CompoundNBT nbt, boolean descPacket);

/*
	@Override
	protected NonNullList<ItemStack> getItems() {
		return null;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {

		ItemStack item_stack = new ItemStack(Items.COOKED_CHICKEN, 23);

		String id = compound.get("id").getString();
		int count = compound.getInt("count");

		
		super.write(compound);
		
		if(!item_stack.isEmpty()) {
			item_stack.write(compound);
		}
		return compound;
	}
	
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
		
		ItemStack item_stack = new ItemStack(Items.COOKED_CHICKEN, 23);

		System.out.println(compound.toString());
		System.out.println(blockState.toString());

		CompoundNBT itemStackNBT = compound.getCompound("item");

		ItemStack readItemStack = ItemStack.read(itemStackNBT);

		if (ItemStack.areItemStacksEqual(item_stack, readItemStack)) {
			ItemStack.read(itemStackNBT);
		}
		
	}

	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		this.chestContents = NonNullList.withSize(1, ItemStack.EMPTY);
		if (!this.checkLootAndRead(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.chestContents);
		}

	}

	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.chestContents);
		}

		return compound;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("block.steveandtheinfernaladventure.crate");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return null;
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}*/
}
