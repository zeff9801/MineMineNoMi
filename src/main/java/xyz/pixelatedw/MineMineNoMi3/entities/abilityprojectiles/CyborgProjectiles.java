package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class CyborgProjectiles 
{
	
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {FreshFire.class, ListAttributes.FRESH_FIRE});
		abilitiesClassesArray.add(new Object[] {RadicalBeam.class, ListAttributes.RADICAL_BEAM});
		abilitiesClassesArray.add(new Object[] {StrongRight.class, ListAttributes.STRONG_RIGHT});
		abilitiesClassesArray.add(new Object[] {CoupDeVent.class, ListAttributes.COUP_DE_VENT});
	}
	
	
	public static class CoupDeVent extends AbilityProjectile
	{
		public CoupDeVent(World world)
		{super(world);}
		
		public CoupDeVent(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public CoupDeVent(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
			{
				double newPosX = 0, newPosY = 0, newPosZ = 0;
				
				hit.entityHit.motionY += 2;
				Direction dir = WyHelper.get4Directions(hit.entityHit);
				if(dir == WyHelper.Direction.SOUTH)
					newPosX += WyMathHelper.randomWithRange(-5, 5);
				else if(dir == WyHelper.Direction.EAST)
					newPosX -= WyMathHelper.randomWithRange(-5, 5);
				else if(dir == WyHelper.Direction.NORTH)
					newPosZ += WyMathHelper.randomWithRange(-5, 5);
				else if(dir == WyHelper.Direction.WEST)  
					newPosZ -= WyMathHelper.randomWithRange(-5, 5);

				((EntityLivingBase)hit.entityHit).setPositionAndUpdate(hit.entityHit.posX + newPosX, hit.entityHit.posY + newPosY, hit.entityHit.posZ + newPosZ);
			}
		}
		
		public void onUpdate()
		{				
			this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC.getParticleName(), this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);			
			super.onUpdate();
		}
	}
	
	public static class StrongRight extends AbilityProjectile
	{
		public StrongRight(World world)
		{super(world);}
		
		public StrongRight(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public StrongRight(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}

	}
	
	public static class FreshFire extends AbilityProjectile
	{
		public FreshFire(World world)
		{super(world);}
		
		public FreshFire(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public FreshFire(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
				hit.entityHit.setFire(this.ticks);
		}
		
		public void onUpdate()
		{			
			if(this.worldObj.isRemote)
			{
				EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MERA, 
						posX, 
						posY + 0.5, 
						posZ, 
						0, 0, 0);
				MainMod.proxy.spawnCustomParticles(this, particle);
			}
			super.onUpdate();
		}
	}
	
	public static class RadicalBeam extends AbilityProjectile
	{
		public RadicalBeam(World world)
		{super(world);}
		
		public RadicalBeam(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public RadicalBeam(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}

	}
}
