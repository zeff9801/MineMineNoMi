package xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityBandit extends BanditData
{ 

	public EntityBandit(World world) 
	{
		super(world, new String[] {"bandit1", "bandit2", "bandit3"});
 	}
	
	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		
		this.setDoriki(10 + this.worldObj.rand.nextInt(3));
		this.setBelly(5 + this.worldObj.rand.nextInt(10));
	}
	
    @Override
	protected void addRandomArmor()
    {
    	Item[] randomSword = new Item[] {ListMisc.PirateCutlass, ListMisc.Knife3};
        this.setCurrentItemOrArmor(0, new ItemStack(randomSword[this.rand.nextInt(randomSword.length)]));
    }
    
	@Override
	public double[] itemOffset() 
	{
		return new double[] {0, 0, -0.1};
	}
	
	public int getDorikiPower() { return this.worldObj.rand.nextInt(3) + 10; }
	public int getBellyInPockets() { return this.worldObj.rand.nextInt(10) + 1; }
	
	@Override
	protected void dropRareDrop(int i)
	{
		this.dropItem(ListMisc.BellyPouch, 1);
	}
}
