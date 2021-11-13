package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import java.util.Arrays;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSpecialFlying;

public class EventsSpecialFlying
{
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);

			Ability abareHimatsuri = abilityProps.getAbilityFromName(ListAttributes.ABARE_HIMATSURI.getAttributeName());
			boolean hasAbareHimatsuri = props.getUsedFruit().equalsIgnoreCase("zushizushi") && abareHimatsuri != null && abareHimatsuri.isPassiveActive();
			
			boolean hasToriFruit = props.getUsedFruit().equalsIgnoreCase("toritoriphoenix") && !props.getZoanPoint().toLowerCase().equals("n/a");
			
			boolean hasFlyingFruit = Arrays.stream(DevilFruitsHelper.flyingFruits).anyMatch(p ->
			{				
				return props.getUsedFruit().equalsIgnoreCase(p);
			});	
			
			if(!player.capabilities.isCreativeMode)
			{
				if(!event.entityLiving.worldObj.isRemote)
				{
					if((MainConfig.enableSpecialFlying && hasFlyingFruit && !DevilFruitsHelper.isNearbyKairoseki(player)) || hasToriFruit || hasAbareHimatsuri)		
					{
						WyNetworkHelper.sendTo(new PacketSpecialFlying(true), (EntityPlayerMP) player);
						player.fallDistance = 0;
					}
					else
						WyNetworkHelper.sendTo(new PacketSpecialFlying(false), (EntityPlayerMP) player);
				}
			
				if(player.capabilities.isFlying && player.worldObj.isRemote)
				{
					double extraOffset = 0;
					
					ResourceLocation particleToUse = null;
					if(props.getUsedFruit().equalsIgnoreCase("mokumoku") )
						particleToUse = ID.PARTICLE_ICON_MOKU;
					else if(props.getUsedFruit().equalsIgnoreCase("gasugasu") )
						particleToUse = ID.PARTICLE_ICON_GASU;
					else if(props.getUsedFruit().equalsIgnoreCase("sunasuna") )
						particleToUse = ID.PARTICLE_ICON_SUNA2;
					else if(props.getUsedFruit().equalsIgnoreCase("toritoriphoenix") )
					{
						particleToUse = ID.PARTICLE_ICON_BLUEFLAME;
						extraOffset = 1;
					}
					
					if(particleToUse != null)
					{
						for (int i = 0; i < 5; i++)
						{							
							double offsetX = 0.5 - player.worldObj.rand.nextDouble();
							double offsetY = player.worldObj.rand.nextDouble();
							double offsetZ = 0.5 - player.worldObj.rand.nextDouble();
							
							MainMod.proxy.spawnCustomParticles(player, 
									new EntityParticleFX(player.worldObj, particleToUse, 
											player.posX + offsetX, 
											player.posY - 2 + offsetY + extraOffset, 
											player.posZ + offsetZ, 
											0, 0, 0)
									.setParticleScale(1.3F).setParticleGravity(-0.05F).setParticleAge(5));
						}
					}
				}
			}
		}
	}
}
