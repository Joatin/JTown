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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.Files;
import com.hotmail.joatin37.JTown.api.Collection;
import com.hotmail.joatin37.JTown.api.Plot;
import com.hotmail.joatin37.JTown.core.ChunkPos;

public class WorldMapCache extends LinkedHashMap<ChunkPos, JChunk> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int VERSION = 1;

	private final int MAX_ENTRIES;

	private final List<ChunkPos> allchunks;

	private final HashMap<ChunkPos, JChunk> dirtychunks;

	private final File savefile;

	private final JavaPlugin jtown;

	private final String world;

	public WorldMapCache(int maxcapacity, File file, JavaPlugin jtown,
			String world) {
		super(maxcapacity, 0.75f, true);
		this.world = world;
		this.MAX_ENTRIES = maxcapacity;
		this.savefile = file;
		this.jtown = jtown;
		this.allchunks = this.loadAllReferences();
		this.dirtychunks = new HashMap<ChunkPos, JChunk>();

	}

	protected void putJ(ChunkPos key, JChunk value) {
		this.put(key, value);
		this.dirtychunks.put(key, value);
		if (!this.allchunks.contains(key)) {
			this.allchunks.add(key);
		}

	}

	public void set(Location loc, Collection coll, Plot plot, short maxheight,
			short minheight) {
		ChunkPos pos = ChunkPos.Wrap(loc.getChunk().getX(), loc.getChunk()
				.getZ());
		JChunk chunk;
		UUID cuuid;
		UUID plotuuid = null;
		BlockRow row;
		if (coll == null) {
			row = null;
		} else {
			cuuid = coll.getUUID();
			if (plot != null) {
				plotuuid = plot.getUUID();
			}
			row = new BlockRow(cuuid, plotuuid, loc.getBlockX(),
					loc.getBlockZ(), maxheight, minheight);
		}
		if ((chunk = this.dirtychunks.get(pos)) != null) {
			chunk.put(loc.getBlockX(), loc.getBlockZ(), row);
			this.putJ(pos, chunk);
		} else {
			chunk = super.get(loc);
			if (chunk == null) {
				chunk = this.getJChunk(pos);
				if (chunk == null) {
					chunk = new JChunk(loc.getChunk().getX(), loc.getChunk()
							.getZ());
				}
			}
			chunk.put(loc.getBlockX(), loc.getBlockZ(), row);
			this.putJ(pos, chunk);
		}
		return;
		// TODO
	}

	public void save() {
		// TODO
		File sfile;
		DataInputStream input;
		DataOutputStream output;
		try {
			sfile = File.createTempFile("tempfile", null,
					this.savefile.getParentFile());
			input = new DataInputStream(new FileInputStream(this.savefile));
			output = new DataOutputStream(new FileOutputStream("temp"));
			input.readInt(); // reads the version int;
			output.writeInt(this.VERSION);
			try {
				while (true) {
					int size = input.readInt();
					int a = input.readInt();
					int b = input.readInt();
					ChunkPos pos = ChunkPos.Wrap(a, b);
					if (this.dirtychunks.containsKey(pos)) {

					} else {
						byte[] ba = new byte[size - 8];
						input.read(ba);
						output.writeInt(size);
						output.writeInt(a);
						output.writeInt(b);
						output.write(ba);
					}
				}
			} catch (EOFException e) {
			}

			if (this.dirtychunks.size() != 0) {
				Iterator<JChunk> dirty = this.dirtychunks.values().iterator();
				while (dirty.hasNext()) {

				}
			}
			Files.copy(sfile, this.savefile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<ChunkPos> loadAllReferences() {
		Vector<ChunkPos> vec = null;
		DataInputStream input;
		try {
			input = new DataInputStream(new FileInputStream(this.savefile));
			input.readInt(); // reads the version number;
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
					"The file " + this.savefile + " was missing");
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
			return this.get(pos).get(loc);
		} else {
			JChunk jchunk = this.getJChunk(pos);
			if (jchunk == null) {
				return null;
			} else {
				return jchunk.get(loc);
			}
		}

	}

	private JChunk getJChunk(ChunkPos pos) {
		if (this.allchunks.contains(pos)) {
			DataInputStream input;
			try {
				input = new DataInputStream(new FileInputStream(this.savefile));
				input.skip(8);
				try {
					while (true) {
						int size = input.readInt();
						int a = input.readInt();
						int b = input.readInt();
						if (a == pos.getX() && b == pos.getZ()) {
							JChunk chunk = new JChunk(a, b);
							for (int i = 0; i < size - 8 / BlockRow.Size; i++) {
								long l1 = input.readLong();
								long l2 = input.readLong();
								long l3 = input.readLong();
								long l4 = input.readLong();
								int i1 = input.readInt();
								int i2 = input.readInt();
								int i3 = input.readInt();
								int i4 = input.readInt();
								UUID uuid1 = null;
								UUID uuid2 = null;
								if (l1 != 0 && l2 != 0) {
									uuid1 = new UUID(l1, l2);
								}
								if (l3 != 0 && l4 != 0) {
									uuid1 = new UUID(l3, l4);
								}
								chunk.put(i1, 12, new BlockRow(uuid1, uuid2,
										i1, i2, i3, i4));
							}
							input.close();
							return chunk;
						}

						input.skip(size - 8);

					}

				} catch (EOFException e) {
					input.close();
					return null;
				}
			} catch (FileNotFoundException e) {
				this.jtown.getLogger().warning(
						"No the file " + this.savefile + " was missing");
				this.savefile.mkdir();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}
