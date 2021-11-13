package xyz.pixelatedw.MineMineNoMi3.world;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.lists.ListBiomes;

public class WorldProviderScenarioArena extends WorldProvider 
{

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(ListBiomes.biomeScenarioArena, 1.8f);
		this.dimensionId = ID.DIMENSION_ID_SCENARIOARENA;
	}
	
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderScenarioArena(this.worldObj, this.worldObj.getSeed());
	}
	
    public boolean canRespawnHere()
    {
        return false;
    }
	
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(ID.DIMENSION_ID_SCENARIOARENA);
	}
	
	public String getDimensionName() 
	{
		return ID.DIMENSION_NAME_SCENARIOARENA;
	}
	
    public int getRespawnDimension(EntityPlayerMP player)
    {
        return 0;
    }

}
