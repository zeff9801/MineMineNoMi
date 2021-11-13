package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectSpiderOverlay;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SupaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class SupaAbilities
{
	static
	{
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Spider(), new SparClaw(), new AtomicSpurt(), new SpiralHollow(), new SparklingDaisy()};
	
	public static class SparklingDaisy extends Ability
	{
		private int initialY;
		
		public SparklingDaisy() 
		{
			super(ListAttributes.SPARKLING_DAISY); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{	
			if(!this.isOnCooldown())
			{
				ExtendedEntityData props = ExtendedEntityData.get(player);
	
				double mX = -MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
				double mZ = MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
					
				this.initialY = (int) player.posY;
					
				double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
				mX /= f2;
				mZ /= f2;
				mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mX *= 3;
				mZ *= 3;
				
				motion("=", mX, player.motionY, mZ, player);
					
				super.use(player);
			}
		}
			
	    @Override
		public void duringCooldown(EntityPlayer player, int currentCooldown)
	    {
			if(currentCooldown > 180 && player.posY >= this.initialY)
			{
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage(player), 18);
				
				for(int[] location : WyHelper.getBlockLocationsNearby(player, 4))
				{
					if(location[1] >= player.posY)
					{
						if(DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, "core", "foliage", "ores"))
						{
							WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_BAKUMUNCH, location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], ID.GENERIC_PARTICLES_RENDER_DISTANCE);
						}
					}
				}
			}
	    }
	}
	
	public static class SpiralHollow extends Ability
	{
		public SpiralHollow()
		{
			super(ListAttributes.SPIRAL_HOLLOW);
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new SupaProjectiles.SpiralHollow(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class AtomicSpurt extends Ability
	{
		public AtomicSpurt()
		{
			super(ListAttributes.ATOMIC_SPURT);
		}
		
		@Override
		public void duringPassive(EntityPlayer player, int passiveTime)
		{
			if(passiveTime > 1000)
			{
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
				super.endPassive(player);
			}

	    	WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_ATOMICSPURT, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			this.startCooldown();
			this.startExtUpdate(player);
		}
	}
	
	public static class SparClaw extends Ability
	{
		public SparClaw()
		{
			super(ListAttributes.SPAR_CLAW);
		}
		
		@Override
		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			super.hitEntity(player, target);
		}
	}
	
	public static class Spider extends Ability
	{
		private int threshold = 300;

		public Spider()
		{
			super(ListAttributes.SPIDER);
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			new DFEffectSpiderOverlay(player, 30);
			WyNetworkHelper.sendTo(new PacketSync(ExtendedEntityData.get(player)), (EntityPlayerMP) player);
		}
		
		@Override
		public void duringPassive(EntityPlayer player, int passiveTimer)
		{
			if(passiveTimer > 2400 || this.threshold <= 0)
			{
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
				this.endPassive(player);
			}
			
			if(player.hurtTime > 0)
				this.threshold--;		
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData.get(player).removeExtraEffects(ID.EXTRAEFFECT_SPIDEROVERLAY);
			WyNetworkHelper.sendTo(new PacketSync(ExtendedEntityData.get(player)), (EntityPlayerMP) player);
			super.endPassive(player);
		}
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
	
}
