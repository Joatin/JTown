package com.hotmail.joatin37.JTown.api;

import java.util.UUID;

import org.bukkit.Location;

public interface ICollectionManager {
	public Plot reconstructPlot(String plugin, String type, Collection parent,
			UUID uuid);

	public boolean putNewCollection(Collection coll, Location baseloc);
}
