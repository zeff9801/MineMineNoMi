package xyz.pixelatedw.MineMineNoMi3.quests.poneglyphs;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.HistoryProperties;
import xyz.pixelatedw.MineMineNoMi3.helpers.QuestLogicHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.IInteractQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.ITimedQuest;

public class QuestPoneglyphChallengeCrocodile extends Quest implements IInteractQuest, ITimedQuest
{
	@Override
	public String getQuestID()
	{
		return "poneglyph_challenge_crocodile";	
	}
	
	@Override
	public String getQuestName()
	{
		return "Decipher Poneglyph";
	}
	
	@Override
	public String[] getQuestDescription()
	{
		return new String[] 
				{
					"",
					"",
					"",
					"",
					"",
					"",
					""
				};
	}
	
	@Override
	public boolean canStart(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		QuestProperties questProps = QuestProperties.get(player);
		HistoryProperties historyProps = HistoryProperties.get(player);
		
		boolean flagQuestAvailable = historyProps.hasUnlockedChallenge(ID.HISTORY_ENNTRY_NAME_CROCODILE);
		
		if(!flagQuestAvailable)
			return true;

		return false;
	}
	
	@Override
	public void startQuest(EntityPlayer player)
	{
		
	}
	
	@Override
	public double getMaxProgress()
	{
		return 1;
	}

	@Override
	public boolean isPrimary()
	{
		return false;
	}

	@Override
	public boolean isRepeatable()
	{
		return false;
	}
	
	@Override
	public boolean isTarget(EntityPlayer player, EntityLivingBase target)
	{
		boolean flagMob = target instanceof EntityVillager;
		boolean flagLibrarian = flagMob && ((EntityVillager) target).getProfession() == 1;
		
		System.out.println(flagMob + "; " + flagLibrarian);
		
		if(flagMob && flagLibrarian)
		{
			this.setProgress(player, this.getMaxProgress());
			WyNetworkHelper.sendTo(new PacketQuestSync(QuestProperties.get(player)), (EntityPlayerMP) player);
			target.playSound("mob.villager.yes", 1, 1);
			this.isFinished(player);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isFinished(EntityPlayer player)
	{
		if (!player.worldObj.isRemote)
		{
			ItemStack itemStack = QuestLogicHelper.getQuestItemStack(player.inventory, this.getQuestID());
			HistoryProperties historyProps = HistoryProperties.get(player);
			
			boolean flagQuestComplete = this.getProgress() >= this.getMaxProgress();

			if(flagQuestComplete && itemStack != null && itemStack.hasTagCompound())
			{
				String entryName = itemStack.getTagCompound().getString("history_entry");

				historyProps.addUnlockedChallenge(entryName);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void finishQuest(EntityPlayer player)
	{
		WyHelper.sendMsgToPlayer(player, I18n.format("quest." + this.getQuestID() + ".completed"));
		
		ItemStack itemStack = QuestLogicHelper.getQuestItemStack(player.inventory, this.getQuestID());
		
		WyHelper.removeStackFromInventory(player, itemStack);
		
		super.finishQuest(player);
	}
	
	@Override
	public void onTimePassEvent(EntityPlayer player)
	{
		if(!this.isFinished(player))
		{
			ItemStack note = QuestLogicHelper.getQuestItemStack(player.inventory, this.getQuestID());
			QuestProperties questProps = QuestProperties.get(player);

			if(note == null)
				questProps.removeQuestFromTracker(ListQuests.poneglyphChallengeCrocodile);
		}
	}
}
