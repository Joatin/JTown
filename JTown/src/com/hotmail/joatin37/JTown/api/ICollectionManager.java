package com.hotmail.joatin37.JTown.api;

import java.util.UUID;

public interface ICollectionManager {
	public Plot reconstructPlot(String plugin, String type, Collection parent,
			UUID uuid);
}
