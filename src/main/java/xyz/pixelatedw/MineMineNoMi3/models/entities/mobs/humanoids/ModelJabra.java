package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelJabra extends ModelBiped
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hairclip_1;
	ModelRenderer hair_1;
	ModelRenderer hairclip_2;
	ModelRenderer hair_2;
	ModelRenderer hairclip_3;
	ModelRenderer hair_3;
	ModelRenderer hairclip_4;
	ModelRenderer hair_4;
	ModelRenderer hairclip_5;
	ModelRenderer hair_5;
	ModelRenderer hairclip_6;
	ModelRenderer hair_6;
	ModelRenderer hairclip_7;
	ModelRenderer hair_7;
	ModelRenderer Right_Beard;
	ModelRenderer Left_Beard;

	public ModelJabra()
	{
		textureWidth = 64;
		textureHeight = 32;

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
		hairclip_1 = new ModelRenderer(this, 34, 0);
		hairclip_1.addBox(0F, 0F, 0F, 1, 1, 1);
		hairclip_1.setRotationPoint(-0.5F, -6.5F, 4F);
		hairclip_1.setTextureSize(64, 32);
		hairclip_1.mirror = true;
		setRotation(hairclip_1, -0.2617994F, 0F, 0F);
		hair_1 = new ModelRenderer(this, 34, 4);
		hair_1.addBox(0F, 0F, 0F, 2, 2, 2);
		hair_1.setRotationPoint(-1F, -6.7F, 4.7F);
		hair_1.setTextureSize(64, 32);
		hair_1.mirror = true;
		setRotation(hair_1, -0.418879F, 0F, 0F);
		hairclip_2 = new ModelRenderer(this, 34, 0);
		hairclip_2.addBox(0F, 0F, 0F, 1, 1, 1);
		hairclip_2.setRotationPoint(-0.5F, -5.3F, 6.2F);
		hairclip_2.setTextureSize(64, 32);
		hairclip_2.mirror = true;
		setRotation(hairclip_2, -0.837758F, 0F, 0F);
		hair_2 = new ModelRenderer(this, 34, 4);
		hair_2.addBox(0F, 0F, 0F, 2, 2, 2);
		hair_2.setRotationPoint(-1F, -5F, 7.5F);
		hair_2.setTextureSize(64, 32);
		hair_2.mirror = true;
		setRotation(hair_2, -1.082104F, 0F, 0F);
		hairclip_3 = new ModelRenderer(this, 34, 0);
		hairclip_3.addBox(0F, 0F, 0F, 1, 1, 1);
		hairclip_3.setRotationPoint(-0.5F, -3.2F, 7.8F);
		hairclip_3.setTextureSize(64, 32);
		hairclip_3.mirror = true;
		setRotation(hairclip_3, -1.047198F, 0F, 0F);
		hair_3 = new ModelRenderer(this, 34, 4);
		hair_3.addBox(0F, 0F, 0F, 2, 2, 2);
		hair_3.setRotationPoint(-1F, -2.5F, 8.8F);
		hair_3.setTextureSize(64, 32);
		hair_3.mirror = true;
		setRotation(hair_3, -1.43117F, 0F, 0F);
		hairclip_4 = new ModelRenderer(this, 34, 0);
		hairclip_4.addBox(0F, 0F, 0F, 1, 1, 1);
		hairclip_4.setRotationPoint(-0.5F, -0.7F, 7.6F);
		hairclip_4.setTextureSize(64, 32);
		hairclip_4.mirror = true;
		setRotation(hairclip_4, 0F, 0F, 0F);
		hair_4 = new ModelRenderer(this, 34, 4);
		hair_4.addBox(0F, 0F, 0F, 2, 2, 2);
		hair_4.setRotationPoint(-1F, 0F, 7.1F);
		hair_4.setTextureSize(64, 32);
		hair_4.mirror = true;
		setRotation(hair_4, 0F, 0F, 0F);
		hairclip_5 = new ModelRenderer(this, 34, 0);
		hairclip_5.addBox(0F, 0F, 0F, 1, 1, 1);
		hairclip_5.setRotationPoint(-0.5F, 1.7F, 7.6F);
		hairclip_5.setTextureSize(64, 32);
		hairclip_5.mirror = true;
		setRotation(hairclip_5, 0F, 0F, 0F);
		hair_5 = new ModelRenderer(this, 34, 4);
		hair_5.addBox(0F, 0F, 0F, 2, 2, 2);
		hair_5.setRotationPoint(-1F, 2.5F, 7.1F);
		hair_5.setTextureSize(64, 32);
		hair_5.mirror = true;
		setRotation(hair_5, 0F, 0F, 0F);
		hairclip_6 = new ModelRenderer(this, 34, 0);
		hairclip_6.addBox(0F, 0F, 0F, 1, 1, 1);
		hairclip_6.setRotationPoint(-0.5F, 4.2F, 7.6F);
		hairclip_6.setTextureSize(64, 32);
		hairclip_6.mirror = true;
		setRotation(hairclip_6, 0F, 0F, 0F);
		hair_6 = new ModelRenderer(this, 34, 4);
		hair_6.addBox(0F, 0F, 0F, 2, 2, 2);
		hair_6.setRotationPoint(-1F, 5F, 7.1F);
		hair_6.setTextureSize(64, 32);
		hair_6.mirror = true;
		setRotation(hair_6, 0F, 0F, 0F);
		hairclip_7 = new ModelRenderer(this, 34, 0);
		hairclip_7.addBox(0F, 0F, 0F, 1, 1, 1);
		hairclip_7.setRotationPoint(-0.5F, 6.7F, 7.6F);
		hairclip_7.setTextureSize(64, 32);
		hairclip_7.mirror = true;
		setRotation(hairclip_7, 0F, 0F, 0F);
		hair_7 = new ModelRenderer(this, 34, 4);
		hair_7.addBox(0F, 0F, 0F, 2, 2, 2);
		hair_7.setRotationPoint(-1F, 7.1F, 8.1F);
		hair_7.setTextureSize(64, 32);
		hair_7.mirror = true;
		setRotation(hair_7, -0.7853982F, 0F, 0F);
		Right_Beard = new ModelRenderer(this, 44, 0);
		Right_Beard.addBox(0F, 0F, 0F, 1, 6, 0);
		Right_Beard.setRotationPoint(-2.5F, -3F, -4.1F);
		Right_Beard.setTextureSize(64, 32);
		Right_Beard.mirror = true;
		setRotation(Right_Beard, 0F, 0F, 0F);
		Left_Beard = new ModelRenderer(this, 47, 0);
		Left_Beard.addBox(0F, 0F, 0F, 1, 6, 0);
		Left_Beard.setRotationPoint(1.5F, -3F, -4.1F);
		Left_Beard.setTextureSize(64, 32);
		Left_Beard.mirror = true;
		setRotation(Left_Beard, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		
		this.bipedLeftLeg.isHidden = true;
		this.bipedRightLeg.isHidden = true;
		this.bipedLeftArm.isHidden = true;
		this.bipedRightArm.isHidden = true;
		
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		hairclip_1.render(f5);
		hair_1.render(f5);
		hairclip_2.render(f5);
		hair_2.render(f5);
		hairclip_3.render(f5);
		hair_3.render(f5);
		hairclip_4.render(f5);
		hair_4.render(f5);
		hairclip_5.render(f5);
		hair_5.render(f5);
		hairclip_6.render(f5);
		hair_6.render(f5);
		hairclip_7.render(f5);
		hair_7.render(f5);
		Right_Beard.render(f5);
		Left_Beard.render(f5);
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
