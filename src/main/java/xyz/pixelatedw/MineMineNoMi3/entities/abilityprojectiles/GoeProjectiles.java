package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GasuProjectiles.GasRobe;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GasuProjectiles.Gastille;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class GoeProjectiles 
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Todoroki.class, ListAttributes.TODOROKI});
	}
	
	public static class Todoroki extends AbilityProjectile
	{
		public Todoroki(World world)
		{super(world);}
		
		public Todoroki(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Todoroki(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}	
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			AbilityExplosion explosion = WyHelper.newExplosion(this.getThrower(), this.posX, this.posY, this.posZ, 3);
			explosion.setDamageOwner(false);
			explosion.setSmokeParticles("");
			explosion.doExplosion();
		}	
	}
}
