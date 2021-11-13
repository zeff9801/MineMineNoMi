package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

import java.util.TimerTask;

public class ParticleTaskSphere extends TimerTask
{
	
	private EntityLivingBase player;
	private Object particle;
	private int density, repeats;
	private double radius, posX, posY, posZ;

	public static ParticleTaskSphere Create(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density, int repeats)
	{
		return new ParticleTaskSphere(player, posX, posY, posZ, particle, radius, density, repeats);
	}
	
	private ParticleTaskSphere(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density, int repeats)
	{
		this.player = player;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.particle = particle;
		this.radius = radius;
		this.density = density;
		this.repeats = repeats;
	}
	
	public void run()
	{
		double phi = 0;
		while(phi < repeats * Math.PI)
		{
			phi += Math.PI / density;
			
			for(double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / density)
			{
				double r = radius;
				double x = r * Math.cos(theta) * Math.sin(phi);
				double y = r * Math.cos(phi) + 1.5;
				double z = r * Math.sin(theta) * Math.sin(phi);
				
				try 
				{
					if(this.particle instanceof EntityParticleFX)
					{
						EntityParticleFX clone = ((EntityParticleFX)particle).clone(this.posX + x, this.posY + y, this.posZ + z);
						Minecraft.getMinecraft().effectRenderer.addEffect(clone);
					}
					else							
						player.worldObj.spawnParticle((String) particle, this.posX + x, this.posY + y, this.posZ + z, 0.0D, 0.0D, 0.0D);
					Thread.sleep(2);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}	
			}
		}
	}
}