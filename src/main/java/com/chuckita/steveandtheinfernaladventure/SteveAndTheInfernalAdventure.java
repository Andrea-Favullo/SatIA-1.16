package com.chuckita.steveandtheinfernaladventure;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chuckita.steveandtheinfernaladventure.init.ItemInit;

import java.util.stream.Collectors;

// id della mod
@Mod("steveinfernaladventure")
public class SteveAndTheInfernalAdventure{
    
	// oggetto logger permette di immettere messaggi nella console di output
    private static final Logger LOGGER = LogManager.getLogger();
    // stringa contenente l'id della mod
    public static final String MOD_ID = "steveinfernaladventure";
    public static SteveAndTheInfernalAdventure istanza;
    
    public SteveAndTheInfernalAdventure(){
    	
    	istanza = this;
        
        // 	Come creare un messaggio con il logger:
        //LOGGER.info("testo");
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    //creo tabella menù creativa
    public static class ModTab extends ItemGroup{
    	
    	public static final ModTab istanza = new ModTab(ItemGroup.GROUPS.length, MOD_ID);
    	
    	private ModTab(int index, String label) {
    		super(index, label);
    	}
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(ItemInit.item_revolver);
    	}
    }
    
    // You can use EventBusSubscriber to automatically subscribe events on the contained class
    // (this is subscribing to the MOD Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent){}
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent){}
    }
}
