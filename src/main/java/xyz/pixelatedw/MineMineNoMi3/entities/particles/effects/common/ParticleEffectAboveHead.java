package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

import java.util.Random;

public class ParticleEffectAboveHead extends ParticleEffect
{
	private final String particle;
	
	public ParticleEffectAboveHead(String particle)
	{
		this.particle = particle;
	}
	
	@Override
	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		Random rand = player.worldObj.rand;
		for (int i = 0; i < 5; ++i)
		{
			double locX = posX + WyMathHelper.randomDouble();
			double locY = posY + WyMathHelper.randomDouble();
			double locZ = posZ + WyMathHelper.randomDouble();

			double motionX = rand.nextGaussian() * 0.02D;
			double motionY = rand.nextGaussian() * 0.02D;
			double motionZ = rand.nextGaussian() * 0.02D;
			
			
			player.worldObj.spawnParticle(this.particle, locX, locY, locZ, motionX, motionY, motionZ);
		}
	}

}
