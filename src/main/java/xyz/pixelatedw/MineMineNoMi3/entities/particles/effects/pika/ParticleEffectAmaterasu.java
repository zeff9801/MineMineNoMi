package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectAmaterasu extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
        double motionX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 1);
        double motionZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 1);
        double motionY = (double)(-MathHelper.sin((player.rotationPitch) / 180.0F * (float)Math.PI) * 1);

		MainMod.proxy.spawnCustomParticles(player, 
				new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_PIKA,
						posX,
						posY,
						posZ,
						motionX,
						motionY + 0.2,
						motionZ)
				.setParticleScale(50).setParticleGravity(0).setParticleAge(10).setHasZoom());		
	}

}
