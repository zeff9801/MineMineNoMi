package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class SupaProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {SpiralHollow.class, ListAttributes.SPIRAL_HOLLOW});
	}
	
	public static class SpiralHollow extends AbilityProjectile
	{
		public SpiralHollow(World world)
		{super(world);}
		
		public SpiralHollow(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public SpiralHollow(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
}
