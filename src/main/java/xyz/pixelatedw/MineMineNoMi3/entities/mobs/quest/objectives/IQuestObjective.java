package xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives;

import net.minecraft.entity.player.EntityPlayer;

public interface IQuestObjective
{	
	void setOwner(EntityPlayer player);
	
	EntityPlayer getOwner();
	
	void setActive(boolean active);
	boolean isActive();
}
