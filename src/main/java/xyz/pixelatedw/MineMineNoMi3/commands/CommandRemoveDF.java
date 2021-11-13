package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class CommandRemoveDF extends CommandBase
{		
	@Override
	public void processCommand(ICommandSender sender, String[] str) 
	{
		EntityPlayer player = null;
		
		if(str.length == 1)
			player = CommandBase.getPlayer(sender, str[0]);
		else
			player = CommandBase.getCommandSenderAsPlayer(sender);
		
		boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(player.getGameProfile());
		
		ExtendedEntityData props = ExtendedEntityData.get(player);
		AbilityProperties abilityProps = AbilityProperties.get(player);
		ExtendedWorldData worldProps = ExtendedWorldData.get(player.worldObj);

		worldProps.removeDevilFruitFromWorld(props.getUsedFruit());
		
		props.setUsedFruit("N/A");
		props.setYamiPower(false);
		props.setIsLogia(false);
		props.triggerActiveHaki(false);
		props.triggerBusoHaki(false);
		props.triggerKenHaki(false);
		
		abilityProps.clearHotbar();
		abilityProps.clearDevilFruitAbilities();
		player.clearActivePotions();

		props.setZoanPoint("n/a");
		
		player.clearActivePotions();
		
		WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP)player);	
		WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));	
		WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP)player);	
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		if(!(sender instanceof EntityPlayer))
			return true;
		
		EntityPlayer senderEntity = CommandBase.getCommandSenderAsPlayer(sender);
		boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(senderEntity.getGameProfile());
		
		if( (MainConfig.commandPermissionRemoveDF == 2 && flag) || MainConfig.commandPermissionRemoveDF < 2 )
			return true;
		else	
			return false;		
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/removedf [player]";
	}

	@Override
	public String getCommandName() 
	{
		return "removedf";
	}
}

