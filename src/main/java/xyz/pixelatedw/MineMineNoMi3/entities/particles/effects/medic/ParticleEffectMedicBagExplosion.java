package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.medic;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectMedicBagExplosion extends ParticleEffect
{

	@Override
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
				y = 0.2 + rand.nextInt(1);
				z = t * Math.sin(theta);
										
				double motionX = x / 4;
				double motionY = 0.05 + (player.worldObj.rand.nextDouble() / 7);
				double motionZ = z / 4;

				EntityParticleFX p1 = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, 
						posX + (x * 0.75), 
						posY + y, 
						posZ + (z * 0.75), 
						motionX, 
						motionY, 
						motionZ)
				.setParticleScale(2F).setParticleAge(4);	
				p1.setRBGColorF(0F, 0.8F, 0F);
				
				EntityParticleFX p2 = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, 
						posX + (x * 2.0), 
						posY + y, 
						posZ + (z * 2.0), 
						motionX, 
						motionY, 
						motionZ)
				.setParticleScale(2.5F).setParticleAge(7);
				p2.setRBGColorF(0F, 0.8F, 0F);
				
				EntityParticleFX p3 = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, 
						posX + (x * 3.75), 
						posY + y, 
						posZ + (z * 3.75), 
						motionX, 
						motionY * 2.25, 
						motionZ)
				.setParticleScale(4.5F).setParticleAge(10);
				p3.setRBGColorF(0F, 0.8F, 0F);

				MainMod.proxy.spawnCustomParticles(player, p1);
				
				MainMod.proxy.spawnCustomParticles(player, p2);
				
				MainMod.proxy.spawnCustomParticles(player, p3);
			}
		}
	}

}
