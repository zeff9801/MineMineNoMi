package xyz.pixelatedw.MineMineNoMi3.items.dials;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles.MilkyDialProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DialMilky extends Item
{
	
	public DialMilky()
	{
		this.setMaxStackSize(16);
		this.setMaxDamage(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{		
		if(!world.isRemote)
		{
	    	if(!player.isSneaking())
	    	{
	    		MilkyDialProjectile proj = new MilkyDialProjectile(player.worldObj, player, ListExtraAttributes.DIAL_MILKY);
				
	    		world.spawnEntityInWorld(proj);
				
		    	if(!player.capabilities.isCreativeMode)
		    		WyTelemetry.addMiscStat("milkyDialsUsed", "Milky Dials Used", 1);
		    	
				itemStack.damageItem(2, player);
	    	}	    
		}
		
		return itemStack;
	}

    @Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i1, int i2, int i3, int i4, float f1, float f2, float f3)
    {
    	if(!world.isRemote && player.isSneaking())
    	{
	    	world.setBlock(i1, i2 + 1, i3, ListMisc.DialMilkyBlock);
	    	itemStack.stackSize--;
    	}
        return false;
    }
}
