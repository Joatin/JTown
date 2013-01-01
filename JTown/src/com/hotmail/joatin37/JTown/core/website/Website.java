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

package com.hotmail.joatin37.JTown.core.website;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.hotmail.joatin37.JTown.core.Core;

public class Website implements Runnable {

	private Core core;
	private FileConfiguration config = null;
	private File configfile = null;
	private SSLServerSocket socket;

	public Website(Core core) {
		this.core = core;
		this.getConfig();
		try {
			this.socket = (SSLServerSocket) SSLServerSocketFactory.getDefault()
					.createServerSocket(this.getConfig().getInt("port", 443));
		} catch (IOException e) {
			core.getPlugin()
					.getLogger()
					.warning(
							"[WebSite] Couldn't create the websocket. Please check your firewall settings.");
		}
		core.getPlugin().getServer().getScheduler()
				.runTaskAsynchronously(core.getPlugin(), this);
	}

	@Override
	public void run() {
		while (true) {
			try {
				SSLSocket csocket = (SSLSocket) this.socket.accept();
				csocket.startHandshake();
				this.core.getPlugin().getLogger()
						.info("[WebSite] New connection!!!");
				BufferedReader input = new BufferedReader(
						new InputStreamReader(csocket.getInputStream()));
				String s;
				while ((s = input.readLine()) != null) {
					this.core.getPlugin().getLogger().info("[WebSite] " + s);
				}
				OutputStream output = csocket.getOutputStream();
				output.write("<p>HEllo world!</p>".getBytes());
				output.flush();
				input.close();
				output.close();
				csocket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void save() {
		this.saveConfig();
	}

	public void reloadConfig() {
		if (this.configfile == null) {
			this.configfile = new File(this.core.getPlugin().getDataFolder(),
					"website.yml");
		}
		this.config = YamlConfiguration.loadConfiguration(this.configfile);

		// Look for defaults in the jar
		InputStream defConfigStream = this.core.getPlugin().getResource(
				"website.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration
					.loadConfiguration(defConfigStream);
			this.config.setDefaults(defConfig);
		}
	}

	public FileConfiguration getConfig() {
		if (this.config == null) {
			this.reloadConfig();
		}
		return this.config;
	}

	public void saveConfig() {
		if (this.config == null || this.configfile == null) {
			return;
		}
		try {
			this.getConfig().save(this.configfile);
		} catch (IOException ex) {
			this.core
					.getPlugin()
					.getLogger()
					.log(Level.SEVERE,
							"[WebSite] Could not save config to "
									+ this.configfile, ex);
		}
	}
}
