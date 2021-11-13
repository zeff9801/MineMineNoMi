package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EntityAIOTasumaki extends EntityAICooldown
{
	private EntityNewMob entity;
	private double damage;
	
	public EntityAIOTasumaki(EntityNewMob entity)
	{
		super(entity, 80, entity.getRNG().nextInt(20));
		this.entity = entity;
		this.damage = this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
	}

	public boolean shouldExecute()
	{
		ItemStack itemStack = this.entity.getHeldItem();
		
		//if(this.entity.getPreviousAI() != null && this.entity.getPreviousAI() == this.entity.getCurrentAI())
		//	return false;
		
		if(itemStack == null || this.entity.getAttackTarget() == null)
			return false;

		if(this.entity.getDistanceToEntity(this.entity.getAttackTarget()) > 3 || this.entity.getDistanceToEntity(this.entity.getAttackTarget()) < 2)
			return false;
		
		if(this.isOnCooldown())
		{
			this.countDownCooldown();
			return false;
		}
		
		this.execute();
		return true;
	} 
	
	public void endCooldown()	
	{
		super.endCooldown();
		this.entity.setCurrentAI(null);
		this.entity.setPreviousAI(this);
	}

    public void execute()
    {
		for(EntityLivingBase e : WyHelper.getEntitiesNear(this.entity, 4))
		{
			e.attackEntityFrom(DamageSource.causeMobDamage(this.entity), (float) this.damage);				
			e.addPotionEffect(new PotionEffect(Potion.weakness.id, 10 * 20, 1, true));
		}	
		WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_KOKUTEICROSS, this.entity), this.entity.dimension, this.entity.posX, this.entity.posY, this.entity.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
		
		this.entity.setCurrentAI(this);
	    this.setOnCooldown(true);
    }
}
