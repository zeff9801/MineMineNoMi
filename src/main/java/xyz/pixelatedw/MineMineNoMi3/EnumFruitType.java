package xyz.pixelatedw.MineMineNoMi3;

import net.minecraft.util.EnumChatFormatting;

public enum EnumFruitType 
{

	PARAMECIA		(EnumChatFormatting.RED			, "Paramecia"),
	LOGIA			(EnumChatFormatting.YELLOW		, "Logia"),
	ZOAN			(EnumChatFormatting.GREEN		, "Zoan"),
	MYTHICALZOAN	(EnumChatFormatting.AQUA		, "Mythical Zoan"),
	ANCIENTZOAN		(EnumChatFormatting.AQUA		, "Ancient Zoan"),
	ARTIFICIALLOGIA	(EnumChatFormatting.GOLD		, "Artificial Logia"),
	ARTIFICIALPARAM	(EnumChatFormatting.GOLD		, "Artificial Paramecia"),
	ARTIFICIALZOAN	(EnumChatFormatting.GOLD		, "Artificial Zoan");
	
	private EnumChatFormatting color;
	private String name;
	
	private EnumFruitType(EnumChatFormatting color, String name)
	{
		this.color = color;
		this.name = name;
	}
	
	public EnumChatFormatting getColor()
	{
		return color;		
	}
	
	public String getName()
	{
		return name;
	}
}
