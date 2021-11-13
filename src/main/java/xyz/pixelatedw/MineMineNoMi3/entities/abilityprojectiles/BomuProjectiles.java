package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class BomuProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {NoseFancyCannon.class, ListAttributes.NOSE_FANCY_CANNON});
	}
	
	public static class NoseFancyCannon extends AbilityProjectile
	{
		public NoseFancyCannon(World world)
		{super(world);}
		
		public NoseFancyCannon(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public NoseFancyCannon(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	
}
