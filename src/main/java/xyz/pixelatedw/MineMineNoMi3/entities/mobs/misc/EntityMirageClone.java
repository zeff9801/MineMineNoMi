package xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EntityMirageClone extends EntityMob
{	
	private EntityPlayer owner;
	
	public EntityMirageClone(World worldIn, EntityPlayer owner) 
	{ 
		this(worldIn);
		this.setOwner(owner);
	    this.tasks.addTask(1, new EntityAISwimming(this));
	    this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
	    this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
	    this.tasks.addTask(4, new EntityAIPanic(this, 1.5));	    
	}

	public EntityMirageClone(World worldIn) 
	{
		super(worldIn); 
	}

	@Override
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
	}
    
	@Override
	public boolean isAIEnabled()
	{return true;}
    
	@Override
	public void setDead()
	{
		if(!this.worldObj.isRemote)
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KEMURIBOSHI, this.posX, this.posY, this.posZ), this.dimension, this.posX, this.posY, this.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		super.setDead();
	}
	
	@Override
	public void onEntityUpdate()
	{
		if(!this.worldObj.isRemote && this.owner == null)
			this.setDead();

	    this.setRevengeTarget(this.owner);
		
		if(this.ticksExisted > 200)
			this.setDead();
		
		super.onEntityUpdate();
	}

	private void setOwner(EntityPlayer player) {this.owner = player;}
	public EntityPlayer getOwner() {return this.owner;}

}
