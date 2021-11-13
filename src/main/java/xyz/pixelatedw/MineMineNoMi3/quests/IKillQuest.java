package xyz.pixelatedw.MineMineNoMi3.quests;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public interface IKillQuest
{

	boolean isTarget(EntityPlayer player, EntityLivingBase target);
	
}
