package xyz.pixelatedw.MineMineNoMi3.quests;

import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;

public enum EnumQuestlines
{

	ARTOFWEATHER_PROGRESSION("artofweatherprogression"),
	MEDIC_PROGRESSION("medicprogression"),
	SNIPER_PROGRESSION("sniperprogression",
			ListQuests.sniperProgression01, ListQuests.sniperProgression02),
	SWORDSMAN_PROGRESSION("swordsmanprogression",
			ListQuests.swordsmanProgression01, ListQuests.swordsmanProgression02, ListQuests.swordsmanProgression03, ListQuests.swordsmanProgression04, ListQuests.swordsmanProgression05);
	
	String questlineName;
	Quest[] quests;
	
	private EnumQuestlines(String questlineName, Quest... quests)
	{
		this.questlineName = questlineName;
		this.quests = quests;
	}
	
	public String getQuestlineName()
	{
		return this.questlineName;
	}
	
	public Quest[] getQuests()
	{
		return this.quests;
	}
}
