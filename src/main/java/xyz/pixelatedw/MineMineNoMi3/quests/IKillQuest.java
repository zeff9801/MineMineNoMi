package xyz.pixelatedw.MineMineNoMi3.quests;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public interface IKillQuest
{

	boolean isTarget(EntityPlayer player, EntityLivingBase target);
	
}
