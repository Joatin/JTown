package com.hotmail.joatin37.JTown.api;

import org.bukkit.Location;

public interface IWorldMap {

	public boolean canSet(Location loc);

	public boolean canSet(Location loc, Collection coll);

	public void set(Location loc, Collection coll, Plot plot);

	public void set(Location loc, Collection coll, Plot plot, short maxheight,
			short minheight);
}
