package xyz.pixelatedw.MineMineNoMi3.world;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class ChunkProviderScenarioArena implements IChunkProvider
{
	
    private final Random random;
    private final World worldObj;
    private int chunkX = 0;
    private int chunkZ = 0;
    private BiomeGenBase[] biomesForGeneration;

    private boolean generatedDojoAmbushInstances;
    
	public ChunkProviderScenarioArena(World world, long seed)
	{
		this.random = new Random(seed);
        this.worldObj = world;
	}
	
	@Override
	public boolean chunkExists(int x, int z) 
	{
		return true;
	}

	@Override
	public Chunk provideChunk(int x, int z) 
	{
        this.chunkX = x; this.chunkZ = z;
        this.random.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		Block[] ablock = new Block[65536];
		byte[] abyte = new byte[65536];
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);

        Chunk chunk = new Chunk(this.worldObj, ablock, abyte, x, z);
        byte[] abyte1 = chunk.getBiomeArray();

        for (int i = 0; i < abyte1.length; ++i)
        {
            abyte1[i] = (byte)this.biomesForGeneration[i].biomeID;
        }
                
        chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public Chunk loadChunk(int x, int z) 
	{
		return this.provideChunk(x, z);
	}

	@Override
	public void populate(IChunkProvider chunkProvider, int x, int z) 
	{
        BlockFalling.fallInstantly = true;        

        long initTime = System.currentTimeMillis();
        
        //Dojo Section
        Schematic sch = WySchematicHelper.load("dojo");
        
        int wallSizeX = sch.getWidth() * 3;
        int wallSizeY = sch.getHeight() * 3;
        int wallSizeZ = sch.getLength() * 3;
        
        int posX = ID.COORDS_SWORDSMANPROGRESSION05_DOJOAMBUSH[0];
        int posY = ID.COORDS_SWORDSMANPROGRESSION05_DOJOAMBUSH[1];
        int posZ = ID.COORDS_SWORDSMANPROGRESSION05_DOJOAMBUSH[2];

        /*WyHelper.createCube(worldObj, 
        		new int[] {posX, posY, posZ}, 
        		new int[] {wallSizeX, wallSizeY, wallSizeZ}, ListMisc.Darkness);*/
        if(!generatedDojoAmbushInstances)
        {
	        WySchematicHelper.build(sch, this.worldObj, posX, posY, posZ);     
	        WyDebug.info("Dojo Ambush Instance Created - " + (System.currentTimeMillis() - initTime) + "ms - X:" + posX + " Y:" + posY + " Z:" + posZ);
	        generatedDojoAmbushInstances = true;
        }
        
        BlockFalling.fallInstantly = false;		
	}

	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_)
	{
		return false;
	}

	@Override
	public boolean unloadQueuedChunks() 
	{
		return false;
	}

	@Override
	public boolean canSave() 
	{
		return false;
	}

	@Override
	public String makeString() 
	{
		return null;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) 
	{
		return null;
	}

	@Override
	public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) 
	{
		return null;
	}

	@Override
	public int getLoadedChunkCount() 
	{
		return 0;
	}

	@Override
	public void recreateStructures(int p_82695_1_, int p_82695_2_) 
	{
		
	}

	@Override
	public void saveExtraData() 
	{
		
	}

}
