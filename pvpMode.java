package me.none.pvpMode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class pvpMode implements CommandExecutor {
	 private Plugin instance = Main.getInstance();
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		
		if(cmd.getName().equalsIgnoreCase("pvpmode") || cmd.getName().equalsIgnoreCase("pvp"))
		{
			if(args.length == 0)
			{
				sender.sendMessage("==== PVP Mode By Cuulv ====");
				sender.sendMessage("========= Version 1.0 =========");
				if(sender.hasPermission("pvp.toggle")) sender.sendMessage("/pvp <on/off> - Turns PvP Mode On Or Off");
				if(sender.hasPermission("pvp.reload")) sender.sendMessage("/pvp reload - Reloads PvPMode");
			}
			else
			{
				if(args[0].equalsIgnoreCase("on"))
				{
					if(sender.hasPermission("pvp.toggle") || (sender.hasPermission("pvp.*")))
					{
						// Enable PvPMode
						instance.getConfig().set("PvpMode Enabled", "true");
						instance.saveConfig();
						sender.sendMessage("PvP Mode is enabled!");
					}
					else if(args[0].equalsIgnoreCase("off"))
					{
						if(sender.hasPermission("pvp.toggle") || (sender.hasPermission("pvp.*")))
						{
							// Disable PvPMode
							instance.getConfig().set("PvPMode Enabled", "false");
							instance.saveConfig();
							sender.sendMessage("PvP Mode is disabled! RIP");
						}
						else if(args[0].equalsIgnoreCase("reload"))
						{
							if(sender.hasPermission("pvp.reload") || (sender.hasPermission("pvp.*")))
							{
								// Reload it
								instance.reloadConfig();
								sender.sendMessage("Reloaded!");
							}
						}
					}
				}
			}
		}
		return true;
		
	}


	

	public Player getPlayer() {
		return null;
	}

}
