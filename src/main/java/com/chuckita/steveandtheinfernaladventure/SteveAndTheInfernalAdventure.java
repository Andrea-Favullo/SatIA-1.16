package com.chuckita.steveandtheinfernaladventure;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.chuckita.steveandtheinfernaladventure.init.SIABlocks;
import com.chuckita.steveandtheinfernaladventure.init.SIAItems;
import com.chuckita.steveandtheinfernaladventure.init.SIATileEntityTypes;
import com.chuckita.steveandtheinfernaladventure.util.RegistryHandler;
import com.chuckita.steveandtheinfernaladventure.util.SoundRegisterListener;

// id della mod
@Mod("steveandtheinfernaladventure")
public class SteveAndTheInfernalAdventure{
    
    //ID DELLA MOD
    public static final String MOD_ID = "steveandtheinfernaladventure";
    
    public SteveAndTheInfernalAdventure(){
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    	
    	SIABlocks.init();
    	SIAItems.init();
    	SIATileEntityTypes.init();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new SoundRegisterListener());
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
