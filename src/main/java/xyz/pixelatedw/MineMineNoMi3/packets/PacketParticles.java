package xyz.pixelatedw.MineMineNoMi3.packets;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.ParticleManager;

public class PacketParticles implements IMessage
{
	private String fx;
	private double posX, posY, posZ;
	private boolean isGeneric;
	
	public PacketParticles() {}
	
	public PacketParticles(String fx, EntityLivingBase living) 
	{
		this.fx = fx;		
		this.posX = living.posX;
		this.posY = living.posY;
		this.posZ = living.posZ;
	}
	
	public PacketParticles(String fx, double posX, double posY, double posZ) 
	{
		this.fx = fx;		
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
	}
	
	public PacketParticles setGeneric()
	{
		isGeneric = true;
		return this;
	}
	
	public void fromBytes(ByteBuf buf) 
	{
		this.fx = ByteBufUtils.readUTF8String(buf);
		this.posX = buf.readDouble();
		this.posY = buf.readDouble();
		this.posZ = buf.readDouble();
	}

	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, this.fx);
		buf.writeDouble(this.posX);
		buf.writeDouble(this.posY);
		buf.writeDouble(this.posZ);
	}

	public static class ClientHandler implements IMessageHandler<PacketParticles, IMessage>
	{
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketParticles message, MessageContext ctx) 
		{
			final EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ExtendedEntityData props = ExtendedEntityData.get(player);
				
			String fx = message.fx;
			
			boolean pass = ParticleManager.getInstance().spawnFX(player, message.posX, message.posY, message.posZ, fx);
					
			if(fx.contains("logiaEffect_"))
			{
				String devilFruit = fx.substring("logiaEffect_".length(), fx.length());

				double offsetX = (new Random().nextInt(20) + 1.0D - 10.0D) / 15.0D;
				double offsetY = (new Random().nextInt(20) + 1.0D - 10.0D) / 15.0D;
				double offsetZ = (new Random().nextInt(20) + 1.0D - 10.0D) / 15.0D;

				EntityParticleFX logiaParticle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MERA, message.posX + offsetX, (message.posY + 1) + offsetY, message.posZ + offsetZ, 0D, 0.01D, 0D)
						.setParticleAge(10);
				
				if(devilFruit.equals("meramera"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle);
				else if(devilFruit.equals("hiehie"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle.setParticleTexture(ID.PARTICLE_ICON_HIE));
				else if(devilFruit.equals("pikapika"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle.setParticleTexture(ID.PARTICLE_ICON_PIKA));
				else if(devilFruit.equals("gorogoro"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle.setParticleTexture(ID.PARTICLE_ICON_GORO));
				else if(devilFruit.equals("mokumoku"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle.setParticleTexture(ID.PARTICLE_ICON_MOKU));
				else if(devilFruit.equals("sunasuna"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle.setParticleTexture(ID.PARTICLE_ICON_SUNA2));
				else if(devilFruit.equals("magumagu"))
					player.worldObj.spawnParticle(EnumParticleTypes.LAVA.getParticleName(), message.posX + offsetX, (message.posY + 1) + offsetY, message.posZ + offsetZ, 0D, 0D, 0D);
				else if(devilFruit.equals("gasugasu"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle.setParticleTexture(ID.PARTICLE_ICON_GASU));
				else if(devilFruit.equals("yukiyuki"))
					MainMod.proxy.spawnCustomParticles(player, logiaParticle.setParticleTexture(ID.PARTICLE_ICON_YUKI));
				
				pass = true;
			}	
			
			if(!pass)
				WyDebug.warn(message.fx + " is not an initialized particle effect !");
			
			return null;	
		}
	}

}
