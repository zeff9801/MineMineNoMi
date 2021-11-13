package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki;

import net.minecraft.entity.projectile.EntityThrowable;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EntityAIGeppo extends EntityAICooldown
{
	private EntityNewMob entity;
	
	public EntityAIGeppo(EntityNewMob entity)
	{
		super(entity, 80, (int) WyMathHelper.randomWithRange(2, 7));		
		this.entity = entity;
	}
	
	@Override
	public boolean shouldExecute()
	{
		this.entity.fallDistance = 0;
		
		if(WyHelper.getEntitiesNear(this.entity, 7, EntityThrowable.class).size() > 0)
		{
			if(this.cooldown > this.maxCooldown / 2 && this.cooldown < this.maxCooldown)
				return false;
			
			this.execute();
			return true;
		}
		
		if(this.isOnCooldown())
		{
			this.countDownCooldown();
			return false;
		}
		
		if (this.entity.getAttackTarget() == null)
			return false;

		float distance = this.entity.getDistanceToEntity(this.entity.getAttackTarget());
		if (distance > 5 && this.entity.getHealth() > this.entity.getMaxHealth() / 4)
			return false;

		this.execute();
		return true;
	}

	@Override
	public void endCooldown()	
	{
		super.endCooldown();
		this.entity.setCurrentAI(null);
		this.entity.setPreviousAI(this);
	}
	
	public void execute()
	{
		this.entity.motionY = 1.3;
		
		WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_GEPPO, this.entity.posX, this.entity.posY, this.entity.posZ), this.entity.dimension, this.entity.posX, this.entity.posY, this.entity.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);		
		
		this.entity.setCurrentAI(this);
	    this.setOnCooldown(true);
	}
}
