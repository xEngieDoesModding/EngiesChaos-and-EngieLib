package engiegames.engies_chaos.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.Map;

import engiegames.engies_chaos.network.EngiesChaosModVariables;
import engiegames.engies_chaos.init.EngiesChaosModGameRules;
import engiegames.engies_chaos.init.EngiesChaosModBlocks;

public class MainOreChecksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate.getBlock() == EngiesChaosModBlocks.ENGIE_ORE.get() || blockstate.getBlock() == EngiesChaosModBlocks.MAD_ENGIE_ORE.get() || blockstate.getBlock() == EngiesChaosModBlocks.UNOBTAINIUM_ORE.get()) {
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.TRUE_THROWBACK_TOGGLE) == true) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Blocks.STONE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
		} else if (blockstate.getBlock() == EngiesChaosModBlocks.DEEPSLATE_ENGIE_ORE.get() || blockstate.getBlock() == EngiesChaosModBlocks.DEEPSLATE_MAD_ENGIE_ORE.get()
				|| blockstate.getBlock() == EngiesChaosModBlocks.DEEPSLATE_UNOBTAINIUM_ORE.get()) {
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.TRUE_THROWBACK_TOGGLE) == true) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Blocks.DEEPSLATE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
		} else if (blockstate.getBlock() == EngiesChaosModBlocks.ANTIMATTER_ORE.get()) {
			if (world.getLevelData().getGameRules().getBoolean(EngiesChaosModGameRules.TRUE_THROWBACK_TOGGLE) == true) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Blocks.END_STONE.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else {
				if (EngiesChaosModVariables.MapVariables.get(world).antimatterdropcheck == false) {
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = Blocks.END_STONE.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				}
			}
		}
	}
}