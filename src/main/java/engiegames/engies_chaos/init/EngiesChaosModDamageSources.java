/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package engiegames.engies_chaos.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.damagesource.DamageSource;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EngiesChaosModDamageSources {
	public static final DamageSource YELLOW_LIGHTNING_EXPLOSION = (new DamageSource("yellow_lightning_explosion"));
	public static final DamageSource BLUE_BURST_EXPLOSION = (new DamageSource("blue_burst_explosion"));
	public static final DamageSource NORMAL_EXPLOSION = (new DamageSource("normal_explosion"));
	public static final DamageSource MOAB_EXPLOSION = (new DamageSource("moab_explosion"));
	public static final DamageSource CHALLENGE_PLUSH_FAILED = (new DamageSource("challenge_plush_failed")).setMagic();
	public static final DamageSource AVALANCHE_BALL_TICK = (new DamageSource("avalanche_ball_tick")).bypassArmor();
	public static final DamageSource DOOMS_LIGHTNING = (new DamageSource("dooms_lightning")).bypassArmor().setIsFire();
	public static final DamageSource RIFT_BALL_DAMAGE = (new DamageSource("rift_ball_damage")).setMagic();
	public static final DamageSource DOOMS_SPIKE_DAMAGE = (new DamageSource("dooms_spike_damage"));
}