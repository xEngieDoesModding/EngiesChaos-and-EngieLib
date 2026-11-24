package engiegames.engies_chaos.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import engiegames.engies_chaos.network.EngiesChaosModVariables;

@Mod.EventBusSubscriber
public class ForecastHordeDialogueProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
			if (EngiesChaosModVariables.MapVariables.get(world).dohordedialogue == true) {
				if (EngiesChaosModVariables.MapVariables.get(world).pausedialogue == true) {
					EngiesChaosModVariables.MapVariables.get(world).forecasthordedialoguetimer = 0;
					EngiesChaosModVariables.MapVariables.get(world).syncData(world);
					EngiesChaosModVariables.MapVariables.get(world).HordeDialogueDisappearTimer = EngiesChaosModVariables.MapVariables.get(world).HordeDialogueDisappearTimer + 0.05;
					EngiesChaosModVariables.MapVariables.get(world).syncData(world);
					if (EngiesChaosModVariables.MapVariables.get(world).HordeDialogueDisappearTimer >= 5) {
						EngiesChaosModVariables.MapVariables.get(world).HordeDialogueDisappearTimer = 0;
						EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						EngiesChaosModVariables.MapVariables.get(world).doomsdayhordedialogue = 0;
						EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						if (EngiesChaosModVariables.MapVariables.get(world).finalforecasthordedialogue == true) {
							EngiesChaosModVariables.MapVariables.get(world).dohordedialogue = false;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).hordespawnstoggle = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).pausedialogue = false;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).ddaystoptimer = false;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						} else {
							EngiesChaosModVariables.MapVariables.get(world).pausedialogue = false;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						}
					}
				} else {
					EngiesChaosModVariables.MapVariables.get(world).forecasthordedialoguetimer = EngiesChaosModVariables.MapVariables.get(world).forecasthordedialoguetimer + 0.05;
					EngiesChaosModVariables.MapVariables.get(world).syncData(world);
					if (EngiesChaosModVariables.MapVariables.get(world).forecasthordedialoguetimer >= 5) {
						if (EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue == 0) {
							EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue = 1;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).doomsdayhordedialogue = 1;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).pausedialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).ddaydialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						} else if (EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue == 1) {
							EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue = 2;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).doomsdayhordedialogue = 2;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).HordeDialogueDisappearTimer = -3;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).pausedialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).ddaydialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						} else if (EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue == 2) {
							EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue = 3;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).doomsdayhordedialogue = 3;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).pausedialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).ddaydialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						} else if (EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue == 3) {
							EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue = 4;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).doomsdayhordedialogue = 4;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).HordeDialogueDisappearTimer = -3;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).pausedialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).ddaydialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
							EngiesChaosModVariables.MapVariables.get(world).finalforecasthordedialogue = true;
							EngiesChaosModVariables.MapVariables.get(world).syncData(world);
						}
					}
				}
			} else if (EngiesChaosModVariables.MapVariables.get(world).dohordedialogue == false) {
				EngiesChaosModVariables.MapVariables.get(world).forecasthordedialoguetimer = 0;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
				EngiesChaosModVariables.MapVariables.get(world).HordeDialogueDisappearTimer = 0;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
				EngiesChaosModVariables.MapVariables.get(world).doomsdayhordedialogue = 0;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
				EngiesChaosModVariables.MapVariables.get(world).forecasthordedialogue = 0;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
				EngiesChaosModVariables.MapVariables.get(world).finalforecasthordedialogue = false;
				EngiesChaosModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}