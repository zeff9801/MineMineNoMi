package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectWaterExplosion extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{	
		for (int i = 0; i < 512; i++)
		{
	        double motionX = WyMathHelper.randomWithRange(-5, 5) + player.worldObj.rand.nextDouble();
	        double motionY = WyMathHelper.randomWithRange(-5, 5) + player.worldObj.rand.nextDouble();
	        double motionZ = WyMathHelper.randomWithRange(-5, 5) + player.worldObj.rand.nextDouble();
	        
            double middlePoint = 0.25;
            middlePoint *= player.worldObj.rand.nextFloat() * player.worldObj.rand.nextFloat() + 0.3F;
	        
	        motionX *= middlePoint / 2;
	        motionY *= middlePoint / 2;
	        motionZ *= middlePoint / 2;
			
            player.worldObj.spawnParticle(EnumParticleTypes.WATER_WAKE.getParticleName(), posX, posY, posZ, motionX, motionY, motionZ);
            player.worldObj.spawnParticle(EnumParticleTypes.WATER_WAKE.getParticleName(), posX, posY, posZ, motionX, motionY, motionZ);
		}
	}
}
