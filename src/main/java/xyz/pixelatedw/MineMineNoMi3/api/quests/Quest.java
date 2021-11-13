package xyz.pixelatedw.MineMineNoMi3.api.quests;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;

public abstract class Quest
{

	protected NBTTagCompound extraData;
	
	protected double questProgress;
	
	public abstract String getQuestID();
	
	public abstract String getQuestName();
	
	public abstract String[] getQuestDescription();
	
	public void startQuest(EntityPlayer player)
	{
		WyHelper.sendMsgToPlayer(player, EnumChatFormatting.GREEN + I18n.format("quest." + this.getQuestID() + ".name") + " " + I18n.format(ID.LANG_GUI_QUESTS_STARTED));
	}
	
	public abstract boolean isPrimary();
	
	public abstract boolean isRepeatable();
	
	public void finishQuest(EntityPlayer player)
	{	
		QuestProperties questProps = QuestProperties.get(player);
		questProps.removeQuestFromTracker(this);
		questProps.addCompletedQuest(this);
		WyNetworkHelper.sendTo(new PacketQuestSync(questProps), (EntityPlayerMP) player);
		
		WyHelper.sendMsgToPlayer(player, EnumChatFormatting.GREEN + I18n.format("quest." + this.getQuestID() + ".name") + " " + I18n.format(ID.LANG_GUI_QUESTS_COMPLETED));
	}
	
	public abstract boolean canStart(EntityPlayer player);
	
	public boolean isFinished(EntityPlayer player)
	{
		if(this.questProgress >= this.getMaxProgress())
		{
			return true;
		}
		
		return false;
	}
	
	public double getProgress()
	{
		return questProgress;
	}
	
	public double getMaxProgress()
	{
		return 1;
	}
	
	public void setProgress(EntityPlayer player, double progress)
	{
		if(progress <= this.getMaxProgress())
			this.questProgress = progress;
		else
			this.questProgress = this.getMaxProgress();
	}

	public void alterProgress(EntityPlayer player, double progress) 
	{
		if(this.questProgress + progress <= this.getMaxProgress())
			this.questProgress += progress;
		else
			this.questProgress = this.getMaxProgress();	
	}

}
