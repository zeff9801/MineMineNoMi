package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;

public class EntityAICooldown extends EntityAIBase
{
	private EntityNewMob entity;
	private boolean isOnCooldown = false;
	protected int maxCooldown, cooldown = 80, randomizer;
	
	public EntityAICooldown(EntityNewMob entity, int timer, int random)
	{
		this.entity = entity;
		this.maxCooldown = timer;
		this.cooldown = this.maxCooldown;
		this.randomizer = random + 1;
	}
	
	@Override
	public boolean shouldExecute()
	{
		if(this.isOnCooldown && this.cooldown <= 0)
			return false;

		return true;
	}
	
	public void endCooldown()
	{
		this.isOnCooldown = false;
		this.cooldown = this.maxCooldown + this.entity.getRNG().nextInt(this.randomizer);
	}
	
	public boolean isOnCooldown()
	{
		return this.isOnCooldown;
	}
	
	public void setOnCooldown(boolean value)
	{
		this.isOnCooldown = value;
	}
	
	public boolean countDownCooldown()
	{
    	if(this.isOnCooldown)
    	{
    		this.cooldown--;
    		if(this.cooldown <= 0)
    			this.endCooldown();
    		
    		return true;
    	}
    	
    	return false;
	}

}
