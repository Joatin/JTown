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

package com.hotmail.joatin37.JTown.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerChannelEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.joatin37.JTown.api.Collection;
import com.hotmail.joatin37.JTown.api.ICollectionManager;
import com.hotmail.joatin37.JTown.api.Plot;
import com.hotmail.joatin37.JTown.core.worldmap.BlockRow;
import com.hotmail.joatin37.JTown.core.worldmap.WorldMap;

public final class CollectionManager implements Listener, ICollectionManager {

	private HashMap<UUID, Collection> collections;
	private final JavaPlugin jtown;
	private File configfile;
	private FileConfiguration saveconfig;
	private WorldMap worldmap;
	private HashMap<String, Collection> players;

	public CollectionManager(JavaPlugin jtown) {
		this.jtown = jtown;
		this.players = new HashMap<String, Collection>();
		this.collections = new HashMap<UUID, Collection>();

		this.load();

	}

	private Collection reconstructCollection(String plugin, String type,
			UUID uuid) {
		return null;
	}

	@Override
	public Plot reconstructPlot(String plugin, String type, Collection parent,
			UUID uuid) {
		return null;
	}

	protected void onInit() {
		this.worldmap = new WorldMap(this.jtown);
		this.jtown.getServer().getPluginManager()
				.registerEvents(this, this.jtown);
	}

	public FileConfiguration getConfig() {
		return this.saveconfig;
	}

	public boolean putNewCollection(Collection coll, Location baseloc) {

		List<Location> list = new Vector<Location>();
		int x = baseloc.getBlockX();
		int z = baseloc.getBlockZ();
		list.add(new Location(baseloc.getWorld(), x - 1, 0, z - 1));
		list.add(new Location(baseloc.getWorld(), x - 1, 0, z));
		list.add(new Location(baseloc.getWorld(), x - 1, 0, z + 1));
		list.add(new Location(baseloc.getWorld(), x, 0, z - 1));
		list.add(new Location(baseloc.getWorld(), x, 0, z));
		list.add(new Location(baseloc.getWorld(), x, 0, z + 1));
		list.add(new Location(baseloc.getWorld(), x + 1, 0, z - 1));
		list.add(new Location(baseloc.getWorld(), x + 1, 0, z));
		list.add(new Location(baseloc.getWorld(), x + 1, 0, z + 1));
		Iterator<Location> it = list.iterator();
		while (it.hasNext()) {
			if (!this.worldmap.canSet(it.next())) {
				return false;
			}
		}
		Iterator<Location> it2 = list.iterator();
		this.collections.put(coll.getUUID(), coll);
		while (it2.hasNext()) {
			this.worldmap.set(it2.next(), coll, null);
		}
		return true;
	}

