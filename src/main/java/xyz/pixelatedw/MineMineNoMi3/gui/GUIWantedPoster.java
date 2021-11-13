package xyz.pixelatedw.MineMineNoMi3.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class GUIWantedPoster extends GuiScreen
{
	private NBTTagCompound wantedData;
	private RenderItem renderItem;

	public GUIWantedPoster(NBTTagCompound nbtTagCompound)
	{
		this.wantedData = nbtTagCompound;
	}

	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		
		// Scaling the entire "context" x2 and positioning it correctly
		GL11.glTranslated(posX + 60, posY + 10, 0);
		GL11.glTranslated(128, 128, 512);
		GL11.glScaled(1, .9, 0);	
		GL11.glTranslated(-128, -128, -512);
		
		// Bounty Poster Texture
		this.mc.renderEngine.bindTexture(ID.TEXTURE_BOUNTYPOSTER_LARGE);
		this.drawTexturedModalRect(0, 0, 0, 0, 220, 250);
		
		// Scaling down the entire thing (with wanted poster texture and name) to x0.71
		GL11.glTranslated(67, 150, 0);	
		GL11.glTranslated(128, 128, 512);
		GL11.glScaled(1.5, 1.6, 0);	
		GL11.glTranslated(-128, -128, -512);
		
        String name = this.wantedData.getString("Name");     
        String background = this.wantedData.getString("Background");     

		GL11.glPushMatrix();
		{
			ResourceLocation rs = new ResourceLocation(ID.PROJECT_ID, "textures/gui/wantedposters/backgrounds/" + background + ".png");		
			this.mc.renderEngine.bindTexture(rs);

			GL11.glScaled(0.34, 0.245, 0);
			this.drawTexturedModalRect(23, -57, 0, 0, 256, 256);
			GL11.glDisable(GL11.GL_BLEND);
			
			rs = AbstractClientPlayer.locationStevePng;
			EntityPlayer player = this.mc.theWorld.getPlayerEntityByName(name);
			
			if(player != null)
				rs = ((AbstractClientPlayer)player).getLocationSkin();
			
			this.mc.renderEngine.bindTexture(rs);			
			
			GL11.glScaled(4.25, 3.25, 0);	
			this.drawTexturedModalRect(21, -5, 32, 64, 32, 64);
			
			/*ResourceLocation rs = AbstractClientPlayer.locationStevePng;		
			EntityPlayer player = this.mc.theWorld.getPlayerEntityByName(name);
			
			if(player != null)
				rs = ((AbstractClientPlayer)player).getLocationSkin();
			this.mc.renderEngine.bindTexture(rs);			
			
			GL11.glScaled(1.8, 1.0, 0);
			GL11.glScaled(0.8, 0.8, 0);		
			this.drawTexturedModalRect(20, -5, 32, 64, 32, 64);
			
			rs = new ResourceLocation(ID.PROJECT_ID, "textures/gui/wantedposters/backgrounds/" + background + ".png");		
			this.mc.renderEngine.bindTexture(rs);

			GL11.glScaled(0.235, 0.235, 0);
			GL11.glScaled(1.0, 1.25, 0);	
			this.drawTexturedModalRect(25, -55, 0, 0, 256, 256);
			GL11.glDisable(GL11.GL_BLEND);*/
		}
		GL11.glPopMatrix();
		
		// Rendering the actually bounty + bounty symbol + wanted name
		this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
		this.drawTexturedModalRect(-2, 63, 0, 0, 32, 32);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        
		if(name.length() > 13)
			name = name.substring(0, 10) + "...";
		mc.fontRenderer.drawString(EnumChatFormatting.BOLD + name, 47 - mc.fontRenderer.getStringWidth(name) / 2, 62, WyHelper.hexToRGB("513413").getRGB());
		
        String bounty = decimalFormat.format(this.wantedData.getLong("Bounty"));
		boolean flag = bounty.length() > 10;		
		if(flag)
		{
			GL11.glPushMatrix();
			GL11.glTranslated(-21, -5, 0);	
			GL11.glTranslated(128, 128, 512);
			GL11.glScaled(.82, 0.89, 0);	
			GL11.glTranslated(-128, -128, -512);
		}
		mc.fontRenderer.drawString(EnumChatFormatting.BOLD + bounty, 22, 76, WyHelper.hexToRGB("513413").getRGB());
		if(flag)
			GL11.glPopMatrix();
		
		// Scaling down the entire thing so the date could fit
		GL11.glTranslated(-24, -2, 0);	
		GL11.glTranslated(128, 128, 512);
		GL11.glScaled(.78, .92, 0);	
		GL11.glTranslated(-128, -128, -512);
		
		mc.fontRenderer.drawString(EnumChatFormatting.BOLD + this.wantedData.getString("Date"), 36 - mc.fontRenderer.getStringWidth(this.wantedData.getString("Date")) / 2, 90, WyHelper.hexToRGB("513413").getRGB());
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		
		
	}
	
	public void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{

		}
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
