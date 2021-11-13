package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSphere extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;

	public ModelSphere()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.shape3 = new ModelRenderer(this, 0, 0);
		this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape3.addBox(-1.5F, 1.5F, -1.5F, 3, 1, 3, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 0);
		this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape2.addBox(-1.5F, -2.5F, -1.5F, 3, 1, 3, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
		this.shape5 = new ModelRenderer(this, 0, 0);
		this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape5.addBox(-2.5F, -1.5F, -1.5F, 1, 3, 3, 0.0F);
		this.shape7 = new ModelRenderer(this, 0, 0);
		this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape7.addBox(-1.5F, -1.5F, -2.5F, 3, 3, 1, 0.0F);
		this.shape6 = new ModelRenderer(this, 0, 0);
		this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape6.addBox(-1.5F, -1.5F, 1.5F, 3, 3, 1, 0.0F);
		this.shape4 = new ModelRenderer(this, 0, 0);
		this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape4.addBox(1.5F, -1.5F, -1.5F, 1, 3, 3, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shape3.render(f5);
		this.shape2.render(f5);
		this.shape1.render(f5);
		this.shape5.render(f5);
		this.shape7.render(f5);
		this.shape6.render(f5);
		this.shape4.render(f5);
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
