package xyz.pixelatedw.MineMineNoMi3.world.structures;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.world.MainWorldGen;

public class StructureCamp extends Structure
{
	
	public static boolean build(Schematic sch, World world, int posX, int posY, int posZ, BiomeGenBase biome)
	{
		boolean flagBiome = (biome != BiomeGenBase.savannaPlateau && biome != BiomeGenBase.plains && biome != BiomeGenBase.taiga && biome != BiomeGenBase.savanna && biome != BiomeGenBase.swampland 
				&& biome != BiomeGenBase.forest && biome != BiomeGenBase.birchForest && !biome.biomeName.equalsIgnoreCase(BiomeGenBase.plains.createMutation().biomeName));
		boolean flagSpecialCheck = !MainWorldGen.checkCorners(sch, world, posX, posY, posZ);
		boolean flagAboveGround = !MainWorldGen.checkCornersAboveGround(sch, world, posX, posY, posZ);

		if(flagBiome || flagSpecialCheck || flagAboveGround)
			return false;
		
		WySchematicHelper.build(sch, world, posX, posY - 7, posZ, Blocks.bedrock);
		populate(posX, posY, posZ, world, sch.getName());

		return true;
	}
	
	private static void populate(int posX, int posY, int posZ, World world, String faction)
	{
		String trash01;
		String trash02;
		String boss;
		if (faction.equals("marineCamp"))
		{
			trash01 = ID.PROJECT_ID + ".Marine with Sword";
			trash02 = ID.PROJECT_ID + ".Marine with Gun";
			boss = ID.PROJECT_ID + ".Marine Captain";
		}
		else
		{
			trash01 = ID.PROJECT_ID + ".Bandit with Sword";
			trash02 = ID.PROJECT_ID + ".Bandit with Sword";
			boss = ID.PROJECT_ID + ".Bandit with Sword";
		}

		// Spawners	
		TileEntityCustomSpawner spawnTrash01 = new TileEntityCustomSpawner().setSpawnerMob(trash01).setSpawnerLimit(2);
		TileEntityCustomSpawner spawnTrash02 = new TileEntityCustomSpawner().setSpawnerMob(trash01).setSpawnerLimit(2);
		TileEntityCustomSpawner spawnTrash03 = new TileEntityCustomSpawner().setSpawnerMob(trash01).setSpawnerLimit(2);
		TileEntityCustomSpawner spawnTrash04 = new TileEntityCustomSpawner().setSpawnerMob(trash02).setSpawnerLimit(2);
		TileEntityCustomSpawner spawnBoss = new TileEntityCustomSpawner().setSpawnerMob(boss).setSpawnerLimit(1);
		
		world.setBlock(posX + 7, posY + 2, posZ + 17, ListMisc.CustomSpawner);
		world.setTileEntity(posX + 7, posY + 2, posZ + 17, spawnTrash01);
		
		world.setBlock(posX + 7, posY + 2, posZ + 27, ListMisc.CustomSpawner);
		world.setTileEntity(posX + 7, posY + 2, posZ + 27, spawnTrash02);
		
		world.setBlock(posX + 27, posY + 2, posZ + 17, ListMisc.CustomSpawner);
		world.setTileEntity(posX + 27, posY + 2, posZ + 17, spawnTrash03);
		
		world.setBlock(posX + 27, posY + 2, posZ + 27, ListMisc.CustomSpawner);
		world.setTileEntity(posX + 27, posY + 2, posZ + 27, spawnTrash04);
		
		world.setBlock(posX + 17, posY + 2, posZ + 7, ListMisc.CustomSpawner);
		world.setTileEntity(posX + 17, posY + 2, posZ + 7, spawnBoss);
			
		// Chests		
		TileEntityChest smallTentChest01 = new TileEntityChest();
		world.setTileEntity(posX + 5, posY + 1, posZ + 17, smallTentChest01);

		TileEntityChest smallTentChest02 = new TileEntityChest();
		world.setTileEntity(posX + 5, posY + 1, posZ + 27, smallTentChest02);
		
		TileEntityChest smallTentChest03 = new TileEntityChest();
		world.setTileEntity(posX + 29, posY + 1, posZ + 17, smallTentChest03);
		
		TileEntityChest smallTentChest04 = new TileEntityChest();
		world.setTileEntity(posX + 29, posY + 1, posZ + 27, smallTentChest04);
		
		TileEntityChest[] smallTentChests = new TileEntityChest[] {smallTentChest01, smallTentChest02, smallTentChest03, smallTentChest04};	

		for(TileEntityChest chest : smallTentChests)
		{
			addChestLoot(world, chest, 100, ListMisc.Bullets, 5, 10);
			addChestLoot(world, chest, 90, Items.apple, 1, 3);
			addChestLoot(world, chest, 70, ListMisc.Bullets, 5, 10);
			addChestLoot(world, chest, 70, Items.cookie, 10, 20);
			addChestLoot(world, chest, 50, ListMisc.BellyPouch, 1, 0);
			addChestLoot(world, chest, 50, Items.gunpowder, 5, 10);
		}
		
		TileEntityChest largeTentChest = new TileEntityChest();
		world.setTileEntity(posX + 18, posY + 1, posZ + 4, largeTentChest);

		addChestLoot(world, largeTentChest, 90, ListMisc.KairosekiBullets, 1, 7);
		addChestLoot(world, largeTentChest, 70, Items.cooked_chicken, 2, 4);
		addChestLoot(world, largeTentChest, 70, Items.cooked_beef, 2, 4);
		addChestLoot(world, largeTentChest, 70, Items.gunpowder, 2, 5);
		addChestLoot(world, largeTentChest, 50, Item.getItemFromBlock(ListMisc.DenDenMushi), 0, 1);
		addChestLoot(world, largeTentChest, 50, ListMisc.Cola, 0, 2);
		addChestLoot(world, largeTentChest, 30, ListMisc.BellyPouch, 1, 2);
		addChestLoot(world, largeTentChest, 10, ListMisc.UltraCola, 0, 1);
		addChestLoot(world, largeTentChest, 30, ListMisc.Flintlock, 0, 1);
	}
}
