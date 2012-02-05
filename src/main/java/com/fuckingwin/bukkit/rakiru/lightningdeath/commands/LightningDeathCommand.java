package com.fuckingwin.bukkit.rakiru.lightningdeath.commands;

import com.fuckingwin.bukkit.rakiru.lightningdeath.LightningDeathPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author rakiru
 */
public class LightningDeathCommand implements CommandExecutor {

	private final LightningDeathPlugin plugin;

	public LightningDeathCommand(LightningDeathPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//Show usage if empty command
		if (args.length == 0) {
			return false;
		}

		if (args[0].equalsIgnoreCase("reload")) {
			plugin.config.load();
			sender.sendMessage(plugin.getDescription().getName() + " reloaded");
		} else {
			return false;
		}

		// Everything went fine! \o/
		return true;
	}
}
