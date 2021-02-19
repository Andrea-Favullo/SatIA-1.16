package com.chuckita.steveandtheinfernaladventure.items;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ItemCrate extends BlockItem {

	public ItemCrate(Block blockIn) {
		super(blockIn, new Item.Properties()
				.group(SteveAndTheInfernalAdventure.TAB)
				.maxStackSize(1));
	}

}
