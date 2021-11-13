package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

import java.util.ArrayList;

public class ExtraProjectiles 
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {NormalBullet.class, ListExtraAttributes.NORMAL_BULLET});
		abilitiesClassesArray.add(new Object[] {KairosekiBullet.class, ListExtraAttributes.KAIROSEKI_BULLET});
		abilitiesClassesArray.add(new Object[] {AxeDialProjectile.class, ListExtraAttributes.DIAL_AXE});
		abilitiesClassesArray.add(new Object[] {PopGreen.class, ListExtraAttributes.POP_GREEN});
		abilitiesClassesArray.add(new Object[] {KujaArrow.class, ListExtraAttributes.KUJA_ARROW});
		abilitiesClassesArray.add(new Object[] {CannonBall.class, ListExtraAttributes.CANNON_BALL});
	}
	
	public static class CannonBall extends AbilityProjectile
	{
		public CannonBall(World world)
		{super(world);}
		
		public CannonBall(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public CannonBall(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class EntityCloud extends Entity
	{
		private int life = 100;
		private EntityPlayer thrower;
		
		public EntityCloud(World world)
		{
			super(world);
		}
		
		@Override
		public void onUpdate()
		{
			super.onUpdate();
			if(!this.worldObj.isRemote)
			{
				if(life <= 0)
					this.setDead();

				life--;
			}		
		}
		
		public EntityPlayer getThrower()
		{
			return this.thrower;
		}
		
		public void setThrower(EntityPlayer player)
		{
			this.thrower = player;
		}
		
		public int getLife()
		{
			return this.life;
		}
		
		public void setLife(int life)
		{
			this.life = life;
		}
		
		@Override
		protected void entityInit() {}
		@Override
		protected void readEntityFromNBT(NBTTagCompound nbt) {}
		@Override
		protected void writeEntityToNBT(NBTTagCompound nbt) {}
	}
	
	public static class MilkyDialProjectile extends AbilityProjectile
	{
		public MilkyDialProjectile(World world)
		{super(world);}
		
		public MilkyDialProjectile(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public MilkyDialProjectile(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void onUpdate()
		{
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX, (int)this.posY - 1, (int)this.posZ, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX + 1, (int)this.posY - 1, (int)this.posZ, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX - 1, (int)this.posY - 1, (int)this.posZ, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX + 1, (int)this.posY - 1, (int)this.posZ + 1, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX + 1, (int)this.posY - 1, (int)this.posZ - 1, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX - 1, (int)this.posY - 1, (int)this.posZ + 1, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX, (int)this.posY - 1, (int)this.posZ + 1, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX, (int)this.posY - 1, (int)this.posZ - 1, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX - 1, (int)this.posY - 1, (int)this.posZ - 1, ListMisc.SkyBlock, 1, 3, "air");
			DevilFruitsHelper.placeBlockIfAllowed(this.worldObj, (int)this.posX, (int)this.posY - 2, (int)this.posZ, ListMisc.SkyBlock, 1, 3, "air");
			
			super.onUpdate();
		}
	}	
	
	public static class AxeDialProjectile extends AbilityProjectile
	{
		public AxeDialProjectile(World world)
		{super(world);}
		
		public AxeDialProjectile(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public AxeDialProjectile(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			WyHelper.doExplosion(this.getThrower(), this.posX, this.posY, this.posZ, 4);
		}	
	}	
	
	public static class PopGreen extends AbilityProjectile
	{
		public PopGreen(World world)
		{super(world);}
		
		public PopGreen(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public PopGreen(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class KujaArrow extends AbilityProjectile
	{
		public KujaArrow(World world)
		{super(world);}
		
		public KujaArrow(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public KujaArrow(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class NormalBullet extends AbilityProjectile
	{
		public NormalBullet(World world)
		{super(world);}
		
		public NormalBullet(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public NormalBullet(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class KairosekiBullet extends AbilityProjectile
	{
		public KairosekiBullet(World world)
		{super(world);}
		
		public KairosekiBullet(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public KairosekiBullet(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
}
