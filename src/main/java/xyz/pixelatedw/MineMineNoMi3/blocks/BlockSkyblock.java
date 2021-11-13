package xyz.pixelatedw.MineMineNoMi3.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class BlockSkyblock extends Block
{

	public BlockSkyblock()
	{
		super(Material.ground);
		this.setLightOpacity(0);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(1);
	}

    @Override
	public int damageDropped(int meta)
    {
        return meta;
    }
	    
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		if(metadata == 1)
			return null;
		
		Item[] dials = new Item[]
			{
					ListMisc.DialAxe, ListMisc.DialBreath, ListMisc.DialEisen, ListMisc.DialFire, ListMisc.DialFlash, ListMisc.DialImpact, ListMisc.DialMilky
			};
		if (rand.nextDouble() < 0.25)
			return dials[rand.nextInt(dials.length)];
		else
			return Item.getItemFromBlock(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
}
