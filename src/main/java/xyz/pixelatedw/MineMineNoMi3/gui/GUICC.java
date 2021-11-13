package xyz.pixelatedw.MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

@SideOnly(Side.CLIENT)
public class GUICC extends GuiScreen
{
	private EntityPlayer player;
	private int page = 0, selectedOpt = 0, maxOpt, lastFac = 0, lastRace = 0, lastFStyle = 0;
	private FontRenderer onePieceFontRenderer;
	
	public GUICC(EntityPlayer player)
	{
		this.player = player;
	}
	
	@Override
	public void drawScreen(int x, int y, float f)
	{
		this.drawDefaultBackground();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ExtendedEntityData props = ExtendedEntityData.get(player);
    
		GL11.glTranslated(20, -10, 0);
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_BLANK);
		this.drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);
		this.drawTexturedModalRect(posX + 15, posY + 75, 0, 92, 25, 100);	
		this.drawTexturedModalRect(posX + 200, posY + 73, 26, 92, 30, 100);
		
		this.drawTexturedModalRect(posX - 80, posY + 70, 0, 196, 96, 49);
		this.drawTexturedModalRect(posX - 80, posY + (int)(70 * 1.6), 0, 196, 96, 49);
		this.drawTexturedModalRect(posX - 80, posY + (int)(70 * 2.2), 0, 196, 96, 49);	
		this.drawTexturedModalRect(posX + 75, posY + 200, 0, 196, 96, 49);
		this.drawCategory("Faction", posX + 70, posY + 225, 2.1);
		this.drawCategory("Race", posX + 82, posY + 267, 2.1);
		this.drawCategory("Fighting", posX - 5, posY + 227, 1.5);
		this.drawCategory("Style", posX + 25, posY + 242, 1.5);
		this.drawCategory("Create", posX + 225, posY + 356, 2.1);
		
		if(this.page == 0)
		{
			if(this.selectedOpt == 0)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_PIRATE);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Pirate", posX + 337, posY + 315, 3);
			}
			else if(this.selectedOpt == 1)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_MARINE);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Marine", posX + 337, posY + 315, 3);
			}
			else if(this.selectedOpt == 2)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_BOUNTYHUNTER);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Bounty", posX + 275, posY + 275, 2.7);
				this.drawCategory("Hunter", posX + 330, posY + 300, 2.7);
			}
			else if(this.selectedOpt == 3)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_REVOLUTIONARY);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Revolutionary", posX + 210, posY + 230, 2.3);
				this.drawCategory("Army", posX + 300, posY + 255, 2.3);
			}
		}
		if(this.page == 1)
		{
			if(this.selectedOpt == 0)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_HUMAN);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Human", posX + 337, posY + 315, 3);
			}
			else if(this.selectedOpt == 1)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_FISHMAN);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Fishman", posX + 328, posY + 315, 3);
			}
			else if(this.selectedOpt == 2)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_CYBORG);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Cyborg", posX + 328, posY + 315, 3);
			}
		}
		if(this.page == 2) 
		{
			if(this.selectedOpt == 0)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_SWORDSMAN);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Swordsman", posX + 300, posY + 315, 3);

			}
			else if(this.selectedOpt == 1)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_SNIPER);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Sniper", posX + 335, posY + 315, 3);
			}
			else if(this.selectedOpt == 2)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_MEDIC);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Doctor", posX + 340, posY + 315, 3);
			}
			else if(this.selectedOpt == 3)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_ARTOFWEATHER);
				this.drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
				this.drawCategory("Art of Weather", posX + 200, posY + 220, 2.2);
			}
		}
		
		super.drawScreen(x, y, f);
	}
	
	@Override
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		
		this.buttonList.add(new GUIButtonNoTexture(100, posX - 58, posY + 63, 90, 36, ""));	
		this.buttonList.add(new GUIButtonNoTexture(101, posX - 58, (int)(posY + 63 * 1.6), 90, 36, ""));	
		this.buttonList.add(new GUIButtonNoTexture(102, posX - 58, (int)(posY + 62 * 2.2), 90, 36, ""));
			
		this.buttonList.add(new GUIButtonNoTexture(103, posX + 35, posY + 75, 24, 100, ""));		
		this.buttonList.add(new GUIButtonNoTexture(104, posX + 230, posY + 73, 24, 100, ""));
		
		this.buttonList.add(new GUIButtonNoTexture(105, posX + 97, posY + 195, 90, 35, ""));
	}

	@Override
	public void updateScreen()
	{
		if(this.page == 0)
			maxOpt = 4;
		if(this.page == 1)
			maxOpt = 3;
		if(this.page == 2)
			maxOpt = 4;
	}
	
	@Override
	public void actionPerformed(GuiButton button)
	{
		ExtendedEntityData props = ExtendedEntityData.get(player);
		
		if(button.id >= 0 && button.id < 10)
			props.setFaction(button.displayString);	
		
		if(button.id >= 10 && button.id < 20)
			props.setRace(button.displayString);

		if(button.id >= 20 && button.id < 30)
			props.setFightStyle(button.displayString);	
		
		switch (button.id)
		{ 			
		case 104:
			if(this.selectedOpt + 1 < maxOpt)
				this.selectedOpt++;
			else
				this.selectedOpt = 0;
			break;
			
		case 103:
			if(this.selectedOpt - 1 > -1)
				this.selectedOpt--;
			else
				this.selectedOpt = maxOpt - 1;
			break;
			
		case 105:
			if(this.lastFac == 0) props.setFaction(ID.FACTION_PIRATE);
			else if(this.lastFac == 1) props.setFaction(ID.FACTION_MARINE);
			else if(this.lastFac == 2) props.setFaction(ID.FACTION_BOUNTYHUNTER);
			else if(this.lastFac == 3) props.setFaction(ID.FACTION_REVOLUTIONARY);
			
			if(this.lastRace == 0) props.setRace(ID.RACE_HUMAN);
			else if(this.lastRace == 1) props.setRace(ID.RACE_FISHMAN);
			else if(this.lastRace == 2) props.setRace(ID.RACE_CYBORG);
			
			if(this.lastFStyle == 0) props.setFightStyle(ID.FSTYLE_SWORDSMAN);
			else if(this.lastFStyle == 1) props.setFightStyle(ID.FSTYLE_SNIPER);
			else if(this.lastFStyle == 2) props.setFightStyle(ID.FSTYLE_DOCTOR);
			else if(this.lastFStyle == 3) props.setFightStyle(ID.FSTYLE_ARTOFWEATHER);
			
			switch(this.page)
			{
				case 0:
				{
					switch(this.selectedOpt)
					{
					case 0:
						props.setFaction(ID.FACTION_PIRATE);
						break;
					case 1:
						props.setFaction(ID.FACTION_MARINE);
						break;
					case 2:
						props.setFaction(ID.FACTION_BOUNTYHUNTER);
						break;
					case 3:
						props.setFaction(ID.FACTION_REVOLUTIONARY);
						break;
					}
					break;
				}
				case 1:
				{
					switch(this.selectedOpt)
					{
					case 0:
						props.setRace(ID.RACE_HUMAN);
						break;
					case 1:
						props.setRace(ID.RACE_FISHMAN);
						break;
					case 2:
						props.setRace(ID.RACE_CYBORG);
						break;
					}
					break;					
				}
				case 2:
				{
					switch(this.selectedOpt)
					{
					case 0:
						props.setFightStyle(ID.FSTYLE_SWORDSMAN);
						break;
					case 1:
						props.setFightStyle(ID.FSTYLE_SNIPER);
						break;
					case 2:
						props.setFightStyle(ID.FSTYLE_DOCTOR);
						break;
					case 3:
						props.setFightStyle(ID.FSTYLE_ARTOFWEATHER);
						break;
					}
					break;					
				}
			}
			
			if(!props.getRace().equals("N/A") && !props.getFaction().equals("N/A") && !props.getFightStyle().equals("N/A"))
			{
				this.mc.displayGuiScreen((GuiScreen)null);
				WyNetworkHelper.sendToServer(new PacketSync(props));
				WyNetworkHelper.sendToServer(new PacketPlayer("delete_book"));
			}
			break;
			
		case 100:
			if(this.page == 0) lastFac = this.selectedOpt;
			if(this.page == 1) lastRace = this.selectedOpt;
			if(this.page == 2) lastFStyle = this.selectedOpt;			
			
			this.page = 0;
			
			if(this.page == 0) this.selectedOpt = lastFac;
			if(this.page == 1) this.selectedOpt = lastRace;
			if(this.page == 2) this.selectedOpt = lastFStyle;		
			
			this.mc.displayGuiScreen(this);
			break;
			
		case 101:
			if(this.page == 0) lastFac = this.selectedOpt;
			else if(this.page == 1) lastRace = this.selectedOpt;
			else if(this.page == 2) lastFStyle = this.selectedOpt;
			
			this.page = 1;

			if(this.page == 0) this.selectedOpt = lastFac;
			if(this.page == 1) this.selectedOpt = lastRace;
			if(this.page == 2) this.selectedOpt = lastFStyle;	
			
			this.mc.displayGuiScreen(this);
			break;
			
		case 102:
			if(this.page == 0) lastFac = this.selectedOpt;
			else if(this.page == 1) lastRace = this.selectedOpt;
			else if(this.page == 2) lastFStyle = this.selectedOpt;
			
			this.page = 2;

			if(this.page == 0) this.selectedOpt = lastFac;
			if(this.page == 1) this.selectedOpt = lastRace;
			if(this.page == 2) this.selectedOpt = lastFStyle;	
			
			this.mc.displayGuiScreen(this);
			break;
		}
		
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
	
	private void drawCategory(String text, int posX, int posY, double scale)
	{
		GL11.glPushMatrix();
		
			GL11.glTranslated(posX, posY, 0);
	
			GL11.glTranslated(128, 128, 0);
			GL11.glScaled(scale, scale, scale);
			GL11.glTranslated(-128, -128, 0);
			
			WyRenderHelper.drawStringWithBorder(text, 0, 0, WyHelper.hexToRGB("#FFFFFF").getRGB());
			
		GL11.glPopMatrix();
	}
}
