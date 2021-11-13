package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class MeraAbilities
{
	static
	{
		Values.abilityWebAppExtraParams.put("hiken", new String[] {"desc", "Turns the user's fist into flames and launches it towards the target."});
		Values.abilityWebAppExtraParams.put("higan", new String[] {"desc", "Turns the user's fingertips into flames and shoots bullets made of fire from them."});
		Values.abilityWebAppExtraParams.put("hidaruma", new String[] {"desc", "Creates small green fireballs that set the target on fire."});
		Values.abilityWebAppExtraParams.put("jujika", new String[] {"desc", "Launches a cross-shaped column of fire at the opponent, leaving a cross of fire."});
		Values.abilityWebAppExtraParams.put("enjomo", new String[] {"desc", "Creates a circle of fire around the user, burning everyone inside of it."});
		Values.abilityWebAppExtraParams.put("daienkaientei", new String[] {"desc", "Amasses the user's flames into a gigantic fireball that the user hurls at the opponent."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Hiken(), new Higan(), new DaiEnkaiEntei(), new Hidaruma(), new Jujika(), new Enjomo()};
	
	public static class Hiken extends Ability
	{
		public Hiken()
		{
			super(ListAttributes.HIKEN);
		}
		
		public void use(EntityPlayer player)
		{			
			this.projectile = new MeraProjectiles.Hiken(player.worldObj, player, ListAttributes.HIKEN);			
			super.use(player);		
		}
	}
	
	public static class Higan extends Ability
	{
		public Higan() 
		{
			super(ListAttributes.HIGAN); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new MeraProjectiles.Higan(player.worldObj, player, ListAttributes.HIGAN);
			super.use(player);
		};			
	}

	public static class DaiEnkaiEntei extends Ability
	{
		public DaiEnkaiEntei() 
		{
			super(ListAttributes.DAI_ENKAI_ENTEI); 
		}
		
		public void startCharging(EntityPlayer player)
		{
			super.startCharging(player);
		}
		
		public void duringCharging(EntityPlayer player, int currentCharge)
		{
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_DAIENKAI2, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		}
		
		public void endCharging(EntityPlayer player)
		{						
			this.projectile = new MeraProjectiles.DaiEnkaiEntei(player.worldObj, player, ListAttributes.DAI_ENKAI_ENTEI);
			super.endCharging(player);
		}
	
	}

	public static class Hidaruma extends Ability
	{
		public Hidaruma() 
		{
			super(ListAttributes.HIDARUMA); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new MeraProjectiles.Hidaruma(player.worldObj, player, ListAttributes.HIDARUMA);
			super.use(player);
		};			
	}

	public static class Jujika extends Ability
	{
		public Jujika() 
		{
			super(ListAttributes.JUJIKA); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new MeraProjectiles.Jujika(player.worldObj, player, ListAttributes.JUJIKA);
			super.use(player);
		};			
	}

	public static class Enjomo extends Ability
	{
		public Enjomo() 
		{
			super(ListAttributes.ENJOMO); 
		}
		
		public void use(final EntityPlayer player)
		{
			if(!isOnCooldown)
			{
				WyHelper.createEmptySphere(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, 13, Blocks.fire, "air", "foliage");
					
				for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 12))
				{l.setFire(20);}
											
				super.use(player);
			}
		}	
	}

}

