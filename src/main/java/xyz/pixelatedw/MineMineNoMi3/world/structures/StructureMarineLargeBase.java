package xyz.pixelatedw.MineMineNoMi3.world.structures;

import java.util.function.Consumer;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.world.MainWorldGen;

public class StructureMarineLargeBase extends Structure
{
	public static boolean build(Schematic sch, World world, int posX, int posY, int posZ, BiomeGenBase biome)
	{		
		boolean flagBiome = (biome != BiomeGenBase.savannaPlateau && biome != BiomeGenBase.plains && biome != BiomeGenBase.taiga && biome != BiomeGenBase.savanna && biome != BiomeGenBase.swampland 
				&& biome != BiomeGenBase.forest && biome != BiomeGenBase.birchForest && biome != BiomeGenBase.icePlains && biome != BiomeGenBase.coldTaiga && biome != BiomeGenBase.forestHills);
		boolean flagSpecialCheck = !MainWorldGen.checkCorners(sch, world, posX, posY, posZ);
		boolean flagAboveGround = !MainWorldGen.checkCornersAboveGround(sch, world, posX, posY, posZ);
		
		if(flagBiome || flagSpecialCheck || flagAboveGround)
			return false;
		
		WySchematicHelper.build(sch, world, posX, posY - 19, posZ, Blocks.bedrock);
		populate(sch, posX, posY + 2, posZ, world);

		return true;
	}
	
