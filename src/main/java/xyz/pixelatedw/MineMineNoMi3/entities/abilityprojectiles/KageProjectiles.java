package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.BomuAbilities.KickBomb;
import xyz.pixelatedw.MineMineNoMi3.abilities.BomuAbilities.NoseFancyCannon;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GuraProjectiles.Kaishin;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GuraProjectiles.ShimaYurashi;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class KageProjectiles 
{
	
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {TsunotokagePillar.class, ListExtraAttributes.TSUNOTOKAGE_PILLAR});
		abilitiesClassesArray.add(new Object[] {BlackBox.class, ListAttributes.BLACK_BOX});
		abilitiesClassesArray.add(new Object[] {BrickBat.class, ListAttributes.BRICK_BAT});
	}
	
	public static class BrickBat extends AbilityProjectile
	{
		public BrickBat(World world)
		{super(world);}
		
		public BrickBat(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BrickBat(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	

	public static class BlackBox extends AbilityProjectile
	{
		public BlackBox(World world)
		{super(world);}
		
		public BlackBox(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BlackBox(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
			{
				WyHelper.createFilledCube(hit.entityHit, new int[] {2, 2, 2}, ListMisc.KageBlock, "air");
			}
		}
	}	
	
	public static class TsunotokagePillar extends AbilityProjectile
	{
		public TsunotokagePillar(World world)
		{super(world);}
		
		public TsunotokagePillar(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public TsunotokagePillar(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
			this.setSize(10, 4);
		}
		
		public void onEntityUpdate()
		{
			for(EntityLivingBase e : WyHelper.getEntitiesNear(this, 2))
				e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 30);
			super.onEntityUpdate();
		}
	}

}
