package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBreathDial extends ModelBase
{
	public ModelRenderer shell1;
	public ModelRenderer shell2;
	public ModelRenderer shell3;
	public ModelRenderer shell4;
	public ModelRenderer shell5;

	public ModelBreathDial()
	{
		this.textureWidth = 50;
		this.textureHeight = 25;
		this.shell1 = new ModelRenderer(this, 0, 0);
		this.shell1.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.shell1.addBox(-1.0F, -3.5F, -3.5F, 2, 7, 7, 0.0F);
		this.shell3 = new ModelRenderer(this, 0, 15);
		this.shell3.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.shell3.addBox(-2.0F, -2.5F, -2.5F, 4, 5, 5, 0.0F);
		this.shell5 = new ModelRenderer(this, 38, 5);
		this.shell5.setRotationPoint(0.0F, 16.5F, 2.299999952316284F);
		this.shell5.addBox(-1.0F, -1.5F, -2.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shell5, 0.06981316953897475F, -0.0F, 0.0F);
		this.shell2 = new ModelRenderer(this, 19, 0);
		this.shell2.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.shell2.addBox(-1.5F, -3.0F, -3.0F, 3, 6, 6, 0.0F);
		this.shell4 = new ModelRenderer(this, 38, 0);
		this.shell4.setRotationPoint(0.0F, 16.899999618530273F, 3.799999952316284F);
		this.shell4.addBox(-1.0F, -2.5F, -2.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shell4, 0.6981316804885863F, -0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shell1.render(f5);
		this.shell3.render(f5);
		this.shell5.render(f5);
		this.shell2.render(f5);
		this.shell4.render(f5);
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
