package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectDoruLock;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class DoruProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {DoruDoruArtsMori.class, ListAttributes.DORU_DORU_ARTS_MORI});
		abilitiesClassesArray.add(new Object[] {CandleLock.class, ListAttributes.CANDLE_LOCK});
	}
	
	public static class DoruDoruArtsMori extends AbilityProjectile
	{
		public DoruDoruArtsMori(World world)
		{super(world);}
		
		public DoruDoruArtsMori(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public DoruDoruArtsMori(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
	public static class CandleLock extends AbilityProjectile
	{
		public CandleLock(World world)
		{super(world);}
		
		public CandleLock(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public CandleLock(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{			
			if(hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{						
				EntityLivingBase target = ((EntityLivingBase)hit.entityHit);

				new DFEffectDoruLock(target, 400);
			}
		}
	}
	
}
