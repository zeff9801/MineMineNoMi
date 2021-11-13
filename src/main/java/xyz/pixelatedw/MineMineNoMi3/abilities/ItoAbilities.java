package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ItoProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityBlackKnight;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

import java.util.ArrayList;
import java.util.List;

public class ItoAbilities 
{
	
	static
	{
		Values.abilityWebAppExtraParams.put("parasite", new String[] {"desc", "The user binds the opponent with a string that renders them immobile."});
		Values.abilityWebAppExtraParams.put("soranomichi", new String[] {"desc", "The user creates strings under their feet to launch themselves into the air."});
		Values.abilityWebAppExtraParams.put("overheat", new String[] {"desc", "The user shoots a rope made of heated strings at the opponent, exploding upon impact."});
		Values.abilityWebAppExtraParams.put("tamaito", new String[] {"desc", "The user shoots a small bundle of strings, acting like a bullet."});
		Values.abilityWebAppExtraParams.put("kumonosugaki", new String[] {"desc", "Creates a huge web that protects the user from any attack."});
		Values.abilityWebAppExtraParams.put("torikago", new String[] {"desc", "Creates an indestructible dome made of strings, that damage anyone who toches then"});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Parasite(), new SoraNoMichi(), new Overheat(), new Tamaito(), new KumoNoSugaki(), new Torikago(), new BlackKnight()};	
	
	public static class BlackKnight extends Ability
	{
		private EntityBlackKnight blackKnight;

		public BlackKnight()
		{
			super(ListAttributes.BLACK_KNIGHT);
		}

		public void passive(EntityPlayer player)
		{			
			if(this.passiveActive && player.isSneaking() && blackKnight != null)
			{
				blackKnight.isAggressive = !blackKnight.isAggressive;
				WyHelper.sendMsgToPlayer(player, "Your Black Knight is now " + (blackKnight.isAggressive ? "aggressive" : "defensive"));
			}
			else
				super.passive(player);
		}
		
		public void startPassive(EntityPlayer player)
		{
			blackKnight = new EntityBlackKnight(player.worldObj, player);
			blackKnight.setPositionAndRotation(player.posX, player.posY, player.posZ, 180, 0);
			player.worldObj.spawnEntityInWorld(blackKnight);
		}

		public void endPassive(EntityPlayer player)
		{
			if (!WyHelper.getEntitiesNear(player, 20, EntityBlackKnight.class).isEmpty())
				WyHelper.getEntitiesNear(player, 20, EntityBlackKnight.class).forEach(x -> x.setDead());

			this.startCooldown();
			this.startExtUpdate(player);
		}

	}
	
	public static class Torikago extends Ability
	{
		private List<int[]> blockList = new ArrayList<int[]>();
		
		public Torikago() 
		{
			super(ListAttributes.TORIKAGO); 
		}
		
		public void passive(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				if(this.blockList.isEmpty())
				{
					this.blockList.addAll(WyHelper.createEmptySphere(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, 20, ListMisc.StringWall, "air", "foliage", "liquids", "nogrief"));
					player.worldObj.setBlock((int) player.posX, (int) player.posY, (int) player.posZ, ListMisc.StringMid);
					this.blockList.add(new int[] {(int) player.posX, (int) player.posY, (int) player.posZ});
				}
				
				super.passive(player);
			}
		}
		
		public void endPassive(EntityPlayer player) 
		{
			for(int[] blockPos : this.blockList)
			{
				if(player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.StringWall || player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.StringMid)
					player.worldObj.setBlock(blockPos[0], blockPos[1], blockPos[2], Blocks.air);
			}
            this.blockList = new ArrayList<int[]>();
            this.startCooldown();
            this.startExtUpdate(player);
		}
	}
	
	public static class KumoNoSugaki extends Ability
	{
		public KumoNoSugaki() 
		{
			super(ListAttributes.KUMO_NO_SUGAKI); 
		}
		
		public void duringPassive(EntityPlayer player, int passiveTimer)
		{		
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KUMONOSUGAKI, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			
			if(passiveTimer >= 300)
			{
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
				super.endPassive(player);
			}
		}
		
		public void endPassive(EntityPlayer player) 
		{
			this.startCooldown();
			this.startExtUpdate(player);
		}
	}
	
	public static class Tamaito extends Ability
	{
		public Tamaito() 
		{
			super(ListAttributes.TAMAITO); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new ItoProjectiles.Tamaito(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class Overheat extends Ability
	{
		public Overheat() 
		{
			super(ListAttributes.OVERHEAT); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new ItoProjectiles.Overheat(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class SoraNoMichi extends Ability
	{
		public SoraNoMichi() 
		{
			super(ListAttributes.SORA_NO_MICHI); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				Direction dir = WyHelper.get8Directions(player);
				
				double mX = 0;
				double mY = 0;
				double mZ = 0;
				
				if(player.onGround)
					mY += 1.8;
				else
					mY += 1.96;

				if(dir == WyHelper.Direction.NORTH) mZ -= 1;
				if(dir == WyHelper.Direction.NORTH_WEST) {mZ -= 1; mX -= 1;}
				if(dir == WyHelper.Direction.SOUTH) mZ += 1;
				if(dir == WyHelper.Direction.NORTH_EAST) {mZ -= 1; mX += 1;}
				if(dir == WyHelper.Direction.WEST) mX -= 1;
				if(dir == WyHelper.Direction.SOUTH_WEST) {mZ += 1; mX -= 1;}
				if(dir == WyHelper.Direction.EAST) mX += 1;
				if(dir == WyHelper.Direction.SOUTH_EAST) {mZ += 1; mX += 1;}
				
				motion("=", mX, mY, mZ, player);
				
				super.use(player);
			}
		}
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
	
	public static class Parasite extends Ability
	{
		public Parasite() 
		{
			super(ListAttributes.PARASITE); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!isOnCooldown)
			{			
				for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 20))
				{
					System.out.println(l);

					l.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 10));
					l.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 10));
					
					l.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 10));
					l.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 10));
				}
					
				super.use(player);
			}
		}
	}

}
