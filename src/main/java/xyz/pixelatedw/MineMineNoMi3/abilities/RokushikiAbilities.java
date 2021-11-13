package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class RokushikiAbilities 
{
	
	static
	{
		Values.abilityWebAppExtraParams.put("soru", new String[] {"desc", "Allows the user to move at an extremely high speed.", "dorikiRequiredForHumans", "500"});
		Values.abilityWebAppExtraParams.put("tekkai", new String[] {"desc", "Hardens the user's body to protect themselves, but they're unable to move.", "dorikiRequiredForHumans", "1500"});
		Values.abilityWebAppExtraParams.put("geppo", new String[] {"desc", "The user kicks the air beneath them to launch themselves into the air.", "dorikiRequiredForHumans", "4500"});
		Values.abilityWebAppExtraParams.put("rankyaku", new String[] {"desc", "By kicking at a very high speed, the user launches an air blade at the opponent.", "dorikiRequiredForHumans", "8500"});
		Values.abilityWebAppExtraParams.put("shigan", new String[] {"desc", "The user thrusts their finger at the opponent, to pierce them.", "dorikiRequiredForHumans", "3000"});
		Values.abilityWebAppExtraParams.put("kamie", new String[] {"desc", "Maked the user's body flexible in order to avoid attacks.", "dorikiRequiredForHumans", "6000"});
	}
	
	public static final Ability SORU = new Soru();
	public static final Ability TEKKAI = new Tekkai();
	public static final Ability GEPPO = new Geppo();
	public static final Ability RANKYAKU = new Rankyaku();
	public static final Ability SHIGAN = new Shigan();
	public static final Ability KAMIE = new Kamie();
	
	public static Ability[] abilitiesArray = new Ability[] {SORU, TEKKAI, GEPPO, RANKYAKU, SHIGAN, KAMIE};
	
	public static class Soru extends Ability
	{
		public Soru() 
		{
			super(ListAttributes.SORU); 
		}
	}
	
	public static class Tekkai extends Ability
	{
		private int threshold = 300;
		
		public Tekkai() 
		{
			super(ListAttributes.TEKKAI); 
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
			this.startCooldown();
			this.startExtUpdate(player);
			this.threshold = 300;
			super.endPassive(player);
		}
	}
	
	public static class Geppo extends Ability
	{
		public Geppo() 
		{
			super(ListAttributes.GEPPO); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				Direction dir = WyHelper.get8Directions(player);
				
				double mX = 0;
				double mY = 0;
				double mZ = 0;
				
				if(player.onGround)
					mY += 1.7;
				else
					mY += 1.86;
	
				if(dir == WyHelper.Direction.NORTH) mZ -= 1;
				if(dir == WyHelper.Direction.NORTH_WEST) {mZ -= 1; mX -= 1;}
				if(dir == WyHelper.Direction.SOUTH) mZ += 1;
				if(dir == WyHelper.Direction.NORTH_EAST) {mZ -= 1; mX += 1;}
				if(dir == WyHelper.Direction.WEST) mX -= 1;
				if(dir == WyHelper.Direction.SOUTH_WEST) {mZ += 1; mX -= 1;}
				if(dir == WyHelper.Direction.EAST) mX += 1;
				if(dir == WyHelper.Direction.SOUTH_EAST) {mZ += 1; mX += 1;}
				
				motion("=", mX, mY, mZ, player);
				
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_GEPPO, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
				
				super.use(player);
			}
		};
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
		
	public static class Rankyaku extends Ability
	{
		public Rankyaku() 
		{
			super(ListAttributes.RANKYAKU); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new RokushikiProjectiles.Rankyaku(player.worldObj, player, ListAttributes.RANKYAKU);
			super.use(player);
		}
	}
	

	public static class Shigan extends Ability
	{
		public Shigan() 
		{
			super(ListAttributes.SHIGAN); 
		}
		
		@Override
		public void hitEntity(EntityPlayer player, EntityLivingBase target) 
		{
			super.hitEntity(player, target);
			target.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
		}
	}
	
	public static class Kamie extends Ability
	{
		public Kamie() 
		{
			super(ListAttributes.KAMIE); 
		}
		
		@Override
		public void duringPassive(EntityPlayer player, int passiveTimer)
		{
			if(passiveTimer > 400)
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
}
