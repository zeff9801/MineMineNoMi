package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBlueno extends ModelBiped
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer body_2;
	ModelRenderer body_3;
	ModelRenderer body_4;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer right_hair_1;
	ModelRenderer right_hair_2;
	ModelRenderer left_hair_1;
	ModelRenderer left_hair_2;

	public ModelBlueno()
	{
		textureWidth = 128;
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
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, -6F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 13, 4);
		body.setRotationPoint(0F, -1F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		body_2 = new ModelRenderer(this, 0, 35);
		body_2.addBox(0F, 0F, 0F, 5, 10, 4);
		body_2.setRotationPoint(-7F, -2F, -2F);
		body_2.setTextureSize(64, 32);
		body_2.mirror = true;
		setRotation(body_2, 0F, 0F, -0.3490659F);
		body_3 = new ModelRenderer(this, 0, 50);
		body_3.addBox(0F, 0F, 0F, 5, 10, 4);
		body_3.setRotationPoint(2.5F, -3.6F, -2F);
		body_3.setTextureSize(64, 32);
		body_3.mirror = true;
		setRotation(body_3, 0F, 0F, 0.3490659F);
		body_4 = new ModelRenderer(this, 19, 35);
		body_4.addBox(0F, 0F, 0F, 12, 6, 4);
		body_4.setRotationPoint(-6F, -6F, -2F);
		body_4.setTextureSize(64, 32);
		body_4.mirror = true;
		setRotation(body_4, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 41, 14);
		rightarm.addBox(-3F, -2F, -2F, 4, 15, 4);
		rightarm.setRotationPoint(-7F, -4F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 41, 14);
		leftarm.addBox(-1F, -2F, -2F, 4, 15, 4);
		leftarm.setRotationPoint(7F, -4F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		right_hair_1 = new ModelRenderer(this, 33, 0);
		right_hair_1.addBox(0F, 0F, 0F, 4, 2, 2);
		right_hair_1.setRotationPoint(-6.7F, -14F, -1F);
		right_hair_1.setTextureSize(64, 32);
		right_hair_1.mirror = true;
		setRotation(right_hair_1, 0F, 0F, 0.4537856F);
		right_hair_2 = new ModelRenderer(this, 33, 5);
		right_hair_2.addBox(0F, 0F, 0F, 4, 1, 1);
		right_hair_2.setRotationPoint(-5.5F, -15.7F, -0.5F);
		right_hair_2.setTextureSize(64, 32);
		right_hair_2.mirror = true;
		setRotation(right_hair_2, 0F, 0F, 2.094395F);
		left_hair_1 = new ModelRenderer(this, 33, 0);
		left_hair_1.addBox(-4F, 0F, 0F, 4, 2, 2);
		left_hair_1.setRotationPoint(6.7F, -13.9F, -1F);
		left_hair_1.setTextureSize(64, 32);
		left_hair_1.mirror = true;
		setRotation(left_hair_1, 0F, 0F, -0.4537856F);
		left_hair_2 = new ModelRenderer(this, 33, 5);
		left_hair_2.addBox(-4F, 0F, 0F, 4, 1, 1);
		left_hair_2.setRotationPoint(5.5F, -15.6F, -0.5F);
		left_hair_2.setTextureSize(64, 32);
		left_hair_2.mirror = true;
		setRotation(left_hair_2, 0F, 0F, -2.094395F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		
		this.bipedLeftLeg.isHidden = true;
		this.bipedRightLeg.isHidden = true;
		this.bipedLeftArm.isHidden = true;
		this.bipedRightArm.isHidden = true;
		this.bipedBody.isHidden = true;
		this.bipedHead.isHidden = true;
		
		head.render(f5);
		body.render(f5);
		body_2.render(f5);
		body_3.render(f5);
		body_4.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		right_hair_1.render(f5);
		right_hair_2.render(f5);
		left_hair_1.render(f5);
		left_hair_2.render(f5);
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
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
		leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
	}

}
