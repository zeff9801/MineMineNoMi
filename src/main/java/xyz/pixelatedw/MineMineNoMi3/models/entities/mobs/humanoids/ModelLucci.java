package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelLucci extends ModelBiped
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hat2;
	ModelRenderer hat1;
	ModelRenderer pi1;
	ModelRenderer pi2;
	ModelRenderer pi3;
	ModelRenderer pi4;
	ModelRenderer pi5;
	ModelRenderer pi6;
	ModelRenderer pi7;
	ModelRenderer pi8;

	public ModelLucci()
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
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-5F, -2F, -2F, 5, 12, 4);
		rightarm.setRotationPoint(-4F, 2F, 0F);
		rightarm.setTextureSize(64, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 5, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		hat2 = new ModelRenderer(this, 0, 44);
		hat2.addBox(-3F, -17F, -3F, 6, 8, 6);
		hat2.setRotationPoint(0F, 0F, 0F);
		hat2.setTextureSize(64, 64);
		hat2.mirror = true;
		setRotation(hat2, 0F, 0F, 0F);
		hat1 = new ModelRenderer(this, 0, 33);
		hat1.addBox(-5F, -9F, -5F, 10, 1, 10);
		hat1.setRotationPoint(0F, 0F, 0F);
		hat1.setTextureSize(64, 64);
		hat1.mirror = true;
		setRotation(hat1, 0F, 0F, 0F);
		pi1 = new ModelRenderer(this, 32, 13);
		pi1.addBox(-5F, -3F, -1F, 1, 1, 2);
		pi1.setRotationPoint(-4F, 2F, 0F);
		pi1.setTextureSize(64, 64);
		pi1.mirror = true;
		setRotation(pi1, 0F, 0F, 0F);
		pi2 = new ModelRenderer(this, 32, 13);
		pi2.addBox(-3F, -3F, -1F, 1, 1, 2);
		pi2.setRotationPoint(-4F, 2F, 0F);
		pi2.setTextureSize(64, 64);
		pi2.mirror = true;
		setRotation(pi2, 0F, 0F, 0F);
		pi3 = new ModelRenderer(this, 40, 5);
		pi3.addBox(-5F, -6F, 0F, 3, 3, 2);
		pi3.setRotationPoint(-4F, 2F, 0F);
		pi3.setTextureSize(64, 64);
		pi3.mirror = true;
		setRotation(pi3, 0F, 0F, 0F);
		pi4 = new ModelRenderer(this, 40, 14);
		pi4.addBox(-4F, -3F, 2F, 1, 0, 2);
		pi4.setRotationPoint(-4F, 2F, 0F);
		pi4.setTextureSize(64, 64);
		pi4.mirror = true;
		setRotation(pi4, 0F, 0F, 0F);
		pi5 = new ModelRenderer(this, 40, 10);
		pi5.addBox(-4.5F, -8F, 0F, 2, 2, 2);
		pi5.setRotationPoint(-4F, 2F, 0F);
		pi5.setTextureSize(64, 64);
		pi5.mirror = true;
		setRotation(pi5, 0F, 0F, 0F);
		pi6 = new ModelRenderer(this, 32, 9);
		pi6.addBox(-4F, -7F, -1F, 1, 1, 2);
		pi6.setRotationPoint(-4F, 2F, 0F);
		pi6.setTextureSize(64, 64);
		pi6.mirror = true;
		setRotation(pi6, 0F, 0F, 0F);
		pi7 = new ModelRenderer(this, 32, 2);
		pi7.addBox(-5.5F, -6F, 0.5F, 1, 3, 2);
		pi7.setRotationPoint(-4F, 2F, 0F);
		pi7.setTextureSize(64, 64);
		pi7.mirror = true;
		setRotation(pi7, 0F, 0F, 0F);
		pi8 = new ModelRenderer(this, 32, 2);
		pi8.addBox(-2.5F, -6F, 0.5F, 1, 3, 2);
		pi8.setRotationPoint(-4F, 2F, 0F);
		pi8.setTextureSize(64, 64);
		pi8.mirror = true;
		setRotation(pi8, 0F, 0F, 0F);
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
		hat2.render(f5);
		hat1.render(f5);
		pi1.render(f5);
		pi2.render(f5);
		pi3.render(f5);
		pi4.render(f5);
		pi5.render(f5);
		pi6.render(f5);
		pi7.render(f5);
		pi8.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
	{
		leftleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.0F * par3;
		rightleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.0F * par3;

		leftarm.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.0F * par3;
		rightarm.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.0F * par3;
		
		pi1.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
		pi2.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
		pi3.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
		pi4.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
		pi5.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
		pi6.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
		pi7.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
		pi8.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 2.0F * par3 * 0.5F;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);

	}

}
