package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class PacketViewProtection implements IMessage
{
	public boolean viewProtection;
	public int[] midPoint;
	public int radius;
	
	public PacketViewProtection() {}

	public PacketViewProtection(boolean flag, int[] midPoint, int radius)
	{
		this.viewProtection = flag;
		this.midPoint = midPoint;
		this.radius = radius;
	}

	@Override
	public void fromBytes(ByteBuf buffer)
	{
		this.viewProtection = buffer.readBoolean();
		this.midPoint = new int[] {buffer.readInt(), buffer.readInt(), buffer.readInt()};
		this.radius = buffer.readInt();
	}

	@Override
	public void toBytes(ByteBuf buffer)
	{
		buffer.writeBoolean(this.viewProtection);
		buffer.writeInt(this.midPoint[0]);
		buffer.writeInt(this.midPoint[1]);
		buffer.writeInt(this.midPoint[2]);
		buffer.writeInt(this.radius);
	}

	public static class ClientHandler implements IMessageHandler<PacketViewProtection, IMessage>
	{
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketViewProtection message, MessageContext ctx)
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);

			WyHelper.createEmptyCube(player.worldObj, message.midPoint[0], message.midPoint[1], message.midPoint[2], new int[] {message.radius, message.radius, message.radius}, ListMisc.AbilityProtectionAreaBlock, "air", "liquids");
			WyHelper.createEmptySphere(player.worldObj, message.midPoint[0], message.midPoint[1], message.midPoint[2], 1, ListMisc.AbilityProtectionCenterBlock, "air", "liquids");

			return null;
		}
	}
}