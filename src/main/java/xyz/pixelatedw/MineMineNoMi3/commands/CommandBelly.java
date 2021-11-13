package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class CommandBelly extends CommandBase
{		
	@Override
	public void processCommand(ICommandSender sender, String[] str) 
	{
		// Checking if the basic formula is used
		if(str.length < 2)
			throw new WrongUsageException(this.getCommandUsage(sender));

		// Initializing the variables
		EntityPlayer target = null;
		int value = 0;
		
		// Check if the sender is a player
		if(sender instanceof EntityPlayer)
		{
			// If it's a player check for permissions and command format, if one of them is false, return the actual sender as a target
			if(str.length == 3 && MainConfig.commandPermissionBelly != 1)
				target = CommandBase.getPlayer(sender, str[2]);
			else
				target = CommandBase.getCommandSenderAsPlayer(sender);		
		}
		else
		{
			// If it's not a player then the [player] parameter is mandatory, @p works as well, otherwise return an error in the logs (for good measure)
			if(str.length == 3)
				target = CommandBase.getPlayer(sender, str[2]);
			else
			{
				WyDebug.error("A player must be provided when the command is not used by a player !");
				return;
			}
		}

		ExtendedEntityData props = ExtendedEntityData.get(target);
		
		if(str[1].equalsIgnoreCase("inf") || str[1].equalsIgnoreCase("max"))
			value = Values.MAX_GENERAL;
		else
			value = Integer.decode(str[1]);
					
		switch(str[0])
		{
			case "+":
				add(target, value); break;
			case "-":
				subtract(target, value); break;
			case "=":
				equal(target, value); break;
		}
		
		WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP)target);

	}
		
	private void equal(EntityPlayer target, int value)
	{
		ExtendedEntityData props = ExtendedEntityData.get(target);

		if(value <= Values.MAX_GENERAL)
		{
			props.setBellyFromCommand(value);
			props.setBelly(value);
			
			if(WyDebug.isDebug())
				WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] " + target.getCommandSenderName() + " now has " + value + " belly"); 
		}	
	}

	private void subtract(EntityPlayer target, int value)
	{
		ExtendedEntityData props = ExtendedEntityData.get(target);

		if(props.getBelly() - value <= 0)
		{			
			props.setBelly(0);
			if(props.getBellyFromCommand() - value > 0)
				props.alterBellyFromCommand( -(props.getBellyFromCommand() - value) );
			else
				props.setBellyFromCommand(0);
		}
		else
		{
			props.alterBelly(-value);	
			if(props.getBellyFromCommand() - value > 0)
				props.alterBellyFromCommand( -(props.getBellyFromCommand() - value) );
			else
				props.setBellyFromCommand(0);
		}
		
		if(WyDebug.isDebug())
			WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Subtracted " + value + " belly from " + target.getCommandSenderName()); 		
	}

	private void add(EntityPlayer target, int value)
	{
		ExtendedEntityData props = ExtendedEntityData.get(target);
		
		if(value + props.getBelly() <= Values.MAX_GENERAL)
		{
			props.alterBelly(value);
			if(props.getBellyFromCommand() + value <= Values.MAX_GENERAL)
				props.alterBellyFromCommand(value);
		}
		else
		{
			props.setBelly(Values.MAX_GENERAL);
			props.alterBellyFromCommand( Values.MAX_GENERAL - value );
		}
		
		if(WyDebug.isDebug())
			WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Added " + value + " belly to " + target.getCommandSenderName()); 
		
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{		
		if(!(sender instanceof EntityPlayer))
			return true;
		
		EntityPlayer senderEntity = CommandBase.getCommandSenderAsPlayer(sender);
		boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(senderEntity.getGameProfile());
		
		if( (MainConfig.commandPermissionBelly == 2 && flag) || MainConfig.commandPermissionBelly < 2 )
			return true;
		else	
			return false;		
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/belly <+|-|=> <amount> [player]";
	}

	@Override
	public String getCommandName() 
	{
		return "belly";
	}

}
