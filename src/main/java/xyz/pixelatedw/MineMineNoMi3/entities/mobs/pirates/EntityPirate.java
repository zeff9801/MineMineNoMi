package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityPirate extends PirateData
{ 
	public EntityPirate(World world) 
	{
		super(world, new String[] {"pirate1", "pirate2", "pirate3", "pirate4", "pirate5"});
 	} 
	  
	@Override
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
	
		this.setDoriki(10 + this.worldObj.rand.nextInt(3));
		this.setBelly(5 + this.worldObj.rand.nextInt(10));
	}

    @Override
	protected void addRandomArmor()
    {
    	Item[] randomSword = new Item[] {ListMisc.PirateCutlass, Items.iron_sword};
        this.setCurrentItemOrArmor(0, new ItemStack(randomSword[this.rand.nextInt(randomSword.length)]));
    }
    
	@Override
	public double[] itemOffset() 
	{
		return new double[] {0, 0, -0.1};
	}
	
    @Override
	protected void dropRareDrop(int i)
    {
        switch (this.rand.nextInt(4))
        {
            case 0:
                this.dropItem(ListMisc.PirateChestplate, 1); break;
            case 1:
                this.dropItem(ListMisc.PirateLeggings, 1); break;
            case 2:
                this.dropItem(ListMisc.PirateBoots, 1); break;
        }
    }
}
