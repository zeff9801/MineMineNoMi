package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class ItoProjectiles 
{
	
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Tamaito.class, ListAttributes.TAMAITO});
		abilitiesClassesArray.add(new Object[] {Overheat.class, ListAttributes.OVERHEAT});
	}
	
	public static class Tamaito extends AbilityProjectile
	{
		public Tamaito(World world)
		{super(world);}
		
		public Tamaito(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Tamaito(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
	public static class Overheat extends AbilityProjectile
	{
		public Overheat(World world)
		{super(world);}
		
		public Overheat(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Overheat(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	

}
