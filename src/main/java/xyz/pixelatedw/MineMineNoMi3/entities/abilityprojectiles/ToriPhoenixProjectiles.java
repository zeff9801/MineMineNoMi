package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

import java.util.ArrayList;

public class ToriPhoenixProjectiles
{
	
	
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {PhoenixGoen.class, ListAttributes.PHOENIX_GOEN});
	}
	
	
	public static class PhoenixGoen extends AbilityProjectile
	{
		public PhoenixGoen(World world)
		{super(world);}
		
		public PhoenixGoen(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public PhoenixGoen(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void onUpdate()
		{		
			if(this.worldObj.isRemote)
			{
				EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_BLUEFLAME, 
						posX, 
						posY, 
						posZ, 
						0, 0, 0)
						.setParticleAge(1).setParticleScale(1.2F);
				
				MainMod.proxy.spawnCustomParticles(this, particle);
			}
			super.onUpdate();
		}
	}
}
