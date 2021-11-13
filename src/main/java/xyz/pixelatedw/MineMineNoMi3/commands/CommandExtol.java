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

public class CommandExtol extends CommandBase
{		
	@Override
	public void processCommand(ICommandSender sender, String[] str) 
	{
		// Checking if the basic formula is used
		if(str.length < 2)
			throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);

		// Initializing the variables
		EntityPlayer target = null;
		int value = 0;
		
		// Check if the sender is a player
		if(sender instanceof EntityPlayer)
		{
			// If it's a player check for permissions and command format, if one of them is false, return the actual sender as a target
			if(str.length == 3 && MainConfig.commandPermissionExtol != 1)
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
			props.setExtolFromCommand(value);
			props.setExtol(value);
			
			if(WyDebug.isDebug())
				WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] " + target.getCommandSenderName() + " now has " + value + " extol"); 
		}			
	}

	private void subtract(EntityPlayer target, int value)
	{
		ExtendedEntityData props = ExtendedEntityData.get(target);

		if(props.getExtol() - value <= 0)
		{			
			props.setExtol(0);
			if(props.getExtolFromCommand() - value > 0)
				props.alterExtolFromCommand( -(props.getExtolFromCommand() - value) );
			else
				props.setExtolFromCommand(0);
		}
		else
		{
			props.alterExtol(-value);	
			if(props.getExtolFromCommand() - value > 0)
				props.alterExtolFromCommand( -(props.getExtolFromCommand() - value) );
			else
				props.setExtolFromCommand(0);
		}
		
		if(WyDebug.isDebug())
			WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Subtracted " + value + " extol from " + target.getCommandSenderName()); 		
	}

	private void add(EntityPlayer target, int value)
	{
		ExtendedEntityData props = ExtendedEntityData.get(target);

		if(value + props.getExtol() <= Values.MAX_GENERAL)
		{
			props.alterExtol(value);
			if(props.getExtolFromCommand() + value <= Values.MAX_GENERAL)
				props.alterExtolFromCommand(value);
		}
		else
		{
			props.setExtol(Values.MAX_GENERAL);
			props.alterExtolFromCommand( Values.MAX_GENERAL - value );
		}
		
		if(WyDebug.isDebug())
			WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Added " + value + " extol to " + target.getCommandSenderName()); 		
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		if(!(sender instanceof EntityPlayer))
			return true;
		
		EntityPlayer senderEntity = CommandBase.getCommandSenderAsPlayer(sender);
		boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(senderEntity.getGameProfile());
		
		if( (MainConfig.commandPermissionExtol == 2 && flag) || MainConfig.commandPermissionExtol < 2 )
			return true;
		else	
			return false;	
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/extol <+|-|=> <amount> [player]";
	}

	@Override
	public String getCommandName() 
	{
		return "extol";
	}

}
