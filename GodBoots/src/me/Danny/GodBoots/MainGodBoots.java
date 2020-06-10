package me.Danny.GodBoots;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class MainGodBoots extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {

		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("godboots")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("sorry wrong sender");
				return true;
			}
			Player player = (Player) sender;
			if (player.getInventory().firstEmpty() == -1) {
				//inventory is full
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.RED + "u dropped the gift bruh");
				return true;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD+ "moyang gave u a gift! poggers");
			return true;
			
		}
		return false;
	}
	
	public ItemStack getItem() {
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = boots.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN+ "boots of leaping");
		List <String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GOLD + "boots made for the minecraft goooods");
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);	
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 10, true);		
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		meta.addEnchant(Enchantment.DEPTH_STRIDER, 10, true);		
			

		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		boots.setItemMeta(meta);
		
		return boots;
	}
	
	@EventHandler
	public void onJump(PlayerMoveEvent event) {
		Player player = (Player) event.getPlayer();
		if(player.getInventory().getBoots() != null) 
			if(player.getInventory().getBoots().getItemMeta().getDisplayName().contains("boots of leaping"))
				if(player.getInventory().getBoots().getItemMeta().hasLore())
					if(event.getFrom().getY() < event.getTo().getY() &&
							player.getLocation().subtract(0,1,0).getBlock().getType() != Material.AIR) {
						player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
					}
	}

	
	@EventHandler
	public void onFall (EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (event.getCause() == DamageCause.FALL)
				if(player.getInventory().getBoots().getItemMeta().getDisplayName().contains("boots of leaping"))
					if(player.getInventory().getBoots().getItemMeta().hasLore()) {
						event.setCancelled(true);
					}
		}
	}
}
