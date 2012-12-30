package com.hotmail.joatin37.JTown.api;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.joatin37.JTown.core.CollectionManager;

public abstract class JTownExtension extends JavaPlugin {

	private IJTown jtown;
	private ICollectionManager icollectionmanager;
	private ICore core;

	protected final void hook() {
		this.core = ((IJTown) this.getServer().getPluginManager()
				.getPlugin("JTown")).getICore();
		this.core.add(this);
		this.icollectionmanager = this.core.getManager();
	}

	public abstract Collection constructCollection(String kind,
			CollectionManager parent, UUID uuid, FileConfiguration config);

	public abstract Plot constructPlot(String kind, Collection parent, UUID uuid);

	public ICollectionManager getICollectionManager() {
		return this.icollectionmanager;
	}
}
