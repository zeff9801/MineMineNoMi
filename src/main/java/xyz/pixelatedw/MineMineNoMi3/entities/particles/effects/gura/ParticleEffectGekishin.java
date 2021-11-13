package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.gura;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectGekishin extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		double offsetX = 0;
		double offsetZ = 0;
		
		switch(WyHelper.get4Directions(player))
		{
			case NORTH:
				offsetZ = -2.5; break;
			case SOUTH:
				offsetZ = 2.5; break;
			case EAST:
				offsetX = 2.5; break;
			case WEST:
				offsetX = -2.5; break;
		}
		
		MainMod.proxy.spawnCustomParticles(player, 
				new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_GURA, 
						posX + offsetX, 
						posY + 1.0, 
						posZ + offsetZ, 
						0.0D, 0.0D, 0.0D)
				.setParticleScale(50).setParticleGravity(0).setParticleAge(10).setHasZoom());
		
		for (int i = 0; i < 50; i++)
		{
			offsetX = (new Random().nextInt(40) + 1.0D - 20.0D) / 2.0D;
			double offsetY = (new Random().nextInt(40) + 1.0D - 20.0D) / 10.0D;
			offsetZ = (new Random().nextInt(40) + 1.0D - 20.0D) / 2.0D;
			
			player.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE.getParticleName(), posX + offsetX + new Random().nextInt(5), posY + offsetY, posZ + offsetZ + new Random().nextInt(5), 0.0, 0.0, 0.0);
		}	
	}

}
