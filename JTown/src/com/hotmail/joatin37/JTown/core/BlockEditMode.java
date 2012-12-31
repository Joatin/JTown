package com.hotmail.joatin37.JTown.core;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.joatin37.JTown.api.Collection;
import com.hotmail.joatin37.JTown.api.IWorldMap;
import com.hotmail.joatin37.JTown.api.Plot;

public class BlockEditMode {

	private static HashMap<String, EditHolder> edits = new HashMap<String, EditHolder>(
			20);
	protected static IWorldMap map;

	public BlockEditMode(Core core) {
		map = core.getManager().getWorldMap();
	}

	public static void Start(JavaPlugin plugin, Player player, Collection coll) {
		if (plugin != null && player != null /* && coll != null */) {
			edits.put(player.getName(), new EditHolder(plugin, player, coll,
					map));
		}
	}

	public static void Start(JavaPlugin plugin, Player player, Plot plot) {
		edits.put(player.getName(), new EditHolder(plugin, player, plot, map));
	}

	public static void addPinPoint(Player player) {
		edits.get(player.getName()).addPinPoint(player.getLocation());
	}

	public static void Finish(Player player) {
		edits.get(player.getName()).Stop();
		edits.remove(player.getName());
	}

	public static void Abort(Player player) {
		edits.get(player.getName()).Stop();
		edits.remove(player.getName());
	}

}
