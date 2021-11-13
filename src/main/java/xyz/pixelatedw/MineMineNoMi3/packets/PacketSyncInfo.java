package xyz.pixelatedw.MineMineNoMi3.packets;

import java.util.UUID;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldServer;
import scala.actors.threadpool.Arrays;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;

public class PacketSyncInfo implements IMessage
{
	public NBTTagCompound data;
	public String user = "";
	public int entityId;

	public PacketSyncInfo() {}
	
	public PacketSyncInfo(int id, ExtendedEntityData props) 
	{
		data = new NBTTagCompound();
		this.entityId = id;
		props.saveNBTData(data);
	}
	
	public PacketSyncInfo(String user, ExtendedEntityData props) 
	{
		data = new NBTTagCompound();
		this.user = user;
		props.saveNBTData(data);
	}
	
	public PacketSyncInfo(ExtendedEntityData props) 
	{
		data = new NBTTagCompound();
		props.saveNBTData(data);
	}

	public void fromBytes(ByteBuf buffer) 
	{
		data = ByteBufUtils.readTag(buffer);
		this.user = ByteBufUtils.readUTF8String(buffer);
		this.entityId = buffer.readInt();
	}
	
	public void toBytes(ByteBuf buffer) 
	{
		ByteBufUtils.writeTag(buffer, data);
		ByteBufUtils.writeUTF8String(buffer, this.user);
		buffer.writeInt(this.entityId);
	}
	
	public static class ClientHandler implements IMessageHandler<PacketSyncInfo, IMessage>
	{
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketSyncInfo message, MessageContext ctx) 
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ExtendedEntityData props = ExtendedEntityData.get(player);	 
			int entityID = message.entityId;
			
			if(message.user != null && !message.user.isEmpty())
			{
				EntityPlayer target = null;
	
				//System.out.println(Arrays.toString(Minecraft.getMinecraft().theWorld.playerEntities.toArray()));
				
				for(Object o : Minecraft.getMinecraft().theWorld.playerEntities)
				{
					EntityPlayer t = (EntityPlayer)o;
					if(t.getDisplayName().equalsIgnoreCase(message.user))
					{
						target = t;
						break;
					}
				}
				
				if(target != null && !target.equals(player))
				{
					ExtendedEntityData propz = ExtendedEntityData.get(target);	 
					
					propz.loadNBTData(message.data);
				}
			}
			else if(entityID != 0)
			{
				Entity target = null;
				
				for (Object e : player.worldObj.loadedEntityList)
				{
					if(e instanceof EntityLivingBase)
					{
						if ( ((EntityLivingBase)e).getEntityId() == entityID)
						{
							target = (Entity) e;
							break;
						}
					}
				}
				
				if(target != null && target instanceof EntityLivingBase && !target.equals(player))
				{
					ExtendedEntityData propz = ExtendedEntityData.get((EntityLivingBase) target);
					propz.loadNBTData(message.data);
				}
			}
			/*else
			{
				props.loadNBTData(message.data);
			}*/

			return null;
		}
	}
}