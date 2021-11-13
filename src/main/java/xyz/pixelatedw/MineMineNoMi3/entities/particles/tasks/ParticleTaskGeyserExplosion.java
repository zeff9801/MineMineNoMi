package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.TimerTask;

import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.MainMod;

/** TODO Fully implement this effect */
public class ParticleTaskGeyserExplosion extends TimerTask
{
	
	private EntityLivingBase player;
	private String fxName;
	private double posX, posY, posZ;

	public ParticleTaskGeyserExplosion(EntityLivingBase player, double posX, double posY, double posZ, String fxName)
	{
		this.player = player;
		this.fxName = fxName;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
	}
	
	public void run()
	{
		double t = 0;
		double x, y, z;

		while(t < 10)
		{
			t = t + 0.15 * Math.PI;
			
			for(double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32)
			{
				x = t * Math.cos(theta);
				y = Math.exp(t) * Math.sin(t / 2);
				z = t * Math.sin(theta);
				
				try
				{
					//if(this.fxName.contains("custom_"))
					//	MainMod.proxy.spawnCustomParticles(this.player, this.fxName.replace("custom_", ""), this.posX + x, this.posY + y, this.posZ + z, 0.0D, 0.0D, 0.0D);
					//else							
					//	player.worldObj.spawnParticle(fxName, this.posX + x, this.posY + y, this.posZ + z, 0.0D, 0.0D, 0.0D);
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
