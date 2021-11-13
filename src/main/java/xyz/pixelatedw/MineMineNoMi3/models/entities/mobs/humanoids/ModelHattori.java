package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHattori extends ModelBiped
{
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape3;

	public ModelHattori()
	{
		textureWidth = 64;
		textureHeight = 64;

		this.bipedHeadwear = new ModelRenderer(this, 1, 1);
		this.bipedHeadwear.addBox(0F, 0F, 0F, 0, 0, 0);
		this.bipedHeadwear.setRotationPoint(0F, 0F, 0F);
		this.bipedHeadwear.setTextureSize(64, 32);
		this.bipedHeadwear.mirror = true;
		setRotation(this.bipedHeadwear, 0F, 0F, 0F);
		this.bipedHead = new ModelRenderer(this, 1, 1);
		this.bipedHead.addBox(0F, 0F, 0F, 0, 0, 0);
		this.bipedHead.setRotationPoint(0F, 0F, 0F);
		this.bipedHead.setTextureSize(64, 32);
		this.bipedHead.mirror = true;
		setRotation(this.bipedHead, 0F, 0F, 0F);
		
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 5, 6, 4);
		Shape1.setRotationPoint(-3F, 0F, -1F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 18, 0);
		Shape2.addBox(-6F, 0F, -1F, 6, 0, 3);
		Shape2.setRotationPoint(-3F, 1F, 0.5F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 6, 10);
		Shape4.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape4.setRotationPoint(-2F, -3F, -0.5F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 10);
		Shape5.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape5.setRotationPoint(-2F, 6F, 0F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 10);
		Shape6.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape6.setRotationPoint(0F, 6F, 0F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 18, 0);
		Shape3.addBox(0F, 0F, 0F, 6, 0, 3);
		Shape3.setRotationPoint(2F, 1F, -0.5F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape3.render(f5);
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
		// 2,6
		Shape2.rotateAngleZ = MathHelper.cos(f2 * 0.6662F + (float) Math.PI) * 2.0F * f3 * 0.5F;
		Shape3.rotateAngleZ = MathHelper.cos(f2 * 0.6662F + (float) Math.PI) * 2.0F * f3 * 0.5F;

	}

}
