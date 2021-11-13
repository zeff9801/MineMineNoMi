package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari200Million;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari20Million;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari5Million;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles.VoltVari60Million;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class GoroAbilities
{
	
	static
	{
		Values.abilityWebAppExtraParams.put("elthor", new String[] {"desc", "Focuses the user's electricity to strike the opponent with lightning from above."});
		Values.abilityWebAppExtraParams.put("voltvari", new String[] {"desc", "Creates a concentrated ball of lightning, which varies in power."});
		Values.abilityWebAppExtraParams.put("raigo", new String[] {"desc", "Creates a huge cloud filled with electricity, which causes massive damage."});
		Values.abilityWebAppExtraParams.put("kari", new String[] {"desc", "Creates an electrical current around the user, which then explodes."});
		Values.abilityWebAppExtraParams.put("sango", new String[] {"desc", "Launches a huge concentrated chunk of electricity at the opponent."});
	}

	public static Ability[] abilitiesArray = new Ability[] {new ElThor(), new VoltVari(), new Raigo(), new Kari(), new Sango(), new SparkStep()};
	
	public static class ElThor extends Ability
	{
		public ElThor() 
		{
			super(ListAttributes.EL_THOR); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			if(hasTomoeDrumsEquipped(player))
			{
				this.attr.setAbilityDisplayName("Mamaragan");
				this.attr.setAbilityCooldown(20);			
			}
			
			super.startCharging(player);				
		}
		
		@Override
		public void duringCharging(EntityPlayer player, int currentCharge)
		{
			MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	
			
			if(mop != null)
			{
				double i = mop.blockX;
				double j = mop.blockY;
				double k = mop.blockZ;

				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_ELTHOR, i, j, k), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			}
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{						
			MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	

			if(mop != null)
			{
				double i = mop.blockX;
				double j = mop.blockY;
				double k = mop.blockZ;

				if(hasTomoeDrumsEquipped(player))
				{
					for(int t = 0; t < 5; t++)
					{
						i += WyMathHelper.randomWithRange(-15, 15);
						k += WyMathHelper.randomWithRange(-15, 15);

						WyNetworkHelper.sendTo(new PacketPlayer("ElThorThunder", i, j, k), (EntityPlayerMP) player);
						AbilityExplosion exp = WyHelper.newExplosion(player, i, j, k, 10);
						exp.setFireAfterExplosion(true);
						exp.doExplosion();
					}
				}
				else
				{
					WyNetworkHelper.sendTo(new PacketPlayer("ElThorThunder", i, j, k), (EntityPlayerMP) player);
					AbilityExplosion exp = WyHelper.newExplosion(player, i, j, k, 10);
					exp.setFireAfterExplosion(true);
					exp.doExplosion();
				}
			}
			
			super.endCharging(player);
					
			this.attr.setAbilityDisplayName("El Thor");
			this.attr.setAbilityCooldown(8);
		}
	}
	
	public static class VoltVari extends Ability
	{
		private int power = 0;
		
		public VoltVari() 
		{
			super(ListAttributes.VOLT_VARI); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				isCharging = true;
				this.startExtUpdate(player);
			}
		}
		
		@Override
		public void duringCharging(EntityPlayer player, int currentCharge)
		{		
			power = currentCharge;
			double truePower = Math.abs(power - this.attr.getAbilityCharges());

			if(truePower % 25 == 0 && MainConfig.enableAnimeScreaming)
			{
				int voltVariType = (int) Math.floor(truePower / 25);
				switch(voltVariType)
				{
					case 1:
						this.attr.setAbilityDisplayName("1 Million Volt Vari");
						break;
					case 2:
						this.attr.setAbilityDisplayName("5 Million Volt Vari");
						break;
					case 3:
						this.attr.setAbilityDisplayName("10 Million Volt Vari");
						break;
					case 4:
						this.attr.setAbilityDisplayName("20 Million Volt Vari");
						break;
					case 5:
						this.attr.setAbilityDisplayName("50 Million Volt Vari");
						break;
					case 6:
						this.attr.setAbilityDisplayName("60 Million Volt Vari");
						break;
					case 7:
						this.attr.setAbilityDisplayName("100 Million Volt Vari");
						break;
				}
				
				if(voltVariType < 8)
					this.sendShounenScream(player);
			}
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{
			double truePower = Math.abs(power - this.attr.getAbilityCharges());
			double trueCooldown = (truePower / 20) * 3;

			if(truePower > 0 && truePower <= 50)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 0 && truePower <= 25)
						this.attr.setAbilityDisplayName("1 Million Volt Vari");
					else
						this.attr.setAbilityDisplayName("5 Million Volt Vari");
				}
				this.projectile = new VoltVari5Million(player.worldObj, player, ListExtraAttributes.VOLT_VARI_5_MILLION);
			}
			else if(truePower > 50 && truePower <= 100)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 50 && truePower <= 75)
						this.attr.setAbilityDisplayName("10 Million Volt Vari");
					else
						this.attr.setAbilityDisplayName("20 Million Volt Vari");
				}
				this.projectile = new VoltVari20Million(player.worldObj, player, ListExtraAttributes.VOLT_VARI_20_MILLION);
			}
			else if(truePower > 100 && truePower <= 150)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 100 && truePower <= 125)
						this.attr.setAbilityDisplayName("50 Million Volt Vari");
					else
						this.attr.setAbilityDisplayName("60 Million Volt Vari");
				}
				this.projectile = new VoltVari60Million(player.worldObj, player, ListExtraAttributes.VOLT_VARI_60_MILLION);
			}
			else if(truePower > 150 && truePower <= 200)
			{
				if(MainConfig.enableAnimeScreaming)
				{
					if(truePower > 150 && truePower <= 175)
						this.attr.setAbilityDisplayName("100 Million Volt Vari");
					else
						this.attr.setAbilityDisplayName("Max 200 Million Volt Vari");
				}
				this.projectile = new VoltVari200Million(player.worldObj, player, ListExtraAttributes.VOLT_VARI_200_MILLION);
			}
			
			this.sendShounenScream(player);
				
			this.attr.setAbilityCooldown(trueCooldown);

			this.isCharging = false;
			this.isOnCooldown = true;	
			WyNetworkHelper.sendTo(new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP) player);

	    	if(!player.capabilities.isCreativeMode)
	    		WyTelemetry.addAbilityStat(this.getAttribute().getAbilityTexture(), this.getAttribute().getAttributeName(), 1);

			if(projectile != null)
				player.worldObj.spawnEntityInWorld(projectile);
			
			this.startExtUpdate(player);
		}
	}
	
	public static class Raigo extends Ability
	{
		public Raigo() 
		{
			super(ListAttributes.RAIGO); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{			
			if(!this.isOnCooldown)		
			{
				MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);	
				
				if(mop != null)
				{
					double x = mop.blockX;
					double y = mop.blockY;
					double z = mop.blockZ;
					
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_RAIGO, x, player.posY, z), player.dimension, x, y, z, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
					
					AbilityProjectile proj = new GoroProjectiles.Raigo(player.worldObj, player, ListAttributes.RAIGO);	
					proj.setLocationAndAngles(x, (y + 90), z, 0, 0);
					proj.motionX = 0;
					proj.motionZ = 0;
					proj.motionY = -1.4;
					player.worldObj.spawnEntityInWorld(proj);
				}
			}
			super.use(player);
		} 
	}
	
	public static class Kari extends Ability
	{
		public Kari() 
		{
			super(ListAttributes.KARI); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			if(!this.isOnCooldown)		
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KARI, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.startCharging(player);				
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{						
			super.endCharging(player);
		}
	}
	
	public static class Sango extends Ability
	{
		public Sango() 
		{
			super(ListAttributes.SANGO); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{
			this.projectile = new GoroProjectiles.Sango(player.worldObj, player, attr);
			super.use(player);
		} 
	}

	public static class SparkStep extends Ability
	{
		public SparkStep() {
			super(ListAttributes.SPARK_STEP);
		}
		@Override
		public void use(EntityPlayer player) {
			if (!this.isOnCooldown) {
				if(WyHelper.rayTraceBlocks(player) != null)
				{
					MovingObjectPosition blockTracer = WyHelper.rayTraceBlocks(player);
					int[] blockLocation = new int[]{blockTracer.blockX,blockTracer.blockY,blockTracer.blockZ};
					while (!(player.getEntityWorld().getBlock(blockLocation[0],(blockLocation[1]),blockLocation[2]) == Blocks.air)) {
						blockLocation[1] += 1;
					}
					EnderTeleportEvent event = new EnderTeleportEvent(player, blockLocation[0], blockLocation[1], blockLocation[2], 0);
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_ELTHOR, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
					player.setPositionAndUpdate(event.targetX, event.targetY + 1, event.targetZ);
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_ELTHOR, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
					player.fallDistance = 0.0F;


				}
				super.use(player);
			}
		}
	}
	
	
	private static boolean hasTomoeDrumsEquipped(EntityPlayer player)
	{
		return player.getEquipmentInSlot(3) != null && player.getEquipmentInSlot(3).getItem() == ListMisc.TomoeDrums;
	}
}
