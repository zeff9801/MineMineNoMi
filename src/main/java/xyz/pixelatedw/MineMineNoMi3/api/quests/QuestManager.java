package xyz.pixelatedw.MineMineNoMi3.api.quests;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;

public class QuestManager
{
	
	private static QuestManager instance;
	public static QuestManager instance()
	{
		if(instance == null) instance = new QuestManager();
		return instance;
	}

	public Quest startQuest(EntityPlayer player, Quest quest)
	{
		Quest nQuest = null;
		QuestProperties questProps = QuestProperties.get(player);
		
		if(questProps.hasQuestCompleted(quest) && !quest.isRepeatable())
		{
			WyHelper.sendMsgToPlayer(player, quest.getQuestName() + " was completed and cannot be started again!");
			return null;
		}
		
		if(questProps.hasQuestInTracker(quest))
		{
			WyHelper.sendMsgToPlayer(player, quest.getQuestName() + " is already in progress!");
			return null;
		}
		
		if(!quest.canStart(player))	
			return null;

		try
		{
			nQuest = quest.getClass().newInstance();
		} 
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		
		questProps.addQuestInTracker(nQuest);
		nQuest.startQuest(player);
		return nQuest;
	}
	
	public Quest getQuestByNameFromList(HashMap<String, Quest> list, String questId)
	{
		for(Quest q : list.values())
		{
			if(q.getQuestID().toLowerCase().equals(questId.toLowerCase()))
				return q;
		}
		
		return null;
	}
}
