package xyz.pixelatedw.MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.HistoryProperties;

public class GUIHistory extends GuiScreen
{
	private EntityPlayer player;
	private ExtendedEntityData props;
	private int currentScreen = 0;
	
	public GUIHistory(EntityPlayer player)
	{
		this.player = player;
		this.props = ExtendedEntityData.get(player);
	}
	
	@Override
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);

		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		
		HistoryProperties historyProps = HistoryProperties.get(player);
		QuestProperties questProps = QuestProperties.get(player);
		
		mc.fontRenderer.drawStringWithShadow("Has Crocodile: " + historyProps.hasUnlockedChallenge(ID.HISTORY_ENNTRY_NAME_CROCODILE), posX - 30, posY + 70, -1);
		
		super.drawScreen(x, y, f);
	}
	
	@Override
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		if(MainConfig.enableBossFights)
			this.buttonList.add(new GuiButton(1, posX - 20, posY + 210, 70, 20, I18n.format(ID.LANG_GUI_CHALLENGES)));

	}
	
	@Override
	public void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
			case 1:
				this.currentScreen = 0; break;
		}
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
