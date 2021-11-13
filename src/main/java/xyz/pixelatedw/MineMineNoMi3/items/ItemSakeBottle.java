package xyz.pixelatedw.MineMineNoMi3.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectSakeDrunk;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class ItemSakeBottle extends ItemFood
{

	public ItemSakeBottle()
	{
		super(1, true);
		this.maxStackSize = 16;
	}

	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(itemStack.getTagCompound() == null)
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("Amount", 5);
		}
		
		player.setItemInUse(itemStack, itemUseDuration);
		return itemStack;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) 
	{
		if(!world.isRemote)
		{						
			ExtendedEntityData props = ExtendedEntityData.get(player);

			int amount = itemStack.getTagCompound().getInteger("Amount");
			
			itemStack.getTagCompound().setInteger("Amount", amount - 1);
			
			new DFEffectSakeDrunk(player, 500);
			
			if(amount - 1 <= 0)
				itemStack.stackSize--;
			
			if (!player.capabilities.isCreativeMode)
				WyTelemetry.addMiscStat("sakeBottlesDrank", "Sake Bottles Drank", 1);			
		}
		
		return itemStack;
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int posX, int posY, int posZ, int blockFace, float f1, float f2, float f3)
	{
		if (player.isSneaking())
		{
			world.setBlock(posX, posY + 1, posZ, ListMisc.SakeBottleBlock, blockFace, 2);
		}
		
		return false;
	}

}
