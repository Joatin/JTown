package com.hotmail.joatin37.JTown;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;

import com.hotmail.joatin37.JTown.api.Collection;
import com.hotmail.joatin37.JTown.api.ICollectionManager;
import com.hotmail.joatin37.JTown.api.JTownExtension;

public class Town extends Collection {

	public Town(ICollectionManager manager, UUID uuid, JTownExtension plugin,
			FileConfiguration loadfile) {
		super(manager, uuid, plugin, loadfile);
		// TODO Auto-generated constructor stub
	}

	public Town(ICollectionManager manager, UUID uuid, JTownExtension plugin,
			String name, String owner) {
		super(manager, uuid, plugin, name, owner);
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
