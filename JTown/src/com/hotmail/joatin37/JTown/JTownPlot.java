package com.hotmail.joatin37.JTown;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class JTownPlot {
	
	
	
	private String owner;
	protected JavaPlugin plugin;
	
	public JTownPlot(JavaPlugin jplugin, JTownCollection owner){
		plugin = jplugin;
	}
	
	public abstract String plotType();

	public abstract String[] plotsThisTypeCanBePlacedIn();
	
	public abstract void onPlayerMovement(PlayerMoveEvent e);
}
