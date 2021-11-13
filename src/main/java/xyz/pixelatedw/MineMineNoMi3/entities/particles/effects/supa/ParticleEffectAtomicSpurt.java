package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.supa;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectAtomicSpurt extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for (int i = 0; i < 2; i++)
		{
			double offsetX = WyMathHelper.randomDouble() / 2;
			double offsetY = 0.25;
			double offsetZ = WyMathHelper.randomDouble() / 2;

			player.worldObj.spawnParticle(
					EnumParticleTypes.BLOCK_CRACK.getParticleName() + "_" + Block.getIdFromBlock(player.worldObj.getBlock((int)posX, (int)posY - 1, (int)posZ)) + "_" + player.worldObj.getBlockMetadata((int)posX, (int)posY - 1, (int)posZ), 
					posX + offsetX, 
					posY, 
					posZ + offsetZ, 
					0, 
					0, 
					0);			
		}
	}

}
