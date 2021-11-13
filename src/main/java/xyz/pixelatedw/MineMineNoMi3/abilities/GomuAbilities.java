package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GomuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class GomuAbilities 
{
	
	static
	{
		Values.abilityWebAppExtraParams.put("gomugomunopistol", new String[] {"desc", "The user stretches their arm to hit the opponent."});
		Values.abilityWebAppExtraParams.put("gomugomunobazooka", new String[] {"desc", "The user stretches their arms to send the opponent flying by hitting them with both palms"});
		Values.abilityWebAppExtraParams.put("gearsecond", new String[] {"desc", "By speding up their blood flow, the user gains strength, speed and mobility."});
		Values.abilityWebAppExtraParams.put("gearthird", new String[] {"desc", "By blowing air and inflating their body, the user's attacks get bigger and gain incredible strength."});
		Values.abilityWebAppExtraParams.put("gearforth", new String[] {"desc", "The user inflates their muscle structure to tremendously increase the power of their attacks."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new GomuGomuNoPistol(), new GomuGomuNoBazooka(), new GomuGomuNoRocket(), new GomuGomuNoGatling(), new GearSecond(), new GearThird(), new GearForth()};

	public static class GearForth extends Ability
	{
		public GearForth() 
		{
			super(ListAttributes.GEAR_FOURTH); 
		}
		
		@Override
		public void passive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);
			
			if(abilityProps.hasHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_HARDENING))
				super.passive(player);
			else
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be activated while Busoshoku Haki is active !");
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.setGear(4);
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}
			
		@Override
		public void duringPassive(EntityPlayer player, int passiveTimer)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			player.addPotionEffect(new PotionEffect(Potion.jump.id, 25, 2, false));
			
			if(passiveTimer >= 600)
			{
				props.setGear(1);
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				super.setPassiveActive(false);
				super.use(player);
			}
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			props.setGear(1);
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			super.use(player);
		} 
	}	
	
	public static class GearThird extends Ability
	{
		public GearThird() 
		{
			super(ListAttributes.GEAR_THIRD); 
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.setGear(3);
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		} 
			
		@Override
		public void duringPassive(EntityPlayer player, int passiveTimer)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(passiveTimer >= 1200)
			{
				props.setGear(1);
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				super.setPassiveActive(false);
				super.use(player);
			}			
		} 
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			props.setGear(1);
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			super.use(player);
		} 
	}		
	
	
	public static class GearSecond extends Ability
	{
		public GearSecond() 
		{
			super(ListAttributes.GEAR_SECOND); 
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			props.setGear(2);
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		} 
			
		@Override
		public void duringPassive(EntityPlayer player, int passiveTimer)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 6, false));
	    	WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_GEARSECOND, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			
			if(passiveTimer >= 1200)
			{
				props.setGear(1);
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				super.setPassiveActive(false);
				super.use(player);
			}			
		} 
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			props.setGear(1);
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			super.use(player);
		} 
	}
	
	public static class GomuGomuNoGatling extends Ability
	{
		public GomuGomuNoGatling() 
		{
			super(ListAttributes.GOMU_GOMU_NO_GATLING); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{		
			if(!this.isOnCooldown)
			{
				ExtendedEntityData props = ExtendedEntityData.get(player);
				
				int type = 0;
				int projectileSpace = 3;
				
				switch(props.getGear())
				{
					case 1:
						type = 0;
						if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Gatling");
						this.attr.setAbilityCooldown(4);
						break;
					case 2:
						type = 1;
						if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Jet Gatling");
						this.attr.setAbilityCooldown(2);
						break;
					case 3:
						type = 2;
						projectileSpace = 7;
						if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Elephant Gatling");
						this.attr.setAbilityCooldown(6);
						break;
					case 4:
						type = 3;
						projectileSpace = 7;
						if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Kong Organ");
						this.attr.setAbilityCooldown(7);
						break;
				}
	
				for(int j = 0; j < 25; j++)
				{
					AbilityProjectile proj = null;
					if(type == 0)
						proj = new GomuProjectiles.GomuGomuNoGatling(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_GATLING);
					else if(type == 1)
						proj = new GomuProjectiles.GomuGomuNoJetGatling(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_JET_GATLING);
					else if(type == 2)
						proj = new GomuProjectiles.GomuGomuNoElephantGatling(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_ELEPHANT_GATLING);
					else if(type == 3)
						proj = new GomuProjectiles.GomuGomuNoKongOrgan(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_KONG_ORGAN);
					
					proj.setLocationAndAngles(
							player.posX + WyMathHelper.randomWithRange(-projectileSpace, projectileSpace) + player.worldObj.rand.nextDouble(), 
							(player.posY + 0.3) + WyMathHelper.randomWithRange(0, projectileSpace) + player.worldObj.rand.nextDouble(), 
							player.posZ + WyMathHelper.randomWithRange(-projectileSpace, projectileSpace) + player.worldObj.rand.nextDouble(), 
							0, 0);
					player.worldObj.spawnEntityInWorld(proj);
				}
				
				super.use(player);
			}
		} 
	}
	
	public static class GomuGomuNoRocket extends Ability
	{
		public GomuGomuNoRocket() 
		{
			super(ListAttributes.GOMU_GOMU_NO_ROCKET); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new GomuProjectiles.GomuGomuNoRocket(player.worldObj, player, ListAttributes.GOMU_GOMU_NO_ROCKET);
			super.use(player);
		} 
	}
	
	public static class GomuGomuNoBazooka extends Ability
	{
		public GomuGomuNoBazooka() 
		{
			super(ListAttributes.GOMU_GOMU_NO_BAZOOKA); 
		}

		@Override
		public void startCharging(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(MainConfig.enableAnimeScreaming)
			{
				switch(props.getGear())
				{
					case 1:
						this.attr.setAbilityDisplayName("Gomu Gomu no Bazooka");
						break;
					case 2:
						this.attr.setAbilityDisplayName("Gomu Gomu no Jet Bazooka");
						break;
					case 3:
						this.attr.setAbilityDisplayName("Gomu Gomu no Grizzly Magnum");
						break;
					case 4:
						this.attr.setAbilityDisplayName("Gomu Gomu no Leo Bazooka");
						break;
				}					
			}
			
			super.startCharging(player);
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			switch(props.getGear())
			{
				case 1:
					this.projectile = new GomuProjectiles.GomuGomuNoBazooka(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_BAZOOKA);
					this.attr.setAbilityCooldown(12);
					this.attr.setAbilityCharges(18);
					break;
				case 2:
					this.projectile = new GomuProjectiles.GomuGomuNoJetBazooka(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_JET_BAZOOKA);
					this.attr.setAbilityCooldown(6);
					this.attr.setAbilityCharges(13);
					break;
				case 3:
					this.projectile = new GomuProjectiles.GomuGomuNoGrizzlyMagnum(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_GRIZZLY_MAGNUM);
					this.attr.setAbilityCooldown(20);
					this.attr.setAbilityCharges(40);
					break;
				case 4:
					this.projectile = new GomuProjectiles.GomuGomuNoLeoBazooka(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_LEO_BAZOOKA);
					this.attr.setAbilityCooldown(30);
					this.attr.setAbilityCharges(40);
					break;
			}
			
			super.endCharging(player);
		} 
	}
	
	public static class GomuGomuNoPistol extends Ability
	{
		public GomuGomuNoPistol() 
		{
			super(ListAttributes.GOMU_GOMU_NO_PISTOL); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);		
			switch(props.getGear())
			{
				case 1:
					if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Pistol");
					this.projectile = new GomuProjectiles.GomuGomuNoPistol(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_PISTOL);
					this.attr.setAbilityCooldown(8);
					break;
				case 2:
					if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Jet Pistol");
					this.projectile = new GomuProjectiles.GomuGomuNoJetPistol(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_JET_PISTOL);
					this.attr.setAbilityCooldown(5);
					break;
				case 3:
					if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Elephant Gun");
					this.projectile = new GomuProjectiles.GomuGomuNoElephantGun(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_ELEPHANT_GUN);
					this.attr.setAbilityCooldown(15);
					break;
				case 4:
					if(MainConfig.enableAnimeScreaming) this.attr.setAbilityDisplayName("Gomu Gomu no Kong Gun");
					this.projectile = new GomuProjectiles.GomuGomuNoKongGun(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_KONG_GUN);
					this.attr.setAbilityCooldown(30);
					break;
			}

			super.use(player);
		} 
	}
}
