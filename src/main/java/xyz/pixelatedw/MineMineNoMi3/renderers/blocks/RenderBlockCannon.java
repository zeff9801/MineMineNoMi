package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelCannon;

@SideOnly(Side.CLIENT)
public class RenderBlockCannon extends TileEntitySpecialRenderer
{
	private ModelBase model;
	private ResourceLocation texture;

	public RenderBlockCannon()
	{
		this.model = new ModelCannon();
		this.texture = new ResourceLocation(ID.PROJECT_ID, "textures/models/blocks/cannon.png");
	}

	@Override
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
			
			GL11.glPushMatrix();
				GL11.glRotatef(rotation * 90, 0F, 1F, 0F);
				this.model.render(null, 0, 0, 0, 0, 0, 0.0625F);
			GL11.glPopMatrix();

		GL11.glPopMatrix();
		
	}

}