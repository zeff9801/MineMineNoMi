package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAISharpshooter;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityPirateWithGun extends PirateData
{

	public EntityPirateWithGun(World world) 
	{
		super(world, new String[] {"pirategun1", "pirategun2", "pirategun3", "pirategun4", "pirategun5"});
		this.tasks.removeTask(entityAIMeleeAttack);
		entityAIMeleeAttack = new EntityAIAttackOnCollide(this, 0.0D, false);
		this.tasks.addTask(0, entityAIMeleeAttack);
		this.tasks.addTask(0, new EntityAISharpshooter(this, 1.7f, 0));
 	} 
	  
	@Override
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		
		this.setDoriki(10 + this.worldObj.rand.nextInt(3));
		this.setBelly(5 + this.worldObj.rand.nextInt(10));
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
