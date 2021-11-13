package xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.lapahn.EntityAILapahnJump;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.lapahn.EntityAILapahnRage;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.BanditData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;

import java.util.UUID;

public class EntityLapahn extends EntityNewMob
{
	private UUID rageModeUUID = UUID.randomUUID();
	private AttributeModifier rageModeModifier = new AttributeModifier(rageModeUUID, "Rage Mode", 10, 0);
	private boolean isEnraged;

	public EntityLapahn(World world)
	{
		super(world);

		this.setSize(0.8F, 2.5F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(0, new EntityAILapahnJump(this));
		this.tasks.addTask(0, new EntityAILapahnRage(this));
		this.tasks.addTask(1, new EntityAILookIdle(this));
		this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, PirateData.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, BanditData.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, MarineData.class, 0, true));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
	}

	@Override
	public void onEntityUpdate()
	{
		super.onEntityUpdate();
		if (!this.worldObj.isRemote)
		{

		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);

		nbt.setBoolean("IsEnraged", this.isEnraged);
	}

	@Override
	public void readEntityFromExtraNBT(NBTTagCompound nbt)
	{
		this.readEntityFromNBT(nbt);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);

		this.isEnraged = nbt.getBoolean("IsEnraged");
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	public boolean isEnraged()
	{
		return this.isEnraged;
	}

	public void setEnraged(boolean value)
	{
		this.isEnraged = value;
		IAttributeInstance attackAttribute = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
		if (value && attackAttribute.getModifier(this.rageModeUUID) == null)
			attackAttribute.applyModifier(rageModeModifier);
		else if (!value && attackAttribute.getModifier(this.rageModeUUID) != null)
			attackAttribute.removeModifier(rageModeModifier);
	}

	@Override
	protected void dropFewItems(boolean flag, int looting)
	{
        int j = (int) (2 + WyMathHelper.randomWithRange(3 + looting, 5 + looting));

		for (int k = 0; k < j; ++k)
		{
			if (this.isBurning())
				this.dropItem(Items.cooked_beef, 1);
			else
				this.dropItem(Items.beef, 1);
		}
	}

	@Override
	protected boolean canDespawn()
	{
		return true;
	}

	@Override
	public void fall(float distance)
	{
		if (distance > 5)
		{
			if (this.worldObj.isRemote)
			{
				for (int i = 0; i < 256; i++)
				{
					double posX = this.posX + WyMathHelper.randomWithRange(-5, 5) + WyMathHelper.randomDouble();
					double posZ = this.posZ + WyMathHelper.randomWithRange(-5, 5) + WyMathHelper.randomDouble();

					this.worldObj.spawnParticle("explode", posX, this.posY + 0.5, posZ, 0, 0.1, 0);
					this.worldObj.spawnParticle("smoke", posX, this.posY + 0.5, posZ, 0, 0.1, 0);
				}
			}

			for (EntityLivingBase entity : WyHelper.getEntitiesNear(this, 5))
			{
				if (!(entity instanceof EntityLapahn))
				{
					entity.attackEntityFrom(DamageSource.causeMobDamage(this), 6);
					entity.motionY = 0.5;
				}
			}
		}
	}
}
