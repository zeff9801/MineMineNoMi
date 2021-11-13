package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BaneProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class BaneAbilities
{

	static
	{
		Values.abilityWebAppExtraParams.put("springhopper", new String[] {"desc", "Turning the userps legs into springs, which launches them into the air."});
		Values.abilityWebAppExtraParams.put("springdeathknock", new String[] {"desc", "By turning the user's arm into a spring and compressing it, they can launch a powerful punch."});
		Values.abilityWebAppExtraParams.put("springsnipe", new String[] {"desc", "Turning the user's forelegs into springs, they can launch themselves directly at the opponent."});
		
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new SpringDeathKnock(), new SpringSnipe(), new SpringHopper()};
	 
	public static class SpringDeathKnock extends Ability
	{
		public SpringDeathKnock() 
		{
			super(ListAttributes.SPRING_DEATH_KNOCK); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new BaneProjectiles.SpringDeathKnock(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class SpringSnipe extends Ability
	{
		public SpringSnipe() 
		{
			super(ListAttributes.SPRING_SNIPE); 
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
			mX *= 8;
			mY *= 3;
			mZ *= 8;

			motion("=", mX, mY, mZ, player);
			
			super.endCharging(player);
	    }
		
	    @Override
		public void duringCooldown(EntityPlayer player, int currentCooldown)
	    {
	    	ExtendedEntityData props = ExtendedEntityData.get(player);

			if((currentCooldown / 20) > (ListAttributes.SPRING_SNIPE.getAbilityCooldown() / 20) - 3)
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 1.6))
					e.attackEntityFrom(DamageSource.causePlayerDamage(player), 8 * props.getDamageMultiplier());
	    }
	}
	
	public static class SpringHopper extends Ability
	{
		public SpringHopper() 
		{
			super(ListAttributes.SPRING_HOPPER); 
		}

	    @Override
		public void endCharging(EntityPlayer player)
	    {
			Direction dir = WyHelper.get8Directions(player);

			if(player.onGround)
				motion("+", 0, 1.2 + (double)1/2, 0, player);
			else
				motion("+", 0, 1.36 + (double)1/7, 0, player);
	
			if(dir == WyHelper.Direction.NORTH) 		motion("-", 0, 0, 1.4 + (double)1/2, player);
			if(dir == WyHelper.Direction.NORTH_WEST) {	motion("-", 1.4 + (double)1/2, 0, 1.4 + (double)1/2, player);}
			if(dir == WyHelper.Direction.SOUTH)			motion("+", 0, 0, 1.4 + (double)1/2, player);
			if(dir == WyHelper.Direction.NORTH_EAST) {	motion("-", 0, 0, 1.4 + (double)1/2, player);motion("+", 1.4 + (double)1/2, 0, 0, player);}
			if(dir == WyHelper.Direction.WEST) 			motion("-", 1.4 + (double)1/2, 0, 0, player);
			if(dir == WyHelper.Direction.SOUTH_WEST) {	motion("+", 0, 0, 1.4 + (double)1/2, player);motion("-", 1.4 + (double)1/2, 0, 0, player);}
			if(dir == WyHelper.Direction.EAST) 			motion("+", 1.4 + (double)1/2, 0, 0, player);
			if(dir == WyHelper.Direction.SOUTH_EAST) {	motion("+", 1.4 + (double)1/2, 0, 1.4 + (double)1/2, player);}
			
			super.endCharging(player);
	    }
	}

	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
}
