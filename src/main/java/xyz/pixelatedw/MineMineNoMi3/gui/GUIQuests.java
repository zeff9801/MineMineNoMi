package xyz.pixelatedw.MineMineNoMi3.gui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;

public class GUIQuests extends GuiScreen
{
	private EntityPlayer player;
	private RenderItem renderItem;
	private ExtendedEntityData props;
	private QuestProperties questProps;
	
	private int questIndex = 0;
	
	public GUIQuests(EntityPlayer player)
	{
		this.player = player;
		this.props = ExtendedEntityData.get(player);
		this.questProps = QuestProperties.get(player);
	}

	@Override
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
	    
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;		
						
		Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_BLANK);
		GL11.glPushMatrix();
		{
			double scale = 1.4;
			GL11.glTranslated(posX + 55, posY + 115, 0);
			GL11.glTranslated(256, 256, 0);
			
			GL11.glScaled(scale, scale, 0);
			GL11.glTranslated(-256, -256, 0);
			
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			
			Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);
			drawTexturedModalRect(-20, 30, 0, 92, 25, 100);
			drawTexturedModalRect(232, 30, 26, 92, 30, 100);
			
		}
		GL11.glPopMatrix();
		
		
		String currentQuest = questProps.getQuestIndexFromTracker(questIndex) != null ? questProps.getQuestIndexFromTracker(questIndex).getQuestName() : "None";
		double currentProgress = questProps.getQuestIndexFromTracker(questIndex) != null ? (questProps.getQuestIndexFromTracker(questIndex).getProgress() / questProps.getQuestIndexFromTracker(questIndex).getMaxProgress()) * 100 : -1;
		List<String> currentDescription = questProps.getQuestIndexFromTracker(questIndex) != null ? Arrays.stream(questProps.getQuestIndexFromTracker(questIndex).getQuestDescription()).filter(line -> !line.isEmpty()).collect(Collectors.toList()) : null;
		
		if(questProps.getQuestIndexFromTracker(questIndex) != null)
		{
			GL11.glPushMatrix();
			{
				double scale = 1.2156;
	
				GL11.glTranslated(posX + 12, posY + 90, 0);
				GL11.glTranslated(256, 256, 0);
	
				GL11.glScaled(scale, scale, 0);
				GL11.glTranslated(-256, -256, 0);
				GL11.glRotated(-12, 0, 0, 1);
					
				if(questProps.getQuestIndexFromTracker(questIndex).isPrimary())
					GL11.glColor3f(1.0F, 1.0F, 0.0F);
				else
					GL11.glColor3f(1.0F, 1.0F, 1.0F);
					
				drawTexturedModalRect(0, 0, 103, 200, 12, 33);	
			}
			GL11.glPopMatrix();
		}
		
		GL11.glPushMatrix();
		{
			double scale = 1.30056;
			GL11.glTranslated(posX + 55, posY + 120, 0);
			GL11.glTranslated(256, 256, 0);
			
			GL11.glScaled(scale, scale, 0);
			GL11.glTranslated(-256, -256, 0);
			
			String questTitleToRender = questProps.getQuestIndexFromTracker(questIndex) != null ? questProps.getQuestIndexFromTracker(questIndex).getQuestID() : "none";
			
			mc.fontRenderer.drawString(EnumChatFormatting.BOLD + "" + EnumChatFormatting.UNDERLINE + I18n.format("quest." + questTitleToRender + ".name"), 0, 0, WyHelper.hexToRGB("#161616").getRGB());
		}
		GL11.glPopMatrix();
		
		if(currentProgress != -1)
			mc.fontRenderer.drawString(EnumChatFormatting.BOLD + I18n.format(ID.LANG_GUI_QUESTS_PROGRESS) + " : " + String.format("%.1f", currentProgress) + "%", posX + 5, posY + 65, WyHelper.hexToRGB("#161616").getRGB());

		if(currentDescription != null)
		{
			int i = 18;
			for(int l = 0; l <  currentDescription.size(); l++)
			{
				mc.fontRenderer.drawString(I18n.format("quest." + questProps.getQuestIndexFromTracker(questIndex).getQuestID() + ".desc." + l), posX - 20, posY + 65 + i, WyHelper.hexToRGB("#161616").getRGB());
				i += 16;
			}
		}

		
		super.drawScreen(x, y, f);
	}

	@Override
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		this.buttonList.add(new GUIButtonNoTexture(100, posX - 65, posY + 60, 24, 125, ""));		
		this.buttonList.add(new GUIButtonNoTexture(101, posX + 290, posY + 60, 24, 125, ""));
	}
	
	@Override
	public void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
			
			case 100:
				if(this.questIndex > 0)
					questIndex--;
				else
					questIndex = 3;
				break;
			case 101:
				if(this.questIndex < 3)
					questIndex++;
				else
					questIndex = 0;
				break;
			
			//case 1: player.openGui(MainMod.getMineMineNoMi(), 4, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		}
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

    private void drawItemStack(ItemStack itemStack, int x, int y, String string)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        itemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (itemStack != null) font = itemStack.getItem().getFontRenderer(itemStack);
        if (font == null) font = fontRendererObj;
        itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y);
        itemRender.renderItemOverlayIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y - 0, string);
        this.zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
    }
}
