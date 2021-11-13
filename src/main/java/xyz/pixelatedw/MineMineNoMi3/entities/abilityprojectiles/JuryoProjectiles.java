package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class JuryoProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {SagariNoRyusei.class, ListAttributes.SAGARI_NO_RYUSEI});
		abilitiesClassesArray.add(new Object[] {Moko.class, ListAttributes.MOKO});
	}
	
	public static class Moko extends AbilityProjectile
	{
		public Moko(World world)
		{super(world);}
		
		public Moko(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Moko(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void onUpdate()
		{
			if(this.worldObj.isRemote)
			{
				double posXOffset = this.worldObj.rand.nextGaussian() * 0.52D;
				double posYOffset = this.worldObj.rand.nextGaussian() * 0.52D;
				double posZOffset = this.worldObj.rand.nextGaussian() * 0.52D;		
		
				EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GASU, 
						posX + posXOffset, 
						posY + posYOffset, 
						posZ + posZOffset, 
						0, 0, 0)
						.setParticleAge(20).setParticleScale(0.7F);
					
				MainMod.proxy.spawnCustomParticles(this, particle);	
			}
			super.onUpdate();
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				for(int x = -1; x < 1; x++)
				for(int z = -1; z < 1; z++)
				{
					int posX = (int)hit.entityHit.posX + x;
					int posY = (int)hit.entityHit.posY - 1;
					int posZ = (int)hit.entityHit.posZ + z;
					
					if(DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, posX, posY, posZ, Blocks.air, "all", "restricted", "ignore liquid"))
					{
						hit.entityHit.motionX = 0;
						hit.entityHit.motionZ = 0;
						hit.entityHit.motionY -= 5;
						((EntityLivingBase) hit.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 10));
					}
				}
			}
			else
			{
				DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, hit.blockX, hit.blockY, hit.blockZ, Blocks.air, "all", "restricted", "ignore liquid");
			}
		}
	}
	
	/**FORGOLD Some particle effects, maybe some dark smoke */
	public static class SagariNoRyusei extends AbilityProjectile
	{
		public SagariNoRyusei(World world)
		{super(world);}
		
		public SagariNoRyusei(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public SagariNoRyusei(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
}
