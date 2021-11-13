package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPoneglyph extends TileEntity
{

	private String entryType = "";
	private String entryName = "";

	public String getEntryType()
	{
		return entryType;
	}
	
	public void setEntryType(String entryType)
	{
		this.entryType = entryType;
	}
	
	public String getEntryName()
	{
		return entryName;
	}
	
	public void setEntryName(String entryName)
	{
		this.entryName = entryName;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		if(this.entryType == null || this.entryName  == null) 
			return;
		nbt.setString("EntryType", this.entryType);
		nbt.setString("EntryName", this.entryName);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.entryType = nbt.getString("EntryType");
		this.entryName = nbt.getString("EntryName");		
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
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
}
