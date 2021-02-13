package com.chuckita.steveandtheinfernaladventure.util;

import com.chuckita.steveandtheinfernaladventure.SteveAndTheInfernalAdventure;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundRegistrator {
	
	public static final SoundEvent CRATE_PLACING;
	public static final SoundEvent CRATE_BREAK;
	public static final SoundEvent CRATE_BREAKING;
	
	static {
		CRATE_PLACING = addSoundsToRegistry("crate_placing");
		CRATE_BREAK = addSoundsToRegistry("crate_break");
		CRATE_BREAKING = addSoundsToRegistry("crate_breaking");
    }
	
	private static SoundEvent addSoundsToRegistry(String soundID) {
		ResourceLocation shotSoundLocation = new ResourceLocation(SteveAndTheInfernalAdventure.MOD_ID, soundID);
		SoundEvent soundEvent = new SoundEvent(shotSoundLocation);
		soundEvent.setRegistryName(shotSoundLocation);
		return soundEvent;
	}
}
