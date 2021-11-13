package xyz.pixelatedw.MineMineNoMi3.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class BellyPouch extends Item
{
	public BellyPouch()
	{

	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);

		if (!world.isRemote)
		{
			int amount = 0;
			
			if(!itemStack.hasTagCompound())
				amount = (int) WyMathHelper.randomWithRange(5, 100);
			else
				amount = itemStack.getTagCompound().getInteger("belly");

			if (props.getBelly() <= Values.MAX_GENERAL - amount)
			{
				props.alterBelly(amount);
				WyHelper.sendMsgToPlayer(player, "You've obtained " + amount + " belly !");
			}
			else
				props.setBelly(Values.MAX_GENERAL);

			if (!player.capabilities.isCreativeMode)
				WyTelemetry.addMiscStat("bellyEarnedFromPouches", "Belly Earned From Pouches", amount);

			--itemStack.stackSize;
		}

		return itemStack;
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(itemStack.hasTagCompound())
		{
			list.add("Belly: " + itemStack.getTagCompound().getInteger("belly"));
		}
	}
}
