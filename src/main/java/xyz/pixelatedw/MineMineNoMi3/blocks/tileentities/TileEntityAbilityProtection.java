package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;

public class TileEntityAbilityProtection extends TileEntity
{

	private int protectedRadius = 100;

	public TileEntityAbilityProtection setRadius(int radius) { protectedRadius = radius; return this; }
	public int getRadius() { return protectedRadius; }
	
	public TileEntityAbilityProtection() {}
	
	public TileEntityAbilityProtection(World world, int posX, int posY, int posZ, int radius)
	{
		ExtendedWorldData worldData = ExtendedWorldData.get(world);
		this.setRadius(radius);
		System.out.println("2 : " + radius);

    	int minPosX = posX - radius;
    	int minPosY = posY - radius;
    	int minPosZ = posZ - radius;
    	int maxPosX = posX + radius;
    	int maxPosY = posY + radius;
    	int maxPosZ = posZ + radius;
    	
    	worldData.addRestrictedArea(new int[] {minPosX, minPosY, minPosZ}, new int[] {maxPosX, maxPosY, maxPosZ});
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTag)
	{
		super.readFromNBT(nbtTag);
		this.protectedRadius = nbtTag.getInteger("Radius");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTag)
	{
		super.writeToNBT(nbtTag);
		nbtTag.setInteger("Radius", this.protectedRadius);
	}

}
