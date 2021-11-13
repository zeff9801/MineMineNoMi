package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectChloroBall extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{	
		for (int i = 0; i < 256; i++)
		{
	        double motionX = WyMathHelper.randomWithRange(-7, 7) + player.worldObj.rand.nextDouble();
	        double motionY = WyMathHelper.randomWithRange(-7, 7) + player.worldObj.rand.nextDouble();
	        double motionZ = WyMathHelper.randomWithRange(-7, 7) + player.worldObj.rand.nextDouble();
	        
            double middlePoint = 0.05;
            middlePoint *= (double)(player.worldObj.rand.nextFloat() * player.worldObj.rand.nextFloat() + 2.2F);
	        
	        motionX *= middlePoint / 2;
	        motionY *= middlePoint / 2;
	        motionZ *= middlePoint / 2;
			
			MainMod.proxy.spawnCustomParticles(player, new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DOKU,
					posX,
					posY + 1,
					posZ,
					motionX,
					motionY,
					motionZ)
			.setParticleScale(2).setParticleAge(1));	
		}
	}
}
