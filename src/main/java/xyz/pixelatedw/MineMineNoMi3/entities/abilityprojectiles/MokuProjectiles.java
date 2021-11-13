package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class MokuProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {WhiteSnake.class, ListAttributes.WHITE_SNAKE});
		abilitiesClassesArray.add(new Object[] {WhiteOut.class, ListAttributes.WHITE_OUT});
	}
	
	public static class WhiteSnake extends AbilityProjectile
	{
		public WhiteSnake(World world)
		{super(world);}
		
		public WhiteSnake(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public WhiteSnake(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for(int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(5); i++)
				{
					double offsetX = (new Random().nextInt(20) + 1.0D - 10.0D) / 18.0D;
					double offsetY = (new Random().nextInt(20) + 1.0D - 10.0D) / 18.0D;
					double offsetZ = (new Random().nextInt(20) + 1.0D - 10.0D) / 18.0D;
				    
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU2, 
							posX + offsetX, 
							posY + offsetY, 
							posZ + offsetZ, 
							0, 0, 0)
							.setParticleAge(15).setParticleScale(3F);
					
					MainMod.proxy.spawnCustomParticles(this, particle);				
				}
			}

			super.onUpdate();
		}
	}	
	
	public static class WhiteOut extends AbilityProjectile
	{
		public WhiteOut(World world)
		{super(world);}
		
		public WhiteOut(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public WhiteOut(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for(int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(5); i++)
				{
					double offsetX = WyMathHelper.randomDouble();
					double offsetY = WyMathHelper.randomDouble();
					double offsetZ = WyMathHelper.randomDouble();
					      
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU, 
							posX + offsetX, 
							posY + offsetY, 
							posZ + offsetZ, 
							0, 0, 0)
							.setParticleAge(15).setParticleScale(3F);
					
					MainMod.proxy.spawnCustomParticles(this, particle);	
				}
			}
			
			super.onUpdate();
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null && !hit.entityHit.isDead)
				((EntityLivingBase) hit.entityHit).setPosition(this.getThrower().posX, this.getThrower().posY, this.getThrower().posZ);
		}
	}
}
