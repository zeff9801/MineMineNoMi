package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectHieSlowness;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class YomiAbilities
{
	public static Ability[] abilitiesArray = new Ability[] {new KasuriutaFubukiGiri(), new SoulParade()};
	
	public static class SoulParade extends Ability
	{
		public SoulParade() 
		{
			super(ListAttributes.SOUL_PARADE); 
		}
		
		@Override
		public void passive(EntityPlayer player)
		{
			if(ItemsHelper.isSword(player.getHeldItem()))
				super.passive(player);
			else
				WyHelper.sendMsgToPlayer(player, "You need a sword to use this ability !");
		}
		
		@Override
		public void duringPassive(EntityPlayer player, int passiveTimer)
		{
			if(passiveTimer > 400 || player.getHeldItem() == null || !ItemsHelper.isSword(player.getHeldItem()))
			{
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
				super.endPassive(player);
			}
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			this.startCooldown();
			this.startExtUpdate(player);	
		}
	}
	
	public static class KasuriutaFubukiGiri extends Ability
	{
		public KasuriutaFubukiGiri() 
		{
			super(ListAttributes.KASURIUTA_FUBUKI_GIRI); 
		}
			
		@Override
		public void use(EntityPlayer player)
		{
			if(ItemsHelper.isSword(player.getHeldItem()))
			{
				if(!this.isOnCooldown)
				{
					double mX = -MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
					double mZ = MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
						
					double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
					mX /= f2;
					mZ /= f2;
					mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
					mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
					mX *= 5;
					mZ *= 5;
				
					motion("=", mX, player.motionY, mZ, player);
					
					if (player.worldObj instanceof WorldServer)
						((WorldServer)player.worldObj).getEntityTracker().func_151248_b(player, new S0BPacketAnimation(player, 0));
				}
				
				super.use(player);
			}
			else
				WyHelper.sendMsgToPlayer(player, "You need a sword to use this ability !");
		}
		
	    @Override
		public void duringCooldown(EntityPlayer player, int currentCooldown)
	    {
	    	ExtendedEntityData props = ExtendedEntityData.get(player);
			if(currentCooldown > 6 * 20)
			{			
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 1.6))
				{
					e.attackEntityFrom(DamageSource.causePlayerDamage(player), 8 * props.getDamageMultiplier());
					e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
					e.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 100, 5));		
					new DFEffectHieSlowness(e, 100);
					AbilityExplosion explosion = WyHelper.newExplosion(player, e.posX, e.posY, e.posZ, 2);
					explosion.setExplosionSound(false);
					explosion.setDamageOwner(false);
					explosion.setDestroyBlocks(false);
					explosion.setSmokeParticles(ID.PARTICLEFX_SOULPARADE);
					explosion.doExplosion(); 
				}
		    	WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KASURIUTAFUBUKIGIRI, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			}
	    }
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
}
