package xyz.pixelatedw.MineMineNoMi3.entities.mobs.baroqueWorks;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;

public class EntityMr0 extends PirateData
{

	public EntityMr0(World worldIn)
	{
		super(worldIn);
	}
	
	@Override
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(55.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
		
		ExtendedEntityData props = ExtendedEntityData.get(this);
		
		props.setUsedFruit("sunasuna");
		props.setIsLogia(true);
		
		this.setDoriki(500 + this.worldObj.rand.nextInt(50));
		this.setBelly(1000 + this.worldObj.rand.nextInt(100));
	}
}
