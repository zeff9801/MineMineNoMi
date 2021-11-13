package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.MainMod;

public class PacketEntityVelocity implements IMessage
{
	public int entityId;
	public double motionX, motionY, motionZ;

	public PacketEntityVelocity() {}

	public PacketEntityVelocity(int id, double motionX, double motionY, double motionZ)
	{
		this.entityId = id;
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
	}

	public void fromBytes(ByteBuf buffer)
	{
		this.entityId = buffer.readInt();
		this.motionX = buffer.readDouble();
		this.motionY = buffer.readDouble();
		this.motionZ = buffer.readDouble();
	}

	public void toBytes(ByteBuf buffer)
	{
		buffer.writeInt(this.entityId);
		buffer.writeDouble(this.motionX);
		buffer.writeDouble(this.motionY);
		buffer.writeDouble(this.motionZ);
	}

	public static class ClientHandler implements IMessageHandler<PacketEntityVelocity, IMessage>
	{
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketEntityVelocity message, MessageContext ctx)
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			
			if(message.entityId != 0)
			{
				Entity target = null;

				for (Object e : player.worldObj.loadedEntityList)
				{
					if(e instanceof EntityLivingBase)
					{
						if ( ((EntityLivingBase)e).getEntityId() == message.entityId)
						{
							target = (Entity) e;
							
							target.motionX = message.motionX;
							target.motionY = message.motionY;
							target.motionZ = message.motionZ;
							
							break;
						}
					}
				}
			}
			
			return message;
		}
	}
	
	public static class ServerHandler implements IMessageHandler<PacketEntityVelocity, IMessage>
	{
		public IMessage onMessage(PacketEntityVelocity message, MessageContext ctx)
		{
			EntityPlayer player = MainMod.proxy.getPlayerEntity(ctx);
			
			if(message.entityId != 0)
			{
				Entity target = null;

				for (Object e : player.worldObj.loadedEntityList)
				{
					if(e instanceof EntityLivingBase)
					{
						if ( ((EntityLivingBase)e).getEntityId() == message.entityId)
						{
							target = (Entity) e;
							
							target.motionX = message.motionX;
							target.motionY = message.motionY;
							target.motionZ = message.motionZ;
							
							break;
						}
					}
				}
			}
			return null;		
		}
	}
}
