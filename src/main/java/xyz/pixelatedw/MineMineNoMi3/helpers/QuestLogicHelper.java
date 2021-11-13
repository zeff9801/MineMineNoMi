package xyz.pixelatedw.MineMineNoMi3.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.quests.ITimedQuest;

import java.util.ArrayList;
import java.util.List;

public class QuestLogicHelper
{
	
	public static ItemStack getQuestItemStack(InventoryPlayer inventory, String forQuest)
	{
		for(int i = 0; i < inventory.mainInventory.length; i++)
		{
			ItemStack itemStack = inventory.getStackInSlot(i);
			if(itemStack != null && itemStack.hasTagCompound())
			{
				String nbtForQuest = itemStack.getTagCompound().getString("ForQuest");
				
				if(nbtForQuest.equalsIgnoreCase(forQuest))
					return itemStack;
			}
		}
		
		return null;
	}
	
	public static int turnInQuestlineQuest(EntityPlayer player, Quest[] questline)
	{
		QuestProperties questProps = QuestProperties.get(player);
		int turnedInQuests = 0;

		for(int i = 0; i < Values.MAX_ACTIVITIES; i++)
		{
			if(questProps.getQuestIndexFromTracker(i) != null && questProps.getQuestIndexFromTracker(i).isFinished(player) && isQuestPartofQuestline(questProps.getQuestIndexFromTracker(i), questline))
			{
				if(player.worldObj.isRemote)
					return 0;
				
				questProps.getQuestIndexFromTracker(i).finishQuest(player);
				turnedInQuests++;
			}
		}
		
		return turnedInQuests;
	}
	
	public static Quest getQuestlineCurrentQuest(Quest[] questline, QuestProperties questProps)
	{	
		if(questProps.hasQuestCompleted(questline[questline.length - 1]))
			return null;
		
		for(int i = 0; i < questline.length; i++)
		{
			if(!questProps.hasQuestCompleted(questline[i]))
				return questline[i];
		}
		
		return questline[0];		
	}
	
	public static List<ITimedQuest> checkForITimedQuests(QuestProperties questProps)
	{		
		List<ITimedQuest> timedQuests = new ArrayList<ITimedQuest>();
		
		if(questProps.questsInProgress() <= 0)
			return timedQuests;
		
		for(int i = 0; i < questProps.questsInProgress(); i++)
		{
			if(questProps.getQuestIndexFromTracker(i) instanceof ITimedQuest)
				timedQuests.add((ITimedQuest) questProps.getQuestIndexFromTracker(i));
		}
		
		return timedQuests;		
	}
	
	public static boolean isQuestPartofQuestline(Quest quest, Quest[] questline)
	{		
		for(int i = 0; i < questline.length; i++)
		{
			if(questline[i].getQuestID().toLowerCase().equals(quest.getQuestID().toLowerCase()))
				return true;
		}
		
		return false;		
	}
	
}
