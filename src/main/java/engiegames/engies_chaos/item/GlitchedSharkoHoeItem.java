package engiegames.engies_chaos.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import engiegames.engies_chaos.init.EngiesChaosModTabs;
import engiegames.engies_chaos.init.EngiesChaosModItems;

public class GlitchedSharkoHoeItem extends HoeItem {
	public GlitchedSharkoHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 5900;
			}

			public float getSpeed() {
				return 76f;
			}

			public float getAttackDamageBonus() {
				return 5604f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 95;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EngiesChaosModItems.GLITCHED_SHARKO_CLOTH.get()));
			}
		}, 0, -1.2f, new Item.Properties().tab(EngiesChaosModTabs.TAB_ENGIES_CHAOS_ITEMS));
	}
}