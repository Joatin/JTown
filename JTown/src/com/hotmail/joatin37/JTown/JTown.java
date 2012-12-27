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

package com.hotmail.joatin37.JTown;

import java.io.File;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class JTown extends JavaPlugin implements JTownSaveable {
	int nexttownid;

	JTownConfig config;
	private JTownSaver saver;

	PlayerCommandHandler playercommand;
	ServerCommandHandler servercommand;

	public static File jtowncollectionsfolder;
	public static Economy econ = null;
	public static Permission perms = null;
	public static Chat chat = null;

	@Override
	public void onEnable() {

		jtowncollectionsfolder = new File(this.getDataFolder().getPath()
				+ File.separator + "JTownCollections");
		jtowncollectionsfolder.mkdir();
		this.setupVault();
		// this.getServer().getMessenger().registerOutgoingPluginChannel(plugin,
		// channel)
		this.getLogger().info("JTown started");

	}

	private void setupVault() {
		if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
			this.getLogger()
					.info("Couldn't find Vault, going for op only mode");
		} else {
			try {
				econ = this.getServer().getServicesManager()
						.getRegistration(Economy.class).getProvider();
			} catch (Exception e) {
				this.getLogger()
						.severe("No economy binding found, you must provide a economy plugin in order to make this work");
			}
			try {
				perms = this.getServer().getServicesManager()
						.getRegistration(Permission.class).getProvider();
			} catch (Exception e) {
				this.getLogger()
						.severe("No permission plugin found, all permissions will be reserved for op's only");
			}
			try {
				chat = this.getServer().getServicesManager()
						.getRegistration(Chat.class).getProvider();
			} catch (Exception e) {
				this.getLogger()
						.severe("No chat found, you must have a chat plugin for town chanels to work");
			}

		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender instanceof Player) {
			this.playercommand.onCommand((Player) sender, cmd, label, args);
		} else {
			this.servercommand.onCommand(sender, cmd, label, args);
		}
		return true;

	}

	@Override
	public void onDisable() {

		this.getLogger().info("onDisable has been invoked!");

	}

	@Override
	public void save() {

	}
}