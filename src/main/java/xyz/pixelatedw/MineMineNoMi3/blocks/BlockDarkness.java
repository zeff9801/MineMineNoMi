package xyz.pixelatedw.MineMineNoMi3.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;


public class BlockDarkness extends Block
{	
	public BlockDarkness()
	{
		super(Material.iron);
	} 

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
    { 
    	if(entity instanceof EntityLivingBase)
    	{
	    	ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase) entity);	    	

	    	if(!props.getUsedFruit().equals("yamiyami") || !props.hasYamiPower())
	    		entity.setInWeb(); 
    	}
    	else 
    		entity.setInWeb();
    }
	
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
    {
    	if(entity instanceof EntityLivingBase)
    	{
	    	ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase) entity);	    	

	    	if(props.getUsedFruit().equals("yamiyami") || props.hasYamiPower())
	    	{
	    		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	    		super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
	    	}
    	}
    	else if(entity instanceof EntityFallingBlock)
    		entity.setDead();
	}
	
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	world.spawnParticle(EnumParticleTypes.TOWN_AURA.getParticleName(), x + rand.nextDouble(), y, z + rand.nextDouble(), 0, 4.0, 0);
	}
}
