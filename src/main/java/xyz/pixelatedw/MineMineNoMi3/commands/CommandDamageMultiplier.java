package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class CommandDamageMultiplier extends CommandBase
{		
	@Override
	public void processCommand(ICommandSender sender, String[] str) 
	{
		// Checking if the basic formula is used
		if(str.length < 1)
			throw new WrongUsageException(this.getCommandUsage(sender), new Object[0]);

		// Initializing the variables
		EntityPlayer target = null;
		float multiplier = 0;
		
		// Check if the sender is a player
		if(sender instanceof EntityPlayer)
		{
			// If it's a player check for permissions and command format, if one of them is false, return the actual sender as a target
			if(str.length == 3)
				target = CommandBase.getPlayer(sender, str[1]);
			else
				target = CommandBase.getCommandSenderAsPlayer(sender);		
		}
		else
		{
			// If it's not a player then the [player] parameter is mandatory, @p works as well, otherwise return an error in the logs (for good measure)
			if(str.length == 3)
				target = CommandBase.getPlayer(sender, str[1]);
			else
			{
				WyDebug.error("A player must be provided when the command is not used by a player !");
				return;
			}
		}
		
		multiplier = Float.parseFloat(str[0]);

		ExtendedEntityData props = ExtendedEntityData.get(target);
		
		props.setDamageMultiplier(multiplier);
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		if(!(sender instanceof EntityPlayer))
			return true;
		
		EntityPlayer senderEntity = CommandBase.getCommandSenderAsPlayer(sender);
		boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(senderEntity.getGameProfile());

		if (flag)
			return true;
		
		return false;
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/damagem <amount> [player]";
	}

	@Override
	public String getCommandName() 
	{
		return "damagem";
	}

}
