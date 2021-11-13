package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class NikyuProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {PadHo.class, ListAttributes.PAD_HO});
		abilitiesClassesArray.add(new Object[] {UrsusShock.class, ListAttributes.URSUS_SHOCK});
	}
	
	public static class PadHo extends AbilityProjectile
	{
		public PadHo(World world)
		{super(world);}
		
		public PadHo(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public PadHo(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				double newPosX = 0, newPosY = 0, newPosZ = 0;
				
				newPosY += 10;
				Direction dir = WyHelper.get4Directions(this.getThrower());
				if(dir == WyHelper.Direction.SOUTH)
					newPosX += WyMathHelper.randomWithRange(-200, 200);
				else if(dir == WyHelper.Direction.EAST)
					newPosX -= WyMathHelper.randomWithRange(-200, 200);
				else if(dir == WyHelper.Direction.NORTH)
					newPosZ += WyMathHelper.randomWithRange(-200, 200);
				else if(dir == WyHelper.Direction.WEST)  
					newPosZ -= WyMathHelper.randomWithRange(-200, 200);

				((EntityLivingBase)hit.entityHit).setPositionAndUpdate(hit.entityHit.posX + newPosX, hit.entityHit.posY + newPosY, hit.entityHit.posZ + newPosZ);
			}
		}
	}	
	
	public static class UrsusShock extends AbilityProjectile
	{
		public UrsusShock(World world)
		{super(world);}
		
		public UrsusShock(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public UrsusShock(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	
}
