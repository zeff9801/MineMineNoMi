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
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class PacketShounenScream implements IMessage
{
	private String senderName, attackName;
	private int splitHalf = 0;
	
	public PacketShounenScream() {}
	
	public PacketShounenScream(String senderName, String attackName) 
	{
		this.senderName = senderName;
		this.attackName = attackName;
	}
	
	public PacketShounenScream(String senderName, String attackName, int splitHalf) 
	{
		this.senderName = senderName;
		this.attackName = attackName;
		this.splitHalf = splitHalf;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.senderName = ByteBufUtils.readUTF8String(buf);
		this.attackName = ByteBufUtils.readUTF8String(buf);
		this.splitHalf = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, this.senderName);
		ByteBufUtils.writeUTF8String(buf, this.attackName);
		buf.writeInt(splitHalf);
	}
	
	public static class ClientHandler implements IMessageHandler<PacketShounenScream, IMessage>
	{
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketShounenScream message, MessageContext ctx) 
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			String localizedName = message.attackName.toUpperCase();//I18n.format("ability." + message.attackName + ".name").toUpperCase();
			String animeScream = localizedName;
			
			if(message.splitHalf > 0)
			{
				String[] abilityWords = localizedName.replaceAll(" [:]", "").split(" ");
				int noOfWords = (int) Math.ceil(abilityWords.length / (abilityWords.length > 2 ? 1.5 : 2));
				
				if(message.splitHalf == 1)
				{		
					if(noOfWords > 1)
					{
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < noOfWords; i++)
							sb.append(abilityWords[i] + " ");
						animeScream = sb.toString().substring(0, sb.toString().length() - 1) + "...";
						
						WyHelper.sendMsgToPlayer(player, "<" + message.senderName + "> " + animeScream);
					}
					else
						WyHelper.sendMsgToPlayer(player, "<" + message.senderName + "> " + animeScream);
				}
				else if(message.splitHalf == 2)
				{
					if(noOfWords > 1)
					{
						StringBuilder sb = new StringBuilder();
						for(int i = noOfWords; i < abilityWords.length; i++)
							sb.append(abilityWords[i] + " ");
						animeScream = "..." + sb.toString();
						
						WyHelper.sendMsgToPlayer(player, "<" + message.senderName + "> " + animeScream);
					}
				}
			}
			else
				WyHelper.sendMsgToPlayer(player, "<" + message.senderName + "> " + animeScream);
			

			return null;
		}
	}
}