package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class BaneProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {SpringDeathKnock.class, ListAttributes.SPRING_DEATH_KNOCK});
	}
	
	public static class SpringDeathKnock extends AbilityProjectile
	{
		public SpringDeathKnock(World world)
		{super(world);}
		
		public SpringDeathKnock(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public SpringDeathKnock(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	
}
