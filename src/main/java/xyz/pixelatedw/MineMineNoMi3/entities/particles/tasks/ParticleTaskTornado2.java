package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

import java.util.TimerTask;


/** TODO Change this shitty effect, this is a Tornado2 effect clearly */
public class ParticleTaskTornado2 extends TimerTask
{
	
	private EntityLivingBase player;
	private Object particle;
	private double radius, posX, posY, posZ;
	private int density;

	public static ParticleTaskTornado2 Create(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density)
	{
		return new ParticleTaskTornado2(player, posX, posY, posZ, particle, radius, density);
	}
	
	private ParticleTaskTornado2(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density)
	{
		this.player = player;
		this.particle = particle;
		this.radius = radius;
		this.density = density;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
	}
	
	@Override
	public void run()
	{
		double phi = 0;
		double x, y, z;
		
		while(phi < density * Math.PI)
		{
			phi += Math.PI / 4;
			for(double t = 0; t <= 2 * Math.PI; t += Math.PI / 16)
			{
				for(double i = 0; i <= 1; i += 1)
				{
					
					x = 0.5 * (radius * phi + t) * Math.cos(t * phi + i);
					y = 0.1 * (t * 3 + radius * Math.PI);
					z = 0.5 * (radius * phi + t) * Math.sin(t * phi + i);
					
					try
					{
						if(this.particle instanceof EntityParticleFX)
						{
							EntityParticleFX clone = ((EntityParticleFX)particle).clone(this.posX + x, this.posY + y, this.posZ + z);
							Minecraft.getMinecraft().effectRenderer.addEffect(clone);
						}
						else							
							player.worldObj.spawnParticle((String) particle, this.posX + x, this.posY - 0.7 + y, this.posZ + z, 0.0D, 0.0D, 0.0D);
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
}