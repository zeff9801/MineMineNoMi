package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

import java.util.TimerTask;

public class ParticleTaskWave2 extends TimerTask
{
	private EntityLivingBase player;
	private Object particle;
	private double posX, posY, posZ;
	
	public ParticleTaskWave2(EntityLivingBase player, double posX, double posY, double posZ, String particle)
	{
		this.player = player;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.particle = particle;
	}
	
	public ParticleTaskWave2(EntityLivingBase player, double posX, double posY, double posZ, EntityParticleFX particle)
	{
		this.player = player;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.particle = particle;

	}
	
	public void run()
	{
		
	}

}
