package engiegames.engies_chaos.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import engiegames.engies_chaos.init.EngiesChaosModTabs;
import engiegames.engies_chaos.init.EngiesChaosModItems;

public class WormholeSharkoAxeItem extends AxeItem {
	public WormholeSharkoAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 5605;
			}

			public float getSpeed() {
				return 72f;
			}

			public float getAttackDamageBonus() {
				return 5308f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 90;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EngiesChaosModItems.WORMHOLE_SHARKO_CLOTH.get()));
			}
		}, 1, -1.3f, new Item.Properties().tab(EngiesChaosModTabs.TAB_ENGIES_CHAOS_ITEMS));
	}
}