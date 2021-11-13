package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectFlash extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		MainMod.proxy.spawnCustomParticles(player, 
				new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_PIKA,
						posX,
						posY + 3.5,
						posZ,
						0, 0, 0)
				.setParticleScale(50).setParticleGravity(0).setParticleAge(10).setHasZoom());		
	}

}
