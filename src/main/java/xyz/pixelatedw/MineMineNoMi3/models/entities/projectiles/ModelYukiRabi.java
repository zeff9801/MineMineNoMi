package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelYukiRabi extends ModelBase
{
	public ModelRenderer body1;
	public ModelRenderer body2;
	public ModelRenderer body3;
	public ModelRenderer body4;
	public ModelRenderer rightEar;
	public ModelRenderer leftEar;

	public ModelYukiRabi()
	{
		this.textureWidth = 80;
		this.textureHeight = 40;
		this.rightEar = new ModelRenderer(this, 0, 30);
		this.rightEar.setRotationPoint(-1.0F, -1.7999999523162842F, 4.0F);
		this.rightEar.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 7, 0.0F);
		this.setRotateAngle(rightEar, 0.1548174165337927F, -0.08593738767230333F, -0.17518607543307713F);
		this.body4 = new ModelRenderer(this, 29, 15);
		this.body4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body4.addBox(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
		this.leftEar = new ModelRenderer(this, 19, 30);
		this.leftEar.setRotationPoint(1.0F, -1.7999999523162842F, 4.0F);
		this.leftEar.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 7, 0.0F);
		this.setRotateAngle(leftEar, 0.1548174165337927F, 0.08593738767230333F, 0.17518607543307713F);
		this.body3 = new ModelRenderer(this, 29, 0);
		this.body3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body3.addBox(-3.0F, -3.0F, -4.0F, 6, 6, 8, 0.0F);
		this.body1 = new ModelRenderer(this, 0, 0);
		this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body1.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7, 0.0F);
		this.body2 = new ModelRenderer(this, 0, 15);
		this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body2.addBox(-4.0F, -3.0F, -3.0F, 8, 6, 6, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.rightEar.render(f5);
		this.body4.render(f5);
		this.leftEar.render(f5);
		this.body3.render(f5);
		this.body1.render(f5);
		this.body2.render(f5);
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
