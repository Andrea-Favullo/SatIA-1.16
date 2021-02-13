package com.chuckita.steveandtheinfernaladventure.util;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundRegistrator {
	
	//dichiaro i suoni
	public static final SoundEvent CRATE_PLACING;
	public static final SoundEvent CRATE_BREAK;
	public static final SoundEvent CRATE_BREAKING;
	
	static {
		//li aggiungo al registry
		CRATE_PLACING = addSoundsToRegistry("crate_placing");
		CRATE_BREAK = addSoundsToRegistry("crate_break");
		CRATE_BREAKING = addSoundsToRegistry("crate_breaking");
    }
	
	private static SoundEvent addSoundsToRegistry(String soundID) {
		//recupero il suono
		ResourceLocation shotSoundLocation = new ResourceLocation(SteveAndTheInfernalAdventure.MOD_ID, soundID);
		//creo il SoundEvent con quel suono
		SoundEvent soundEvent = new SoundEvent(shotSoundLocation);
		//lo aggiungo al registry
		soundEvent.setRegistryName(shotSoundLocation);
		//restituisco Sound Event
		return soundEvent;
	}
}
