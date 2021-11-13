package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SunaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class SunaAbilities 
{
	static
	{
		Values.abilityWebAppExtraParams.put("barjan", new String[] {"desc", "Launches a crescent-shaped wave of sand at the opponent, that dehydrates them."});
		Values.abilityWebAppExtraParams.put("grounddeath", new String[] {"desc", "Dries out the surroundings and suffucates all nearby opponents in sand."});
		Values.abilityWebAppExtraParams.put("sables", new String[] {"desc", "The user launches a compressed sandstorm at the opponent, which sends them flying."});		
		Values.abilityWebAppExtraParams.put("desertspada", new String[] {"desc", "The user extends their sand along the ground, splitting it and suffocating everything it its path. "});		
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Barjan(), new Sables(), new GroundDeath(), new DesertSpada(), new DesertEncierro(), new DesertGirasole()};

	public static class DesertGirasole extends Ability
	{
		public DesertGirasole() 
		{
			super(ListAttributes.DESERT_GIRASOLE); 
		}
		
		@Override
		public void startCharging(EntityPlayer player)
		{
			if(!this.isOnCooldown)
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_DESERTGIRASOLE, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.startCharging(player);
		}
		
		@Override
		public void endCharging(EntityPlayer player)
		{		
			if(!this.isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					for(int i = -15; i < 15; i++)
					for(int j = -5; j < 5; j++)
					for(int k = -15; k < 15; k++)
					{
						int posX = (int) (player.posX + i + (i < -WyMathHelper.randomWithRange(8, 12) || i > WyMathHelper.randomWithRange(8, 12) ? WyMathHelper.randomWithRange(-5, 5) : 0));
						int posY = (int) player.posY + j;
						int posZ = (int) (player.posZ + k + (k < -WyMathHelper.randomWithRange(8, 12) || k > WyMathHelper.randomWithRange(8, 12) ? WyMathHelper.randomWithRange(-5, 5) : 0));
						
						DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, 2, "core");			
					}
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_DESERTGIRASOLE2, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
				}

				super.endCharging(player);
			}	
		}
	}
	
	public static class DesertEncierro extends Ability
	{
		public DesertEncierro() 
		{
			super(ListAttributes.DESERT_ENCIERRO); 
		}
		
		@Override
		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_DESERTENCIERRO, target), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.hitEntity(player, target);
		}
	}
	
	public static class Barjan extends Ability
	{
		public Barjan() 
		{
			super(ListAttributes.BARJAN); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{		
			this.projectile = new SunaProjectiles.Barjan(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class Sables extends Ability
	{
		public Sables() 
		{
			super(ListAttributes.SABLES); 
		}	
		
		@Override
		public void hitEntity(EntityPlayer player, EntityLivingBase target) 
		{	
			double newPosX = 0, newPosY = 0, newPosZ = 0;
			
			newPosY += 25;
			target.addPotionEffect(new PotionEffect(Potion.hunger.id, 500, 1));
			Direction dir = WyHelper.get4Directions(player);
			if(dir == WyHelper.Direction.SOUTH)
				newPosX += WyMathHelper.randomWithRange(-10, 10);
			else if(dir == WyHelper.Direction.EAST)
				newPosX -= WyMathHelper.randomWithRange(-10, 10);
			else if(dir == WyHelper.Direction.NORTH)
				newPosZ += WyMathHelper.randomWithRange(-10, 10);
			else if(dir == WyHelper.Direction.WEST)  
				newPosZ -= WyMathHelper.randomWithRange(-10, 10);

			WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_SABLES, target), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			target.setPositionAndUpdate(target.posX + newPosX, target.posY + newPosY, target.posZ + newPosZ);
			
			super.hitEntity(player, target);
		}
	}
	
	public static class GroundDeath extends Ability
	{
		public GroundDeath() 
		{
			super(ListAttributes.GROUND_DEATH); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{	
			if(!this.isOnCooldown())
			{
				if(MainConfig.enableGriefing)
				{
					for(EntityLivingBase entityLivingBase : WyHelper.getEntitiesNear(player, 25))
					{
						WyHelper.createFilledCube(entityLivingBase, new int[] {2, 2, 2}, Blocks.sand, "air", "foliage");
					}	
					
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_GROUNDDEATH, player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);			
				}
				
				super.use(player);
			}
		}
	}
	
	public static class DesertSpada extends Ability
	{
		public DesertSpada() 
		{
			super(ListAttributes.DESERT_SPADA); 
		}
		
		@Override
		public void use(EntityPlayer player)
		{		
			if(!isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					if(WyHelper.get4Directions(player) == WyHelper.Direction.NORTH)
					{
						for(int i = -4; i < 6; i++)
						for(int j = 0; j < 5; j++)
						for(int k = 0; k < 30; k++)		
						{
							int posX = (int) player.posX + i;
							int posY = (int) player.posY - (j + 1);
							int posZ = (int) player.posZ - (k + 2);
							
							DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, "core");
						}
					}
					else if(WyHelper.get4Directions(player) == WyHelper.Direction.SOUTH)
					{
						for(int i = -4; i < 6; i++)
						for(int j = 0; j < 5; j++)
						for(int k = 0; k < 30; k++)		
						{
							int posX = (int) player.posX + i;
							int posY = (int) player.posY - (j + 1);
							int posZ = (int) player.posZ + (k + 2);
							
							DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, "core");
						}
					}
					else if(WyHelper.get4Directions(player) == WyHelper.Direction.EAST)
					{
						for(int i = 0; i < 30; i++)
						for(int j = 0; j < 5; j++)
						for(int k = -4; k < 6; k++)		
						{
							int posX = (int) player.posX + (i + 2);
							int posY = (int) player.posY - (j + 1);
							int posZ = (int) player.posZ + k;
							
							DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, "core");
						}
					}
					else if(WyHelper.get4Directions(player) == WyHelper.Direction.WEST)
					{
						for(int i = 0; i < 30; i++)
						for(int j = 0; j < 5; j++)
						for(int k = -4; k < 6; k++)
						{
							int posX = (int) player.posX - (i + 2);
							int posY = (int) player.posY - (j + 1);
							int posZ = (int) player.posZ + k;
							
							DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, "core");
						}	
					}
					
					WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_DESERTSPADA, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);			

				}
				super.use(player);
			}
		}
	}
	
}
