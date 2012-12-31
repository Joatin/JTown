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

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.hotmail.joatin37.JTown.core.BlockEditMode;

public class PlayerCommandHandler {

	private final JTown jtown;

	public PlayerCommandHandler(JTown jtown) {
		this.jtown = jtown;
	}

	public void onCommand(Player player, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("town")) {
			if (args.length == 0) {

			} else {
				switch (args[0]) {
				case "new":
					player.sendMessage("You created a new collection");
					this.jtown.getICollectionManager().putNewCollection(
							new Town(this.jtown.getICollectionManager(),
									UUID.randomUUID(), this.jtown,
									"Firts coll", player.getName()),
							player.getLocation());

					break;

				case "start":
					BlockEditMode.Start(this.jtown, player,
							this.jtown.getICollectionManager()
									.getCurrentCollection(player.getName()));
					break;
				case "pin":
					BlockEditMode.addPinPoint(player);
					break;

				}
			}
		}

	}
}
