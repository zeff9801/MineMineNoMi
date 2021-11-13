package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.brawler;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;

public class EntityAIHakaiHo extends EntityAICooldown
{
	private EntityNewMob entity;
	private double damage;
	
	public EntityAIHakaiHo(EntityNewMob entity)
	{
		super(entity, 90, entity.getRNG().nextInt(20));
		this.entity = entity;
		this.damage = this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
	}

	public boolean shouldExecute()
	{
		ItemStack itemStack = this.entity.getHeldItem();
		
		//if(this.entity.getPreviousAI() != null && this.entity.getPreviousAI() == this.entity.getCurrentAI())
		//	return false;
		
		if(itemStack != null || this.entity.getAttackTarget() == null)
			return false;


		if(this.entity.getDistanceToEntity(this.entity.getAttackTarget()) > 2)
			return false;
		
		if(this.isOnCooldown())
		{
			this.countDownCooldown();
			return false;
		}
		
		this.execute();
		return true;
	} 
	
	public void endCooldown()	
	{
		super.endCooldown();
		this.entity.setCurrentAI(null);
		this.entity.setPreviousAI(this);
	}

    public void execute()
    {
		AbilityExplosion explosion = WyHelper.newExplosion(this.entity, this.entity.getAttackTarget().posX, this.entity.getAttackTarget().posY, this.entity.getAttackTarget().posZ, 2);
		explosion.setDamageOwner(false);
		explosion.setDestroyBlocks(false);
		explosion.doExplosion();
			
		this.entity.setCurrentAI(this);
	    this.setOnCooldown(true);
    }
}