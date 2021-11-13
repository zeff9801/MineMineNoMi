package xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.givers;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.IQuestGiver;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIGapCloser;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIHakiCombat;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman.EntityAIOTasumaki;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman.EntityAIYakkodori;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;

public class EntityDojoSensei extends EntityNewMob implements IQuestGiver
{
	private ItemStack swordStack;

	public EntityDojoSensei(World worldIn)
	{
		super(worldIn, new String[] {"dojosensei1", "dojosensei2", "dojosensei3"});
		
		this.tasks.addTask(0, new EntityAIHakiCombat(this));
		this.tasks.addTask(1, new EntityAIYakkodori(this));
		this.tasks.addTask(1, new EntityAIOTasumaki(this));
		this.tasks.addTask(1, new EntityAIGapCloser(this));
		
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
		
		this.setDoriki(50 + this.worldObj.rand.nextInt(5));
		this.setBelly(10 + this.worldObj.rand.nextInt(50));

		if(!this.worldObj.isRemote)
		{
			Item[] randomSword = new Item[] {ListMisc.NidaiKitetsu, ListMisc.SandaiKitetsu, ListMisc.Shusui, ListMisc.Jitte, ListMisc.Kikoku, ListMisc.WadoIchimonji};

			this.setBusoHaki(true);

			Item sword = randomSword[this.rand.nextInt(randomSword.length)];			
			if(sword != null)
			{
				swordStack = new ItemStack(sword);
				swordStack.setTagCompound(new NBTTagCompound());
				swordStack.stackTagCompound.setInteger("metadata", 1);
			}
		}
	}
	
    @Override
	protected void addRandomArmor()
    {
    	if(swordStack != null)
    		this.setCurrentItemOrArmor(0, swordStack);
    }
    
    @Override
	protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {}
    
	@Override
	public double[] itemOffset() 
	{
		return new double[] {0, -0.05, -0.1};
	}

	@Override
	protected boolean canDespawn()
	{return true;}

	@Override
	public EnumQuestlines getQuestline()
	{
		return EnumQuestlines.SWORDSMAN_PROGRESSION;
	}
}
