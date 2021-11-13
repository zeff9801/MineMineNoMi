package xyz.pixelatedw.MineMineNoMi3.world.scenario;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMorgan;

public class BasicScenario extends Scenario
{

	public void load(EntityPlayer player, World world)
	{
		WyDebug.info("Load " + player.dimension);
        double dx = this.scenarioXPos;
        double dy = this.scenarioYPos;
        double dz = this.scenarioZPos;
        
        this.scenarioXSize = 20;
        this.scenarioYSize = 1;
        this.scenarioZSize = 20;

		player.motionX = player.motionY = player.motionZ = 0.0D;
		player.setPositionAndUpdate(dx, dy + 2, dz);
        
        for(int x = 0; x < scenarioXSize; x++)
        {
        	for(int z = 0; z < scenarioZSize; z++)
        	{
        		world.setBlock((int)dx + x, (int)dy, (int)dz + z, Blocks.stone);
        	}
        }
		WyDebug.info("Build Done In Dimension " + player.dimension);

        //EntityMorgan target = new EntityMorgan(player.worldObj);
        //target.setPositionAndRotation(dx, dy + 1, dz + 8, 180, 0);
        //world.spawnEntityInWorld(target);
	}

	public void unload(EntityPlayer player, World world)
	{
		WyDebug.info("Unload");
        double dx = this.scenarioXPos;
        double dy = this.scenarioYPos;
        double dz = this.scenarioZPos;

        for(int x = 0; x < scenarioXSize; x++)
        {
        	for(int y = 0; y < scenarioYSize; y++)
        	{
	        	for(int z = 0; z < scenarioZSize; z++)
	        	{
	        		if(world.getBlock((int)dx + x, (int)dy + y, (int)dz + z) != Blocks.air)
	        			world.setBlock((int)dx + x, (int)dy + y, (int)dz + z, Blocks.air);    		
	        	}
        	}
        }
        
		player.motionX = player.motionY = player.motionZ = 0.0D;
		player.setPositionAndUpdate(dx, dy + 2, dz);
        
	}

}
