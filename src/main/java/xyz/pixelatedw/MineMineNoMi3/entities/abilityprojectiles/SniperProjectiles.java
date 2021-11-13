package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles.EntityCloud;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

import java.util.ArrayList;

public class SniperProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {KaenBoshi.class, ListAttributes.KAEN_BOSHI});
		abilitiesClassesArray.add(new Object[] {KemuriBoshi.class, ListAttributes.KEMURI_BOSHI});
		abilitiesClassesArray.add(new Object[] {RenpatsuNamariBoshi.class, ListAttributes.RENPATSU_NAMARI_BOSHI});
		abilitiesClassesArray.add(new Object[] {SakuretsuSabotenBoshi.class, ListAttributes.SAKURETSU_SABOTEN_BOSHI});

	}
	
	public static class SakuretsuSabotenBoshi extends AbilityProjectile
	{
		public SakuretsuSabotenBoshi(World world)
		{super(world);}
		
		public SakuretsuSabotenBoshi(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public SakuretsuSabotenBoshi(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			for(int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(8); i++)
			{
				int a1 = worldObj.rand.nextInt(10) - 5;
				int a2 = worldObj.rand.nextInt(10) - 5;
				
				DevilFruitsHelper.placeBlockIfAllowed(worldObj, (int)posX + a1, (int)posY - 3 , (int)posZ + a2, Blocks.cactus, 2, "air");
				DevilFruitsHelper.placeBlockIfAllowed(worldObj, (int)posX + a1, (int)posY - 2 , (int)posZ + a2, Blocks.cactus, 2, "air");	
				DevilFruitsHelper.placeBlockIfAllowed(worldObj, (int)posX + a1, (int)posY - 1 , (int)posZ + a2, Blocks.cactus, 2, "air");	
				DevilFruitsHelper.placeBlockIfAllowed(worldObj, (int)posX + a1, (int)posY , (int)posZ + a2, Blocks.cactus, 2, "air");		
				DevilFruitsHelper.placeBlockIfAllowed(worldObj, (int)posX + a1, (int)posY + 1, (int)posZ + a2, Blocks.cactus, 2, "air");		
				DevilFruitsHelper.placeBlockIfAllowed(worldObj, (int)posX + a1, (int)posY + 2, (int)posZ + a2, Blocks.cactus, 2, "air");	
			}
		}
	}
	
	public static class RenpatsuNamariBoshi extends AbilityProjectile
	{
		public RenpatsuNamariBoshi(World world)
		{super(world);}
		
		public RenpatsuNamariBoshi(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public RenpatsuNamariBoshi(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
	public static class KemuriBoshi extends AbilityProjectile
	{
		public KemuriBoshi(World world)
		{super(world);}
		
		public KemuriBoshi(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public KemuriBoshi(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}

		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			EntityKemuriBoshiCloud smokeCloud = new EntityKemuriBoshiCloud(worldObj);
			smokeCloud.setLife(100);
			smokeCloud.setLocationAndAngles(this.posX, (this.posY + 1), this.posZ, 0, 0);
			smokeCloud.motionX = 0;
			smokeCloud.motionZ = 0;
			smokeCloud.motionY = 0;	
			smokeCloud.setThrower((EntityPlayer) this.getThrower());
			this.worldObj.spawnEntityInWorld(smokeCloud);		
		}	
	}
	
	public static class EntityKemuriBoshiCloud extends EntityCloud
	{
		public EntityKemuriBoshiCloud(World world)
		{
			super(world);
		}
		
		@Override
		public void onUpdate()
		{
			super.onUpdate();
			if(!this.worldObj.isRemote)
			{				
				for(EntityLivingBase target : WyHelper.getEntitiesNear(this, 5))
					target.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
			}
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KEMURIBOSHI, this.posX, this.posY, this.posZ), this.dimension, this.posX, this.posY, this.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		}
	}
	
	public static class KaenBoshi extends AbilityProjectile
	{
		public KaenBoshi(World world)
		{super(world);}
		
		public KaenBoshi(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public KaenBoshi(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{								
			this.setFire(999);
			super.onUpdate();
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
			{
				hit.entityHit.setFire(100);
			}
		}	
	}
}
