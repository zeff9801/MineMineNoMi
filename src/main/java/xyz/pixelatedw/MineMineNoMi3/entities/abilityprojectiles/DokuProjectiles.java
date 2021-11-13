package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles.EntityCloud;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

import java.util.ArrayList;
import java.util.Random;

public class DokuProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {ChloroBall.class, ListAttributes.CHLORO_BALL});
		abilitiesClassesArray.add(new Object[] {Hydra.class, ListAttributes.HYDRA});
		abilitiesClassesArray.add(new Object[] {VenomRoad.class, ListAttributes.VENOM_ROAD});
	}
		
	public static class VenomRoad extends AbilityProjectile
	{
		public VenomRoad(World world)
		{super(world);}
		
		public VenomRoad(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public VenomRoad(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}	
		
		public void tasksImapct(MovingObjectPosition hit)
		{		
			if(hit != null && !worldObj.isRemote)
			{
				int x;
				int y;
				int z;
				
				if(hit.entityHit == null)
				{
					x = hit.blockX;
					y = hit.blockY;
					z = hit.blockZ;	
				}
				else
				{
					x = (int) hit.entityHit.posX;
					y = (int) hit.entityHit.posY;
					z = (int) hit.entityHit.posZ;	
				}
				
				if (this.getThrower().isRiding())
					this.getThrower().mountEntity(null);
				EnderTeleportEvent event = new EnderTeleportEvent(this.getThrower(), x, y, z, 5.0F);
				this.getThrower().setPositionAndUpdate(event.targetX, event.targetY + 1, event.targetZ);
				this.getThrower().fallDistance = 0.0F;
			}
		}
	}
	
	public static class ChloroBall extends AbilityProjectile
	{
		public ChloroBall(World world)
		{super(world);}
		
		public ChloroBall(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public ChloroBall(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}	
		
		public void tasksImapct(MovingObjectPosition hit)
		{	
			if(MainConfig.enableGriefing)
			{
				for (int i = 0; i < 20; i++)
				{
					double offsetX = new Random().nextInt(5) - 3;
					double offsetZ = new Random().nextInt(5) - 3;
					
					DevilFruitsHelper.placeBlockIfAllowed(worldObj, (int)(this.posX + offsetX), (int)this.posY, (int)(this.posZ + offsetZ), ListMisc.Poison, "air", "foliage");
				}
				
				AbilityExplosion explosion = WyHelper.newExplosion(this.getThrower(), this.posX, this.posY, this.posZ, 2.2);
				explosion.setExplosionSound(false);
				explosion.setDestroyBlocks(false);
				explosion.setSmokeParticles(ID.PARTICLEFX_CHLOROBALL);
				explosion.setDamageOwner(false);
				explosion.doExplosion();
				
				EntityChloroBallCloud smokeCloud = new EntityChloroBallCloud(worldObj);
				smokeCloud.setLife(30);
				smokeCloud.setLocationAndAngles(this.posX, (this.posY + 1), this.posZ, 0, 0);
				smokeCloud.motionX = 0;
				smokeCloud.motionZ = 0;
				smokeCloud.motionY = 0;	
				smokeCloud.setThrower((EntityPlayer) this.getThrower());
				this.worldObj.spawnEntityInWorld(smokeCloud);
			}
		}
		
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				double posXOffset = this.worldObj.rand.nextGaussian() * 0.42D;
				double posYOffset = this.worldObj.rand.nextGaussian() * 0.22D;
				double posZOffset = this.worldObj.rand.nextGaussian() * 0.42D;		
	
				EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_DOKU, 
						posX + posXOffset, 
						posY + posYOffset, 
						posZ + posZOffset, 
						0, 0, 0)
						.setParticleAge(6).setParticleScale(1.7F);
				
				MainMod.proxy.spawnCustomParticles(this, particle);		
			}
			super.onUpdate();
		}
	}
	
	public static class EntityChloroBallCloud extends EntityCloud
	{
		public EntityChloroBallCloud(World world)
		{
			super(world);
		}
		
		public void onUpdate()
		{
			super.onUpdate();
			if(!this.worldObj.isRemote)
			{				
				for(EntityLivingBase target : WyHelper.getEntitiesNear(this, 4))
					target.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 2));
			}
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_CHLOROBALLCLOUD, this.posX, this.posY, this.posZ), this.dimension, this.posX, this.posY, this.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		}
	}
	
	public static class Hydra extends AbilityProjectile
	{
		public Hydra(World world)
		{super(world);}
		
		public Hydra(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Hydra(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}	
	}
	
}
