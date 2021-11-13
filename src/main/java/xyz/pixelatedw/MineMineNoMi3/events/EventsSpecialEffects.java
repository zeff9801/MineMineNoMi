package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListEffects;

public class EventsSpecialEffects
{

	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event)
	{	
		if (event.source.getSourceOfDamage() instanceof EntityPlayer && !event.source.isExplosion())
		{
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			ExtendedEntityData props = ExtendedEntityData.get(player);
			ItemStack heldItem = player.getHeldItem();
			
			if(heldItem != null && heldItem.isItemEnchanted() && !player.worldObj.isRemote)
			{
				int impactDialLevel = EnchantmentHelper.getEnchantmentLevel(ListEffects.dialImpact.effectId, heldItem);
				if(impactDialLevel > 0)
				{
					AbilityExplosion explosion = WyHelper.newExplosion(player, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, impactDialLevel);
					explosion.setDamageOwner(false);
					explosion.setDestroyBlocks(false);
					explosion.doExplosion();
				}
				
				int flashDialLevel = EnchantmentHelper.getEnchantmentLevel(ListEffects.dialFlash.effectId, heldItem);
				if(flashDialLevel > 0)
				{
					event.entityLiving.addPotionEffect(new PotionEffect(Potion.blindness.id, 200 * flashDialLevel, flashDialLevel));
				}
			}
		}
	}
	
}
