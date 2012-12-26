package com.hotmail.joatin37.JTown;

import java.util.List;
import java.util.Vector;

import org.bukkit.configuration.file.FileConfiguration;

public class JTownConfig implements JTownSaveable{
	
	public List<String> townnames;
	public String ListNoTowns;
	public List<String> WorldExceptions;
	public List<String> playerlist;
	
	private JTown jtown;
	private FileConfiguration config;
	
	public JTownConfig(JTown t){
		jtown = t;
		jtown.saveDefaultConfig();
		loadConfig();
		
	}
	
	public void loadConfig(){
		config = jtown.getConfig();
		loadLists();
		
	}
	public void saveConfig(){
		jtown.saveConfig();
	}
	public void reloadConfig(){
		jtown.reloadConfig();
		loadLists();
	}
	private void loadLists(){
		townnames=config.getStringList("Town.TownNames");
		
		WorldExceptions= config.getStringList("World.WorldExceptions");
		playerlist=config.getStringList("Player.PlayerList");
	}
	public void addTown(String name){
		if(townnames == null){
			townnames = new Vector<String>();
		}
		townnames.add(name);
		config.set("Town.TownNames", townnames);
	}
	public void removeTown(String name){
		townnames.remove(name);
		config.set("Town.TownNames", townnames);
	}

	@Override
	public void save() {
		saveConfig();
		
	}
}
