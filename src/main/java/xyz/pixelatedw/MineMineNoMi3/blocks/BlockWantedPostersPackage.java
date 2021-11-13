package xyz.pixelatedw.MineMineNoMi3.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;

public class BlockWantedPostersPackage extends BlockContainer
{

	public BlockWantedPostersPackage()
	{
		super(Material.iron);
		this.setHardness(1);
	}

    public void breakBlock(World world, int posX, int posY, int posZ, Block block, int i1)
    {
    	ItemsHelper.dropWantedPosters(world, posX, posY, posZ);
    }
    
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 0.5, z + 1);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 0.5, z + 1);
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderType()
	{
		return -1;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}
    
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityWantedPostersPackage();
	}

}
