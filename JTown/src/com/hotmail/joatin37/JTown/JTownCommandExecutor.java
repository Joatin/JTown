package com.hotmail.joatin37.JTown;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class JTownCommandExecutor implements CommandExecutor{
	
	private JTown jtown;
	
	

	public JTownCommandExecutor(JTown town){
		jtown=town;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(sender instanceof Player){
				playerCommand(sender, cmd, label, args);
			}else{
				consoleCommand(cmd, label, args);
			}
		return true;
	}

	public void consoleCommand(Command cmd, String label, String[] args){
		
		//JAdmin commands
		if(cmd.getName().equalsIgnoreCase("jadmin")){
			if(args.length<1){
				jtown.getLogger().info("To few arguments");
				return;
			}
			
			//new town
			if(args[0].equals("newtown")){
				if(args.length!=3){
					if (args.length<3){
						jtown.getLogger().info("To few arguments");
					}else{
						jtown.getLogger().info("to many arguments");
					}
				}else{
					jtown.getLogger().info("Trying to create new town");
					createTown(args[1], args[2]);
				}
			}
		}
		
	}
	public void playerCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("jadmin")){
			if(args.length<1){
				sender.sendMessage("to few arguments");
				return;
			}
			
			//new town
			if(args[0].equals("newtown")){
				
					
			}
		}
		
	}
			
	private void createTown(String townname, String mayor){
		
	}
		
	
	

}
