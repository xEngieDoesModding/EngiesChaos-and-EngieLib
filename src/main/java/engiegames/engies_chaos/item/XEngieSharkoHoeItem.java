package engiegames.engies_chaos.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import engiegames.engies_chaos.init.EngiesChaosModTabs;
import engiegames.engies_chaos.init.EngiesChaosModItems;

public class XEngieSharkoHoeItem extends HoeItem {
	public XEngieSharkoHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 6195;
			}

			public float getSpeed() {
				return 80f;
			}

			public float getAttackDamageBonus() {
				return 5899f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 100;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EngiesChaosModItems.X_ENGIE_SHARKO_CLOTH.get()));
			}
		}, 0, -1.1f, new Item.Properties().tab(EngiesChaosModTabs.TAB_ENGIES_CHAOS_ITEMS));
	}
}