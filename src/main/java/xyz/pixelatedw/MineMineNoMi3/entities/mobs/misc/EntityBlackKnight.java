package xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class EntityBlackKnight extends EntityMob
{	
	private EntityPlayer owner;
	public boolean isAggressive = true;
	public List<EntityLivingBase> forcedTargets = new ArrayList<EntityLivingBase>();
	
	public EntityBlackKnight(World worldIn, EntityPlayer owner) 
	{ 
		this(worldIn);
		this.setOwner(owner);
	    this.tasks.addTask(1, new EntityAISwimming(this));
	    this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
	    this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
	    this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
	    this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
	    this.tasks.addTask(5, new EntityAILookIdle(this));
	    this.tasks.addTask(6, new EntityAIHurtByTarget(this, true));
	    this.tasks.addTask(7, new EntityAIWatchClosest(this, MarineData.class, 8.0F));
	    this.tasks.addTask(7, new EntityAIWatchClosest(this, PirateData.class, 8.0F));
	    this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
	}

	public EntityBlackKnight(World worldIn) 
	{
		super(worldIn); 
	}

	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
	}
	
    public boolean attackEntityFrom(DamageSource damageSource, float damageValue)
    {
    	if(damageSource.getEntity() != null && damageSource.getEntity() instanceof EntityPlayer && damageSource.getEntity() == this.owner)
    		return false;
    	
    	return super.attackEntityFrom(damageSource, damageValue);
    }
    
	public boolean isAIEnabled()
	{return true;}
    
	public void onEntityUpdate()
	{
		if(!this.worldObj.isRemote && this.owner == null)
			this.setDead();

		if(!this.worldObj.isRemote && this.owner != null)
		{					
			if(this.getDistanceToEntity(owner) > 10)
				this.getNavigator().tryMoveToEntityLiving(owner, 1.5);
			
			if(this.getDistanceToEntity(owner) > 80)
				this.setPositionAndUpdate(this.owner.posX, this.owner.posY, this.owner.posZ);
			
			ExtendedEntityData ownerProps = ExtendedEntityData.get(this.owner);		
			List<EntityLivingBase> attackList = isAggressive ? WyHelper.getEntitiesNear(this, 10, EntityPlayer.class, MarineData.class, PirateData.class) : !forcedTargets.isEmpty() ? forcedTargets : new ArrayList<EntityLivingBase>();

			if(!ownerProps.getUsedFruit().equalsIgnoreCase("itoito"))
				this.setDead();
			
			if(!attackList.isEmpty())
			{
				if(attackList.contains(owner))
					attackList.remove(owner);
				
				if(ownerProps.isMarine())
					attackList = attackList.stream().filter(x -> !(x instanceof MarineData)).collect(Collectors.toList());
				
				EntityLivingBase target = attackList.stream().findFirst().orElse(null);
					
				if(target != null)
					this.setAttackTarget(target);
			}
			
			if(!forcedTargets.isEmpty())
			{
				Iterator it = forcedTargets.iterator();
				while(it.hasNext())
				{
					EntityLivingBase forcedTarget = (EntityLivingBase) it.next();
					if(forcedTarget == null || !forcedTarget.isEntityAlive())
						it.remove();
				}
			}
		}	
		
		super.onEntityUpdate();
	}
	
    public boolean attackEntityAsMob(Entity target)
    {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() + (ExtendedEntityData.get(this).getDoriki() * 4);
        int i = 0;

        if (target instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)target);
            i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)target);
        }

        boolean flag = target.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag)
        {
            if (i > 0)
            {
                target.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }
        }

        return flag;
    }
	
	private void setOwner(EntityPlayer player) {this.owner = player;}
	public EntityPlayer getOwner() {return this.owner;}

}
