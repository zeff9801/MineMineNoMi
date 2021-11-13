package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.abilities.GoroAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;

public class PacketUseAbility implements IMessage
{
	public int abilitySlot;

	public PacketUseAbility() {}

	public PacketUseAbility(int abilitySlot)
	{
		this.abilitySlot = abilitySlot;
	}

	public void fromBytes(ByteBuf buffer)
	{
		this.abilitySlot = buffer.readInt();
	}

	public void toBytes(ByteBuf buffer)
	{
		buffer.writeInt(this.abilitySlot);
	}

	public static class ClientHandler implements IMessageHandler<PacketUseAbility, IMessage>
	{
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketUseAbility message, MessageContext ctx)
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);
			
			return null;
		}
	}

	public static class ServerHandler implements IMessageHandler<PacketUseAbility, IMessage>
	{
		public IMessage onMessage(PacketUseAbility message, MessageContext ctx)
		{
			EntityPlayer player = MainMod.proxy.getPlayerEntity(ctx);
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);

			if(DevilFruitsHelper.checkForRestriction(player))
				return null;
			
			for (int i = 0; i < 8; i++)
			{
				if(message.abilitySlot == i)
				{
					if (abilityProps.getAbilityFromSlot(i) != null)
					{
						for (int j = 0; j < 8; j++)
						{
							if (abilityProps.getAbilityFromSlot(j) != null)
							{
								if (abilityProps.getAbilityFromSlot(j).isCharging() && abilityProps.getAbilityFromSlot(j) == abilityProps.getAbilityFromSlot(i) && abilityProps.getAbilityFromSlot(i).getAttribute().canStopChargeEarly() )
									abilityProps.getAbilityFromSlot(i).endCharging(player);
								
								if (abilityProps.getAbilityFromSlot(j).isCharging())
									return null;
								
								if (abilityProps.getAbilityFromSlot(i) != abilityProps.getAbilityFromSlot(j) && abilityProps.getAbilityFromSlot(j).isPassiveActive() && abilityProps.getAbilityFromSlot(i).getAttribute().isPassive())
								{
									if(abilityProps.getAbilityFromSlot(i).getAttribute().isAbilityFreePassive())
										abilityProps.getAbilityFromSlot(i).passive(player);
									else if(!abilityProps.getAbilityFromSlot(i).getAttribute().isAbilityFreePassive() && abilityProps.getAbilityFromSlot(j).getAttribute().isAbilityFreePassive() && abilityProps.getAbilityFromSlot(j).isPassiveActive())
										abilityProps.getAbilityFromSlot(i).passive(player);								
									return null;
								}
							}
						}
	
						if (abilityProps.getAbilityFromSlot(i).getAttribute().isPassive())
							abilityProps.getAbilityFromSlot(i).passive(player);
						else if (abilityProps.getAbilityFromSlot(i).getAttribute().getAbilityCharges() > 0)
							abilityProps.getAbilityFromSlot(i).startCharging(player);
						else
							abilityProps.getAbilityFromSlot(i).use(player);
					}
				}
			}

			return null;//new PacketUseAbility(message.abilitySlot);
		}
	}
}
