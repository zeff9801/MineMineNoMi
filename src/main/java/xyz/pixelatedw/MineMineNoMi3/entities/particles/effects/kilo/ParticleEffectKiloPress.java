package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kilo;

import java.util.Timer;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskWave;

public class ParticleEffectKiloPress extends ParticleEffect
{

	public void spawn(EntityPlayer player, double posX, double posY, double posZ)
	{
		for(int i = 0; i < 8; i++)
		{
			Timer timer = new Timer(true); 
			String particleString = EnumParticleTypes.BLOCK_CRACK.getParticleName() + "_" + Block.getIdFromBlock(player.worldObj.getBlock((int)posX, (int)posY - 1, (int)posZ))  + "_" + player.worldObj.getBlockMetadata((int)posX, (int)posY - 1, (int)posZ);
			timer.schedule(ParticleTaskWave.Create(player, player.posX, player.posY - 1.5, player.posZ, particleString, 4), 0);
		}
	}

}
