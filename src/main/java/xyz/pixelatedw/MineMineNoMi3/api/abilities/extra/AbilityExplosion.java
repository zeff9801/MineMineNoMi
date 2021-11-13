package xyz.pixelatedw.MineMineNoMi3.api.abilities.extra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class AbilityExplosion
{

	private World worldObj;
	private Entity exploder;
	private double explosionX;
	private double explosionY;
	private double explosionZ;
	private double explosionSize;
	private String smokeParticles = ID.PARTICLEFX_COMMONEXPLOSION;

	private int explosionGrab = 16;
	public List affectedBlockPositions = new ArrayList();

	private boolean canStartFireAfterExplosion = false;
	private boolean canDestroyBlocks = true;
	private boolean canDropBlocksAfterExplosion = false;
	private boolean canDamageEntities = true;
	private boolean canDamageOwner = true;
	private boolean canProduceExplosionSound = true;
	
	public AbilityExplosion(Entity entity, double posX, double posY, double posZ, double power)
	{
		this.worldObj = entity.worldObj;
		this.exploder = entity;
		this.explosionSize = power;
		this.explosionX = posX;
		this.explosionY = posY;
		this.explosionZ = posZ;
	}

	public void setDamageOwner(boolean damageOwner)
	{
		this.canDamageOwner = damageOwner;
	}

	public void setDamageEntities(boolean damageEntities)
	{
		this.canDamageEntities = damageEntities;
	}

	public void setDropBlocksAfterExplosion(boolean canDrop)
	{
		this.canDropBlocksAfterExplosion = canDrop;
	}

	public void setFireAfterExplosion(boolean hasFire)
	{
		this.canStartFireAfterExplosion = hasFire;
	}

	public void setDestroyBlocks(boolean canDestroyBlocks)
	{
		this.canDestroyBlocks = canDestroyBlocks;
	}

	public void setSmokeParticles(String particle)
	{
		this.smokeParticles = particle;
	}

	public boolean hasSmokeParticles()
	{
		return !this.smokeParticles.isEmpty();
	}
	
	public void setExplosionSound(boolean hasSound)
	{
		this.canProduceExplosionSound = hasSound;
	}


	public void doExplosion()
	{
		// Gather data about the blocks that are about to be "exploded"
		HashSet blocksData = new HashSet();
		double newExplosionPosX;
		double newExplosionPosY;
		double newExplosionPosZ;

		for (int i = 0; i < this.explosionGrab; ++i)
		{
			for (int j = 0; j < this.explosionGrab; ++j)
			{
				for (int k = 0; k < this.explosionGrab; ++k)
				{
					if (i == 0 || i == this.explosionGrab - 1 || j == 0 || j == this.explosionGrab - 1 || k == 0 || k == this.explosionGrab - 1)
					{
						double d0 = i / (this.explosionGrab - 1.0F) * 2.0F - 1.0F;
						double d1 = j / (this.explosionGrab - 1.0F) * 2.0F - 1.0F;
						double d2 = k / (this.explosionGrab - 1.0F) * 2.0F - 1.0F;
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 /= d3;
						d1 /= d3;
						d2 /= d3;
						double f1 = this.explosionSize * (0.7F + this.worldObj.rand.nextDouble() * 0.6F);
						newExplosionPosX = this.explosionX;
						newExplosionPosY = this.explosionY;
						newExplosionPosZ = this.explosionZ;

						for (float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F)
						{
							int j1 = MathHelper.floor_double(newExplosionPosX);
							int k1 = MathHelper.floor_double(newExplosionPosY);
							int l1 = MathHelper.floor_double(newExplosionPosZ);
							Block block = this.worldObj.getBlock(j1, k1, l1);

							if (block.getMaterial() != Material.air)
							{
								float f3 = (float) (block.getExplosionResistance(this.exploder, worldObj, j1, k1, l1, explosionX, explosionY, explosionZ) / 1.25);
								f1 -= (f3 + 0.1F) * f2;
							}

							if (f1 > 0.0F)
								blocksData.add(new ChunkPosition(j1, k1, l1));

							newExplosionPosX += d0 * f2;
							newExplosionPosY += d1 * f2;
							newExplosionPosZ += d2 * f2;
						}
					}
				}
			}
		}
		this.affectedBlockPositions.addAll(blocksData);

		// Destroying the blocks, damaging entities and spawning particles if
		// necessary
		Iterator iterator;
		ChunkPosition chunkposition;
		int posX, posY, posZ;
		Block block;

		if(this.canProduceExplosionSound)
			this.worldObj.playSoundEffect(this.explosionX, this.explosionY, this.explosionZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
		
		if (this.canDamageEntities)
		{
			for (EntityLivingBase entity : WyHelper.getEntitiesNear((int) this.explosionX, (int) this.explosionY, (int) this.explosionZ, this.worldObj, this.explosionSize * 1.5, EntityLivingBase.class))
			{
				if (!canDamageOwner && entity == this.exploder)
					continue;
					
				newExplosionPosX = entity.posX - this.explosionX;
				newExplosionPosY = entity.posY + entity.getEyeHeight() - this.explosionY;
				newExplosionPosZ = entity.posZ - this.explosionZ;

				Vec3 vec3 = Vec3.createVectorHelper(this.explosionX, this.explosionY, this.explosionZ);
				double d4 = entity.getDistance(this.explosionX, this.explosionY, this.explosionZ) / this.explosionSize;
				double d10 = this.worldObj.getBlockDensity(vec3, entity.boundingBox);
                double d11 = (1.0D - d4) * d10;
                float damage = ((int)((d11 * d11 + d11) / 2.0D * 8.0D * this.explosionSize + 1.0D));

                DamageSource damageSource;
                float damageMultiplier = 1;
                
                if(this.exploder instanceof EntityLivingBase)
                {
	                damageSource = DamageSource.causeMobDamage((EntityLivingBase) this.exploder);
	                damageMultiplier = ExtendedEntityData.get((EntityLivingBase) this.exploder).getDamageMultiplier();
                }
                else
	                damageSource = DamageSource.magic;
                	
                entity.attackEntityFrom(this.setExplosionSource(this), damage * damageMultiplier);
			}
		}

		if (this.canDestroyBlocks && MainConfig.enableGriefing)
		{
			iterator = this.affectedBlockPositions.iterator();

			while (iterator.hasNext())
			{
				chunkposition = (ChunkPosition) iterator.next();
				posX = chunkposition.chunkPosX;
				posY = chunkposition.chunkPosY;
				posZ = chunkposition.chunkPosZ;
				block = this.worldObj.getBlock(posX, posY, posZ);

				if (block != null && block.getMaterial() != Material.air) //&& block != ListMisc.KairosekiOre && block != ListMisc.KairosekiBlock)
				{
					block.dropBlockAsItemWithChance(this.worldObj, posX, posY, posZ, this.worldObj.getBlockMetadata(posX, posY, posZ), 0, 0);
					this.worldObj.setBlockToAir(posX, posY, posZ);
				}
			}			
		}
		
		if (this.hasSmokeParticles())
			WyNetworkHelper.sendToAllAround(new PacketParticles(this.smokeParticles, this.explosionX, this.explosionY, this.explosionZ), this.exploder.dimension, this.explosionX, this.explosionY, this.explosionZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);

		if (this.canStartFireAfterExplosion && MainConfig.enableGriefing)
		{
			iterator = this.affectedBlockPositions.iterator();

			while (iterator.hasNext())
			{
				chunkposition = (ChunkPosition) iterator.next();
				posX = chunkposition.chunkPosX;
				posY = chunkposition.chunkPosY;
				posZ = chunkposition.chunkPosZ;
				block = this.worldObj.getBlock(posX, posY, posZ);
				Block blockUnder = this.worldObj.getBlock(posX, posY - 1, posZ);

				if (block.getMaterial() == Material.air && blockUnder.func_149730_j() && this.worldObj.rand.nextInt(3) == 0)
				{
					this.worldObj.setBlock(posX, posY, posZ, Blocks.fire);
				}
			}
		}
	}
	
    public DamageSource setExplosionSource(AbilityExplosion explosion)
    {
        return explosion != null && explosion.exploder != null ? (new EntityDamageSource("explosion.player", explosion.exploder)).setDifficultyScaled().setExplosion() : (new DamageSource("explosion")).setDifficultyScaled().setExplosion();
    }
}
