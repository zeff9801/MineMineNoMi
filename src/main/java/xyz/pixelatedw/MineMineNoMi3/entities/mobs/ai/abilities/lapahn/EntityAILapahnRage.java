package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.lapahn;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityLapahn;

public class EntityAILapahnRage extends EntityAIBase
{
	private EntityLapahn entity;
	
	public EntityAILapahnRage(EntityLapahn entity)
	{
		this.entity = entity;
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.entity.getAttackTarget() == null)
			return false;

		if (this.entity.getHealth() > this.entity.getMaxHealth() / 3)
			return false;

		this.execute();
		return true;
	}
	
	public void execute()
	{
		this.entity.setEnraged(true);

		for(EntityLivingBase entity : WyHelper.getEntitiesNear(this.entity, 10))
		{
			if(entity instanceof EntityLapahn)
			{
				EntityLapahn lapahn = (EntityLapahn) entity;
				
				lapahn.setEnraged(true);
				lapahn.setAttackTarget(this.entity.getAttackTarget());
				lapahn.updateNBT();
			}
		}
		
		this.entity.updateNBT();
	}
}
