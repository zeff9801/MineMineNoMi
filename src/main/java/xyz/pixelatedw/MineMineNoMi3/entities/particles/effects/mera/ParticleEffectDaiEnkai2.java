package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mera;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectDaiEnkai2 extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		double t = 0;
		double x, y, z;
		Random rand = player.getRNG();

		while(t < 1)
		{
			t += 0.5 * Math.PI;
			
			for(double theta = 0; theta <= 4 * Math.PI; theta += Math.PI / 32)
			{
				x = t * Math.cos(theta);
				y = rand.nextInt(1);
				z = t * Math.sin(theta);
										
				double motionX = x / 10;
				double motionY = 0.05 + (player.worldObj.rand.nextDouble() / 10);
				double motionZ = z / 10;

				MainMod.proxy.spawnCustomParticles(player, 
						new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MERA, 
								posX + (x * 1.25), 
								posY + y, 
								posZ + (z * 1.25), 
								motionX, 
								motionY, 
								motionZ)
						.setParticleScale(1.3F).setParticleAge(-3));
				
				MainMod.proxy.spawnCustomParticles(player, 
						new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MERA, 
								posX + (x * 2.0), 
								posY + y, 
								posZ + (z * 2.0), 
								motionX, 
								motionY, 
								motionZ)
						.setParticleScale(1.3F).setParticleAge(1));
				
				MainMod.proxy.spawnCustomParticles(player, 
						new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MERA, 
								posX + (x * 3.25), 
								posY + y, 
								posZ + (z * 3.25), 
								motionX, 
								motionY * 2.25, 
								motionZ)
						.setParticleScale(1.3F).setParticleAge(3));
			}
		}
	}

}
