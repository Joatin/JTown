package com.hotmail.joatin37.JTown;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;



public class JTown extends JavaPlugin implements JTownSaveable {
	int nexttownid;
	
	JTownConfig config;
	private JTownSaver saver;
	
	PlayerCommandHandler playercommand;
	ServerCommandHandler servercommand;
	
	
	
	public static File jtowncollectionsfolder;	
	public static Economy econ = null;
    public static Permission perms = null;
    public static Chat chat = null;
            
            
	public void onEnable(){
		
		jtowncollectionsfolder = new File (this.getDataFolder().getPath() + File.separator + "JTownCollections");
		jtowncollectionsfolder.mkdir();
		setupVault();
		//this.getServer().getMessenger().registerOutgoingPluginChannel(plugin, channel)
		getLogger().info("JTown started");
	
	}
	
	private void setupVault(){
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().info("Couldn't find Vault, going for op only mode");
        }else{
        	try{
        	econ = getServer().getServicesManager().getRegistration(Economy.class).getProvider();
        	}catch (Exception e){getLogger().severe("No economy binding found, you must provide a economy plugin in order to make this work");}
        	try{
        	perms = getServer().getServicesManager().getRegistration(Permission.class).getProvider();
        	}catch (Exception e){getLogger().severe("No permission plugin found, all permissions will be reserved for op's only");}
        	try{
        	chat = getServer().getServicesManager().getRegistration(Chat.class).getProvider();
        }catch (Exception e){getLogger().severe("No chat found, you must have a chat plugin for town chanels to work");}

        }
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if (sender instanceof Player) {
    			playercommand.onCommand((Player)sender, cmd, label, args);
    		}else{
    			servercommand.onCommand(sender, cmd, label, args);
    	}
		return true;
		
	}
 
	 
	public void onDisable(){
		
		getLogger().info("onDisable has been invoked!");
	
	}
	
	
	
	
	
	@Override
	public void save() {
		
		
	}
}