package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines;

import javax.annotation.Nullable;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityMomonga extends MarineData
{
	private int ticksBeforeSoru = 50;
	
	public EntityMomonga(World world)
	{
		super(world);
	}
	
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(140.0D);
	}

    protected void entityInit() 
    {
        super.entityInit();
        //this.getEntityData().set
        //this.getDataManager().register(EntityHelper.STATE, 0);
    }	
	
	public void onUpdate() 
	{
		Direction dir = WyHelper.get4Directions(this);
		
		if(this.getAttackTarget() != null)
		{
			
			if(this.getHealth() < this.getMaxHealth()/2)
				this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10);
			
			if(ticksBeforeSoru <= 0 && this.getDistanceSqToEntity(this.getAttackTarget()) < 250 && this.onGround)
			{
				if(this.getHealth() < this.getMaxHealth() / 2)
				{
					if (dir == Direction.NORTH) this.motionZ -= 2.8;
					if (dir == Direction.SOUTH) this.motionZ += 2.8;
					if (dir == Direction.EAST) this.motionX += 2.8;
					if (dir == Direction.WEST) this.motionX -= 2.8;
					this.rotationPitch += 180;
				}
				else
				{
					if (dir == Direction.NORTH) this.motionZ -= 3.3;
					if (dir == Direction.SOUTH) this.motionZ += 3.3;
					if (dir == Direction.EAST) this.motionX += 3.3;
					if (dir == Direction.WEST) this.motionX -= 3.3;
					this.rotationPitch += 180;
				}
				this.ticksBeforeSoru = 40;
			}
			else
				this.ticksBeforeSoru--;
		}
		
		super.onUpdate();
	}
}
