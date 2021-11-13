package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class PikaProjectiles 
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Amaterasu.class, ListAttributes.AMATERASU});
		abilitiesClassesArray.add(new Object[] {YasakaniNoMagatama.class, ListAttributes.YASAKANI_NO_MAGATAMA});
	}
	
	public static class YasakaniNoMagatama extends AbilityProjectile
	{
		public YasakaniNoMagatama(World world)
		{super(world);}
		
		public YasakaniNoMagatama(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public YasakaniNoMagatama(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
	public static class Amaterasu extends AbilityProjectile
	{
		public Amaterasu(World world)
		{super(world);}
		
		public Amaterasu(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Amaterasu(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
}
