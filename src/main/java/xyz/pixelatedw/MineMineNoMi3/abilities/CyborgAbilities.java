package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.CyborgProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

import java.util.Random;

public class CyborgAbilities 
{
	static
	{
		Values.abilityWebAppExtraParams.put("freshfire", new String[] {"desc", "The user heats up and breathes fire like a flamethrower at the opponent.", "dorikiRequiredForCyborgs", "0"});
		Values.abilityWebAppExtraParams.put("colaoverdrive", new String[] {"desc", "The user absorbs all of their cola at once to boost their physical abilities.", "dorikiRequiredForCyborgs", "0"});
		Values.abilityWebAppExtraParams.put("radicalbeam", new String[] {"desc", "After charging, the user launches a powerful beam of energy at the opponent.", "dorikiRequiredForCyborgs", "0"});
		Values.abilityWebAppExtraParams.put("strongright", new String[] {"desc", "The user punches the opponent with a metal fist.", "dorikiRequiredForCyborgs", "0"});
		Values.abilityWebAppExtraParams.put("coupdevent", new String[] {"desc", "Launches a powerful blast of compressed air that blows the opponent away.", "dorikiRequiredForCyborgs", "0"});
	}
	
	public static final Ability FRESH_FIRE = new FreshFire();
	public static final Ability COLA_OVERDRIVE = new ColaOverdrive();
	public static final Ability RADICAL_BEAM = new RadicalBeam();
	public static final Ability STRONG_RIGHT = new StrongRight();
	public static final Ability COUP_DE_VENT = new CoupDeVent();
	
	public static Ability[] abilitiesArray = new Ability[] {FRESH_FIRE, COLA_OVERDRIVE, RADICAL_BEAM, STRONG_RIGHT, COUP_DE_VENT};
	
	public static class CoupDeVent extends Ability
	{
		public CoupDeVent() 
		{
			super(ListAttributes.COUP_DE_VENT); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(!isOnCooldown && props.getCola() >= 25)
				super.startCharging(player);
			else if(props.getCola() < 25)
				WyHelper.sendMsgToPlayer(player, "Not enough Cola !");					
		}
		
		@Override
		public void duringCharging(EntityPlayer player, int currentCharge)
		{		
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 1000));
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10, 1000));	
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			props.alterCola(-25);
			isCharging = false;
			isOnCooldown = true;	
					
			for (int i = 0; i < 100; i++)
			{
				double offsetX = (new Random().nextInt(50) + 1.0D - 25.0D) / 20.0D;
				double offsetY = (new Random().nextInt(50) + 1.0D - 25.0D) / 20.0D;
				double offsetZ = (new Random().nextInt(50) + 1.0D - 25.0D) / 20.0D;
						
				this.projectile = new CyborgProjectiles.CoupDeVent(player.worldObj, player, attr);
				this.projectile.setLocationAndAngles(player.posX + offsetX, player.posY + 2 + offsetY, player.posZ + offsetZ, player.cameraPitch, player.cameraYaw);
				player.worldObj.spawnEntityInWorld(projectile);
			}
				
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			startCooldown();
			startExtUpdate(player);
		}	
	}
	
	public static class StrongRight extends Ability
	{
		public StrongRight() 
		{
			super(ListAttributes.STRONG_RIGHT); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(!player.worldObj.isRemote)
			{				
				if(!this.isOnCooldown && props.getCola() >= 10)
				{					
					this.projectile = new CyborgProjectiles.StrongRight(player.worldObj, player, attr);
					player.worldObj.spawnEntityInWorld(projectile);

					props.alterCola(-10);					
					WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
					super.use(player);
				}
				else if(props.getCola() < 10)
					WyHelper.sendMsgToPlayer(player, "Not enough Cola !");
			}
		}			
	}
	
	public static class RadicalBeam extends Ability
	{
		public RadicalBeam() 
		{
			super(ListAttributes.RADICAL_BEAM); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(!player.worldObj.isRemote)
			{
				if(!this.isOnCooldown && props.getCola() >= 15)
				{
					this.projectile = new CyborgProjectiles.RadicalBeam(player.worldObj, player, attr);
					player.worldObj.spawnEntityInWorld(projectile);

					props.alterCola(-15);
					WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
					super.use(player);
				}
				else if(props.getCola() < 15)
					WyHelper.sendMsgToPlayer(player, "Not enough Cola !");
			}
		}			
	}
	
	public static class FreshFire extends Ability
	{
		public FreshFire() 
		{
			super(ListAttributes.FRESH_FIRE); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(!this.isOnCooldown && props.getCola() >= 5)
			{
				for (int i = 0; i < 100; i++)
				{
					double offsetX = (new Random().nextInt(50) + 1.0D - 25.0D) / 20.0D;
					double offsetY = (new Random().nextInt(50) + 1.0D - 25.0D) / 20.0D;
					double offsetZ = (new Random().nextInt(50) + 1.0D - 25.0D) / 20.0D;
						
					this.projectile = new CyborgProjectiles.FreshFire(player.worldObj, player, attr);
					this.projectile.setLocationAndAngles(player.posX + offsetX, player.posY + 2 + offsetY, player.posZ + offsetZ, player.cameraPitch, player.cameraYaw);
					player.worldObj.spawnEntityInWorld(projectile);
				}
					
				props.alterCola(-5);
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				super.use(player);
			}
			else if(props.getCola() < 5)
				WyHelper.sendMsgToPlayer(player, "Not enough Cola !");
		}	
	}
	
	public static class ColaOverdrive extends Ability
	{
		public ColaOverdrive() 
		{
			super(ListAttributes.COLA_OVERDRIVE); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(!isOnCooldown && props.getCola() > 0)
			{
				double r = (props.getCola() / props.getMaxCola()) * 100;
				
				props.setCola(0);
				
				player.setHealth((float) (player.getHealth() + ((r / 100) * player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue()) ));	
				
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				super.use(player);
			}
			else if(props.getCola() <= 0)
				WyHelper.sendMsgToPlayer(player, "Not enough Cola !");
		}		
	}
}
