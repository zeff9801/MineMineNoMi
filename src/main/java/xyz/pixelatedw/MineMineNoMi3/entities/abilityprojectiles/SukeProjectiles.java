package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class SukeProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {ShishaNoTe.class, ListAttributes.SHISHA_NO_TE});
	}
	
	public static class ShishaNoTe extends AbilityProjectile
	{
		public ShishaNoTe(World world)
		{super(world);}
		
		public ShishaNoTe(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public ShishaNoTe(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	
}
