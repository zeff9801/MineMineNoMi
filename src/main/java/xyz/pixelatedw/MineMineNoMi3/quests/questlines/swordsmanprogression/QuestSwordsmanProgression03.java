package xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.ItemCoreWeapon;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IKillQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;

public class QuestSwordsmanProgression03 extends Quest implements IKillQuest, IProgressionQuest
{

	public String getQuestID()
	{
		return "swordsmanprogression03";	
	}
	
	public String getQuestName()
	{
		return "Feel the Wind";
	}
	
	public String[] getQuestDescription()
	{
		return new String[] 
				{
					" Killing 20 creatures near the mountains, apparently",
					"that is my next trial. Not so hard but it seems...",
					"pointless.",
					"",
					"",
					"",
					""
				};
	}
	
	public void startQuest(EntityPlayer player)
	{
		WyHelper.sendMsgToPlayer(player, I18n.format("quest." + this.getQuestID() + ".started"));	
		
		super.startQuest(player);
	}

	public void finishQuest(EntityPlayer player)
	{
		WyHelper.sendMsgToPlayer(player, I18n.format("quest." + this.getQuestID() + ".completed"));	

		super.finishQuest(player);
	}

	public boolean canStart(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		QuestProperties questProps = QuestProperties.get(player);
		
		boolean flag1 = !props.isSwordsman() || !questProps.hasQuestCompleted(ListQuests.swordsmanProgression02);
		
		if(flag1)
			return false;

		return true;
	}

	public double getMaxProgress()
	{
		return 20;
	}

	public boolean isPrimary()
	{
		return true;
	}

	public EnumQuestlines getQuestLine()
	{
		return EnumQuestlines.SWORDSMAN_PROGRESSION;
	}

	public boolean isRepeatable()
	{
		return false;
	}

	@Override
	public boolean isTarget(EntityPlayer player, EntityLivingBase target)
	{
		BiomeGenBase biome = player.worldObj.getBiomeGenForCoordsBody((int)player.posX, (int)player.posZ);
		ItemStack heldItem = player.getHeldItem();
		
		if((biome.biomeName.equalsIgnoreCase(BiomeGenBase.extremeHills.biomeName) || biome.biomeName.equalsIgnoreCase(BiomeGenBase.extremeHillsPlus.biomeName)) 
				&& target instanceof EntityMob && heldItem != null && (heldItem.getItem() instanceof ItemCoreWeapon || heldItem.getItem() instanceof ItemSword))
		{
			return true;
		}
		
		return false;
	}

}
