package xyz.pixelatedw.MineMineNoMi3.abilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.OpeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.items.devilfruitextras.Heart;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class OpeAbilities
{

	static
	{
		Values.abilityWebAppExtraParams.put("room", new String[]
			{
					"desc", "Creates a spherical space around the user, in which they can manipulate anything with other skills."
			});
		Values.abilityWebAppExtraParams.put("countershock", new String[]
			{
					"desc", "Releases a strong electrical current, which shocks the opponent."
			});
		Values.abilityWebAppExtraParams.put("mes", new String[]
			{
					"desc", "Removes the heart of the user's target, which they can then damage to hurt the opponent."
			});
		Values.abilityWebAppExtraParams.put("gammaknife", new String[]
			{
					"desc", "Creates a blade of gamma radiation, which massively damages the opponent's organs"
			});
		Values.abilityWebAppExtraParams.put("shambles", new String[]
			{
					"desc", "The user swaps place with the closest entity within the ROOM."
			});
		Values.abilityWebAppExtraParams.put("takt", new String[]
			{
					"desc", "Lifts all entities inside ROOM, making them unable to move."
			});
		Values.abilityWebAppExtraParams.put("injectionshot", new String[]
			{
					"desc", "While holding a weapon, the user charges at the enemy, leaving them poisoned and confused."
			});
	}

	public static Ability[] abilitiesArray = new Ability[]
		{
				new Room(), new Mes(), new CounterShock(), new GammaKnife(), new Takt(), new Shambles(), new InjectionShot()
		};

	public static class InjectionShot extends Ability
	{
		public InjectionShot()
		{
			super(ListAttributes.INJECTION_SHOT);
		}

		@Override
		public void use(EntityPlayer player)
		{
			if (DevilFruitsHelper.isEntityInRoom(player))
			{
				if (!ItemsHelper.isSword(player.getHeldItem()))
				{
					WyHelper.sendMsgToPlayer(player, "You need a sword to use this ability !");
					return;
				}
				
				if (!this.isOnCooldown)
				{
					double mX = -MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI) * 0.4;
					double mZ = MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI) * 0.4;

					double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
					mX /= f2;
					mZ /= f2;
					mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
					mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0;
					mX *= 3;
					mZ *= 3;

					motion("=", mX, player.motionY, mZ, player);

					if (player.worldObj instanceof WorldServer)
						((WorldServer) player.worldObj).getEntityTracker().func_151248_b(player, new S0BPacketAnimation(player, 0));
				}

				super.use(player);
					
			}
			else 
				WyHelper.sendMsgToPlayer(player,""+this.getAttribute().getAttributeName()+" can only be used inside ROOM !");
	}

	@Override
	public void duringCooldown(EntityPlayer player, int currentCooldown)
	{
		if (currentCooldown > 13 * 20)
		{
			for (EntityLivingBase e : WyHelper.getEntitiesNear(player, 1.6))
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);

				e.addPotionEffect(new PotionEffect(Potion.poison.id, 10 * 20, 0));
				e.addPotionEffect(new PotionEffect(Potion.confusion.id, 10 * 20, 0));
			}
		}
	}
}

public static class Takt extends Ability
{
	private HashMap<EntityLivingBase, Double> entitiesInRoom = new HashMap<EntityLivingBase, Double>();

	public Takt()
	{
		super(ListAttributes.TAKT);
	}

	@Override
	public void passive(EntityPlayer player)
	{
		if (!this.isPassiveActive())
		{
			if (DevilFruitsHelper.isEntityInRoom(player))
			{
				for (EntityLivingBase entity : WyHelper.getEntitiesNear(player, 40))
				{
					if (DevilFruitsHelper.isEntityInRoom(entity) && !entity.equals(player))
					{
						entitiesInRoom.put(entity, entity.posY + 3);
					}
				}
				super.passive(player);
			}
			else
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used inside ROOM !");
		}
		else
		{
			super.passive(player);
		}
	}

