package engiegames.engies_chaos.procedures;

import net.minecraft.world.level.LevelAccessor;

import engiegames.engies_chaos.network.EngiesChaosModVariables;

public class DoomsdayDialogueForecastHordeDisplayVar7Procedure {
	public static boolean execute(LevelAccessor world) {
		if (EngiesChaosModVariables.MapVariables.get(world).doomsdayhordedialogue == 3 && (EngiesChaosModVariables.MapVariables.get(world).ddayprophnumb == 1 && EngiesChaosModVariables.MapVariables.get(world).ddayprophnormhordenumb == 7
				|| EngiesChaosModVariables.MapVariables.get(world).ddayprophnumb == 2 && EngiesChaosModVariables.MapVariables.get(world).ddayprophnightmarehordenumb == 7
				|| EngiesChaosModVariables.MapVariables.get(world).ddayprophnumb == 3 && EngiesChaosModVariables.MapVariables.get(world).ddayprophinsanityhordenumb == 7
				|| EngiesChaosModVariables.MapVariables.get(world).ddayprophnumb == 4 && EngiesChaosModVariables.MapVariables.get(world).ddayprophengiepochordenumb == 7)) {
			return true;
		}
		return false;
	}
}