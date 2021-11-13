package xyz.pixelatedw.MineMineNoMi3.quests.bounties.lowlevel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;
import xyz.pixelatedw.MineMineNoMi3.quests.IKillQuest;

public class BountyLowLevel03 extends Quest implements IKillQuest
{
	public String getQuestID()
	{
		return "bountylowlevel03";	
	}
	
	public String getQuestName()
	{
		return "Common Bounty #3";
	}
	
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
					"",
				};
	}
	
	public void startQuest(EntityPlayer player)
	{
		super.startQuest(player);
	}

	public void finishQuest(EntityPlayer player)
	{		
		ExtendedEntityData props = ExtendedEntityData.get(player);	
		props.alterBelly(150);
		WyHelper.sendMsgToPlayer(player, EnumChatFormatting.GOLD + "Reward : 150 Belly");		
		super.finishQuest(player);
	}

	public boolean canStart(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		return props.isBountyHunter();
	}

	public double getMaxProgress()
	{
		return 1;
	}

	public void setProgress(EntityPlayer player, double progress) 
	{
		super.setProgress(player, progress);
	}
	
	public void alterProgress(EntityPlayer player, double progress) 
	{
		super.alterProgress(player, progress);
	}

	public boolean isPrimary()
	{
		return false;
	}

	public boolean isTarget(EntityPlayer player, EntityLivingBase target)
	{
		return target instanceof PirateData;
	}
	
	public boolean isRepeatable()
	{
		return true;
	}
}
