package xyz.pixelatedw.MineMineNoMi3;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class MainEnchantment extends Enchantment
{
    public MainEnchantment(int id, int weight, EnumEnchantmentType type, String name)
    {
        super(id, weight, type);
        this.setName(name);
    }
    
    public int getMaxLevel()
    {
        return 1;
    }
}