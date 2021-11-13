package xyz.pixelatedw.MineMineNoMi3.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class CommandPouch extends CommandBase
{
	@Override
	public void processCommand(ICommandSender sender, String[] str) 
	{
		EntityPlayer player = CommandBase.getCommandSenderAsPlayer(sender);
		
		// Checking if the basic formula is used
		if(str.length < 1)
			throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);
		
		int amount = Integer.parseInt(str[0]);
		ExtendedEntityData props = ExtendedEntityData.get(player);

		if(amount <= 0)
			return;
		
		if(props.getBelly() - amount >= 0)
			props.alterBelly(-amount);
		else
		{
			amount = props.getBelly();		
			props.alterBelly(-amount);
		}
		
		if (!player.capabilities.isCreativeMode)
			WyTelemetry.addMiscStat("bellyEarnedFromPouches", "Belly Earned From Pouches", -amount);
		
		ItemStack pouch = new ItemStack(ListMisc.BellyPouch);
		
		pouch.setTagCompound(new NBTTagCompound());	
		pouch.getTagCompound().setInteger("belly", amount);
		
		player.inventory.addItemStackToInventory(pouch);
		
		WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP)player);
		WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/pouch [amount]";
	}

	@Override
	public String getCommandName() 
	{
		return "pouch";
	}
}
