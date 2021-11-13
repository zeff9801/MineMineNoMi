package xyz.pixelatedw.MineMineNoMi3.abilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BakuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.JuryoProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class BakuAbilities
{

	public static Ability[] abilitiesArray = new Ability[] {new BakuMunch(), new BeroCannon(), new BakuTsuiho()};

	private static Block[] bakuPermittedBlocks = new Block[] 
			{ 
					Blocks.grass, Blocks.dirt, Blocks.leaves, Blocks.leaves2, Blocks.planks, Blocks.log, Blocks.log2, Blocks.stone, Blocks.cobblestone, Blocks.sand, Blocks.sandstone,
					Blocks.gravel, Blocks.packed_ice, Blocks.clay, Blocks.hardened_clay, Blocks.cactus, Blocks.deadbush
			};
	
	public static class BakuBakuFactory extends Ability
	{
		public BakuBakuFactory() 
		{
			super(ListAttributes.BAKU_BAKU_FACTORY); 
		}
		
		public void use(EntityPlayer player)
		{
			//Something something open a crafting GUI :)
			super.use(player);
		}
	}
	
	public static class BakuTsuiho extends Ability
	{
		private List<ItemStack> projectiles = new ArrayList<ItemStack>();
		private List<Block> loadedProjectiles = new ArrayList<Block>();
		
		public BakuTsuiho() 
		{
			super(ListAttributes.BAKU_TSUIHO); 
		}

		public void startCharging(EntityPlayer player)
		{			
			loadedProjectiles.clear();
			projectiles.clear();
			
			for(ItemStack item : player.inventory.mainInventory)
			{
				if(item != null && item.getItem() instanceof ItemBlock && Arrays.stream(bakuPermittedBlocks).anyMatch(p -> p == ((ItemBlock)item.getItem()).field_150939_a ))
					projectiles.add(item);
			}
			
			if(!projectiles.isEmpty())
			{
				super.startCharging(player);
			}
			else
				WyHelper.sendMsgToPlayer(player, "You don't have any blocks to use");
		}
		
		public void duringCharging(EntityPlayer player, int chargeTime)
		{
			if(!projectiles.isEmpty())
			{
				if(chargeTime % 20 == 0)
				{
					ItemStack s = projectiles.stream().findAny().orElse(null);
					
					if(s != null)
					{
						if(s.stackSize > 1)
							s.stackSize--;
						else
						{
							WyHelper.removeStackFromInventory(player, s);
							projectiles.remove(s);
						}
						loadedProjectiles.add( ((ItemBlock)s.getItem()).field_150939_a );
					}
				}
			}
			else
				endCharging(player);
		}
		
		public void endCharging(EntityPlayer player)
		{
			for(int j = 0; j < this.loadedProjectiles.size(); j++)
			{
				AbilityProjectile proj = new BakuProjectiles.BeroCannon(player.worldObj, player, ListAttributes.BERO_CANNON);
				int distanceBetweenProjectiles = this.loadedProjectiles.size() / 7;
				
				proj.setLocationAndAngles(
						player.posX + WyMathHelper.randomWithRange(-distanceBetweenProjectiles, distanceBetweenProjectiles) + player.worldObj.rand.nextDouble(), 
						(player.posY + 0.3) + WyMathHelper.randomWithRange(0, distanceBetweenProjectiles) + player.worldObj.rand.nextDouble(), 
						player.posZ + WyMathHelper.randomWithRange(-distanceBetweenProjectiles, distanceBetweenProjectiles) + player.worldObj.rand.nextDouble(), 
						0, 0);
				player.worldObj.spawnEntityInWorld(proj);
			}
			super.endCharging(player);
		}
	}
	
	public static class BeroCannon extends Ability
	{
		public BeroCannon() 
		{
			super(ListAttributes.BERO_CANNON); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				List<ItemStack> projectiles = new ArrayList<ItemStack>();

				for(ItemStack item : player.inventory.mainInventory)
				{
					if(item != null && item.getItem() instanceof ItemBlock && Arrays.stream(bakuPermittedBlocks).anyMatch(p -> p == ((ItemBlock)item.getItem()).field_150939_a ))
						projectiles.add(item);
				}
				
				if(!projectiles.isEmpty())
				{
					this.projectile = new BakuProjectiles.BeroCannon(player.worldObj, player, attr);
					
					ItemStack s = projectiles.stream().findFirst().orElse(null);
					
					if(s.stackSize > 1)
						s.stackSize--;
					else
						WyHelper.removeStackFromInventory(player, s);
					
					super.use(player);
				}
				else
					WyHelper.sendMsgToPlayer(player, "You don't have any blocks to use");
			}
		}
	}
	
	public static class BakuMunch extends Ability
	{
		public BakuMunch() 
		{
			super(ListAttributes.BAKU_MUNCH); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				MovingObjectPosition mop = WyHelper.rayTraceBlocks(player);
				if(mop != null && player.getDistance(mop.blockX, mop.blockY, mop.blockZ) < 5)
				{
					if(MainConfig.enableGriefing)
					{
						int i = 0;
						for(int x = -2; x < 2; x++)
						for(int y = 0; y < 3; y++)
						for(int z = -2; z < 2; z++)
						{
							int posX = (int)mop.blockX + x;
							int posY = (int)mop.blockY - y;
							int posZ = (int)mop.blockZ + z;
							
							Block tempBlock = player.worldObj.getBlock(posX, posY, posZ);
							if(DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, Blocks.air, "all", "restricted", "ignore liquids"))
							{
								player.inventory.addItemStackToInventory(new ItemStack(tempBlock));
								WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_BAKUMUNCH, posX, posY, posZ), player.dimension, posX, posY, posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
							}
						}
						super.use(player);
					}
				}
			}
		}
	}	
}
