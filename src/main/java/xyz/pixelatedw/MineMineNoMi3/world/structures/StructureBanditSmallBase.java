package xyz.pixelatedw.MineMineNoMi3.world.structures;

import java.util.function.Consumer;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.world.MainWorldGen;

public class StructureBanditSmallBase extends Structure
{

	public static boolean build(Schematic sch, World world, int posX, int posY, int posZ, BiomeGenBase biome)
	{		
		boolean flagBiome = (biome != BiomeGenBase.savannaPlateau && biome != BiomeGenBase.plains && biome != BiomeGenBase.taiga && biome != BiomeGenBase.savanna && biome != BiomeGenBase.swampland 
				&& biome != BiomeGenBase.forest && biome != BiomeGenBase.birchForest && biome != BiomeGenBase.icePlains && biome != BiomeGenBase.coldTaiga && biome != BiomeGenBase.forestHills);
		boolean flagSpecialCheck = !MainWorldGen.checkCorners(sch, world, posX, posY, posZ);
		boolean flagAboveGround = !MainWorldGen.checkCornersAboveGround(sch, world, posX, posY, posZ);

		if(flagBiome || flagSpecialCheck || flagAboveGround)
			return false;
		
		WySchematicHelper.build(sch, world, posX, posY - 33, posZ, Blocks.bedrock);
		populate(sch, posX, posY, posZ, world);

		return true;
	}
	
	private static void populate(Schematic sch, int posX, int posY, int posZ, World world)
	{
		// Spawners
		int[][] banditsSpawnerPositions = new int[][]
		{
			{posX + 21, posY - 22, posZ + 16}, {posX + 25, posY - 25, posZ + 6}
		};	
		addSpawnerTileEntity(world, banditsSpawnerPositions, "Bandit with Sword", 7, 12);
		
		// Chests
		int[][] mineChestPositions = new int[][]
		{
			{posX + 10, posY - 26, posZ + 6}, {posX + 10, posY - 26, posZ + 5}, {posX + 12, posY - 26, posZ + 3}, {posX + 13, posY - 26, posZ + 3}, {posX + 4, posY - 28, posZ + 15}
		};
		
		Consumer<TileEntityChest> mineChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 70, Items.iron_ingot, 5, 10);
			addChestLoot(world, chest, 70, new ItemStack(Items.dye, (int) WyMathHelper.randomWithRange(2, 7), 4));
			addChestLoot(world, chest, 60, Items.iron_pickaxe, 1, 0);
			addChestLoot(world, chest, 60, Items.gold_ingot, 2, 5);
			addChestLoot(world, chest, 60, ListMisc.Kairoseki, 5, 10);
			addChestLoot(world, chest, 40, Items.emerald, 0, 5);
			addChestLoot(world, chest, 20, Items.iron_ingot, 7, 10);
			addChestLoot(world, chest, 20, Items.emerald, 3, 7);
			addChestLoot(world, chest, 20, Items.diamond_pickaxe, 1, 0);
			addChestLoot(world, chest, 20, ListMisc.Kairoseki, 5, 10);
			addChestLoot(world, chest, 10, Items.diamond, 2, 5);
			addChestLoot(world, chest, 10, Items.diamond, 3, 4);
			
		};
		
		addChestTileEntity(world, mineChestPositions, 2, mineChestLoot);
		
		int[][] alchemyChestPositions = new int[][]
		{
			{posX + 6, posY - 22, posZ + 9}
		};

		Consumer<TileEntityChest> alchemyChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 100, Item.getItemFromBlock(Blocks.lever), 1, 0);
			addChestLoot(world, chest, 50, Items.glowstone_dust, 2, 15);
			addChestLoot(world, chest, 50, ListMisc.Kairoseki, 2, 7);
			addChestLoot(world, chest, 40, Items.redstone, 5, 7);
			addChestLoot(world, chest, 40, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(getEnchantment(), 2)));
			addChestLoot(world, chest, 30, Items.redstone, 7, 10);
			addChestLoot(world, chest, 30, Items.blaze_powder, 2, 5);
			addChestLoot(world, chest, 20, ListMisc.BlackMetal, 5, 8);
			addChestLoot(world, chest, 20, Items.glowstone_dust, 5, 7);
			addChestLoot(world, chest, 10, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(getEnchantment(), 3)));
			addChestLoot(world, chest, 10, ListMisc.BlackMetal, 2, 7);
			
		};
		
		addChestTileEntity(world, alchemyChestPositions, 0, alchemyChestLoot);

		int[][] treasureChestPositions = new int[][]
		{
			{posX + 7, posY - 26, posZ + 22}, {posX + 6, posY - 26, posZ + 22}, {posX + 5, posY - 26, posZ + 23}, {posX + 5, posY - 26, posZ + 24}, {posX + 5, posY - 25, posZ + 32},
			{posX + 7, posY - 25, posZ + 34}
		};

		Consumer<TileEntityChest> treasureChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 60, Item.getItemFromBlock(Blocks.gold_block), 0, 2);
			addChestLoot(world, chest, 50, ListMisc.BellyPouch, 1, 2);
			addChestLoot(world, chest, 20, ListMisc.BellyPouch, 3, 5);
			addChestLoot(world, chest, 20, Item.getItemFromBlock(Blocks.gold_block), 3, 7);
			addChestLoot(world, chest, 5, Item.getItemFromBlock(Blocks.gold_block), 1, 3);
			addChestLoot(world, chest, 5, ListMisc.Box1, 1, 0);
			addChestLoot(world, chest, 2, ListMisc.Box2, 1, 0);
		};
		
		addChestTileEntity(world, treasureChestPositions, 3, treasureChestLoot);		
	}
	
}
