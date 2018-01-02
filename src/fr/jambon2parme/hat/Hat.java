package fr.jambon2parme.hat;

import org.bukkit.plugin.java.JavaPlugin;

import fr.jambon2parme.hat.commands.CommandHat;

/**
 * @author Jambon2Parme
 *
 */
public class Hat extends JavaPlugin{
	
	/**
	 * Method running on the plugin's start
	 */
	@Override
	public void onEnable() {
		System.out.println("[Hat] Start completed");
		getCommand("hat").setExecutor(new CommandHat());
	}
	
	/**
	 * Method running on the plugin's stop
	 */
	@Override
	public void onDisable() {
		System.out.println("[Hat] Stop completed");
	}
	
	

	
}
