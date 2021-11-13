package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.fishkarate;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskSphere;

import java.util.Timer;

public class ParticleEffectSamehada extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		Timer timer = new Timer(true); 
		timer.schedule(ParticleTaskSphere.Create(player, posX, posY, posZ, EnumParticleTypes.WATER_SPLASH.getParticleName(), 1.5, 10, 1), 0);
	}

}
