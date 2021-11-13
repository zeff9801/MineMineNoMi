package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectMeroPetrification;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class MeroProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {MeroMeroMellow.class, ListAttributes.MERO_MERO_MELLOW});
		abilitiesClassesArray.add(new Object[] {PistolKiss.class, ListAttributes.PISTOL_KISS});
		abilitiesClassesArray.add(new Object[] {SlaveArrow.class, ListAttributes.SLAVE_ARROW});
	}
	
	public static class SlaveArrow extends AbilityProjectile
	{
		public SlaveArrow(World world)
		{super(world);}
		
		public SlaveArrow(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public SlaveArrow(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase) hit.entityHit;
				
				new DFEffectMeroPetrification(entity, 400);
			}
		}
		
		@Override
		public void onUpdate()
		{		
			if(this.worldObj.isRemote && this.ticksExisted > 5)
			{		
				for(int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
				{
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MERO, 
							posX, 
							posY, 
							posZ, 
							0, 0, 0)
							.setParticleAge(1).setParticleScale(1.3F);
					MainMod.proxy.spawnCustomParticles(this, particle);
				}
			}
			super.onUpdate();
		}
	}	
	
	public static class PistolKiss extends AbilityProjectile
	{
		public PistolKiss(World world)
		{super(world);}
		
		public PistolKiss(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public PistolKiss(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase) hit.entityHit;
				
				new DFEffectMeroPetrification(entity, 200);
			}
		}
	}	
	
	public static class MeroMeroMellow extends AbilityProjectile
	{
		public MeroMeroMellow(World world)
		{super(world);}
		
		public MeroMeroMellow(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public MeroMeroMellow(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase) hit.entityHit;
				
				new DFEffectMeroPetrification(entity, 600);
			}
		}
	}	
}
