package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;

public class ModelBisonPower extends ModelZoanMorph
{
	public ModelRenderer rightarm1;
	public ModelRenderer leftarm1;
	public ModelRenderer rightleg4;
	public ModelRenderer leftleg4;
	public ModelRenderer body2;
	public ModelRenderer rightarm2;
	public ModelRenderer righthull1;
	public ModelRenderer leftarm2;
	public ModelRenderer lefthull1;
	public ModelRenderer rightleg3;
	public ModelRenderer rightleg2;
	public ModelRenderer rightleg1;
	public ModelRenderer leftleg3;
	public ModelRenderer leftleg2;
	public ModelRenderer leftleg1;
	public ModelRenderer body1;
	public ModelRenderer body3;
	public ModelRenderer body4;
	public ModelRenderer body5;
	public ModelRenderer body6;
	public ModelRenderer head;
	public ModelRenderer righthorn1;
	public ModelRenderer righthorn2;
	public ModelRenderer lefthorn1;
	public ModelRenderer lefthorn2;

	public ModelBisonPower()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.rightleg4 = new ModelRenderer(this, 9, 30);
		this.rightleg4.setRotationPoint(-3.0F, 11.6F, 0.5F);
		this.rightleg4.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(rightleg4, -0.3490658503988659F, -0.0F, 0.0F);
		this.rightleg1 = new ModelRenderer(this, 0, 39);
		this.rightleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightleg1.addBox(-1.0F, 10.5F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(rightleg1, 0.5235987755982988F, -0.0F, 0.0F);
		this.body1 = new ModelRenderer(this, 17, 0);
		this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body1.addBox(-5.0F, 9.9F, -2.0F, 10, 8, 5, 0.0F);
		this.lefthull1 = new ModelRenderer(this, 0, 25);
		this.lefthull1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lefthull1.addBox(2.0F, 12.0F, -3.0F, 3, 3, 1, 0.0F);
		this.setRotateAngle(lefthull1, 0.17453292519943295F, -0.0F, 0.0F);
		this.rightleg2 = new ModelRenderer(this, 0, 30);
		this.rightleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightleg2.addBox(-1.0F, 3.1F, 4.8F, 2, 6, 2, 0.0F);
		this.setRotateAngle(rightleg2, -2.007128639793479F, -0.0F, 0.0F);
		this.righthull1 = new ModelRenderer(this, 0, 25);
		this.righthull1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.righthull1.addBox(-4.3F, 12.0F, -3.0F, 3, 3, 1, 0.0F);
		this.setRotateAngle(righthull1, 0.17453292519943295F, 0.0F, 0.017453292519943295F);
		this.leftleg2 = new ModelRenderer(this, 0, 30);
		this.leftleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftleg2.addBox(-1.5F, 3.3F, 4.4F, 2, 6, 2, 0.0F);
		this.setRotateAngle(leftleg2, -2.007128639793479F, -0.0F, 0.0F);
		this.leftleg1 = new ModelRenderer(this, 0, 39);
		this.leftleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftleg1.addBox(-1.5F, 10.5F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(leftleg1, 0.5235987755982988F, -0.0F, 0.0F);
		this.leftleg3 = new ModelRenderer(this, 9, 41);
		this.leftleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftleg3.addBox(-1.5F, -1.5F, -6.8F, 2, 4, 2, 0.0F);
		this.setRotateAngle(leftleg3, 1.8151424220741026F, -0.0F, 0.0F);
		this.lefthorn1 = new ModelRenderer(this, 115, 0);
		this.lefthorn1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lefthorn1.addBox(1.0F, 1.0F, -6.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(lefthorn1, 0.0F, -0.0F, -0.7330382858376184F);
		this.righthorn2 = new ModelRenderer(this, 122, 0);
		this.righthorn2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.righthorn2.addBox(-1.3F, 2.5F, -6.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(righthorn2, 0.0F, 0.0F, 1.9198621771937625F);
		this.rightleg3 = new ModelRenderer(this, 9, 41);
		this.rightleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightleg3.addBox(-1.0F, -0.9F, -6.8F, 2, 4, 2, 0.0F);
		this.setRotateAngle(rightleg3, 1.8151424220741026F, -0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -1.0F, -7.0F, 4, 5, 4, 0.0F);
		this.leftarm2 = new ModelRenderer(this, 23, 42);
		this.leftarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftarm2.addBox(2.0F, 5.8F, -2.0F, 3, 7, 3, 0.0F);
		this.setRotateAngle(leftarm2, 0.0F, -0.0F, 0.2792526803190927F);
		this.lefthorn2 = new ModelRenderer(this, 122, 0);
		this.lefthorn2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lefthorn2.addBox(-0.7F, 2.5F, -6.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(lefthorn2, 0.0F, -0.0F, -1.9198621771937625F);
		this.body6 = new ModelRenderer(this, 83, 24);
		this.body6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body6.addBox(-4.5F, 0.0F, -0.5F, 9, 10, 6, 0.0F);
		this.setRotateAngle(body6, 0.41887902047863906F, -0.0F, 0.0F);
		this.body3 = new ModelRenderer(this, 83, 0);
		this.body3.setRotationPoint(-3.5F, 4.0F, 0.0F);
		this.body3.addBox(-3.0F, -3.0F, -2.0F, 6, 7, 4, 0.0F);
		this.setRotateAngle(body3, 0.0F, 0.0F, -0.2617993877991494F);
		this.righthorn1 = new ModelRenderer(this, 115, 0);
		this.righthorn1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.righthorn1.addBox(-3.0F, 1.0F, -6.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(righthorn1, 0.0F, -0.0F, 0.7330382858376184F);
		this.leftarm1 = new ModelRenderer(this, 23, 30);
		this.leftarm1.setRotationPoint(5.0F, -2.6F, 0.0F);
		this.leftarm1.addBox(0.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.setRotateAngle(leftarm1, 0.0F, -0.0F, -0.20943951023931953F);
		this.leftleg4 = new ModelRenderer(this, 9, 30);
		this.leftleg4.setRotationPoint(3.5F, 11.600000381469727F, 1.0F);
		this.leftleg4.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
		this.setRotateAngle(leftleg4, -0.34906584024429316F, -0.0F, 0.0F);
		this.rightarm1 = new ModelRenderer(this, 23, 30);
		this.rightarm1.setRotationPoint(-5.0F, -2.6F, 0.0F);
		this.rightarm1.addBox(-4.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.setRotateAngle(rightarm1, 0.0F, -0.0F, 0.20943951023931953F);
		this.body2 = new ModelRenderer(this, 48, 0);
		this.body2.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.body2.addBox(-5.5F, 0.0F, -2.5F, 11, 10, 6, 0.0F);
		this.body4 = new ModelRenderer(this, 83, 0);
		this.body4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body4.addBox(1.5F, 0.0F, -2.0F, 6, 7, 4, 0.0F);
		this.setRotateAngle(body4, 0.0F, -0.0F, 0.2617993877991494F);
		this.rightarm2 = new ModelRenderer(this, 23, 42);
		this.rightarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightarm2.addBox(-4.5F, 5.5F, -2.0F, 3, 7, 3, 0.0F);
		this.setRotateAngle(rightarm2, 0.0F, -0.0F, -0.2792526803190927F);
		this.body5 = new ModelRenderer(this, 83, 12);
		this.body5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body5.addBox(-3.5F, 0.0F, -5.0F, 7, 7, 4, 0.0F);
		this.setRotateAngle(body5, 0.4886921905584123F, -0.0F, 0.0F);
		this.rightleg2.addChild(this.rightleg1);
		this.body2.addChild(this.body1);
		this.leftarm2.addChild(this.lefthull1);
		this.rightleg3.addChild(this.rightleg2);
		this.rightarm2.addChild(this.righthull1);
		this.leftleg3.addChild(this.leftleg2);
		this.leftleg2.addChild(this.leftleg1);
		this.leftleg4.addChild(this.leftleg3);
		this.head.addChild(this.lefthorn1);
		this.head.addChild(this.righthorn2);
		this.rightleg4.addChild(this.rightleg3);
		this.body2.addChild(this.head);
		this.leftarm1.addChild(this.leftarm2);
		this.head.addChild(this.lefthorn2);
		this.body2.addChild(this.body6);
		this.body2.addChild(this.body3);
		this.head.addChild(this.righthorn1);
		this.body2.addChild(this.body4);
		this.rightarm1.addChild(this.rightarm2);
		this.body2.addChild(this.body5);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
	{
		EntityLivingBase entity = ((EntityLivingBase) ent);

		this.head.rotateAngleY = headYaw / (270F / (float) Math.PI);
		this.head.rotateAngleX = headPitch / (360F / (float) Math.PI);

		this.leftleg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.rightleg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;

		this.rightarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		this.leftarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount;

		if (entity.isSwingInProgress)
		{
			this.rightarm1.rotateAngleX = MathHelper.sin(entity.swingProgress * 3.0F + (float) Math.PI) * 1.2F;
			this.rightarm1.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + (float) Math.PI) * -0.2F;
			this.rightarm1.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + (float) Math.PI) * 0.5F;
		}

		if (ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) <= 0.05F && !entity.isSwingInProgress)
		{
			this.rightarm1.rotateAngleX = 0;
			this.rightarm1.rotateAngleY = 0;
			this.rightarm1.rotateAngleZ = 0.209F;
		}
		else if (!entity.isSwingInProgress && ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) > 0)
		{
			this.rightarm1.rotateAngleY = 0;
			this.rightarm1.rotateAngleZ = 0.209F;
		}

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.rightleg4.render(f5);
		this.leftarm1.render(f5);
		this.leftleg4.render(f5);
		this.rightarm1.render(f5);
		this.body2.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public ModelRenderer getHandRenderer()
	{
		GL11.glScaled(1.2, 1.2, 1);
		GL11.glTranslated(-0.1, -0.1, 0.05);
		GL11.glRotated(-7, 1, 0, 0);
		GL11.glRotated(7, 0, 0, 1);
		return this.rightarm2;
	}
}
