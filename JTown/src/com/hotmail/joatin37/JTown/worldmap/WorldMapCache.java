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

package com.hotmail.joatin37.JTown.worldmap;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.bukkit.Location;

import com.hotmail.joatin37.JTown.JTown;
import com.hotmail.joatin37.JTown.util.ChunkPos;

public class WorldMapCache extends LinkedHashMap<ChunkPos, JChunk> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int MAX_ENTRIES;

	private final List<ChunkPos> allchunks;

	private final File savefile;

	private final JTown jtown;

	private final String world;

	public WorldMapCache(int maxcapacity, File file, JTown jtown, String world) {
		super(maxcapacity, 0.75f, true);
		this.world = world;
		this.MAX_ENTRIES = maxcapacity;
		this.savefile = file;
		this.jtown = jtown;
		this.allchunks = this.loadAllReferences();

	}

	private List<ChunkPos> loadAllReferences() {
		Vector<ChunkPos> vec = null;
		DataInputStream input;
		try {
			input = new DataInputStream(new FileInputStream(this.savefile));

			vec = new Vector<ChunkPos>(input.readInt(), 5);
			try {
				while (true) {
					int size = input.readInt();
					int a = input.readInt();
					int b = input.readInt();
					vec.add(ChunkPos.Wrap(a, b));
					input.skip(size - 8);

				}
			} catch (EOFException e) {
				input.close();
			}
		} catch (FileNotFoundException e) {
			this.jtown.getLogger().warning(
					"No the file " + this.savefile + " was missing");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vec == null) {
			vec = new Vector<ChunkPos>();
		}
		return vec;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<ChunkPos, JChunk> eldest) {
		return this.size() > this.MAX_ENTRIES;
	}

	public BlockRow get(Location loc) {
		ChunkPos pos = ChunkPos.Wrap(loc.getChunk().getX(), loc.getChunk()
				.getZ());
		if (this.containsKey(pos)) {
			return super.get(pos).get(loc);
		} else {
			if (this.allchunks.contains(pos)) {
				JChunk jchunk = this.loadJChunk(pos);
				if (jchunk == null) {
					return null;
				} else {
					return jchunk.get(loc);
				}
			} else {
				return null;
			}
		}

	}

	private JChunk loadJChunk(ChunkPos pos) {
		return null;

	}
}
