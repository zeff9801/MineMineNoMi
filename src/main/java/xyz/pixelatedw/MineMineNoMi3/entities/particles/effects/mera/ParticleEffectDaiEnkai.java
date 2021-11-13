package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mera;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectDaiEnkai extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for (int i = 0; i < 10; i++)
		{
			double offsetX = WyMathHelper.randomWithRange(-3, 3) + player.worldObj.rand.nextDouble();
			double offsetY = WyMathHelper.randomWithRange(-3, 3) + player.worldObj.rand.nextDouble();
			double offsetZ = WyMathHelper.randomWithRange(-3, 3) + player.worldObj.rand.nextDouble();
			
	        double motionX = WyMathHelper.randomWithRange(-1, 1) + player.worldObj.rand.nextDouble();
	        double motionY = WyMathHelper.randomWithRange(-1, 1) + player.worldObj.rand.nextDouble();
	        double motionZ = WyMathHelper.randomWithRange(-1, 1) + player.worldObj.rand.nextDouble();
	        
            double middlePoint = 0.5D / (5 / 0.5);
            middlePoint *= player.worldObj.rand.nextFloat() * player.worldObj.rand.nextFloat() + 0.3F;
	        
	        motionX *= middlePoint / 2;
	        motionY *= middlePoint / 2;
	        motionZ *= middlePoint / 2;
			
			MainMod.proxy.spawnCustomParticles(player, 
					new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MERA, 
							posX + offsetX, 
							posY + 1.5 + offsetY, 
							posZ + offsetZ, 
							motionX,
							motionY + 0.05,
							motionZ)
					.setParticleScale(1.3F)
					.setParticleAge(10));		
		}
	}

}
