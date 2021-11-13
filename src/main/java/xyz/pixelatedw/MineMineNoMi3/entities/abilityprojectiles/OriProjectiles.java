package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

import java.util.ArrayList;

public class OriProjectiles
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();

	static
	{
		abilitiesClassesArray.add(new Object[] { AwaseBaori.class, ListAttributes.AWASE_BAORI });
	}

	public static class AwaseBaori extends AbilityProjectile
	{
		public AwaseBaori(World world)
		{
			super(world);
		}

		public AwaseBaori(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public AwaseBaori(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		public void tasksImapct(MovingObjectPosition hit)
		{
			if (MainConfig.enableGriefing)
			{
				if (hit.entityHit != null)
				{
					WyHelper.createEmptyCube(hit.entityHit, new int[]
					{
							2, 3, 2
					}, ListMisc.OriBars, "air", "foliage", "liquid");
				}
			}
		}
	}
}
