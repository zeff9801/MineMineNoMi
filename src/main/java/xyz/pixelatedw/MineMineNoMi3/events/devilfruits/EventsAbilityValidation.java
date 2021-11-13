package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class EventsAbilityValidation
{
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			QuestProperties questProps = QuestProperties.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);
			
			if (!player.worldObj.isRemote)
			{			
				//if (!props.hasRace() && !props.hasFaction() && !props.hasFightingStyle() && !player.inventory.hasItemStack(new ItemStack(ListMisc.CharacterCreator)))
				//	player.inventory.addItemStackToInventory(new ItemStack(ListMisc.CharacterCreator, 1));
				
				if(props.getUsedFruit() != null && !props.getUsedFruit().equalsIgnoreCase("n/a"))
				{					
					ItemStack df = DevilFruitsHelper.getDevilFruitItem(props.getUsedFruit());
					
					abilityProps.clearDevilFruitAbilities();
					props.setGear(1);
					if(!props.getZoanPoint().equalsIgnoreCase("yomi"))
						props.setZoanPoint("n/a");
					
					if(df != null && df.getItem() != null)
					{
						if(props.hasYamiPower())
						{
							ItemStack yami = DevilFruitsHelper.getDevilFruitItem("yamiyami");
							for(Ability a : ((AkumaNoMi)yami.getItem()).abilities)
								if(!DevilFruitsHelper.verifyIfAbilityIsBanned(a))
									abilityProps.addDevilFruitAbility(a);
						}
						for(Ability a : ((AkumaNoMi)df.getItem()).abilities)
							if(!DevilFruitsHelper.verifyIfAbilityIsBanned(a))
								abilityProps.addDevilFruitAbility(a);
					}
					
					for(Ability a : abilityProps.getAbilitiesInHotbar())
						if(a != null && a.isOnCooldown())
							a.startUpdate(player);
				}
				
				DevilFruitsHelper.validateRacialMoves(player);
				DevilFruitsHelper.validateStyleMoves(player);
				
				for(int i = 0; i < abilityProps.countAbilitiesInHotbar(); i++)
				{
					if(abilityProps.getAbilityFromSlot(i) != null)
					{
						if(DevilFruitsHelper.verifyIfAbilityIsBanned(abilityProps.getAbilityFromSlot(i)))
							abilityProps.setAbilityInSlot(i, null);
					}
				}			
				
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				WyNetworkHelper.sendTo(new PacketQuestSync(questProps), (EntityPlayerMP) player);
				WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP) player);	
				
				//WyNetworkHelper.sendTo(new PacketAbilityReset(true), (EntityPlayerMP) player);
			}		
		}
	}
}
