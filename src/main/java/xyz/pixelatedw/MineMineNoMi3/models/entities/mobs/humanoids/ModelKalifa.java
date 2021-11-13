package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKalifa extends ModelBiped
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hair_1;
	ModelRenderer right_hair;
	ModelRenderer left_hair;
	ModelRenderer bust;
	ModelRenderer glasses_front;

	public ModelKalifa()
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
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
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
		hair_1 = new ModelRenderer(this, 33, 0);
		hair_1.addBox(0F, 0F, 0F, 8, 7, 0);
		hair_1.setRotationPoint(-4F, 0F, 4F);
		hair_1.setTextureSize(64, 32);
		hair_1.mirror = true;
		setRotation(hair_1, 0F, 0F, 0F);
		right_hair = new ModelRenderer(this, 33, 7);
		right_hair.addBox(0F, 0F, 0F, 0, 7, 1);
		right_hair.setRotationPoint(-4.1F, -1F, -3F);
		right_hair.setTextureSize(64, 32);
		right_hair.mirror = true;
		setRotation(right_hair, 0F, 0F, 0F);
		left_hair = new ModelRenderer(this, 33, 7);
		left_hair.addBox(0F, 0F, 0F, 0, 7, 1);
		left_hair.setRotationPoint(4.1F, -1F, -3F);
		left_hair.setTextureSize(64, 32);
		left_hair.mirror = true;
		setRotation(left_hair, 0F, 0F, 0F);
		bust = new ModelRenderer(this, 36, 10);
		bust.addBox(0F, 0F, 0F, 8, 3, 2);
		bust.setRotationPoint(-4F, 2F, -3.5F);
		bust.setTextureSize(64, 32);
		bust.mirror = true;
		setRotation(bust, 0F, 0F, 0F);
		glasses_front = new ModelRenderer(this, 36, 8);
		glasses_front.addBox(0F, 0F, 0F, 8, 1, 0);
		glasses_front.setRotationPoint(-4F, -5F, -4.1F);
		glasses_front.setTextureSize(64, 32);
		glasses_front.mirror = true;
		setRotation(glasses_front, 0F, 0F, 0F);
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
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		hair_1.render(f5);
		right_hair.render(f5);
		left_hair.render(f5);
		bust.render(f5);
		glasses_front.render(f5);
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