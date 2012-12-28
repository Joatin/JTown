package com.hotmail.joatin37.JTown;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonEvent;
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
import org.bukkit.event.entity.EntityEvent;
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
import org.bukkit.event.hanging.HangingEvent;
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
import org.bukkit.event.player.PlayerBucketEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerChannelEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerEvent;
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
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.StructureGrowEvent;

import com.hotmail.joatin37.JTown.worldmap.WorldMap;

public final class CollectionManager implements Listener {

	private HashMap<String, Collection> collections;
	private final JTown jtown;
	private File configfile;
	private FileConfiguration saveconfig;
	private WorldMap worldmap;

	public CollectionManager(JTown jtown) {
		this.jtown = jtown;
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

	/*------EventListeners------*/

	// All block listeners

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {

	}

	@EventHandler
	public void onBlockBurnEvent(BlockBurnEvent event) {

	}

	@EventHandler
	public void onBlockCanBuildEvent(BlockCanBuildEvent event) {

	}

	@EventHandler
	public void onBlockDamageEvent(BlockDamageEvent event) {

	}

	@EventHandler
	public void onBlockDispenseEvent(BlockDispenseEvent event) {

	}

	@EventHandler
	public void onBlockEvent(BlockEvent event) {

	}

	@EventHandler
	public void onBlockExpEvent(BlockExpEvent event) {

	}

	@EventHandler
	public void onBlockFadeEvent(BlockFadeEvent event) {

	}

	@EventHandler
	public void onBlockFormEvent(BlockFormEvent event) {

	}

	@EventHandler
	public void onBlockFromToEvent(BlockFromToEvent event) {

	}

	@EventHandler
	public void onBlockGrowEvent(BlockGrowEvent event) {

	}

	@EventHandler
	public void onBlockIgniteEvent(BlockIgniteEvent event) {

	}

	@EventHandler
	public void onBlockPhysicsEvent(BlockPhysicsEvent event) {

	}

	@EventHandler
	public void onBlockPistonEvent(BlockPistonEvent event) {

	}

	@EventHandler
	public void onBlockPistonExtendEvent(BlockPistonExtendEvent event) {

	}

	@EventHandler
	public void onBlockPistonRetractEvent(BlockPistonRetractEvent event) {

	}

	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {

	}

	@EventHandler
	public void onBlockRedstoneEvent(BlockRedstoneEvent event) {

	}

	@EventHandler
	public void onBlockSpreadEvent(BlockSpreadEvent event) {

	}

	@EventHandler
	public void onEntityBlockFormEvent(EntityBlockFormEvent event) {

	}

	@EventHandler
	public void onLeavesDecayEvent(LeavesDecayEvent event) {

	}

	@EventHandler
	public void onNotePlayEvent(NotePlayEvent event) {

	}

	@EventHandler
	public void onSignChangeEvent(SignChangeEvent event) {

	}

	// Enchantment Listeners

	@EventHandler
	public void onEnchantItemEvent(EnchantItemEvent event) {

	}

	@EventHandler
	public void onPrepareItemEnchantEvent(PrepareItemEnchantEvent event) {

	}

	// Entity listeners

	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent event) {

	}

	public void onCreeperPowerEvent(CreeperPowerEvent event) {

	}

	public void onEntityBreakDoorEvent(EntityBreakDoorEvent event) {

	}

	public void onEntityChangeBlockEvent(EntityChangeBlockEvent event) {

	}

	public void onEntityCombustByBlockEvent(EntityCombustByBlockEvent event) {

	}

	public void onEntityCombustByEntityEvent(EntityCombustByEntityEvent event) {

	}

	public void onEntityCombustEvent(EntityCombustEvent event) {

	}

	public void onEntityCreatePortalEvent(EntityCreatePortalEvent event) {

	}

	public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event) {

	}

	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {

	}

	public void onEntityDamageEvent(EntityDamageEvent event) {

	}

	public void onEntityEvent(EntityEvent event) {

	}

	public void onEntityExplodeEvent(EntityExplodeEvent event) {

	}

	public void onEntityInteractEvent(EntityInteractEvent event) {

	}

	public void onEntityPortalEnterEvent(EntityPortalEnterEvent event) {

	}

	public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {

	}

	public void onEntityShootBowEvent(EntityShootBowEvent event) {

	}

	public void onEntityTameEvent(EntityTameEvent event) {

	}

	public void onEntityTargetEvent(EntityTargetEvent event) {

	}

	public void onEntityTargetLivingEntityEvent(
			EntityTargetLivingEntityEvent event) {

	}

	public void onEntityTeleportEvent(EntityTeleportEvent event) {

	}

	public void onExpBottleEvent(ExpBottleEvent event) {

	}

	public void onExplosionPrimeEvent(ExplosionPrimeEvent event) {

	}

	public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {

	}

	public void onItemDespawnEvent(ItemDespawnEvent event) {

	}

	public void onItemSpawnEvent(ItemSpawnEvent event) {

	}

	public void onPigZapEvent(PigZapEvent event) {

	}

	public void onPlayerDeathEvent(PlayerDeathEvent event) {

	}

	public void onPotionSplashEvent(PotionSplashEvent event) {

	}

	public void onProjectileHitEvent(ProjectileHitEvent event) {

	}

	public void onProjectileLaunchEvent(ProjectileLaunchEvent event) {

	}

	public void onSheepDyeWoolEvent(SheepDyeWoolEvent event) {

	}

	public void onSheepRegrowWoolEvent(SheepRegrowWoolEvent event) {

	}

	public void onSlimeSplitEvent(SlimeSplitEvent event) {

	}

	// Hanging listeners

	public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {

	}

	public void onHangingBreakEvent(HangingBreakEvent event) {

	}

	public void onHangingEvent(HangingEvent event) {

	}

	public void onHangingPlaceEvent(HangingPlaceEvent event) {

	}

	// Inventory listeners

	public void onBrewEvent(BrewEvent event) {

	}

	public void onCraftItemEvent(CraftItemEvent event) {

	}

	public void onFurnaceBurnEvent(FurnaceBurnEvent event) {

	}

	public void onFurnaceExtractEvent(FurnaceExtractEvent event) {

	}

	public void onFurnaceSmeltEvent(FurnaceSmeltEvent event) {

	}

	public void onInventoryClickEvent(InventoryClickEvent event) {

	}

	public void onInventoryCloseEvent(InventoryCloseEvent event) {

	}

	public void onInventoryEvent(InventoryEvent event) {

	}

	public void onInventoryOpenEvent(InventoryOpenEvent event) {

	}

	public void onPrepareItemCraftEvent(PrepareItemCraftEvent event) {

	}

	// Player listeners

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
	public void onPlayerBucketEvent(PlayerBucketEvent event) {

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
	public void onPlayerEvent(PlayerEvent event) {

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

	// Vehicle listeners

	@EventHandler
	public void onVehicleBlockCollisionEvent(VehicleBlockCollisionEvent event) {

	}

	@EventHandler
	public void onVehicleCollisionEvent(VehicleCollisionEvent event) {

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
	public void onVehicleEvent(VehicleEvent event) {

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

	// Weather listeners

	@EventHandler
	public void onLightningStrikeEvent(LightningStrikeEvent event) {

	}

	// World listeners

	@EventHandler
	public void onPortalCreateEvent(PortalCreateEvent event) {

	}

	@EventHandler
	public void onStructureGrowEvent(StructureGrowEvent event) {

	}

}
