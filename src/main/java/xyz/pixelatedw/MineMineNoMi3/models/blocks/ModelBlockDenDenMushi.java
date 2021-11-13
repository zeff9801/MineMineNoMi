package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class ModelBlockDenDenMushi extends ModelBase
{
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;

	public ModelBlockDenDenMushi()
	{
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-2F, 0F, -3F, 5, 1, 9);
		Shape1.setRotationPoint(0F, 23F, 0F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 21, 11);
		Shape2.addBox(-1F, -3F, -3F, 3, 3, 3);
		Shape2.setRotationPoint(0F, 23F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 11);
		Shape3.addBox(-2F, -5F, 0F, 5, 5, 5);
		Shape3.setRotationPoint(0F, 23F, 0F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 29, 0);
		Shape4.addBox(-1F, -5F, -2F, 1, 2, 1);
		Shape4.setRotationPoint(0F, 23F, 0F);
		Shape4.setTextureSize(64, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 34, 3);
		Shape5.addBox(-1.666667F, -7F, -2.5F, 2, 2, 2);
		Shape5.setRotationPoint(0F, 23F, 0F);
		Shape5.setTextureSize(64, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 29, 0);
		Shape6.addBox(1F, -5F, -2F, 1, 2, 1);
		Shape6.setRotationPoint(0F, 23F, 0F);
		Shape6.setTextureSize(64, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 34, 3);
		Shape7.addBox(0.7F, -7F, -2.5F, 2, 2, 2);
		Shape7.setRotationPoint(0F, 23F, 0F);
		Shape7.setTextureSize(64, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 48, 0);
		Shape8.addBox(-3F, -4F, 1F, 1, 3, 3);
		Shape8.setRotationPoint(0F, 23F, 0F);
		Shape8.setTextureSize(64, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 48, 7);
		Shape9.addBox(-2F, -6F, 1.5F, 5, 1, 2);
		Shape9.setRotationPoint(0F, 23F, 0F);
		Shape9.setTextureSize(64, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 43, 0);
		Shape10.addBox(-3F, -6F, 2F, 1, 2, 1);
		Shape10.setRotationPoint(0F, 23F, 0F);
		Shape10.setTextureSize(64, 64);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
	}

	public void render()
	{
		Shape1.render(0.0625F);
		Shape2.render(0.0625F);
		Shape3.render(0.0625F);
		Shape4.render(0.0625F);
		Shape5.render(0.0625F);
		Shape6.render(0.0625F);
		Shape7.render(0.0625F);
		Shape8.render(0.0625F);
		Shape9.render(0.0625F);
		Shape10.render(0.0625F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
