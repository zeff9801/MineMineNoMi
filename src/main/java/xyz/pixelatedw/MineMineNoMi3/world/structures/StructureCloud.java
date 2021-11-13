package xyz.pixelatedw.MineMineNoMi3.world.structures;

import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class StructureCloud extends Structure
{
	public static boolean build(World world, int posX, int posY, int posZ)
	{
		boolean flagHeight = posY >= 90;

		if(!flagHeight)
			return false;

		for(int i = -5; i < 5; i++)
		for(int j = -2; j < 2; j++)
		for(int k = -5; k < 5; k++)
		{
			int newPosX = (int) (posX + i + (i < -WyMathHelper.randomWithRange(3, 5) || i > WyMathHelper.randomWithRange(3, 5) ? WyMathHelper.randomWithRange(-5, 5) : 0));
			int newPosY = posY + j;
			int newPosZ = (int) (posZ + k + (k < -WyMathHelper.randomWithRange(3, 5) || k > WyMathHelper.randomWithRange(3, 5) ? WyMathHelper.randomWithRange(-5, 5) : 0));
				
			DevilFruitsHelper.placeBlockIfAllowed(world, newPosX, newPosY, newPosZ, ListMisc.SkyBlock, "air");			
		}
		
		WyTelemetry.addStructureStat("sky_island", "Sky Island", 1);

		return true;
	}
}
