package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class ZouProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {TrunkShot.class, ListAttributes.TRUNK_SHOT});
	}
	
	public static class TrunkShot extends AbilityProjectile
	{
		public TrunkShot(World world)
		{super(world);}
		
		public TrunkShot(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public TrunkShot(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}		
	}
}
