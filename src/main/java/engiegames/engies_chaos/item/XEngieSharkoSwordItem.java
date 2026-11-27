package engiegames.engies_chaos.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import engiegames.engies_chaos.init.EngiesChaosModTabs;
import engiegames.engies_chaos.init.EngiesChaosModItems;

public class XEngieSharkoSwordItem extends SwordItem {
	public XEngieSharkoSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 6195;
			}

			public float getSpeed() {
				return 80f;
			}

			public float getAttackDamageBonus() {
				return 5896f;
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
		}, 3, -1.1f, new Item.Properties().tab(EngiesChaosModTabs.TAB_ENGIES_CHAOS_ITEMS));
	}
}