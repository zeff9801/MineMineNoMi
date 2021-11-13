package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlameDial extends ModelBase
{
	public ModelRenderer shell1;
	public ModelRenderer shell2;
	public ModelRenderer shell3;
	public ModelRenderer shell4;

	public ModelFlameDial()
	{
		this.textureWidth = 50;
		this.textureHeight = 25;
		this.shell4 = new ModelRenderer(this, 19, 0);
		this.shell4.setRotationPoint(-1.2000000476837158F, 21.299999237060547F, -0.800000011920929F);
		this.shell4.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.shell3 = new ModelRenderer(this, 0, 16);
		this.shell3.setRotationPoint(4.0F, 22.0F, 0.0F);
		this.shell3.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.shell1 = new ModelRenderer(this, 0, 0);
		this.shell1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.shell1.addBox(-2.5F, -2.0F, -2.0F, 5, 4, 4, 0.0F);
		this.shell2 = new ModelRenderer(this, 0, 9);
		this.shell2.setRotationPoint(2.5F, 22.0F, 0.0F);
		this.shell2.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shell4.render(f5);
		this.shell3.render(f5);
		this.shell1.render(f5);
		this.shell2.render(f5);
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
