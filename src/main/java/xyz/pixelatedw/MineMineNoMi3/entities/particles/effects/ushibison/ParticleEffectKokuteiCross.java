package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ushibison;

import java.util.Timer;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskTornado2;

public class ParticleEffectKokuteiCross extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		Timer timer = new Timer(true); 
		timer.schedule(ParticleTaskTornado2.Create(player, posX, posY, posZ, EnumParticleTypes.EXPLOSION_NORMAL.getParticleName(), 2.0, 1), 0);		
	}

}
