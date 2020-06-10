package me.Danny.HelloWorld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		//startup
		//reloads
		//plugin reloads
	}
	
	@Override 
	public void onDisable() {
		//shutdown
		//reloads
		//plugin reloads
	}
	
	// /hello <-- hey welcome! pro gamer
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("hello")){
			if (sender instanceof Player) {
				//player
				Player player = (Player) sender;
				if (player.hasPermission("hello.use")) {
					player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "woah is that pro gamer Danny Jeong?:P");
					return true; 
				}
				player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "no chicken parmesean sir");
				return true; 
			}
				
			else {
				//console
				sender.sendMessage("hey console");
				return true; 
			}
				
		}
		return false;
	}
}
