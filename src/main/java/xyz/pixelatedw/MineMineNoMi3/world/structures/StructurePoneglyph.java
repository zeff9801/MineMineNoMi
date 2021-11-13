package xyz.pixelatedw.MineMineNoMi3.world.structures;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class StructurePoneglyph extends Structure
{
	private static Block[] poneglyphBlocks = new Block[] {ListMisc.Poneglyph1, ListMisc.Poneglyph2, ListMisc.Poneglyph3};
	public static boolean build(World world, int posX, int posY, int posZ)
	{
		boolean flagHeight = posY < 60;
		
		if(!flagHeight)
			return false;

		for(int i = -1; i < 2; i++)
		for(int j = -1; j < 2; j++)
		for(int k = -1; k < 2; k++)
		{
			int newPosX = posX + i;
			int newPosY = posY + j;
			int newPosZ = posZ + k;
			
			Block poneglyphBlock = poneglyphBlocks[world.rand.nextInt(poneglyphBlocks.length - 1)];	
			
			DevilFruitsHelper.placeBlockIfAllowed(world, newPosX, newPosY, newPosZ, poneglyphBlock, "core", "foliage", "ores", "air");			
		}
		
		return true;
	}
	
	private static boolean checkCornersUnderGround(World world, int posX, int posY, int posZ, int width, int length)
	{
		boolean corner1 = false, corner2 = false, corner3 = false, corner4 = false;
		for(int i = 0; i < 3; i++)
		{
			if(!corner1)
				corner1 = world.getBlock(posX, posY + i, posZ) == Blocks.air && world.canBlockSeeTheSky(posX, posY + i, posZ);
			if(!corner2)
				corner2 = world.getBlock(posX + width, posY + i, posZ) == Blocks.air && world.canBlockSeeTheSky(posX + width, posY + i, posZ);
			if(!corner3)
				corner3 = world.getBlock(posX, posY + i, posZ + length) == Blocks.air && world.canBlockSeeTheSky(posX, posY + i, posZ + length);
			if(!corner4)
				corner4 = world.getBlock(posX + width, posY + i, posZ + length) == Blocks.air && world.canBlockSeeTheSky(posX + width, posY + i, posZ + length);		

			if((corner1?1:0) + (corner2?1:0) + (corner3?1:0) + (corner4?1:0) >= 3)
			{
				return true;
			}
		}

		return false;
	}
}
