package xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives.IQuestObjective;

public class BanditData extends EntityNewMob implements IQuestObjective
{
	protected EntityAIBase entityAIMeleeAttack = new EntityAIAttackOnCollide(this, 1.0D, false);
	private EntityAIBase entityAIAttackNonMarine = new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true);
	private EntityPlayer owner;
	private boolean active = false;
	
	public BanditData(World world)
	{
		this(world, null);
	}
	
	public BanditData(World world, String[] textures) 
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
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, PirateData.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, MarineData.class, 0, true));
	}
  
	@Override
	public void onEntityUpdate() 
	{
		if(this.getAttackTarget() == null)
		{
			this.targetTasks.removeTask(entityAIAttackNonMarine);
			for(EntityLivingBase target : WyHelper.getEntitiesNear(this, 20))
			{	
				if(target instanceof EntityPlayer)
				{
					EntityPlayer targetP = (EntityPlayer) target;
					ExtendedEntityData props = ExtendedEntityData.get(targetP);
	
					this.setTarget(targetP);
					this.targetTasks.addTask(1, entityAIAttackNonMarine);
				}
			}
		}
		
		super.onEntityUpdate();
	}

	@Override
	protected boolean isValidLightLevel()
	{return true;} 
    
	@Override
	protected boolean canDespawn()
	{return true;}
    
	@Override
	public boolean isAIEnabled()
	{return true;}
	
	@Override
	public boolean getCanSpawnHere()
	{return true;}
		
	@Override
	public void setOwner(EntityPlayer player)
	{
		this.owner = player;
	}
	
	@Override
	public EntityPlayer getOwner()
	{
		return this.owner;
	}

	@Override
	public boolean isActive()
	{
		return this.active;
	}

	@Override
	public void setActive(boolean active)
	{
		this.active = active;
	}
}

