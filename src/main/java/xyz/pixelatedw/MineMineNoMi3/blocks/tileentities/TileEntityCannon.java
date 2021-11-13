package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCannon extends TileEntity
{
	private int gunpowderLoaded = 0;
	private boolean hasCannonBall = false;

	public int getGunpowederLoaded()
	{
		return gunpowderLoaded;
	}

	public void addGunpoweder()
	{
		this.gunpowderLoaded++;
	}

	public void emptyGunpoweder()
	{
		this.gunpowderLoaded = 0;
	}
	
	public boolean hasCannonBall()
	{
		return hasCannonBall;
	}

	public void setHasCannonBall(boolean hasCannonBall)
	{
		this.hasCannonBall = hasCannonBall;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("LoadedGunpowder", this.gunpowderLoaded);
		nbt.setBoolean("HasCannonBall", this.hasCannonBall);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.gunpowderLoaded = nbt.getInteger("LoadedGunpowder");
		this.hasCannonBall = nbt.getBoolean("HasCannonBall");
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.func_148857_g());
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}
}
