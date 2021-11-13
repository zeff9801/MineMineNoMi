package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;

public class EventsDFWeaknesses
{

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityLivingBase)
		{
			EntityLivingBase entity = event.entityLiving;
			ExtendedEntityData props = ExtendedEntityData.get(entity);

			if(props.hasDevilFruit() && DevilFruitsHelper.isAffectedByWater(entity))
			{			
				if(entity instanceof EntityPlayer && !((EntityPlayer) entity).capabilities.isCreativeMode)	
					entity.motionY -= 5;
				else if(entity instanceof EntityNewMob)
					entity.motionY -= 5;
			}
		}
		
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);
			ItemStack heldItem = player.getHeldItem();
			boolean updateDisabledAbilities = false;
			
			if (!player.worldObj.isRemote)
			{
				if (props.hasDevilFruit() && ItemsHelper.hasKairosekiItem(player))
					player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 200, 0));
				
				if (props.hasDevilFruit() && DevilFruitsHelper.isNearbyKairoseki(player))
				{
					for (int i = 0; i < abilityProps.countAbilitiesInHotbar(); i++)
					{
						if (abilityProps.getAbilityFromSlot(i) != null && !abilityProps.getAbilityFromSlot(i).isDisabled() && !abilityProps.getAbilityFromSlot(i).isOnCooldown())
						{						
							abilityProps.getAbilityFromSlot(i).endPassive(player);
							abilityProps.getAbilityFromSlot(i).setCooldownActive(true);
							abilityProps.getAbilityFromSlot(i).disable(player, true);
							updateDisabledAbilities = true;
						}
					}
					
					if(updateDisabledAbilities)
						WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP) player);					
					player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 100, 0));
				}
				else
				{
					for (int i = 0; i < abilityProps.countAbilitiesInHotbar(); i++)
					{										
						if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isDisabled())
						{
							abilityProps.getAbilityFromSlot(i).setPassiveActive(false);
							abilityProps.getAbilityFromSlot(i).disable(player, false);
							abilityProps.getAbilityFromSlot(i).startUpdate(player);
							updateDisabledAbilities = true;
						}
						
					}

					for(int i = 0; i < abilityProps.countAbilitiesInHotbar(); i++)
					{					
						if(abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isRepeating())
						{ 					
							abilityProps.getAbilityFromSlot(i).duringRepeater(player);
						}				
					}

					if(updateDisabledAbilities)
						WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP) player);
				}
			}
		}
	}
}
