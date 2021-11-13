package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.BanditData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;

public class PirateData extends EntityNewMob
{
	protected EntityAIBase entityAIMeleeAttack = new EntityAIAttackOnCollide(this, 1.0D, false);
	protected EntityAIBase entityAINonCrewPlayers = new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true);
	
	public PirateData(World world)
	{
		this(world, null);
	}
	
	public PirateData(World world, String[] textures) 
	{
		super(world, textures);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, entityAIMeleeAttack);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, MarineData.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, BanditData.class, 0, true));
	}

	@Override
	public void onEntityUpdate() 
	{
		if(this.getAttackTarget() == null)
		{
			this.targetTasks.removeTask(this.entityAINonCrewPlayers);
			for(EntityLivingBase target : WyHelper.getEntitiesNear(this, 20))
			{	
				if(target instanceof EntityPlayer)
				{
					EntityPlayer targetP = (EntityPlayer) target;
					ExtendedEntityData props = ExtendedEntityData.get(targetP);
									
					if(props.getCrew().equals(this.getCrew()))
						break;
									
					this.setTarget(targetP);
					this.targetTasks.addTask(1, this.entityAINonCrewPlayers);
				}
			}
		}
		
		super.onEntityUpdate();
	}

	
	@Override
	protected boolean isValidLightLevel() { return true; }

	@Override
	protected boolean canDespawn() { return true; }

	@Override
	public boolean isAIEnabled() { return true; }

	@Override
	public boolean getCanSpawnHere() { return true; }

	public String getCrew() { return "null"; }
}
