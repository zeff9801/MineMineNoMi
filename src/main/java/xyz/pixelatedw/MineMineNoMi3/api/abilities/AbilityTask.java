package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;

public class AbilityTask 
{

	public void onItemUse(ItemStack itemStack, EntityPlayer player) {}

	public void onItemCooldown(ItemStack itemStack, EntityPlayer player) {}
	
	public void onItemTick(ItemStack itemStack, EntityPlayer player) {}
	
	public void onItemWhileUsing(ItemStack itemStack, EntityPlayer player, int count) {}
	
	public void onProjectileUpdate(AbilityProjectile abilityProjectile) {}
	
	public void onItemAfterUse(ItemStack itemStack, EntityPlayer player, int timeLeft) {}
	
	public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {}
	
	public void onProjectileHit(AbilityProjectile abilityProjectile, MovingObjectPosition hit) {}

	
}
