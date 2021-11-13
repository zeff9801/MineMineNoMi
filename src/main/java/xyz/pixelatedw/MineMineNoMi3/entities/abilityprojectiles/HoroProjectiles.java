package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class HoroProjectiles 
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {NegativeHollow.class, ListAttributes.NEGATIVE_HOLLOW});
		abilitiesClassesArray.add(new Object[] {MiniHollow.class, ListAttributes.MINI_HOLLOW});
		abilitiesClassesArray.add(new Object[] {TokuHollow.class, ListAttributes.TOKU_HOLLOW});
	}
	
	public static class TokuHollow extends AbilityProjectile
	{
		public TokuHollow(World world)
		{super(world);}
		
		public TokuHollow(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public TokuHollow(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class MiniHollow extends AbilityProjectile
	{
		public MiniHollow(World world)
		{super(world);}
		
		public MiniHollow(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public MiniHollow(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class NegativeHollow extends AbilityProjectile
	{
		public NegativeHollow(World world)
		{super(world);}
		
		public NegativeHollow(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public NegativeHollow(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	

}
