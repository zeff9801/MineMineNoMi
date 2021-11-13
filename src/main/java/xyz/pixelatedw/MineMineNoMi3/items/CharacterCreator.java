package xyz.pixelatedw.MineMineNoMi3.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.MainMod;

public class CharacterCreator extends Item
{
	
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    { 
		player.openGui(MainMod.getMineMineNoMi(), 2, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return itemStack;	  
	}
	
}
