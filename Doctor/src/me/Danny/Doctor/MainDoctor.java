package me.Danny.Doctor;

import org.bukkit.plugin.java.JavaPlugin;

public class MainDoctor extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("Doctor").setExecutor(new Heal());
	}
	
	@Override 
	public void onDisable() {
		//shutdown
		//reloads
		//plugin reloads
	}


}
