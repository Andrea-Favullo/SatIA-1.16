package com.chuckita.steveandtheinfernaladventure.util;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SoundRegisterListener {
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		//registro tutti i suoni
		event.getRegistry().registerAll(
				SoundRegistrator.CRATE_PLACING,
				SoundRegistrator.CRATE_BREAK,
				SoundRegistrator.CRATE_BREAKING
		);
	}
}