package xyz.pixelatedw.MineMineNoMi3.world.structures;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.world.MainWorldGen;

public class StructureLargeShip extends Structure
{
	public static boolean build(Schematic sch, World world, int posX, int posY, int posZ, BiomeGenBase biome)
	{
		boolean flagBiome = (biome != BiomeGenBase.ocean && biome != BiomeGenBase.deepOcean);
		boolean flagSpecialCheck = !MainWorldGen.checkForWaterSpawn(sch, world, posX, posY, posZ);
		
		if( flagBiome || flagSpecialCheck )
			return false;	
		
		WySchematicHelper.build(sch, world, posX, posY, posZ);
		populate(posX, posY, posZ, world, sch.getName());

		return true;
	}
	
	public static void populate(int posX, int posY, int posZ, World world, String faction)
	{
		Item swordToSpawn;
		String trashWithSword;
		String trashWithGun;
		String boss;
		
		if(faction.equals("marineLargeShip"))
		{
			trashWithSword = "Marine with Sword";
			trashWithGun = "Marine with Gun";
			boss = "Marine Captain";
			swordToSpawn = ListMisc.MarineSword;
		}
		else
		{
			trashWithSword = "Pirate with Sword";
			trashWithGun = "Pirate with Gun";	
			boss = "Pirate Captain";
			swordToSpawn = ListMisc.PirateCutlass;
		}
		
		// Spawners
		int[][] trash01SpawnerPositions = new int[][]
		{
			{posX + 10, posY + 6, posZ + 27}, {posX + 10, posY + 12, posZ + 13}, {posX + 8, posY + 12, posZ + 42}
		};	
		addSpawnerTileEntity(world, trash01SpawnerPositions, trashWithSword, 4, 6);
		
		int[][] trash02SpawnerPositions = new int[][]
		{
			{posX + 10, posY + 6, posZ + 20}, {posX + 10, posY + 12, posZ + 10}
		};	
		addSpawnerTileEntity(world, trash02SpawnerPositions, trashWithGun, 3, 5);
		
		int[][] bossSpawnerPositions = new int[][]
		{
			{posX + 12, posY + 12, posZ + 42}
		};	
		addSpawnerTileEntity(world, bossSpawnerPositions, boss, 1, 0);
		
		// Chests		
		TileEntityChest combatChest = new TileEntityChest();
		world.setTileEntity(posX + 6, posY + 6, posZ + 39, combatChest);
		
		addChestLoot(world, combatChest, 100, ListMisc.Bullets, 5, 10);
		addChestLoot(world, combatChest, 100, ListMisc.Bullets, 10, 15);
		addChestLoot(world, combatChest, 80, Items.boat, 1, 0);
		addChestLoot(world, combatChest, 80, ListMisc.BellyPouch, 2, 6);
		addChestLoot(world, combatChest, 50, ListMisc.BellyPouch, 6, 10);
		addChestLoot(world, combatChest, 50, ListMisc.KairosekiBullets, 3, 5);
		addChestLoot(world, combatChest, 45, swordToSpawn, 0, 1);
		addChestLoot(world, combatChest, 45, ListMisc.Flintlock, 0, 1);
		addChestLoot(world, combatChest, 20, ListMisc.BellyPouch, 1, 0);
		addChestLoot(world, combatChest, 10, ListMisc.Box1, 1, 0);

		TileEntityChest foodChest = new TileEntityChest();
		world.setTileEntity(posX + 13, posY + 6, posZ + 39, foodChest);
		
		addChestLoot(world, foodChest, 100, Items.bread, 1, 3);
		addChestLoot(world, foodChest, 100, Items.bread, 1, 2);
		if(getRandomChance(world) <= 10)
			addChestLoot(world, foodChest, 45, Items.melon, 5, 10);
		addChestLoot(world, foodChest, 45, Items.baked_potato, 0, 5);
		addChestLoot(world, foodChest, 45, Items.apple, 1, 10);
		if(getRandomChance(world) <= 70)
			addChestLoot(world, foodChest, 45, Items.melon, 5, 10);
		addChestLoot(world, foodChest, 20, ListMisc.Cola, 0, 3);
		if(getRandomChance(world) <= 50)
		{
			addChestLoot(world, foodChest, 10, Items.cooked_chicken, 0, 2);
			if(getRandomChance(world) <= 50)
				addChestLoot(world, foodChest, 10, Items.cooked_fished, 1, 4);
			else
				addChestLoot(world, foodChest, 10, Items.cooked_fished, 1, 1, 4);
		}
		else
			addChestLoot(world, foodChest, 10, Items.cooked_chicken, 1, 2);
		addChestLoot(world, foodChest, 10, ListMisc.Cola, 0, 5);

		TileEntityChest specialChest = new TileEntityChest();
		world.setTileEntity(posX + 9, posY + 6, posZ + 42, specialChest);

		addChestLoot(world, specialChest, 75, ListMisc.BellyPouch, 1, 6);
		addChestLoot(world, specialChest, 70, ListMisc.KairosekiBullets, 5, 10);
		addChestLoot(world, specialChest, 65, ListMisc.BellyPouch, 3, 8);
		addChestLoot(world, specialChest, 50, Items.boat, 1, 0);
		addChestLoot(world, specialChest, 35, ListMisc.BellyPouch, 5, 6);
		addChestLoot(world, specialChest, 35, ListMisc.BlackMetal, 1, 2);
		addChestLoot(world, specialChest, 20, ListMisc.Box1, 1, 0);
		addChestLoot(world, specialChest, 20, ListMisc.UltraCola, 1, 0);
		addChestLoot(world, specialChest, 15, ListMisc.Box2, 1, 0);
		addChestLoot(world, specialChest, 10, ListMisc.Box3, 1, 0);
		
	}
}
