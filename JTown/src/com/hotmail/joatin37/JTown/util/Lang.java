package com.hotmail.joatin37.JTown.util;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Lang {

	public static Lang lang;

	public Lang(String language, JavaPlugin plugin) {

		switch (language) {
		case "custom":
			break;

		case "en-US":
			plugin.getResource("LANG" + File.separator + "en-US.LANG");
			break;

		default:
			plugin.getResource("LANG" + File.separator + "en-US.LANG");
			break;
		}

	}
}
