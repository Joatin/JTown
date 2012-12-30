package com.hotmail.joatin37.JTown.util;

import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.joatin37.JTown.Collection;
import com.hotmail.joatin37.JTown.CollectionManager;
import com.hotmail.joatin37.JTown.Economy;
import com.hotmail.joatin37.JTown.Plot;

public abstract class JTownExtension extends JavaPlugin {

	private IJTown jtown;

	protected final void hook() {
		this.jtown = (IJTown) this.getServer().getPluginManager()
				.getPlugin("JTown");
		this.jtown.add(this);
		this.getLogger().info("Succesfully hooked to JTown");
	}

	@Override
	public void onLoad() {
		this.hook();
	}

	public Economy getEconomy() {
		return this.jtown.getEconomy();
	}

	public Collection constructNewCollection() {
		return null;
	}

	public abstract Collection constructCollection(String kind,
			CollectionManager parent, UUID uuid, IJTown jtown);

	public abstract Plot constructPlot(String kind, Collection parent, UUID uuid);
}
