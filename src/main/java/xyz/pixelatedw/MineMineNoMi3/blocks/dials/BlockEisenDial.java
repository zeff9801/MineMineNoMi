package xyz.pixelatedw.MineMineNoMi3.blocks.dials;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityEisenDial;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class BlockEisenDial extends BlockContainer
{

	public BlockEisenDial()
	{
		super(Material.iron);
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.425F, 0.75F);
	}  

	public boolean isOpaqueCube() {return false;}

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() { return 1; }

    public boolean renderAsNormalBlock() { return false; }
	
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
    	return true;
    }

    public Item getItemDropped(int i1, Random rand, int fortune)
    {
        return ListMisc.DialEisen;
    }
    
    public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
        return true;
    }

	public int getRenderType() { return -1; }
	    
	public TileEntity createNewTileEntity(World wolrd, int i)
	{
		return new TileEntityEisenDial();
	}
    
}
