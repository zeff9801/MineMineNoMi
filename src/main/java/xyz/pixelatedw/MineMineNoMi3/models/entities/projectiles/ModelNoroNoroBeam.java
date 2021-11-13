package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNoroNoroBeam extends ModelBase
{
	public ModelRenderer circle1;
	public ModelRenderer circle2;
	public ModelRenderer circle3;
	public ModelRenderer circle4;
	public ModelRenderer circle5;
	public ModelRenderer circle6;
	public ModelRenderer circle7;
	public ModelRenderer circle8;
	public ModelRenderer circle9;
	public ModelRenderer circle10;
	public ModelRenderer circle11;
	public ModelRenderer circle12;
	public ModelRenderer pellicle;

	public ModelNoroNoroBeam()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.circle3 = new ModelRenderer(this, 0, 0);
		this.circle3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle3.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle3, 0.0F, -0.0F, 0.7853981852531433F);
		this.circle1 = new ModelRenderer(this, 0, 0);
		this.circle1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle1.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle1, 0.0F, -0.0F, -0.2617993950843811F);
		this.circle11 = new ModelRenderer(this, 0, 0);
		this.circle11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle11.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle11, 0.0F, -0.0F, -1.3089969158172607F);
		this.circle12 = new ModelRenderer(this, 0, 0);
		this.circle12.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle12.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle12, 0.0F, -0.0F, -0.7853981852531433F);
		this.pellicle = new ModelRenderer(this, 0, 3);
		this.pellicle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pellicle.addBox(-5.0F, -5.0F, 0.0F, 10, 10, 0, 0.0F);
		this.circle9 = new ModelRenderer(this, 0, 0);
		this.circle9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle9.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle9, 0.0F, -0.0F, -2.356194496154785F);
		this.circle2 = new ModelRenderer(this, 0, 0);
		this.circle2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle2.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle2, 0.0F, -0.0F, 0.2617993950843811F);
		this.circle10 = new ModelRenderer(this, 0, 0);
		this.circle10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle10.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle10, 0.0F, -0.0F, -1.8325957059860232F);
		this.circle7 = new ModelRenderer(this, 0, 0);
		this.circle7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle7.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle7, 0.0F, -0.0F, 2.8972465991973877F);
		this.circle5 = new ModelRenderer(this, 0, 0);
		this.circle5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle5.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle5, 0.0F, -0.0F, 1.8325957059860232F);
		this.circle8 = new ModelRenderer(this, 0, 0);
		this.circle8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle8.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle8, 0.0F, -0.0F, -2.8972465991973877F);
		this.circle4 = new ModelRenderer(this, 0, 0);
		this.circle4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle4.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle4, 0.0F, -0.0F, 1.3089969158172607F);
		this.circle6 = new ModelRenderer(this, 0, 0);
		this.circle6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.circle6.addBox(-1.5F, -5.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(circle6, 0.0F, -0.0F, 2.356194496154785F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.circle3.render(f5);
		this.circle1.render(f5);
		this.circle11.render(f5);
		this.circle12.render(f5);
		this.pellicle.render(f5);
		this.circle9.render(f5);
		this.circle2.render(f5);
		this.circle10.render(f5);
		this.circle7.render(f5);
		this.circle5.render(f5);
		this.circle8.render(f5);
		this.circle4.render(f5);
		this.circle6.render(f5);
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
