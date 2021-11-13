package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelWantedPostersPackage;

@SideOnly(Side.CLIENT)
public class RenderBlockWantedPostersPackage extends TileEntitySpecialRenderer
{
	private ModelWantedPostersPackage model;
	private static final ResourceLocation texture = new ResourceLocation(ID.PROJECT_ID + ":textures/models/wantedposterspackage.png");

	public RenderBlockWantedPostersPackage()
	{
		this.model = new ModelWantedPostersPackage();
	}

	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick)
	{
		bindTexture(texture);

		GL11.glPushMatrix();
		{
			GL11.glTranslated(posX + 0.5, posY + 1.6, posZ + 0.5);
			GL11.glScalef(1, 1, 1);
			GL11.glRotatef(180, 0F, 0F, 1F);

			model.parachute.isHidden = true;
			model.render(null, 0, 0, 0, 0, 0, 0.0625F);
		}
		GL11.glPopMatrix();
	}

}