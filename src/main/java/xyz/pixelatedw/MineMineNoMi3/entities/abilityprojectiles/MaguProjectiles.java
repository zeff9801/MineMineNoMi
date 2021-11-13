package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class MaguProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Meigo.class, ListAttributes.MEIGO});
		abilitiesClassesArray.add(new Object[] {DaiFunka.class, ListAttributes.DAI_FUNKA});
	}
	
	public static class Meigo extends AbilityProjectile
	{
		public Meigo(World world)
		{super(world);}
		
		public Meigo(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Meigo(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
				hit.entityHit.setFire(200);
		};
		
		@Override
		public void onUpdate()
		{	
			for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(20); i++)
			{
				double offsetX = (new Random().nextInt(40) + 1.0D - 20.0D) / 40.0D;
				double offsetY = (new Random().nextInt(40) + 1.0D - 20.0D) / 40.0D;
				double offsetZ = (new Random().nextInt(40) + 1.0D - 20.0D) / 40.0D;
		      
				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, -0.08D, 0.0D);
			}		
			super.onUpdate();
		}
	}
	
	public static class DaiFunka extends AbilityProjectile
	{
		public DaiFunka(World world)
		{super(world);}
		
		public DaiFunka(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public DaiFunka(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
				hit.entityHit.setFire(100);
			
			if(MainConfig.enableGriefing)
				DevilFruitsHelper.placeBlockIfAllowed(worldObj, hit.blockX, hit.blockY, hit.blockZ, Blocks.flowing_lava, "core", "foliage");
		};
		
		@Override
		public void onUpdate()
		{	
			for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(13); i++)
			{
				double offsetX = (new Random().nextInt(40) + 1.0D - 20.0D) / 10.0D;
				double offsetY = (new Random().nextInt(40) + 1.0D - 20.0D) / 10.0D;
				double offsetZ = (new Random().nextInt(40) + 1.0D - 20.0D) / 10.0D;
		      
				this.worldObj.spawnParticle(EnumParticleTypes.LAVA.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D);
				//this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, -2.0D, 0.0D);
			}		
			super.onUpdate();
		}
	}	
	
}
