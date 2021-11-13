package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;

public class EntityAISharpshooter extends EntityAIBase
{
	
	private EntityNewMob theEntity;
	private float inaccuracy;
	private int ticksBeforeShoot = 30, maxTicksBeforeShoot;
	private AbilityAttribute bullet;
	
	public EntityAISharpshooter(EntityNewMob entity, float inaccuracy, int bulletType)
	{
		this(entity, inaccuracy, bulletType, 30);
	}
	
	public EntityAISharpshooter(EntityNewMob entity, float inaccuracy, int bulletType, int cooldown)
	{
		this.theEntity = entity;
		this.inaccuracy = inaccuracy;
		this.ticksBeforeShoot = cooldown;
		this.maxTicksBeforeShoot = cooldown;
		switch(bulletType)
		{
		case 0:
			bullet = ListExtraAttributes.NORMAL_BULLET.setProjectileDamage(4);
			break;
		case 1:
			bullet = ListExtraAttributes.KAIROSEKI_BULLET.setProjectileDamage(6);
			break;
			
		default:
			bullet = ListExtraAttributes.NORMAL_BULLET.setProjectileDamage(4);
			break;
		}
		
		this.setMutexBits(8);
	}
	
	public boolean shouldExecute() 
	{
		if(theEntity.getAttackTarget() != null)
			return true;
		else 
			return false;
	}	
	
	public void startExecuting()
	{
		theEntity.getLookHelper().setLookPositionWithEntity(theEntity.getAttackTarget(), 10, 10);	
	}
		
	public boolean continueExecuting()
	{
		boolean continueFlag = theEntity.getAttackTarget() != null && theEntity.canEntityBeSeen(theEntity.getAttackTarget()) && theEntity.getDistanceSqToEntity(theEntity.getAttackTarget()) < 120;
			
		if(continueFlag)
		{
			theEntity.getLookHelper().setLookPositionWithEntity(theEntity.getAttackTarget(), 10, 10);
	
			if(ticksBeforeShoot <= 0)
			{ 
	    		double d0 = theEntity.getDistanceSqToEntity(theEntity.getAttackTarget());
	    		float f = MathHelper.sqrt_float(MathHelper.sqrt_double(d0));
	    		double d1 = theEntity.getAttackTarget().posX - theEntity.posX;
	    		double d2 = theEntity.getAttackTarget().boundingBox.minY + (double)(theEntity.getAttackTarget().height / 2.0F) - (theEntity.posY + (double)(theEntity.height / 2.0F));
	    		double d3 = theEntity.getAttackTarget().posZ - theEntity.posZ;
	
				AbilityProjectile proj;
				if(bullet == ListExtraAttributes.NORMAL_BULLET) proj = new ExtraProjectiles.NormalBullet(theEntity.worldObj, theEntity, bullet);
				else if(bullet == ListExtraAttributes.KAIROSEKI_BULLET) proj = new ExtraProjectiles.KairosekiBullet(theEntity.worldObj, theEntity, bullet);
				else proj = new ExtraProjectiles.NormalBullet(theEntity.worldObj, theEntity, bullet);
				
				proj.posY = theEntity.posY + (double)(theEntity.height / 2.0F) + 0.5D;
				proj.setThrowableHeading(d1 + theEntity.getRNG().nextGaussian(), d2, d3 + theEntity.getRNG().nextGaussian(), inaccuracy, 0);
				theEntity.worldObj.spawnEntityInWorld(proj);
	
	    		ticksBeforeShoot = maxTicksBeforeShoot; 
			}
			else 
				ticksBeforeShoot--;
		}
			
		return continueFlag;
	}
}
