package xyz.pixelatedw.MineMineNoMi3.items.weapons;

import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class ClimaTact extends Item
{

	private double damage = 1;

	public ClimaTact()
	{
		this.setFull3D();
	}
	
	public void emptyCharge(ItemStack itemStack)
	{
		if(!itemStack.hasTagCompound())
			itemStack.setTagCompound(new NBTTagCompound());
		
		itemStack.getTagCompound().setString("firstSlot", "");
		itemStack.getTagCompound().setString("secondSlot", "");
		itemStack.getTagCompound().setString("thirdSlot", "");
	}
	
	public String checkCharge(ItemStack itemStack)
	{
		if(!itemStack.hasTagCompound())
			itemStack.setTagCompound(new NBTTagCompound());
		
		StringBuilder sb = new StringBuilder();
		
		if(!WyHelper.isNullOrEmpty(itemStack.getTagCompound().getString("firstSlot")))
			sb.append(itemStack.getTagCompound().getString("firstSlot"));
		
		if(!WyHelper.isNullOrEmpty(itemStack.getTagCompound().getString("secondSlot")))
			sb.append(itemStack.getTagCompound().getString("secondSlot"));
		
		if(!WyHelper.isNullOrEmpty(itemStack.getTagCompound().getString("thirdSlot")))
			sb.append(itemStack.getTagCompound().getString("thirdSlot"));

		return sb.toString();
	}
	
	public void chargeWeatherBall(ItemStack itemStack, String ball)
	{
		if(!itemStack.hasTagCompound())
			itemStack.setTagCompound(new NBTTagCompound());
		
		if(WyHelper.isNullOrEmpty(itemStack.getTagCompound().getString("firstSlot")))
			itemStack.getTagCompound().setString("firstSlot", ball);
		
		else if(WyHelper.isNullOrEmpty(itemStack.getTagCompound().getString("secondSlot")))
			itemStack.getTagCompound().setString("secondSlot", ball);
		
		else if(WyHelper.isNullOrEmpty(itemStack.getTagCompound().getString("thirdSlot")))
			itemStack.getTagCompound().setString("thirdSlot", ball);	
	}
	
	public ClimaTact setDamage(double damage)
	{
		this.damage = damage;
		return this;
	}

	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		Multimap multimap = super.getAttributeModifiers(stack);
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.damage, 0));
		return multimap;
	}
}
