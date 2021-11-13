package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class ModelDenDenMushi extends ModelBiped
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;

	public ModelDenDenMushi()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Shape1 = new ModelRenderer(this, 0, 0);
		this.Shape1.addBox(-2.0F, 0.0F, -3.0F, 5, 1, 9);
		this.Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape1.setTextureSize(64, 64);
		this.Shape1.mirror = true;
		setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
		this.Shape2 = new ModelRenderer(this, 21, 11);
		this.Shape2.addBox(-1.0F, -3.0F, -3.0F, 3, 3, 3);
		this.Shape2.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape2.setTextureSize(64, 64);
		this.Shape2.mirror = true;
		setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 11);
		this.Shape3.addBox(-2.0F, -5.0F, 0.0F, 5, 5, 5);
		this.Shape3.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape3.setTextureSize(64, 64);
		this.Shape3.mirror = true;
		setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
		this.Shape4 = new ModelRenderer(this, 29, 0);
		this.Shape4.addBox(-1.0F, -5.0F, -2.0F, 1, 2, 1);
		this.Shape4.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape4.setTextureSize(64, 64);
		this.Shape4.mirror = true;
		setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
		this.Shape5 = new ModelRenderer(this, 34, 3);
		this.Shape5.addBox(-1.666667F, -7.0F, -2.5F, 2, 2, 2);
		this.Shape5.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape5.setTextureSize(64, 64);
		this.Shape5.mirror = true;
		setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
		this.Shape6 = new ModelRenderer(this, 29, 0);
		this.Shape6.addBox(1.0F, -5.0F, -2.0F, 1, 2, 1);
		this.Shape6.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape6.setTextureSize(64, 64);
		this.Shape6.mirror = true;
		setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
		this.Shape7 = new ModelRenderer(this, 34, 3);
		this.Shape7.addBox(0.7F, -7.0F, -2.5F, 2, 2, 2);
		this.Shape7.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape7.setTextureSize(64, 64);
		this.Shape7.mirror = true;
		setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5);
		this.Shape1.render(f5);
		this.Shape2.render(f5);
		this.Shape3.render(f5);
		this.Shape4.render(f5);
		this.Shape5.render(f5);
		this.Shape6.render(f5);
		this.Shape7.render(f5);
	}

	public void render(TileEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5);
		this.Shape1.render(f5);
		this.Shape2.render(f5);
		this.Shape3.render(f5);
		this.Shape4.render(f5);
		this.Shape5.render(f5);
		this.Shape6.render(f5);
		this.Shape7.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}
}