	@Override
	public void duringPassive(EntityPlayer player, int passiveTimer)
	{
		if (!DevilFruitsHelper.isEntityInRoom(player))
		{
			this.setPassiveActive(false);
			this.setCooldownActive(true);
			this.endPassive(player);
		}

		if (passiveTimer >= 160)
		{
			this.setPassiveActive(false);
			this.setCooldownActive(true);
			this.endPassive(player);
		}

		Iterator it = entitiesInRoom.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<EntityLivingBase, Double> pair = (Map.Entry) it.next();
			pair.getKey().setPositionAndUpdate(pair.getKey().posX, pair.getValue(), pair.getKey().posZ);
			pair.getKey().fallDistance = 0;
		}
	}

	@Override
	public void endPassive(EntityPlayer player)
	{
		this.startCooldown();
		this.startExtUpdate(player);
		this.entitiesInRoom.clear();
	}
}

public static class Shambles extends Ability
{
	public Shambles()
	{
		super(ListAttributes.SHAMBLES);
	}

	@Override
	public void use(EntityPlayer player)
	{
		if (DevilFruitsHelper.isEntityInRoom(player))
		{
			if (!this.isOnCooldown)
			{
				MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);

				if (mop != null)
				{
					double i = mop.blockX;
					double j = mop.blockY;
					double k = mop.blockZ;

					List<EntityLivingBase> entityList = WyHelper.getEntitiesNear((int) i, (int) j, (int) k, player.worldObj, 4, EntityLivingBase.class);

					if (entityList.size() <= 0)
						return;

					EntityLivingBase target = entityList.get(0);

					double[] beforeCoords = new double[]
						{
								player.posX, player.posY, player.posZ
						};
					player.setPositionAndRotation(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
					player.setPositionAndUpdate(target.posX, target.posY, target.posZ);
					target.setPositionAndUpdate(beforeCoords[0], beforeCoords[1], beforeCoords[2]);

				}
			}
			super.use(player);
		}
		else
			WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used inside ROOM !");
	}
}

public static class GammaKnife extends Ability
{
	public GammaKnife()
	{
		super(ListAttributes.GAMMA_KNIFE);
	}

	@Override
	public void use(EntityPlayer player)
	{
		if (DevilFruitsHelper.isEntityInRoom(player))
		{
			this.projectile = new OpeProjectiles.GammaKnife(player.worldObj, player, attr);
			super.use(player);
		}
		else
			WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used inside ROOM !");
	}
}

public static class Mes extends Ability
{
	public Mes()
	{
		super(ListAttributes.MES);
	}

	@Override
	public void hitEntity(EntityPlayer player, EntityLivingBase target)
	{
		ExtendedEntityData targetprops = ExtendedEntityData.get(target);

		if (targetprops.hasHeart())
		{
			ItemStack heart = new ItemStack(ListMisc.Heart);
			((Heart) heart.getItem()).setHeartOwner(heart, target);
			heart.setStackDisplayName(target.getCommandSenderName() + "'s Heart");

			player.inventory.addItemStackToInventory(heart);

			targetprops.setHasHeart(false);
		}

		super.hitEntity(player, target);
	}
}

public static class CounterShock extends Ability
{
	public CounterShock()
	{
		super(ListAttributes.COUNTER_SHOCK);
	}

	@Override
	public void hitEntity(EntityPlayer player, EntityLivingBase target)
	{
		super.hitEntity(player, target);
		WyNetworkHelper.sendTo(new PacketParticles(ID.PARTICLEFX_ELTHOR, target.posX, target.posY, target.posZ), (EntityPlayerMP) player);
	}
}

public static class Room extends Ability
{
	private List<int[]> blockList = new ArrayList<int[]>();

	public Room()
	{
		super(ListAttributes.ROOM);
	}

	@Override
	public void passive(EntityPlayer player)
	{
		if (!this.isOnCooldown)
		{
			if (this.blockList.isEmpty())
			{
				this.blockList.addAll(WyHelper.createEmptySphere(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, 20, ListMisc.Ope, "air", "foliage", "liquids", "nogrief"));
				player.worldObj.setBlock((int) player.posX, (int) player.posY, (int) player.posZ, ListMisc.OpeMid);
				this.blockList.add(new int[]
					{
							(int) player.posX, (int) player.posY, (int) player.posZ
					});
			}

			super.passive(player);
		}
	}

	@Override
	public void endPassive(EntityPlayer player)
	{
		for (int[] blockPos : this.blockList)
		{
			if (player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.Ope || player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.OpeMid)
				player.worldObj.setBlock(blockPos[0], blockPos[1], blockPos[2], Blocks.air);
		}
		this.blockList = new ArrayList<int[]>();
		this.startCooldown();
		this.startExtUpdate(player);
	}

	}

	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
}
