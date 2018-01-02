package fr.jambon2parme.hat;

import org.bukkit.plugin.java.JavaPlugin;

import fr.jambon2parme.hat.commands.CommandHat;

public class Hat extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("[Hat] Start completed");
		getCommand("hat").setExecutor(new CommandHat());
	}
	
	@Override
	public void onDisable() {
		System.out.println("[Hat] Stop completed");
	}
	
	

}
