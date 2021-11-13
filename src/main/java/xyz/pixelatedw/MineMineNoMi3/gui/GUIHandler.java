package xyz.pixelatedw.MineMineNoMi3.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class GUIHandler implements IGuiHandler
{
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(id)
		{
			case 0: return (world.getBlock(x, y, z) == ListMisc.EnchantmentTable ? new GUIEnchantmentTable(player, world, x, y, z) : null);
			case 1: return new GUIPlayer(player);
			case 2: return new GUICC(player);
			case 4: return new GUISelectHotbarAbilities(player);
			case 5: return new GUIQuests(player);
			case 6: return new GUIHistory(player);
			//case 6: return new GUIQuestYesNo(player, x, y, z);
		}
		return null;
	}
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(id)
		{
			//case 0: return id == 0 && world.getBlock(x, y, z) == ListMisc.EnchantmentTable ? new ContainerEnchantmentTable(player, world) : null;
		}
		return null;
	}
}
