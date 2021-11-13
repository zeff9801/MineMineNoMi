package xyz.pixelatedw.MineMineNoMi3.lists;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;

public class ListCreativeTabs 
{
	
	public static void init()
	{
		WyRegistry.registerName("itemGroup.tab1", "Devil Fruits");
		WyRegistry.registerName("itemGroup.tab2", "Equipment");
		WyRegistry.registerName("itemGroup.tab3", "Miscellaneous");
	}
	
	public static CreativeTabs tabDevilFruits = new CreativeTabs("tab1") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListDevilFruits.MeraMeraNoMi;
	    }
	};
	
	public static CreativeTabs tabWeapons = new CreativeTabs("tab2") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListMisc.Yoru;
	    }
	};
	
	public static CreativeTabs tabMisc = new CreativeTabs("tab3") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListMisc.Kairoseki;
	    }
	};

}
