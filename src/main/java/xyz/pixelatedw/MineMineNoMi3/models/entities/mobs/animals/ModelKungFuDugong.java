package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityKungFuDugong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDugong;

public class ModelKungFuDugong extends ModelBiped
{
	public ModelRenderer head;
	public ModelRenderer headShell;
	public ModelRenderer body1;
	public ModelRenderer body2;
	public ModelRenderer bodyShell;
	public ModelRenderer rightArm;
	public ModelRenderer leftArm;
	public ModelRenderer snout;
	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer tail4;
	public ModelRenderer leftTail1;
	public ModelRenderer rightTail1;

	public ModelKungFuDugong()
	{
		this.textureWidth = 100;
		this.textureHeight = 50;
		this.tail3 = new ModelRenderer(this, 48, 16);
		this.tail3.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.tail3.addBox(-2.0F, 0.0F, -1.0F, 4, 2, 2, 0.0F);
		this.body2 = new ModelRenderer(this, 21, 14);
		this.body2.setRotationPoint(0.0F, 18.0F, -0.20000000298023224F);
		this.body2.addBox(-3.5F, 0.0F, -2.0F, 7, 6, 4, 0.0F);
		this.setRotateAngle(body2, 0.43633231520652765F, -0.0F, 0.0F);
		this.rightTail1 = new ModelRenderer(this, 48, 25);
		this.rightTail1.setRotationPoint(-0.5F, 0.0F, 0.0F);
		this.rightTail1.addBox(-3.0F, -2.0F, -0.5F, 3, 2, 1, 0.0F);
		this.setRotateAngle(rightTail1, 0.0F, -0.22689280275926282F, 0.3490658503988659F);
		this.rightArm = new ModelRenderer(this, 0, 24);
		this.rightArm.setRotationPoint(-4.5F, 12.300000190734863F, 0.0F);
		this.rightArm.addBox(-1.5F, -1.0F, -1.5F, 2, 7, 3, 0.0F);
		this.leftArm = new ModelRenderer(this, 0, 24);
		this.leftArm.setRotationPoint(4.5F, 12.300000190734863F, 0.0F);
		this.leftArm.addBox(-0.5F, -1.0F, -1.5F, 2, 7, 3, 0.0F);
		this.snout = new ModelRenderer(this, 0, 20);
		this.snout.setRotationPoint(0.0F, 1.0F, -2.7F);
		this.snout.addBox(-1.5F, -1.0F, -1.0F, 3, 2, 1, 0.0F);
		this.tail2 = new ModelRenderer(this, 48, 9);
		this.tail2.setRotationPoint(0.0F, 3.0F, -0.5F);
		this.tail2.addBox(-2.5F, 0.0F, -1.5F, 5, 3, 3, 0.0F);
		this.setRotateAngle(tail2, 0.6981317007977318F, 0.0F, 0.0F);
		this.tail4 = new ModelRenderer(this, 48, 21);
		this.tail4.setRotationPoint(0.0F, 1.7F, -0.1F);
		this.tail4.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(tail4, -2.96705972839036F, -0.0F, 0.0F);
		this.leftTail1 = new ModelRenderer(this, 48, 25);
		this.leftTail1.setRotationPoint(0.4F, 0.0F, -0.5F);
		this.leftTail1.addBox(0.0F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
		this.setRotateAngle(leftTail1, 0.0F, 0.22689280275926282F, -0.3490658503988659F);
		this.body1 = new ModelRenderer(this, 21, 0);
		this.body1.setRotationPoint(0.0F, 11.0F, 0.0F);
		this.body1.addBox(-4.0F, 0.0F, -2.5F, 8, 8, 5, 0.0F);
		this.head = new ModelRenderer(this, 0, 9);
		this.head.setRotationPoint(0.0F, 8.5F, -0.20000000298023224F);
		this.head.addBox(-2.5F, -2.5F, -2.5999999046325684F, 5, 5, 5, 0.0F);
		this.tail1 = new ModelRenderer(this, 48, 0);
		this.tail1.setRotationPoint(0.0F, 4.2F, -1.0F);
		this.tail1.addBox(-3.0F, 0.0F, -2.0F, 6, 4, 4, 0.0F);
		this.setRotateAngle(tail1, 1.1344640137963142F, -0.0F, 0.0F);
		this.bodyShell = new ModelRenderer(this, 21, 25);
		this.bodyShell.setRotationPoint(0.0F, 11.0F, 2.0F);
		this.bodyShell.addBox(-4.5F, -0.5F, -1.5F, 9, 9, 3, 0.0F);
		this.headShell = new ModelRenderer(this, 0, 0);
		this.headShell.setRotationPoint(0.0F, 8.199999809265137F, -0.5F);
		this.headShell.addBox(-3.0F, -2.5F, 0.0F, 6, 5, 3, 0.0F);
		this.tail2.addChild(this.tail3);
		this.tail4.addChild(this.rightTail1);
		this.head.addChild(this.snout);
		this.tail1.addChild(this.tail2);
		this.tail3.addChild(this.tail4);
		this.tail4.addChild(this.leftTail1);
		this.body2.addChild(this.tail1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.body2.render(f5);
		this.rightArm.render(f5);
		this.leftArm.render(f5);
		this.body1.render(f5);
		this.head.render(f5);
		this.bodyShell.render(f5);
		this.headShell.render(f5);
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

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
	{
		boolean flagTempEntity = ent instanceof TempEntityDugong;
		if (Minecraft.getMinecraft().isGamePaused() || flagTempEntity)
			return;

		EntityKungFuDugong entity = (EntityKungFuDugong)ent;
		
		// Happy Tail animation
		if(entity.isHappy())
		{
			this.tail2.rotateAngleX = 0.4F * (0.7F + MathHelper.cos(ageInTicks * 0.4F));
			this.tail3.rotateAngleX = 0.6F * this.tail2.rotateAngleX;
		}
		else
		{
			this.tail2.rotateAngleX = 0.69F;
			this.tail3.rotateAngleX = WyMathHelper.degToRad(0);
			
			this.tail2.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.3F;
			this.tail3.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.3F;

		}
		
		// Training animations
		if(entity.isTraining())
		{
			float rightArmMovement = MathHelper.cos(ageInTicks * 0.9F);
			float leftArmMovement = -MathHelper.cos(ageInTicks * 0.9F);
			
			if(leftArmMovement >= 0.4 || leftArmMovement <= -0.4)
			{
				this.rightArm.rotateAngleX = WyMathHelper.degToRad(-90);
				this.rightArm.offsetZ = 0.1F * (0.9F - rightArmMovement);
			}
			
			if(rightArmMovement >= 0.4 || rightArmMovement <= -0.4)
			{
				this.leftArm.rotateAngleX = WyMathHelper.degToRad(-90);
				this.leftArm.offsetZ = 0.1F * (0.9F - leftArmMovement);
			}
		}
		else
		{
			this.rightArm.offsetZ = 0;
			this.leftArm.offsetZ = 0;
			
	        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
	        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		}
	}
}
