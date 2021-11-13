package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

import java.util.Random;
import java.util.TimerTask;

public class ParticleTaskWave extends TimerTask
{
	
	private EntityLivingBase player;
	private Object particle;
	private double posX, posY, posZ, radius;

	public static ParticleTaskWave Create(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius)
	{
		return new ParticleTaskWave(player, posX, posY, posZ, particle, radius);
	}
	
	private ParticleTaskWave(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius)
	{
		this.player = player;
		this.particle = particle;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.radius = radius;
	}
	
	public void run()
	{
		double t = 0;
		double x, y, z;
		Random rand = this.player.getRNG();

		while(t < radius)
		{
			t += 0.5 * Math.PI;
			
			for(double theta = 0; theta <= 4 * Math.PI; theta += Math.PI / 16)
			{
				x = t * Math.cos(theta);
				//y = Math.sin(theta / (0.5 * t));
				//y = Math.exp(t * -0.4) + Math.sin((t*t) * 0.25);
				y = rand.nextInt(1);
				z = t * Math.sin(theta);
				
				try
				{
					if(this.particle instanceof EntityParticleFX)
					{
						EntityParticleFX clone = ((EntityParticleFX)particle).clone(this.posX + WyMathHelper.randomWithRange(-3, 3) + x, this.posY + 1 + y, this.posZ + WyMathHelper.randomWithRange(-3, 3) + z);
						Minecraft.getMinecraft().effectRenderer.addEffect(clone);
					}
					else							
						player.worldObj.spawnParticle((String) particle, this.posX + WyMathHelper.randomWithRange(-3, 3) + x, this.posY + y, this.posZ + WyMathHelper.randomWithRange(-3, 3) + z, 0.0D, 0.0D, 0.0D);
					Thread.sleep(1);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}	
			}
		}
	}
}