package fr.jambon2parme.hat.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandHat implements CommandExecutor {

	/**
	 * @author Jambon2Parme
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {


		if (sender instanceof Player){
			
			Player player = (Player) sender;
			
			if (cmd.getName().equalsIgnoreCase("hat")){
			
				// Il faut au moins un arguement
				if (args.length != 1){
					player.sendMessage("§cUsage: /hat <help|set|remove>");
					
				// Un seul argument = OK
				} else if (args.length == 1){
					
					
					// help : affiche l'aide du plugin
					if (args[0].equalsIgnoreCase("help")){
						player.sendMessage(
								"§2[§aHat§2]§f /hat set : Replace your head by the block in your main hand\n"
								+ "§2[§aHat§2]§f /hat remove : Remove the block on your head\n"
								+ "§2[§aHat§2]§f /hat help : Display help of Hat plugin");
						
					// set : remplace la tête du joueur par le bloc dans sa main
					} else if (args[0].equalsIgnoreCase("set")){
						
						ItemStack currentBlock = player.getInventory().getItemInMainHand();
						
				
//						// Si le joueur ne tient rien =~ AIR
						if (currentBlock.getType() == Material.AIR){
							player.sendMessage("§2[§aHat§2]§f You need to hold a block in your main hand !");
						} else {
							// SUppression de l'item en main
							player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
							
							// Puis on le place sur la tête
							player.getInventory().setHelmet(currentBlock);
							player.sendMessage("§2[§aHat§2]§f Hope you like your new hat !");
							
							player.updateInventory();
						}						
					
					// remove : Supprime le bloc de la tête du joueur
					} else if (args[0].equalsIgnoreCase("remove")){
						
						// On sauvegarde le "hat" actuel ...
						ItemStack currentHead = player.getInventory().getHelmet();
						
						// Si il y a quelque chose sur la tête du joueur ...
						if (currentHead != null){
						
							// On supprime ce qu'il y a sur sa tête
							player.getInventory().setHelmet(new ItemStack(Material.AIR,1));
							player.sendMessage("§2[§aHat§2]§f Hat removed");
	
							// ... puis on le place dans l'inventaire du joueur
							player.getInventory().addItem(currentHead);
							
							player.updateInventory();
						} else {
							player.sendMessage("§2[§aHat§2]§f Nothing on your head !");
						}
					}
					

					
//					if (player.getInventory().getHelmet() != null){
//						player.sendMessage("Quelque chose sur ma tête");
//					} else {
//						player.sendMessage("Rien sur ma tête");
//					}
					
					
					
				}
								
				return true;
			}
		}
		
		
		
		
		
		
		return false;
	}

}
