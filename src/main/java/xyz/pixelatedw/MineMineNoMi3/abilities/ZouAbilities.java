package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ZouProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketEntityVelocity;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketNewAABB;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class ZouAbilities
{

	public static Ability[] abilitiesArray = new Ability[] {new ZouPoint(), new HybridPoint(), new IvoryDart(), new IvoryStomp(), new GreatStomp(), new TrunkShot()};
	
	public static class TrunkShot extends Ability
	{
		public TrunkShot()
		{
			super(ListAttributes.TRUNK_SHOT);
		}
		
		@Override
		public void use(EntityPlayer player)
		{	
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(!props.getZoanPoint().equals("full") && !props.getZoanPoint().equals("hybrid"))
			{
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while Zou Point or Hybrid Point are active !");	
				return;
			}
			
			this.projectile = new ZouProjectiles.TrunkShot(player.worldObj, player, ListAttributes.TRUNK_SHOT);			
			super.use(player);	
		}
	}
	
	public static class GreatStomp extends Ability
	{
		public GreatStomp() 
		{
			super(ListAttributes.GREAT_STOMP); 
		}	
		
		@Override
		public void use(EntityPlayer player) 
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(!props.getZoanPoint().equals("full"))
			{
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while Zou Point is active !");	
				return;
			}
			
			if(!this.isOnCooldown)
			{
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_GREATSTOMP, player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);

				for(EntityLivingBase entity : WyHelper.getEntitiesNear(player, 10))
				{
					entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10 * props.getDamageMultiplier());
					entity.setPositionAndUpdate(entity.posX, entity.posY + 3, entity.posZ);
				}
				
				super.use(player);
			}
		}
	}
	
	public static class IvoryStomp extends Ability
	{
		public IvoryStomp() 
		{
			super(ListAttributes.IVORY_STOMP); 
		}	
		
		@Override
		public void passive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(!props.getZoanPoint().equals("hybrid"))
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while Hybrid Point is active !");	
			else
				super.passive(player);
		}
		
		@Override
		public void hitEntity(EntityPlayer player, EntityLivingBase target) 
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(props.getZoanPoint().equals("hybrid"))
			{
				super.hitEntity(player, target);
				target.attackEntityFrom(DamageSource.causePlayerDamage(player), 20 * props.getDamageMultiplier());
				AbilityExplosion explosion = WyHelper.newExplosion(target, target.posX, target.posY, target.posZ, 1);
				explosion.setExplosionSound(false);
				explosion.setDamageOwner(false);
				explosion.setDestroyBlocks(false);
				explosion.doExplosion();
				
				double mX = -MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
				double mZ = MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
					
				double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
				mX /= f2;
				mZ /= f2;
				mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mX *= -2.7;
				mZ *= -2.7;
			
				WyNetworkHelper.sendToAll(new PacketEntityVelocity(target.getEntityId(), mX, 0.1, mZ));
			}
			else
			{
				this.setPassiveActive(false);
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while Hybrid Point is active !");
			}
		}
	}
	
	public static class IvoryDart extends Ability
	{
		private int initialY;
		
		public IvoryDart() 
		{
			super(ListAttributes.IVORY_DART); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{	
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(props.getZoanPoint().equals("full") && !this.isOnCooldown)
			{
				double mX = -MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
				double mZ = MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
				
				this.initialY = (int) player.posY;
				
				double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
				mX /= f2;
				mZ /= f2;
				mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
				mX *= 4;
				mZ *= 4;
			
				motion("=", mX, player.motionY, mZ, player);
				
				super.use(player);
			}
			else if(!props.getZoanPoint().equals("full") )
			{
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while Zou Point is active !");
			}
		}
		
	    @Override
		public void duringCooldown(EntityPlayer player, int currentCooldown)
	    {
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(currentCooldown > 180 && player.posY >= this.initialY)
			{
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage(player), 12 * props.getDamageMultiplier());
				
				for(int[] location : WyHelper.getBlockLocationsNearby(player, 3))
				{
					if(location[1] >= player.posY)
					{
						if(DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, "core", "foliage"))
						{
							WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_BAKUMUNCH, location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], ID.GENERIC_PARTICLES_RENDER_DISTANCE);
						}
					}
				}
			}
	    }
	}
	
	public static class ZouPoint extends Ability
	{
		public ZouPoint()
		{
			super(ListAttributes.ZOU_FULL_POINT);
		}
		
		@Override
		public void passive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("full")))
			{
				super.passive(player);
			}
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (props.getZoanPoint().isEmpty())
				props.setZoanPoint("n/a");

			WyNetworkHelper.sendTo(new PacketNewAABB(1.5F, 2.5F), (EntityPlayerMP) player);
			
			props.setZoanPoint("full");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			WyNetworkHelper.sendTo(new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP) player);
			
			props.setZoanPoint("n/a");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
	}
	
	public static class HybridPoint extends Ability
	{
		public HybridPoint()
		{
			super(ListAttributes.ZOU_HYBRID_POINT);
		}
		
		@Override
		public void passive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("hybrid")))
			{
				super.passive(player);
			}
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (props.getZoanPoint().isEmpty())
				props.setZoanPoint("n/a");

			WyNetworkHelper.sendTo(new PacketNewAABB(1.5F, 2.5F), (EntityPlayerMP) player);
			
			props.setZoanPoint("hybrid");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			WyNetworkHelper.sendTo(new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP) player);
			
			props.setZoanPoint("n/a");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
	
}
