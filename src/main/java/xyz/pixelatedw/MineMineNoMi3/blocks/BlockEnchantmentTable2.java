package xyz.pixelatedw.MineMineNoMi3.blocks;

import javax.annotation.Nullable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.lists.ListCreativeTabs;

public class BlockEnchantmentTable2 extends Block 
{

    protected static final AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
	
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    
    public BlockEnchantmentTable2()
    {
    	super(Material.iron);
        this.setLightOpacity(0);
        //this.setCreativeTab(ListCreativeTabs.tabMisc); 
    }
      
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return AABB;} 
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1)
    {
		this.blockIcon = par1.registerIcon("mineminenomi:dialtable_side");
		this.topIcon = par1.registerIcon("mineminenomi:dialtable_top");
	}
	
    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.topIcon : par1 == 0 ? this.topIcon : this.blockIcon;
	}
	
	public boolean isOpaqueCube() {return false;}
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() { return 0; }
    public boolean renderAsNormalBlock() { return false; }
   
    public boolean onBlockActivated(World world,int x, int y, int z, EntityPlayer player, int w, float hitX, float hitY, float hitZ)
    { 
        if (world.isRemote)
            return true;
        else
        {
            player.openGui(MainMod.getMineMineNoMi(), 0, world, x, y, z);
            return true;
        }
    }
}
