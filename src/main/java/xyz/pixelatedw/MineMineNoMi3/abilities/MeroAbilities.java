package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectMeroPetrification;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class MeroAbilities
{
	static
	{
	}
	
	public static Ability[] abilitiesArray = new Ability[] {new MeroMeroMellow(), new PistolKiss(), new SlaveArrow(), new PerfumeFemur()};
	
	public static class PerfumeFemur extends Ability
	{
		public PerfumeFemur() 
		{
			super(ListAttributes.PERFUME_FEMUR); 
		}
		
		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			super.hitEntity(player, target);
			
			new DFEffectMeroPetrification(target, 400);
			
			AbilityExplosion explosion = WyHelper.newExplosion(player, target.posX, target.posY, target.posZ, 2);
			explosion.setExplosionSound(false);
			explosion.setDamageOwner(false);
			explosion.setDestroyBlocks(false);
			explosion.setSmokeParticles(ID.PARTICLEFX_PERFUMEFEMUR);
			explosion.doExplosion();
		}
	}
	
	public static class SlaveArrow extends Ability
	{
		public SlaveArrow() 
		{
			super(ListAttributes.SLAVE_ARROW); 
		}
		
		public void startCharging(EntityPlayer player)
		{
			if(!this.isOnCooldown)
				WyNetworkHelper.sendToAllAround(new PacketParticles(ID.PARTICLEFX_SLAVEARROW, player), player.dimension, player.posX, player.posY, player.posZ, ID.GENERIC_PARTICLES_RENDER_DISTANCE);
			super.startCharging(player);				
		}

		public void endCharging(EntityPlayer player)
		{						
			this.projectile = new MeroProjectiles.SlaveArrow(player.worldObj, player, attr);
			super.endCharging(player);
		}

	}
	
	public static class PistolKiss extends Ability
	{
		public PistolKiss()
		{
			super(ListAttributes.PISTOL_KISS);
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new MeroProjectiles.PistolKiss(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class MeroMeroMellow extends Ability
	{
		public MeroMeroMellow()
		{
			super(ListAttributes.MERO_MERO_MELLOW);
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new MeroProjectiles.MeroMeroMellow(player.worldObj, player, attr);
			super.use(player);
		}
	}
}
