package xyz.pixelatedw.MineMineNoMi3.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class ItemRumbleBall extends Item
{

	public ItemRumbleBall()
	{
		
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if(WyHelper.isNullOrEmpty(props.getUsedFruit()))
				return itemStack;
			
			
			
			if(!player.capabilities.isCreativeMode)
				--itemStack.stackSize;
		}
		
		return itemStack;
	}

    @Override
	public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }
	
    @Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }
    
    @Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }
}
