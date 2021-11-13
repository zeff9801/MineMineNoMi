package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWantedPoster extends TileEntity
{

	private String entityName = "";
	private String bounty = "";
	private String date = "";
	private String background = "";

	public String getEntityName()
	{
		return this.entityName;
	}

	public void setEntityName(String name)
	{
		this.entityName = name;
	}

	public String getBackground()
	{
		return this.background;
	}

	public void setBackground(String background)
	{
		this.background = background;
	}
	
	public void setPosterBounty(String bounty)
	{
		this.bounty = bounty;
	}

	public String getPosterBounty()
	{
		return this.bounty;
	}

	public void setIssuedDate(String date)
	{
		this.date = date;
	}

	public String getIssuedDate()
	{
		return this.date;
	}

	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		if(this.entityName == null || this.bounty  == null || this.date == null || this.background == null) return;
		nbt.setString("Name", this.entityName);
		nbt.setString("Bounty", this.bounty);
		nbt.setString("Date", this.date);
		nbt.setString("Background", this.background);
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.entityName = nbt.getString("Name");
		this.bounty = nbt.getString("Bounty");
		this.date = nbt.getString("Date");
		this.background = nbt.getString("Background");
	}

	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
}
