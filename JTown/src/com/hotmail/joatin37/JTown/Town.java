package com.hotmail.joatin37.JTown;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;

import com.hotmail.joatin37.JTown.util.IJTown;
import com.hotmail.joatin37.JTown.util.JTownExtension;

public class Town extends Collection {

	public Town(CollectionManager manager, UUID uuid, IJTown jtown,
			JTownExtension plugin, FileConfiguration loadfile) {
		super(manager, uuid, jtown, plugin, loadfile);
		// TODO Auto-generated constructor stub
	}

	public Town(CollectionManager manager, UUID uuid, IJTown jtown,
			JTownExtension plugin, String name, String owner) {
		super(manager, uuid, jtown, plugin, name, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getKind() {
		return "Town";
	}

	@Override
	public void onSave(FileConfiguration config) {
		// TODO Auto-generated method stub

	}

}
