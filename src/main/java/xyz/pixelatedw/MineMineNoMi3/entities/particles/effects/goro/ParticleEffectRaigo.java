package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro;

import java.util.Timer;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskSparks;

public class ParticleEffectRaigo extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for (int i = 0; i < 512; i++)
		{
			double offsetX = WyMathHelper.randomWithRange(-55, 55);
			double offsetY = WyMathHelper.randomWithRange(-5, 5);
			double offsetZ = WyMathHelper.randomWithRange(-55, 55);

			EntityParticleFX particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_GORO3,
					posX + offsetX + (player.worldObj.rand.nextDouble() * 5),
					posY + 40 + offsetY + (player.worldObj.rand.nextDouble() * 5),
					posZ + offsetZ + (player.worldObj.rand.nextDouble() * 5),
					0, 0, 0)
			.setParticleScale(100).setParticleAge(100);
			
			if(i % 2 == 0)
				particle.setRBGColorF(0.4F, 0.4F, 0.4F);
			else
				particle.setRBGColorF(0.3F, 0.3F, 0.3F);			
			
			MainMod.proxy.spawnCustomParticles(player, particle);
		}
		
		Timer timer = new Timer(true); 
		timer.schedule(ParticleTaskSparks.Create(player, posX, posY + 30, posZ, 55, 5, 55), 0);		
	}
	
}
