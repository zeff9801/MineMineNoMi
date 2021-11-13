package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;

@SideOnly(Side.CLIENT)
public class RenderBlockDial extends TileEntitySpecialRenderer
{
	private final ModelBase model;
	private final ResourceLocation texture;

	public RenderBlockDial(ModelBase model, String textureName)
	{
		this.model = model;
		this.texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/blocks/" + textureName + ".png");
	}

	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) 
	{
		int rotation = 0;
	    if (te.getWorldObj() != null)
	        rotation = te.getBlockMetadata();
		
		bindTexture(texture);

		GL11.glPushMatrix();
			GL11.glTranslated(posX + 0.5, posY + 1.5, posZ + 0.5);
			GL11.glScalef(1, 1, 1);
			GL11.glRotatef(180, 0F, 0F, 1F);
			
			if(this.texture.getResourcePath().contains("impactdial") || this.texture.getResourcePath().contains("flashdial") || this.texture.getResourcePath().contains("axedial"))
			{
				GL11.glTranslated(1.25, 1.45, 0);
				GL11.glRotatef(90, 0, 0, 1);
			}
			
			GL11.glPushMatrix();
				GL11.glRotatef(rotation * 90, 0F, 1F, 0F);
				model.render(null, 0, 0, 0, 0, 0, 0.0625F);
			GL11.glPopMatrix();

		GL11.glPopMatrix();
		
	}

}