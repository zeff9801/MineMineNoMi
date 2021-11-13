package xyz.pixelatedw.MineMineNoMi3.data;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import xyz.pixelatedw.MineMineNoMi3.ID;

public class HistoryProperties implements IExtendedEntityProperties
{
	private static final String NAME = ID.PROJECT_ID + "_HistoryIEEP";
	private EntityPlayer player;

	private List<String> unlockedChallenges = new ArrayList<String>();
	private List<String> completedChallenges = new ArrayList<String>();

	public HistoryProperties(EntityPlayer player) 
	{
		this.player = player;	
	}
	
	public static final void register(EntityPlayer player) 
	{
		player.registerExtendedProperties(NAME, new HistoryProperties(player));
	}

	public static final HistoryProperties get(EntityPlayer player) 
	{
		return (HistoryProperties) player.getExtendedProperties(NAME);
	}

	public EntityPlayer getEntity()
	{
		return this.player;
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound unlockedChallengesTag = new NBTTagCompound();
		if (!this.unlockedChallenges.isEmpty())
		{
			this.unlockedChallenges.forEach(x ->
					unlockedChallengesTag.setBoolean(x, true));
		}
		compound.setTag("unlockedChallenges", unlockedChallengesTag);
		
		NBTTagCompound completedChallengesTag = new NBTTagCompound();
		if (!this.completedChallenges.isEmpty())
		{
			this.completedChallenges.forEach(x ->
					completedChallengesTag.setBoolean(x, true));
		}
		compound.setTag("completedChallenges", completedChallengesTag);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{	
		NBTTagCompound unlockedChallenges = compound.getCompoundTag("unlockedChallenges");
		this.unlockedChallenges.clear();
		unlockedChallenges.func_150296_c().stream().forEach(x ->
		{
			this.unlockedChallenges.add((String) x);
		});
		
		NBTTagCompound completedChallenges = compound.getCompoundTag("completedChallenges");
		this.completedChallenges.clear();
		completedChallenges.func_150296_c().forEach(x ->
				this.completedChallenges.add((String) x));
	}

	@Override
	public void init(Entity entity, World world) {}

	// Completed Challenges
	public boolean addCompletedChallenge(String entry)
	{
		if(!this.hasCompletedChallenge(entry))
		{
			this.completedChallenges.add(entry);
			return true;
		}
		
		return false;
	}
	
	public boolean removeCompletedChallenge(String entry)
	{
		if(this.hasCompletedChallenge(entry))
		{
			this.completedChallenges.remove(entry);
			return true;
		}
		
		return false;
	}
	
	public boolean hasCompletedChallenge(String entry)
	{
		return this.completedChallenges.contains(entry);
	}
	
	// Unlocked Challenges
	public boolean addUnlockedChallenge(String entry)
	{
		if(!this.hasUnlockedChallenge(entry))
		{
			this.unlockedChallenges.add(entry);
			return true;
		}
		
		return false;
	}
	
	public boolean removeUnlockedChallenge(String entry)
	{
		if(this.hasUnlockedChallenge(entry))
		{
			this.unlockedChallenges.remove(entry);
			return true;
		}
		
		return false;
	}
	
	public boolean hasUnlockedChallenge(String entry)
	{
		return this.unlockedChallenges.contains(entry);
	}
}
