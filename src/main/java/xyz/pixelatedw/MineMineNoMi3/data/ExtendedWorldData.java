package xyz.pixelatedw.MineMineNoMi3.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;

public class ExtendedWorldData extends WorldSavedData
{

	private static final String IDENTIFIER = "mineminenomi";

	private boolean isSwordsmanDojoSpawned = false;
	private int totalDojosSpawned;
	private HashMap<String, Long> issuedBounties = new HashMap<String, Long>();
	private List<String> devilFruitsInWorld = new ArrayList<String>();
	private List<int[][]> protectedAreas = new ArrayList<int[][]>();

	public ExtendedWorldData()
	{
		super(IDENTIFIER);
	}

	public ExtendedWorldData(String identifier)
	{
		super(identifier);
	}

	public static ExtendedWorldData get(World world)
	{
		ExtendedWorldData data = (ExtendedWorldData) world.loadItemData(ExtendedWorldData.class, IDENTIFIER);
		if (data == null)
		{
			data = new ExtendedWorldData();
			world.setItemData(IDENTIFIER, data);
		}
		return data;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		this.isSwordsmanDojoSpawned = nbt.getBoolean("isSwordsmanDojoSpawned");
		this.totalDojosSpawned = nbt.getInteger("totalDojosSpawned");

		NBTTagCompound bounties = nbt.getCompoundTag("issuedBounties");
		this.issuedBounties.clear();
		bounties.func_150296_c().forEach(x ->
		{
			this.issuedBounties.put((String) x, bounties.getLong((String) x));
		});

		NBTTagCompound devilFruits = nbt.getCompoundTag("devilFruits");
		this.devilFruitsInWorld.clear();
		devilFruits.func_150296_c().forEach(x ->
				this.devilFruitsInWorld.add((String) x));

		NBTTagCompound protectedAreas = nbt.getCompoundTag("protectedAreas");
		this.protectedAreas.clear();
		for (int i = 0; i <= protectedAreas.func_150296_c().size(); i++)
		{
			int[] minPos = protectedAreas.getIntArray("minPos_" + i);
			int[] maxPos = protectedAreas.getIntArray("maxPos_" + i);
			this.protectedAreas.add(new int[][] {minPos, maxPos});
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		nbt.setBoolean("isSwordsmanDojoSpawned", this.isSwordsmanDojoSpawned);
		nbt.setInteger("totalDojosSpawned", this.totalDojosSpawned);

		NBTTagCompound bounties = new NBTTagCompound();
		if (issuedBounties.size() > 0)
		{
			issuedBounties.forEach(bounties::setLong);
		}
		nbt.setTag("issuedBounties", bounties);

		NBTTagCompound devilFruits = new NBTTagCompound();
		if (!devilFruitsInWorld.isEmpty())
		{
			devilFruitsInWorld.forEach(x ->
					devilFruits.setBoolean(x, true));
		}
		nbt.setTag("devilFruits", devilFruits);

		NBTTagCompound protectedAreas = new NBTTagCompound();
		if (!this.protectedAreas.isEmpty())
		{
			int i = 0;
			for (int[][] area : this.protectedAreas)
			{
				protectedAreas.setIntArray("minPos_" + i, area[0]);
				protectedAreas.setIntArray("maxPos_" + i, area[1]);
				i++;
			}
		}
		nbt.setTag("protectedAreas", protectedAreas);
	}

	public boolean isInsideRestrictedArea(int posX, int posY, int posZ)
	{
		if(this.protectedAreas.isEmpty())
			return false;
		
		for (int[][] area : this.protectedAreas)
		{
			int[] minPos = area[0];
			int[] maxPos = area[1];

			if(minPos.length <= 0 || maxPos.length <= 0)
				continue;
			
			if (posX > minPos[0] && posX < maxPos[0] && posY > minPos[1] && posY < maxPos[1] && posZ > minPos[2] && posZ < maxPos[2])
			{
				return true;
			}
		}

		return false;
	}

	public void addRestrictedArea(int[] minPos, int[] maxPos)
	{
		this.protectedAreas.add(new int[][]
		{
				minPos, maxPos
		});

		this.markDirty();
	}

	public void removeRestrictedArea(int midX, int midY, int midZ)
	{
		Iterator iterator = this.protectedAreas.iterator();
		while(iterator.hasNext())
		{
			int[][] area = (int[][]) iterator.next();
			int[] minPos = area[0];
			int[] maxPos = area[1];

			if(minPos.length <= 0 || maxPos.length <= 0)
				continue;
			
			int possibleMidX = (minPos[0] + maxPos[0]) / 2;
			int possibleMidY = (minPos[1] + maxPos[1]) / 2;
			int possibleMidZ = (minPos[2] + maxPos[2]) / 2;
			
			if(midX == possibleMidX && midY == possibleMidY && midZ == possibleMidZ)
				iterator.remove();
		}

		this.markDirty();
	}
	
	public List<int[][]> getAllRestrictions()
	{
		return this.protectedAreas;
	}

	public Map<String, Long> getAllBounties()
	{
		return this.issuedBounties;
	}

	public long getBounty(String name)
	{
		if (this.issuedBounties.containsKey(name.toLowerCase()))
			return this.issuedBounties.get(name.toLowerCase());

		return 0;
	}

	public void issueBounty(String name, long bounty)
	{
		if (this.issuedBounties.containsKey(name.toLowerCase()))
		{
			this.issuedBounties.remove(name.toLowerCase());
			this.issuedBounties.put(name.toLowerCase(), bounty);
		}
		else
			this.issuedBounties.put(name.toLowerCase(), bounty);

		this.markDirty();
	}

	public int getTotalDojosSpawned()
	{
		return this.totalDojosSpawned;
	}

	public void countUpDojoSpawned()
	{
		this.totalDojosSpawned++;
		if (this.totalDojosSpawned >= MainConfig.maxDojoSpawn)
			this.setSwordsmanDojoSpawned(true);
		this.markDirty();
	}

	public void setDojoSpawned(int value)
	{
		this.totalDojosSpawned = value;
		if (this.totalDojosSpawned >= MainConfig.maxDojoSpawn)
			this.setSwordsmanDojoSpawned(true);
		this.markDirty();
	}

	public boolean isSwordsmanDojoSpawned()
	{
		return this.isSwordsmanDojoSpawned;
	}

	public void setSwordsmanDojoSpawned(boolean value)
	{
		this.isSwordsmanDojoSpawned = value;
		this.markDirty();
	}
	
	public List<String> getDevilFruitsInWorld()
	{
		return this.devilFruitsInWorld;
	}

	public void removeDevilFruitFromWorld(AkumaNoMi fruit)
	{
		String name = fruit.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", "");

		if (this.devilFruitsInWorld.contains(name))
		{
			this.devilFruitsInWorld.remove(name);
			this.markDirty();
		}
	}
	
	public void removeDevilFruitFromWorld(String name)
	{
		if (this.devilFruitsInWorld.contains(name))
		{
			this.devilFruitsInWorld.remove(name);
			this.markDirty();
		}
	}
	
	public void addDevilFruitInWorld(AkumaNoMi fruit)
	{
		String name = fruit.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", "");

		if (!this.devilFruitsInWorld.contains(name))
		{
			this.devilFruitsInWorld.add(name);
			this.markDirty();
		}
	}

	public void addDevilFruitInWorld(String name)
	{
		if (!this.devilFruitsInWorld.contains(name))
		{
			this.devilFruitsInWorld.add(name);
			this.markDirty();
		}
	}

	public boolean isDevilFruitInWorld(String name)
	{
		return this.devilFruitsInWorld.contains(name);
	}
}
