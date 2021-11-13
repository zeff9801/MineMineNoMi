package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.YukiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class YukiAbilities 
{

	static
	{
		Values.abilityWebAppExtraParams.put("fubuki", new String[] {"desc", "The user releases an extremely cold stream of snow that spreads into the air around them."});
		Values.abilityWebAppExtraParams.put("kamakura", new String[] {"desc", "Creates an igloo-like snow barrier around the user."});
		Values.abilityWebAppExtraParams.put("kamakurajussoshi", new String[] {"desc", "Like 'Kamakura', but creates a multi-layered snow barrier."});		
		Values.abilityWebAppExtraParams.put("yukirabi", new String[] {"desc", "Launches numerous hardened snowballs, that have the shape of a rabbit's head."});
		Values.abilityWebAppExtraParams.put("tabirayuki", new String[] {"desc", "The user creates a sword made of solid hardened snow."});
		Values.abilityWebAppExtraParams.put("yukigaki", new String[] {"desc", "The user creates a huge wall of snow."});
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new Kamakura(), new TabiraYuki(), new YukiRabi(), new KamakuraJussoshi(), new Fubuki(), new YukiGaki()};		

	public static class YukiGaki extends Ability
	{
		public YukiGaki() 
		{
			super(ListAttributes.YUKI_GAKI); 
		}
		
		public void use(EntityPlayer player)
		{		
			if(!isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					if(WyHelper.get4Directions(player) == WyHelper.Direction.NORTH)
					{
						for(int x = -3; x <  3; x++)
						for(int y = 0; y <= 3; y++)
						for(int z = -1; z <= 1; z++)
							player.worldObj.setBlock((int) player.posX - x, (int) player.posY + y, ((int) player.posZ - 3) - z, Blocks.snow);
					}
					if(WyHelper.get4Directions(player) == WyHelper.Direction.SOUTH)
					{
						for(int x = -3; x <  3; x++)
						for(int y = 0; y <= 3; y++)
						for(int z = -1; z <= 1; z++)
							player.worldObj.setBlock((int) player.posX - x, (int) player.posY + y, ((int) player.posZ + 2) - z, Blocks.snow);
					}
					if(WyHelper.get4Directions(player) == WyHelper.Direction.EAST)
					{
						for(int x = -1; x < 1; x++)
						for(int y = 0; y <= 3; y++)
						for(int z = -3; z <= 3; z++)
							player.worldObj.setBlock(((int) player.posX + 2) - x, (int) player.posY + y, (int) player.posZ - z, Blocks.snow);
					}
					if(WyHelper.get4Directions(player) == WyHelper.Direction.WEST)
					{
						for(int x = -1; x < 1; x++)
						for(int y = 0; y <= 3; y++)
						for(int z = -3; z <= 3; z++)
							player.worldObj.setBlock(((int) player.posX - 3) - x, (int) player.posY + y, (int) player.posZ - z, Blocks.snow);
					}
				}
					
				super.use(player);
			}
		}
	}
	
	public static class TabiraYuki extends Ability
	{
		public TabiraYuki()
		{
			super(ListAttributes.TABIRA_YUKI); 
		}
		
		public void startPassive(EntityPlayer player) 
		{
			if(player.inventory.getCurrentItem() == null)
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ListMisc.TabiraYuki));
			else
			{
				WyHelper.sendMsgToPlayer(player, "Cannot equip " + this.getAttribute().getAttributeName() + " while holding another item in hand !");
				this.passive(player);
			}
		}
		
		public void endPassive(EntityPlayer player) 
		{
			player.inventory.clearInventory(ListMisc.TabiraYuki, -1);
		}
	}
	
	public static class Fubuki extends Ability
	{
		public Fubuki() 
		{
			super(ListAttributes.FUBUKI); 
		}
		
		public void use(final EntityPlayer player)
		{				
			if(!isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					Sphere.generate((int) player.posX, (int) player.posY, (int) player.posZ, 25, new ISphere()
				    { 
						public void call(int x, int y, int z)
						{
			    			for(int i = -4; i <= 4; i++)
					    		if(player.worldObj.isAirBlock(x, y, z) && player.worldObj.getBlock(x, y - 1, z) != Blocks.air && player.worldObj.getBlock(x, y - 1, z) != Blocks.snow_layer)
					    			player.worldObj.setBlock(x, y, z, Blocks.snow_layer);
						}
				    });
				}
				
				for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 25))
				{
					e.attackEntityFrom(DamageSource.causePlayerDamage(player), 8);
					e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));
				}
				
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_FUBUKI, player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
				super.use(player);
			}
		}
	}
	
	public static class KamakuraJussoshi extends Ability
	{
		public KamakuraJussoshi() 
		{
			super(ListAttributes.KAMAKURA_JUSSOSHI); 
		}
		
		public void use(EntityPlayer player)
		{	
			if(!isOnCooldown)
			{			
				if(MainConfig.enableGriefing)
				{
					MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);				
					World world = player.worldObj;
					
					if(player.isSneaking())
					{		
						WyHelper.createEmptySphere(world, (int)player.posX, (int)player.posY, (int)player.posZ, 4, Blocks.snow, "air", "foliage", "liquids");
						WyHelper.createEmptySphere(world, (int)player.posX, (int)player.posY, (int)player.posZ, 6, Blocks.snow, "air", "foliage", "liquids");
						WyHelper.createEmptySphere(world, (int)player.posX, (int)player.posY, (int)player.posZ, 8, Blocks.snow, "air", "foliage", "liquids");
					}
					else
					{
						if(mop != null && world.getBlock(mop.blockX, mop.blockY, mop.blockZ) != Blocks.air)
						{
							WyHelper.createEmptySphere(world, mop.blockX, mop.blockY, mop.blockZ, 4, Blocks.snow, "air", "foliage", "liquids");
							WyHelper.createEmptySphere(world, mop.blockX, mop.blockY, mop.blockZ, 6, Blocks.snow, "air", "foliage", "liquids");
							WyHelper.createEmptySphere(world, mop.blockX, mop.blockY, mop.blockZ, 8, Blocks.snow, "air", "foliage", "liquids");
						}
					}
				}
				
				super.use(player);
			}
		}
	}
	
	public static class YukiRabi extends Ability
	{
		public YukiRabi() 
		{
			super(ListAttributes.YUKI_RABI); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new YukiProjectiles.YukiRabi(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class Kamakura extends Ability
	{
		public Kamakura() 
		{
			super(ListAttributes.KAMAKURA); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!isOnCooldown)
			{
				if(MainConfig.enableGriefing)
				{
					MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);				
					World world = player.worldObj;
					
					if(player.isSneaking())
					{		
						WyHelper.createEmptySphere(world, (int)player.posX, (int)player.posY, (int)player.posZ, 4, Blocks.snow, "air", "foliage", "liquids");
					}
					else
					{
						if(mop != null && world.getBlock(mop.blockX, mop.blockY, mop.blockZ) != Blocks.air)
						{
							WyHelper.createEmptySphere(world, mop.blockX, mop.blockY, mop.blockZ, 4, Blocks.snow, "air", "foliage", "liquids");
						}
					}
				}

				super.use(player);
			}
		} 
	}
	
}
