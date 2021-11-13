package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class EntityMorgan extends MarineData
{ 
	
	private SpecialAttack currentAttack, previousAttack;
	
	public EntityMorgan(World world) 
	{
		super(world);
		this.tasks.addTask(0, new EntityAIMorganChop(this));
 	}
	
	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
	}
		
	public int getDorikiPower() { return this.worldObj.rand.nextInt(5) + 30; }
	public int getBellyInPockets() { return this.worldObj.rand.nextInt(20) + 100; }
	
	public void setCurrentAttackState(SpecialAttack state)
	{
		this.currentAttack = state;
	}
	
	public SpecialAttack getCurrentAttackState()
	{
		return this.currentAttack;
	}
	
	public void setPreviousAttackState(SpecialAttack state)
	{
		this.previousAttack = state;
	} 
	
	public SpecialAttack getPreviousAttackState()
	{
		return this.previousAttack;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity ent)
    {
		int i = 2;
		
        return ent.attackEntityFrom(DamageSource.causeMobDamage(this), i);
    }
	
	enum SpecialAttack
	{
		WAIT,
		CHOP,
		FISSURE;
	}
	
	class EntityAIMorganChop extends EntityAIBase
	{
		private EntityMorgan theEntity;	
		private boolean canUseAttack = true;
		private final int ATTACK_MAX_TIMER = 50;
		private int attackTimer = ATTACK_MAX_TIMER, whileAttackTimer;
		private double[] posToCharge;
		
		public EntityAIMorganChop(EntityMorgan e) 
		{
			this.theEntity = e;
		}
		
		@Override
		public boolean shouldExecute() 
		{
			if(theEntity.getAttackTarget() != null && this.theEntity.getCurrentAttackState() == null && theEntity.getDistanceToEntity(theEntity.getAttackTarget()) < 6)
			{
				if(!canUseAttack)
				{
					if(attackTimer > 0)
					{
						attackTimer--;
						return false;
					}
					else return prevAttackCalc();
				}
				else return prevAttackCalc();
			}
			else return false;
		}
		
		public boolean prevAttackCalc()
		{
			if(this.theEntity.getPreviousAttackState() == SpecialAttack.CHOP)
			{
				if(theEntity.rand.nextFloat() <= 0.5f) return true;
				else return false;
			}
			return true;
		}
		
	    @Override
		public boolean continueExecuting()
	    {
	    	boolean flag = canUseAttack;
	    	
	    	if(!flag)
	    	{
	    		this.theEntity.setPreviousAttackState(this.theEntity.getCurrentAttackState());
	    		this.theEntity.setCurrentAttackState(null);
	    		//theEntity.setState(0);
	    	}
	    	
	    	return flag; //(theEntity.getAttackTarget() != null && theEntity.getDistanceSqToEntity(this.theEntity.getAttackTarget()) < 400) ||
	    }
		
		@Override
		public void startExecuting()
		{
			canUseAttack = true;
			attackTimer = ATTACK_MAX_TIMER;
			whileAttackTimer = 0;
			this.theEntity.setCurrentAttackState(SpecialAttack.CHOP);
			//theEntity.setState(1);
		}
			
        @Override
		public void updateTask()
        { 
        	if(theEntity.getAttackTarget() != null && canUseAttack)
        	{
        		whileAttackTimer++;
        		System.out.println("chop - " + whileAttackTimer);

        		for(Entity t : WyHelper.getEntitiesNear(this.theEntity, 1.8))
        		{
        			t.attackEntityFrom(DamageSource.causeMobDamage(this.theEntity), 10);
        			System.out.println("CHOP ATTACK");
        		}
        		
	            if(whileAttackTimer > 12)
	            	canUseAttack = false;
        	}
		}
	}
}
