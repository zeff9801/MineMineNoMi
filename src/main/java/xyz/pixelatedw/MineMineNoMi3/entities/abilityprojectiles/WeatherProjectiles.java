package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles.EntityCloud;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WeatherProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();

	static
	{
		abilitiesClassesArray.add(new Object[] {HeatBall.class, ListAttributes.HEAT_BALL});
		abilitiesClassesArray.add(new Object[] {CoolBall.class, ListAttributes.COOL_BALL});
		abilitiesClassesArray.add(new Object[] {ThunderBall.class, ListAttributes.THUNDER_BALL});
		abilitiesClassesArray.add(new Object[] {GustSword.class, ListAttributes.GUST_SWORD});
		abilitiesClassesArray.add(new Object[] {WeatherEgg.class, ListAttributes.WEATHER_EGG});
		
		abilitiesClassesArray.add(new Object[] {EntityWeatherCloud.class, ListExtraAttributes.WEATHER_CLOUD});
	}
	
	public static class WeatherEgg extends WeatherBall
	{
		public WeatherEgg(World world)
		{super(world);}
		
		public WeatherEgg(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public WeatherEgg(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);
			this.weaponUsed = player.getHeldItem() != null ? player.getHeldItem().getItem() : null;
		}
		
		@Override
		public void setDead()
		{
			if(!this.worldObj.isRemote)
			{
				EntityWeatherCloud weatherCloud = new EntityWeatherCloud(worldObj);
				weatherCloud.setLife(200);
				weatherCloud.setThrower((EntityPlayer) this.getThrower());
				weatherCloud.setPositionAndRotation(this.posX, this.posY, this.posZ, 0, 0);
				this.worldObj.spawnEntityInWorld(weatherCloud);
			}
			super.setDead();
		}
	}
	
	public static class GustSword extends AbilityProjectile
	{
		public GustSword(World world)
		{super(world);}
		
		public GustSword(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public GustSword(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);
		}
		
		@Override
		public void onUpdate()
		{
			if(this.worldObj.isRemote)
			{
				for(int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(5); i++)
				{
					double offsetX = WyMathHelper.randomDouble() / 4;
					double offsetY = WyMathHelper.randomDouble() / 4;
					double offsetZ = WyMathHelper.randomDouble() / 4;
				    
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU2, 
							posX + offsetX, 
							posY + offsetY, 
							posZ + offsetZ, 
							0, 0.01F, 0)
							.setParticleAge(2).setParticleScale(1F);
					particle.setAlphaF(0.5F);
					MainMod.proxy.spawnCustomParticles(this, particle);
					
					particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU, 
							posX + offsetX, 
							posY + offsetY, 
							posZ + offsetZ, 
							0, 0.01F, 0)
							.setParticleAge(2).setParticleScale(1F);
					particle.setAlphaF(0.7F);
					MainMod.proxy.spawnCustomParticles(this, particle);
				}
			}

			super.onUpdate();
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				double mX = -MathHelper.sin(this.getThrower().rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.getThrower().rotationPitch / 180.0F * (float)Math.PI) * 0.4;
				double mZ = MathHelper.cos(this.getThrower().rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.getThrower().rotationPitch / 180.0F * (float)Math.PI) * 0.4;
					
				double f2 = MathHelper.sqrt_double(mX * mX + this.getThrower().motionY * this.getThrower().motionY + mZ * mZ);
				mX /= f2;
				mZ /= f2;
				mX += this.getThrower().worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mZ += this.getThrower().worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mX *= 2;
				mZ *= 2;
				
				hit.entityHit.motionX = mX;
				hit.entityHit.motionZ = mZ;
			}
		}
	}
	
	public static class ThunderBall extends WeatherBall
	{
		public ThunderBall(World world)
		{super(world);}
		
		public ThunderBall(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public ThunderBall(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);
			this.weaponUsed = player.getHeldItem() != null ? player.getHeldItem().getItem() : null;
		}
	}
	
	public static class CoolBall extends WeatherBall
	{
		public CoolBall(World world)
		{super(world);}
		
		public CoolBall(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public CoolBall(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);
			this.weaponUsed = player.getHeldItem() != null ? player.getHeldItem().getItem() : null;
		}
		
		@Override
		public void onUpdate()
		{
			super.onUpdate();
			if(!this.worldObj.isRemote)
			{
				List weatherBallsNear = WyHelper.getEntitiesNear(this, new double[] {4, 1, 4}, WeatherBall.class);
				if(!weatherBallsNear.isEmpty() && this.ticksExisted > 100)
				{
					List<HeatBall> heatBalls = (List<HeatBall>) weatherBallsNear.stream().filter(x ->
					{
						WeatherBall ball = (WeatherBall)x;
						
						return ball instanceof HeatBall;
					}).collect(Collectors.toList());

					if(!heatBalls.isEmpty())
					{
						EntityWeatherCloud weatherCloud = new EntityWeatherCloud(worldObj);
						weatherCloud.setThrower((EntityPlayer) this.getThrower());
						weatherCloud.setPositionAndRotation(this.posX, this.posY, this.posZ, 0, 0);
						weatherCloud.addWeatherBall(this);
						
						for(HeatBall hb : heatBalls)
						{
							weatherCloud.addWeatherBall(hb);
							hb.setDead();
						}
						
						this.worldObj.spawnEntityInWorld(weatherCloud);
						if(this.getThrower() != null)
							DevilFruitsHelper.sendShounenScream((EntityPlayer) this.getThrower(), "Thunderbolt Tempo", 0);
						
						this.setDead();
					}
				}
			}
		}
	}
	
	public static class HeatBall extends WeatherBall
	{		
		public HeatBall(World world)
		{super(world);}
		
		public HeatBall(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public HeatBall(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
			this.weaponUsed = player.getHeldItem() != null ? player.getHeldItem().getItem() : null;
		}
	}
	
	public static class WeatherBall extends AbilityProjectile
	{
		protected Item weaponUsed;
		
		public WeatherBall(World world)
		{super(world);}
		
		public WeatherBall(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public WeatherBall(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{
			super.onUpdate();

			this.motionX /= 1.5;
			this.motionZ /= 1.5;
			if(this.ticksExisted < 100)
				this.motionY = 0.25;
			else
				this.motionY = 0;
		}

		public Item getWeaponUsed()
		{
			return this.weaponUsed;
		}
	}
	
	public static class EntityMirageTempoCloud extends EntityCloud
	{
		public EntityMirageTempoCloud(World world)
		{
			super(world);
		}
		
		@Override
		public void onUpdate()
		{
			super.onUpdate();
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KEMURIBOSHI, this.posX, this.posY, this.posZ), this.dimension, this.posX, this.posY, this.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		}
	}
	
	public static class EntityWeatherCloud extends Entity
	{
		private int life = 300;
		private EntityPlayer thrower;
		private final List<WeatherBall> weatherBalls = new ArrayList<WeatherBall>();
		private boolean charged = false;
		private boolean superCharged = false;
		
		public EntityWeatherCloud(World world)
		{
			super(world);
		}
		
		@Override
		public void onUpdate()
		{
			if(this.worldObj.isRemote)
			{
				for(int i = 0; i < 100; i++)
				{
					double offsetX = WyMathHelper.randomWithRange(-12, 12) + (WyMathHelper.randomDouble() * 7);
					double offsetY = WyMathHelper.randomWithRange(-2, 0) + WyMathHelper.randomDouble();
					double offsetZ = WyMathHelper.randomWithRange(-12, 12) + (WyMathHelper.randomDouble() * 7);
					    
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GORO2, 
							posX + offsetX, 
							posY + offsetY, 
							posZ + offsetZ, 
							0, 0, 0)
							.setParticleAge(20 + new Random().nextInt(5)).setParticleScale(15F).setParticleGravity(-0.75F);
						
					MainMod.proxy.spawnCustomParticles(this, particle);
					
					particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU2, 
							posX + offsetX + WyMathHelper.randomDouble(), 
							posY + offsetY + WyMathHelper.randomDouble(), 
							posZ + offsetZ + WyMathHelper.randomDouble(), 
							0, 0, 0)
							.setParticleAge(25 + new Random().nextInt(5)).setParticleScale(15F).setParticleGravity(-0.75F);
					
					MainMod.proxy.spawnCustomParticles(this, particle);
				}
			}
			
			super.onUpdate();
			
			if(!this.worldObj.isRemote)
			{
				if(life <= 0 || this.getThrower() == null)
					this.setDead();

				life--;
				
				if(this.charged)
				{
					List<EntityLivingBase> targets = WyHelper.getEntitiesNear(this, new double[] {15, 50, 15}, EntityLivingBase.class);
					
					targets.remove(this.getThrower());

					int thunderTimer = this.superCharged ? 30 : 50;
					
					for(EntityLivingBase entity : targets)
					{
						if(entity.posY <= this.posY)
						{
							if(this.ticksExisted % thunderTimer == 0)
							{
								WyNetworkHelper.sendTo(new PacketPlayer("ElThorThunder", entity.posX, entity.posY, entity.posZ), (EntityPlayerMP) this.getThrower());
								EntityLightningBolt thunder = new EntityLightningBolt(worldObj, entity.posX, entity.posY, entity.posZ);
								AbilityExplosion exp = WyHelper.newExplosion(this, entity.posX, entity.posY, entity.posZ, 1);
								exp.setFireAfterExplosion(false);
								exp.setDestroyBlocks(false);
								exp.setSmokeParticles("");
								exp.doExplosion();
								
								this.worldObj.spawnEntityInWorld(thunder);
								if(!this.superCharged)
									break;
							}
						}
					}
				}
		        
				int perfectThunderBallsIn = (int) this.weatherBalls.stream().filter(x -> x instanceof ThunderBall && ItemsHelper.getClimaTactLevel(x.getWeaponUsed()) >= 2).count();

				if(perfectThunderBallsIn >= 2 && !this.superCharged)
				{
					this.superCharged = true;
					DevilFruitsHelper.sendShounenScream(getThrower(), "Thunderstorm Tempo", 0);
				}

				List weatherBallsNear = WyHelper.getEntitiesNear(this, new double[] {15, 6, 15}, WeatherBall.class);
					
				if(weatherBallsNear.size() > 0)
				{
					List<ThunderBall> thunderBalls = (List<ThunderBall>) weatherBallsNear.stream().filter(x ->
					{
						WeatherBall ball = (WeatherBall)x;
						
						return ball instanceof ThunderBall;
					}).collect(Collectors.toList());

					if(thunderBalls.size() > 0)
					{
						for(ThunderBall tb : thunderBalls)
						{
							this.life += 50;
							this.weatherBalls.add(tb);
							this.charged = true;
							tb.setDead();
						}
					}
					
					List<CoolBall> coolBalls = (List<CoolBall>) weatherBallsNear.stream().filter(x ->
					{
						WeatherBall ball = (WeatherBall)x;
						
						return ball instanceof CoolBall && ItemsHelper.getClimaTactLevel(ball.getWeaponUsed()) >= 2;
					}).collect(Collectors.toList());

					if(coolBalls.size() >= 2)
					{					
						DevilFruitsHelper.sendShounenScream(getThrower(), "Rain Tempo", 0);
				        WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
				        worldinfo.setRaining(true);
				        
						for(CoolBall cb : coolBalls)
						{
							this.life += 100;
							cb.setDead();
						}
						
				        this.setDead();
					}
				}
			}	
		}
		
		public boolean isCharged()
		{
			return this.charged;
		}
		
		public boolean isSuperCharged()
		{
			return this.superCharged;
		}
		
		public void addWeatherBall(WeatherBall ball)
		{
			this.weatherBalls.add(ball);
		}
		
		public EntityPlayer getThrower()
		{
			return this.thrower;
		}
		
		public void setThrower(EntityPlayer player)
		{
			this.thrower = player;
		}
		
		public int getLife()
		{
			return this.life;
		}
		
		public void setLife(int life)
		{
			this.life = life;
		}
		
		@Override
		protected void entityInit() {}
		@Override
		protected void readEntityFromNBT(NBTTagCompound nbt) {}
		@Override
		protected void writeEntityToNBT(NBTTagCompound nbt) {}
	}	
}
