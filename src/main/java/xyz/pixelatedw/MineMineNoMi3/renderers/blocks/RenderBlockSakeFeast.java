package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntitySakeFeast;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelSakeBottle;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelSakeCup;

@SideOnly(Side.CLIENT)
public class RenderBlockSakeFeast extends TileEntitySpecialRenderer
{
	private final ModelBase bottleModel;
	private final ModelBase cupModel;
	private final ResourceLocation bottleTexture;
	private final ResourceLocation cupTexture;

	private final double[] cupPositions = new double[]
			{
					0.06, 0, -0.4,
					0.36, 0, -0.26,
					0.50, 0, 0.06,
					0.50, 0, 0.06
			};
	
	public RenderBlockSakeFeast()
	{
		this.bottleModel = new ModelSakeBottle();
		this.cupModel = new ModelSakeCup();
		this.bottleTexture = new ResourceLocation(ID.PROJECT_ID, "textures/models/blocks/sakebottle.png");
		this.cupTexture = new ResourceLocation(ID.PROJECT_ID, "textures/models/blocks/sakecup.png");

	}

	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) 
	{	
		TileEntitySakeFeast sakeFeast = (TileEntitySakeFeast) te;
		
		GL11.glPushMatrix();
	    	GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			this.bindTexture(this.bottleTexture);

			GL11.glTranslated(posX + 0.6, posY + 1.5, posZ + 0.4);
			GL11.glScalef(1, 1, 1);
			GL11.glRotatef(180, 0F, 0F, 1F);
			
			GL11.glPushMatrix();
				this.bottleModel.render(null, 0, 0, 0, 0, 0, 0.0625F);
			GL11.glPopMatrix();

		GL11.glPopMatrix();
		
	}

}