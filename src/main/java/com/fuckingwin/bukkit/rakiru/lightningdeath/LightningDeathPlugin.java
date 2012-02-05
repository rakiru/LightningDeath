package com.fuckingwin.bukkit.rakiru.lightningdeath;

import com.fuckingwin.bukkit.rakiru.lightningdeath.commands.*;
import com.fuckingwin.bukkit.rakiru.lightningdeath.events.LightningDeathListener;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

//TODO: Write custom event for bans
//TODO: Write local ban backup system - MiniDB?

/**
 * MCBans 4 main plugin
 *
 * @author Sean Gordon (rakiru)
 */
public class LightningDeathPlugin extends JavaPlugin {

	public final Config config = new Config(this);
	public static final Logger log = Logger.getLogger("Minecraft");

	public void onDisable() {
		// Output to console that plugin is disabled
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " disabled!");
	}

	public void onEnable() {
		// Load config
		config.load();

		// Get plugin info from plugin.yml
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("Using bukkit permissions");

		// Register commands
		getCommand("lightningdeath").setExecutor(new LightningDeathCommand(this));

		// Register listeners
		getServer().getPluginManager().registerEvents(new LightningDeathListener(this), this);

		// Output to console that plugin is enabled
		log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " enabled!");
	}
}
