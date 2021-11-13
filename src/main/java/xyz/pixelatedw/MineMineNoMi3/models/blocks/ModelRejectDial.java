package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRejectDial extends ModelBase
{
	public ModelRenderer shell1;
	public ModelRenderer shell2;
	public ModelRenderer shell3;
	public ModelRenderer shell4;
	public ModelRenderer shell5;
	public ModelRenderer shell6;

	public ModelRejectDial()
	{
		this.textureWidth = 50;
		this.textureHeight = 25;
		this.shell3 = new ModelRenderer(this, 17, 0);
		this.shell3.setRotationPoint(2.0F, 22.0F, 0.0F);
		this.shell3.addBox(-1.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
		this.shell1 = new ModelRenderer(this, 0, 0);
		this.shell1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.shell1.addBox(-1.5F, -2.5F, -2.5F, 3, 5, 5, 0.0F);
		this.shell2 = new ModelRenderer(this, 0, 11);
		this.shell2.setRotationPoint(-0.699999988079071F, 20.299999237060547F, -1.7000000476837158F);
		this.shell2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.shell5 = new ModelRenderer(this, 41, 0);
		this.shell5.setRotationPoint(5.0F, 22.0F, 0.0F);
		this.shell5.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
		this.shell4 = new ModelRenderer(this, 30, 0);
		this.shell4.setRotationPoint(3.0F, 22.0F, 0.0F);
		this.shell4.addBox(-0.5F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
		this.shell6 = new ModelRenderer(this, 41, 5);
		this.shell6.setRotationPoint(5.5F, 22.0F, 0.0F);
		this.shell6.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shell3.render(f5);
		this.shell1.render(f5);
		this.shell2.render(f5);
		this.shell5.render(f5);
		this.shell4.render(f5);
		this.shell6.render(f5);
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
