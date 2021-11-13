package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.moku;

import java.util.Timer;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskWave;

public class ParticleEffectWhiteStrike extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		Timer timer = new Timer(true); 
		EntityParticleFX particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MOKU, 
				posX, 
				posY - 0.8, 
				posZ, 
				0, 0, 0)
			.setParticleScale(4.0F);
		timer.schedule(ParticleTaskWave.Create(player, particle.posX, particle.posY, particle.posZ, particle, 15), 0);
	}
	
}