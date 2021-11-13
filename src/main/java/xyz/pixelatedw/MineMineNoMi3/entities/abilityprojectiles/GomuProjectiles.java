package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class GomuProjectiles
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();

	static
	{
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoRocket.class, ListAttributes.GOMU_GOMU_NO_ROCKET
		});

		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoPistol.class, ListExtraAttributes.GOMU_GOMU_NO_PISTOL
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoJetPistol.class, ListExtraAttributes.GOMU_GOMU_NO_JET_PISTOL
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoElephantGun.class, ListExtraAttributes.GOMU_GOMU_NO_ELEPHANT_GUN
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoKongGun.class, ListExtraAttributes.GOMU_GOMU_NO_KONG_GUN
		});

		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoBazooka.class, ListExtraAttributes.GOMU_GOMU_NO_BAZOOKA
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoJetBazooka.class, ListExtraAttributes.GOMU_GOMU_NO_JET_BAZOOKA
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoGrizzlyMagnum.class, ListExtraAttributes.GOMU_GOMU_NO_GRIZZLY_MAGNUM
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoLeoBazooka.class, ListExtraAttributes.GOMU_GOMU_NO_LEO_BAZOOKA
		});

		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoGatling.class, ListExtraAttributes.GOMU_GOMU_NO_GATLING
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoJetGatling.class, ListExtraAttributes.GOMU_GOMU_NO_JET_GATLING
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoElephantGatling.class, ListExtraAttributes.GOMU_GOMU_NO_ELEPHANT_GATLING
		});
		abilitiesClassesArray.add(new Object[]
		{
				GomuGomuNoKongOrgan.class, ListExtraAttributes.GOMU_GOMU_NO_KONG_ORGAN
		});
	}

	public static class GomuGomuNoRocket extends AbilityProjectile
	{
		public GomuGomuNoRocket(World world)
		{
			super(world);
		}

		public GomuGomuNoRocket(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoRocket(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			EntityPlayer player = (EntityPlayer) this.getThrower();
			if (hit.entityHit != null)
			{

			}
			else
			{
				Direction dir = WyHelper.get8Directions(player);

				double mX = 0;
				double mY = 0;
				double mZ = 0;

				double powerX = Math.abs(hit.blockX - player.posX) / 5;
				double powerY = (hit.blockY - player.posY) / 4;
				double powerZ = Math.abs(hit.blockZ - player.posZ) / 5;

				mY += powerY;

				if (dir == WyHelper.Direction.NORTH)
					mZ -= powerZ;
				if (dir == WyHelper.Direction.NORTH_WEST)
				{
					mZ -= powerZ;
					mX -= powerX;
				}
				if (dir == WyHelper.Direction.SOUTH)
					mZ += powerZ;
				if (dir == WyHelper.Direction.NORTH_EAST)
				{
					mZ -= powerZ;
					mX += powerX;
				}
				if (dir == WyHelper.Direction.WEST)
					mX -= powerX;
				if (dir == WyHelper.Direction.SOUTH_WEST)
				{
					mZ += powerZ;
					mX -= powerZ;
				}
				if (dir == WyHelper.Direction.EAST)
					mX += powerX;
				if (dir == WyHelper.Direction.SOUTH_EAST)
				{
					mZ += powerZ;
					mX += powerX;
				}

				motion("=", mX, mY, mZ, player);
			}
		}
	}

	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}

	public static class GomuGomuNoKongOrgan extends AbilityProjectile
	{
		public GomuGomuNoKongOrgan(World world)
		{
			super(world);
		}

		public GomuGomuNoKongOrgan(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoKongOrgan(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}
	}

	public static class GomuGomuNoElephantGatling extends AbilityProjectile
	{
		public GomuGomuNoElephantGatling(World world)
		{
			super(world);
		}

		public GomuGomuNoElephantGatling(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoElephantGatling(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}
	}

	public static class GomuGomuNoJetGatling extends AbilityProjectile
	{
		public GomuGomuNoJetGatling(World world)
		{
			super(world);
		}

		public GomuGomuNoJetGatling(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoJetGatling(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		@Override
		public void onUpdate()
		{
			for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
			{
				double offsetX = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;
				double offsetY = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;
				double offsetZ = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;

				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D);
				this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D);
			}
			super.onUpdate();
		}
	}

	public static class GomuGomuNoGatling extends AbilityProjectile
	{
		public GomuGomuNoGatling(World world)
		{
			super(world);
		}

		public GomuGomuNoGatling(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoGatling(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}
	}

	public static class GomuGomuNoLeoBazooka extends AbilityProjectile
	{
		public GomuGomuNoLeoBazooka(World world)
		{
			super(world);
		}

		public GomuGomuNoLeoBazooka(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoLeoBazooka(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				double newPosX = 0, newPosY = 0, newPosZ = 0;

				int minPower = 13;
				int maxPower = 17;

				newPosY += 2;
				Direction dir = WyHelper.get4Directions(this.getThrower());
				if (dir == WyHelper.Direction.SOUTH)
					newPosZ += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.EAST)
					newPosX += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.NORTH)
					newPosZ -= WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.WEST)
					newPosX -= WyMathHelper.randomWithRange(minPower, maxPower);

				((EntityLivingBase) hit.entityHit).setPositionAndUpdate(hit.entityHit.posX + newPosX, hit.entityHit.posY + newPosY, hit.entityHit.posZ + newPosZ);
			}
		}
	}

	public static class GomuGomuNoGrizzlyMagnum extends AbilityProjectile
	{
		public GomuGomuNoGrizzlyMagnum(World world)
		{
			super(world);
		}

		public GomuGomuNoGrizzlyMagnum(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoGrizzlyMagnum(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				double newPosX = 0, newPosY = 0, newPosZ = 0;

				int minPower = 8;
				int maxPower = 15;

				newPosY += 2;
				Direction dir = WyHelper.get4Directions(this.getThrower());
				if (dir == WyHelper.Direction.SOUTH)
					newPosZ += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.EAST)
					newPosX += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.NORTH)
					newPosZ -= WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.WEST)
					newPosX -= WyMathHelper.randomWithRange(minPower, maxPower);

				((EntityLivingBase) hit.entityHit).setPositionAndUpdate(hit.entityHit.posX + newPosX, hit.entityHit.posY + newPosY, hit.entityHit.posZ + newPosZ);
			}
		}
	}

	public static class GomuGomuNoJetBazooka extends AbilityProjectile
	{
		public GomuGomuNoJetBazooka(World world)
		{
			super(world);
		}

		public GomuGomuNoJetBazooka(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoJetBazooka(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		@Override
		public void onUpdate()
		{
			for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
			{
				double offsetX = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;
				double offsetY = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;
				double offsetZ = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;

				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D);
				this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D);
			}
			super.onUpdate();
		}

		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				double newPosX = 0, newPosY = 0, newPosZ = 0;

				int minPower = 5;
				int maxPower = 8;

				newPosY += 2;
				Direction dir = WyHelper.get4Directions(this.getThrower());
				if (dir == WyHelper.Direction.SOUTH)
					newPosZ += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.EAST)
					newPosX += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.NORTH)
					newPosZ -= WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.WEST)
					newPosX -= WyMathHelper.randomWithRange(minPower, maxPower);

				((EntityLivingBase) hit.entityHit).setPositionAndUpdate(hit.entityHit.posX + newPosX, hit.entityHit.posY + newPosY, hit.entityHit.posZ + newPosZ);
			}
		}
	}

	public static class GomuGomuNoBazooka extends AbilityProjectile
	{
		public GomuGomuNoBazooka(World world)
		{
			super(world);
		}

		public GomuGomuNoBazooka(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoBazooka(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		@Override
		public void tasksImapct(MovingObjectPosition hit)
		{
			if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{
				double newPosX = 0, newPosY = 0, newPosZ = 0;

				int minPower = 3;
				int maxPower = 8;

				newPosY += 2;
				Direction dir = WyHelper.get4Directions(this.getThrower());
				if (dir == WyHelper.Direction.SOUTH)
					newPosZ += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.EAST)
					newPosX += WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.NORTH)
					newPosZ -= WyMathHelper.randomWithRange(minPower, maxPower);
				else if (dir == WyHelper.Direction.WEST)
					newPosX -= WyMathHelper.randomWithRange(minPower, maxPower);

				((EntityLivingBase) hit.entityHit).setPositionAndUpdate(hit.entityHit.posX + newPosX, hit.entityHit.posY + newPosY, hit.entityHit.posZ + newPosZ);
			}
		}
	}

	public static class GomuGomuNoPistol extends AbilityProjectile
	{
		public GomuGomuNoPistol(World world)
		{
			super(world);
		}

		public GomuGomuNoPistol(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoPistol(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}
	}

	public static class GomuGomuNoJetPistol extends AbilityProjectile
	{
		public GomuGomuNoJetPistol(World world)
		{
			super(world);
		}

		public GomuGomuNoJetPistol(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoJetPistol(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}

		@Override
		public void onUpdate()
		{
			for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++)
			{
				double offsetX = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;
				double offsetY = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;
				double offsetZ = (new Random().nextInt(5) + 1.0D - 2.5D) / 5.0D;

				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D);
				this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D);
			}
			super.onUpdate();
		}
	}

	public static class GomuGomuNoElephantGun extends AbilityProjectile
	{
		public GomuGomuNoElephantGun(World world)
		{
			super(world);
		}

		public GomuGomuNoElephantGun(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoElephantGun(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}
	}

	public static class GomuGomuNoKongGun extends AbilityProjectile
	{
		public GomuGomuNoKongGun(World world)
		{
			super(world);
		}

		public GomuGomuNoKongGun(World world, double x, double y, double z)
		{
			super(world, x, y, z);
		}

		public GomuGomuNoKongGun(World world, EntityLivingBase player, AbilityAttribute attr)
		{
			super(world, player, attr);
		}
	}
}
