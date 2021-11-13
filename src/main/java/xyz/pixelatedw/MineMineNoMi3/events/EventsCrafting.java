package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.AnvilUpdateEvent;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListEffects;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EventsCrafting
{

	@SubscribeEvent
	public void onAnvilUpdate(AnvilUpdateEvent event)
	{
		if(ItemsHelper.isBow(event.left))
		{
			if(event.right.getItem() == ListMisc.Kairoseki && event.right.stackSize >= 10)
			{
				event.cost = 1;
				event.materialCost = 10;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(ListEffects.kairoseki, 1);
			}
			else if(event.right.getItem() == ListMisc.DialFire  && event.right.stackSize >= 3)
			{
				event.cost = 1;
				event.materialCost = 3;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(Enchantment.flame, 1);
			}
			else if(event.right.getItem() == ListMisc.DialEisen  && event.right.stackSize >= 3)
			{
				int level = event.right.stackSize / 3;
				
				if(level > 3)
					level = 3;
				
				event.cost = 1;
				event.materialCost = 3 * level;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(Enchantment.power, level);
			}
			else if(event.right.getItem() == ListMisc.DialBreath  && event.right.stackSize >= 3)
			{
				int level = event.right.stackSize / 3;
				
				if(level > 3)
					level = 3;
				
				event.cost = 1;
				event.materialCost = 3 * level;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(Enchantment.punch, level);
			}
		}
		else if(ItemsHelper.isSword(event.left))
		{
			if(event.right.getItem() == ListMisc.Kairoseki && event.right.stackSize >= 10)
			{
				event.cost = 1;
				event.materialCost = 10;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(ListEffects.kairoseki, 1);
			}
			else if(event.right.getItem() == ListMisc.BlackMetal  && event.right.stackSize >= 5)
			{
				int level = event.right.stackSize / 5;
				
				if(level > 3)
					level = 3;

				event.cost = 1;
				event.materialCost = 5 * level;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
			
				if(event.left.getTagCompound() == null)
					event.left.setTagCompound(new NBTTagCompound());
				
				event.output.setTagCompound((NBTTagCompound) event.left.getTagCompound().copy());
				if(event.output.getTagCompound().getDouble("multiplier_black_metal") >= 0.3 * level)
					return;
				event.output.getTagCompound().setDouble("multiplier_black_metal", 0.3 * level);
				event.output.getItem().setMaxDamage(event.output.getItem().getMaxDamage() + (3000 * level));
			}
			else if(event.right.getItem() == ListMisc.DialFire  && event.right.stackSize >= 3)
			{
				event.cost = 1;
				event.materialCost = 3;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(Enchantment.fireAspect, 1);
			}
			else if(event.right.getItem() == ListMisc.DialEisen  && event.right.stackSize >= 3)
			{
				int level = event.right.stackSize / 3;
				
				if(level > 3)
					level = 3;
				
				event.cost = 1;
				event.materialCost = 3 * level;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				
				if(event.left.getTagCompound() == null)
					event.left.setTagCompound(new NBTTagCompound());
				
				event.output.setTagCompound((NBTTagCompound) event.left.getTagCompound().copy());
				if(event.output.getTagCompound().getDouble("multiplier_eisen") >= 0.05 * level)
					return;
				event.output.getTagCompound().setDouble("multiplier_eisen", 0.05 * level);
			}
			else if(event.right.getItem() == ListMisc.DialFlash  && event.right.stackSize >= 3)
			{
				event.cost = 1;
				event.materialCost = 3;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(ListEffects.dialFlash, 1);
			}
			else if(event.right.getItem() == ListMisc.DialImpact  && event.right.stackSize >= 3)
			{
				int level = event.right.stackSize / 3;
				
				if(level > 3)
					level = 3;
				
				event.cost = 1;
				event.materialCost = 3 * level;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(ListEffects.dialImpact, level);
			}
			else if(event.right.getItem() == ListMisc.DialBreath  && event.right.stackSize >= 3)
			{
				int level = event.right.stackSize / 3;
				
				if(level > 3)
					level = 3;
				
				event.cost = 1;
				event.materialCost = 3 * level;
				event.output = new ItemStack(event.left.getItem());
				EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(event.left), event.output);
				event.output.addEnchantment(Enchantment.knockback, level);
			}
		}
	}
	
}
