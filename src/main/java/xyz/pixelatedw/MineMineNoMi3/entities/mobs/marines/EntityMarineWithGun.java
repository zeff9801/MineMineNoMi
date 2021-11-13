package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAISharpshooter;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityMarineWithGun extends MarineData
{
	
	public EntityMarineWithGun(World world) 
	{
		super(world, new String[] {"marinegun1", "marinegun2", "marinegun3", "marinegun4", "marinegun5"});
		this.tasks.removeTask(this.entityAIMeleeAttack);
		this.entityAIMeleeAttack = new EntityAIAttackOnCollide(this, 0.0D, false);
		this.tasks.addTask(0, this.entityAIMeleeAttack);
		this.tasks.addTask(0, new EntityAISharpshooter(this, 1.5f, 0));
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
                this.dropItem(ListMisc.MarineHelm, 1); break;
            case 1:
                this.dropItem(ListMisc.MarineChestplate, 1); break;
            case 2:
                this.dropItem(ListMisc.MarineLeggings, 1); break;
            case 3:
                this.dropItem(ListMisc.MarineBoots, 1); break;
        }
    }
}