	private void load() {
		if (this.configfile == null) {
			this.configfile = new File(this.jtown.getDataFolder(),
					"collections.sav");
		}
		this.saveconfig = YamlConfiguration.loadConfiguration(this.configfile);
		List<String> list = this.saveconfig.getStringList("collections");
		if (list == null) {
			return;
		}
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			Collection coll = this.reconstructCollection(
					JUtil.getPluginFromUuidString(s),
					JUtil.getTypeFromUuidString(s), JUtil.stringToUUID(s));
			this.collections.put(JUtil.stringToUUID(s), coll);
			// TODO if(coll instanceof town)
		}

	}

	public void save() {
		if (this.saveconfig == null || this.configfile == null) {
			return;
		}
		List<String> list = new Vector<String>();
		Iterator<Collection> it = this.collections.values().iterator();
		while (it.hasNext()) {
			Collection coll = it.next();
			list.add(JUtil.uuidToString(coll.save(this.saveconfig)) + ";"
					+ coll.getPluginName() + ";" + coll.getKind());
		}
		this.saveconfig.set("collections", list);
		try {
			this.saveconfig.save(this.configfile);
			this.jtown.getLogger().info("Succesfully saved collections.sav");
		} catch (IOException ex) {
			this.jtown.getLogger().log(Level.SEVERE,
					"Could not save config to " + this.configfile, ex);
		}
		this.worldmap.save();
	}

	public void createNewCollection(Player player, String name) {

	}

	/*------EventListeners------*/

	// block listeners

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockBreakEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockBurnEvent(BlockBurnEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockBurnEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockCanBuildEvent(BlockCanBuildEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockCanBuildEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockDamageEvent(BlockDamageEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockDamageEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockDispenseEvent(BlockDispenseEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockDispenseEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockExpEvent(BlockExpEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockExpEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockFadeEvent(BlockFadeEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockFadeEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockFormEvent(BlockFormEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockFormEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockFromToEvent(BlockFromToEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockFromToEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockGrowEvent(BlockGrowEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockGrowEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockIgniteEvent(BlockIgniteEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockIgniteEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPhysicsEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockPistonExtendEvent(BlockPistonExtendEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPistonExtendEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockPistonRetractEvent(BlockPistonRetractEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPistonRetractEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPlaceEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockRedstoneEvent(BlockRedstoneEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockRedstoneEvent(event, row);
		}
	}

	@EventHandler
	public void onBlockSpreadEvent(BlockSpreadEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockSpreadEvent(event, row);
		}
	}

	@EventHandler
	public void onEntityBlockFormEvent(EntityBlockFormEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.EntityBlockFormEvent(event, row);
		}
	}

	@EventHandler
	public void onLeavesDecayEvent(LeavesDecayEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.LeavesDecayEvent(event, row);
		}
	}

	@EventHandler
	public void onNotePlayEvent(NotePlayEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.NotePlayEvent(event, row);
		}
	}

	@EventHandler
	public void onSignChangeEvent(SignChangeEvent event) {

		BlockRow row = this.worldmap.get(event.getBlock().getLocation());
		if (row == null) {
			return;
		}
		Collection coll = this.collections.get(row.getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.SignChangeEvent(event, row);
		}
	}

	// enchantment listeners

	@EventHandler
	public void onEnchantItemEvent(EnchantItemEvent event) {

	}

	@EventHandler
	public void onPrepareItemEnchantEvent(PrepareItemEnchantEvent event) {

	}

	// enitity listeners

	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent event) {

	}

	@EventHandler
	public void onCreeperPowerEvent(CreeperPowerEvent event) {

	}

	@EventHandler
	public void onEntityBreakDoorEvent(EntityBreakDoorEvent event) {

	}

	@EventHandler
	public void onEntityChangeBlockEvent(EntityChangeBlockEvent event) {

	}

	@EventHandler
	public void onEntityCombustByBlockEvent(EntityCombustByBlockEvent event) {

	}

	@EventHandler
	public void onEntityCombustByEntityEvent(EntityCombustByEntityEvent event) {

	}

	@EventHandler
	public void onEntityCombustEvent(EntityCombustEvent event) {

	}

	@EventHandler
	public void onEntityCreatePortalEvent(EntityCreatePortalEvent event) {

	}

	@EventHandler
	public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event) {

	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {

	}

	@EventHandler
	public void onEntityDamageEvent(EntityDamageEvent event) {

	}

	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent event) {

	}

	@EventHandler
	public void onEntityInteractEvent(EntityInteractEvent event) {

	}

	@EventHandler
	public void onEntityPortalEnterEvent(EntityPortalEnterEvent event) {

	}

	@EventHandler
	public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {

	}

	@EventHandler
	public void onEntityShootBowEvent(EntityShootBowEvent event) {

	}

	@EventHandler
	public void onEntityTameEvent(EntityTameEvent event) {

	}

	@EventHandler
	public void onEntityTargetEvent(EntityTargetEvent event) {

	}

	@EventHandler
	public void onEntityTargetLivingEntityEvent(
			EntityTargetLivingEntityEvent event) {

	}

	@EventHandler
	public void onEntityTeleportEvent(EntityTeleportEvent event) {

	}

	@EventHandler
	public void onExpBottleEvent(ExpBottleEvent event) {

	}

	@EventHandler
	public void onExplosionPrimeEvent(ExplosionPrimeEvent event) {

	}

	@EventHandler
	public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {

	}

	@EventHandler
	public void onItemDespawnEvent(ItemDespawnEvent event) {

	}

	@EventHandler
	public void onItemSpawnEvent(ItemSpawnEvent event) {

	}

	@EventHandler
	public void onPigZapEvent(PigZapEvent event) {

	}

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent event) {

	}

	@EventHandler
	public void onPotionSplashEvent(PotionSplashEvent event) {

	}

	@EventHandler
	public void onProjectileHitEvent(ProjectileHitEvent event) {

	}

	@EventHandler
	public void onProjectileLaunchEvent(ProjectileLaunchEvent event) {

	}

	@EventHandler
	public void onSheepDyeWoolEvent(SheepDyeWoolEvent event) {

	}

	@EventHandler
	public void onSheepRegrowWoolEvent(SheepRegrowWoolEvent event) {

	}

	@EventHandler
	public void onSlimeSplitEvent(SlimeSplitEvent event) {

	}

	// hanging listeners

	@EventHandler
	public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {

	}

	@EventHandler
	public void onHangingBreakEvent(HangingBreakEvent event) {

	}

	@EventHandler
	public void onHangingPlaceEvent(HangingPlaceEvent event) {

	}

	// inventory listeners

	@EventHandler
	public void onBrewEvent(BrewEvent event) {

	}

	@EventHandler
	public void onCraftItemEvent(CraftItemEvent event) {

	}

	@EventHandler
	public void onFurnaceBurnEvent(FurnaceBurnEvent event) {

	}

	@EventHandler
	public void onFurnaceExtractEvent(FurnaceExtractEvent event) {

	}

	@EventHandler
	public void onFurnaceSmeltEvent(FurnaceSmeltEvent event) {

	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent event) {

	}

	@EventHandler
	public void onInventoryCloseEvent(InventoryCloseEvent event) {

	}

	@EventHandler
	public void onInventoryEvent(InventoryEvent event) {

	}

	@EventHandler
	public void onInventoryOpenEvent(InventoryOpenEvent event) {

	}

	@EventHandler
	public void onPrepareItemCraftEvent(PrepareItemCraftEvent event) {

	}

	// player listeners

	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {

	}

	@EventHandler
	public void onAsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {

	}

	@EventHandler
	public void onPlayerAnimationEvent(PlayerAnimationEvent event) {

	}

	@EventHandler
	public void onPlayerBedEnterEvent(PlayerBedEnterEvent event) {

	}

	@EventHandler
	public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event) {

	}

	@EventHandler
	public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event) {

	}

	@EventHandler
	public void onPlayerBucketFillEvent(PlayerBucketFillEvent event) {

	}

	@EventHandler
	public void onPlayerChangedWorldEvent(PlayerChangedWorldEvent event) {

	}

	@EventHandler
	public void onPlayerChannelEvent(PlayerChannelEvent event) {

	}

	@EventHandler
	public void onPlayerChatTabCompleteEvent(PlayerChatTabCompleteEvent event) {

	}

	@EventHandler
	public void onPlayerCommandPreprocessEvent(
			PlayerCommandPreprocessEvent event) {

	}

	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {

	}

	@EventHandler
	public void onPlayerEggThrowEvent(PlayerEggThrowEvent event) {

	}

	@EventHandler
	public void onPlayerExpChangeEvent(PlayerExpChangeEvent event) {

	}

	@EventHandler
	public void onPlayerFishEvent(PlayerFishEvent event) {

	}

	@EventHandler
	public void onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent event) {

	}

	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {

	}

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {

	}

	@EventHandler
	public void onPlayerItemBreakEvent(PlayerItemBreakEvent event) {

	}

	@EventHandler
	public void onPlayerItemHeldEvent(PlayerItemHeldEvent event) {

	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Collection coll;
		BlockRow row = this.worldmap.get(event.getPlayer().getLocation());
		if (row == null) {
			coll = null;
		} else {
			coll = this.collections.get(row.getCollectionId());
			coll.PlayerEntered(event.getPlayer(), row, null);
		}
		this.players.put(event.getPlayer().getName(), coll);
	}

	@EventHandler
	public void onPlayerKickEvent(PlayerKickEvent event) {

	}

	@EventHandler
	public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent event) {

	}

	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent event) {

	}

	@EventHandler
	public void onPlayerPortalEvent(PlayerMoveEvent event) {

	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {

	}

	@EventHandler
	public void onPlayerRegisterChannelEvent(PlayerRegisterChannelEvent event) {

	}

	@EventHandler
	public void onPlayerRespawnEvent(PlayerRespawnEvent event) {

	}

	@EventHandler
	public void onPlayerShearEntityEvent(PlayerShearEntityEvent event) {

	}

	@EventHandler
	public void onPlayerTeleportEvent(PlayerTeleportEvent event) {

	}

	@EventHandler
	public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent event) {

	}

	@EventHandler
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {

	}

	@EventHandler
	public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent event) {

	}

	@EventHandler
	public void onPlayerUnregisterChannelEvent(
			PlayerUnregisterChannelEvent event) {

	}

	@EventHandler
	public void onPlayerVelocityEvent(PlayerVelocityEvent event) {

	}

	// vehicle listeners

	@EventHandler
	public void onVehicleBlockCollisionEvent(VehicleBlockCollisionEvent event) {

	}

	@EventHandler
	public void onVehicleCreateEvent(VehicleCreateEvent event) {

	}

	@EventHandler
	public void onVehicleDamageEvent(VehicleDamageEvent event) {

	}

	@EventHandler
	public void onVehicleDestroyEvent(VehicleDestroyEvent event) {

	}

	@EventHandler
	public void onVehicleEnterEvent(VehicleEnterEvent event) {

	}

	@EventHandler
	public void onVehicleEntityCollisionEvent(VehicleEntityCollisionEvent event) {

	}

	@EventHandler
	public void onVehicleExitEvent(VehicleExitEvent event) {

	}

	@EventHandler
	public void onVehicleMoveEvent(VehicleMoveEvent event) {

	}

	@EventHandler
	public void onVehicleUpdateEvent(VehicleUpdateEvent event) {

	}

	// weather listeners

	@EventHandler
	public void onLightningStrikeEvent(LightningStrikeEvent event) {

	}

	// world listeners

	@EventHandler
	public void onPortalCreateEvent(PortalCreateEvent event) {

	}

	@EventHandler
	public void onStructureGrowEvent(StructureGrowEvent event) {

	}

}
