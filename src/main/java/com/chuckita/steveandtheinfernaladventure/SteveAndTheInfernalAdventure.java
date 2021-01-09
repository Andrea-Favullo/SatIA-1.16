package com.chuckita.steveandtheinfernaladventure;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.chuckita.steveandtheinfernaladventure.util.RegistryHandler;

// id della mod
@Mod("steveandtheinfernaladventure")
public class SteveAndTheInfernalAdventure{
    
    //ID DELLA MOD
    public static final String MOD_ID = "steveandtheinfernaladventure";
    
    public SteveAndTheInfernalAdventure(){
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    	
    	RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {}
    private void doClientStuff(final FMLCommonSetupEvent event) {}
    
    //TAB CREATIVA CUSTOMIZZATA
    public static final ItemGroup TAB = new ItemGroup("modTab") {
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(RegistryHandler.REVOLVER.get());
    	}
    };

}
