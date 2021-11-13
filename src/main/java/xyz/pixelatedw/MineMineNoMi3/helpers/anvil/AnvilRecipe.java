package xyz.pixelatedw.MineMineNoMi3.helpers.anvil;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AnvilRecipe
{
	private int cost = 1;
	private int materialCost = 1;
	private int maxLevel = 1;
	private AnvilRecipeType type = AnvilRecipeType.SWORD;
	private Item rightSlot = null;
	private ItemStack result = null;
	
	private Enchantment enchantmentBonus = null;
	
	public AnvilRecipe(int cost, int materialCost, AnvilRecipeType type, Item materialItem)
	{
		this.cost = cost;
		this.materialCost = materialCost;
		this.type = type;
		this.rightSlot = materialItem;
	}
	
	public ItemStack craft(Item i, ItemStack actualRightSlot)
	{
		if(actualRightSlot.getItem() != this.rightSlot)
			return null;
		
		ItemStack is = new ItemStack(i);
		
		if(enchantmentBonus != null)
		{
			int level = actualRightSlot.stackSize / 3;
			
			if(level > 3)
				level = 3;
			
			is.addEnchantment(enchantmentBonus, 1);
		}
		
		return is;
	}
	
	public void setEnchantment(Enchantment bonus)
	{
		this.enchantmentBonus = bonus;
	}
	
	public enum AnvilRecipeType
	{
		SWORD, BOW
	}
}
