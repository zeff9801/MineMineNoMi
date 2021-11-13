package xyz.pixelatedw.MineMineNoMi3.items.dials;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DialReject extends Item
{
	
	public DialReject()
	{
		this.setMaxStackSize(16);
		this.setMaxDamage(1);
	}
	
    @Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase user, EntityLivingBase target)
    {
		if(!user.worldObj.isRemote)
		{
	    	if(!user.isSneaking())
	    	{
				itemStack.damageItem(2, user);
	    		
				user.attackEntityFrom(DamageSource.generic, Float.MAX_VALUE);
				target.attackEntityFrom(DamageSource.generic, Float.MAX_VALUE);
				
		    	if(user instanceof EntityPlayer && !((EntityPlayer)user).capabilities.isCreativeMode)
		    		WyTelemetry.addMiscStat("rejectDialsUsed", "Reject Dials Used", 1);
				
				return true;
	    	}	    
		}
    	
        return false;
    }

    @Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i1, int i2, int i3, int i4, float f1, float f2, float f3)
    {
    	if(!world.isRemote && player.isSneaking())
    	{
	    	world.setBlock(i1, i2 + 1, i3, ListMisc.DialRejectBlock);
	    	itemStack.stackSize--;
    	}
        return false;
    }
}
