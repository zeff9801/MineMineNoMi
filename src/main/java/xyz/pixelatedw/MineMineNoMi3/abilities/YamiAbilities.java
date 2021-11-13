package xyz.pixelatedw.MineMineNoMi3.abilities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectLogiaOff;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilityReset;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.YamiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class YamiAbilities 
{

	static
	{
		Values.abilityWebAppExtraParams.put("darkmatter", new String[] {"desc", "Launches a ball of darkness that engulfs the opponent."});
		Values.abilityWebAppExtraParams.put("kurouzu", new String[] {"desc", "Creates a strong gravitational force, that pulls the opponent towards the user."});
		Values.abilityWebAppExtraParams.put("blackhole", new String[] {"desc", "The user spreads darkness over the target area, which engulfs anyone and anything inside of it."});
		Values.abilityWebAppExtraParams.put("liberation", new String[] {"desc", "The user expells everything sucked up by the 'Black Hole' at the target location."});
		Values.abilityWebAppExtraParams.put("blackworld", new String[] {"desc", "The user spreads darkness to the surroundings, blinding enemies and creating pillars made of Darkness."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Kurouzu(), new DarkMatter(), new Liberation(), new BlackHole(), new BlackWorld()};	
	
	public static class BlackWorld extends Ability
	{
		public BlackWorld() 
		{
			super(ListAttributes.BLACK_WORLD); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_BLACKWORLD, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);

				if(MainConfig.enableGriefing)
				{	
					for(int i = 0; i < 8; i++)
					{
						int a1 = player.getRNG().nextInt(20) - 10;
						int a2 = player.getRNG().nextInt(20) - 10;
						
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY , (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 1, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 2, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 3, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 4, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");
						
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 1, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 2, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 3, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 4, (int)player.posZ + a2, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 1, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 2, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 3, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 4, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 1, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");		
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 2, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 3, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 4, (int)player.posZ + a2 + 1, ListMisc.Darkness, "core", "foliage", "liquid", "air");	
	
					}
				}
				
				super.use(player);
			}
		}
	}
	
	public static class BlackHole extends Ability
	{
		public BlackHole() 
		{
			super(ListAttributes.BLACKHOLE); 
		}
		
		@Override
		public void use(final EntityPlayer player)
		{				
			if(!this.isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					WyHelper.createFilledSphere(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, 10, ListMisc.Darkness, "core", "foliage", "liquids", "ores");
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_BLACKHOLE, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
				}
				
				super.use(player);
			}		
		}
	}
	
	public static class Liberation extends Ability
	{
		public int liberationCount = 0;
		
		public Liberation() 
		{
			super(ListAttributes.LIBERATION); 
		}
		
		/** TODO Explosion particles */
		@Override
		public void use(final EntityPlayer player)
		{
			int libCount = 0;
			
			if(!this.isOnCooldown)
			{
				if(liberationCount > 0)
				{
					MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	
					
					if(mop != null)
					{
						double x = mop.blockX;
						double y = mop.blockY;
						double z = mop.blockZ;

						while(liberationCount > 0)
						{
							AbilityProjectile proj = new YamiProjectiles.Liberation(player.worldObj, player, ListExtraAttributes.LIBERATION_BLOCK);	
							proj.setLocationAndAngles(x + WyMathHelper.randomWithRange(-3, 3), (y + 14) + WyMathHelper.randomWithRange(0, 4), z + WyMathHelper.randomWithRange(-3, 3), 0, 0);
							proj.motionX = 0;
							proj.motionZ = 0;
							proj.motionY = -0.7 - player.worldObj.rand.nextDouble();
							player.worldObj.spawnEntityInWorld(proj);
							liberationCount--;	
						}					
					}
				}
				else
				{
					for(int x = -40; x < 40; x++)
					for(int y = -40; y < 40; y++)
					for(int z = -40; z < 40; z++)
					{
						if( player.worldObj.getBlock((int) player.posX + x, (int) player.posY + y, (int) player.posZ + z) == ListMisc.Darkness)
						{
							player.worldObj.setBlockToAir((int) player.posX + x, (int) player.posY + y, (int) player.posZ + z);
							libCount++;
							if(libCount % 10 == 0)
								liberationCount++;
						}
					}
				}
				
				super.use(player);
			}		
		}
	}
	
	public static class Kurouzu extends Ability
	{
		private List<EntityLivingBase> entities = new ArrayList<EntityLivingBase>();
		
		public Kurouzu() 
		{
			super(ListAttributes.KUROUZU); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			super.startCharging(player);				
		}
		
		@Override
		public void duringCharging(EntityPlayer player, int currentCharge)
		{
			MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	
			
			this.entities.clear();
			if(mop != null)
			{
				double i = mop.blockX;
				double j = mop.blockY;
				double k = mop.blockZ;

				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KOROUZU, i, j, k), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
				
				for(EntityLivingBase target : WyHelper.getEntitiesNear((int)i, (int)j, (int)k, player.worldObj, 5))
				{
					this.entities.add(target);
				}
			}
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{
			if(this.entities.contains(player))
				this.entities.remove(player);
			for(EntityLivingBase target : this.entities)
			{
				target.setPositionAndUpdate(player.posX, player.posY, player.posZ);
				target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
				target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 100, 5));
				target.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 5));
				new DFEffectLogiaOff(target, 100);
				if(target instanceof EntityPlayer)
				{
					EntityPlayer playerTarget = (EntityPlayer)target;
					WyNetworkHelper.sendTo(new PacketAbilityReset(false), (EntityPlayerMP) playerTarget);
				}
			}
			super.endCharging(player);
		}
	}
	
	public static class DarkMatter extends Ability
	{
		public DarkMatter() 
		{
			super(ListAttributes.DARK_MATTER);
		}
		
		@Override
		public void use(final EntityPlayer player)
		{				
			this.projectile = new YamiProjectiles.DarkMatter(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
}
