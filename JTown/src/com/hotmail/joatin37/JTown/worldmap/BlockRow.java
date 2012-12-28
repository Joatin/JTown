package com.hotmail.joatin37.JTown.worldmap;

import java.util.UUID;

public final class BlockRow {

	public static int Size = 48;

	private final UUID collection;
	private final UUID plot;
	private final int posx;
	private final int posz;
	private final int maxheight;
	private final int minheight;

	public BlockRow(UUID collection, UUID plot, int posx, int posz,
			int maxheight, int minheight) {
		this.collection = collection;
		this.plot = plot;
		this.posx = posx;
		this.posz = posz;
		this.maxheight = maxheight;
		this.minheight = minheight;
	}
}
