package xyz.pixelatedw.MineMineNoMi3.api.network;

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
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;

public class PacketAbilitySync implements IMessage
{
	public NBTTagCompound data;

	public PacketAbilitySync() {}
	
	public PacketAbilitySync(AbilityProperties props) 
	{
		data = new NBTTagCompound();
		props.saveNBTData(data);
	}

	public void fromBytes(ByteBuf buffer) 
	{
		data = ByteBufUtils.readTag(buffer);
	}
	
	public void toBytes(ByteBuf buffer) 
	{
		ByteBufUtils.writeTag(buffer, data);
	}
	
	public static class ClientHandler implements IMessageHandler<PacketAbilitySync, IMessage>
	{
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketAbilitySync message, MessageContext ctx) 
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			AbilityProperties props = AbilityProperties.get(player);	 

			props.loadNBTData(message.data);

			return null;
		}
	}
	
	public static class ServerHandler implements IMessageHandler<PacketAbilitySync, IMessage>
	{
		public IMessage onMessage(PacketAbilitySync message, MessageContext ctx) 
		{
			EntityPlayer player = MainMod.proxy.getPlayerEntity(ctx);
			AbilityProperties props = AbilityProperties.get(player);	 

			props.loadNBTData(message.data);
			
			return null;
		}
	}
}