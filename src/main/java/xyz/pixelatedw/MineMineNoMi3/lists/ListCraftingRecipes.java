package xyz.pixelatedw.MineMineNoMi3.lists;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ListCraftingRecipes 
{
	
	public static void init()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.SakeCup, 1), new Object[]
				{ "...", "X.X", ".X.", 'X', Items.clay_ball });
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Cannon, 1), new Object[]
				{ "...", "XXX", ".YY", 'X', Blocks.iron_block, 'Y', Blocks.planks });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[]
				{ "...", ".XX", ".XX", 'X', Items.iron_ingot });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[]
				{ ".XX", ".XX", "...", 'X', Items.iron_ingot });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[]
				{ "XX.", "XX.", "...", 'X', Items.iron_ingot });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[]
				{ "...", "XX.", "XX.", 'X', Items.iron_ingot });

		GameRegistry.addShapelessRecipe(new ItemStack(ListMisc.VivreCard, 1), Items.paper);
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.MedicBag, 1), new Object[]
				{ "Y.Y", "XZX", "XXX", 'X', Items.leather, 'Y', Items.string, 'Z', new ItemStack(Items.dye, 1, 4) });
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.ClimaTact, 1), new Object[]
				{ "YXY", "YXY", "YXY", 'X', Items.stick, 'Y', new ItemStack(Items.dye, 1, 4) });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.PerfectClimaTact, 1), new Object[]
				{ "EME", "BXI", "EFE", 'X', ListMisc.ClimaTact, 'E', ListMisc.DialEisen, 'F', ListMisc.DialFlash, 'I', ListMisc.DialFire, 'B', ListMisc.DialBreath, 'M', ListMisc.DialMilky });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Mace, 1), new Object[]
				{ ".X.", ".X.", ".Y.", 'X', Blocks.iron_block, 'Y', Items.iron_ingot });
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBars, 16), new Object[]
				{ "...", "XXX", "XXX", 'X', ListMisc.DenseKairoseki });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBars, 16), new Object[]
				{ "XXX", "XXX", "...", 'X', ListMisc.DenseKairoseki });
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Umbrella), new Object[]
				{ "OOO", ".X.", ".X.", 'X', Items.stick, 'O', Blocks.wool });	
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Scissors), new Object[]
				{ ".OO", "XOO", "XX.", 'X', Blocks.cobblestone, 'O', Items.iron_ingot });	
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.ColaBackpack), new Object[]
				{ "X.X", "XOX", "X.X", 'X', ListMisc.UltraCola, 'O', Items.iron_ingot });	
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Key), new Object[]
				{ ".X.", ".X.", ".X.", 'X', Items.gold_ingot });	
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Cola), new Object[]
				{ ".O.", ".O.", ".X.", 'O', Items.sugar, 'X', Items.glass_bottle });
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.UltraCola), new Object[]
				{ "OOO", "OOO", "OXO", 'O', Items.sugar, 'X', ListMisc.Cola });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ListMisc.Kairoseki, 9), ListMisc.KairosekiBlock);
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBlock), new Object[]
				{ "XXX", "XXX", "XXX", 'X', ListMisc.Kairoseki });
		
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ "#$.", "$#.", "...", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ "$#.", "#$.", "...", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ ".$#", ".#$", "...", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ ".#$", ".$#", "...", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ "...", "$#.", "#$.", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ "...", "#$.", "$#.", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ "...", ".#$", ".$#", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });  
	    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] 
	    		{ "...", ".$#", ".#$", '#', ListMisc.Kairoseki, '$', Items.iron_ingot });
	    
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.BlackMetal), new Object[]
				{ "...", "XXX", "XXX", 'X', ListMisc.DenseKairoseki });		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.BlackMetal), new Object[]
				{ "XXX", "XXX", "...", 'X', ListMisc.DenseKairoseki });	
		
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[]
				{ "XX.", "XX.", "...", 'X', Items.iron_ingot });	
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[]
				{ "...", "XX.", "XX.", 'X', Items.iron_ingot });	
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[]
				{ ".XX", ".XX", "...", 'X', Items.iron_ingot });	
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[]
				{ "...", ".XX", ".XX", 'X', Items.iron_ingot });	
	    
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[]
				{ "XX.", "XX.", "...", 'X', ListMisc.DenseKairoseki });	
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[]
				{ "...", "XX.", "XX.", 'X', ListMisc.DenseKairoseki });	
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[]
				{ ".XX", ".XX", "...", 'X', ListMisc.DenseKairoseki });	
		GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[]
				{ "...", ".XX", ".XX", 'X', ListMisc.DenseKairoseki });	
	}

}
