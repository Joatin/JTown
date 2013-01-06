package com.hotmail.joatin37.JTown;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerMoveEvent;

import com.hotmail.joatin37.jcore.api.Collection;
import com.hotmail.joatin37.jcore.api.ExtensionHandler;

public class Town extends Collection {

	public Town(UUID uuid, ExtensionHandler plugin, String name, String owner) {
		super(uuid, plugin, name, owner);
		// TODO Auto-generated constructor stub
	}

	public Town(UUID uuid, ExtensionHandler plugin, FileConfiguration config) {
		super(uuid, plugin, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getKind() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onSave(FileConfiguration arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		event.getPlayer().sendMessage("§4Moving!");
	}

}
