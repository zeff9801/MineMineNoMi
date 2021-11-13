package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIGapCloser;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIHakiCombat;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIKnockback;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.brawler.EntityAIHakaiHo;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityFatPirate extends PirateData
{
	private ItemStack swordStack;

	public EntityFatPirate(World world) 
	{
		super(world, new String[] {"fatpirate1", "fatpirate2"});
		this.setSize(0.70F, 2.5F);
		this.tasks.addTask(0, new EntityAIHakiCombat(this));
		this.tasks.addTask(1, new EntityAIGapCloser(this).setSpeed(1.1).setMaxCounter(5));
		this.tasks.addTask(1, new EntityAIKnockback(this));
		this.tasks.addTask(1, new EntityAIHakaiHo(this));
 	}
	
	@Override
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
			
		this.setDoriki(15 + this.worldObj.rand.nextInt(15));
		this.setBelly(10 + this.worldObj.rand.nextInt(20));

		if(!this.worldObj.isRemote)
		{
			Item[] randomSword = new Item[] {ListMisc.MarineSword, null};
			if(this.rand.nextInt(100) <= 20)
			{
				this.setBusoHaki(true);

				Item sword = randomSword[this.rand.nextInt(randomSword.length)];			
				if(sword != null)
				{
					swordStack = new ItemStack(sword);
					swordStack.setTagCompound(new NBTTagCompound());
					swordStack.stackTagCompound.setInteger("metadata", 1);
				}
			}
			else
			{
				Item sword = randomSword[this.rand.nextInt(randomSword.length)];
				if(sword != null)
					swordStack = new ItemStack(sword);
			}
		}
	}

    @Override
	protected void addRandomArmor()
    {
    	if(this.rand.nextInt(10) <= 2)
    		this.setCurrentItemOrArmor(0, new ItemStack(ListMisc.Mace));
    }
    
	@Override
	public double[] itemOffset() 
	{
		return new double[] {-0.2, 0, -0.1};
	}
}
