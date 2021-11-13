package xyz.pixelatedw.MineMineNoMi3.quests.bounties.lowlevel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.BanditData;
import xyz.pixelatedw.MineMineNoMi3.quests.IKillQuest;

public class BountyLowLevel02 extends Quest implements IKillQuest
{
	public String getQuestID()
	{
		return "bountylowlevel02";	
	}
	
	public String getQuestName()
	{
		return "Bandit Hunter";
	}
	
	public String[] getQuestDescription()
	{
		return new String[] 
				{
					"Some low-life bandits are terrorizing the local villagers",
					"hunt them down fast before they cause more problems !",
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
		props.alterBelly(100);
		WyHelper.sendMsgToPlayer(player, EnumChatFormatting.GOLD + "Reward : 100 Belly");	
		
		super.finishQuest(player);
	}

	public boolean canStart(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		return props.isBountyHunter();
	}

	public double getMaxProgress()
	{
		return 10;
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
		return target instanceof BanditData;
	}
	
	public boolean isRepeatable()
	{
		return true;
	}
}
