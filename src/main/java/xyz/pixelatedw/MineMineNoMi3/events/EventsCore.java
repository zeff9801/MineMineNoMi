package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.ClickEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.data.HistoryProperties;

public class EventsCore
{
	
	// Registering the extended properties
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityLivingBase && ExtendedEntityData.get((EntityLivingBase) event.entity) == null)
			ExtendedEntityData.register((EntityLivingBase) event.entity);

		if (event.entity instanceof EntityPlayer)
		{
			if(QuestProperties.get((EntityPlayer) event.entity) == null)
				QuestProperties.register((EntityPlayer) event.entity);
			if(AbilityProperties.get((EntityPlayer) event.entity) == null)
				AbilityProperties.register((EntityPlayer) event.entity);
			if(HistoryProperties.get((EntityPlayer) event.entity) == null)
				HistoryProperties.register((EntityPlayer) event.entity);
		}
	}
	
	// Cloning the player data to the new entity based on the config option
	@SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone e) 
	{
		if(e.wasDeath) 
		{		
	    	ExtendedWorldData worldProps = ExtendedWorldData.get(e.original.worldObj);

			ExtendedEntityData oldPlayerProps = ExtendedEntityData.get(e.original);	
			ExtendedEntityData newPlayerProps = ExtendedEntityData.get(e.entityPlayer);

			//WyNetworkHelper.sendTo(new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP) e.entityPlayer);
			
			if(MainConfig.enableKeepIEEPAfterDeath.equals("full"))
			{
				NBTTagCompound compound = new NBTTagCompound();
				
				ExtendedEntityData oldProps = ExtendedEntityData.get(e.original);
				oldProps.saveNBTData(compound);
				oldProps.triggerActiveHaki(false);
				oldProps.triggerBusoHaki(false);
				oldProps.triggerKenHaki(false);
				oldProps.setGear(1);
				oldProps.setZoanPoint("n/a");
				ExtendedEntityData props = ExtendedEntityData.get(e.entityPlayer);
				props.loadNBTData(compound);				
				
				compound = new NBTTagCompound();
				AbilityProperties.get(e.original).saveNBTData(compound);
				AbilityProperties abilityProps = AbilityProperties.get(e.entityPlayer);
				abilityProps.loadNBTData(compound);
				
				if(e.entityPlayer != null && MainConfig.enableExtraHearts)		
				{
					IAttributeInstance maxHp = e.entityPlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth);
								
					if(props.getDoriki() / 100 <= 20)
						e.entityPlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
					else
						e.entityPlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(props.getDoriki() / 100);
				}
			}
			else if(MainConfig.enableKeepIEEPAfterDeath.equals("auto"))
			{
				ExtendedEntityData oldProps = ExtendedEntityData.get(e.original);
				
				String faction = oldProps.getFaction();
				String race = oldProps.getRace();
				String fightStyle = oldProps.getFightStyle();
				String crew = oldProps.getCrew();
				int doriki = MathHelper.ceiling_double_int(WyMathHelper.percentage(MainConfig.dorikiKeepPercentage, oldProps.getDoriki()));
				int bounty = MathHelper.ceiling_double_int(WyMathHelper.percentage(MainConfig.bountyKeepPercentage, oldProps.getBounty()));
				int belly = MathHelper.ceiling_double_int(WyMathHelper.percentage(MainConfig.bellyKeepPercentage, oldProps.getBelly()));

				worldProps.removeDevilFruitFromWorld(oldProps.getUsedFruit());
				
				ExtendedEntityData props = ExtendedEntityData.get(e.entityPlayer);
				props.setFaction(faction);
				props.setRace(race);
				props.setFightStyle(fightStyle);
				props.setCrew(crew);			
				props.setMaxCola(100);
				props.setCola(oldProps.getMaxCola());
				props.setDoriki(doriki);
				props.setBounty(bounty);
				props.setBelly(belly);
				
			}
			else if(MainConfig.enableKeepIEEPAfterDeath.equals("custom"))
			{
				ExtendedEntityData oldProps = ExtendedEntityData.get(e.original);
				ExtendedEntityData props = ExtendedEntityData.get(e.entityPlayer);

				for(String stat : MainConfig.statsToKeep)
				{
					switch(WyHelper.getFancyName(stat))
					{
						case "doriki":
							int doriki = MathHelper.ceiling_double_int(WyMathHelper.percentage(MainConfig.dorikiKeepPercentage, oldProps.getDoriki()));
							props.setDoriki(doriki); 
							break;
						case "bounty":
							int bounty = MathHelper.ceiling_double_int(WyMathHelper.percentage(MainConfig.bountyKeepPercentage, oldProps.getBounty()));
							props.setBounty(bounty); 
							break;
						case "belly":
							int belly = MathHelper.ceiling_double_int(WyMathHelper.percentage(MainConfig.bellyKeepPercentage, oldProps.getBelly()));
							props.setBelly(belly); 
							break;
						case "race":
							props.setRace(oldProps.getRace()); break;
						case "faction":
							props.setFaction(oldProps.getFaction()); break;
						case "fightingstyle":
							props.setFightStyle(oldProps.getFightStyle()); break;
						case "devilfruit":
							props.setUsedFruit(oldProps.getUsedFruit()); break;
					}
				}
				
				if(WyHelper.isNullOrEmpty(props.getUsedFruit()))
					worldProps.removeDevilFruitFromWorld(oldProps.getUsedFruit());
			}
			
			NBTTagCompound compound = new NBTTagCompound();
			QuestProperties.get(e.original).saveNBTData(compound);
			QuestProperties questProps = QuestProperties.get(e.entityPlayer);
			questProps.loadNBTData(compound);
		}
	}
	
	// Protection code and the update notification message
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;

			if (!player.worldObj.isRemote)
			{
				if(!WyHelper.isReleaseBuild())
				{
					if(!WyHelper.hasPatreonAccess(player))
					{
						((EntityPlayerMP)player).playerNetServerHandler.kickPlayerFromServer(EnumChatFormatting.BOLD + "" + EnumChatFormatting.RED + "WARNING! \n\n " + EnumChatFormatting.RESET + "You don't have access to this version yet!");
						if(!WyDebug.isDebug())
						{
							WyTelemetry.addMiscStat("onlinePlayers", "Online Players", -1);
							WyTelemetry.sendAllDataSync();
						}
						event.setCanceled(true);
						return;
					}
				}
				
				if(MainConfig.enableUpdateMsg)
				{
					try 
					{
						String[] version = ID.PROJECT_VERSION.replaceAll("[^0-9.]", "").split("\\.");
						
						int currentX = Integer.parseInt(version[0]) * 100;
						int currentY = Integer.parseInt(version[1]) * 10;
						int currentZ = Integer.parseInt(version[2]);
						
						int currentVersion = currentX + currentY + currentZ;
						
						String apiURL = "/version?minecraft-version=" + ID.PROJECT_MCVERSION;
						
						String result = WyTelemetry.sendGET(apiURL);
						
						if(!WyHelper.isNullOrEmpty(result))
						{
							String[] resultVersion = result.replaceAll("[^0-9.]", "").split("\\.");
							
							int latestX = Integer.parseInt(resultVersion[0]) * 100;
							int latestY = Integer.parseInt(resultVersion[1]) * 10;
							int latestZ = Integer.parseInt(resultVersion[2]);
							
							int latestVersion = latestX + latestY + latestZ;
							
							if(latestVersion > currentVersion)
							{
								ChatStyle updateStyle = new ChatStyle().setColor(EnumChatFormatting.GOLD).setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://pixelatedw.xyz/versions"));
								
								player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "[UPDATE]" + EnumChatFormatting.RED + " Mine Mine no Mi " + result + " is now available !").setChatStyle(updateStyle) );
								player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Download it from the official website : [http://pixelatedw.xyz/versions]").setChatStyle(updateStyle) );
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("Connection failed !");
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerLoggedIn(ClientConnectedToServerEvent event)
	{
		if(!WyDebug.isDebug())
		{
			WyTelemetry.addMiscStat("onlinePlayers", "Online Players", 1);
			WyTelemetry.sendAllData();
		}
	}
	
	@SubscribeEvent
	public void onPlayerLoggedOut(ClientDisconnectionFromServerEvent event)
	{
		if(!WyDebug.isDebug())
		{
			WyTelemetry.addMiscStat("onlinePlayers", "Online Players", -1);
			WyTelemetry.sendAllDataSync();
		}
	}
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		if(event.phase == Phase.END && event.side == Side.SERVER)
		{
			if(event.player.worldObj.getWorldTime() % 1200 == 0)
			{
				WyTelemetry.sendAllData();
			}
		}
	}
}
