package xyz.pixelatedw.MineMineNoMi3.items.weapons;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class Flintlock extends Item
{

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (player.isSneaking())
		{
			if (itemStack.getTagCompound().getInteger("bulletType") == 0)
			{
				itemStack.getTagCompound().setInteger("bulletType", 1);
				itemStack.setStackDisplayName(EnumChatFormatting.RESET + "Flintlock <Kairoseki>");
			}
			else if (itemStack.getTagCompound().getInteger("bulletType") == 1)
			{
				itemStack.getTagCompound().setInteger("bulletType", 0);
				itemStack.setStackDisplayName(EnumChatFormatting.RESET + "Flintlock <Normal>");
			}
		}
		else
		{
			if (itemStack.getTagCompound().getBoolean("canUse"))
			{
				if(itemStack.getTagCompound().getInteger("gunPowder") > 0)
				{
					if ((player.inventory.hasItem(ListMisc.Bullets) && itemStack.getTagCompound().getInteger("bulletType") == 0) 
							|| (player.inventory.hasItem(ListMisc.KairosekiBullets) && itemStack.getTagCompound().getInteger("bulletType") == 1))
					{
						AbilityProjectile proj = null;
						int powder = itemStack.getTagCompound().getInteger("gunPowder");
						if (!world.isRemote)
						{
							if (itemStack.getTagCompound().getInteger("bulletType") == 0) proj = new ExtraProjectiles.NormalBullet(player.worldObj, player, ListExtraAttributes.NORMAL_BULLET);
							else if (itemStack.getTagCompound().getInteger("bulletType") == 1) proj = new ExtraProjectiles.KairosekiBullet(player.worldObj, player, ListExtraAttributes.KAIROSEKI_BULLET);
							player.worldObj.spawnEntityInWorld(proj);
							
							String id = (itemStack.getTagCompound().getInteger("bulletType") == 0 ? "normal" : "kairoseki");
					    	WyTelemetry.addMiscStat(id + "BulletsShot", WyHelper.upperCaseFirst(id) + " Bullets Shot", 1);
						}
	
						itemStack.getTagCompound().setBoolean("canUse", false);
						itemStack.getTagCompound().setInteger("gunPowder", --powder);
						player.inventory.consumeInventoryItem(itemStack.getTagCompound().getInteger("bulletType") == 0 ? ListMisc.Bullets : ListMisc.KairosekiBullets);
					}
				}
				else
				{
					if(player.inventory.hasItem(Items.gunpowder))
					{
						itemStack.getTagCompound().setInteger("gunPowder", 10);
						player.inventory.consumeInventoryItem(Items.gunpowder);
					}
				}
			}			
		}
		return itemStack;
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)
	{
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("bulletType", 0);
			itemStack.getTagCompound().setBoolean("canUse", true);
			itemStack.getTagCompound().setInteger("gunPowder", 0);
			itemStack.getTagCompound().setInteger("cooldown", 15);
			
			itemStack.getTagCompound().setInteger("bulletType", 0);
			itemStack.setStackDisplayName(EnumChatFormatting.RESET + "Flintlock <Normal>");
		}

		if (!itemStack.getTagCompound().getBoolean("canUse"))
		{
			int cd = itemStack.getTagCompound().getInteger("cooldown");
			if (cd > 0)
			{
				cd--;
				itemStack.getTagCompound().setInteger("cooldown", cd);
			}
			else
			{
				itemStack.getTagCompound().setInteger("cooldown", 15);
				itemStack.getTagCompound().setBoolean("canUse", true);
			}
		}
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if (itemStack.hasTagCompound())
		{
	  		list.add("Gun Powder : " + itemStack.getTagCompound().getInteger("gunPowder"));
		}
	}

}
