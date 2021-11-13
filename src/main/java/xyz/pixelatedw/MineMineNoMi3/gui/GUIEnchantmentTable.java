package xyz.pixelatedw.MineMineNoMi3.gui;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;

@SideOnly(Side.CLIENT)
public class GUIEnchantmentTable extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation(ID.PROJECT_ID, "textures/gui/gui_dial.png");

    public GUIEnchantmentTable(EntityPlayer player, World par2World, int par3, int par4, int par5)
    {
        super(null); //new ContainerEnchantmentTable(player, par2World)
    } 

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, (new Color(0, 0, 0)).getRGB());
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
