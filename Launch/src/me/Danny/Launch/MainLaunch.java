package me.Danny.Launch;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainLaunch extends JavaPlugin{

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
	
	// /launch 
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch")){
			if (!(sender instanceof Player)) {
				sender.sendMessage("console go boom");
				return true;
			}
			Player player = (Player) sender; 
			//launch /launch number
			if (args.length == 0) {
				player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "zoooom!");
				player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
				
			
				return true;
			}
			if (isNum(args[0])) {
				player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "zoooom!");
				player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
			
			}
			else {
				player.sendMessage(ChatColor.RED + "Usage: /launch + number");
			}
				return true;
		}
		return false;
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
	
