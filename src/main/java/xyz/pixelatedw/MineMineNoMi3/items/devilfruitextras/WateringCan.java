package xyz.pixelatedw.MineMineNoMi3.items.devilfruitextras;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class WateringCan extends Item
{

    @Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {		
		if (!world.isRemote)
		{
			int currentTears = itemStack.getTagCompound().getInteger("tears");

			player.heal(4);
			itemStack.getTagCompound().setInteger("tears", currentTears - 1);
		}
		
		return itemStack;
    }

    @Override
	public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 32;
    }
    
    @Override
	public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.drink;
    }
    
    @Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
		if(!itemStack.hasTagCompound())
			itemStack.setTagCompound(new NBTTagCompound());
			
		int currentTears = itemStack.getTagCompound().getInteger("tears");

		if(currentTears > 0)
		{
			player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		}
        return itemStack;
    }
    
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(!itemStack.hasTagCompound())
			itemStack.setTagCompound(new NBTTagCompound());
		
		int currentTears = itemStack.getTagCompound().getInteger("tears");
		list.add("Tears : " + currentTears);
	}
	
	public void addTears(ItemStack itemStack, EntityLivingBase e)
	{
		if(!itemStack.hasTagCompound())
			itemStack.setTagCompound(new NBTTagCompound());
		
		int currentTears = itemStack.getTagCompound().getInteger("tears");
		
		itemStack.getTagCompound().setInteger("tears", currentTears + 1);
	}
	
}
