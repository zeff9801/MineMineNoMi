package xyz.pixelatedw.MineMineNoMi3.items;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class ItemVivreCard extends Item
{

	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(itemStack.getTagCompound() != null)
		{
			EntityLivingBase entity = WyHelper.getEntityByUUID(player.worldObj, UUID.fromString(itemStack.getTagCompound().getString("owner")));
			
			if(entity != null)
			{
				list.add(EnumChatFormatting.GOLD + "[Owner] " + EnumChatFormatting.RESET + entity.getCommandSenderName());
				list.add(EnumChatFormatting.GOLD + "[Location] " + EnumChatFormatting.RESET + (int)entity.posX + "X " + (int)entity.posY + "Y " + (int)entity.posZ +"Z");
				list.add(EnumChatFormatting.GOLD + "[HP] " + EnumChatFormatting.RESET + entity.getHealth());
			}
		}
	}
	
    @Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) 
    {
    	this.setOwner(itemStack, player);
    	String itemName = itemStack.getDisplayName();
    	itemStack.setStackDisplayName(player.getDisplayName() + "'s " + itemName);
    }

	public void setOwner(ItemStack itemStack, EntityLivingBase e)
	{
		itemStack.setTagCompound(new NBTTagCompound());
		itemStack.getTagCompound().setString("owner", e.getUniqueID().toString());
	}
}
