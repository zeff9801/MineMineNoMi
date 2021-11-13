package xyz.pixelatedw.MineMineNoMi3.world.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public abstract class Structure
{
	
	protected static void addChestLoot(World world, TileEntityChest te, double rarity, ItemStack loot)
	{
		if (getRandomChance(world) <= rarity)
			te.setInventorySlotContents((int) WyMathHelper.randomWithRange(0, 26), loot);
	}
	
	protected static void addChestLoot(World world, TileEntityChest te, double rarity, Item loot, int min, int max)
	{
		addChestLoot(world, te, rarity, loot, 0, min, max);
	}

	protected static void addChestLoot(World world, TileEntityChest te, double rarity, Item loot, int metadata, int min, int max)
	{
		if (getRandomChance(world) <= rarity)
		{
			int chance = max <= 0 ? min : (int) WyMathHelper.randomWithRange(min, max);
			if(chance > 0)
				te.setInventorySlotContents((int) WyMathHelper.randomWithRange(0, 26), new ItemStack(loot, chance, metadata));		
		}
	}
	
	protected static void addChestTileEntity(World world, int[][] positions, int maxChests, Consumer<TileEntityChest> lootList)
	{
		try
		{
			List<TileEntityChest> chests = new ArrayList<TileEntityChest>();
			
			for(int[] pos : positions)
			{
				TileEntityChest chest = new TileEntityChest();
				world.setTileEntity(pos[0], pos[1], pos[2], chest);
	
				chests.add(chest);
			}
	
			WyMathHelper.shuffle(chests);
			
			int index = 0;
			for(TileEntityChest chest : chests)
			{
				if(maxChests > 0 && index > maxChests)
					break;
				
				lootList.accept(chest);
				
				index++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected static void addSpawnerTileEntity(World world, int[][] positions, String mobName, int min, int max)
	{
		try
		{
			List<TileEntityCustomSpawner> spawners = new ArrayList<TileEntityCustomSpawner>();
			String mob = ID.PROJECT_ID + "." + mobName;
			
			for(int[] pos : positions)
			{
				int chance = max <= 0 ? min : (int) WyMathHelper.randomWithRange(min, max);		
				TileEntityCustomSpawner spawner = new TileEntityCustomSpawner().setSpawnerMob(mob).setSpawnerLimit(chance);
				world.setBlock(pos[0], pos[1], pos[2], ListMisc.CustomSpawner);
				world.setTileEntity(pos[0], pos[1], pos[2], spawner);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected static Enchantment getEnchantment()
	{
		Enchantment ench = null;
		switch((int)WyMathHelper.randomWithRange(0, 5))
		{
			case 0:
				ench = Enchantment.sharpness;
				break;
			case 1:
				ench = Enchantment.baneOfArthropods;
				break;
			case 2:
				ench = Enchantment.efficiency;
				break;
			case 3:
				ench = Enchantment.protection;
				break;
			case 4:
				ench = Enchantment.thorns;
				break;
			case 5:
				ench = Enchantment.unbreaking;
				break;
			default:
				ench = Enchantment.sharpness;
		}
		
		return ench;
	}
	
	protected static double getRandomChance(World world)
	{
		return world.rand.nextInt(100) + world.rand.nextDouble();
	}
}
