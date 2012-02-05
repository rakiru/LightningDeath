package com.fuckingwin.bukkit.rakiru.lightningdeath.events;

import com.fuckingwin.bukkit.rakiru.lightningdeath.LightningDeathPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 *
 * @author Sean
 */
public class LightningDeathListener implements Listener {

	private LightningDeathPlugin plugin;

	public LightningDeathListener(LightningDeathPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerLogin(EntityDeathEvent event) {
		if (plugin.config.isDamagin()) {
			event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
		} else {
			event.getEntity().getWorld().strikeLightningEffect(event.getEntity().getLocation());
		}
	}
}
