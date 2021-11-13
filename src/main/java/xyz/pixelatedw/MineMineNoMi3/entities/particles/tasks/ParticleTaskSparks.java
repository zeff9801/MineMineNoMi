package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.TimerTask;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

public class ParticleTaskSparks extends TimerTask
{
	
	private EntityLivingBase player;
	private double posX, posY, posZ;
	private int rangeX, rangeY, rangeZ;
	private int density;

	public static ParticleTaskSparks Create(EntityLivingBase player, double posX, double posY, double posZ, int rangeX, int rangeY, int rangeZ)
	{
		return new ParticleTaskSparks(player, posX, posY, posZ, rangeX, rangeY, rangeZ);
	}
	
	private ParticleTaskSparks(EntityLivingBase player, double posX, double posY, double posZ, int rangeX, int rangeY, int rangeZ)
	{
		this.player = player;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.rangeX = rangeX;
		this.rangeY = rangeY;
		this.rangeZ = rangeZ;
	}
	
	public void run()
	{
		for (int i = 0; i < 256; i++)
		{
			double offsetX = WyMathHelper.randomWithRange(-rangeX, rangeX);
			double offsetY = WyMathHelper.randomWithRange(-rangeY, rangeY);
			double offsetZ = WyMathHelper.randomWithRange(-rangeZ, rangeZ);
			
			ResourceLocation particleToUse = ID.PARTICLE_ICON_GORO;
			
			try
			{
				for (int j = 0; j < 7; j++)
				{
					if(j % 2 == 0)
						particleToUse = ID.PARTICLE_ICON_GORO2;
					else
						particleToUse = ID.PARTICLE_ICON_GORO;
					
					MainMod.proxy.spawnCustomParticles(player,
							new EntityParticleFX(player.worldObj, particleToUse,
									posX + offsetX + (player.worldObj.rand.nextDouble() * 3),
									posY + offsetY + (player.worldObj.rand.nextDouble() * 3),
									posZ + offsetZ + (player.worldObj.rand.nextDouble() * 3),
									0, 0, 0)
							.setParticleScale(10).setParticleAge((int) (3 + (0.2 * j))));
				}
				Thread.sleep(15);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
