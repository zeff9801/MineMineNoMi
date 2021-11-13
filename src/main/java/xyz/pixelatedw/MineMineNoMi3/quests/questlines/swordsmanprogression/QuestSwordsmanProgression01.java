package xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.givers.EntityDojoSensei;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.ItemCoreWeapon;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IInteractQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;

import java.util.Iterator;
import java.util.Map.Entry;

public class QuestSwordsmanProgression01 extends Quest implements IInteractQuest, IProgressionQuest
{
	
	@Override
	public String getQuestID()
	{
		return "swordsmanprogression01";	
	}
	
	@Override
	public String getQuestName()
	{
		return "Road to becoming the Best Swordsman";
	}
	
	@Override
	public String[] getQuestDescription()
	{
		return new String[] 
				{
					" I'm starting my journey to become the best swordsman",
					"in the world. Proving the Master that  I'm ready won't",
					"be easy but I need to start somewhere.",
					"",
					"",
					"",
					""
				};
	}

	@Override
	public void startQuest(EntityPlayer player)
	{
		WyHelper.sendMsgToPlayer(player, I18n.format("quest." + this.getQuestID() + ".started"));								
	
		super.startQuest(player);
	}

	@Override
	public void finishQuest(EntityPlayer player)
	{
		WyHelper.sendMsgToPlayer(player, I18n.format("quest." + this.getQuestID() + ".completed"));								
		
		super.finishQuest(player);
	}

	@Override
	public boolean canStart(EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		return props.isSwordsman();
	}

	@Override
	public double getMaxProgress()
	{
		return 1;
	}

	@Override
	public void setProgress(EntityPlayer player, double progress) 
	{
		super.setProgress(player, progress);
	}
		
	@Override
	public void alterProgress(EntityPlayer player, double progress) 
	{
		super.alterProgress(player, progress);
		
		if(this.isFinished(player))
			this.finishQuest(player);	
	}

	@Override
	public boolean isPrimary()
	{
		return true;
	}

	@Override
	public boolean isTarget(EntityPlayer player, EntityLivingBase target)
	{
		ItemStack heldItem = player.getHeldItem();
		QuestProperties questProps = QuestProperties.get(player);
		
		if(!(target instanceof EntityDojoSensei))
			return false;
		
		if(heldItem != null && (heldItem.getItem() instanceof ItemSword || heldItem.getItem() instanceof ItemCoreWeapon))
		{

			for (Object o : heldItem.getAttributeModifiers().entries()) {
				Entry entry = (Entry) o;

				if (entry.getKey().equals(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName())) {
					AttributeModifier attrmodif = (AttributeModifier) entry.getValue();
					double damage = attrmodif.getAmount();

					if (damage >= 7) {
						return true;
					} else {
						WyHelper.sendMsgToPlayer(player, "<Swordsman Master> That sword of yours is way too weak, you won't get anywhere with that excuse of a sword.");
						return false;
					}
				}
			}		
		}
		
		return false;
	}

	@Override
	public EnumQuestlines getQuestLine()
	{
		return EnumQuestlines.SWORDSMAN_PROGRESSION;
	}

	@Override
	public boolean isRepeatable()
	{
		return false;
	}

}
