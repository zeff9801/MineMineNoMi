package xyz.pixelatedw.MineMineNoMi3.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCannon;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class BlockCannon extends BlockContainer
{

	public BlockCannon()
	{
		super(Material.iron);
		this.setHardness(1);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack)
	{
		int rotation = 0;
		switch(WyHelper.get4Directions(entity))
		{
			case NORTH:
				rotation = 0; break;
			case EAST:
				rotation = 1; break;
			case SOUTH:
				rotation = 2; break;
			case WEST:
				rotation = 3; break;
		}
		world.setBlock(posX, posY, posZ, ListMisc.Cannon, rotation, 2);
	}
	
	@Override
	public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntityCannon cannonTE = (TileEntityCannon) world.getTileEntity(posX, posY, posZ);

		if (player.getHeldItem() != null)
		{
			if (cannonTE.getGunpowederLoaded() < 5 && player.getHeldItem().getItem() == Items.gunpowder)
			{
				player.getHeldItem().stackSize--;
				cannonTE.addGunpoweder();
				return true;
			}

			if (!cannonTE.hasCannonBall() && player.getHeldItem().getItem() == ListMisc.CannonBall)
			{
				player.getHeldItem().stackSize--;
				cannonTE.setHasCannonBall(true);
				return true;
			}
		}

		if (cannonTE.getGunpowederLoaded() > 0 && cannonTE.hasCannonBall())
		{
			int motion = 5 + cannonTE.getGunpowederLoaded();
			int damage = 30 + (cannonTE.getGunpowederLoaded() * 2);
			int life = 100 + (cannonTE.getGunpowederLoaded() * 20);

			AbilityProjectile cannonBall = new ExtraProjectiles.CannonBall(world, player, ListExtraAttributes.CANNON_BALL.setProjectileDamage(damage).setProjectileTicks(life));
			cannonBall.setLocationAndAngles(posX + 0.5, posY + 1, posZ + 0.5, cannonTE.getBlockMetadata() * 90, 0);
			cannonBall.motionX = 0;
			cannonBall.motionZ = 0;
			switch (cannonTE.blockMetadata)
			{
				case 0:
					cannonBall.motionZ = -motion;
					break;
				case 1:
					cannonBall.motionX = motion;
					break;
				case 2:
					cannonBall.motionZ = motion;
					break;
				case 3:
					cannonBall.motionX = -motion;
					break;
			}
			cannonBall.motionY = 0;
			if(!world.isRemote)
				world.spawnEntityInWorld(cannonBall);

			for (int i = 0; i < 10; i++)
				world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleName(), posX + (WyMathHelper.randomDouble() / 5), posY + 0.6, posZ + (WyMathHelper.randomDouble() / 5), 0, 0.01, 0);
			
			cannonTE.emptyGunpoweder();
			cannonTE.setHasCannonBall(false);

			return true;
		}
		return true;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
    
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityCannon();
	}
}
