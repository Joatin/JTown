package com.hotmail.joatin37.JTown.worldmap;

import java.util.HashMap;

import org.bukkit.Location;

public class JChunk {

	private final int x;
	private final int z;

	private HashMap<blockpos, BlockRow> blockrows;

	public JChunk(int x, int z) {
		this.x = x;
		this.z = z;
		this.blockrows = new HashMap<blockpos, BlockRow>();
	}

	public void put(int x, int z, BlockRow row) {
		this.blockrows.put(new blockpos(x, z), row);
	}

	public BlockRow get(Location loc) {
		return this.blockrows
				.get(new blockpos(loc.getBlockX(), loc.getBlockZ()));
	}

	public class blockpos {
		public final int x;
		public final int z;

		public blockpos(int x, int z) {
			this.x = x;
			this.z = z;
		}
	}
}
