package com.hotmail.joatin37.JTown;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public abstract class JTownCollection{
	
	protected HashMap<String, JTownPlot> plots;
	protected String name;
	JTown jtown;
	private FileConfiguration config = null;
	private File configfile = null;
	
	/**Game Variables**/
	private int amountbaseland;
	
	public JTownCollection(JTown town, String Name){
		jtown = town;
		reloadConfig();
	}
	
	public int getNumPlots(){
		return plots.size();
	}
	
	public abstract void onPlayerMovement(PlayerMoveEvent e);
	
	public void setOwner(Player player, String newowner){
		
	}
	
	public void addPlot(JTownPlot plot){
		
	}
	public void removePlot(JTownPlot plot){
		
	}
	
	public void resizePlot(JTownPlot plot){
		
	}
	private void reloadConfig() {
	    if (configfile == null) {
	    configfile = new File(JTown.jtowncollectionsfolder, name+".yml");
	    }
	    config = YamlConfiguration.loadConfiguration(configfile);
	    
	    // Look for defaults in the jar
	    InputStream defConfigStream = jtown.getResource("defcollection.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        config.setDefaults(defConfig);
	    }

	}
	
	private FileConfiguration getConfig() {
	    if (config == null) {
	        this.reloadConfig();
	    }
	    return config;
	}
	
	private void saveConfig() {
	    if (config == null || configfile == null) {
	    return;
	    }
	    try {
	        getConfig().save(configfile);
	    } catch (IOException ex) {
	        jtown.getLogger().log(Level.SEVERE, "Could not save config to " + configfile, ex);
	    }
	}
	
	private void removeFile(){
		configfile.delete();
	}

	
}
