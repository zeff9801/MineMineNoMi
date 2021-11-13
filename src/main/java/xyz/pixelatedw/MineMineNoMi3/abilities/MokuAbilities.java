package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MokuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class MokuAbilities 
{

	static
	{
		Values.abilityWebAppExtraParams.put("whiteout", new String[] {"desc", "Shoots clouds of smoke to engulf the opponent and trap them."});
		Values.abilityWebAppExtraParams.put("whitesnake", new String[] {"desc", "Launches a long dense smoke cloud in the shape of a snake to grab the opponent and damage them."});
		Values.abilityWebAppExtraParams.put("whitelauncher", new String[] {"desc", "Transforms the user into smoke and launches them forward."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new WhiteOut(), new WhiteSnake(), new WhiteLauncher(), new WhiteStrike()};
	
	public static class WhiteStrike extends Ability
	{
		public WhiteStrike() 
		{
			super(ListAttributes.WHITE_STRIKE); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{	
			if(!this.isOnCooldown())
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_WHITESTRIKE, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.use(player);
		}
	}
	
	public static class WhiteLauncher extends Ability
	{
		public WhiteLauncher() 
		{
			super(ListAttributes.WHITE_LAUNCHER); 
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{	
			double mX = -MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
			double mZ = MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * 0.4;
			double mY = -MathHelper.sin((player.rotationPitch + 0) / 180.0F * (float)Math.PI) * 0.4;		        
				
			double f2 = MathHelper.sqrt_double(mX * mX + mY * mY + mZ * mZ);
			mX /= f2;
			mY /= f2;
			mZ /= f2;
			mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mY += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
			mX *= 5;
			mY *= 1.5;
			mZ *= 5;
		
			motion("=", mX, mY, mZ, player);

			super.endCharging(player);
	    }
		
	    @Override
		public void duringCooldown(EntityPlayer player, int currentCooldown)
	    {
	    	ExtendedEntityData props = ExtendedEntityData.get(player);
			if((currentCooldown / 20) > (ListAttributes.WHITE_LAUNCHER.getAbilityCooldown() / 20) - 3)
			{
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage(player), 2 * props.getDamageMultiplier());
		    	WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_WHITELAUNCHER, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			}
	    }
	}
	
	public static class WhiteSnake extends Ability
	{
		public WhiteSnake() 
		{
			super(ListAttributes.WHITE_SNAKE); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{		
			this.projectile = new MokuProjectiles.WhiteSnake(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class WhiteOut extends Ability
	{
		public WhiteOut() 
		{
			super(ListAttributes.WHITE_OUT); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{		
			this.projectile = new MokuProjectiles.WhiteOut(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
	
}
