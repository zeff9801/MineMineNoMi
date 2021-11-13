package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ToriPhoenixProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

import java.util.Random;

public class ToriPhoenixAbilities
{

	static
	{
		Values.abilityWebAppExtraParams.put("hybridpoint", new String[] {"desc", "The user transforms into a phoenix-human hybrid, which allows them to fly. Allows the user to use 'Phoenix Goen' "});
		Values.abilityWebAppExtraParams.put("phoenixpoint", new String[] {"desc", "The user fully transforms into a phoenix, allowing them to fly at great speed. Allows the user to use both 'Phoenix Goen' and 'Tensei no Soen'"});
		Values.abilityWebAppExtraParams.put("phoenixgoen", new String[] {"desc", "Launches a powerful fiery shockwave made of blue flames at the target."});
		Values.abilityWebAppExtraParams.put("tenseinosoen", new String[] {"desc", "While in the air, the user amasses spiraling flames, then slams into the ground, releasing a massive shockwave."});		
		Values.abilityWebAppExtraParams.put("blueflamesofresurrection", new String[] {"desc", "Blue phoenix flames grant the user regeneration."});
		Values.abilityWebAppExtraParams.put("flameofrestoration", new String[] {"desc", "Uses the blue flames to heal the target."});	
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new PhoenixPoint(), new HybridPoint(), new BlueFlamesOfResurrection(), new FlameOfRestoration(), new PhoenixGoen(), new TenseiNoSoen()};
	
	public static class HybridPoint extends Ability
	{
		public HybridPoint()
		{
			super(ListAttributes.PHOENIX_HYBRID_POINT);
		}

		@Override
		public void passive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("hybrid")))
			{
				super.passive(player);
			}
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (props.getZoanPoint().isEmpty())
				props.setZoanPoint("n/a");

			props.setZoanPoint("hybrid");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			props.setZoanPoint("n/a");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
	}
	
	public static class TenseiNoSoen extends Ability
	{
		private int particlesSpawned = 0;
		
		public TenseiNoSoen() 
		{
			super(ListAttributes.TENSEI_NO_SOEN); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);
			particlesSpawned = 0;
			
			if((props.getZoanPoint().equals("full")) && !this.isOnCooldown)
			{
				if(!player.onGround)
				{
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_TENSEINOSOEN1, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
					super.startCharging(player);
				}
				else
					WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while airborne !");
			}
			else if(!props.getZoanPoint().equals("full"))
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while Phoenix Point is active !");
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{
			player.fallDistance = 0;
			motion("=", 0, -100, 0, player);
			super.endCharging(player);
		}		
		
	    @Override
		public void duringCooldown(EntityPlayer player, int currentCooldown)
	    {
			if(currentCooldown > 28 * 20)
			{
				if(player.onGround && particlesSpawned < 10)
				{
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_TENSEINOSOEN2, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
					particlesSpawned++;
				}			
				
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 20))
				{
					if(e.posY >= player.posY)
						e.attackEntityFrom(DamageSource.causePlayerDamage(player), 30);
				}
			}
	    }
	}
	
	public static class PhoenixGoen extends Ability
	{
		public PhoenixGoen() 
		{
			super(ListAttributes.PHOENIX_GOEN); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if((props.getZoanPoint().equals("full") || props.getZoanPoint().equals("hybrid")) && !this.isOnCooldown)
			{
				for (int i = 0; i < 100; i++)
				{
					double offsetX = (new Random().nextInt(20) + 1.0D - 5.0D) / 5.0D;
					double offsetY = (new Random().nextInt(20) + 1.0D - 20.0D) / 10.0D;
					double offsetZ = (new Random().nextInt(20) + 1.0D - 5.0D) / 5.0D;
						
					this.projectile = new ToriPhoenixProjectiles.PhoenixGoen(player.worldObj, player, attr);
					this.projectile.setLocationAndAngles(player.posX - 1 + offsetX, player.posY + 2 + offsetY, player.posZ + offsetZ, player.cameraPitch, player.cameraYaw);
					player.worldObj.spawnEntityInWorld(projectile);
				}
					
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
				super.use(player);
			}
			else if(!props.getZoanPoint().equals("full") && !props.getZoanPoint().equals("hybrid"))
				WyHelper.sendMsgToPlayer(player, "" + this.getAttribute().getAttributeName() + " can only be used while Phoenix Point or Hybrid Point is active !");
		}	
	}
	
	public static class FlameOfRestoration extends Ability
	{
		public FlameOfRestoration() 
		{
			super(ListAttributes.FLAME_OF_RESTORATION); 
		}
		
		@Override
		public void hitEntity(EntityPlayer player, EntityLivingBase target) 
		{
			super.hitEntity(player, target);

			target.setHealth(Math.min(target.getHealth() + 6, target.getMaxHealth()));
			
			WyNetworkHelper.sendTo(new PacketParticles(ID.PARTICLEFX_BLUEFLAMES, player), (EntityPlayerMP) player);
		}
	}	
	
	public static class BlueFlamesOfResurrection extends Ability
	{
		public BlueFlamesOfResurrection() 
		{
			super(ListAttributes.BLUE_FLAMES_OF_RESURRECTION); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			if(!isOnCooldown)
			{
				WyNetworkHelper.sendTo(new PacketParticles(ID.PARTICLEFX_BLUEFLAMES, player), (EntityPlayerMP) player);
			}
			super.use(player);
		}
	}	
	
	public static class PhoenixPoint extends Ability
	{
		public PhoenixPoint()
		{
			super(ListAttributes.PHOENIX_FULL_POINT);
		}

		@Override
		public void passive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("full")))
			{
				super.passive(player);
			}
		}
		
		@Override
		public void startPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			if (props.getZoanPoint().isEmpty())
				props.setZoanPoint("n/a");

			props.setZoanPoint("full");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
		
		@Override
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityData props = ExtendedEntityData.get(player);

			props.setZoanPoint("n/a");
			WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			WyNetworkHelper.sendToAll(new PacketSyncInfo(player.getDisplayName(), props));
		}
	}
	
	private static void motion(String c, double x, double y, double z, EntityPlayer p)
	{
		WyNetworkHelper.sendTo(new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP) p);
	}
}
