package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelWantedPoster extends ModelBase
{
	public ModelRenderer poster;

	public ModelWantedPoster()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
        this.poster = new ModelRenderer(this, 0, 0);
        this.poster.setRotationPoint(10.0F, 15.0F, 0.0F);
        this.poster.addBox(-10.0F, -15.0F, 0.0F, 20, 30, 0, 1.0F);
	}

	public void render()
	{
		this.poster.render(0.0625F);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
