package com.hotmail.joatin37.JTown.util;

public class ChunkPos {

	private final int x;
	private final int z;

	public static ChunkPos Wrap(int x, int z) {
		return new ChunkPos(x, z);
	}

	private ChunkPos(int x, int z) {
		this.x = x;
		this.z = z;
	}

	public int getX() {
		return this.x;
	}

	public int getZ() {
		return this.z;
	}
}
