package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.gomu;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectGearSecond extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for (int i = 0; i < 2; i++)
		{
			double offsetX = (new Random().nextInt(20) + 1.0D - 10.0D) / 15.0D;
			double offsetY = (new Random().nextInt(20) + 1.0D - 10.0D) / 15.0D;
			double offsetZ = (new Random().nextInt(20) + 1.0D - 10.0D) / 15.0D;
	      
			player.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL.getParticleName(), posX + offsetX, (posY + 0.5) + offsetY, posZ + offsetZ, 0.0D, 0.0D, 0.0D);
		}	
	}

}
