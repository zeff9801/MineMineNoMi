package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.BariAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

import java.util.ArrayList;

public class BariProjectiles 
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {BarrierCrash.class, ListAttributes.BARRIER_CRASH});
		abilitiesClassesArray.add(new Object[] {BarrierbilityStairs.class, ListAttributes.BARRIERBILITY_STAIRS});
	}
	
	public static class BarrierbilityStairs extends AbilityProjectile
	{
		public BarrierbilityStairs(World world)
		{super(world);}
		
		public BarrierbilityStairs(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BarrierbilityStairs(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void onUpdate()
		{	
			if(!this.worldObj.isRemote)
			{
				if(this.getThrower() == null)
					return;
				
				AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer) this.getThrower());			
				Ability ability = abilityProps.getAbilityFromName(ListAttributes.BARRIERBILITY_STAIRS.getAttributeName());            

				if(ability != null)
				{
					if(!ability.isPassiveActive())
					{
						this.setDead();
						return;
					}
					
					((BariAbilities.BarrierbilityStairs)ability).fillBlocksList(WyHelper.createFilledCube(this.worldObj, this.posX, this.posY - 2, this.posZ, new int[] {1, 1, 1}, ListMisc.Barrier, "air", "nogrief"));
				}

			}
			
			super.onUpdate();
		}
	}	
	
	public static class BarrierCrash extends AbilityProjectile
	{
		public BarrierCrash(World world)
		{super(world);}
		
		public BarrierCrash(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BarrierCrash(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
}
