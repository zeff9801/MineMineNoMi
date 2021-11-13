package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKumadori extends ModelBiped
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
	ModelRenderer Hair_1;
	ModelRenderer Hair_2;
	ModelRenderer Hair_3;
	ModelRenderer Hair_4;
	ModelRenderer Hair_5;
	ModelRenderer Hair_6;
	ModelRenderer right_hair;
	ModelRenderer right_hair_2;
	ModelRenderer left_hair;
	ModelRenderer left_hair_2;
	ModelRenderer staff;
	ModelRenderer ring_1;
	ModelRenderer ring_2;
	ModelRenderer ring_3;

	public ModelKumadori()
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
		head.setRotationPoint(0F, -8F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, -1, 17);
		body.addBox(-4F, 0F, -2F, 8, 14, 4);
		body.setRotationPoint(0F, -2F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		body_2 = new ModelRenderer(this, 0, 36);
		body_2.addBox(0F, 0F, 0F, 6, 14, 4);
		body_2.setRotationPoint(-8F, -4F, -2F);
		body_2.setTextureSize(64, 32);
		body_2.mirror = true;
		setRotation(body_2, 0F, 0F, -0.296706F);
		body_3 = new ModelRenderer(this, 0, 36);
		body_3.addBox(0F, 0F, 0F, 6, 14, 4);
		body_3.setRotationPoint(2.3F, -5.6F, -2F);
		body_3.setTextureSize(64, 32);
		body_3.mirror = true;
		setRotation(body_3, 0F, 0F, 0.296706F);
		body_4 = new ModelRenderer(this, 88, 53);
		body_4.addBox(0F, 0F, 0F, 16, 6, 4);
		body_4.setRotationPoint(-8F, -8F, -2F);
		body_4.setTextureSize(64, 32);
		body_4.mirror = true;
		setRotation(body_4, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 46, 0);
		rightarm.addBox(-3F, -2F, -2F, 4, 15, 4);
		rightarm.setRotationPoint(-9F, -6F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 46, 0);
		leftarm.addBox(-1F, -2F, -2F, 4, 15, 4);
		leftarm.setRotationPoint(9F, -6F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 63, 0);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 63, 0);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		Hair_1 = new ModelRenderer(this, 80, 0);
		Hair_1.addBox(0F, 0F, 0F, 14, 5, 10);
		Hair_1.setRotationPoint(-7F, -21F, -3F);
		Hair_1.setTextureSize(64, 32);
		Hair_1.mirror = true;
		setRotation(Hair_1, -0.1745329F, 0F, 0F);
		Hair_2 = new ModelRenderer(this, 83, 17);
		Hair_2.addBox(0F, 0F, 0F, 13, 7, 10);
		Hair_2.setRotationPoint(-6.5F, -19F, 6F);
		Hair_2.setTextureSize(64, 32);
		Hair_2.mirror = true;
		setRotation(Hair_2, -1.117011F, 0F, 0F);
		Hair_3 = new ModelRenderer(this, 84, 35);
		Hair_3.addBox(0F, 0F, 0F, 12, 7, 9);
		Hair_3.setRotationPoint(-6F, -10F, 10F);
		Hair_3.setTextureSize(64, 32);
		Hair_3.mirror = true;
		setRotation(Hair_3, -1.570796F, 0F, 0F);
		Hair_4 = new ModelRenderer(this, 43, 49);
		Hair_4.addBox(0F, 0F, 0F, 11, 6, 8);
		Hair_4.setRotationPoint(-5.5F, -1F, 9.5F);
		Hair_4.setTextureSize(64, 32);
		Hair_4.mirror = true;
		setRotation(Hair_4, -1.570796F, 0F, 0F);
		Hair_5 = new ModelRenderer(this, 43, 35);
		Hair_5.addBox(0F, 0F, 0F, 10, 5, 8);
		Hair_5.setRotationPoint(-5F, 7F, 9F);
		Hair_5.setTextureSize(64, 32);
		Hair_5.mirror = true;
		setRotation(Hair_5, -1.570796F, 0F, 0F);
		Hair_6 = new ModelRenderer(this, 43, 24);
		Hair_6.addBox(0F, 0F, 0F, 6, 4, 6);
		Hair_6.setRotationPoint(0F, 10.2F, 8.5F);
		Hair_6.setTextureSize(64, 32);
		Hair_6.mirror = true;
		setRotation(Hair_6, -1.570796F, 0F, 0.7853982F);
		right_hair = new ModelRenderer(this, 24, 17);
		right_hair.addBox(0F, 0F, 0F, 3, 9, 3);
		right_hair.setRotationPoint(-7F, -17F, -3.5F);
		right_hair.setTextureSize(64, 32);
		right_hair.mirror = true;
		setRotation(right_hair, -0.1745329F, 0F, 0F);
		right_hair_2 = new ModelRenderer(this, 24, 30);
		right_hair_2.addBox(0F, 0F, 0F, 3, 15, 3);
		right_hair_2.setRotationPoint(-7F, -8.2F, -5F);
		right_hair_2.setTextureSize(64, 32);
		right_hair_2.mirror = true;
		setRotation(right_hair_2, 0F, 0F, 0F);
		left_hair = new ModelRenderer(this, 24, 17);
		left_hair.addBox(0F, 0F, 0F, 3, 9, 3);
		left_hair.setRotationPoint(4F, -17F, -3.5F);
		left_hair.setTextureSize(64, 32);
		left_hair.mirror = true;
		setRotation(left_hair, -0.1745329F, 0F, 0F);
		left_hair_2 = new ModelRenderer(this, 24, 30);
		left_hair_2.addBox(0F, 0F, 0F, 3, 15, 3);
		left_hair_2.setRotationPoint(4F, -8.2F, -5F);
		left_hair_2.setTextureSize(64, 32);
		left_hair_2.mirror = true;
		setRotation(left_hair_2, 0F, 0F, 0F);
		staff = new ModelRenderer(this, 37, 0);
		staff.addBox(0F, 0F, 0F, 1, 45, 1);
		staff.setRotationPoint(-14F, -25F, 8F);
		staff.setTextureSize(64, 32);
		staff.mirror = true;
		setRotation(staff, 0F, 0F, -0.6108652F);
		ring_1 = new ModelRenderer(this, 0, 59);
		ring_1.addBox(0F, 0F, 0F, 4, 4, 1);
		ring_1.setRotationPoint(-17.3F, -27.3F, 8F);
		ring_1.setTextureSize(64, 32);
		ring_1.mirror = true;
		setRotation(ring_1, 0F, 0F, -0.6108652F);
		ring_2 = new ModelRenderer(this, 12, 59);
		ring_2.addBox(0F, 0F, 0F, 4, 1, 4);
		ring_2.setRotationPoint(-17.5F, -22.5F, 6.5F);
		ring_2.setTextureSize(64, 32);
		ring_2.mirror = true;
		setRotation(ring_2, 0F, 0F, -1.134464F);
		ring_3 = new ModelRenderer(this, 12, 59);
		ring_3.addBox(0F, 0F, 0F, 4, 1, 4);
		ring_3.setRotationPoint(-19F, -24.5F, 6.5F);
		ring_3.setTextureSize(64, 32);
		ring_3.mirror = true;
		setRotation(ring_3, 0F, 0F, -0.5759587F);
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
		Hair_1.render(f5);
		Hair_2.render(f5);
		Hair_3.render(f5);
		Hair_4.render(f5);
		Hair_5.render(f5);
		Hair_6.render(f5);
		right_hair.render(f5);
		right_hair_2.render(f5);
		left_hair.render(f5);
		left_hair_2.render(f5);
		staff.render(f5);
		ring_1.render(f5);
		ring_2.render(f5);
		ring_3.render(f5);
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
