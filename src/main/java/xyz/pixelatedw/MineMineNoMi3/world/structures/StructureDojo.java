package xyz.pixelatedw.MineMineNoMi3.world.structures;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.world.MainWorldGen;

public class StructureDojo extends Structure
{
	public static boolean build(Schematic sch, World world, int posX, int posY, int posZ, BiomeGenBase biome)
	{
		ExtendedWorldData worldData = ExtendedWorldData.get(world);
		
		boolean flagBiome = (biome != BiomeGenBase.beach && biome != BiomeGenBase.plains && biome != BiomeGenBase.desert && biome != BiomeGenBase.savanna && biome != BiomeGenBase.icePlains 
				&& biome != BiomeGenBase.swampland && biome != BiomeGenBase.taiga && !biome.biomeName.equalsIgnoreCase(BiomeGenBase.plains.createMutation().biomeName));
		boolean flagSpecialCheck = !MainWorldGen.checkCorners(sch, world, posX, posY, posZ, 2);
		boolean flagMaxSpawned = worldData.getTotalDojosSpawned() > MainConfig.maxDojoSpawn;
		boolean flagAboveGround = !MainWorldGen.checkCornersAboveGround(sch, world, posX, posY, posZ);

		if(flagBiome || flagSpecialCheck || flagMaxSpawned || flagAboveGround)
			return false;
		
		WySchematicHelper.build(sch, world, posX, posY, posZ);
		populate(posX, posY + 1, posZ, world);

		worldData.countUpDojoSpawned();
		
		return true;
	}
	
	private static void populate(int posX, int posY, int posZ, World world)
	{			
		TileEntityCustomSpawner spawnDojoMaster = new TileEntityCustomSpawner().setSpawnerMob(ID.PROJECT_ID + ".Dojo Sensei").setSpawnerLimit(1);
		
		world.setBlock(posX + 5, posY + 2, posZ + 11, ListMisc.CustomSpawner);
		world.setTileEntity(posX + 5, posY + 2, posZ + 11, spawnDojoMaster);
	}
}
