package xyz.pixelatedw.MineMineNoMi3.api.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.MainMod;

public class WyNetworkHelper
{

	public static final void registerMessage(Class handlerClass, Class messageClass, int id, Side side) 
	{
		MainMod.dispatcher.registerMessage(handlerClass, messageClass, id, side);
	}
	
	public static final void sendTo(IMessage message, EntityPlayerMP player)
	{
		MainMod.dispatcher.sendTo(message, player);
	}
	
	public static final void sendToAll(IMessage message)
	{
		MainMod.dispatcher.sendToAll(message);
	}
		
	public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range)
	{
		MainMod.dispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}
	
	public static final void sendToDimension(IMessage message, int dimensionId)
	{
		MainMod.dispatcher.sendToDimension(message, dimensionId);
	}

	public static final void sendToServer(IMessage message)
	{
		MainMod.dispatcher.sendToServer(message);
	}

}
