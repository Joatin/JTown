package com.hotmail.joatin37.JTown.worldmap;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Location;
import org.bukkit.World;

import com.hotmail.joatin37.JTown.Collection;
import com.hotmail.joatin37.JTown.JTown;
import com.hotmail.joatin37.JTown.Plot;

public class WorldMap {

	private HashMap<String, WorldMapCache> caches;
	private final JTown jtown;

	public WorldMap(JTown jtown) {
		this.jtown = jtown;
		this.caches = new HashMap<String, WorldMapCache>(3, 1);
		Iterator<World> iterator = jtown.getServer().getWorlds().iterator();
		while (iterator.hasNext()) {
			String w = iterator.next().getName();
			this.caches.put(
					w,
					new WorldMapCache(this.jtown.getConfig().getInt(
							"chachesize", 1000), new File(this.jtown
							.getDataFolder(), w + ".sav"), this.jtown, w));
		}
	}

	public BlockRow get(Location loc) {
		return this.caches.get(loc.getWorld().getName()).get(loc);
	}

	public void set(Location loc, Collection coll, Plot plot) {

	}
}
