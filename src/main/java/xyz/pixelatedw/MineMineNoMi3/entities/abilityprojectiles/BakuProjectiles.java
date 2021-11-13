package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BaneProjectiles.SpringDeathKnock;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class BakuProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {BeroCannon.class, ListAttributes.BERO_CANNON});
		abilitiesClassesArray.add(new Object[] {BakuTsuiho.class, ListAttributes.BAKU_TSUIHO});
	}
	
	public static class BakuTsuiho extends AbilityProjectile
	{
		public BakuTsuiho(World world)
		{super(world);}
		
		public BakuTsuiho(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BakuTsuiho(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class BeroCannon extends AbilityProjectile
	{
		public BeroCannon(World world)
		{super(world);}
		
		public BeroCannon(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BeroCannon(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
}
