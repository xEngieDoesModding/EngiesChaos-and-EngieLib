package engiegames.engies_chaos.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import java.util.Comparator;
import java.util.ArrayList;

import engiegames.engies_chaos.network.EngiesChaosModVariables;
import engiegames.engies_chaos.init.EngiesChaosModMobEffects;
import engiegames.engies_chaos.init.EngiesChaosModDamageSources;
import engiegames.engies_chaos.EngiesChaosMod;

public class EngiesWrathDoomsdayLightningProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Mth.nextDouble(RandomSource.create(), 1, 100) < 85) {
			EngiesChaosModVariables.MapVariables.get(world).lightningcooldown = 0;
			EngiesChaosModVariables.MapVariables.get(world).syncData(world);
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				{
					double _setval = 0.25;
					entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningflashnum = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					Entity _ent = entityiterator;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "stopsound @s weather engies_chaos:extreme_lightning_strike");
					}
				}
				{
					Entity _ent = entityiterator;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "playsound engies_chaos:extreme_lightning_strike weather @s ~ ~ ~ 0.5");
					}
				}
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			for (int index0 = 0; index0 < (int) Math.round(Mth.nextDouble(RandomSource.create(), 3, 6)); index0++) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + Math.round(Mth.nextDouble(RandomSource.create(), -6, 6)), y, z + Math.round(Mth.nextDouble(RandomSource.create(), -6, 6)))));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)
							&& (entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).DoomsdayAlive == true) {
						entityiterator.hurt(EngiesChaosModDamageSources.DOOMS_LIGHTNING, Mth.nextInt(RandomSource.create(), 40, 100));
					}
					if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(EngiesChaosModMobEffects.STUNNED.get(), 100, 0, false, false));
					}
				}
			}
		} else if (Mth.nextDouble(RandomSource.create(), 1, 100) >= 85) {
			EngiesChaosModVariables.MapVariables.get(world).lightningcooldown = -2.5;
			EngiesChaosModVariables.MapVariables.get(world).syncData(world);
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				{
					double _setval = 0.25;
					entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningflashnum = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					Entity _ent = entityiterator;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "stopsound @s weather engies_chaos:extreme_lightning_strike");
					}
				}
				{
					Entity _ent = entityiterator;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "playsound engies_chaos:extreme_lightning_strike weather @s ~ ~ ~ 0.5");
					}
				}
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(175, Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 175, 175)), 175)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			{
				final Vec3 _center = new Vec3(175, Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 175, 175)), 175);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)
							&& (entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).DoomsdayAlive == true) {
						entityiterator.hurt(EngiesChaosModDamageSources.DOOMS_LIGHTNING, Mth.nextInt(RandomSource.create(), 40, 100));
					}
					if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(EngiesChaosModMobEffects.STUNNED.get(), 100, 0, false, false));
					}
				}
			}
			EngiesChaosMod.queueServerWork(10, () -> {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					{
						double _setval = 0.25;
						entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightningflashnum = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						Entity _ent = entityiterator;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "stopsound @s weather engies_chaos:extreme_lightning_strike");
						}
					}
					{
						Entity _ent = entityiterator;
						if (!_ent.level.isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "playsound engies_chaos:extreme_lightning_strike weather @s ~ ~ ~ 0.5");
						}
					}
				}
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(175, Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 175, -175)), -175)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				{
					final Vec3 _center = new Vec3(175, Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 175, -175)), (-175));
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)
								&& (entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).DoomsdayAlive == true) {
							entityiterator.hurt(EngiesChaosModDamageSources.DOOMS_LIGHTNING, Mth.nextInt(RandomSource.create(), 40, 100));
						}
						if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(EngiesChaosModMobEffects.STUNNED.get(), 100, 0, false, false));
						}
					}
				}
				EngiesChaosMod.queueServerWork(10, () -> {
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						{
							double _setval = 0.25;
							entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lightningflashnum = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
						{
							Entity _ent = entityiterator;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "stopsound @s weather engies_chaos:extreme_lightning_strike");
							}
						}
						{
							Entity _ent = entityiterator;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "playsound engies_chaos:extreme_lightning_strike weather @s ~ ~ ~ 0.5");
							}
						}
					}
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(-175, Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, -175, -175)), -175)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					{
						final Vec3 _center = new Vec3((-175), Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, -175, -175)), (-175));
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)
									&& (entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).DoomsdayAlive == true) {
								entityiterator.hurt(EngiesChaosModDamageSources.DOOMS_LIGHTNING, Mth.nextInt(RandomSource.create(), 40, 100));
							}
							if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(EngiesChaosModMobEffects.STUNNED.get(), 100, 0, false, false));
							}
						}
					}
					EngiesChaosMod.queueServerWork(10, () -> {
						for (Entity entityiterator : new ArrayList<>(world.players())) {
							{
								double _setval = 0.25;
								entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.lightningflashnum = _setval;
									capability.syncPlayerVariables(entityiterator);
								});
							}
							{
								Entity _ent = entityiterator;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
											_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "stopsound @s weather engies_chaos:extreme_lightning_strike");
								}
							}
							{
								Entity _ent = entityiterator;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
											_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "playsound engies_chaos:extreme_lightning_strike weather @s ~ ~ ~ 0.5");
								}
							}
						}
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(-175, Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, -175, 175)), 175)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						{
							final Vec3 _center = new Vec3((-175), Math.round(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, -175, 175)), 175);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)
										&& (entityiterator.getCapability(EngiesChaosModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EngiesChaosModVariables.PlayerVariables())).DoomsdayAlive == true) {
									entityiterator.hurt(EngiesChaosModDamageSources.DOOMS_LIGHTNING, Mth.nextInt(RandomSource.create(), 40, 100));
								}
								if (entityiterator instanceof Player && (getEntityGameType(entityiterator) == GameType.SURVIVAL || getEntityGameType(entityiterator) == GameType.ADVENTURE)) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
										_entity.addEffect(new MobEffectInstance(EngiesChaosModMobEffects.STUNNED.get(), 100, 0, false, false));
								}
							}
						}
					});
				});
			});
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