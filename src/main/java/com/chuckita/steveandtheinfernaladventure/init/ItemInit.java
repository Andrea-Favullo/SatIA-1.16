package com.chuckita.steveandtheinfernaladventure.init;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

//permette alla classe di sottoscrivere tutti gli eventi, li aggiunge al bus principale
//gli passo l'id e il bus della mod
@EventBusSubscriber(modid = SteveAndTheInfernalAdventure.MOD_ID, bus = Bus.MOD)
public class ItemInit {

	//id dell'oggetto che apparirà in game
	@ObjectHolder(SteveAndTheInfernalAdventure.MOD_ID + "revolver")
	public static Item item_revolver;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName("revolver"));
	}
}
