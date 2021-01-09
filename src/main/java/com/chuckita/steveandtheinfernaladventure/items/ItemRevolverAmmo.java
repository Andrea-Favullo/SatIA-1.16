package com.chuckita.steveandtheinfernaladventure.items;

import net.minecraft.item.Item;

public class ItemRevolverAmmo extends Item{

	
	public ItemRevolverAmmo(Properties properties, int bullets) {
		super(properties);
		this.bullets=bullets;
	}
	
	private static final int maximumCapacity=18;
	private int bullets;
	
	
	
	public static int getMaximumCapacity() {
		return maximumCapacity;
	}
	
	public int remainingBullets() {
		return this.bullets;
	}
	
	
	
	public ItemRevolverAmmo consumeAmmo(int ammo_to_give) {
		if(ammo_to_give<this.remainingBullets()) {
			this.bullets= this.remainingBullets()-ammo_to_give;
		}
		return this;
	}
}
