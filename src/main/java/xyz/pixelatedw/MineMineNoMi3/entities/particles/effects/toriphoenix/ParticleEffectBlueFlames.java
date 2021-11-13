package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectBlueFlames extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for (int i = 0; i < 50; i++)
		{
			double offsetX = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
			double offsetY = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
			double offsetZ = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
			
			MainMod.proxy.spawnCustomParticles(player, 
					new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_BLUEFLAME,
							posX + offsetX, 
							posY + 1 + offsetY, 
							posZ + offsetZ, 
							0, 0, 0)
					.setParticleScale(1.2F).setParticleGravity(0).setParticleAge(1));
		}
	}

}
