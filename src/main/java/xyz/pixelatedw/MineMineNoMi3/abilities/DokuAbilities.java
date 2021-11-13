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
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.DokuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketNewAABB;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class DokuAbilities 
{
	static
	{
		Values.abilityWebAppExtraParams.put("hydra", new String[] {"desc", "Launches a dragon made out of liqiud poison at the opponent."});
		Values.abilityWebAppExtraParams.put("chloroball", new String[] {"desc", "The user spits a bubble made of poison towards the enemy, which leaves poison on the ground."});
		Values.abilityWebAppExtraParams.put("dokufugu", new String[] {"desc", "Shoots multiple poisonous bullets at the opponent."});
		Values.abilityWebAppExtraParams.put("dokugumo", new String[] {"desc", "Creates a dense cloud of poisonous smoke, which moves along with the user and poisons and blinds everyone inside."});
		Values.abilityWebAppExtraParams.put("venomroad", new String[] {"desc", "The user fires a Hydra at the target location and transports there through its path."});
		Values.abilityWebAppExtraParams.put("venomdemon", new String[] {"desc", "The user coats himself in layers of strong corrosive venom, becoming a Venom Demon and leaving a highly poisonou trail."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Hydra(), new ChloroBall(), new DokuFugu(), new VenomRoad(), new DokuGumo(), new VenomDemon()};		
	
	public static class DokuGumo extends Ability
	{
		public DokuGumo() 
		{
			super(ListAttributes.DOKU_GUMO); 
		}

		public void duringPassive(EntityPlayer player, int passiveTimer) 
		{
			if(passiveTimer > 400)
			{
				this.setPassiveActive(false);
				this.startCooldown();
				this.startExtUpdate(player);
			}

			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_DOKUGOMU, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);

			for(EntityLivingBase enemy : WyHelper.getEntitiesNear(player, 10))
			{
				if(!enemy.isPotionActive(Potion.blindness.id))
					enemy.addPotionEffect(new PotionEffect(Potion.blindness.id, 10 * 20, 0));
				if(!enemy.isPotionActive(Potion.poison.id))
					enemy.addPotionEffect(new PotionEffect(Potion.poison.id, 10 * 20, 1));
				if(!enemy.isPotionActive(Potion.weakness.id))
					enemy.addPotionEffect(new PotionEffect(Potion.weakness.id, 10 * 20, 1));
			}	
		}	
		
		public void endPassive(EntityPlayer player) 
		{
			this.startCooldown();
			this.startExtUpdate(player);
		}

	}
	
	public static class VenomDemon extends Ability
	{
		public VenomDemon() 
		{
			super(ListAttributes.VENOM_DEMON); 
		}
		
		public void startPassive(EntityPlayer player) 
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if (props.getZoanPoint().isEmpty())
				props.setZoanPoint("n/a");

			WyNetworkHelper.sendTo(new PacketNewAABB(1.5F, 3.5F), (EntityPlayerMP) player);
			
			props.setZoanPoint("venomDemon");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
		
		public void duringPassive(EntityPlayer player, int passiveTimer) 
		{
			if(passiveTimer >= 800)
			{
				this.setPassiveActive(false);
				this.setCooldownActive(true);
				this.endPassive(player);
			}
			
			if(!WyHelper.isBlockNearby(player, 2, Blocks.water, Blocks.flowing_water, ListMisc.KairosekiOre, ListMisc.KairosekiBlock, ListMisc.KairosekiBars))
			{
				for(int x = -1; x < 1; x++)
				for(int z = -1; z < 1; z++)
				{
					DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + x, (int)player.posY, (int)player.posZ + z, ListMisc.DemonPoison, "core", "foliage", "air");
				}
				/*if (player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) != Blocks.air
				&& player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) != ListMisc.Poison
				&& player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) != ListMisc.DemonPoison)
					DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, ListMisc.DemonPoison, "core", "foliage", "air");*/
			}
			
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_VENOMDEMON, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		}		

		public void endPassive(EntityPlayer player) 
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			WyNetworkHelper.sendTo(new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP) player);
			
			props.setZoanPoint("n/a");	
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
			
			this.startCooldown();
			this.startExtUpdate(player);
		}
	}
	
	public static class DokuFugu extends Ability
	{
		public DokuFugu() 
		{
			super(ListAttributes.DOKU_FUGU); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new DokuProjectiles.ChloroBall(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class VenomRoad extends Ability
	{
		public VenomRoad() 
		{
			super(ListAttributes.VENOM_ROAD); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new DokuProjectiles.VenomRoad(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class ChloroBall extends Ability
	{
		public ChloroBall() 
		{
			super(ListAttributes.CHLORO_BALL); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new DokuProjectiles.ChloroBall(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Hydra extends Ability
	{
		public Hydra() 
		{
			super(ListAttributes.HYDRA); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new DokuProjectiles.Hydra(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
}
