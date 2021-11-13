package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;

import java.util.ArrayList;

public class GoroProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {ElThorThunder.class, ListExtraAttributes.EL_THOR_THUNDER});
		abilitiesClassesArray.add(new Object[] {Sango.class, ListAttributes.SANGO});
		abilitiesClassesArray.add(new Object[] {Raigo.class, ListAttributes.RAIGO});
		abilitiesClassesArray.add(new Object[] {VoltVari5Million.class, ListExtraAttributes.VOLT_VARI_5_MILLION});
		abilitiesClassesArray.add(new Object[] {VoltVari20Million.class, ListExtraAttributes.VOLT_VARI_20_MILLION});
		abilitiesClassesArray.add(new Object[] {VoltVari60Million.class, ListExtraAttributes.VOLT_VARI_60_MILLION});
		abilitiesClassesArray.add(new Object[] {VoltVari200Million.class, ListExtraAttributes.VOLT_VARI_200_MILLION});
	}
	
	public static class ElThorThunder extends AbilityProjectile
	{
		public ElThorThunder(World world)
		{super(world);}
		
		public ElThorThunder(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public ElThorThunder(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class Sango extends AbilityProjectile
	{
		public Sango(World world)
		{super(world);}
		
		public Sango(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Sango(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}

		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
				{				    
					ResourceLocation particleToUse = i % 2 == 0 ? ID.PARTICLE_ICON_GORO2 : ID.PARTICLE_ICON_GORO;
					
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, particleToUse, 
							posX + (this.worldObj.rand.nextDouble()),
							posY + (this.worldObj.rand.nextDouble() - 0.5),
							posZ + (this.worldObj.rand.nextDouble()),
							0, 0, 0)
							.setParticleAge(5).setParticleScale(4);
					
					MainMod.proxy.spawnCustomParticles(this, particle);					
				}			
			}
			
			super.onUpdate();
		}
	}	
	
	public static class Raigo extends AbilityProjectile
	{
		public Raigo(World world)
		{super(world);}
		
		public Raigo(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Raigo(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(35); i++)
				{
					double offsetX = WyMathHelper.randomWithRange(-8, 8);
					double offsetY = WyMathHelper.randomWithRange(-10, 20);
					double offsetZ = WyMathHelper.randomWithRange(-8, 8);
				      
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GORO2, 
							posX + offsetX + this.worldObj.rand.nextDouble(), 
							posY + offsetY + this.worldObj.rand.nextDouble(), 
							posZ + offsetZ + this.worldObj.rand.nextDouble(), 
							0, 0, 0)
							.setParticleAge(10).setParticleScale(10);
					
					MainMod.proxy.spawnCustomParticles(this, particle);					
				}			
			}
			
			super.onUpdate();
		}
	}
	
	public static class VoltVari5Million extends AbilityProjectile
	{
		public VoltVari5Million(World world)
		{super(world);}
		
		public VoltVari5Million(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public VoltVari5Million(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
				{
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GORO2, 
							posX + this.worldObj.rand.nextDouble() - 0.5, 
							posY + this.worldObj.rand.nextDouble() - 0.5, 
							posZ + this.worldObj.rand.nextDouble() - 0.5, 
							0, 0, 0)
							.setParticleAge(10).setParticleScale(2);
					
					MainMod.proxy.spawnCustomParticles(this, particle);					
				}			
			}
			
			super.onUpdate();
		}
	}
	
	public static class VoltVari20Million extends AbilityProjectile
	{
		public VoltVari20Million(World world)
		{super(world);}
		
		public VoltVari20Million(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public VoltVari20Million(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
				{
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GORO2, 
							posX + this.worldObj.rand.nextDouble() - 0.5, 
							posY + this.worldObj.rand.nextDouble() - 0.5, 
							posZ + this.worldObj.rand.nextDouble() - 0.5, 
							0, 0, 0)
							.setParticleAge(10).setParticleScale(2);
					
					MainMod.proxy.spawnCustomParticles(this, particle);					
				}			
			}
			
			super.onUpdate();
		}
	}
	
	public static class VoltVari60Million extends AbilityProjectile
	{
		public VoltVari60Million(World world)
		{super(world);}
		
		public VoltVari60Million(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public VoltVari60Million(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
				{
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GORO2, 
							posX + this.worldObj.rand.nextDouble() - 0.5, 
							posY + this.worldObj.rand.nextDouble() - 0.5, 
							posZ + this.worldObj.rand.nextDouble() - 0.5, 
							0, 0, 0)
							.setParticleAge(10).setParticleScale(2);
					
					MainMod.proxy.spawnCustomParticles(this, particle);					
				}			
			}
			
			super.onUpdate();
		}
	}
	
	public static class VoltVari200Million extends AbilityProjectile
	{
		public VoltVari200Million(World world)
		{super(world);}
		
		public VoltVari200Million(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public VoltVari200Million(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{	
			if(this.worldObj.isRemote)
			{
				for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
				{
					EntityParticleFX particle = new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GORO2, 
							posX + this.worldObj.rand.nextDouble() - 0.5, 
							posY + this.worldObj.rand.nextDouble() - 0.5, 
							posZ + this.worldObj.rand.nextDouble() - 0.5, 
							0, 0, 0)
							.setParticleAge(10).setParticleScale(2);
					
					MainMod.proxy.spawnCustomParticles(this, particle);					
				}			
			}
			
			super.onUpdate();
		}
	}
	
}
