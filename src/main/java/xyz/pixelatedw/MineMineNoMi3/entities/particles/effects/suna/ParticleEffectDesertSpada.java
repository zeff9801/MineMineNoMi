package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectDesertSpada extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		Random rand = player.getRNG();
		
		for(int i = 0; i < 200; i++)
		{
			double x = 0;
			double z = 0;

			double motionX = 0;
			double motionY = 0.05 + (WyMathHelper.randomDouble() / 50);
			double motionZ = 0;
			
			if(WyHelper.get4Directions(player) == WyHelper.Direction.NORTH)
			{
				x = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
				z = -i * 0.2;
			}
			else if(WyHelper.get4Directions(player) == WyHelper.Direction.EAST)
			{
				x = i * 0.2;
				z = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
			}
			else if(WyHelper.get4Directions(player) == WyHelper.Direction.SOUTH)
			{
				x = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
				z = i * 0.2;
			}
			else if(WyHelper.get4Directions(player) == WyHelper.Direction.WEST)
			{
				x = -i * 0.2;
				z = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
			}
			
			MainMod.proxy.spawnCustomParticles(player, 
					new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_SUNA, 
							posX + x,
							posY + 0.1,
							posZ + z,
							motionX, 
							motionY, 
							motionZ)
					.setParticleScale(5F).setParticleAge(10));
		}
	}
}
