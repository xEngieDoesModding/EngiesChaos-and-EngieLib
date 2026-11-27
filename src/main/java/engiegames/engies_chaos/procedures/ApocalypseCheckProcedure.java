package engiegames.engies_chaos.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import java.util.ArrayList;

import engiegames.engies_chaos.network.EngiesChaosModVariables;
import engiegames.engies_chaos.init.EngiesChaosModGameRules;

@Mod.EventBusSubscriber
public class ApocalypseCheckProcedure {
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
		if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.ENGIE_POC) == true) {
			if (entity.isSprinting()) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.0175));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.0175));
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.025));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.025));
					}
				}
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.level.dimension()) == Level.END) {
					if (!(entityiterator instanceof ServerPlayer _plr9 && _plr9.level instanceof ServerLevel
							&& _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone())) {
						if (EngiesChaosModVariables.MapVariables.get(world).unlockend == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
						}
					} else if (entityiterator instanceof ServerPlayer _plr11 && _plr11.level instanceof ServerLevel
							&& _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone()
							&& EngiesChaosModVariables.MapVariables.get(world).unlockend == false) {
						EngiesChaosModVariables.MapVariables.get(world).unlockend = true;
						EngiesChaosModVariables.MapVariables.get(world).syncData(world);
					}
				} else if ((entityiterator.level.dimension()) == Level.OVERWORLD) {
					if (!(world instanceof Level _lvl15 && _lvl15.isDay())) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			world.getLevelData().getGameRules().getRule(GameRules.RULE_UNIVERSAL_ANGER).set(true, world.getServer());
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.RANDOM) == false) {
				world.getLevelData().getGameRules().getRule(GameRules.RULE_NATURAL_REGENERATION).set(false, world.getServer());
			}
		} else if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.APOCALYPSE_THREE) == true) {
			if (entity.isSprinting()) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.035));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.035));
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.05));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.05));
					}
				}
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.level.dimension()) == Level.END) {
					if (!(entityiterator instanceof ServerPlayer _plr31 && _plr31.level instanceof ServerLevel
							&& _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone())) {
						if (EngiesChaosModVariables.MapVariables.get(world).unlockend == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
						}
					} else if (entityiterator instanceof ServerPlayer _plr33 && _plr33.level instanceof ServerLevel
							&& _plr33.getAdvancements().getOrStartProgress(_plr33.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone()
							&& EngiesChaosModVariables.MapVariables.get(world).unlockend == false) {
						EngiesChaosModVariables.MapVariables.get(world).unlockend = true;
						EngiesChaosModVariables.MapVariables.get(world).syncData(world);
					}
				} else if ((entityiterator.level.dimension()) == Level.OVERWORLD) {
					if (!(world instanceof Level _lvl37 && _lvl37.isDay())) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.RANDOM) == false) {
				world.getLevelData().getGameRules().getRule(GameRules.RULE_NATURAL_REGENERATION).set(false, world.getServer());
			}
		} else if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.APOCALYPSE_TWO) == true) {
			if (entity.isSprinting()) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.0525));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.0525));
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.075));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.075));
					}
				}
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.level.dimension()) == Level.END) {
					if (!(entityiterator instanceof ServerPlayer _plr52 && _plr52.level instanceof ServerLevel
							&& _plr52.getAdvancements().getOrStartProgress(_plr52.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone())) {
						if (EngiesChaosModVariables.MapVariables.get(world).unlockend == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
						}
					} else if (entityiterator instanceof ServerPlayer _plr54 && _plr54.level instanceof ServerLevel
							&& _plr54.getAdvancements().getOrStartProgress(_plr54.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone()
							&& EngiesChaosModVariables.MapVariables.get(world).unlockend == false) {
						EngiesChaosModVariables.MapVariables.get(world).unlockend = true;
						EngiesChaosModVariables.MapVariables.get(world).syncData(world);
					}
				} else if ((entityiterator.level.dimension()) == Level.OVERWORLD) {
					if (!(world instanceof Level _lvl58 && _lvl58.isDay())) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 0, false, false));
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.RANDOM) == false) {
				world.getLevelData().getGameRules().getRule(GameRules.RULE_NATURAL_REGENERATION).set(false, world.getServer());
			}
		} else if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.APOCALYPSE_ONE) == true) {
			if (entity.isSprinting()) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.07));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.07));
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.1));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.1));
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.RANDOM) == false) {
				world.getLevelData().getGameRules().getRule(GameRules.RULE_NATURAL_REGENERATION).set(false, world.getServer());
			}
		} else {
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.CUSTOM_SPRINT) == true) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4d && (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 10) {
					if (entity.isSprinting()) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.125));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.125));
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.05));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.05));
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4d
						&& (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 10) {
					if (entity.isSprinting()) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.1));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.1));
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.025));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.025));
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4d
						&& (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 10) {
					if (entity.isSprinting()) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.1));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.1));
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.025));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.025));
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4d
						&& (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 10) {
					if (entity.isSprinting()) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.0875));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.0875));
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.0125));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.0125));
							}
						}
					}
				}
			} else if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.CUSTOM_SPRINT) == false) {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:generic.movement_speed base set " + 0.1));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("attribute @s minecraft:movement_speed base set " + 0.1));
					}
				}
			}
		}
	}
}