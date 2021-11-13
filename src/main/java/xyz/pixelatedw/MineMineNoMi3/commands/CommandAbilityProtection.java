package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityAbilityProtection;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketViewProtection;

public class CommandAbilityProtection extends CommandBase
{
	@Override
	public void processCommand(ICommandSender sender, String[] str)
	{
		if (str.length > 0)
		{
			EntityPlayer player = CommandBase.getCommandSenderAsPlayer(sender);
			ExtendedWorldData worldData = ExtendedWorldData.get(player.worldObj);

			if (str[0].equalsIgnoreCase("new"))
			{
				int areaSize;
				if(str.length <= 1 || WyHelper.isNullOrEmpty(str[1]))
					areaSize = 100;
				else
					areaSize = Integer.parseInt(str[1]);

				System.out.println("1 : " + areaSize);

				TileEntityAbilityProtection center = new TileEntityAbilityProtection(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, areaSize);
				player.worldObj.setBlock((int) player.posX, (int) player.posY, (int) player.posZ, ListMisc.AbilityProtectionBlock);
				player.worldObj.setTileEntity((int) player.posX, (int) player.posY, (int) player.posZ, center);
			}
			else if (str[0].equalsIgnoreCase("view"))
			{
				boolean state;
				if(str.length <= 1 || WyHelper.isNullOrEmpty(str[1]))
					state = true;
				else
					state = Boolean.parseBoolean(str[1]);
				
				System.out.println("1 : " + state);
				
				for(int[][] area : worldData.getAllRestrictions())
				{
					int[] minPos = area[0];
					int[] maxPos = area[1];
					
					if(minPos.length <= 0 || maxPos.length <= 0)
						continue;
					
					int midX = (minPos[0] + maxPos[0]) / 2;
					int midY = (minPos[1] + maxPos[1]) / 2;
					int midZ = (minPos[2] + maxPos[2]) / 2;
					int[] midPoint = new int[] { midX, midY, midZ };
					
					TileEntity te = player.worldObj.getTileEntity(midPoint[0], midPoint[1], midPoint[2]);

					if(te == null || !(te instanceof TileEntityAbilityProtection))
						continue;
					
					TileEntityAbilityProtection protection = (TileEntityAbilityProtection) te;

					WyNetworkHelper.sendTo(new PacketViewProtection(true, midPoint, protection.getRadius()), (EntityPlayerMP) player);
				}
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		EntityPlayer senderEntity = CommandBase.getCommandSenderAsPlayer(sender);
		boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(senderEntity.getGameProfile());

		if (flag)
			return true;

		return false;
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/abilityprotection <command>";
	}

	@Override
	public String getCommandName()
	{
		return "abilityprotection";
	}
}
