package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskTornado;

import java.util.Timer;

public class ParticleEffectDarkMatter extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		Timer timer = new Timer(true); 
		EntityParticleFX particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DARKNESS, 
				posX, 
				posY + 1, 
				posZ, 
				0, 0, 0)
				.setParticleGravity(-1.25f + player.worldObj.rand.nextFloat()).setParticleScale(player.worldObj.rand.nextInt(3) + 1);
		timer.schedule(ParticleTaskTornado.Create(player, posX, posY, posZ, particle, 8.0, 2, 0.15, 0.5), 0);
	}

}
