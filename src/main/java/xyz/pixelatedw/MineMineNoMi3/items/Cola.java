package xyz.pixelatedw.MineMineNoMi3.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class Cola extends ItemFood
{

	public Cola()
	{
		super(0, false);
		this.maxStackSize = 16;
	} 
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		player.setItemInUse(itemStack, this.itemUseDuration);
		return itemStack;
	}

    @Override
	public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.drink;
    }

	@Override
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) 
	{
		if(!world.isRemote)
		{						
			ExtendedEntityData props = ExtendedEntityData.get(player);
			
			if(props.isCyborg())
			{
				if(props.getCola() <= props.getMaxCola() - 15) 
					props.alterCola(15);
				else 
					props.setCola(props.getMaxCola());
			}
			
	    	if(!player.capabilities.isCreativeMode)
	    		WyTelemetry.addMiscStat("bottlesOfColaDrank", "Bottles of Cola Drank", 1);
			
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}			
	}
}
