package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;

public class EventsOneDevilFruit
{
	
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(props.hasDevilFruit())
			{
				ExtendedWorldData worldData = ExtendedWorldData.get(player.worldObj);				
				worldData.removeDevilFruitFromWorld(props.getUsedFruit());
			}
		}	
	}

	@SubscribeEvent
	public void onDFItemExpires(ItemExpireEvent event)
	{
		if(event.entityItem.getEntityItem().getItem() instanceof AkumaNoMi)
		{
			ExtendedWorldData worldData = ExtendedWorldData.get(event.entity.worldObj);				
			
			worldData.removeDevilFruitFromWorld((AkumaNoMi) event.entityItem.getEntityItem().getItem());
		}
	}
	
}
