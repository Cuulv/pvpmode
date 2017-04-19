package me.none.pvpMode;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.permissions.Permission;



public class Main extends JavaPlugin implements Listener {
    private static Plugin instance;

    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        
        Bukkit.getPluginManager().registerEvents(new mainPvP(), this);
        getCommand("pvpmode").setExecutor(new pvpMode());
        getCommand("pvp").setExecutor(new pvpMode());
        
        
        
        console.sendMessage(ChatColor.GREEN + "====== PVP MODE ======");
        console.sendMessage(ChatColor.GREEN + "=========== VERSION: 1.0 ===========");
        console.sendMessage(ChatColor.GREEN + "======== BY NONE! ========");
    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getInstance() {
        return instance;
    }
    
    @SuppressWarnings("unused")
	private void registerPermissions()
    {
    	Permission reload = new Permission("pvp.reload");
    	Permission toggle = new Permission("pvp.toggle");
    	Permission all = new Permission("pvp.*");
    }
}
