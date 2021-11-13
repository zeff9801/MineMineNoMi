package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

import java.util.Random;

public class ParticleEffectGroundDeath extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{		
		double t = 0;
		double x, y, z;
		Random rand = player.getRNG();

		while(t < 2)
		{
			t += 0.1 * Math.PI;
			
			for(double theta = 0; theta <= 4 * Math.PI; theta += Math.PI / 32)
			{
				x = t * Math.cos(theta);
				y = rand.nextInt(1);
				z = t * Math.sin(theta);
										
				double motionX = x / 2 + WyMathHelper.randomDouble();
				double motionY = 0;
				double motionZ = z / 2 + WyMathHelper.randomDouble();

				MainMod.proxy.spawnCustomParticles(player, 
						new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_SUNA2, 
								posX + (x * 1.25), 
								posY + 0.5 + y, 
								posZ + (z * 1.25), 
								motionX, 
								motionY, 
								motionZ)
						.setParticleScale(3.3F).setParticleAge(10));
			}
		}
	}

}
