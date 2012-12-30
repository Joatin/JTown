/*
 * Copyright 2013 Joatin Granlund. All rights reserved.
 *
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 *    conditions and the following disclaimer.
 *
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list
 *    of conditions and the following disclaimer in the documentation and/or other materials
 *    provided with the distribution.
 *
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * 
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

package com.hotmail.joatin37.JTown.core.worldmap;

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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.getOuterType().hashCode();
			result = prime * result + this.x;
			result = prime * result + this.z;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof blockpos)) {
				return false;
			}
			blockpos other = (blockpos) obj;
			if (!this.getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (this.x != other.x) {
				return false;
			}
			if (this.z != other.z) {
				return false;
			}
			return true;
		}

		public final int x;
		public final int z;

		public blockpos(int x, int z) {
			this.x = x;
			this.z = z;
		}

		private JChunk getOuterType() {
			return JChunk.this;
		}
	}

}
