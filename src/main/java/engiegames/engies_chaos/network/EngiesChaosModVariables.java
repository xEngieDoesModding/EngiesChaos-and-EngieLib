package engiegames.engies_chaos.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import engiegames.engies_chaos.EngiesChaosMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EngiesChaosModVariables {
	public static boolean decembercodeblock = true;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		EngiesChaosMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		EngiesChaosMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.AngryEngieKillCount = original.AngryEngieKillCount;
			clone.angryplushesobtained = original.angryplushesobtained;
			clone.biblicallyplushesobtained = original.biblicallyplushesobtained;
			clone.BlindShadowSharkEngieAttack = original.BlindShadowSharkEngieAttack;
			clone.boyoaprilfoolslaycheck = original.boyoaprilfoolslaycheck;
			clone.browniescount = original.browniescount;
			clone.cheeseballcount = original.cheeseballcount;
			clone.coderedeemblock = original.coderedeemblock;
			clone.CountUntilBaseDrop = original.CountUntilBaseDrop;
			clone.crucifixbypass = original.crucifixbypass;
			clone.crucifixsavedentity = original.crucifixsavedentity;
			clone.dashleftclickcount = original.dashleftclickcount;
			clone.dashtoggle = original.dashtoggle;
			clone.ddayplayeraddedtodeadcount = original.ddayplayeraddedtodeadcount;
			clone.diffadvancement1 = original.diffadvancement1;
			clone.diffadvancement10 = original.diffadvancement10;
			clone.diffadvancement11 = original.diffadvancement11;
			clone.diffadvancement12 = original.diffadvancement12;
			clone.diffadvancement13 = original.diffadvancement13;
			clone.diffadvancement14 = original.diffadvancement14;
			clone.diffadvancement15 = original.diffadvancement15;
			clone.diffadvancement16 = original.diffadvancement16;
			clone.diffadvancement17 = original.diffadvancement17;
			clone.diffadvancement18 = original.diffadvancement18;
			clone.diffadvancement19 = original.diffadvancement19;
			clone.diffadvancement2 = original.diffadvancement2;
			clone.diffadvancement20 = original.diffadvancement20;
			clone.diffadvancement21 = original.diffadvancement21;
			clone.diffadvancement22 = original.diffadvancement22;
			clone.diffadvancement23 = original.diffadvancement23;
			clone.diffadvancement24 = original.diffadvancement24;
			clone.diffadvancement25 = original.diffadvancement25;
			clone.diffadvancement26 = original.diffadvancement26;
			clone.diffadvancement27 = original.diffadvancement27;
			clone.diffadvancement28 = original.diffadvancement28;
			clone.diffadvancement29 = original.diffadvancement29;
			clone.diffadvancement3 = original.diffadvancement3;
			clone.diffadvancement30 = original.diffadvancement30;
			clone.diffadvancement31 = original.diffadvancement31;
			clone.diffadvancement32 = original.diffadvancement32;
			clone.diffadvancement4 = original.diffadvancement4;
			clone.diffadvancement5 = original.diffadvancement5;
			clone.diffadvancement6 = original.diffadvancement6;
			clone.diffadvancement7 = original.diffadvancement7;
			clone.diffadvancement8 = original.diffadvancement8;
			clone.diffadvancement9 = original.diffadvancement9;
			clone.difficultyoverlaytoggle = original.difficultyoverlaytoggle;
			clone.DoomsdayAlive = original.DoomsdayAlive;
			clone.DoomsdayRiskTrackToggle = original.DoomsdayRiskTrackToggle;
			clone.DoomsdayTrackToggle = original.DoomsdayTrackToggle;
			clone.doublejumpcount = original.doublejumpcount;
			clone.doublejumping = original.doublejumping;
			clone.engiegameshallowscythestatclock = original.engiegameshallowscythestatclock;
			clone.EnragedEngieKillCount = original.EnragedEngieKillCount;
			clone.enragedplushesobtained = original.enragedplushesobtained;
			clone.entityabletodespawn = original.entityabletodespawn;
			clone.GoodLuck = original.GoodLuck;
			clone.healthreductiondday = original.healthreductiondday;
			clone.HHGLookX = original.HHGLookX;
			clone.HHGLookY = original.HHGLookY;
			clone.HHGLookZ = original.HHGLookZ;
			clone.HostileBiblicallyKillCount = original.HostileBiblicallyKillCount;
			clone.HostileEngieKillCount = original.HostileEngieKillCount;
			clone.hostileplushesobtained = original.hostileplushesobtained;
			clone.hphudtoggle = original.hphudtoggle;
			clone.InsanityKillCount = original.InsanityKillCount;
			clone.insanityplushesobtained = original.insanityplushesobtained;
			clone.lightningflashnum = original.lightningflashnum;
			clone.MadEngieKillCount = original.MadEngieKillCount;
			clone.madplushesobtained = original.madplushesobtained;
			clone.MaxPercentGiveOptionToDoHardestMobDiff = original.MaxPercentGiveOptionToDoHardestMobDiff;
			clone.MonstrosityEngieKillCount = original.MonstrosityEngieKillCount;
			clone.monstrosityplushesobtained = original.monstrosityplushesobtained;
			clone.OutragedEngieKillCount = original.OutragedEngieKillCount;
			clone.outragedplushesobtained = original.outragedplushesobtained;
			clone.pageNumber = original.pageNumber;
			clone.Photosensitivity = original.Photosensitivity;
			clone.pickaxeonly = original.pickaxeonly;
			clone.playerattackbackstabblock = original.playerattackbackstabblock;
			clone.playercountedtoplayercount = original.playercountedtoplayercount;
			clone.PlayerDeathX = original.PlayerDeathX;
			clone.PlayerDeathY = original.PlayerDeathY;
			clone.PlayerDeathZ = original.PlayerDeathZ;
			clone.playerdebugmode = original.playerdebugmode;
			clone.PlayerHas101PercentAdvancement = original.PlayerHas101PercentAdvancement;
			clone.PlayerHasAntimatterEngieGamesSwordAdvancement = original.PlayerHasAntimatterEngieGamesSwordAdvancement;
			clone.PlayerHasEngieGamesSwordAdvancement = original.PlayerHasEngieGamesSwordAdvancement;
			clone.playerhasimmunity = original.playerhasimmunity;
			clone.playerready = original.playerready;
			clone.playerrequested = original.playerrequested;
			clone.playerstunned = original.playerstunned;
			clone.playerstunnedmobs = original.playerstunnedmobs;
			clone.PlayerX = original.PlayerX;
			clone.PlayerY = original.PlayerY;
			clone.PlayerZ = original.PlayerZ;
			clone.PureInsanityKillCount = original.PureInsanityKillCount;
			clone.recipebookantimattercraftstoggle = original.recipebookantimattercraftstoggle;
			clone.riftspawnoneentity = original.riftspawnoneentity;
			clone.RiftX = original.RiftX;
			clone.RiftY = original.RiftY;
			clone.RiftZ = original.RiftZ;
			clone.SharkoLayCD = original.SharkoLayCD;
			clone.sharkolayingstate = original.sharkolayingstate;
			clone.SharkoLayOnSideCD = original.SharkoLayOnSideCD;
			clone.SharkoRetryState = original.SharkoRetryState;
			clone.SharkoSitCD = original.SharkoSitCD;
			clone.SharkoSleepCD = original.SharkoSleepCD;
			clone.timeoverlaytoggle = original.timeoverlaytoggle;
			clone.TrueHardcoreLifeChangeAmount = original.TrueHardcoreLifeChangeAmount;
			clone.TrueHardcoreLifeCount = original.TrueHardcoreLifeCount;
			clone.truehardcorelifesobtained = original.truehardcorelifesobtained;
			clone.TrueHardcoreMaxLifeCount = original.TrueHardcoreMaxLifeCount;
			clone.WelcomeBackToggle = original.WelcomeBackToggle;
			if (!event.isWasDeath()) {
				clone.firstplay = original.firstplay;
				clone.missileblueburstscale = original.missileblueburstscale;
				clone.missilemoabscale = original.missilemoabscale;
				clone.missilenormalscale = original.missilenormalscale;
				clone.missileyellowlightningscale = original.missileyellowlightningscale;
				clone.RespawnNormInstantHealth = original.RespawnNormInstantHealth;
				clone.RespawnTrueHardcoreGraceStart = original.RespawnTrueHardcoreGraceStart;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					EngiesChaosMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					EngiesChaosMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					EngiesChaosMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "engies_chaos_worldvars";
		public boolean yeah = false;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			yeah = nbt.getBoolean("yeah");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("yeah", yeah);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				EngiesChaosMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "engies_chaos_mapvars";
		public boolean ambiencemodeenabled = false;
		public boolean antimatterdropcheck = false;
		public double apocdayonestart = 0;
		public double avaballtimebeforeshrink = 0;
		public double avalanchecooldown = 0;
		public double AvalancheRX = 0;
		public double AvalancheRZ = 0;
		public double avascaledowncd = 0;
		public boolean Birthday = false;
		public boolean birthdaystart = false;
		public boolean blizzard = false;
		public double blizzardsfxtimerforchallenge = 0;
		public boolean BYEBYE = false;
		public boolean challengehugewepobtained = false;
		public double challengeplayerreadyupcount = 0.0;
		public boolean ChallengeToggle = false;
		public boolean checkboxbothmarked = false;
		public boolean checkboxbothnomarked = false;
		public boolean churchbellsewrath = false;
		public boolean churchbellsnorm = false;
		public boolean CosmicEngieGamesDespawnLock = true;
		public boolean CosmicEngieGamesSpawnLock = true;
		public double darknessretrycooldown = 0.0;
		public boolean DayCheck = false;
		public boolean DayCooldownToggle = false;
		public boolean ddayaltsongplay = false;
		public boolean ddayavalanche = false;
		public double DDayAvalancheAmount = 0;
		public boolean ddayawardadvancement1 = false;
		public boolean ddayawardadvancement2 = false;
		public boolean DDAYCleanup = false;
		public boolean ddaydialogue = false;
		public double ddaydialoguenum = 0.0;
		public boolean ddayhappened = false;
		public boolean ddaymainsongplay = false;
		public double DDayMissileAmount = 0;
		public boolean ddayoncleanup = false;
		public double ddayplayeralivecount = 0;
		public double ddayplayerdeadcount = 0;
		public double ddayprophengiepochordenumb = 0;
		public double ddayprophinsanityhordenumb = 0;
		public double ddayprophnightmarehordenumb = 0;
		public double ddayprophnormhordenumb = 0;
		public double ddayprophnumb = 0;
		public boolean ddayprophshow = false;
		public double DDayRiftAmount = 0;
		public double DDayRiftedEntityCount = 0.0;
		public boolean ddayscornerlightning = false;
		public double DDaySpikeAmount = 0;
		public boolean ddaystoptimer = true;
		public double ddaytimerminutes = 0;
		public double ddaytimerseconds = 0;
		public boolean despawnava = false;
		public boolean despawnspike = false;
		public boolean detectedothermodesenabledthrowback = false;
		public double dialogueamount = 0;
		public double DialogueCooldownStart = 0.0;
		public double DialogueDisappearTimer = 0;
		public boolean difficultytoggle = true;
		public boolean dohordedialogue = false;
		public double doomsdaychance = 0.0;
		public double doomsdaycleanuptimer = 0;
		public boolean DoomsdayDialogueDelay = true;
		public double DoomsdayDialogueDelayTimer = 0;
		public double DoomsdayDialogueTimer = 0;
		public boolean DoomsdayEerie = false;
		public boolean DoomsdayEeriePlayOnce = false;
		public boolean DoomsdayFullStart = false;
		public double DoomsdayHalf = 1.0;
		public double doomsdayhordedialogue = 0;
		public double doomsdaymaxtime = 0;
		public boolean DoomsdayNightTime = false;
		public double DoomsdayNightTimeDelayTimer = 0;
		public boolean doomsdayprophwait = false;
		public boolean DoomsdayStart = false;
		public boolean DoomsdayTeleportedPlayers = false;
		public double DoomsdayTeleportTime = 0;
		public boolean doomssentdebug1 = false;
		public boolean doomssentdebug2 = false;
		public boolean engiepocenabled = false;
		public boolean engiepocgivenplush = false;
		public double engiepocgraceperiod = 0.0;
		public boolean EngiePocSpawnedHelper = false;
		public double engiepoctime = 18000.0;
		public boolean engiepoctruehardest = false;
		public double engiepoctruehardest20mincount = 0;
		public double engiepoctruehardesttimemult = 0;
		public boolean engiestruewrath = false;
		public boolean EngiesWrathDialogueDelay = true;
		public double EngiesWrathDialogueDelayTimer = 0;
		public double EngiesWrathDialogueDisappearTimer = 0;
		public double EngiesWrathDialogueTimer = 0;
		public boolean EngiesWrathEerie = false;
		public boolean EngiesWrathForceCreativePlayersAdventure = false;
		public boolean EngiesWrathFullStart = false;
		public double engieswrathmaxtime = 1525.0;
		public boolean EngiesWrathNightTime = false;
		public double EngiesWrathNightTimeDelayTimer = 0;
		public boolean EngiesWrathStart = false;
		public boolean EngiesWrathTeleportedPlayers = false;
		public double EngiesWrathTeleportTime = 0;
		public double EngiesWrathTimeBeforeDialogueDisappear = 0;
		public double EngiesWrathTimeBeforeNextDialogue = 0;
		public boolean ewrathhappened = false;
		public double ewrathtimerminutes = 0;
		public double ewrathtimerseconds = 0;
		public boolean extremeddaylightningenabled = false;
		public boolean extremelightningenabled = false;
		public boolean FallingTreeInstalled = false;
		public boolean firstplayofaltsoundtrack = false;
		public double forecastdialogue = 0;
		public double forecasthordedialogue = 0;
		public double forecasthordedialoguetimer = 0.0;
		public boolean forecasttoggle = false;
		public double FunFactNumber = 0;
		public double getdamage = 0;
		public boolean glitchsharkoabletospawn = false;
		public double glitchsharkorandnum = 0;
		public boolean GOODBYE = false;
		public boolean graceperiodbeforeplushangryagain = false;
		public boolean heavylightningenabled = false;
		public boolean hewhowatches = false;
		public boolean HHGkilledtoggle = false;
		public double hordecooldown = 0;
		public double HordeRX = 0;
		public double HordeRZ = 0;
		public boolean hordespawnstoggle = false;
		public boolean itemswap1 = false;
		public boolean itemswap2 = false;
		public double lightningcooldown = 0.0;
		public boolean lockhewhogamesotherspawn = false;
		public boolean madlads = false;
		public double missilecooldown = 0.0;
		public double MissileRX = 0;
		public double MissileRZ = 0;
		public boolean mobbasehpmulttoggle = false;
		public double MobDiffBeforeChallenge = 0;
		public double MobDifficulty = 0;
		public boolean multiplayertrophyobtained = false;
		public boolean NightCheck = false;
		public double nightmare = 0.0;
		public double numb = 0;
		public double numberofcosmicengiegames = 0;
		public double numberofdistorted = 0;
		public double numberofdoomsdays = 0;
		public double numberofengiegames = 0;
		public double numberofmindscapetradeable = 0.0;
		public double numberofroughianengiegames = 0;
		public double numberofsuperdoomsdays = 0;
		public double numberoftheend = 0;
		public boolean OHBOY = true;
		public boolean OHNO = false;
		public boolean pausedialogue = false;
		public double playerobtainedantimatterbiblicallycount = 0;
		public double playerobtainedantimatterbigcount = 0;
		public double playerobtainedantimatterdoomsdaycount = 0;
		public double playerobtainedantimatterengiecount = 0;
		public double playerobtainedantimatterengiegamessword = 0;
		public double playerobtainedantimatterenormouscount = 0;
		public double playerobtainedantimattergiganticcount = 0;
		public double playerobtainedantimatterhugecount = 0;
		public double playerobtainedantimatterlargecount = 0;
		public double playerobtainedantimattermassivecount = 0;
		public double playerobtainedantimatterminicount = 0;
		public double playerobtainedantimattermonstrositycount = 0;
		public double playerobtainedantimatterregularcount = 0;
		public double playerobtainedantimattersuperdoomsdaycount = 0;
		public double playerobtainedantimattertheendcount = 0;
		public double playerobtainedbiblicallycount = 0;
		public double playerobtainedbigcount = 0;
		public double playerobtainedcollectorshallowscythe = 0;
		public double playerobtainedcosmicswordcount = 0;
		public double playerobtaineddoomsdaycount = 0;
		public double playerobtainedengiecount = 0;
		public double playerobtainedengiegamesswordcount = 0;
		public double playerobtainedenormouscount = 0;
		public double playerobtainedgiganticcount = 0;
		public double playerobtainedhallowscythecount = 0;
		public double playerobtainedhugecount = 0;
		public double playerobtainedlargecount = 0;
		public double playerobtainedmassivecount = 0;
		public double playerobtainedmindscapecount = 0;
		public double playerobtainedmonstrositycount = 0;
		public double playerobtainedsuperdoomsdaycount = 0;
		public double playerobtainedtheendcount = 0;
		public double playersaidyestotrymaxdiff = 0;
		public boolean playlightningcornersound = false;
		public boolean playlightningsound = false;
		public boolean playlightningsound2 = false;
		public boolean playmissileexplosionsound = false;
		public boolean playmissilespawnsound = false;
		public boolean playriftsound = false;
		public double plushtimeuntildeathforall = 0;
		public double previousdifficulty = 0;
		public double previoustime = 0;
		public boolean prophallowticking = false;
		public double ProphecyDisasterRevealTimer = 0;
		public double ProphecyShowTimer = 0;
		public double ProphecyTimerTotal = 0;
		public double prophposition = 115.0;
		public boolean prophshowedupfirsttime = false;
		public double random25minutetimer = 1500.0;
		public boolean ranfirstcleanup = false;
		public boolean rangraceperiodcount = true;
		public boolean ransecondcleanup = false;
		public boolean resetpickaxeonlycount = false;
		public double riftcooldown = 0.0;
		public double RiftRX = 0;
		public double RiftRZ = 0;
		public double Risk = 0.0;
		public boolean riskcooldown = true;
		public double riskcooldownnumb = 0;
		public double RX = 0;
		public double RY = 0;
		public double RZ = 0;
		public boolean sddayhappened = false;
		public double sddaytimerminutes = 0;
		public double sddaytimerseconds = 0;
		public boolean seasonautumn = false;
		public boolean seasonspring = false;
		public boolean seasonsummer = false;
		public boolean seasonwinter = false;
		public boolean shadowsharkdevspawn = false;
		public double SharkoKilledByPlayersCount = 0;
		public boolean ShowObjectiveOverlay = false;
		public boolean solotrophyobtained = false;
		public boolean spawnedfinaldisasters = false;
		public boolean specialhealth = false;
		public double spikecooldown = 0;
		public double spikecooldownamount = 0;
		public double SpikeRX = 0;
		public double SpikeRZ = 0;
		public boolean spikescurrentlytriggering = false;
		public double spiketimewait = 5.0;
		public boolean StartDoomsdayBeginning = false;
		public boolean StartEngiesWrathBeginning = false;
		public boolean StartSuperDoomsdayBeginning = false;
		public boolean StartTheEndBeginning = false;
		public boolean stopdialogue = false;
		public boolean stopeeriesound = false;
		public double stunmobsradiusnum = 100.0;
		public boolean SuperDoomsdayDialogueDelay = true;
		public double SuperDoomsdayDialogueDelayTimer = 0;
		public double SuperDoomsdayDialogueDisappearTimer = 0;
		public double SuperDoomsdayDialogueTimer = 0;
		public boolean SuperDoomsdayEerie = false;
		public boolean SuperDoomsdayFullStart = false;
		public double superdoomsdaymaxtime = 0;
		public boolean SuperDoomsdayNightTime = false;
		public double SuperDoomsdayNightTimeDelayTimer = 0;
		public boolean SuperDoomsdayStart = false;
		public boolean SuperDoomsdayTeleportedPlayers = false;
		public double SuperDoomsdayTeleportTime = 0;
		public double SuperDoomsdayTimeBeforeDialogueDisappear = 0;
		public double SuperDoomsdayTimeBeforeNextDialogue = 0;
		public boolean TheEndDialogueDelay = true;
		public double TheEndDialogueDelayTimer = 0;
		public double TheEndDialogueDisappearTimer = 0;
		public double TheEndDialogueTimer = 0;
		public boolean TheEndEerie = false;
		public boolean TheEndFullStart = false;
		public boolean theendhappened = false;
		public double theendmaxtime = 0;
		public boolean TheEndNightTime = false;
		public double TheEndNightTimeDelayTimer = 0;
		public boolean TheEndStart = false;
		public boolean TheEndTeleportedPlayers = false;
		public double TheEndTeleportTime = 0;
		public double TheEndTimeBeforeDialogueDisappear = 0;
		public double TheEndTimeBeforeNextDialogue = 0;
		public double theendtimerminutes = 0;
		public double theendtimerseconds = 0;
		public double ticktimerentitycheck = 0;
		public double TimeBeforeDialogueDisappear = 0;
		public double TimeBeforeNextDialogue = 0;
		public double timebeforespecial = 0.0;
		public boolean timecheckstop = false;
		public double timerforextremelyraresharko = 0;
		public double timeticks = 0;
		public double TimeUntilNight = 0.0;
		public double totalplayersinworld = 0;
		public boolean TraderCosmicEngieGamesSpawnLock = false;
		public boolean TraderDoomsdaySpawnLock = false;
		public boolean TraderEngieGamesSpawnLock = false;
		public boolean TraderEngieSpawnLock = false;
		public boolean TraderMindscapeEngieSpawnLock = false;
		public boolean traderneedcount = false;
		public boolean TraderRoughianEngieGamesSpawnLock = false;
		public boolean TraderSuperDoomsdaySpawnLock = false;
		public boolean TraderTheEndSpawnLock = false;
		public double tradertimercounttick = 0;
		public boolean truechaosenabledbydev = false;
		public boolean truehardcoreenabledonworld = false;
		public double tstormlightning = 0;
		public boolean unlockedtruechaos = false;
		public String userids = "";
		public boolean VeinMinerInstalled = false;
		public boolean warnonce = false;
		public boolean wormholesharkoabletospawn = false;
		public double wormholesharkorandnum = 0;
		public boolean xengiesharkoabletospawn = false;
		public double xengiesharkorandnum = 0;
		public double HordeDialogueDisappearTimer = 0;
		public boolean finalforecasthordedialogue = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			ambiencemodeenabled = nbt.getBoolean("ambiencemodeenabled");
			antimatterdropcheck = nbt.getBoolean("antimatterdropcheck");
			apocdayonestart = nbt.getDouble("apocdayonestart");
			avaballtimebeforeshrink = nbt.getDouble("avaballtimebeforeshrink");
			avalanchecooldown = nbt.getDouble("avalanchecooldown");
			AvalancheRX = nbt.getDouble("AvalancheRX");
			AvalancheRZ = nbt.getDouble("AvalancheRZ");
			avascaledowncd = nbt.getDouble("avascaledowncd");
			Birthday = nbt.getBoolean("Birthday");
			birthdaystart = nbt.getBoolean("birthdaystart");
			blizzard = nbt.getBoolean("blizzard");
			blizzardsfxtimerforchallenge = nbt.getDouble("blizzardsfxtimerforchallenge");
			BYEBYE = nbt.getBoolean("BYEBYE");
			challengehugewepobtained = nbt.getBoolean("challengehugewepobtained");
			challengeplayerreadyupcount = nbt.getDouble("challengeplayerreadyupcount");
			ChallengeToggle = nbt.getBoolean("ChallengeToggle");
			checkboxbothmarked = nbt.getBoolean("checkboxbothmarked");
			checkboxbothnomarked = nbt.getBoolean("checkboxbothnomarked");
			churchbellsewrath = nbt.getBoolean("churchbellsewrath");
			churchbellsnorm = nbt.getBoolean("churchbellsnorm");
			CosmicEngieGamesDespawnLock = nbt.getBoolean("CosmicEngieGamesDespawnLock");
			CosmicEngieGamesSpawnLock = nbt.getBoolean("CosmicEngieGamesSpawnLock");
			darknessretrycooldown = nbt.getDouble("darknessretrycooldown");
			DayCheck = nbt.getBoolean("DayCheck");
			DayCooldownToggle = nbt.getBoolean("DayCooldownToggle");
			ddayaltsongplay = nbt.getBoolean("ddayaltsongplay");
			ddayavalanche = nbt.getBoolean("ddayavalanche");
			DDayAvalancheAmount = nbt.getDouble("DDayAvalancheAmount");
			ddayawardadvancement1 = nbt.getBoolean("ddayawardadvancement1");
			ddayawardadvancement2 = nbt.getBoolean("ddayawardadvancement2");
			DDAYCleanup = nbt.getBoolean("DDAYCleanup");
			ddaydialogue = nbt.getBoolean("ddaydialogue");
			ddaydialoguenum = nbt.getDouble("ddaydialoguenum");
			ddayhappened = nbt.getBoolean("ddayhappened");
			ddaymainsongplay = nbt.getBoolean("ddaymainsongplay");
			DDayMissileAmount = nbt.getDouble("DDayMissileAmount");
			ddayoncleanup = nbt.getBoolean("ddayoncleanup");
			ddayplayeralivecount = nbt.getDouble("ddayplayeralivecount");
			ddayplayerdeadcount = nbt.getDouble("ddayplayerdeadcount");
			ddayprophengiepochordenumb = nbt.getDouble("ddayprophengiepochordenumb");
			ddayprophinsanityhordenumb = nbt.getDouble("ddayprophinsanityhordenumb");
			ddayprophnightmarehordenumb = nbt.getDouble("ddayprophnightmarehordenumb");
			ddayprophnormhordenumb = nbt.getDouble("ddayprophnormhordenumb");
			ddayprophnumb = nbt.getDouble("ddayprophnumb");
			ddayprophshow = nbt.getBoolean("ddayprophshow");
			DDayRiftAmount = nbt.getDouble("DDayRiftAmount");
			DDayRiftedEntityCount = nbt.getDouble("DDayRiftedEntityCount");
			ddayscornerlightning = nbt.getBoolean("ddayscornerlightning");
			DDaySpikeAmount = nbt.getDouble("DDaySpikeAmount");
			ddaystoptimer = nbt.getBoolean("ddaystoptimer");
			ddaytimerminutes = nbt.getDouble("ddaytimerminutes");
			ddaytimerseconds = nbt.getDouble("ddaytimerseconds");
			despawnava = nbt.getBoolean("despawnava");
			despawnspike = nbt.getBoolean("despawnspike");
			detectedothermodesenabledthrowback = nbt.getBoolean("detectedothermodesenabledthrowback");
			dialogueamount = nbt.getDouble("dialogueamount");
			DialogueCooldownStart = nbt.getDouble("DialogueCooldownStart");
			DialogueDisappearTimer = nbt.getDouble("DialogueDisappearTimer");
			difficultytoggle = nbt.getBoolean("difficultytoggle");
			dohordedialogue = nbt.getBoolean("dohordedialogue");
			doomsdaychance = nbt.getDouble("doomsdaychance");
			doomsdaycleanuptimer = nbt.getDouble("doomsdaycleanuptimer");
			DoomsdayDialogueDelay = nbt.getBoolean("DoomsdayDialogueDelay");
			DoomsdayDialogueDelayTimer = nbt.getDouble("DoomsdayDialogueDelayTimer");
			DoomsdayDialogueTimer = nbt.getDouble("DoomsdayDialogueTimer");
			DoomsdayEerie = nbt.getBoolean("DoomsdayEerie");
			DoomsdayEeriePlayOnce = nbt.getBoolean("DoomsdayEeriePlayOnce");
			DoomsdayFullStart = nbt.getBoolean("DoomsdayFullStart");
			DoomsdayHalf = nbt.getDouble("DoomsdayHalf");
			doomsdayhordedialogue = nbt.getDouble("doomsdayhordedialogue");
			doomsdaymaxtime = nbt.getDouble("doomsdaymaxtime");
			DoomsdayNightTime = nbt.getBoolean("DoomsdayNightTime");
			DoomsdayNightTimeDelayTimer = nbt.getDouble("DoomsdayNightTimeDelayTimer");
			doomsdayprophwait = nbt.getBoolean("doomsdayprophwait");
			DoomsdayStart = nbt.getBoolean("DoomsdayStart");
			DoomsdayTeleportedPlayers = nbt.getBoolean("DoomsdayTeleportedPlayers");
			DoomsdayTeleportTime = nbt.getDouble("DoomsdayTeleportTime");
			doomssentdebug1 = nbt.getBoolean("doomssentdebug1");
			doomssentdebug2 = nbt.getBoolean("doomssentdebug2");
			engiepocenabled = nbt.getBoolean("engiepocenabled");
			engiepocgivenplush = nbt.getBoolean("engiepocgivenplush");
			engiepocgraceperiod = nbt.getDouble("engiepocgraceperiod");
			EngiePocSpawnedHelper = nbt.getBoolean("EngiePocSpawnedHelper");
			engiepoctime = nbt.getDouble("engiepoctime");
			engiepoctruehardest = nbt.getBoolean("engiepoctruehardest");
			engiepoctruehardest20mincount = nbt.getDouble("engiepoctruehardest20mincount");
			engiepoctruehardesttimemult = nbt.getDouble("engiepoctruehardesttimemult");
			engiestruewrath = nbt.getBoolean("engiestruewrath");
			EngiesWrathDialogueDelay = nbt.getBoolean("EngiesWrathDialogueDelay");
			EngiesWrathDialogueDelayTimer = nbt.getDouble("EngiesWrathDialogueDelayTimer");
			EngiesWrathDialogueDisappearTimer = nbt.getDouble("EngiesWrathDialogueDisappearTimer");
			EngiesWrathDialogueTimer = nbt.getDouble("EngiesWrathDialogueTimer");
			EngiesWrathEerie = nbt.getBoolean("EngiesWrathEerie");
			EngiesWrathForceCreativePlayersAdventure = nbt.getBoolean("EngiesWrathForceCreativePlayersAdventure");
			EngiesWrathFullStart = nbt.getBoolean("EngiesWrathFullStart");
			engieswrathmaxtime = nbt.getDouble("engieswrathmaxtime");
			EngiesWrathNightTime = nbt.getBoolean("EngiesWrathNightTime");
			EngiesWrathNightTimeDelayTimer = nbt.getDouble("EngiesWrathNightTimeDelayTimer");
			EngiesWrathStart = nbt.getBoolean("EngiesWrathStart");
			EngiesWrathTeleportedPlayers = nbt.getBoolean("EngiesWrathTeleportedPlayers");
			EngiesWrathTeleportTime = nbt.getDouble("EngiesWrathTeleportTime");
			EngiesWrathTimeBeforeDialogueDisappear = nbt.getDouble("EngiesWrathTimeBeforeDialogueDisappear");
			EngiesWrathTimeBeforeNextDialogue = nbt.getDouble("EngiesWrathTimeBeforeNextDialogue");
			ewrathhappened = nbt.getBoolean("ewrathhappened");
			ewrathtimerminutes = nbt.getDouble("ewrathtimerminutes");
			ewrathtimerseconds = nbt.getDouble("ewrathtimerseconds");
			extremeddaylightningenabled = nbt.getBoolean("extremeddaylightningenabled");
			extremelightningenabled = nbt.getBoolean("extremelightningenabled");
			FallingTreeInstalled = nbt.getBoolean("FallingTreeInstalled");
			firstplayofaltsoundtrack = nbt.getBoolean("firstplayofaltsoundtrack");
			forecastdialogue = nbt.getDouble("forecastdialogue");
			forecasthordedialogue = nbt.getDouble("forecasthordedialogue");
			forecasthordedialoguetimer = nbt.getDouble("forecasthordedialoguetimer");
			forecasttoggle = nbt.getBoolean("forecasttoggle");
			FunFactNumber = nbt.getDouble("FunFactNumber");
			getdamage = nbt.getDouble("getdamage");
			glitchsharkoabletospawn = nbt.getBoolean("glitchsharkoabletospawn");
			glitchsharkorandnum = nbt.getDouble("glitchsharkorandnum");
			GOODBYE = nbt.getBoolean("GOODBYE");
			graceperiodbeforeplushangryagain = nbt.getBoolean("graceperiodbeforeplushangryagain");
			heavylightningenabled = nbt.getBoolean("heavylightningenabled");
			hewhowatches = nbt.getBoolean("hewhowatches");
			HHGkilledtoggle = nbt.getBoolean("HHGkilledtoggle");
			hordecooldown = nbt.getDouble("hordecooldown");
			HordeRX = nbt.getDouble("HordeRX");
			HordeRZ = nbt.getDouble("HordeRZ");
			hordespawnstoggle = nbt.getBoolean("hordespawnstoggle");
			itemswap1 = nbt.getBoolean("itemswap1");
			itemswap2 = nbt.getBoolean("itemswap2");
			lightningcooldown = nbt.getDouble("lightningcooldown");
			lockhewhogamesotherspawn = nbt.getBoolean("lockhewhogamesotherspawn");
			madlads = nbt.getBoolean("madlads");
			missilecooldown = nbt.getDouble("missilecooldown");
			MissileRX = nbt.getDouble("MissileRX");
			MissileRZ = nbt.getDouble("MissileRZ");
			mobbasehpmulttoggle = nbt.getBoolean("mobbasehpmulttoggle");
			MobDiffBeforeChallenge = nbt.getDouble("MobDiffBeforeChallenge");
			MobDifficulty = nbt.getDouble("MobDifficulty");
			multiplayertrophyobtained = nbt.getBoolean("multiplayertrophyobtained");
			NightCheck = nbt.getBoolean("NightCheck");
			nightmare = nbt.getDouble("nightmare");
			numb = nbt.getDouble("numb");
			numberofcosmicengiegames = nbt.getDouble("numberofcosmicengiegames");
			numberofdistorted = nbt.getDouble("numberofdistorted");
			numberofdoomsdays = nbt.getDouble("numberofdoomsdays");
			numberofengiegames = nbt.getDouble("numberofengiegames");
			numberofmindscapetradeable = nbt.getDouble("numberofmindscapetradeable");
			numberofroughianengiegames = nbt.getDouble("numberofroughianengiegames");
			numberofsuperdoomsdays = nbt.getDouble("numberofsuperdoomsdays");
			numberoftheend = nbt.getDouble("numberoftheend");
			OHBOY = nbt.getBoolean("OHBOY");
			OHNO = nbt.getBoolean("OHNO");
			pausedialogue = nbt.getBoolean("pausedialogue");
			playerobtainedantimatterbiblicallycount = nbt.getDouble("playerobtainedantimatterbiblicallycount");
			playerobtainedantimatterbigcount = nbt.getDouble("playerobtainedantimatterbigcount");
			playerobtainedantimatterdoomsdaycount = nbt.getDouble("playerobtainedantimatterdoomsdaycount");
			playerobtainedantimatterengiecount = nbt.getDouble("playerobtainedantimatterengiecount");
			playerobtainedantimatterengiegamessword = nbt.getDouble("playerobtainedantimatterengiegamessword");
			playerobtainedantimatterenormouscount = nbt.getDouble("playerobtainedantimatterenormouscount");
			playerobtainedantimattergiganticcount = nbt.getDouble("playerobtainedantimattergiganticcount");
			playerobtainedantimatterhugecount = nbt.getDouble("playerobtainedantimatterhugecount");
			playerobtainedantimatterlargecount = nbt.getDouble("playerobtainedantimatterlargecount");
			playerobtainedantimattermassivecount = nbt.getDouble("playerobtainedantimattermassivecount");
			playerobtainedantimatterminicount = nbt.getDouble("playerobtainedantimatterminicount");
			playerobtainedantimattermonstrositycount = nbt.getDouble("playerobtainedantimattermonstrositycount");
			playerobtainedantimatterregularcount = nbt.getDouble("playerobtainedantimatterregularcount");
			playerobtainedantimattersuperdoomsdaycount = nbt.getDouble("playerobtainedantimattersuperdoomsdaycount");
			playerobtainedantimattertheendcount = nbt.getDouble("playerobtainedantimattertheendcount");
			playerobtainedbiblicallycount = nbt.getDouble("playerobtainedbiblicallycount");
			playerobtainedbigcount = nbt.getDouble("playerobtainedbigcount");
			playerobtainedcollectorshallowscythe = nbt.getDouble("playerobtainedcollectorshallowscythe");
			playerobtainedcosmicswordcount = nbt.getDouble("playerobtainedcosmicswordcount");
			playerobtaineddoomsdaycount = nbt.getDouble("playerobtaineddoomsdaycount");
			playerobtainedengiecount = nbt.getDouble("playerobtainedengiecount");
			playerobtainedengiegamesswordcount = nbt.getDouble("playerobtainedengiegamesswordcount");
			playerobtainedenormouscount = nbt.getDouble("playerobtainedenormouscount");
			playerobtainedgiganticcount = nbt.getDouble("playerobtainedgiganticcount");
			playerobtainedhallowscythecount = nbt.getDouble("playerobtainedhallowscythecount");
			playerobtainedhugecount = nbt.getDouble("playerobtainedhugecount");
			playerobtainedlargecount = nbt.getDouble("playerobtainedlargecount");
			playerobtainedmassivecount = nbt.getDouble("playerobtainedmassivecount");
			playerobtainedmindscapecount = nbt.getDouble("playerobtainedmindscapecount");
			playerobtainedmonstrositycount = nbt.getDouble("playerobtainedmonstrositycount");
			playerobtainedsuperdoomsdaycount = nbt.getDouble("playerobtainedsuperdoomsdaycount");
			playerobtainedtheendcount = nbt.getDouble("playerobtainedtheendcount");
			playersaidyestotrymaxdiff = nbt.getDouble("playersaidyestotrymaxdiff");
			playlightningcornersound = nbt.getBoolean("playlightningcornersound");
			playlightningsound = nbt.getBoolean("playlightningsound");
			playlightningsound2 = nbt.getBoolean("playlightningsound2");
			playmissileexplosionsound = nbt.getBoolean("playmissileexplosionsound");
			playmissilespawnsound = nbt.getBoolean("playmissilespawnsound");
			playriftsound = nbt.getBoolean("playriftsound");
			plushtimeuntildeathforall = nbt.getDouble("plushtimeuntildeathforall");
			previousdifficulty = nbt.getDouble("previousdifficulty");
			previoustime = nbt.getDouble("previoustime");
			prophallowticking = nbt.getBoolean("prophallowticking");
			ProphecyDisasterRevealTimer = nbt.getDouble("ProphecyDisasterRevealTimer");
			ProphecyShowTimer = nbt.getDouble("ProphecyShowTimer");
			ProphecyTimerTotal = nbt.getDouble("ProphecyTimerTotal");
			prophposition = nbt.getDouble("prophposition");
			prophshowedupfirsttime = nbt.getBoolean("prophshowedupfirsttime");
			random25minutetimer = nbt.getDouble("random25minutetimer");
			ranfirstcleanup = nbt.getBoolean("ranfirstcleanup");
			rangraceperiodcount = nbt.getBoolean("rangraceperiodcount");
			ransecondcleanup = nbt.getBoolean("ransecondcleanup");
			resetpickaxeonlycount = nbt.getBoolean("resetpickaxeonlycount");
			riftcooldown = nbt.getDouble("riftcooldown");
			RiftRX = nbt.getDouble("RiftRX");
			RiftRZ = nbt.getDouble("RiftRZ");
			Risk = nbt.getDouble("Risk");
			riskcooldown = nbt.getBoolean("riskcooldown");
			riskcooldownnumb = nbt.getDouble("riskcooldownnumb");
			RX = nbt.getDouble("RX");
			RY = nbt.getDouble("RY");
			RZ = nbt.getDouble("RZ");
			sddayhappened = nbt.getBoolean("sddayhappened");
			sddaytimerminutes = nbt.getDouble("sddaytimerminutes");
			sddaytimerseconds = nbt.getDouble("sddaytimerseconds");
			seasonautumn = nbt.getBoolean("seasonautumn");
			seasonspring = nbt.getBoolean("seasonspring");
			seasonsummer = nbt.getBoolean("seasonsummer");
			seasonwinter = nbt.getBoolean("seasonwinter");
			shadowsharkdevspawn = nbt.getBoolean("shadowsharkdevspawn");
			SharkoKilledByPlayersCount = nbt.getDouble("SharkoKilledByPlayersCount");
			ShowObjectiveOverlay = nbt.getBoolean("ShowObjectiveOverlay");
			solotrophyobtained = nbt.getBoolean("solotrophyobtained");
			spawnedfinaldisasters = nbt.getBoolean("spawnedfinaldisasters");
			specialhealth = nbt.getBoolean("specialhealth");
			spikecooldown = nbt.getDouble("spikecooldown");
			spikecooldownamount = nbt.getDouble("spikecooldownamount");
			SpikeRX = nbt.getDouble("SpikeRX");
			SpikeRZ = nbt.getDouble("SpikeRZ");
			spikescurrentlytriggering = nbt.getBoolean("spikescurrentlytriggering");
			spiketimewait = nbt.getDouble("spiketimewait");
			StartDoomsdayBeginning = nbt.getBoolean("StartDoomsdayBeginning");
			StartEngiesWrathBeginning = nbt.getBoolean("StartEngiesWrathBeginning");
			StartSuperDoomsdayBeginning = nbt.getBoolean("StartSuperDoomsdayBeginning");
			StartTheEndBeginning = nbt.getBoolean("StartTheEndBeginning");
			stopdialogue = nbt.getBoolean("stopdialogue");
			stopeeriesound = nbt.getBoolean("stopeeriesound");
			stunmobsradiusnum = nbt.getDouble("stunmobsradiusnum");
			SuperDoomsdayDialogueDelay = nbt.getBoolean("SuperDoomsdayDialogueDelay");
			SuperDoomsdayDialogueDelayTimer = nbt.getDouble("SuperDoomsdayDialogueDelayTimer");
			SuperDoomsdayDialogueDisappearTimer = nbt.getDouble("SuperDoomsdayDialogueDisappearTimer");
			SuperDoomsdayDialogueTimer = nbt.getDouble("SuperDoomsdayDialogueTimer");
			SuperDoomsdayEerie = nbt.getBoolean("SuperDoomsdayEerie");
			SuperDoomsdayFullStart = nbt.getBoolean("SuperDoomsdayFullStart");
			superdoomsdaymaxtime = nbt.getDouble("superdoomsdaymaxtime");
			SuperDoomsdayNightTime = nbt.getBoolean("SuperDoomsdayNightTime");
			SuperDoomsdayNightTimeDelayTimer = nbt.getDouble("SuperDoomsdayNightTimeDelayTimer");
			SuperDoomsdayStart = nbt.getBoolean("SuperDoomsdayStart");
			SuperDoomsdayTeleportedPlayers = nbt.getBoolean("SuperDoomsdayTeleportedPlayers");
			SuperDoomsdayTeleportTime = nbt.getDouble("SuperDoomsdayTeleportTime");
			SuperDoomsdayTimeBeforeDialogueDisappear = nbt.getDouble("SuperDoomsdayTimeBeforeDialogueDisappear");
			SuperDoomsdayTimeBeforeNextDialogue = nbt.getDouble("SuperDoomsdayTimeBeforeNextDialogue");
			TheEndDialogueDelay = nbt.getBoolean("TheEndDialogueDelay");
			TheEndDialogueDelayTimer = nbt.getDouble("TheEndDialogueDelayTimer");
			TheEndDialogueDisappearTimer = nbt.getDouble("TheEndDialogueDisappearTimer");
			TheEndDialogueTimer = nbt.getDouble("TheEndDialogueTimer");
			TheEndEerie = nbt.getBoolean("TheEndEerie");
			TheEndFullStart = nbt.getBoolean("TheEndFullStart");
			theendhappened = nbt.getBoolean("theendhappened");
			theendmaxtime = nbt.getDouble("theendmaxtime");
			TheEndNightTime = nbt.getBoolean("TheEndNightTime");
			TheEndNightTimeDelayTimer = nbt.getDouble("TheEndNightTimeDelayTimer");
			TheEndStart = nbt.getBoolean("TheEndStart");
			TheEndTeleportedPlayers = nbt.getBoolean("TheEndTeleportedPlayers");
			TheEndTeleportTime = nbt.getDouble("TheEndTeleportTime");
			TheEndTimeBeforeDialogueDisappear = nbt.getDouble("TheEndTimeBeforeDialogueDisappear");
			TheEndTimeBeforeNextDialogue = nbt.getDouble("TheEndTimeBeforeNextDialogue");
			theendtimerminutes = nbt.getDouble("theendtimerminutes");
			theendtimerseconds = nbt.getDouble("theendtimerseconds");
			ticktimerentitycheck = nbt.getDouble("ticktimerentitycheck");
			TimeBeforeDialogueDisappear = nbt.getDouble("TimeBeforeDialogueDisappear");
			TimeBeforeNextDialogue = nbt.getDouble("TimeBeforeNextDialogue");
			timebeforespecial = nbt.getDouble("timebeforespecial");
			timecheckstop = nbt.getBoolean("timecheckstop");
			timerforextremelyraresharko = nbt.getDouble("timerforextremelyraresharko");
			timeticks = nbt.getDouble("timeticks");
			TimeUntilNight = nbt.getDouble("TimeUntilNight");
			totalplayersinworld = nbt.getDouble("totalplayersinworld");
			TraderCosmicEngieGamesSpawnLock = nbt.getBoolean("TraderCosmicEngieGamesSpawnLock");
			TraderDoomsdaySpawnLock = nbt.getBoolean("TraderDoomsdaySpawnLock");
			TraderEngieGamesSpawnLock = nbt.getBoolean("TraderEngieGamesSpawnLock");
			TraderEngieSpawnLock = nbt.getBoolean("TraderEngieSpawnLock");
			TraderMindscapeEngieSpawnLock = nbt.getBoolean("TraderMindscapeEngieSpawnLock");
			traderneedcount = nbt.getBoolean("traderneedcount");
			TraderRoughianEngieGamesSpawnLock = nbt.getBoolean("TraderRoughianEngieGamesSpawnLock");
			TraderSuperDoomsdaySpawnLock = nbt.getBoolean("TraderSuperDoomsdaySpawnLock");
			TraderTheEndSpawnLock = nbt.getBoolean("TraderTheEndSpawnLock");
			tradertimercounttick = nbt.getDouble("tradertimercounttick");
			truechaosenabledbydev = nbt.getBoolean("truechaosenabledbydev");
			truehardcoreenabledonworld = nbt.getBoolean("truehardcoreenabledonworld");
			tstormlightning = nbt.getDouble("tstormlightning");
			unlockedtruechaos = nbt.getBoolean("unlockedtruechaos");
			userids = nbt.getString("userids");
			VeinMinerInstalled = nbt.getBoolean("VeinMinerInstalled");
			warnonce = nbt.getBoolean("warnonce");
			wormholesharkoabletospawn = nbt.getBoolean("wormholesharkoabletospawn");
			wormholesharkorandnum = nbt.getDouble("wormholesharkorandnum");
			xengiesharkoabletospawn = nbt.getBoolean("xengiesharkoabletospawn");
			xengiesharkorandnum = nbt.getDouble("xengiesharkorandnum");
			HordeDialogueDisappearTimer = nbt.getDouble("HordeDialogueDisappearTimer");
			finalforecasthordedialogue = nbt.getBoolean("finalforecasthordedialogue");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("ambiencemodeenabled", ambiencemodeenabled);
			nbt.putBoolean("antimatterdropcheck", antimatterdropcheck);
			nbt.putDouble("apocdayonestart", apocdayonestart);
			nbt.putDouble("avaballtimebeforeshrink", avaballtimebeforeshrink);
			nbt.putDouble("avalanchecooldown", avalanchecooldown);
			nbt.putDouble("AvalancheRX", AvalancheRX);
			nbt.putDouble("AvalancheRZ", AvalancheRZ);
			nbt.putDouble("avascaledowncd", avascaledowncd);
			nbt.putBoolean("Birthday", Birthday);
			nbt.putBoolean("birthdaystart", birthdaystart);
			nbt.putBoolean("blizzard", blizzard);
			nbt.putDouble("blizzardsfxtimerforchallenge", blizzardsfxtimerforchallenge);
			nbt.putBoolean("BYEBYE", BYEBYE);
			nbt.putBoolean("challengehugewepobtained", challengehugewepobtained);
			nbt.putDouble("challengeplayerreadyupcount", challengeplayerreadyupcount);
			nbt.putBoolean("ChallengeToggle", ChallengeToggle);
			nbt.putBoolean("checkboxbothmarked", checkboxbothmarked);
			nbt.putBoolean("checkboxbothnomarked", checkboxbothnomarked);
			nbt.putBoolean("churchbellsewrath", churchbellsewrath);
			nbt.putBoolean("churchbellsnorm", churchbellsnorm);
			nbt.putBoolean("CosmicEngieGamesDespawnLock", CosmicEngieGamesDespawnLock);
			nbt.putBoolean("CosmicEngieGamesSpawnLock", CosmicEngieGamesSpawnLock);
			nbt.putDouble("darknessretrycooldown", darknessretrycooldown);
			nbt.putBoolean("DayCheck", DayCheck);
			nbt.putBoolean("DayCooldownToggle", DayCooldownToggle);
			nbt.putBoolean("ddayaltsongplay", ddayaltsongplay);
			nbt.putBoolean("ddayavalanche", ddayavalanche);
			nbt.putDouble("DDayAvalancheAmount", DDayAvalancheAmount);
			nbt.putBoolean("ddayawardadvancement1", ddayawardadvancement1);
			nbt.putBoolean("ddayawardadvancement2", ddayawardadvancement2);
			nbt.putBoolean("DDAYCleanup", DDAYCleanup);
			nbt.putBoolean("ddaydialogue", ddaydialogue);
			nbt.putDouble("ddaydialoguenum", ddaydialoguenum);
			nbt.putBoolean("ddayhappened", ddayhappened);
			nbt.putBoolean("ddaymainsongplay", ddaymainsongplay);
			nbt.putDouble("DDayMissileAmount", DDayMissileAmount);
			nbt.putBoolean("ddayoncleanup", ddayoncleanup);
			nbt.putDouble("ddayplayeralivecount", ddayplayeralivecount);
			nbt.putDouble("ddayplayerdeadcount", ddayplayerdeadcount);
			nbt.putDouble("ddayprophengiepochordenumb", ddayprophengiepochordenumb);
			nbt.putDouble("ddayprophinsanityhordenumb", ddayprophinsanityhordenumb);
			nbt.putDouble("ddayprophnightmarehordenumb", ddayprophnightmarehordenumb);
			nbt.putDouble("ddayprophnormhordenumb", ddayprophnormhordenumb);
			nbt.putDouble("ddayprophnumb", ddayprophnumb);
			nbt.putBoolean("ddayprophshow", ddayprophshow);
			nbt.putDouble("DDayRiftAmount", DDayRiftAmount);
			nbt.putDouble("DDayRiftedEntityCount", DDayRiftedEntityCount);
			nbt.putBoolean("ddayscornerlightning", ddayscornerlightning);
			nbt.putDouble("DDaySpikeAmount", DDaySpikeAmount);
			nbt.putBoolean("ddaystoptimer", ddaystoptimer);
			nbt.putDouble("ddaytimerminutes", ddaytimerminutes);
			nbt.putDouble("ddaytimerseconds", ddaytimerseconds);
			nbt.putBoolean("despawnava", despawnava);
			nbt.putBoolean("despawnspike", despawnspike);
			nbt.putBoolean("detectedothermodesenabledthrowback", detectedothermodesenabledthrowback);
			nbt.putDouble("dialogueamount", dialogueamount);
			nbt.putDouble("DialogueCooldownStart", DialogueCooldownStart);
			nbt.putDouble("DialogueDisappearTimer", DialogueDisappearTimer);
			nbt.putBoolean("difficultytoggle", difficultytoggle);
			nbt.putBoolean("dohordedialogue", dohordedialogue);
			nbt.putDouble("doomsdaychance", doomsdaychance);
			nbt.putDouble("doomsdaycleanuptimer", doomsdaycleanuptimer);
			nbt.putBoolean("DoomsdayDialogueDelay", DoomsdayDialogueDelay);
			nbt.putDouble("DoomsdayDialogueDelayTimer", DoomsdayDialogueDelayTimer);
			nbt.putDouble("DoomsdayDialogueTimer", DoomsdayDialogueTimer);
			nbt.putBoolean("DoomsdayEerie", DoomsdayEerie);
			nbt.putBoolean("DoomsdayEeriePlayOnce", DoomsdayEeriePlayOnce);
			nbt.putBoolean("DoomsdayFullStart", DoomsdayFullStart);
			nbt.putDouble("DoomsdayHalf", DoomsdayHalf);
			nbt.putDouble("doomsdayhordedialogue", doomsdayhordedialogue);
			nbt.putDouble("doomsdaymaxtime", doomsdaymaxtime);
			nbt.putBoolean("DoomsdayNightTime", DoomsdayNightTime);
			nbt.putDouble("DoomsdayNightTimeDelayTimer", DoomsdayNightTimeDelayTimer);
			nbt.putBoolean("doomsdayprophwait", doomsdayprophwait);
			nbt.putBoolean("DoomsdayStart", DoomsdayStart);
			nbt.putBoolean("DoomsdayTeleportedPlayers", DoomsdayTeleportedPlayers);
			nbt.putDouble("DoomsdayTeleportTime", DoomsdayTeleportTime);
			nbt.putBoolean("doomssentdebug1", doomssentdebug1);
			nbt.putBoolean("doomssentdebug2", doomssentdebug2);
			nbt.putBoolean("engiepocenabled", engiepocenabled);
			nbt.putBoolean("engiepocgivenplush", engiepocgivenplush);
			nbt.putDouble("engiepocgraceperiod", engiepocgraceperiod);
			nbt.putBoolean("EngiePocSpawnedHelper", EngiePocSpawnedHelper);
			nbt.putDouble("engiepoctime", engiepoctime);
			nbt.putBoolean("engiepoctruehardest", engiepoctruehardest);
			nbt.putDouble("engiepoctruehardest20mincount", engiepoctruehardest20mincount);
			nbt.putDouble("engiepoctruehardesttimemult", engiepoctruehardesttimemult);
			nbt.putBoolean("engiestruewrath", engiestruewrath);
			nbt.putBoolean("EngiesWrathDialogueDelay", EngiesWrathDialogueDelay);
			nbt.putDouble("EngiesWrathDialogueDelayTimer", EngiesWrathDialogueDelayTimer);
			nbt.putDouble("EngiesWrathDialogueDisappearTimer", EngiesWrathDialogueDisappearTimer);
			nbt.putDouble("EngiesWrathDialogueTimer", EngiesWrathDialogueTimer);
			nbt.putBoolean("EngiesWrathEerie", EngiesWrathEerie);
			nbt.putBoolean("EngiesWrathForceCreativePlayersAdventure", EngiesWrathForceCreativePlayersAdventure);
			nbt.putBoolean("EngiesWrathFullStart", EngiesWrathFullStart);
			nbt.putDouble("engieswrathmaxtime", engieswrathmaxtime);
			nbt.putBoolean("EngiesWrathNightTime", EngiesWrathNightTime);
			nbt.putDouble("EngiesWrathNightTimeDelayTimer", EngiesWrathNightTimeDelayTimer);
			nbt.putBoolean("EngiesWrathStart", EngiesWrathStart);
			nbt.putBoolean("EngiesWrathTeleportedPlayers", EngiesWrathTeleportedPlayers);
			nbt.putDouble("EngiesWrathTeleportTime", EngiesWrathTeleportTime);
			nbt.putDouble("EngiesWrathTimeBeforeDialogueDisappear", EngiesWrathTimeBeforeDialogueDisappear);
			nbt.putDouble("EngiesWrathTimeBeforeNextDialogue", EngiesWrathTimeBeforeNextDialogue);
			nbt.putBoolean("ewrathhappened", ewrathhappened);
			nbt.putDouble("ewrathtimerminutes", ewrathtimerminutes);
			nbt.putDouble("ewrathtimerseconds", ewrathtimerseconds);
			nbt.putBoolean("extremeddaylightningenabled", extremeddaylightningenabled);
			nbt.putBoolean("extremelightningenabled", extremelightningenabled);
			nbt.putBoolean("FallingTreeInstalled", FallingTreeInstalled);
			nbt.putBoolean("firstplayofaltsoundtrack", firstplayofaltsoundtrack);
			nbt.putDouble("forecastdialogue", forecastdialogue);
			nbt.putDouble("forecasthordedialogue", forecasthordedialogue);
			nbt.putDouble("forecasthordedialoguetimer", forecasthordedialoguetimer);
			nbt.putBoolean("forecasttoggle", forecasttoggle);
			nbt.putDouble("FunFactNumber", FunFactNumber);
			nbt.putDouble("getdamage", getdamage);
			nbt.putBoolean("glitchsharkoabletospawn", glitchsharkoabletospawn);
			nbt.putDouble("glitchsharkorandnum", glitchsharkorandnum);
			nbt.putBoolean("GOODBYE", GOODBYE);
			nbt.putBoolean("graceperiodbeforeplushangryagain", graceperiodbeforeplushangryagain);
			nbt.putBoolean("heavylightningenabled", heavylightningenabled);
			nbt.putBoolean("hewhowatches", hewhowatches);
			nbt.putBoolean("HHGkilledtoggle", HHGkilledtoggle);
			nbt.putDouble("hordecooldown", hordecooldown);
			nbt.putDouble("HordeRX", HordeRX);
			nbt.putDouble("HordeRZ", HordeRZ);
			nbt.putBoolean("hordespawnstoggle", hordespawnstoggle);
			nbt.putBoolean("itemswap1", itemswap1);
			nbt.putBoolean("itemswap2", itemswap2);
			nbt.putDouble("lightningcooldown", lightningcooldown);
			nbt.putBoolean("lockhewhogamesotherspawn", lockhewhogamesotherspawn);
			nbt.putBoolean("madlads", madlads);
			nbt.putDouble("missilecooldown", missilecooldown);
			nbt.putDouble("MissileRX", MissileRX);
			nbt.putDouble("MissileRZ", MissileRZ);
			nbt.putBoolean("mobbasehpmulttoggle", mobbasehpmulttoggle);
			nbt.putDouble("MobDiffBeforeChallenge", MobDiffBeforeChallenge);
			nbt.putDouble("MobDifficulty", MobDifficulty);
			nbt.putBoolean("multiplayertrophyobtained", multiplayertrophyobtained);
			nbt.putBoolean("NightCheck", NightCheck);
			nbt.putDouble("nightmare", nightmare);
			nbt.putDouble("numb", numb);
			nbt.putDouble("numberofcosmicengiegames", numberofcosmicengiegames);
			nbt.putDouble("numberofdistorted", numberofdistorted);
			nbt.putDouble("numberofdoomsdays", numberofdoomsdays);
			nbt.putDouble("numberofengiegames", numberofengiegames);
			nbt.putDouble("numberofmindscapetradeable", numberofmindscapetradeable);
			nbt.putDouble("numberofroughianengiegames", numberofroughianengiegames);
			nbt.putDouble("numberofsuperdoomsdays", numberofsuperdoomsdays);
			nbt.putDouble("numberoftheend", numberoftheend);
			nbt.putBoolean("OHBOY", OHBOY);
			nbt.putBoolean("OHNO", OHNO);
			nbt.putBoolean("pausedialogue", pausedialogue);
			nbt.putDouble("playerobtainedantimatterbiblicallycount", playerobtainedantimatterbiblicallycount);
			nbt.putDouble("playerobtainedantimatterbigcount", playerobtainedantimatterbigcount);
			nbt.putDouble("playerobtainedantimatterdoomsdaycount", playerobtainedantimatterdoomsdaycount);
			nbt.putDouble("playerobtainedantimatterengiecount", playerobtainedantimatterengiecount);
			nbt.putDouble("playerobtainedantimatterengiegamessword", playerobtainedantimatterengiegamessword);
			nbt.putDouble("playerobtainedantimatterenormouscount", playerobtainedantimatterenormouscount);
			nbt.putDouble("playerobtainedantimattergiganticcount", playerobtainedantimattergiganticcount);
			nbt.putDouble("playerobtainedantimatterhugecount", playerobtainedantimatterhugecount);
			nbt.putDouble("playerobtainedantimatterlargecount", playerobtainedantimatterlargecount);
			nbt.putDouble("playerobtainedantimattermassivecount", playerobtainedantimattermassivecount);
			nbt.putDouble("playerobtainedantimatterminicount", playerobtainedantimatterminicount);
			nbt.putDouble("playerobtainedantimattermonstrositycount", playerobtainedantimattermonstrositycount);
			nbt.putDouble("playerobtainedantimatterregularcount", playerobtainedantimatterregularcount);
			nbt.putDouble("playerobtainedantimattersuperdoomsdaycount", playerobtainedantimattersuperdoomsdaycount);
			nbt.putDouble("playerobtainedantimattertheendcount", playerobtainedantimattertheendcount);
			nbt.putDouble("playerobtainedbiblicallycount", playerobtainedbiblicallycount);
			nbt.putDouble("playerobtainedbigcount", playerobtainedbigcount);
			nbt.putDouble("playerobtainedcollectorshallowscythe", playerobtainedcollectorshallowscythe);
			nbt.putDouble("playerobtainedcosmicswordcount", playerobtainedcosmicswordcount);
			nbt.putDouble("playerobtaineddoomsdaycount", playerobtaineddoomsdaycount);
			nbt.putDouble("playerobtainedengiecount", playerobtainedengiecount);
			nbt.putDouble("playerobtainedengiegamesswordcount", playerobtainedengiegamesswordcount);
			nbt.putDouble("playerobtainedenormouscount", playerobtainedenormouscount);
			nbt.putDouble("playerobtainedgiganticcount", playerobtainedgiganticcount);
			nbt.putDouble("playerobtainedhallowscythecount", playerobtainedhallowscythecount);
			nbt.putDouble("playerobtainedhugecount", playerobtainedhugecount);
			nbt.putDouble("playerobtainedlargecount", playerobtainedlargecount);
			nbt.putDouble("playerobtainedmassivecount", playerobtainedmassivecount);
			nbt.putDouble("playerobtainedmindscapecount", playerobtainedmindscapecount);
			nbt.putDouble("playerobtainedmonstrositycount", playerobtainedmonstrositycount);
			nbt.putDouble("playerobtainedsuperdoomsdaycount", playerobtainedsuperdoomsdaycount);
			nbt.putDouble("playerobtainedtheendcount", playerobtainedtheendcount);
			nbt.putDouble("playersaidyestotrymaxdiff", playersaidyestotrymaxdiff);
			nbt.putBoolean("playlightningcornersound", playlightningcornersound);
			nbt.putBoolean("playlightningsound", playlightningsound);
			nbt.putBoolean("playlightningsound2", playlightningsound2);
			nbt.putBoolean("playmissileexplosionsound", playmissileexplosionsound);
			nbt.putBoolean("playmissilespawnsound", playmissilespawnsound);
			nbt.putBoolean("playriftsound", playriftsound);
			nbt.putDouble("plushtimeuntildeathforall", plushtimeuntildeathforall);
			nbt.putDouble("previousdifficulty", previousdifficulty);
			nbt.putDouble("previoustime", previoustime);
			nbt.putBoolean("prophallowticking", prophallowticking);
			nbt.putDouble("ProphecyDisasterRevealTimer", ProphecyDisasterRevealTimer);
			nbt.putDouble("ProphecyShowTimer", ProphecyShowTimer);
			nbt.putDouble("ProphecyTimerTotal", ProphecyTimerTotal);
			nbt.putDouble("prophposition", prophposition);
			nbt.putBoolean("prophshowedupfirsttime", prophshowedupfirsttime);
			nbt.putDouble("random25minutetimer", random25minutetimer);
			nbt.putBoolean("ranfirstcleanup", ranfirstcleanup);
			nbt.putBoolean("rangraceperiodcount", rangraceperiodcount);
			nbt.putBoolean("ransecondcleanup", ransecondcleanup);
			nbt.putBoolean("resetpickaxeonlycount", resetpickaxeonlycount);
			nbt.putDouble("riftcooldown", riftcooldown);
			nbt.putDouble("RiftRX", RiftRX);
			nbt.putDouble("RiftRZ", RiftRZ);
			nbt.putDouble("Risk", Risk);
			nbt.putBoolean("riskcooldown", riskcooldown);
			nbt.putDouble("riskcooldownnumb", riskcooldownnumb);
			nbt.putDouble("RX", RX);
			nbt.putDouble("RY", RY);
			nbt.putDouble("RZ", RZ);
			nbt.putBoolean("sddayhappened", sddayhappened);
			nbt.putDouble("sddaytimerminutes", sddaytimerminutes);
			nbt.putDouble("sddaytimerseconds", sddaytimerseconds);
			nbt.putBoolean("seasonautumn", seasonautumn);
			nbt.putBoolean("seasonspring", seasonspring);
			nbt.putBoolean("seasonsummer", seasonsummer);
			nbt.putBoolean("seasonwinter", seasonwinter);
			nbt.putBoolean("shadowsharkdevspawn", shadowsharkdevspawn);
			nbt.putDouble("SharkoKilledByPlayersCount", SharkoKilledByPlayersCount);
			nbt.putBoolean("ShowObjectiveOverlay", ShowObjectiveOverlay);
			nbt.putBoolean("solotrophyobtained", solotrophyobtained);
			nbt.putBoolean("spawnedfinaldisasters", spawnedfinaldisasters);
			nbt.putBoolean("specialhealth", specialhealth);
			nbt.putDouble("spikecooldown", spikecooldown);
			nbt.putDouble("spikecooldownamount", spikecooldownamount);
			nbt.putDouble("SpikeRX", SpikeRX);
			nbt.putDouble("SpikeRZ", SpikeRZ);
			nbt.putBoolean("spikescurrentlytriggering", spikescurrentlytriggering);
			nbt.putDouble("spiketimewait", spiketimewait);
			nbt.putBoolean("StartDoomsdayBeginning", StartDoomsdayBeginning);
			nbt.putBoolean("StartEngiesWrathBeginning", StartEngiesWrathBeginning);
			nbt.putBoolean("StartSuperDoomsdayBeginning", StartSuperDoomsdayBeginning);
			nbt.putBoolean("StartTheEndBeginning", StartTheEndBeginning);
			nbt.putBoolean("stopdialogue", stopdialogue);
			nbt.putBoolean("stopeeriesound", stopeeriesound);
			nbt.putDouble("stunmobsradiusnum", stunmobsradiusnum);
			nbt.putBoolean("SuperDoomsdayDialogueDelay", SuperDoomsdayDialogueDelay);
			nbt.putDouble("SuperDoomsdayDialogueDelayTimer", SuperDoomsdayDialogueDelayTimer);
			nbt.putDouble("SuperDoomsdayDialogueDisappearTimer", SuperDoomsdayDialogueDisappearTimer);
			nbt.putDouble("SuperDoomsdayDialogueTimer", SuperDoomsdayDialogueTimer);
			nbt.putBoolean("SuperDoomsdayEerie", SuperDoomsdayEerie);
			nbt.putBoolean("SuperDoomsdayFullStart", SuperDoomsdayFullStart);
			nbt.putDouble("superdoomsdaymaxtime", superdoomsdaymaxtime);
			nbt.putBoolean("SuperDoomsdayNightTime", SuperDoomsdayNightTime);
			nbt.putDouble("SuperDoomsdayNightTimeDelayTimer", SuperDoomsdayNightTimeDelayTimer);
			nbt.putBoolean("SuperDoomsdayStart", SuperDoomsdayStart);
			nbt.putBoolean("SuperDoomsdayTeleportedPlayers", SuperDoomsdayTeleportedPlayers);
			nbt.putDouble("SuperDoomsdayTeleportTime", SuperDoomsdayTeleportTime);
			nbt.putDouble("SuperDoomsdayTimeBeforeDialogueDisappear", SuperDoomsdayTimeBeforeDialogueDisappear);
			nbt.putDouble("SuperDoomsdayTimeBeforeNextDialogue", SuperDoomsdayTimeBeforeNextDialogue);
			nbt.putBoolean("TheEndDialogueDelay", TheEndDialogueDelay);
			nbt.putDouble("TheEndDialogueDelayTimer", TheEndDialogueDelayTimer);
			nbt.putDouble("TheEndDialogueDisappearTimer", TheEndDialogueDisappearTimer);
			nbt.putDouble("TheEndDialogueTimer", TheEndDialogueTimer);
			nbt.putBoolean("TheEndEerie", TheEndEerie);
			nbt.putBoolean("TheEndFullStart", TheEndFullStart);
			nbt.putBoolean("theendhappened", theendhappened);
			nbt.putDouble("theendmaxtime", theendmaxtime);
			nbt.putBoolean("TheEndNightTime", TheEndNightTime);
			nbt.putDouble("TheEndNightTimeDelayTimer", TheEndNightTimeDelayTimer);
			nbt.putBoolean("TheEndStart", TheEndStart);
			nbt.putBoolean("TheEndTeleportedPlayers", TheEndTeleportedPlayers);
			nbt.putDouble("TheEndTeleportTime", TheEndTeleportTime);
			nbt.putDouble("TheEndTimeBeforeDialogueDisappear", TheEndTimeBeforeDialogueDisappear);
			nbt.putDouble("TheEndTimeBeforeNextDialogue", TheEndTimeBeforeNextDialogue);
			nbt.putDouble("theendtimerminutes", theendtimerminutes);
			nbt.putDouble("theendtimerseconds", theendtimerseconds);
			nbt.putDouble("ticktimerentitycheck", ticktimerentitycheck);
			nbt.putDouble("TimeBeforeDialogueDisappear", TimeBeforeDialogueDisappear);
			nbt.putDouble("TimeBeforeNextDialogue", TimeBeforeNextDialogue);
			nbt.putDouble("timebeforespecial", timebeforespecial);
			nbt.putBoolean("timecheckstop", timecheckstop);
			nbt.putDouble("timerforextremelyraresharko", timerforextremelyraresharko);
			nbt.putDouble("timeticks", timeticks);
			nbt.putDouble("TimeUntilNight", TimeUntilNight);
			nbt.putDouble("totalplayersinworld", totalplayersinworld);
			nbt.putBoolean("TraderCosmicEngieGamesSpawnLock", TraderCosmicEngieGamesSpawnLock);
			nbt.putBoolean("TraderDoomsdaySpawnLock", TraderDoomsdaySpawnLock);
			nbt.putBoolean("TraderEngieGamesSpawnLock", TraderEngieGamesSpawnLock);
			nbt.putBoolean("TraderEngieSpawnLock", TraderEngieSpawnLock);
			nbt.putBoolean("TraderMindscapeEngieSpawnLock", TraderMindscapeEngieSpawnLock);
			nbt.putBoolean("traderneedcount", traderneedcount);
			nbt.putBoolean("TraderRoughianEngieGamesSpawnLock", TraderRoughianEngieGamesSpawnLock);
			nbt.putBoolean("TraderSuperDoomsdaySpawnLock", TraderSuperDoomsdaySpawnLock);
			nbt.putBoolean("TraderTheEndSpawnLock", TraderTheEndSpawnLock);
			nbt.putDouble("tradertimercounttick", tradertimercounttick);
			nbt.putBoolean("truechaosenabledbydev", truechaosenabledbydev);
			nbt.putBoolean("truehardcoreenabledonworld", truehardcoreenabledonworld);
			nbt.putDouble("tstormlightning", tstormlightning);
			nbt.putBoolean("unlockedtruechaos", unlockedtruechaos);
			nbt.putString("userids", userids);
			nbt.putBoolean("VeinMinerInstalled", VeinMinerInstalled);
			nbt.putBoolean("warnonce", warnonce);
			nbt.putBoolean("wormholesharkoabletospawn", wormholesharkoabletospawn);
			nbt.putDouble("wormholesharkorandnum", wormholesharkorandnum);
			nbt.putBoolean("xengiesharkoabletospawn", xengiesharkoabletospawn);
			nbt.putDouble("xengiesharkorandnum", xengiesharkorandnum);
			nbt.putDouble("HordeDialogueDisappearTimer", HordeDialogueDisappearTimer);
			nbt.putBoolean("finalforecasthordedialogue", finalforecasthordedialogue);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				EngiesChaosMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("engies_chaos", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double AngryEngieKillCount = 0.0;
		public boolean angryplushesobtained = false;
		public boolean biblicallyplushesobtained = false;
		public boolean BlindShadowSharkEngieAttack = false;
		public boolean boyoaprilfoolslaycheck = false;
		public double browniescount = 0.0;
		public double cheeseballcount = 0.0;
		public boolean coderedeemblock = false;
		public double CountUntilBaseDrop = 0;
		public boolean crucifixbypass = false;
		public boolean crucifixsavedentity = false;
		public double dashleftclickcount = 0;
		public boolean dashtoggle = false;
		public boolean ddayplayeraddedtodeadcount = false;
		public boolean diffadvancement1 = false;
		public boolean diffadvancement10 = false;
		public boolean diffadvancement11 = false;
		public boolean diffadvancement12 = false;
		public boolean diffadvancement13 = false;
		public boolean diffadvancement14 = false;
		public boolean diffadvancement15 = false;
		public boolean diffadvancement16 = false;
		public boolean diffadvancement17 = false;
		public boolean diffadvancement18 = false;
		public boolean diffadvancement19 = false;
		public boolean diffadvancement2 = false;
		public boolean diffadvancement20 = false;
		public boolean diffadvancement21 = false;
		public boolean diffadvancement22 = false;
		public boolean diffadvancement23 = false;
		public boolean diffadvancement24 = false;
		public boolean diffadvancement25 = false;
		public boolean diffadvancement26 = false;
		public boolean diffadvancement27 = false;
		public boolean diffadvancement28 = false;
		public boolean diffadvancement29 = false;
		public boolean diffadvancement3 = false;
		public boolean diffadvancement30 = false;
		public boolean diffadvancement31 = false;
		public boolean diffadvancement32 = false;
		public boolean diffadvancement4 = false;
		public boolean diffadvancement5 = false;
		public boolean diffadvancement6 = false;
		public boolean diffadvancement7 = false;
		public boolean diffadvancement8 = false;
		public boolean diffadvancement9 = false;
		public double difficultyoverlaytoggle = 3.0;
		public boolean DoomsdayAlive = false;
		public boolean DoomsdayRiskTrackToggle = false;
		public boolean DoomsdayTrackToggle = false;
		public double doublejumpcount = 1.0;
		public boolean doublejumping = false;
		public double engiegameshallowscythestatclock = 0;
		public double EnragedEngieKillCount = 0.0;
		public boolean enragedplushesobtained = false;
		public boolean entityabletodespawn = true;
		public boolean firstplay = false;
		public boolean GoodLuck = false;
		public boolean healthreductiondday = false;
		public double HHGLookX = 525.0;
		public double HHGLookY = 525.0;
		public double HHGLookZ = 525.0;
		public double HostileBiblicallyKillCount = 0;
		public double HostileEngieKillCount = 0;
		public boolean hostileplushesobtained = false;
		public boolean hphudtoggle = true;
		public double InsanityKillCount = 0.0;
		public boolean insanityplushesobtained = false;
		public double lightningflashnum = 0.0;
		public double MadEngieKillCount = 0.0;
		public boolean madplushesobtained = false;
		public boolean MaxPercentGiveOptionToDoHardestMobDiff = false;
		public double missileblueburstscale = 1.0;
		public double missilemoabscale = 1.0;
		public double missilenormalscale = 1.0;
		public double missileyellowlightningscale = 1.0;
		public double MonstrosityEngieKillCount = 0;
		public boolean monstrosityplushesobtained = false;
		public double OutragedEngieKillCount = 0.0;
		public boolean outragedplushesobtained = false;
		public double pageNumber = 1.0;
		public boolean Photosensitivity = false;
		public double pickaxeonly = 0;
		public boolean playerattackbackstabblock = true;
		public boolean playercountedtoplayercount = false;
		public double PlayerDeathX = 0;
		public double PlayerDeathY = 0;
		public double PlayerDeathZ = 0;
		public boolean playerdebugmode = false;
		public boolean PlayerHas101PercentAdvancement = false;
		public boolean PlayerHasAntimatterEngieGamesSwordAdvancement = false;
		public boolean PlayerHasEngieGamesSwordAdvancement = false;
		public boolean playerhasimmunity = false;
		public boolean playerready = false;
		public boolean playerrequested = false;
		public boolean playerstunned = false;
		public boolean playerstunnedmobs = false;
		public double PlayerX = 0.0;
		public double PlayerY = 0.0;
		public double PlayerZ = 0.0;
		public double PureInsanityKillCount = 0;
		public boolean recipebookantimattercraftstoggle = false;
		public boolean RespawnNormInstantHealth = false;
		public boolean RespawnTrueHardcoreGraceStart = false;
		public boolean riftspawnoneentity = false;
		public double RiftX = 0;
		public double RiftY = 0;
		public double RiftZ = 0;
		public boolean SharkoLayCD = true;
		public boolean sharkolayingstate = false;
		public boolean SharkoLayOnSideCD = true;
		public boolean SharkoRetryState = false;
		public boolean SharkoSitCD = true;
		public boolean SharkoSleepCD = true;
		public boolean timeoverlaytoggle = false;
		public double TrueHardcoreLifeChangeAmount = 0;
		public double TrueHardcoreLifeCount = 10.0;
		public boolean truehardcorelifesobtained = false;
		public double TrueHardcoreMaxLifeCount = 0;
		public boolean WelcomeBackToggle = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				EngiesChaosMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("AngryEngieKillCount", AngryEngieKillCount);
			nbt.putBoolean("angryplushesobtained", angryplushesobtained);
			nbt.putBoolean("biblicallyplushesobtained", biblicallyplushesobtained);
			nbt.putBoolean("BlindShadowSharkEngieAttack", BlindShadowSharkEngieAttack);
			nbt.putBoolean("boyoaprilfoolslaycheck", boyoaprilfoolslaycheck);
			nbt.putDouble("browniescount", browniescount);
			nbt.putDouble("cheeseballcount", cheeseballcount);
			nbt.putBoolean("coderedeemblock", coderedeemblock);
			nbt.putDouble("CountUntilBaseDrop", CountUntilBaseDrop);
			nbt.putBoolean("crucifixbypass", crucifixbypass);
			nbt.putBoolean("crucifixsavedentity", crucifixsavedentity);
			nbt.putDouble("dashleftclickcount", dashleftclickcount);
			nbt.putBoolean("dashtoggle", dashtoggle);
			nbt.putBoolean("ddayplayeraddedtodeadcount", ddayplayeraddedtodeadcount);
			nbt.putBoolean("diffadvancement1", diffadvancement1);
			nbt.putBoolean("diffadvancement10", diffadvancement10);
			nbt.putBoolean("diffadvancement11", diffadvancement11);
			nbt.putBoolean("diffadvancement12", diffadvancement12);
			nbt.putBoolean("diffadvancement13", diffadvancement13);
			nbt.putBoolean("diffadvancement14", diffadvancement14);
			nbt.putBoolean("diffadvancement15", diffadvancement15);
			nbt.putBoolean("diffadvancement16", diffadvancement16);
			nbt.putBoolean("diffadvancement17", diffadvancement17);
			nbt.putBoolean("diffadvancement18", diffadvancement18);
			nbt.putBoolean("diffadvancement19", diffadvancement19);
			nbt.putBoolean("diffadvancement2", diffadvancement2);
			nbt.putBoolean("diffadvancement20", diffadvancement20);
			nbt.putBoolean("diffadvancement21", diffadvancement21);
			nbt.putBoolean("diffadvancement22", diffadvancement22);
			nbt.putBoolean("diffadvancement23", diffadvancement23);
			nbt.putBoolean("diffadvancement24", diffadvancement24);
			nbt.putBoolean("diffadvancement25", diffadvancement25);
			nbt.putBoolean("diffadvancement26", diffadvancement26);
			nbt.putBoolean("diffadvancement27", diffadvancement27);
			nbt.putBoolean("diffadvancement28", diffadvancement28);
			nbt.putBoolean("diffadvancement29", diffadvancement29);
			nbt.putBoolean("diffadvancement3", diffadvancement3);
			nbt.putBoolean("diffadvancement30", diffadvancement30);
			nbt.putBoolean("diffadvancement31", diffadvancement31);
			nbt.putBoolean("diffadvancement32", diffadvancement32);
			nbt.putBoolean("diffadvancement4", diffadvancement4);
			nbt.putBoolean("diffadvancement5", diffadvancement5);
			nbt.putBoolean("diffadvancement6", diffadvancement6);
			nbt.putBoolean("diffadvancement7", diffadvancement7);
			nbt.putBoolean("diffadvancement8", diffadvancement8);
			nbt.putBoolean("diffadvancement9", diffadvancement9);
			nbt.putDouble("difficultyoverlaytoggle", difficultyoverlaytoggle);
			nbt.putBoolean("DoomsdayAlive", DoomsdayAlive);
			nbt.putBoolean("DoomsdayRiskTrackToggle", DoomsdayRiskTrackToggle);
			nbt.putBoolean("DoomsdayTrackToggle", DoomsdayTrackToggle);
			nbt.putDouble("doublejumpcount", doublejumpcount);
			nbt.putBoolean("doublejumping", doublejumping);
			nbt.putDouble("engiegameshallowscythestatclock", engiegameshallowscythestatclock);
			nbt.putDouble("EnragedEngieKillCount", EnragedEngieKillCount);
			nbt.putBoolean("enragedplushesobtained", enragedplushesobtained);
			nbt.putBoolean("entityabletodespawn", entityabletodespawn);
			nbt.putBoolean("firstplay", firstplay);
			nbt.putBoolean("GoodLuck", GoodLuck);
			nbt.putBoolean("healthreductiondday", healthreductiondday);
			nbt.putDouble("HHGLookX", HHGLookX);
			nbt.putDouble("HHGLookY", HHGLookY);
			nbt.putDouble("HHGLookZ", HHGLookZ);
			nbt.putDouble("HostileBiblicallyKillCount", HostileBiblicallyKillCount);
			nbt.putDouble("HostileEngieKillCount", HostileEngieKillCount);
			nbt.putBoolean("hostileplushesobtained", hostileplushesobtained);
			nbt.putBoolean("hphudtoggle", hphudtoggle);
			nbt.putDouble("InsanityKillCount", InsanityKillCount);
			nbt.putBoolean("insanityplushesobtained", insanityplushesobtained);
			nbt.putDouble("lightningflashnum", lightningflashnum);
			nbt.putDouble("MadEngieKillCount", MadEngieKillCount);
			nbt.putBoolean("madplushesobtained", madplushesobtained);
			nbt.putBoolean("MaxPercentGiveOptionToDoHardestMobDiff", MaxPercentGiveOptionToDoHardestMobDiff);
			nbt.putDouble("missileblueburstscale", missileblueburstscale);
			nbt.putDouble("missilemoabscale", missilemoabscale);
			nbt.putDouble("missilenormalscale", missilenormalscale);
			nbt.putDouble("missileyellowlightningscale", missileyellowlightningscale);
			nbt.putDouble("MonstrosityEngieKillCount", MonstrosityEngieKillCount);
			nbt.putBoolean("monstrosityplushesobtained", monstrosityplushesobtained);
			nbt.putDouble("OutragedEngieKillCount", OutragedEngieKillCount);
			nbt.putBoolean("outragedplushesobtained", outragedplushesobtained);
			nbt.putDouble("pageNumber", pageNumber);
			nbt.putBoolean("Photosensitivity", Photosensitivity);
			nbt.putDouble("pickaxeonly", pickaxeonly);
			nbt.putBoolean("playerattackbackstabblock", playerattackbackstabblock);
			nbt.putBoolean("playercountedtoplayercount", playercountedtoplayercount);
			nbt.putDouble("PlayerDeathX", PlayerDeathX);
			nbt.putDouble("PlayerDeathY", PlayerDeathY);
			nbt.putDouble("PlayerDeathZ", PlayerDeathZ);
			nbt.putBoolean("playerdebugmode", playerdebugmode);
			nbt.putBoolean("PlayerHas101PercentAdvancement", PlayerHas101PercentAdvancement);
			nbt.putBoolean("PlayerHasAntimatterEngieGamesSwordAdvancement", PlayerHasAntimatterEngieGamesSwordAdvancement);
			nbt.putBoolean("PlayerHasEngieGamesSwordAdvancement", PlayerHasEngieGamesSwordAdvancement);
			nbt.putBoolean("playerhasimmunity", playerhasimmunity);
			nbt.putBoolean("playerready", playerready);
			nbt.putBoolean("playerrequested", playerrequested);
			nbt.putBoolean("playerstunned", playerstunned);
			nbt.putBoolean("playerstunnedmobs", playerstunnedmobs);
			nbt.putDouble("PlayerX", PlayerX);
			nbt.putDouble("PlayerY", PlayerY);
			nbt.putDouble("PlayerZ", PlayerZ);
			nbt.putDouble("PureInsanityKillCount", PureInsanityKillCount);
			nbt.putBoolean("recipebookantimattercraftstoggle", recipebookantimattercraftstoggle);
			nbt.putBoolean("RespawnNormInstantHealth", RespawnNormInstantHealth);
			nbt.putBoolean("RespawnTrueHardcoreGraceStart", RespawnTrueHardcoreGraceStart);
			nbt.putBoolean("riftspawnoneentity", riftspawnoneentity);
			nbt.putDouble("RiftX", RiftX);
			nbt.putDouble("RiftY", RiftY);
			nbt.putDouble("RiftZ", RiftZ);
			nbt.putBoolean("SharkoLayCD", SharkoLayCD);
			nbt.putBoolean("sharkolayingstate", sharkolayingstate);
			nbt.putBoolean("SharkoLayOnSideCD", SharkoLayOnSideCD);
			nbt.putBoolean("SharkoRetryState", SharkoRetryState);
			nbt.putBoolean("SharkoSitCD", SharkoSitCD);
			nbt.putBoolean("SharkoSleepCD", SharkoSleepCD);
			nbt.putBoolean("timeoverlaytoggle", timeoverlaytoggle);
			nbt.putDouble("TrueHardcoreLifeChangeAmount", TrueHardcoreLifeChangeAmount);
			nbt.putDouble("TrueHardcoreLifeCount", TrueHardcoreLifeCount);
			nbt.putBoolean("truehardcorelifesobtained", truehardcorelifesobtained);
			nbt.putDouble("TrueHardcoreMaxLifeCount", TrueHardcoreMaxLifeCount);
			nbt.putBoolean("WelcomeBackToggle", WelcomeBackToggle);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			AngryEngieKillCount = nbt.getDouble("AngryEngieKillCount");
			angryplushesobtained = nbt.getBoolean("angryplushesobtained");
			biblicallyplushesobtained = nbt.getBoolean("biblicallyplushesobtained");
			BlindShadowSharkEngieAttack = nbt.getBoolean("BlindShadowSharkEngieAttack");
			boyoaprilfoolslaycheck = nbt.getBoolean("boyoaprilfoolslaycheck");
			browniescount = nbt.getDouble("browniescount");
			cheeseballcount = nbt.getDouble("cheeseballcount");
			coderedeemblock = nbt.getBoolean("coderedeemblock");
			CountUntilBaseDrop = nbt.getDouble("CountUntilBaseDrop");
			crucifixbypass = nbt.getBoolean("crucifixbypass");
			crucifixsavedentity = nbt.getBoolean("crucifixsavedentity");
			dashleftclickcount = nbt.getDouble("dashleftclickcount");
			dashtoggle = nbt.getBoolean("dashtoggle");
			ddayplayeraddedtodeadcount = nbt.getBoolean("ddayplayeraddedtodeadcount");
			diffadvancement1 = nbt.getBoolean("diffadvancement1");
			diffadvancement10 = nbt.getBoolean("diffadvancement10");
			diffadvancement11 = nbt.getBoolean("diffadvancement11");
			diffadvancement12 = nbt.getBoolean("diffadvancement12");
			diffadvancement13 = nbt.getBoolean("diffadvancement13");
			diffadvancement14 = nbt.getBoolean("diffadvancement14");
			diffadvancement15 = nbt.getBoolean("diffadvancement15");
			diffadvancement16 = nbt.getBoolean("diffadvancement16");
			diffadvancement17 = nbt.getBoolean("diffadvancement17");
			diffadvancement18 = nbt.getBoolean("diffadvancement18");
			diffadvancement19 = nbt.getBoolean("diffadvancement19");
			diffadvancement2 = nbt.getBoolean("diffadvancement2");
			diffadvancement20 = nbt.getBoolean("diffadvancement20");
			diffadvancement21 = nbt.getBoolean("diffadvancement21");
			diffadvancement22 = nbt.getBoolean("diffadvancement22");
			diffadvancement23 = nbt.getBoolean("diffadvancement23");
			diffadvancement24 = nbt.getBoolean("diffadvancement24");
			diffadvancement25 = nbt.getBoolean("diffadvancement25");
			diffadvancement26 = nbt.getBoolean("diffadvancement26");
			diffadvancement27 = nbt.getBoolean("diffadvancement27");
			diffadvancement28 = nbt.getBoolean("diffadvancement28");
			diffadvancement29 = nbt.getBoolean("diffadvancement29");
			diffadvancement3 = nbt.getBoolean("diffadvancement3");
			diffadvancement30 = nbt.getBoolean("diffadvancement30");
			diffadvancement31 = nbt.getBoolean("diffadvancement31");
			diffadvancement32 = nbt.getBoolean("diffadvancement32");
			diffadvancement4 = nbt.getBoolean("diffadvancement4");
			diffadvancement5 = nbt.getBoolean("diffadvancement5");
			diffadvancement6 = nbt.getBoolean("diffadvancement6");
			diffadvancement7 = nbt.getBoolean("diffadvancement7");
			diffadvancement8 = nbt.getBoolean("diffadvancement8");
			diffadvancement9 = nbt.getBoolean("diffadvancement9");
			difficultyoverlaytoggle = nbt.getDouble("difficultyoverlaytoggle");
			DoomsdayAlive = nbt.getBoolean("DoomsdayAlive");
			DoomsdayRiskTrackToggle = nbt.getBoolean("DoomsdayRiskTrackToggle");
			DoomsdayTrackToggle = nbt.getBoolean("DoomsdayTrackToggle");
			doublejumpcount = nbt.getDouble("doublejumpcount");
			doublejumping = nbt.getBoolean("doublejumping");
			engiegameshallowscythestatclock = nbt.getDouble("engiegameshallowscythestatclock");
			EnragedEngieKillCount = nbt.getDouble("EnragedEngieKillCount");
			enragedplushesobtained = nbt.getBoolean("enragedplushesobtained");
			entityabletodespawn = nbt.getBoolean("entityabletodespawn");
			firstplay = nbt.getBoolean("firstplay");
			GoodLuck = nbt.getBoolean("GoodLuck");
			healthreductiondday = nbt.getBoolean("healthreductiondday");
			HHGLookX = nbt.getDouble("HHGLookX");
			HHGLookY = nbt.getDouble("HHGLookY");
			HHGLookZ = nbt.getDouble("HHGLookZ");
			HostileBiblicallyKillCount = nbt.getDouble("HostileBiblicallyKillCount");
			HostileEngieKillCount = nbt.getDouble("HostileEngieKillCount");
			hostileplushesobtained = nbt.getBoolean("hostileplushesobtained");
			hphudtoggle = nbt.getBoolean("hphudtoggle");
			InsanityKillCount = nbt.getDouble("InsanityKillCount");
			insanityplushesobtained = nbt.getBoolean("insanityplushesobtained");
			lightningflashnum = nbt.getDouble("lightningflashnum");
			MadEngieKillCount = nbt.getDouble("MadEngieKillCount");
			madplushesobtained = nbt.getBoolean("madplushesobtained");
			MaxPercentGiveOptionToDoHardestMobDiff = nbt.getBoolean("MaxPercentGiveOptionToDoHardestMobDiff");
			missileblueburstscale = nbt.getDouble("missileblueburstscale");
			missilemoabscale = nbt.getDouble("missilemoabscale");
			missilenormalscale = nbt.getDouble("missilenormalscale");
			missileyellowlightningscale = nbt.getDouble("missileyellowlightningscale");
			MonstrosityEngieKillCount = nbt.getDouble("MonstrosityEngieKillCount");
			monstrosityplushesobtained = nbt.getBoolean("monstrosityplushesobtained");
			OutragedEngieKillCount = nbt.getDouble("OutragedEngieKillCount");
			outragedplushesobtained = nbt.getBoolean("outragedplushesobtained");
			pageNumber = nbt.getDouble("pageNumber");
			Photosensitivity = nbt.getBoolean("Photosensitivity");
			pickaxeonly = nbt.getDouble("pickaxeonly");
			playerattackbackstabblock = nbt.getBoolean("playerattackbackstabblock");
			playercountedtoplayercount = nbt.getBoolean("playercountedtoplayercount");
			PlayerDeathX = nbt.getDouble("PlayerDeathX");
			PlayerDeathY = nbt.getDouble("PlayerDeathY");
			PlayerDeathZ = nbt.getDouble("PlayerDeathZ");
			playerdebugmode = nbt.getBoolean("playerdebugmode");
			PlayerHas101PercentAdvancement = nbt.getBoolean("PlayerHas101PercentAdvancement");
			PlayerHasAntimatterEngieGamesSwordAdvancement = nbt.getBoolean("PlayerHasAntimatterEngieGamesSwordAdvancement");
			PlayerHasEngieGamesSwordAdvancement = nbt.getBoolean("PlayerHasEngieGamesSwordAdvancement");
			playerhasimmunity = nbt.getBoolean("playerhasimmunity");
			playerready = nbt.getBoolean("playerready");
			playerrequested = nbt.getBoolean("playerrequested");
			playerstunned = nbt.getBoolean("playerstunned");
			playerstunnedmobs = nbt.getBoolean("playerstunnedmobs");
			PlayerX = nbt.getDouble("PlayerX");
			PlayerY = nbt.getDouble("PlayerY");
			PlayerZ = nbt.getDouble("PlayerZ");
			PureInsanityKillCount = nbt.getDouble("PureInsanityKillCount");
			recipebookantimattercraftstoggle = nbt.getBoolean("recipebookantimattercraftstoggle");
			RespawnNormInstantHealth = nbt.getBoolean("RespawnNormInstantHealth");
			RespawnTrueHardcoreGraceStart = nbt.getBoolean("RespawnTrueHardcoreGraceStart");
			riftspawnoneentity = nbt.getBoolean("riftspawnoneentity");
			RiftX = nbt.getDouble("RiftX");
			RiftY = nbt.getDouble("RiftY");
			RiftZ = nbt.getDouble("RiftZ");
			SharkoLayCD = nbt.getBoolean("SharkoLayCD");
			sharkolayingstate = nbt.getBoolean("sharkolayingstate");
			SharkoLayOnSideCD = nbt.getBoolean("SharkoLayOnSideCD");
			SharkoRetryState = nbt.getBoolean("SharkoRetryState");
			SharkoSitCD = nbt.getBoolean("SharkoSitCD");
			SharkoSleepCD = nbt.getBoolean("SharkoSleepCD");
			timeoverlaytoggle = nbt.getBoolean("timeoverlaytoggle");
			TrueHardcoreLifeChangeAmount = nbt.getDouble("TrueHardcoreLifeChangeAmount");
			TrueHardcoreLifeCount = nbt.getDouble("TrueHardcoreLifeCount");
			truehardcorelifesobtained = nbt.getBoolean("truehardcorelifesobtained");
			TrueHardcoreMaxLifeCount = nbt.getDouble("TrueHardcoreMaxLifeCount");
			WelcomeBackToggle = nbt.getBoolean("WelcomeBackToggle");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.AngryEngieKillCount = message.data.AngryEngieKillCount;
					variables.angryplushesobtained = message.data.angryplushesobtained;
					variables.biblicallyplushesobtained = message.data.biblicallyplushesobtained;
					variables.BlindShadowSharkEngieAttack = message.data.BlindShadowSharkEngieAttack;
					variables.boyoaprilfoolslaycheck = message.data.boyoaprilfoolslaycheck;
					variables.browniescount = message.data.browniescount;
					variables.cheeseballcount = message.data.cheeseballcount;
					variables.coderedeemblock = message.data.coderedeemblock;
					variables.CountUntilBaseDrop = message.data.CountUntilBaseDrop;
					variables.crucifixbypass = message.data.crucifixbypass;
					variables.crucifixsavedentity = message.data.crucifixsavedentity;
					variables.dashleftclickcount = message.data.dashleftclickcount;
					variables.dashtoggle = message.data.dashtoggle;
					variables.ddayplayeraddedtodeadcount = message.data.ddayplayeraddedtodeadcount;
					variables.diffadvancement1 = message.data.diffadvancement1;
					variables.diffadvancement10 = message.data.diffadvancement10;
					variables.diffadvancement11 = message.data.diffadvancement11;
					variables.diffadvancement12 = message.data.diffadvancement12;
					variables.diffadvancement13 = message.data.diffadvancement13;
					variables.diffadvancement14 = message.data.diffadvancement14;
					variables.diffadvancement15 = message.data.diffadvancement15;
					variables.diffadvancement16 = message.data.diffadvancement16;
					variables.diffadvancement17 = message.data.diffadvancement17;
					variables.diffadvancement18 = message.data.diffadvancement18;
					variables.diffadvancement19 = message.data.diffadvancement19;
					variables.diffadvancement2 = message.data.diffadvancement2;
					variables.diffadvancement20 = message.data.diffadvancement20;
					variables.diffadvancement21 = message.data.diffadvancement21;
					variables.diffadvancement22 = message.data.diffadvancement22;
					variables.diffadvancement23 = message.data.diffadvancement23;
					variables.diffadvancement24 = message.data.diffadvancement24;
					variables.diffadvancement25 = message.data.diffadvancement25;
					variables.diffadvancement26 = message.data.diffadvancement26;
					variables.diffadvancement27 = message.data.diffadvancement27;
					variables.diffadvancement28 = message.data.diffadvancement28;
					variables.diffadvancement29 = message.data.diffadvancement29;
					variables.diffadvancement3 = message.data.diffadvancement3;
					variables.diffadvancement30 = message.data.diffadvancement30;
					variables.diffadvancement31 = message.data.diffadvancement31;
					variables.diffadvancement32 = message.data.diffadvancement32;
					variables.diffadvancement4 = message.data.diffadvancement4;
					variables.diffadvancement5 = message.data.diffadvancement5;
					variables.diffadvancement6 = message.data.diffadvancement6;
					variables.diffadvancement7 = message.data.diffadvancement7;
					variables.diffadvancement8 = message.data.diffadvancement8;
					variables.diffadvancement9 = message.data.diffadvancement9;
					variables.difficultyoverlaytoggle = message.data.difficultyoverlaytoggle;
					variables.DoomsdayAlive = message.data.DoomsdayAlive;
					variables.DoomsdayRiskTrackToggle = message.data.DoomsdayRiskTrackToggle;
					variables.DoomsdayTrackToggle = message.data.DoomsdayTrackToggle;
					variables.doublejumpcount = message.data.doublejumpcount;
					variables.doublejumping = message.data.doublejumping;
					variables.engiegameshallowscythestatclock = message.data.engiegameshallowscythestatclock;
					variables.EnragedEngieKillCount = message.data.EnragedEngieKillCount;
					variables.enragedplushesobtained = message.data.enragedplushesobtained;
					variables.entityabletodespawn = message.data.entityabletodespawn;
					variables.firstplay = message.data.firstplay;
					variables.GoodLuck = message.data.GoodLuck;
					variables.healthreductiondday = message.data.healthreductiondday;
					variables.HHGLookX = message.data.HHGLookX;
					variables.HHGLookY = message.data.HHGLookY;
					variables.HHGLookZ = message.data.HHGLookZ;
					variables.HostileBiblicallyKillCount = message.data.HostileBiblicallyKillCount;
					variables.HostileEngieKillCount = message.data.HostileEngieKillCount;
					variables.hostileplushesobtained = message.data.hostileplushesobtained;
					variables.hphudtoggle = message.data.hphudtoggle;
					variables.InsanityKillCount = message.data.InsanityKillCount;
					variables.insanityplushesobtained = message.data.insanityplushesobtained;
					variables.lightningflashnum = message.data.lightningflashnum;
					variables.MadEngieKillCount = message.data.MadEngieKillCount;
					variables.madplushesobtained = message.data.madplushesobtained;
					variables.MaxPercentGiveOptionToDoHardestMobDiff = message.data.MaxPercentGiveOptionToDoHardestMobDiff;
					variables.missileblueburstscale = message.data.missileblueburstscale;
					variables.missilemoabscale = message.data.missilemoabscale;
					variables.missilenormalscale = message.data.missilenormalscale;
					variables.missileyellowlightningscale = message.data.missileyellowlightningscale;
					variables.MonstrosityEngieKillCount = message.data.MonstrosityEngieKillCount;
					variables.monstrosityplushesobtained = message.data.monstrosityplushesobtained;
					variables.OutragedEngieKillCount = message.data.OutragedEngieKillCount;
					variables.outragedplushesobtained = message.data.outragedplushesobtained;
					variables.pageNumber = message.data.pageNumber;
					variables.Photosensitivity = message.data.Photosensitivity;
					variables.pickaxeonly = message.data.pickaxeonly;
					variables.playerattackbackstabblock = message.data.playerattackbackstabblock;
					variables.playercountedtoplayercount = message.data.playercountedtoplayercount;
					variables.PlayerDeathX = message.data.PlayerDeathX;
					variables.PlayerDeathY = message.data.PlayerDeathY;
					variables.PlayerDeathZ = message.data.PlayerDeathZ;
					variables.playerdebugmode = message.data.playerdebugmode;
					variables.PlayerHas101PercentAdvancement = message.data.PlayerHas101PercentAdvancement;
					variables.PlayerHasAntimatterEngieGamesSwordAdvancement = message.data.PlayerHasAntimatterEngieGamesSwordAdvancement;
					variables.PlayerHasEngieGamesSwordAdvancement = message.data.PlayerHasEngieGamesSwordAdvancement;
					variables.playerhasimmunity = message.data.playerhasimmunity;
					variables.playerready = message.data.playerready;
					variables.playerrequested = message.data.playerrequested;
					variables.playerstunned = message.data.playerstunned;
					variables.playerstunnedmobs = message.data.playerstunnedmobs;
					variables.PlayerX = message.data.PlayerX;
					variables.PlayerY = message.data.PlayerY;
					variables.PlayerZ = message.data.PlayerZ;
					variables.PureInsanityKillCount = message.data.PureInsanityKillCount;
					variables.recipebookantimattercraftstoggle = message.data.recipebookantimattercraftstoggle;
					variables.RespawnNormInstantHealth = message.data.RespawnNormInstantHealth;
					variables.RespawnTrueHardcoreGraceStart = message.data.RespawnTrueHardcoreGraceStart;
					variables.riftspawnoneentity = message.data.riftspawnoneentity;
					variables.RiftX = message.data.RiftX;
					variables.RiftY = message.data.RiftY;
					variables.RiftZ = message.data.RiftZ;
					variables.SharkoLayCD = message.data.SharkoLayCD;
					variables.sharkolayingstate = message.data.sharkolayingstate;
					variables.SharkoLayOnSideCD = message.data.SharkoLayOnSideCD;
					variables.SharkoRetryState = message.data.SharkoRetryState;
					variables.SharkoSitCD = message.data.SharkoSitCD;
					variables.SharkoSleepCD = message.data.SharkoSleepCD;
					variables.timeoverlaytoggle = message.data.timeoverlaytoggle;
					variables.TrueHardcoreLifeChangeAmount = message.data.TrueHardcoreLifeChangeAmount;
					variables.TrueHardcoreLifeCount = message.data.TrueHardcoreLifeCount;
					variables.truehardcorelifesobtained = message.data.truehardcorelifesobtained;
					variables.TrueHardcoreMaxLifeCount = message.data.TrueHardcoreMaxLifeCount;
					variables.WelcomeBackToggle = message.data.WelcomeBackToggle;
				}
			});
			context.setPacketHandled(true);
		}
	}
}