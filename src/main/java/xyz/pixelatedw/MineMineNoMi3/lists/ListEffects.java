package xyz.pixelatedw.MineMineNoMi3.lists;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainEnchantment;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;

public class ListEffects 
{
	public static Enchantment dialImpact, dialFlash, kairoseki;
	
	public static void init()
	{		
		dialImpact = new MainEnchantment(MainConfig.enchantmentDialImpactId, 1, EnumEnchantmentType.weapon, "Impact Dial");
		kairoseki  = new MainEnchantment(MainConfig.enchantmentKairosekiId, 1, EnumEnchantmentType.weapon, "Kairoseki");
		dialFlash = new MainEnchantment(MainConfig.enchantmentDialFlashId, 1, EnumEnchantmentType.weapon, "Breath Dial");

		WyRegistry.registerEnchantment(dialImpact, "Impact Dial");
		WyRegistry.registerEnchantment(kairoseki, "Kairoseki");
		WyRegistry.registerEnchantment(dialFlash, "Flash Dial");
	}
}