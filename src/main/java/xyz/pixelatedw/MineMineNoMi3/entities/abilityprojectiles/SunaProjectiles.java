package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.KageProjectiles.BlackBox;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.KageProjectiles.BrickBat;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class SunaProjectiles 
{
	
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Barjan.class, ListAttributes.BARJAN});
	}
	
	public static class Barjan extends AbilityProjectile
	{
		public Barjan(World world)
		{super(world);}
		
		public Barjan(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Barjan(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	

}
