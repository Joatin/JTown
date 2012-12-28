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
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

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
import org.bukkit.event.player.PlayerLoginEvent;
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

import com.hotmail.joatin37.JTown.worldmap.WorldMap;

public final class CollectionManager implements Listener {

	private HashMap<UUID, Collection> collections;
	private final JTown jtown;
	private File configfile;
	private FileConfiguration saveconfig;
	private WorldMap worldmap;

	public CollectionManager(JTown jtown) {
		this.jtown = jtown;
		this.collections = new HashMap<UUID, Collection>();
		this.worldmap = new WorldMap(this.jtown);
		this.jtown.getServer().getPluginManager()
				.registerEvents(this, this.jtown);

	}

	private void load() {
		if (this.configfile == null) {
			this.configfile = new File(this.jtown.getDataFolder(),
					"collections.sav");
		}
		this.saveconfig = YamlConfiguration.loadConfiguration(this.configfile);

	}

	private void save() {
		if (this.saveconfig == null || this.configfile == null) {
			return;
		}
		try {
			this.saveconfig.save(this.configfile);
			this.jtown.getLogger().info("Succesfully saved collections.sav");
		} catch (IOException ex) {
			this.jtown.getLogger().log(Level.SEVERE,
					"Could not save config to " + this.configfile, ex);
		}
	}

	public void createNewCollection(Player player, String name) {

	}

	/*------EventListeners------*/

	// block listeners

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockBreakEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockBurnEvent(BlockBurnEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockBurnEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockCanBuildEvent(BlockCanBuildEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockCanBuildEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockDamageEvent(BlockDamageEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockDamageEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockDispenseEvent(BlockDispenseEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockDispenseEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockExpEvent(BlockExpEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockExpEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockFadeEvent(BlockFadeEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockFadeEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockFormEvent(BlockFormEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockFormEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockFromToEvent(BlockFromToEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockFromToEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockGrowEvent(BlockGrowEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockGrowEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockIgniteEvent(BlockIgniteEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockIgniteEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPhysicsEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockPistonExtendEvent(BlockPistonExtendEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPistonExtendEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockPistonRetractEvent(BlockPistonRetractEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPistonRetractEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockPlaceEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockRedstoneEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onBlockSpreadEvent(BlockSpreadEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.BlockSpreadEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onEntityBlockFormEvent(EntityBlockFormEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.EntityBlockFormEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onLeavesDecayEvent(LeavesDecayEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.LeavesDecayEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onNotePlayEvent(NotePlayEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.NotePlayEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
		}
	}

	@EventHandler
	public void onSignChangeEvent(SignChangeEvent event) {
		Collection coll = this.collections.get(this.worldmap.get(
				event.getBlock().getLocation()).getCollectionId());
		if (coll == null) {
			this.worldmap.set(null, null, null);
		} else {
			coll.SignChangeEvent(event,
					this.worldmap.get(event.getBlock().getLocation()));
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

	}

	@EventHandler
	public void onPlayerKickEvent(PlayerKickEvent event) {

	}

	@EventHandler
	public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent event) {

	}

	@EventHandler
	public void onPlayerLoginEvent(PlayerLoginEvent event) {

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
