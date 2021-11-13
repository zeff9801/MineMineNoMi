package xyz.pixelatedw.MineMineNoMi3.world.scenario;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;

public abstract class Scenario
{

	protected String scenarioName;
	public int scenarioXPos, scenarioYPos, scenarioZPos;
	protected int spawnXPos, spawnYPos, spawnZPos;
	protected int scenarioXSize, scenarioYSize, scenarioZSize;

	public abstract void load(EntityPlayer player, World world);
	
	public abstract void unload(EntityPlayer player, World world);
	
	public String getScenarioId()
	{
		return scenarioName + "" + scenarioXPos + "" + scenarioYPos + "" + scenarioZPos;
	}
	
	public int getOriginX()
	{
		return this.scenarioXPos;
	}
	
	public int getOriginY()
	{
		return this.scenarioYPos;
	}
	
	public int getOriginZ()
	{
		return this.scenarioZPos;
	}
}
