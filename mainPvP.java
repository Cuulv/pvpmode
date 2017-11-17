package me.none.pvpMode;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class mainPvP implements Listener
{
	Plugin instance = Main.getInstance();
	
	
	@EventHandler
	public void pvpModeOn(pvpMode event)
	{
		if(instance.getConfig().getString("PvP Mode Enabled").equalsIgnoreCase("true"))
		{
		Player player = event.getPlayer();
		player.setMetadata("PvPMode", new FixedMetadataValue(instance, true));
		player.setCanPickupItems(false);
		
		if(player.getHealth() <= 7)
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 2));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 150, 2));
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 20, 2));
			player.sendMessage(ChatColor.GREEN + "[Cuulv]" + ChatColor.GOLD + "You are hurt, bad! Don't worry, though. I supplied potion effects to help!");
		}
		else if(player.getHealth() <= 4)
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 30, 3));
			player.sendMessage(ChatColor.GREEN + "[Cuulv]" + ChatColor.GOLD + "You are hurt, bad! Don't worry, though. I supplied potion effects to help!");
		}
		else
		{
			return;
		}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		if(instance.getConfig().getString("PvP Mode Enabled").equalsIgnoreCase("true"))
		{
			event.setCancelled(true);
		}
				
	}
	
	
	@EventHandler
	public void onBedEnter(PlayerBedEnterEvent event)
	{
		if(instance.getConfig().getString("PvP Mode Enabled").equalsIgnoreCase("true"))
		{
			event.setCancelled(true);
		}
		else
		{
			event.setCancelled(false);
			return true;
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event)
	{
		Player player = event.getPlayer();
		if(player.isDead())
		{
		player.getWorld().strikeLightning(player.getTargetBlock(null, 200).getLocation());
		return true; 
		}
	}
}
	


