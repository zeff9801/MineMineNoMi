package xyz.pixelatedw.MineMineNoMi3.items.dials;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DialFire extends Item
{
	
	public DialFire()
	{
		this.setMaxStackSize(16);
		this.setMaxDamage(4);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{		
		if(!world.isRemote)
		{
	    	if(!player.isSneaking())
	    	{
				Vec3 look = player.getLookVec();
				EntitySmallFireball fireball = new EntitySmallFireball(world, player, 1, 1, 1);
				fireball.setPosition(
						player.posX,
						player.posY + 1.5, 
						player.posZ);
				fireball.accelerationX = look.xCoord * 0.2;
				fireball.accelerationY = look.yCoord * 0.2;
				fireball.accelerationZ = look.zCoord * 0.2;
				world.spawnEntityInWorld(fireball);	
				
		    	if(!player.capabilities.isCreativeMode)
		    		WyTelemetry.addMiscStat("fireDialsUsed", "Fire Dials Used", 1);
				
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
	    	world.setBlock(i1, i2 + 1, i3, ListMisc.DialFireBlock);
	    	itemStack.stackSize--;
    	}
        return false;
    }
	
}
