package xyz.pixelatedw.MineMineNoMi3.quests;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;

public interface IInteractQuest
{

	boolean isTarget(EntityPlayer player, EntityLivingBase target);
		
}
