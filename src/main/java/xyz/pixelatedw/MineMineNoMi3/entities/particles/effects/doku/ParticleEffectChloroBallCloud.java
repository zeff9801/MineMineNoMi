package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectChloroBallCloud extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for (int i = 0; i < 128; i++)
		{
			double offsetX = WyMathHelper.randomWithRange(-2, 2) + WyMathHelper.randomDouble();
			double offsetY = WyMathHelper.randomWithRange(-1, 2) + WyMathHelper.randomDouble();
			double offsetZ = WyMathHelper.randomWithRange(-2, 2) + WyMathHelper.randomDouble();
			
			double motionX = WyMathHelper.randomDouble() / 8;
			double motionZ = WyMathHelper.randomDouble() / 8;
			
			MainMod.proxy.spawnCustomParticles(player, 
					new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DOKU,
							posX + offsetX, 
							posY + offsetY, 
							posZ + offsetZ, 
							motionX, 
							0.05D, 
							motionZ)
					.setParticleScale(1.2F).setParticleGravity(0).setParticleAge(5 + player.worldObj.rand.nextInt(2)));
		}	
	}

}
