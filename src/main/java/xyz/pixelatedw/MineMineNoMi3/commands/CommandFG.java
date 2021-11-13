package xyz.pixelatedw.MineMineNoMi3.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.abilities.HakiAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestManager;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.data.HistoryProperties;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.baroqueWorks.EntityMr0;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMorgan;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDugong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDummy;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityLapahn;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityYagaraBull;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.world.TeleporterScenarioArena;
import xyz.pixelatedw.MineMineNoMi3.world.structures.StructureBanditSmallBase;
import xyz.pixelatedw.MineMineNoMi3.world.structures.StructureLargeShip;
import xyz.pixelatedw.MineMineNoMi3.world.structures.StructureMarineLargeBase;

public class CommandFG extends CommandBase
{	
	
	private Quest[] questsPool = new Quest[] {ListQuests.bountyLowLevel01, ListQuests.bountyLowLevel02, ListQuests.bountyLowLevel03};
	
	@Override
	public void processCommand(ICommandSender sender, String[] str) 
	{
		if(str.length >= 1)
		{
			EntityPlayer player = CommandBase.getCommandSenderAsPlayer(sender);
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);
			QuestProperties questProps = QuestProperties.get(player);
			HistoryProperties historyProps = HistoryProperties.get(player);
			Entity toSpawn = null;

			if(str[0].equalsIgnoreCase("dummy"))
				toSpawn = new TempEntityDummy(player.worldObj);
			else if(str[0].equalsIgnoreCase("mr0"))
				toSpawn = new EntityMr0(player.worldObj);
			else if(str[0].equalsIgnoreCase("morgan"))
				toSpawn = new EntityMorgan(player.worldObj);
			else if(str[0].equalsIgnoreCase("dugong"))
				toSpawn = new TempEntityDugong(player.worldObj);
			else if(str[0].equalsIgnoreCase("lapahn"))
				toSpawn = new TempEntityLapahn(player.worldObj);
			else if(str[0].equalsIgnoreCase("yagarabull"))
				toSpawn = new TempEntityYagaraBull(player.worldObj);
			
			if(str[0].equalsIgnoreCase("package"))
			{			
				toSpawn = new EntityWantedPostersPackage(player.worldObj);
				toSpawn.setLocationAndAngles(player.posX + WyMathHelper.randomWithRange(-10, 10), player.posY + 30, player.posZ + WyMathHelper.randomWithRange(-10, 10), 0, 0);
				player.worldObj.spawnEntityInWorld(toSpawn);
				return;
			}
			
			else if(str[0].equalsIgnoreCase("randBounties"))
			{
				ExtendedWorldData worldData = ExtendedWorldData.get(player.worldObj);
				
				for(int i = 1; i < 10; i++)
				{
					worldData.issueBounty("Test Name #"+i, i*100 + player.worldObj.rand.nextInt(1000));
				}
			}
			else if(str[0].equalsIgnoreCase("monsterspawner"))
			{
				String toSpawn1 = ID.PROJECT_ID + ".Marine with Sword";
				
				TileEntityCustomSpawner spw1 = new TileEntityCustomSpawner().setSpawnerMob(toSpawn1).setSpawnerLimit(5);
				player.worldObj.setBlock((int)player.posX, (int)player.posY + 1, (int)player.posZ, ListMisc.CustomSpawner );
				player.worldObj.setTileEntity((int)player.posX, (int)player.posY + 1, (int)player.posZ, spw1);
			}
			
			else if(str[0].equalsIgnoreCase("scenario"))
			{
				if(str[1].equalsIgnoreCase("start"))
				{
					if(!player.worldObj.isRemote)
						new TeleporterScenarioArena((WorldServer) player.worldObj).teleport(player, ID.SCENARIO_ROMANCEDAWN_CAPTAINMORGAN);
				}
				else if(str[1].equalsIgnoreCase("end"))
				{
					if(!player.worldObj.isRemote)
						new TeleporterScenarioArena((WorldServer) player.worldObj).endScenario(player, ID.SCENARIO_ROMANCEDAWN_CAPTAINMORGAN);
				}
			}
			else if(str[0].equalsIgnoreCase("maxcola"))
			{
				if(!props.hasColaBackpack())
					props.setMaxCola(250);
				else
					props.setMaxCola(450);
			}
			else if(str[0].equalsIgnoreCase("fillcola"))
				props.setCola(props.getMaxCola());
			else if(str[0].equalsIgnoreCase("rngquest"))
			{
				//QuestManager.instance().startQuest(player, questsPool[player.getRNG().nextInt(questsPool.length)]);
				QuestManager.instance().startQuest(player, ListQuests.bountyLowLevel01);
				WyNetworkHelper.sendTo(new PacketQuestSync(questProps), (EntityPlayerMP) player);
			}
			else if(str[0].equalsIgnoreCase("questprogress"))
			{
				Quest[] questline = null;
				
				if(str.length < 3)
					WyHelper.sendMsgToPlayer(player, "Incorrect syntax");
				
				if(str[1].equalsIgnoreCase("swordsman"))
					questline = EnumQuestlines.SWORDSMAN_PROGRESSION.getQuests();
				else if(str[1].equalsIgnoreCase("sniper"))
					questline = EnumQuestlines.SNIPER_PROGRESSION.getQuests();
									
				int questNo = Integer.parseInt(str[2]);
				
				if(questline == null)
					WyHelper.sendMsgToPlayer(player, "Incorrect Questline");
				
				for(int i = 0; i < questNo; i++)
				{				
					try
					{
						Quest nQuest = questline[i].getClass().newInstance();
						questProps.addQuestInTracker(nQuest);
						questProps.getQuestIndexFromTracker(0).startQuest(player);
						questProps.getQuestIndexFromTracker(0).finishQuest(player);
						WyNetworkHelper.sendTo(new PacketQuestSync(questProps), (EntityPlayerMP) player);
					}
					catch (InstantiationException | IllegalAccessException e)
					{
						e.printStackTrace();
					}
				}
			}
			else if(str[0].equalsIgnoreCase("resetquests"))
			{
				questProps.clearQuestTracker();
				questProps.clearCompletedQuests();
				WyNetworkHelper.sendTo(new PacketQuestSync(questProps), (EntityPlayerMP) player);
			}

			else if(str[0].equalsIgnoreCase("marinebase"))
				StructureMarineLargeBase.build(WySchematicHelper.load("marineLargeBase"), player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, player.worldObj.getBiomeGenForCoordsBody((int)player.posX, (int)player.posZ));
			else if(str[0].equalsIgnoreCase("banditbase"))
				StructureBanditSmallBase.build(WySchematicHelper.load("banditBase"), player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, player.worldObj.getBiomeGenForCoordsBody((int)player.posX, (int)player.posZ));
			else if(str[0].equalsIgnoreCase("marineShip"))
			{
				Schematic sch = WySchematicHelper.load("marineLargeShip");
				WySchematicHelper.build(sch, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
				StructureLargeShip.populate((int)player.posX, (int)player.posY, (int)player.posZ, player.worldObj, sch.getName());
			}
			else if(str[0].equalsIgnoreCase("pirateShip"))
			{
				Schematic sch = WySchematicHelper.load("pyrateLargeShip");
				WySchematicHelper.build(sch, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
				StructureLargeShip.populate((int)player.posX, (int)player.posY, (int)player.posZ, player.worldObj, sch.getName());
			}
			else if(str[0].equalsIgnoreCase("reset_history"))
			{
				historyProps.removeUnlockedChallenge("crocodile");
			}
			
			else if(str[0].equalsIgnoreCase("haki"))
			{
				if(str[1].equalsIgnoreCase("aura"))
				{
					abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_AURA);
					WyHelper.sendMsgToPlayer(player, "Kenbunshoku Haki: Aura Unlocked");
				}
				else if(str[1].equalsIgnoreCase("futuresight"))
				{
					abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_FUTURE_SIGHT);
					WyHelper.sendMsgToPlayer(player, "Kenbunshoku Haki: Future Sight Unlocked");
				}
				else if(str[1].equalsIgnoreCase("hardening"))
				{
					abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_HARDENING);
					WyHelper.sendMsgToPlayer(player, "Busoshoku Haki: Hardening Unlocked");
				}
				else if(str[1].equalsIgnoreCase("fullbody"))
				{
					abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_FULL_BODY_HARDENING);
					WyHelper.sendMsgToPlayer(player, "Busoshoku Haki: Full Body Hardening Unlocked");
				}
				else if(str[1].equalsIgnoreCase("imbuing"))
				{
					abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_IMBUING);
					WyHelper.sendMsgToPlayer(player, "Busoshoku Haki: Imbuing Unlocked");
				}
				else if(str[1].equalsIgnoreCase("hao"))
				{
					abilityProps.addHakiAbility(HakiAbilities.HAOSHOKU_HAKI);
					WyHelper.sendMsgToPlayer(player, "Haoshoku Haki");
				}
				else if(str[1].equalsIgnoreCase("all"))
				{
					abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_AURA);
					abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_FUTURE_SIGHT);
					abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_HARDENING);
					abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_FULL_BODY_HARDENING);
					abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_IMBUING);
					abilityProps.addHakiAbility(HakiAbilities.HAOSHOKU_HAKI);
					WyHelper.sendMsgToPlayer(player, "Unlocked All Haki Types");
				}
			}
			
			if(toSpawn != null)
			{
				toSpawn.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
				player.worldObj.spawnEntityInWorld(toSpawn);
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender cmd)
	{
		return true;
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/fg <entity>";
	}

	@Override
	public String getCommandName() 
	{
		return "fg";
	}

}
