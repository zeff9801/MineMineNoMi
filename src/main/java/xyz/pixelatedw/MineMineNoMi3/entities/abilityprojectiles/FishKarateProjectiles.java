package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class FishKarateProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Uchimizu.class, ListAttributes.UCHIMIZU});
		abilitiesClassesArray.add(new Object[] {Soshark.class, ListAttributes.MURASAME});
	}
	
	public static class Uchimizu extends AbilityProjectile
	{
		public Uchimizu(World world)
		{super(world);}
		
		public Uchimizu(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Uchimizu(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			AbilityExplosion explosion = WyHelper.newExplosion(this.getThrower(), this.posX, this.posY, this.posZ, 1.2);
			explosion.setExplosionSound(false);
			explosion.setSmokeParticles(ID.PARTICLEFX_WATEREXPLOSION);
			explosion.setDestroyBlocks(false);
			explosion.setDamageOwner(false);
			explosion.doExplosion();
		}
	}

	public static class Soshark extends AbilityProjectile
	{
		public Soshark(World world)
		{super(world);}
		
		public Soshark(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Soshark(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			AbilityExplosion explosion = WyHelper.newExplosion(this.getThrower(), this.posX, this.posY, this.posZ, 2.2);
			explosion.setExplosionSound(false);
			explosion.setSmokeParticles(ID.PARTICLEFX_WATEREXPLOSION);
			explosion.setDamageOwner(false);
			explosion.doExplosion();
		}
	}
}
