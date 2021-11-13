package xyz.pixelatedw.MineMineNoMi3.helpers.anvil;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.helpers.anvil.AnvilRecipe.AnvilRecipeType;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class AnvilRecipeHelper
{
	private static List<AnvilRecipe> recipes = new ArrayList<AnvilRecipe>();
	
	public static void init()
	{
		AnvilRecipe kairoseki = new AnvilRecipe(1, 10, AnvilRecipeType.SWORD, ListMisc.Kairoseki);
		
		recipes.add(kairoseki);
	}

	public static void checkForCrafting(AnvilRecipeType type, ItemStack material)
	{
		for(AnvilRecipe recipe : recipes)
		{
			
		}
	}
}
