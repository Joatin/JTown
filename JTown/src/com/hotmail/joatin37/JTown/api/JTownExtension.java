package com.hotmail.joatin37.JTown.api;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.joatin37.JTown.core.CollectionManager;

public abstract class JTownExtension extends JavaPlugin {

	private IJTown jtown;

	protected final void hook() {
		((IJTown) this.getServer().getPluginManager().getPlugin("JTown"))
				.getICore().add(this);
	}

	@Override
	public void onLoad() {
		this.hook();
	}

	public Collection constructNewCollection() {
		return null;
	}

	public abstract Collection constructCollection(String kind,
			CollectionManager parent, UUID uuid, IJTown jtown,
			FileConfiguration config);

	public abstract Plot constructPlot(String kind, Collection parent, UUID uuid);
}
