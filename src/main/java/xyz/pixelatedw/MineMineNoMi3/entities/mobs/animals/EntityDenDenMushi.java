package xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityDenDenMushi extends EntityAnimal
{

	public EntityDenDenMushi(World world)
	{
		super(world);
		this.setSize(0.3F, 0.3F);
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(2, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(3, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes()
	{

		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.12D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack heldItem = player.inventory.getCurrentItem();
		if (heldItem != null && heldItem.getItem() == Items.iron_ingot)
		{
			player.inventory.addItemStackToInventory(new ItemStack(ListMisc.DenDenMushi));
			heldItem.stackSize--;
			this.setDead();
			return true;
		}
		return false;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
	}

	@Override
	protected boolean canDespawn()
	{
		return true;
	}

	@Override
	public boolean getCanSpawnHere()
	{
		return true;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
