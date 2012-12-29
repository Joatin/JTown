package com.hotmail.joatin37.JTown.util;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class JTownExtension extends JavaPlugin {

	protected void hook() {
		IJTown jtown = (IJTown) this.getServer().getPluginManager()
				.getPlugin("JTown");
		jtown.add(this);
	}
}
