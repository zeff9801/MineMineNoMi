package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.gui.GUIWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.items.CharacterCreator;

public class PacketPlayer implements IMessage
{
	private String cmd;
	private boolean ablState = false;
	private NBTTagCompound nbt;
	private double mX, mY, mZ;
	
	public PacketPlayer() {}
	
	public PacketPlayer(String cmd) 
	{
		this.cmd = cmd;
	}
	
	public PacketPlayer(String cmd, boolean bool) 
	{
		this.cmd = cmd;
		this.ablState = bool;
	}
	
	public PacketPlayer(String cmd, ItemStack stack) 
	{
		this.cmd = cmd;
		this.nbt = stack.getTagCompound();
	}
	
	public PacketPlayer(String cmd, double mX, double mY, double mZ) 
	{
		this.cmd = cmd;		
		this.mX = mX;
		this.mY = mY;
		this.mZ = mZ;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.cmd = ByteBufUtils.readUTF8String(buf);
		this.ablState = buf.readBoolean();
		this.mX = buf.readDouble();
		this.mY = buf.readDouble();
		this.mZ = buf.readDouble();
		this.nbt = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, this.cmd);
		buf.writeBoolean(this.ablState);
		buf.writeDouble(this.mX);
		buf.writeDouble(this.mY);
		buf.writeDouble(this.mZ);
		ByteBufUtils.writeTag(buf, nbt);
	}

	public static class ClientHandler implements IMessageHandler<PacketPlayer, IMessage>
	{
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketPlayer message, MessageContext ctx) 
		{
			final EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);

		    boolean canAnimate = true;
			double frame = 0;
			
			if(message.cmd.equals("guiWantedPoster"))
				Minecraft.getMinecraft().displayGuiScreen(new GUIWantedPoster(message.nbt));
			
			if(message.cmd.equals("ChangeRotation"))
			{
				float initialRotation = player.rotationYaw;
				
				player.rotationYaw = initialRotation + 10;
			}
			
			if(message.cmd.equals("ElThorThunder"))
			{
				int i = (int) message.mX;
				int j = (int) message.mY;
				int k = (int) message.mZ;
				
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i+1, j, k));
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k+1));
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i-1, j, k));
				player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k-1));
			}
			
			if(message.cmd.contains("motion+"))
			{
				player.motionX += message.mX;
				player.motionY += message.mY;
				player.motionZ += message.mZ;			
			}
			if(message.cmd.contains("motion-"))
			{
				player.motionX -= message.mX;
				player.motionY -= message.mY;
				player.motionZ -= message.mZ;			
			}
			if(message.cmd.contains("motion="))
			{
				player.motionX = message.mX;
				player.motionY = message.mY;
				player.motionZ = message.mZ;						
			}
			if(message.cmd.contains("motion*"))
			{
				player.motionX *= message.mX;
				player.motionY *= message.mY;
				player.motionZ *= message.mZ;						
			}	
			if(message.cmd.contains("pos"))
			{
				player.setPositionAndRotation(message.mX, message.mY, message.mZ, player.rotationYaw, player.rotationPitch);
			}
			
			return null;		
		}
	}
	
	public static class ServerHandler implements IMessageHandler<PacketPlayer, IMessage>
	{
		@Override
		public IMessage onMessage(PacketPlayer message, MessageContext ctx) 
		{
			EntityPlayer player = ctx.getServerHandler().playerEntity;
			ExtendedEntityData props = ExtendedEntityData.get(player);
			AbilityProperties abilityProps = AbilityProperties.get(player);

			if(message.cmd.equals("delete_book"))
			{
				abilityProps.clearHotbar();
				abilityProps.clearRacialAbilities();
				
				DevilFruitsHelper.validateRacialMoves(player);
				DevilFruitsHelper.validateStyleMoves(player);
				
				if(props.isCyborg())
				{
					props.setMaxCola(100);
					props.setCola(props.getMaxCola());
				}
				
				for(ItemStack is : player.inventory.mainInventory)
					if(is != null && is.getItem() instanceof CharacterCreator)
						WyHelper.removeStackFromInventory(player, is);
				
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP) player);
			}
			if(message.cmd.equals("forcesync"))
			{
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				WyNetworkHelper.sendTo(new PacketAbilitySync(abilityProps), (EntityPlayerMP) player);
			}
			if(message.cmd.contains("msg"))
				WyHelper.sendMsgToPlayer(player, message.cmd.replace("msg", ""));
			if(message.cmd.equals("enterCombatMode"))
			{
				props.setCombatMode(!props.isInCombatMode());
				//WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			}

			return null;
		}
	}
	
}
