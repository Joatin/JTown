package com.hotmail.joatin37.JTown.core.worldmap;

public class BlockPos {

	private final int x;
	private final int z;

	public BlockPos(int x, int z) {
		this.x = x;
		this.z = z;
	}

	public int getX() {
		return this.x;
	}

	public int getZ() {
		return this.z;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.z;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BlockPos)) {
			return false;
		}
		BlockPos other = (BlockPos) obj;
		if (this.x != other.x) {
			return false;
		}
		if (this.z != other.z) {
			return false;
		}
		return true;
	}
}
