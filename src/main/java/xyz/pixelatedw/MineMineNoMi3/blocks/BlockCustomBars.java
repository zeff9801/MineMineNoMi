package xyz.pixelatedw.MineMineNoMi3.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import xyz.pixelatedw.MineMineNoMi3.ID;

public class BlockCustomBars extends BlockPane
{

	private final String topIcon;
	private final boolean field_150099_b;
	private final String mainIcon;
	@SideOnly(Side.CLIENT)
	private IIcon field_150102_N;
	private static final String __OBFID = "CL_00000322";

	public BlockCustomBars(String mainIcon, String topIcon)
	{
		super(topIcon, topIcon, Material.iron, true);
		this.field_150099_b = true;
		this.topIcon = topIcon;
		this.mainIcon = mainIcon;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return null;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return this.blockMaterial == Material.glass ? 41 : 18;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int w)
	{
		return blockAccess.getBlock(x, y, z) == this ? false : super.shouldSideBeRendered(blockAccess, x, y, z, w);
	}
	
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity)
	{
		boolean flag = this.canPaneConnectTo(world, x, y, z - 1, NORTH);
		boolean flag1 = this.canPaneConnectTo(world, x, y, z + 1, SOUTH);
		boolean flag2 = this.canPaneConnectTo(world, x - 1, y, z, WEST);
		boolean flag3 = this.canPaneConnectTo(world, x + 1, y, z, EAST);

		if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
		{
			if (flag2 && !flag3)
			{
				this.setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
				super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			}
			else if (!flag2 && flag3)
			{
				this.setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
				super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			}
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}

		if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
		{
			if (flag && !flag1)
			{
				this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
				super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			}
			else if (!flag && flag1)
			{
				this.setBlockBounds(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			}
		}
		else
		{
			this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}
	}
	
	public void setBlockBoundsForItemRender()
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
	{
		float f = 0.4375F;
		float f1 = 0.5625F;
		float f2 = 0.4375F;
		float f3 = 0.5625F;
		boolean flag = this.canPaneConnectTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1, NORTH);
		boolean flag1 = this.canPaneConnectTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1, SOUTH);
		boolean flag2 = this.canPaneConnectTo(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_, WEST);
		boolean flag3 = this.canPaneConnectTo(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_, EAST);

		if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
		{
			if (flag2 && !flag3)
			{
				f = 0.0F;
			}
			else if (!flag2 && flag3)
			{
				f1 = 1.0F;
			}
		}
		else
		{
			f = 0.0F;
			f1 = 1.0F;
		}

		if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
		{
			if (flag && !flag1)
			{
				f2 = 0.0F;
			}
			else if (!flag && flag1)
			{
				f3 = 1.0F;
			}
		}
		else
		{
			f2 = 0.0F;
			f3 = 1.0F;
		}

		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
	}

	@SideOnly(Side.CLIENT)
	public IIcon func_150097_e()
	{
		return this.field_150102_N;
	}

	protected boolean canSilkHarvest()
	{
		return false;
	}

	protected ItemStack createStackedBlock(int p_149644_1_)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, p_149644_1_);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(ID.PROJECT_ID + ":" + this.mainIcon);
		this.field_150102_N = iconRegister.registerIcon(ID.PROJECT_ID + ":" + this.topIcon);
	}

	public boolean canPaneConnectTo(IBlockAccess world, int x, int y, int z, ForgeDirection dir)
	{
		return canPaneConnectToBlock(world.getBlock(x, y, z)) || world.isSideSolid(x, y, z, dir.getOpposite(), false);
	}
}
