package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ito;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectKumoNoSugaki extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		double offsetX = 0;
		double offsetZ = 0;
		
		switch(WyHelper.get4Directions(player))
		{
			case NORTH:
				offsetZ = -1.5; break;
			case SOUTH:
				offsetZ = 1.5; break;
			case EAST:
				offsetX = 1.5; break;
			case WEST:
				offsetX = -1.5; break;
		}
		
		MainMod.proxy.spawnCustomParticles(player, 
				new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_ITO,
						posX + offsetX, 
						posY + 1.0, 
						posZ + offsetZ, 
						0.0D, 0.0D, 0.0D)
				.setParticleScale(30).setParticleGravity(0).setParticleAge(10));

	}

}
