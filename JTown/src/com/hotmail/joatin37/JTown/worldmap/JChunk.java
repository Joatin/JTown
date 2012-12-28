package com.hotmail.joatin37.JTown.worldmap;

import java.util.HashMap;

import org.bukkit.Location;

public class JChunk {

	private HashMap<blockpos, BlockRow> blockrows;

	public JChunk() {

	}

	public BlockRow get(Location loc) {
		return this.blockrows.get(new blockpos(loc.getBlockX(),
				loc.getBlockY(), loc.getBlockZ()));
	}

	private class blockpos {
		public final int x;
		public final int y;
		public final int z;

		public blockpos(int x, int y, int z) {
			this.x = x;
			this.z = z;
			this.y = y;
		}
	}
}
