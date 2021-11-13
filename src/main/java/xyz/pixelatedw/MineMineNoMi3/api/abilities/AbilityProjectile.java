package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;

public class AbilityProjectile extends EntityThrowable
{
	public int ticks, maxticks;
	private AbilityAttribute attr;
	private EntityLivingBase user;
	public float gravity = 0.001F;

	public AbilityProjectile(World world)
	{
		super(world);
	}

	public AbilityProjectile(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}

	public AbilityProjectile(World world, EntityLivingBase player, AbilityAttribute attr)
	{
		super(world, player);
		this.attr = attr;
		this.ticks = attr.getProjectileTicks();
		this.maxticks = ticks;
		this.user = player;
		
		if(this.getThrower() != null && this.getThrower() instanceof EntityPlayer && DevilFruitsHelper.checkForRestriction((EntityPlayer) this.getThrower()))
			this.setDead();
		
		if (this.attr != null)
		{
			this.setLocationAndAngles(this.user.posX, this.user.posY + this.user.getEyeHeight(), this.user.posZ, this.user.rotationYaw, this.user.rotationPitch);
			this.motionX = -MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI) * 0.4;
			this.motionZ = MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI) * 0.4;
			this.motionY = -MathHelper.sin((this.rotationPitch + this.func_70183_g()) / 180.0F * (float) Math.PI) * 0.4;
			this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, attr.getProjectileSpeed(), 1.0F);
		}

	}

	public AbilityAttribute getAttribute()
	{
		return this.attr;
	}

	public void tasksImapct(MovingObjectPosition hit)
	{
	};

	@Override
	public void onEntityUpdate()
	{	
		if (this.attr != null)
		{
			if (ticks <= 0)
			{
				ticks = maxticks;
				this.setDead();
			}
			else
				ticks--;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(this.attr != null)
		{
			Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
			vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			
			double sizeX = this.attr.getProjectileCollisionSizes()[0];
			double sizeY = this.attr.getProjectileCollisionSizes()[1];
			double sizeZ = this.attr.getProjectileCollisionSizes()[2];
			
			Entity entity = null;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(sizeX, sizeY, sizeZ));
			double d0 = 0.0D;
			int i;
			float f1;
			
			for (i = 0; i < list.size(); ++i)
			{
				Entity entity1 = (Entity) list.get(i);
				
				if (entity1.canBeCollidedWith() && (entity1 != this.getThrower() || this.ticksExisted >= 5))
				{
					AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(sizeX, sizeY, sizeZ);
					MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);
					
					if (movingobjectposition1 != null)
					{
						double d1 = vec31.distanceTo(movingobjectposition1.hitVec);
						
						if (d1 < d0 || d0 == 0.0D)
						{
							entity = entity1;
							d0 = d1;
						}
					}
				}
			}
			
			if (entity != null)
				movingobjectposition = new MovingObjectPosition(entity);
			
			if (movingobjectposition != null && movingobjectposition.entityHit != null)
				this.onImpact(movingobjectposition);
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition hit)
	{
		if (!this.worldObj.isRemote)
		{
			if (this.attr != null)
			{
				if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
				{
					ExtendedEntityData props = ExtendedEntityData.get(this.getThrower());
					ExtendedEntityData propz = ExtendedEntityData.get((EntityLivingBase) hit.entityHit);

					if(propz.isLogia() && this.getAttribute().isProjectilePhysical() && !props.hasBusoHakiActive())
						return;
						
					if (this.attr.getPotionEffectsForProjectile() != null)
						for (PotionEffect p : this.attr.getPotionEffectsForProjectile())
							((EntityLivingBase) hit.entityHit).addPotionEffect(new PotionEffect(p));

					if (this.attr.getProjectileExplosionPower() > 0)
					{
						AbilityExplosion explosion = WyHelper.newExplosion(this.getThrower(), this.posX, this.posY, this.posZ, this.attr.getProjectileExplosionPower());
						explosion.setDamageOwner(false);
						explosion.setFireAfterExplosion(this.attr.canProjectileExplosionSetFire());
						explosion.setDestroyBlocks(this.attr.canProjectileExplosionDestroyBlocks());
						explosion.doExplosion();
					}

					if (this.attr.getProjectileDamage() > 0)
						hit.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.attr.getProjectileDamage() * props.getDamageMultiplier());
					
					tasksImapct(hit);

					this.setDead();
				}
				else
				{
					if (this.attr.getProjectileExplosionPower() > 0)
					{
						AbilityExplosion explosion = WyHelper.newExplosion(this.getThrower(), this.posX, this.posY, this.posZ, this.attr.getProjectileExplosionPower());
						explosion.setDamageOwner(false);
						explosion.setFireAfterExplosion(this.attr.canProjectileExplosionSetFire());
						explosion.setDestroyBlocks(this.attr.canProjectileExplosionDestroyBlocks());
						explosion.doExplosion();
					}

					tasksImapct(hit);

					Material hitMat = this.worldObj.getBlock(hit.blockX, hit.blockY, hit.blockZ).getMaterial();

					if (!this.attr.canProjectileMoveThroughBlocks() && (hitMat != Material.plants && hitMat != Material.vine && hitMat != Material.water))
						this.setDead();
				}
			}
			else
				this.setDead();
		}
	}

	@Override
	protected float getGravityVelocity()
	{
		return gravity;
	}

}