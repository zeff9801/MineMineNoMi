package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectChiyuHormone;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectTensionHormone;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class HoruAbilities
{
	public static Ability[] abilitiesArray = new Ability[] {new OnnaHormone(), new ChiyuHormone(), new TensionHormone()};
	
	public static class TensionHormone extends Ability
	{
		public TensionHormone()
		{
			super(ListAttributes.TENSION_HORMONE);
		}
		
		public void passive(EntityPlayer player)
		{
			if(player.isSneaking() && !this.isPassiveActive())
			{
				new DFEffectTensionHormone(player, 600);
	            this.startCooldown();
	            this.startExtUpdate(player);
			}
			else
				super.passive(player);
		}
		
		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			super.hitEntity(player, target);
			
			new DFEffectTensionHormone(target, 600);
		}
	}
	
	public static class ChiyuHormone extends Ability
	{
		public ChiyuHormone()
		{
			super(ListAttributes.CHIYU_HORMONE);
		}
		
		public void passive(EntityPlayer player)
		{
			if(player.isSneaking() && !this.isPassiveActive())
			{
				new DFEffectChiyuHormone(player, 100);
	            this.startCooldown();
	            this.startExtUpdate(player);
			}
			else
				super.passive(player);
		}
		
		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			super.hitEntity(player, target);
			
			new DFEffectChiyuHormone(target, 100);
		}
	}
	
	public static class OnnaHormone extends Ability
	{
		public OnnaHormone() 
		{
			super(ListAttributes.ONNA_HORMONE); 
		}
		
		public void hitEntity(EntityPlayer player, EntityLivingBase target)
		{
			super.hitEntity(player, target);
			
			target.addPotionEffect(new PotionEffect(Potion.confusion.id, 600, 1));
			target.addPotionEffect(new PotionEffect(Potion.weakness.id, 600, 1));
			target.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 0));
		}
	}
}