	public static void populate(Schematic sch, int posX, int posY, int posZ, World world)
	{
		// Spawners
		int[][] trash01SpawnerPositions = new int[][]
		{
			{posX + 36, posY + 8, posZ + 30}, {posX + 19, posY + 8, posZ + 38}, {posX + 19, posY + 13, posZ + 38}, {posX + 37, posY + 13, posZ + 38}, {posX + 31, posY + 22, posZ + 25},
			{posX + 31, posY + 28, posZ + 32}
		};	
		addSpawnerTileEntity(world, trash01SpawnerPositions, "Marine with Sword", 5, 7);
		
		int[][] trash02SpawnerPositions = new int[][]
		{
			{posX + 37, posY + 13, posZ + 25}, {posX + 19, posY + 13, posZ + 20}, {posX + 21, posY + 28, posZ + 32}
		};
		addSpawnerTileEntity(world, trash02SpawnerPositions, "Marine with Gun", 3, 5);
	
		int[][] captainSpawnerPositions = new int[][]
		{
			{posX + 18, posY + 22, posZ + 20}, {posX + 18, posY + 22, posZ + 33}
		};
		addSpawnerTileEntity(world, captainSpawnerPositions, "Marine Captain", 1, 2);

		int[][] prisonPirateTrash01SpawnerPositions = new int[][]
		{
			{posX + 31, posY - 8, posZ + 42}, {posX + 18, posY - 19, posZ + 42}, {posX + 31, posY - 8, posZ + 18}, {posX + 19, posY - 12, posZ + 18}, 
		};
		addSpawnerTileEntity(world, prisonPirateTrash01SpawnerPositions, "Pirate with Sword", 3, 5);

		int[][] prisonBanditTrash01SpawnerPositions = new int[][]
		{
			{posX + 19, posY - 12, posZ + 42}, {posX + 34, posY - 12, posZ + 18}, {posX + 19, posY - 19, posZ + 18}
		};
		addSpawnerTileEntity(world, prisonBanditTrash01SpawnerPositions, "Bandit with Sword", 3, 5);

		// Chests
		int[][] foodChestPositions = new int[][]
		{
			{posX + 41, posY + 10, posZ + 37}, {posX + 41, posY + 10, posZ + 36}, {posX + 41, posY + 8, posZ + 37}, {posX + 41, posY + 8, posZ + 36}, {posX + 40, posY + 10, posZ + 40},
			{posX + 39, posY + 10, posZ + 40}, {posX + 40, posY + 8, posZ + 40}, {posX + 39, posY + 8, posZ + 40}
		};

		Consumer<TileEntityChest> foodChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 100, Items.apple, 5, 10);
			addChestLoot(world, chest, 90, Items.pumpkin_pie, 1, 3);
			addChestLoot(world, chest, 90, Items.mushroom_stew, 3, 7);
			addChestLoot(world, chest, 50, Items.cooked_beef, 1, 5);
			addChestLoot(world, chest, 50, Items.cooked_chicken, 1, 5);
			addChestLoot(world, chest, 50, Items.cooked_porkchop, 1, 5);
			addChestLoot(world, chest, 50, Items.cookie, 5, 10);
			addChestLoot(world, chest, 30, ListMisc.Cola, 2, 5);
			addChestLoot(world, chest, 10, ListMisc.UltraCola, 0, 2);
			addChestLoot(world, chest, 10, ListMisc.SeaKingMeat, 0, 2);
			addChestLoot(world, chest, 10, Items.cake, 1, 0);
			addChestLoot(world, chest, 5, ListMisc.UltraCola, 1, 2);
		};
		
		addChestTileEntity(world, foodChestPositions, 2, foodChestLoot);
		
		int[][] generalChestPositions = new int[][]
		{
			{posX + 37, posY + 19, posZ + 41}, {posX + 35, posY + 19, posZ + 41}, {posX + 39, posY + 19, posZ + 37}, {posX + 39, posY + 19, posZ + 35}, {posX + 39, posY + 19, posZ + 33},
			{posX + 39, posY + 19, posZ + 29}, {posX + 39, posY + 19, posZ + 27}, {posX + 39, posY + 19, posZ + 25}, {posX + 39, posY + 19, posZ + 23}, {posX + 37, posY + 19, posZ + 19},
			{posX + 35, posY + 19, posZ + 19}, {posX + 22, posY + 19, posZ + 32}, {posX + 20, posY + 19, posZ + 32}, {posX + 18, posY + 19, posZ + 32}, {posX + 16, posY + 19, posZ + 32},
			{posX + 14, posY + 19, posZ + 32}, {posX + 13, posY + 19, posZ + 33}, {posX + 13, posY + 19, posZ + 35}, {posX + 13, posY + 19, posZ + 35}, {posX + 13, posY + 19, posZ + 37}
		};
	
		Consumer<TileEntityChest> generalChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 50, ListMisc.Bullets, 5, 10);
			addChestLoot(world, chest, 50, ListMisc.Bullets, 5, 10);
			addChestLoot(world, chest, 40, ListMisc.BellyPouch, 2, 4);
			addChestLoot(world, chest, 30, Items.gunpowder, 5, 10);
			addChestLoot(world, chest, 30, ListMisc.BellyPouch, 1, 2);
			addChestLoot(world, chest, 20, ListMisc.Bullets, 10, 20);
			addChestLoot(world, chest, 20, ListMisc.KairosekiBullets, 5, 10);
			addChestLoot(world, chest, 20, ListMisc.KairosekiBullets, 2, 5);
			addChestLoot(world, chest, 20, ListMisc.Kairoseki, 7, 10);
			addChestLoot(world, chest, 20, Items.gold_ingot, 5, 7);
			addChestLoot(world, chest, 15, ListMisc.DialFire, 5, 7);
			addChestLoot(world, chest, 15, ListMisc.DialAxe, 2, 5);
			addChestLoot(world, chest, 15, ListMisc.DialEisen, 5, 10);
			addChestLoot(world, chest, 15, ListMisc.DialImpact, 2, 5);
			addChestLoot(world, chest, 15, ListMisc.DialMilky, 5, 10);
			addChestLoot(world, chest, 15, ListMisc.DialBreath, 2, 10);
			addChestLoot(world, chest, 15, ListMisc.DialFlash, 5, 7);
			addChestLoot(world, chest, 15, Items.iron_ingot, 5, 7);
			addChestLoot(world, chest, 15, Items.diamond, 1, 3);
			addChestLoot(world, chest, 15, ListMisc.BlackMetal, 3, 5);
			addChestLoot(world, chest, 10, Item.getItemFromBlock(ListMisc.DenDenMushi), 1, 0);
			addChestLoot(world, chest, 5, Items.diamond, 0, 5);
			addChestLoot(world, chest, 5, ListMisc.BlackMetal, 0, 5);
		};
		
		addChestTileEntity(world, generalChestPositions, 7, generalChestLoot);
		
		int[][] specialChestPositions = new int[][]
		{
			{posX + 20, posY + 18, posZ + 29}, {posX + 19, posY + 18, posZ + 29}
		};
		
		Consumer<TileEntityChest> specialChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 40, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(getEnchantment(), 2)));
			addChestLoot(world, chest, 40, ListMisc.Kairoseki, 10, 20);
			addChestLoot(world, chest, 40, Items.gold_ingot, 10, 15);
			addChestLoot(world, chest, 35, Items.iron_ingot, 5, 10);
			addChestLoot(world, chest, 35, Items.diamond, 2, 5);
			addChestLoot(world, chest, 30, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(getEnchantment(), 2)));
			addChestLoot(world, chest, 25, ListMisc.BlackMetal, 5, 7);
			addChestLoot(world, chest, 20, ListMisc.Kairoseki, 15, 20);
			addChestLoot(world, chest, 20, Items.gold_ingot, 10, 15);
			addChestLoot(world, chest, 20, Items.iron_ingot, 7, 12);
			addChestLoot(world, chest, 10, Items.diamond, 5, 6);
			addChestLoot(world, chest, 10, ListMisc.BlackMetal, 6, 8);
			addChestLoot(world, chest, 10, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(getEnchantment(), 3)));
		};
		
		addChestTileEntity(world, specialChestPositions, 0, specialChestLoot);
		
		int[][] captainChestPositions = new int[][]
		{
			{posX + 22, posY + 22, posZ + 37}, {posX + 15, posY + 22, posZ + 21}
		};
		
		Consumer<TileEntityChest> captainChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 50, Items.compass, 1, 0);
			addChestLoot(world, chest, 40, ListMisc.Cola, 1, 5);
			addChestLoot(world, chest, 40, Items.map, 1, 0);
			addChestLoot(world, chest, 30, ListMisc.BellyPouch, 1, 2);
			addChestLoot(world, chest, 20, Items.diamond, 0, 5);
			addChestLoot(world, chest, 20, ListMisc.Flintlock, 1, 0);
			addChestLoot(world, chest, 20, ListMisc.UltraCola, 1, 0);
			addChestLoot(world, chest, 20, ListMisc.BlackMetal, 1, 5);
			addChestLoot(world, chest, 15, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(getEnchantment(), 2)));
			addChestLoot(world, chest, 10, Items.diamond, 3, 7);
			addChestLoot(world, chest, 10, ListMisc.Box1, 1, 0);
			addChestLoot(world, chest, 5, ListMisc.Box2, 1, 0);
		};
		
		addChestTileEntity(world, captainChestPositions, 0, captainChestLoot);
		
		int[][] commodoreChestPositions = new int[][]
		{
			{posX + 23, posY + 36, posZ + 24}, {posX + 29, posY + 36, posZ + 24}, {posX + 22, posY + 47, posZ + 26}
		};
		
		Consumer<TileEntityChest> commodoreChestLoot = (chest) -> 
		{
			addChestLoot(world, chest, 40, Items.clock, 1, 0);
			addChestLoot(world, chest, 40, Items.map, 1, 0);
			addChestLoot(world, chest, 30, ListMisc.UltraCola, 1, 0);
			addChestLoot(world, chest, 20, ListMisc.Box1, 1, 0);
			addChestLoot(world, chest, 10, ListMisc.Box2, 1, 0);
			addChestLoot(world, chest, 10, ListMisc.UltraCola, 1, 0);
			addChestLoot(world, chest, 10, ListMisc.Box3, 1, 0);
		};
		
		addChestTileEntity(world, commodoreChestPositions, 0, commodoreChestLoot);
	}
	
	
}
