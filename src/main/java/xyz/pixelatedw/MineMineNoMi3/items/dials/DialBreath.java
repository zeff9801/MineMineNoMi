package xyz.pixelatedw.MineMineNoMi3.items.dials;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DialBreath extends Item
{
	
	public DialBreath()
	{
		this.setMaxStackSize(16);
		this.setMaxDamage(1);
	}

    @Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i1, int i2, int i3, int i4, float f1, float f2, float f3)
    {
    	if(!world.isRemote && player.isSneaking())
    	{
	    	world.setBlock(i1, i2 + 1, i3, ListMisc.DialBreathBlock);
	    	itemStack.stackSize--;
    	}
        return false;
    }
}
