package com.fuckingwin.bukkit.rakiru.lightningdeath;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * @author Sean Gordon (rakiru)
 */
public class Config {

	private LightningDeathPlugin plugin;
	private FileConfiguration config;

	public Config(LightningDeathPlugin plugin) {
		this.plugin = plugin;
	}

	public void load() {
		plugin.reloadConfig();
		config = plugin.getConfig();
		config.addDefault("lightning-causes-damage", true);
		config.options().copyDefaults(true);
		plugin.saveConfig();
	}

	public boolean isDamaging() {
		return config.getBoolean("lightning-causes-damage");
	}
}
