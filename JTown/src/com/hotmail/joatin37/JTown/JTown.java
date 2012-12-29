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

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;

import com.hotmail.joatin37.JTown.util.GraphCollector;
import com.hotmail.joatin37.JTown.util.IJTown;
import com.hotmail.joatin37.JTown.util.JTownExtension;

public class JTown extends JTownExtension implements IJTown, Listener {

	PlayerCommandHandler playercommand;
	ServerCommandHandler servercommand;

	private int amounttowns;

	private GraphCollector graphcollector;

	private CollectionManager cmanager;

	private Economy economy;

	protected HashMap<String, JTownExtension> extensions;

	@Override
	public void onEnable() {

		this.economy = new Economy(this);

		this.cmanager = new CollectionManager(this);

		this.graphcollector = new GraphCollector(this);

		this.getServer().getPluginManager().registerEvents(this, this);

		this.getLogger().info("JTown started");

	}

	public JTown() {
		this.extensions = new HashMap<String, JTownExtension>();
	}

	@Override
	public void onLoad() {
		this.extensions.put(this.getName(), this);
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
	public Plot constructNewPlot(String plugin, String kind, Collection parent,
			UUID uuid) {
		return this.extensions.get(plugin).constructPlot(kind, parent, uuid);
	}

	@Override
	public Collection constructNewCollection(String plugin, String kind,
			UUID uuid) {
		return this.extensions.get(plugin).constructCollection(kind,
				this.cmanager, uuid, this);

	}

	@EventHandler
	public void onSave(WorldSaveEvent event) {
		this.cmanager.save();
	}

	@Override
	public void onDisable() {

		this.getLogger().info("onDisable has been invoked!");

	}

	public int getAmountTowns() {
		return this.amounttowns;
	}

	@Override
	public void add(JTownExtension extension) {
		this.extensions.put(extension.getName(), extension);
	}

	@Override
	public Economy getEconomy() {
		return this.economy;
	}

	@Override
	public Collection constructCollection(String kind,
			CollectionManager parent, UUID uuid, IJTown jtown) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plot constructPlot(String kind, Collection parent, UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}