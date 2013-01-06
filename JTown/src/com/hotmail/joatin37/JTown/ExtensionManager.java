package com.hotmail.joatin37.JTown;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.joatin37.jcore.api.Collection;
import com.hotmail.joatin37.jcore.api.ExtensionHandler;
import com.hotmail.joatin37.jcore.api.ICollectionManager;
import com.hotmail.joatin37.jcore.api.Plot;

public class ExtensionManager extends ExtensionHandler {

	public ExtensionManager(JavaPlugin plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection constructCollection(String arg0, ICollectionManager arg1,
			UUID arg2, FileConfiguration arg3) {
		return new Town(arg2, this, arg3);
	}

	@Override
	public Plot constructPlot(String arg0, Collection arg1, UUID arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
