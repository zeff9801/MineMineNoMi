package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.hie;

import java.util.Timer;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskWave;

public class ParticleEffectIceAge extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for(int i = 0; i < 7; i++)
		{
			Timer timer = new Timer(true); 
			EntityParticleFX particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_HIE, 
					posX, 
					posY - 0.5, 
					posZ, 
					0, 0, 0)
					.setParticleScale(1 + player.worldObj.rand.nextFloat());
			timer.schedule(ParticleTaskWave.Create(player, particle.posX, particle.posY, particle.posZ, particle, 20), 0);
		}
	}

}
