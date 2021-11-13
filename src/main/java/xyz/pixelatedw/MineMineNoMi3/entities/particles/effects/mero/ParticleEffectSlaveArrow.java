package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mero;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectSlaveArrow extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
        double motionX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.05);
        double motionZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.05);
        double motionY = (double)(-MathHelper.sin((player.rotationPitch) / 180.0F * (float)Math.PI) * 0);

		EntityParticleFX heartParticle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MERO,
				posX,
				posY + 1.5,
				posZ,
				motionX,
				motionY,
				motionZ)
		.setParticleScale(10).setParticleGravity(0).setParticleAge(50);
		
		heartParticle.setAlphaF(0.5F);
        
		MainMod.proxy.spawnCustomParticles(player, heartParticle);	
	}

}
