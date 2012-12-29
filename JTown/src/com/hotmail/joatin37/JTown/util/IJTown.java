package com.hotmail.joatin37.JTown.util;

import java.util.UUID;

import com.hotmail.joatin37.JTown.Collection;
import com.hotmail.joatin37.JTown.Economy;
import com.hotmail.joatin37.JTown.Plot;

public interface IJTown {
	public void add(JTownExtension extension);

	public Economy getEconomy();

	public Plot constructNewPlot(String plugin, String kind, Collection parent,
			UUID uuid);

	public Collection constructNewCollection(String plugin, String kind,
			UUID uuid);
}
