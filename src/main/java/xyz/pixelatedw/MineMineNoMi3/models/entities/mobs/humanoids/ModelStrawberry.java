package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStrawberry extends ModelBiped
{
	// fields
	ModelRenderer hair3;
	ModelRenderer hair1;
	ModelRenderer sword2;
	ModelRenderer sword1;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer sword3;
	ModelRenderer sword4;
	ModelRenderer sword5;
	ModelRenderer sword6;
	ModelRenderer hair2;
	ModelRenderer hair4;

	public ModelStrawberry()
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
		
		hair3 = new ModelRenderer(this, 29, 34);
		hair3.addBox(0F, 0F, 0F, 4, 5, 1);
		hair3.setRotationPoint(-2F, 0F, -4F);
		hair3.setTextureSize(64, 32);
		hair3.mirror = true;
		setRotation(hair3, 0F, 0F, 0F);
		hair1 = new ModelRenderer(this, 32, 0);
		hair1.addBox(0F, 0F, 0F, 5, 5, 5);
		hair1.setRotationPoint(-2.5F, -13F, -2.5F);
		hair1.setTextureSize(64, 32);
		hair1.mirror = true;
		setRotation(hair1, 0F, 0F, 0F);
		sword2 = new ModelRenderer(this, 19, 34);
		sword2.addBox(-2.5F, 7.5F, -4F, 3, 3, 1);
		sword2.setRotationPoint(-5F, 2F, 0F);
		sword2.setTextureSize(64, 32);
		sword2.mirror = true;
		setRotation(sword2, 0F, 0F, 0F);
		sword1 = new ModelRenderer(this, 0, 33);
		sword1.addBox(-2F, 8F, -3F, 2, 2, 6);
		sword1.setRotationPoint(-5F, 2F, 0F);
		sword1.setTextureSize(64, 32);
		sword1.mirror = true;
		setRotation(sword1, 0F, 0F, 0F);
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
		sword3 = new ModelRenderer(this, 0, 42);
		sword3.addBox(-1.5F, 8.5F, -16F, 1, 1, 12);
		sword3.setRotationPoint(-5F, 2F, 0F);
		sword3.setTextureSize(64, 32);
		sword3.mirror = true;
		setRotation(sword3, 0F, 0F, 0F);
		sword4 = new ModelRenderer(this, 0, 33);
		sword4.addBox(0F, 8F, -3F, 2, 2, 6);
		sword4.setRotationPoint(5F, 2F, 0F);
		sword4.setTextureSize(64, 32);
		sword4.mirror = true;
		setRotation(sword4, 0F, 0F, 0F);
		sword5 = new ModelRenderer(this, 19, 34);
		sword5.addBox(-0.5F, 7.5F, -4F, 3, 3, 1);
		sword5.setRotationPoint(5F, 2F, 0F);
		sword5.setTextureSize(64, 32);
		sword5.mirror = true;
		setRotation(sword5, 0F, 0F, 0F);
		sword6 = new ModelRenderer(this, 0, 42);
		sword6.addBox(0.5F, 8.5F, -16F, 1, 1, 12);
		sword6.setRotationPoint(5F, 2F, 0F);
		sword6.setTextureSize(64, 32);
		sword6.mirror = true;
		setRotation(sword6, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 51, 33);
		hair2.addBox(0F, 0F, 0F, 3, 7, 3);
		hair2.setRotationPoint(-1.5F, -20F, -1.5F);
		hair2.setTextureSize(64, 32);
		hair2.mirror = true;
		setRotation(hair2, 0F, 0F, 0F);
		hair4 = new ModelRenderer(this, 41, 34);
		hair4.addBox(0F, 0F, 0F, 2, 5, 1);
		hair4.setRotationPoint(-1F, 5F, -4F);
		hair4.setTextureSize(64, 32);
		hair4.mirror = true;
		setRotation(hair4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		hair3.render(f5);
		hair1.render(f5);
		sword2.render(f5);
		sword1.render(f5);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		sword3.render(f5);
		sword4.render(f5);
		sword5.render(f5);
		sword6.render(f5);
		hair2.render(f5);
		hair4.render(f5);
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
		sword4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		sword5.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		sword6.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
		sword1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
		sword2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
		sword3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.0F * f1;
	}

}