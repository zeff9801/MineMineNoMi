package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectBlackHole extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for (int i = 0; i < 1024; i++)
		{
			double offsetX = WyMathHelper.randomWithRange(-10, 10) + player.worldObj.rand.nextDouble();
			double offsetZ = WyMathHelper.randomWithRange(-10, 10) + player.worldObj.rand.nextDouble();
			
			MainMod.proxy.spawnCustomParticles(player, 
					new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DARKNESS,
							posX - 1 + offsetX, 
							posY - 0.5 + new Random().nextDouble(),
							posZ - 1 + offsetZ, 
							0.0D, 0.0D, 0.0D)
					.setParticleGravity(-1 + player.worldObj.rand.nextFloat()).setParticleScale(player.worldObj.rand.nextInt(3) + 1)
					);
		}
	}

}
