package xyz.pixelatedw.MineMineNoMi3.items.devilfruitextras;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class Heart extends Item
{
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(itemStack.getTagCompound() != null && world.getEntityByID(itemStack.getTagCompound().getInteger("owner")) != null)
		{
			EntityLivingBase owner = (EntityLivingBase) world.getEntityByID(itemStack.getTagCompound().getInteger("owner"));
			if(owner == player)
			{
				ExtendedEntityData props = new ExtendedEntityData(player);
				props.setHasHeart(true);
				/** TODO This throws an error server-side, just make sure it doesn't break anything or find a fix ;) */
				WyNetworkHelper.sendToServer(new PacketSync(props));
				WyHelper.removeStackFromInventory(player, itemStack);
			}
			else
			{
				owner.attackEntityFrom(DamageSource.magic, 5);
				owner.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 250, 1));
				owner.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 1));
				if(owner.getHealth() <= 0)
					WyHelper.removeStackFromInventory(player, itemStack);
			}
		}

		return itemStack;
	}
	
    @Override
	public boolean onEntityItemUpdate(EntityItem entityItem)
    {
    	ItemStack itemStack = entityItem.getEntityItem();
    	World world = entityItem.worldObj;
    	
		if(itemStack.getTagCompound() != null)
		{
			EntityLivingBase target = ((EntityLivingBase) world.getEntityByID(itemStack.getTagCompound().getInteger("owner")));

			boolean flagIsDead = entityItem.isBurning();
			
			if(target != null && flagIsDead)
				target.attackEntityFrom(DamageSource.magic, Float.MAX_VALUE);
		}
    	
        return false;
    }
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(itemStack.getTagCompound() != null)
		{
			if(player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")) != null)
			{
				list.add(EnumChatFormatting.GOLD + "[Owner] " + EnumChatFormatting.RESET + player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).getCommandSenderName());
				list.add(EnumChatFormatting.GOLD + "[HP] " + EnumChatFormatting.RESET + ((EntityLivingBase) player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner"))).getHealth());
				list.add(EnumChatFormatting.GOLD + "[Location] " + EnumChatFormatting.RESET + (int)player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).posX + "X " + (int)player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).posY + "Y " + (int)player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).posZ +"Z");
			}
			else
				list.add(EnumChatFormatting.GOLD + itemStack.getDisplayName().replace("'s Heart", "") + " is dead !");
		}
		else
			list.add(EnumChatFormatting.RED + "SOMEBODY TOUCHA MA HART!");
	}
	
	public void setHeartOwner(ItemStack itemStack, EntityLivingBase e)
	{
		itemStack.setTagCompound(new NBTTagCompound());
		itemStack.getTagCompound().setInteger("owner", e.getEntityId());
	}
	
}
