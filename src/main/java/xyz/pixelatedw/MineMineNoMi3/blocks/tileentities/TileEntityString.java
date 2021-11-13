package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.ItoAbilities.Torikago;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketWorld;

public class TileEntityString extends TileEntity
{

	public TileEntityString()
	{

	}

	public void updateEntity()
	{
    	if(!this.worldObj.isRemote)
    	{
			List<EntityLivingBase> nearbyPlayers = WyHelper.getEntitiesNear(this, 28).stream().filter(x ->
				{
					if (x instanceof EntityPlayer && ExtendedEntityData.get(x).getUsedFruit().equalsIgnoreCase("itoito"))
						return true;
			
					return false;
				})
				.collect(Collectors.toList());
	
			if (nearbyPlayers.isEmpty())
				clearRoom();
    	}
	}

	public void clearRoom()
	{
		World world = this.worldObj;

		for(int i = -22; i < 22; i++)
		for(int k = -21; k < 21; k++)
		for(int j = -22; j < 22; j++)
			if(world.getBlock((int) this.xCoord + i, (int) this.yCoord + k, (int) this.zCoord + j) == ListMisc.StringWall)
				world.setBlock((int) this.xCoord + i, (int) this.yCoord + k, (int) this.zCoord + j, Blocks.air);
		world.setBlock((int) this.xCoord, (int) this.yCoord, (int) this.zCoord, Blocks.air);
	}

}
