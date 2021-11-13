package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import xyz.pixelatedw.MineMineNoMi3.lists.ListEffects;

public class EventsEnchantments
{
	@SubscribeEvent
	public void onLivingAttackEvent(LivingAttackEvent event)
	{
		if (((event.source.getEntity() instanceof EntityPlayer)) && ((event.entityLiving instanceof EntityLiving)))
		{
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			EntityLiving living = (EntityLiving)event.entityLiving;
			ItemStack hand = player.inventory.getCurrentItem();
			
			if(hand != null && hand.isItemEnchanted())
			{
				if(!living.worldObj.isRemote)
				{
					if (EnchantmentHelper.getEnchantmentLevel(ListEffects.dialImpact.effectId, player.getHeldItem()) == 1)
					{
						int r = living.worldObj.rand.nextInt(10);
						if(r < 2)
						{	    			  
							player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 10)); 
							living.worldObj.createExplosion(living, living.posX, living.posY, living.posZ, 1.4F, true);
						}
					} 
				}
			}
		}
	}
}