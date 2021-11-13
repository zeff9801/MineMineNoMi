package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;

import java.util.UUID;

public class EntityAITekkai extends EntityAICooldown
{
	private EntityNewMob entity;
	private int hitCount, maxCount;
	private float prevHealth;
	private UUID knockbackResistanceUUID = UUID.fromString("4929edc3-45e7-4763-aecc-d478f5eadc3b");
	private AttributeModifier knockbackModifier = new AttributeModifier(this.knockbackResistanceUUID, "Knockback Resistance", 999, 0);
	
	public EntityAITekkai(EntityNewMob entity)
	{
		super(entity, 50, (int) WyMathHelper.randomWithRange(5, 10));
		this.entity = entity;
		this.maxCount = 2;
		this.prevHealth = this.entity.getHealth();
	}
	
	@Override
	public boolean shouldExecute()
	{
		this.entity.fallDistance = 0;

		if(this.isOnCooldown())
		{
			IAttributeInstance knockbackResistsance = this.entity.getEntityAttribute(SharedMonsterAttributes.knockbackResistance);
			if(this.cooldown < this.maxCooldown / 2 && knockbackResistsance.getModifier(this.knockbackResistanceUUID) != null)
				knockbackResistsance.removeModifier(this.knockbackModifier);
			
			this.countDownCooldown();
			return false;
		}

		if (this.entity.getAttackTarget() == null)
			return false;

		if (this.entity.getHealth() < this.prevHealth)
		{
			this.hitCount++;
			this.prevHealth = this.entity.getHealth();
		}
		
		float distance = this.entity.getDistanceToEntity(this.entity.getAttackTarget());
		if (distance > 3)
			return false;

		if (this.hitCount < this.maxCount)
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
		if(this.entity.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getModifier(this.knockbackResistanceUUID) == null)
			this.entity.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(this.knockbackModifier);
		
		this.entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 70, 100));
		this.entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 70, 100));
		this.entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 70, 5));
		this.entity.addPotionEffect(new PotionEffect(Potion.jump.id, 70, -100));
		
		this.hitCount = 0;	
		this.maxCount = (int) (2 + WyMathHelper.randomWithRange(1, 3));
		this.entity.setCurrentAI(this);
	    this.setOnCooldown(true);
	}

}
