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

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Location;
import org.bukkit.World;

import com.hotmail.joatin37.JTown.Collection;
import com.hotmail.joatin37.JTown.JTown;
import com.hotmail.joatin37.JTown.Plot;

public class WorldMap {

	private HashMap<String, WorldMapCache> caches;
	private final JTown jtown;

	public WorldMap(JTown jtown) {
		this.jtown = jtown;
		this.caches = new HashMap<String, WorldMapCache>(3, 1);
		Iterator<World> iterator = jtown.getServer().getWorlds().iterator();
		while (iterator.hasNext()) {
			String w = iterator.next().getName();
			this.caches.put(
					w,
					new WorldMapCache(this.jtown.getConfig().getInt(
							"chachesize", 1000), new File(this.jtown
							.getDataFolder(), w + ".sav"), this.jtown, w));
		}
	}

	public BlockRow get(Location loc) {
		return this.caches.get(loc.getWorld().getName()).get(loc);
	}

	public void set(Location loc, Collection coll, Plot plot) {

	}
}
