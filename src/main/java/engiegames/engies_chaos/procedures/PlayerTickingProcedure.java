package engiegames.engies_chaos.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import javax.annotation.Nullable;

import engiegames.engies_chaos.network.EngiesChaosModVariables;
import engiegames.engies_chaos.init.EngiesChaosModGameRules;
import engiegames.engies_chaos.EngiesChaosMod;

@Mod.EventBusSubscriber
public class PlayerTickingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity.getX();
			entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getX();
			entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HHGLookX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getY();
			entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getY() + 1.5;
			entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HHGLookY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getZ();
			entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getZ();
			entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HHGLookZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity instanceof ServerPlayer _plr6 && _plr6.level instanceof ServerLevel
				&& _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:challenge_destroyed"))).isDone()) == true) {
			if (EngiesChaosModVariables.MapVariables.get(world).solotrophyobtained == false) {
				EngiesChaosModVariables.MapVariables.get(world).solotrophyobtained = true;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
				EngiesChaosMod.queueServerWork(1, () -> {
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "give @p engies_chaos:challenge_insanity_engie_games_plush_solo");
						}
					}
				});
			}
		} else if ((entity instanceof ServerPlayer _plr9 && _plr9.level instanceof ServerLevel
				&& _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:challenge_destroyed_2"))).isDone()) == true) {
			if (EngiesChaosModVariables.MapVariables.get(world).multiplayertrophyobtained == false) {
				EngiesChaosModVariables.MapVariables.get(world).multiplayertrophyobtained = true;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
				EngiesChaosMod.queueServerWork(1, () -> {
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "give @p engies_chaos:challenge_insanity_engie_games_plush_multiplayer");
						}
					}
				});
			}
		}
		if ((entity instanceof ServerPlayer _plr12 && _plr12.level instanceof ServerLevel
				&& _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:all_fully_done"))).isDone()) == true) {
			if ((entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).MaxPercentGiveOptionToDoHardestMobDiff == false) {
				{
					boolean _setval = true;
					entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MaxPercentGiveOptionToDoHardestMobDiff = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.TRUE_THROWBACK_TOGGLE) == true) {
			if (entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null) instanceof IItemHandler _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (itemstackiterator.is(ItemTags.create(new ResourceLocation("engies_chaos:throwback/disableditems")))) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = itemstackiterator;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
				}
			}
		}
		if ((entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).playerhasimmunity == true) {
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation(20);
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel(20);
		}
		if (EngiesChaosModVariables.MapVariables.get(world).MobDifficulty == 525) {
			if (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity21.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(525);
		} else if (EngiesChaosModVariables.MapVariables.get(world).MobDifficulty == 690) {
			if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity22.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(690);
		} else if (EngiesChaosModVariables.MapVariables.get(world).MobDifficulty == 525000) {
			if (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity23.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(525000);
		} else {
			if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity24.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1);
		}
		if (!world.isClientSide()) {
			if (entity instanceof ServerPlayer _plr26 && _plr26.level instanceof ServerLevel
					&& _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:engie_games_ban_scythe_obtained"))).isDone()) {
				{
					boolean _setval = true;
					entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHasEngieGamesSwordAdvancement = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(entity instanceof ServerPlayer _plr27 && _plr27.level instanceof ServerLevel
					&& _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:engie_games_ban_scythe_obtained"))).isDone())) {
				{
					boolean _setval = false;
					entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHasEngieGamesSwordAdvancement = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof ServerPlayer _plr28 && _plr28.level instanceof ServerLevel
					&& _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:antimatter_engie_games_ban_scythe_obtained"))).isDone()) {
				{
					boolean _setval = true;
					entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHasAntimatterEngieGamesSwordAdvancement = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(entity instanceof ServerPlayer _plr29 && _plr29.level instanceof ServerLevel
					&& _plr29.getAdvancements().getOrStartProgress(_plr29.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:antimatter_engie_games_ban_scythe_obtained"))).isDone())) {
				{
					boolean _setval = false;
					entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHasAntimatterEngieGamesSwordAdvancement = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof ServerPlayer _plr30 && _plr30.level instanceof ServerLevel
					&& _plr30.getAdvancements().getOrStartProgress(_plr30.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:all_fully_done"))).isDone()) {
				{
					boolean _setval = true;
					entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHas101PercentAdvancement = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(entity instanceof ServerPlayer _plr31 && _plr31.level instanceof ServerLevel
					&& _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:all_fully_done"))).isDone())) {
				{
					boolean _setval = false;
					entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHas101PercentAdvancement = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (entity instanceof ServerPlayer _plr32 && _plr32.level instanceof ServerLevel && _plr32.getAdvancements().getOrStartProgress(_plr32.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone()) {
			if (EngiesChaosModVariables.MapVariables.get(world).antimatterdropcheck == false) {
				EngiesChaosModVariables.MapVariables.get(world).antimatterdropcheck = true;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (entity instanceof ServerPlayer _plr33 && _plr33.level instanceof ServerLevel && _plr33.getAdvancements().getOrStartProgress(_plr33.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:all_done"))).isDone()
				&& (entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).pickaxeonly == 0) {
			if (!(entity instanceof ServerPlayer _plr34 && _plr34.level instanceof ServerLevel
					&& _plr34.getAdvancements().getOrStartProgress(_plr34.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:pickaxe_only_all_done"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:pickaxe_only_all_done"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (entity instanceof ServerPlayer _plr36 && _plr36.level instanceof ServerLevel && _plr36.getAdvancements().getOrStartProgress(_plr36.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:all_fully_done"))).isDone()
				&& (entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).pickaxeonly == 0) {
			if (!(entity instanceof ServerPlayer _plr37 && _plr37.level instanceof ServerLevel
					&& _plr37.getAdvancements().getOrStartProgress(_plr37.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:pickaxe_only_all_fully_done"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:pickaxe_only_all_fully_done"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "give @s engies_chaos:technoblade_helmet");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "give @s engies_chaos:technoblade_chestplate");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "give @s engies_chaos:technoblade_leggings");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "give @s engies_chaos:technoblade_boots");
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.ENGIE_POC) == true) {
			if (entity instanceof ServerPlayer _plr44 && _plr44.level instanceof ServerLevel
					&& _plr44.getAdvancements().getOrStartProgress(_plr44.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:engie_poc_all_fully_done"))).isDone()
					&& (entity.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).pickaxeonly == 0) {
				if (!(entity instanceof ServerPlayer _plr45 && _plr45.level instanceof ServerLevel
						&& _plr45.getAdvancements().getOrStartProgress(_plr45.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:engie_poc_pickaxe_only_all_fully_done"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("engies_chaos:engie_poc_pickaxe_only_all_fully_done"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
		if (!(getEntityGameType(entity) == GameType.CREATIVE || getEntityGameType(entity) == GameType.SPECTATOR)) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("engies_chaos:boots/allowflight")))) {
				if (EngiesChaosModVariables.MapVariables.get(world).DoomsdayStart == false && EngiesChaosModVariables.MapVariables.get(world).SuperDoomsdayStart == false && EngiesChaosModVariables.MapVariables.get(world).TheEndStart == false
						&& EngiesChaosModVariables.MapVariables.get(world).EngiesWrathStart == false) {
					if (entity instanceof Player _player) {
						_player.getAbilities().mayfly = true;
						_player.onUpdateAbilities();
					}
				} else {
					if (entity instanceof Player _player) {
						_player.getAbilities().mayfly = false;
						_player.onUpdateAbilities();
					}
				}
			} else {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = false;
					_player.onUpdateAbilities();
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level.isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}