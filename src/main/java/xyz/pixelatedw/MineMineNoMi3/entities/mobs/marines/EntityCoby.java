package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;

public class EntityCoby extends MarineData
{
	private int ticksBeforeSoru = 60, ticksBeforeGeppo = 100;
	
	public EntityCoby(World world)
	{
		super(world);
	}
	
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.63D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
	}

	public void onUpdate() 
	{
		Direction dir = WyHelper.get4Directions(this);
		
		if(this.getAttackTarget() != null)
		{
			
			if(this.getHealth() < this.getMaxHealth()/2)
				this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10);
			
			if(ticksBeforeSoru <= 0 && this.getDistanceSqToEntity(this.getAttackTarget()) < 180 && this.onGround)
			{
				if(this.getHealth() < this.getMaxHealth()/2)
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
				this.ticksBeforeSoru = 60;
			}
			else
				this.ticksBeforeSoru--;
		}
		
		super.onUpdate();
	}
	
}
