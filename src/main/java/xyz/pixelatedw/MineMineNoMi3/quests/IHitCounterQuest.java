package xyz.pixelatedw.MineMineNoMi3.quests;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;

public interface IHitCounterQuest
{

	boolean checkHit(EntityPlayer player, EntityLivingBase target, DamageSource source);
	
}
