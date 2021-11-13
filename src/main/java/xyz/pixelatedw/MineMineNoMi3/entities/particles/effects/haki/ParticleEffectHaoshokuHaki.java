package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.haki;

import java.util.Random;
import java.util.Timer;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskTornado2;

public class ParticleEffectHaoshokuHaki extends ParticleEffect
{

	@Override
	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		Timer timer = new Timer(true);

		EntityParticleFX particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MOKU, 
				posX * 1.25, 
				posY + 0.5, 
				posZ * 1.25, 
				0, 
				0, 
				0);
		
		particle.setRBGColorF(0.7F, 0, 0.7F);
		particle.setParticleScale(0.8F);
		particle.setParticleAge(-3);
		
		timer.schedule(ParticleTaskTornado2.Create(player, posX, posY, posZ, particle, 3.2, 2), 0);
		
		double t = 0;
		double x, y, z;
		Random rand = player.getRNG();

		for(int i = 0; i < 25; i++)
		{
			while(t < 1)
			{
				t += 0.01 * Math.PI;
				
				for(double theta = 0; theta <= 4 * Math.PI; theta += Math.PI / 32)
				{
					x = t * Math.cos(theta);
					z = t * Math.sin(theta);
											
					double motionX = (x / 8) + WyMathHelper.randomDouble();
					double motionZ = (z / 8) + WyMathHelper.randomDouble();
					
					particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MOKU, 
							posX + (x * 1.25), 
							posY + 0.5, 
							posZ + (z * 1.25), 
							motionX, 
							0, 
							motionZ);
					
					particle.setRBGColorF(0.7F, 0, 0.7F);
					particle.setParticleScale(0.8F);
					particle.setParticleAge(2);
					
					MainMod.proxy.spawnCustomParticles(player, particle);
					
					double motionY = (x / 12) + WyMathHelper.randomDouble();

					particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, 
							posX + (x * 1.25), 
							posY + 1.5, 
							posZ + (z * 1.25), 
							motionX * 1.5, 
							motionY * 1.5, 
							motionZ * 1.5);
					
					particle.setRBGColorF(0.7F, 0, 0.7F);
					particle.setParticleScale(1.2F);
					particle.setParticleAge(5);
					
					MainMod.proxy.spawnCustomParticles(player, particle);
				}
			}
		}
	}

}
