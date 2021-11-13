package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.lapahn;

import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityLapahn;

public class EntityAILapahnJump extends EntityAICooldown
{
	private EntityLapahn entity;
	private int hitCount, maxCount;
	private float prevHealth;
	private double speed;

	public EntityAILapahnJump(EntityLapahn entity)
	{
		super(entity, 40, 5);
		this.entity = entity;
		this.speed = 1.5;
		this.maxCount = 2;
		this.prevHealth = this.entity.getHealth();
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.entity.getAttackTarget() == null)
			return false;

		if (this.entity.getHealth() < this.prevHealth)
		{
			this.hitCount++;
			this.prevHealth = this.entity.getHealth();
		}

		float distance = this.entity.getDistanceToEntity(this.entity.getAttackTarget());
		if (distance > 10 && distance < 2)
			return false;

		if (this.hitCount < this.maxCount)
			return false;

		this.execute();
		return true;
	}

	public void execute()
	{
		this.entity.motionY = 2;

		this.hitCount = 0;
	}
}
