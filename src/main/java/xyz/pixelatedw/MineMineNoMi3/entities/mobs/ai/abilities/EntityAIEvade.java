package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIEvade extends EntityAIBase
{

	private EntityLivingBase theEntity;
	private int chance;
	
	public EntityAIEvade(EntityLivingBase entity, int chance)
	{
		this.theEntity = entity;
		this.chance = chance;

		this.setMutexBits(8);
	}
	
	public boolean shouldExecute() 
	{
		if(theEntity.getAITarget() != null)
			return true;
		else 
			return false;
	}	
	
	public void startExecuting()
	{
				
	}
		
	public boolean continueExecuting()
	{
		return true;
	}
	

}
