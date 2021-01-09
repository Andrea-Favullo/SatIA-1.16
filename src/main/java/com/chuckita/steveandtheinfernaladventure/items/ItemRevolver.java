package com.chuckita.steveandtheinfernaladventure.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemRevolver extends Item {

	private static final int clipSize = 6;
	private int bullets;

	public ItemRevolver(Properties properties, int bullets) {
		super(properties);
		this.bullets = bullets;
	}

	public static int getClipSize() {
		return clipSize;
	}

	public int remainingBullets() {
		return this.bullets;
	}

	public void onShooting() {
		this.bullets -= 1;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	      if (this.isFood()) {
	         ItemStack itemstack = playerIn.getHeldItem(handIn);
	         if (playerIn.canEat(this.getFood().canEatWhenFull())) {
	            playerIn.setActiveHand(handIn);
	            return ActionResult.resultConsume(itemstack);
	         } else {
	            return ActionResult.resultFail(itemstack);
	         }
	      } else {
	         return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	      }
	   }

}
