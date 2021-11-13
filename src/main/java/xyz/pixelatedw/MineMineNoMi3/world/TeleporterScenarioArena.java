package xyz.pixelatedw.MineMineNoMi3.world;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMorgan;
import xyz.pixelatedw.MineMineNoMi3.world.scenario.Scenario;
import xyz.pixelatedw.MineMineNoMi3.world.scenario.ScenarioManager;

public class TeleporterScenarioArena extends Teleporter
{

	private final WorldServer worldServerInstance;
	private Random random;
	
	public TeleporterScenarioArena(WorldServer ws) 
	{
		super(ws);
		worldServerInstance = ws;
		random = new Random(ws.getSeed());
	}
	
	public void teleport(Entity entity, String scenarioName)
	{
		EntityPlayerMP playerMP = (EntityPlayerMP) entity;

		playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ID.DIMENSION_ID_SCENARIOARENA, this);
		
		playerMP.setPositionAndUpdate(-20000, 64, -20000);
	}
	
	public void endScenario(Entity entity, String scenarioName)
	{
		EntityPlayerMP playerMP = (EntityPlayerMP) entity;
		
		//ScenarioManager.scenarios.get(scenarioName).unload(playerMP, playerMP.worldObj);
		
        playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, this);	
	}

	public void placeInPortal(Entity entity, double x, double y, double z, double f)
	{
        if (worldServerInstance.provider.getDimensionName().equals(ID.DIMENSION_NAME_SCENARIOARENA)) 
        {
            entity.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, 0.0F);

            entity.motionX = 0.0D;
            entity.motionY = 0.0D;
            entity.motionZ = 0.0D;
            
            if(entity instanceof EntityPlayer) 
            {
            	EntityPlayer player = (EntityPlayer) entity;
            	if (player.worldObj.isRemote) 
            	{
                    if (player.dimension == ID.DIMENSION_ID_SCENARIOARENA) 
                    {
                    	WyHelper.sendMsgToPlayer(player, "TEST MESSAGE");
                    }
                }
            }

        }		
	}
	
    @Override
    public boolean placeInExistingPortal(Entity entityIn, double x, double y, double z, float f) 
    {
        return false;
    }

    @Override
    public boolean makePortal(Entity entityIn) 
    {
        return false;
    }


}
