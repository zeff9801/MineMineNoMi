package xyz.pixelatedw.MineMineNoMi3.gui.extra;


import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class GUIButtonNoTexture extends GuiButton
{    	
	public GUIButtonNoTexture(int par1, int par2, int par3, int par4, int par5, String par6St0r) 
	{
		super(par1, par2, par3, par4, par5, par6St0r);
	}
	
    public void drawButton(Minecraft mc, int x, int y)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(new ResourceLocation("mineminenomi","textures/gui/empty.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_146123_n = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glBlendFunc(770, 771);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.mouseDragged(mc, x, y);
            int l = 14737632;
            
			if(k == 2)
				l = WyHelper.hexToRGB("FFD700").getRGB();
			else
				l = 14737632;
            
            //this.drawString(fontrenderer, this.displayString, this.xPosition, this.yPosition + (this.height - 8) / 2, l);                  
        }
    }

}
