package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelWantedPoster;

import java.text.DecimalFormat;

@SideOnly(Side.CLIENT)
public class RenderBlockWantedPoster extends TileEntitySpecialRenderer
{
	private static final ResourceLocation texture = new ResourceLocation(ID.PROJECT_ID + ":textures/models/wantedposter.png");
	private final ModelWantedPoster posterModel;

	public RenderBlockWantedPoster()
	{
		this.posterModel = new ModelWantedPoster();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick)
	{
		ExtendedWorldData worldData = ExtendedWorldData.get(te.getWorldObj());

		TileEntityWantedPoster te2 = (TileEntityWantedPoster) te;

		int rawRot = te2.getBlockMetadata();

		double posterX = 0, textX = 0, pictureX = 0;
		double posterY = 0, textY = 0, pictureY = 0;
		double posterZ = 0, textZ = 0, pictureZ = 0;
		int posterRotation = 90, textRotation = 90;

		if (rawRot == 2)
		{
			posterX = 0.90;
			posterZ = 0.16;
			posterRotation = 180;
			
			pictureX = 0.25;
			pictureZ = 0.7;
						
			textX = 0.38;
			textZ = 0.55;
			textRotation = 0;
		}
		else if (rawRot == 3)
		{
			posterX = 0.18;
			posterZ = -0.9;
			posterRotation = 0;
			
			pictureX = 0.71;
			pictureZ = -0.25;
						
			textX = 0.57;
			textY = 0.01;
			textZ = -0.41;
			textRotation = 180;
		}
		else if (rawRot == 5)
		{
			posterX = 1.1;
			posterZ = -0.74;
			posterRotation = -90;
			
			pictureX = 0.97;
			pictureZ = 0.44;
						
			textX = 0.98;
			textY = 0.005;
			textZ = 0.165;
			textRotation = -90;
		}

		bindTexture(texture);

		GL11.glPushMatrix();
		{
			GL11.glDepthMask(false);

			GL11.glTranslated(posX + 1.05, posY + 1.2, posZ + 0.87);
			GL11.glRotatef(180, 0F, 0F, 1F);
			GL11.glRotatef(0, 0F, 1F, 0F);

			GL11.glPushMatrix();
			{
				GL11.glTranslated(posterX, posterY, posterZ);
				GL11.glRotatef(posterRotation, 0F, 1F, 0F);
				GL11.glScaled(.6, .6, 1);
				this.posterModel.render();
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glDepthMask(true);
				
				GL11.glTranslated(pictureX + 0.06, pictureY + 0.3, pictureZ - 0.60);
				GL11.glRotatef(-textRotation, 0F, 1F, 0F);
				GL11.glScalef(2.2F, 2.0F, 1.6F);
			
				String name = te2.getEntityName();
				Minecraft minecraft = Minecraft.getMinecraft();
				
				if(name == null || name.isEmpty())
					return;
				
				ResourceLocation rs = AbstractClientPlayer.locationStevePng;
				
				EntityPlayer player = minecraft.theWorld.getPlayerEntityByName(name);
								
				if(player != null)
					rs = ((AbstractClientPlayer)player).getLocationSkin();

				this.bindTexture(rs);
	
				int x = 0;
				int y = 0;
				double u = 0.2;
				double v = 0.2;

				Tessellator tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(x			, y + v			, 0, 0.125, 0.5);
				tessellator.addVertexWithUV(x + u		, y + v			, 0, 0.25, 0.5);
				tessellator.addVertexWithUV(x + u		, y        		, 0, 0.25, 0.25);
				tessellator.addVertexWithUV(x			, y         	, 0, 0.125, 0.25);
				tessellator.draw();
				
				ResourceLocation background = new ResourceLocation(ID.PROJECT_ID, "textures/gui/wantedposters/backgrounds/" + te2.getBackground() + ".png");
								
				this.bindTexture(background);

				GL11.glTranslated(-0.059, -0.04, 0.001);
				GL11.glScalef(1.02F, 1.25F, 1.0F);
				
				u = 0.3;
				v = 0.2;
				
				tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(x			, y + v			, 0, 0.0, 1.0);
				tessellator.addVertexWithUV(x + u		, y + v			, 0, 1.0, 1.0);
				tessellator.addVertexWithUV(x + u		, y        		, 0, 1.0, 0.0);
				tessellator.addVertexWithUV(x			, y         	, 0, 0.0, 0.0);
				tessellator.draw();
				
				GL11.glDepthMask(false);
			}
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
			{
				GL11.glNormal3f(0.0F, 1.0F, -1.0F);

				GL11.glTranslated(textX + 0.065, textY + 0.83, textZ - 0.45);
				GL11.glRotatef(-textRotation, 0F, 1F, 0F);
				GL11.glScalef(.007F, .007F, .007F);
				
				String name = te2.getEntityName();
				if(name.length() > 13)
					name = name.substring(0, 10) + "...";			
				Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BOLD + name, 3 - Minecraft.getMinecraft().fontRenderer.getStringWidth(name) / 2, 0, WyHelper.hexToRGB("513413").getRGB());
				
				GL11.glScalef(1.2F, 1.2F, 1.2F);
				DecimalFormat decimalFormat = new DecimalFormat("#,##0");
				if (te2.getPosterBounty() == null)
					te2.setPosterBounty("0");
				String bounty = "0";
				try
				{
					bounty = decimalFormat.format(Long.parseLong(te2.getPosterBounty().replace("L", "")));
				}
				catch(Exception e)
				{
					bounty = "0";
					e.printStackTrace();
				}
				
				boolean flag = bounty.length() > 10;

				if(flag)
				{
					GL11.glPushMatrix();
					GL11.glTranslated(-40, -13.5, 0);	
					GL11.glTranslated(128, 128, 512);
					GL11.glScaled(.72, 0.89, 1.005);	
					GL11.glTranslated(-128, -128, -512);
				}
				Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BOLD + bounty, -20, 13, WyHelper.hexToRGB("#513413").getRGB());
				if(flag)
					GL11.glPopMatrix();
				
				GL11.glScalef(0.7F, 0.9F, 0.8F);
				Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BOLD + te2.getIssuedDate(), -40, 30, WyHelper.hexToRGB("#513413").getRGB());
			}
			GL11.glPopMatrix();
			
			GL11.glDepthMask(true);
		}
		GL11.glPopMatrix();
	}
	
    public void drawTexturedModalRect(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_)
    {
    	int zLevel = 1;
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(p_73729_1_ + 0, p_73729_2_ + p_73729_6_, zLevel, (p_73729_3_ + 0) * f, (p_73729_4_ + p_73729_6_) * f1);
        tessellator.addVertexWithUV(p_73729_1_ + p_73729_5_, p_73729_2_ + p_73729_6_, zLevel, (p_73729_3_ + p_73729_5_) * f, (p_73729_4_ + p_73729_6_) * f1);
        tessellator.addVertexWithUV(p_73729_1_ + p_73729_5_, p_73729_2_ + 0, zLevel, (p_73729_3_ + p_73729_5_) * f, (p_73729_4_ + 0) * f1);
        tessellator.addVertexWithUV(p_73729_1_ + 0, p_73729_2_ + 0, zLevel, (p_73729_3_ + 0) * f, (p_73729_4_ + 0) * f1);
        tessellator.draw();
    }
}