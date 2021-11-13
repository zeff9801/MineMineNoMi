package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.abilities.HakiAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EventsHakiGain
{
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);
			ItemStack heldItem = player.getHeldItem();
			
			if(abilityProps.hasHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_AURA))
			{
				Ability auraKen = abilityProps.getAbilityFromName(ListAttributes.KENBUNSHOKU_HAKI_AURA.getAttributeName());
				boolean hasAuraKenActive = auraKen != null && auraKen.isPassiveActive();
				
				if(props.getObservationHakiExp() >= 200 && hasAuraKenActive)
				{
					if(player.ticksExisted % 200 == 0)
						props.addObservationHakiExp((int) (6 + WyMathHelper.randomWithRange(0, 10)));
				}
			}
			
			if(MainConfig.haoshokuHakiUnlockLogic.equalsIgnoreCase("exp") && !player.worldObj.isRemote)
			{
				int haoExp = (props.getHardeningHakiExp() + props.getImbuingHakiExp() + props.getObservationHakiExp()) / 3;
				
				if(haoExp >= 100 && player.getHealth() < WyMathHelper.percentage(20, player.getMaxHealth()) && player.ticksExisted % 200 == 0)
					props.addKingHakiExp(1);

			}
		}		
	}
	
	@SubscribeEvent
	public void onEntityAttack(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			Entity attacker = event.source.getSourceOfDamage();
			EntityPlayer attacked = (EntityPlayer) event.entityLiving;
			ExtendedEntityData props = ExtendedEntityData.get(attacked);
			AbilityProperties abilityProps = AbilityProperties.get(attacked);
			
			double hakiMultiplier = 1;
			
			if(attacked.isPotionActive(Potion.blindness.id) || attacked.isPotionActive(Potion.confusion.id))
				hakiMultiplier = 1.25;
			
			if(props.getDoriki() > 1500 && props.getObservationHakiExp() <= 300)
			{
				int exp = (int) (event.ammount / 10);
				if(exp <= 0)
					exp = 1;
				
				props.addObservationHakiExp((int) ((exp + WyMathHelper.randomWithRange(0, 2)) * hakiMultiplier));
			}
			
			if(props.getObservationHakiExp() > 300 + WyMathHelper.randomWithRange(0, 50))
			{
				this.giveHakiAbility(abilityProps, HakiAbilities.KENBUNSHOKU_HAKI_AURA, attacked);
			}
			
			if(props.getObservationHakiExp() > 600 + WyMathHelper.randomWithRange(0, 100))
			{
				this.giveHakiAbility(abilityProps, HakiAbilities.KENBUNSHOKU_HAKI_FUTURE_SIGHT, attacked);
			}
								
			if(MainConfig.haoshokuHakiUnlockLogic.equalsIgnoreCase("exp") && !attacked.worldObj.isRemote)
			{
				int haoExp = (props.getHardeningHakiExp() + props.getImbuingHakiExp() + props.getObservationHakiExp()) / 3;
				
				if(haoExp > 600 + WyMathHelper.randomWithRange(0, 100))
					this.giveHakiAbility(abilityProps, HakiAbilities.HAOSHOKU_HAKI, attacked);
				
				boolean hasEnemiesNear = WyHelper.getEntitiesNear(attacked, 20, EntityCreature.class).size() > 0;
				if(haoExp >= 100 && attacked.getHealth() < WyMathHelper.percentage(20, attacked.getMaxHealth()) && attacked.ticksExisted % 200 == 0 && hasEnemiesNear)
				{
					if(props.getKingHakiExp() >= 5 + WyMathHelper.randomWithRange(0, 2))
					{
						WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_HAOSHOKU_HAKI, attacked), attacked.dimension, attacked.posX, attacked.posY, attacked.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
						DevilFruitsHelper.haoAttackEntities(attacked);

						props.addKingHakiExp(-props.getKingHakiExp());
					}
				}
			}
			
			System.out.println("Imbuing : " + props.getImbuingHakiExp());
			System.out.println("Hardening : " + props.getHardeningHakiExp());
			System.out.println("Observation : " + props.getObservationHakiExp());
			System.out.println("King : " + props.getKingHakiExp());
		}
	}
	
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{
		if (event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);
			EntityLivingBase target = event.entityLiving;	
			ItemStack heldItem = player.getHeldItem();
			
			double hakiMultiplier = 1;

			if(target.isPotionActive(Potion.resistance.id))
				hakiMultiplier = 1.25;
			
			if(heldItem != null)
			{
				Ability imbuingBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_IMBUING.getAttributeName());
				boolean hasImbuingBusoActive = imbuingBuso != null && imbuingBuso.isPassiveActive();
				
				if(props.getImbuingHakiExp() <= 600 || hasImbuingBusoActive)
				{
					if(ItemsHelper.isSword(heldItem))
						props.addImbuingHakiExp((int) ((3 + WyMathHelper.randomWithRange(0, 3)) * hakiMultiplier));
					else
						props.addImbuingHakiExp(1);
				}
			}
			else
			{
				Ability hardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_HARDENING.getAttributeName());
				boolean hasHardeningBusoActive = hardeningBuso != null && hardeningBuso.isPassiveActive();
				
				if(props.getHardeningHakiExp() <= 600 || hasHardeningBusoActive)
				{
					props.addHardeningHakiExp((int) ((6 + WyMathHelper.randomWithRange(0, 3)) * hakiMultiplier));
				}
			}
			
			if(props.getDoriki() > 4000 && props.getImbuingHakiExp() > 400 + WyMathHelper.randomWithRange(10, 50))
			{
				this.giveHakiAbility(abilityProps, HakiAbilities.BUSOSHOKU_HAKI_IMBUING, player);
			}
			
			if(props.getDoriki() > 3000 && props.getHardeningHakiExp() > 500 + WyMathHelper.randomWithRange(10, 100))
			{
				this.giveHakiAbility(abilityProps, HakiAbilities.BUSOSHOKU_HAKI_HARDENING, player);
				if(props.getHardeningHakiExp() > 800 + WyMathHelper.randomWithRange(10, 100))
				{
					this.giveHakiAbility(abilityProps, HakiAbilities.BUSOSHOKU_HAKI_FULL_BODY_HARDENING, player);
				}
			}
			
			/*
			System.out.println("Imbuing : " + props.getImbuingHakiExp());
			System.out.println("Hardening : " + props.getHardeningHakiExp());
			System.out.println("Observation : " + props.getObservationHakiExp());
			System.out.println("King : " + props.getKingHakiExp());
			*/
		}
	}
	
	private void giveHakiAbility(AbilityProperties abilityProps, Ability ability, EntityPlayer player)
	{
		if(!abilityProps.hasHakiAbility(ability) && !DevilFruitsHelper.verifyIfAbilityIsBanned(ability))
		{
			abilityProps.addHakiAbility(ability);
			WyHelper.sendMsgToPlayer(player, "Obtained " + ability.getAttribute().getAttributeName());
		}
	}
	
	@SubscribeEvent
	public void onPlayerLoggedIn(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof EntityPlayer && MainConfig.haoshokuHakiUnlockLogic.equalsIgnoreCase("random"))
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			AbilityProperties abilityProps = AbilityProperties.get(player);
			int isKing = (int) (player.getUniqueID().getMostSignificantBits() % 4);
			
			// That moment when your entire chance of getting haoshoku haki is based on the time when you bought minecraft. Design 101
			if(isKing == 0)
				this.giveHakiAbility(abilityProps, HakiAbilities.HAOSHOKU_HAKI, player);
		}
	}
}
