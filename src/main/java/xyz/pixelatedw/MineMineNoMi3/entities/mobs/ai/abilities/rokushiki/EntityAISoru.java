package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;

public class EntityAISoru extends EntityAICooldown
{
	private EntityNewMob entity;
	private UUID soruSpeedUUID = UUID.fromString("4929edc3-45e7-4763-aecc-d478f5eadc3b");
	private AttributeModifier speedModifier;// = new AttributeModifier(soruSpeedUUID, "Soru Speed", 20, 0);
	
	public EntityAISoru(EntityNewMob entity)
	{
		super(entity, 40, (int) WyMathHelper.randomWithRange(5, 10));		
		this.entity = entity;
	}
	
	@Override
	public boolean shouldExecute()
	{
		if(this.isOnCooldown())
		{
			IAttributeInstance soruSpeed = this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			if(this.cooldown < this.maxCooldown / 2 && soruSpeed.getModifier(soruSpeedUUID) != null)
				soruSpeed.removeModifier(this.speedModifier);
			
			this.countDownCooldown();
			return false;
		}
		
		if(this.isOnCooldown())
		{
			this.countDownCooldown();
			return false;
		}
		
		if (this.entity.getAttackTarget() == null)
			return false;

		float distance = this.entity.getDistanceToEntity(this.entity.getAttackTarget());
		if (distance > 15 && distance <= 25)
		{
			this.execute(0.3);
			return true;
		}
		else if(distance > 25)
		{
			this.execute(0.4);
			return true;	
		}
		else
		{
			return false;
		}
	}

	@Override
	public void endCooldown()	
	{
		super.endCooldown();
		this.entity.setCurrentAI(null);
		this.entity.setPreviousAI(this);
	}
	
	public void execute(double level)
	{
		IAttributeInstance soruSpeed = this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		if(soruSpeed.getModifier(this.soruSpeedUUID) != null && this.speedModifier != null)
			soruSpeed.removeModifier(this.speedModifier);	
		
		this.speedModifier = new AttributeModifier(this.soruSpeedUUID, "Soru Speed", level, 0);

		this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(this.speedModifier);
		
		this.entity.setCurrentAI(this);
	    this.setOnCooldown(true);
	}
}
