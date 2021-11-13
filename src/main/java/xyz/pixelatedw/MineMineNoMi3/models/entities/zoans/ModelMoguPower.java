package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelMoguPower extends ModelZoanMorph
{
	public ModelRenderer leftleg;
	public ModelRenderer leftfoot;
	public ModelRenderer leftfootClaw1;
	public ModelRenderer leftfootClaw2;
	public ModelRenderer leftfootClaw3;
	public ModelRenderer leftfootClaw4;
	public ModelRenderer head1;
	public ModelRenderer body1;
	public ModelRenderer rightarm1;
	public ModelRenderer leftarm1;
	public ModelRenderer rightleg;
	public ModelRenderer mouth3;
	public ModelRenderer mouth1;
	public ModelRenderer mouth2;
	public ModelRenderer mouth4;
	public ModelRenderer body2;
	public ModelRenderer body3;
	public ModelRenderer rightarm2;
	public ModelRenderer righthand1;
	public ModelRenderer rightClaw10;
	public ModelRenderer rightClaw20;
	public ModelRenderer rightClaw30;
	public ModelRenderer rightClaw40;
	public ModelRenderer rightClaw11;
	public ModelRenderer rightClaw12;
	public ModelRenderer rightClaw21;
	public ModelRenderer rightClaw22;
	public ModelRenderer rightClaw31;
	public ModelRenderer rightClaw32;
	public ModelRenderer rightClaw41;
	public ModelRenderer leftarm2;
	public ModelRenderer righthand1_1;
	public ModelRenderer rightClaw10_1;
	public ModelRenderer rightClaw40_1;
	public ModelRenderer rightClaw20_1;
	public ModelRenderer rightClaw20_2;
	public ModelRenderer rightClaw11_1;
	public ModelRenderer rightClaw12_1;
	public ModelRenderer rightClaw41_1;
	public ModelRenderer rightClaw21_1;
	public ModelRenderer rightClaw22_1;
	public ModelRenderer rightClaw21_2;
	public ModelRenderer rightClaw22_2;
	public ModelRenderer rightfoot;
	public ModelRenderer rightfootClaw1;
	public ModelRenderer rightfootClaw2;
	public ModelRenderer rightfootClaw3;
	public ModelRenderer rightfootClaw4;

	public ModelMoguPower()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.mouth4 = new ModelRenderer(this, 36, 5);
		this.mouth4.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.mouth4.addBox(-1.0F, -1.0F, -3.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(mouth4, -0.24434609527920614F, -0.0F, 0.0F);
		this.rightClaw20_2 = new ModelRenderer(this, 73, 44);
		this.rightClaw20_2.setRotationPoint(1.5F, 1.5F, 1.5F);
		this.rightClaw20_2.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw20_2, 0.0F, 0.0F, -0.4363323129985824F);
		this.leftarm1 = new ModelRenderer(this, 73, 12);
		this.leftarm1.setRotationPoint(5.400000095367432F, 2.0F, 0.0F);
		this.leftarm1.addBox(0.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
		this.setRotateAngle(leftarm1, 0.0F, -0.0F, -0.06981316953897475F);
		this.rightClaw22_2 = new ModelRenderer(this, 73, 49);
		this.rightClaw22_2.setRotationPoint(-0.5F, 2.0F, 0.0F);
		this.rightClaw22_2.addBox(-1.0F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw22_2, 0.0F, 0.0F, 0.9599310885968813F);
		this.rightClaw31 = new ModelRenderer(this, 73, 49);
		this.rightClaw31.setRotationPoint(0.3F, 2.0F, 0.0F);
		this.rightClaw31.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw31, 0.0F, 0.0F, -0.4363323129985824F);
		this.rightClaw20_1 = new ModelRenderer(this, 73, 44);
		this.rightClaw20_1.setRotationPoint(1.5F, 1.5F, 0.0F);
		this.rightClaw20_1.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw20_1, 0.0F, 0.0F, -0.4363323129985824F);
		this.leftleg = new ModelRenderer(this, 0, 12);
		this.leftleg.setRotationPoint(3.0F, 17.0F, 0.0F);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.rightfootClaw2 = new ModelRenderer(this, 0, 27);
		this.rightfootClaw2.setRotationPoint(0.5F, 0.4F, -0.4F);
		this.rightfootClaw2.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(rightfootClaw2, -0.7853981633974483F, 0.0F, 0.0F);
		this.leftfootClaw4 = new ModelRenderer(this, 0, 27);
		this.leftfootClaw4.setRotationPoint(-1.4F, 0.4F, -0.4F);
		this.leftfootClaw4.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(leftfootClaw4, -0.7853981633974483F, 0.136659280431156F, -0.18203784098300857F);
		this.rightClaw10 = new ModelRenderer(this, 73, 44);
		this.rightClaw10.setRotationPoint(0.5F, 2.5F, -1.5F);
		this.rightClaw10.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw10, 0.0F, 0.0F, 0.3490658503988659F);
		this.rightClaw22 = new ModelRenderer(this, 73, 49);
		this.rightClaw22.setRotationPoint(-1.0F, 1.0F, 0.0F);
		this.rightClaw22.addBox(-1.0F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw22, 0.0F, 0.0F, -0.7853981633974483F);
		this.mouth2 = new ModelRenderer(this, 25, 5);
		this.mouth2.setRotationPoint(1.0F, 0.0F, 0.2F);
		this.mouth2.addBox(-1.0F, -1.0F, -3.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(mouth2, 0.0F, 0.3490658503988659F, 0.0F);
		this.rightClaw10_1 = new ModelRenderer(this, 73, 44);
		this.rightClaw10_1.setRotationPoint(1.5F, 1.5F, -1.5F);
		this.rightClaw10_1.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw10_1, 0.0F, 0.0F, -0.4363323129985824F);
		this.rightClaw12_1 = new ModelRenderer(this, 73, 49);
		this.rightClaw12_1.setRotationPoint(-0.5F, 2.0F, 0.0F);
		this.rightClaw12_1.addBox(-1.0F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw12_1, 0.0F, 0.0F, 0.9599310885968813F);
		this.rightClaw11_1 = new ModelRenderer(this, 73, 49);
		this.rightClaw11_1.setRotationPoint(-0.5F, 2.95F, 0.0F);
		this.rightClaw11_1.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw11_1, 0.0F, 0.0F, 0.4363323129985824F);
		this.rightClaw41 = new ModelRenderer(this, 80, 48);
		this.rightClaw41.setRotationPoint(0.0F, 1.7F, -0.1F);
		this.rightClaw41.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightClaw41, 0.7740535232594852F, 0.0F, 0.0F);
		this.rightClaw21 = new ModelRenderer(this, 73, 49);
		this.rightClaw21.setRotationPoint(0.3F, 2.0F, 0.0F);
		this.rightClaw21.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw21, 0.0F, 0.0F, -0.4363323129985824F);
		this.body2 = new ModelRenderer(this, 17, 36);
		this.body2.setRotationPoint(0.0F, 0.5F, -0.5F);
		this.body2.addBox(-5.0F, 0.0F, -3.0F, 10, 16, 7, 0.0F);
		this.leftfootClaw3 = new ModelRenderer(this, 0, 27);
		this.leftfootClaw3.setRotationPoint(-0.6F, 0.4F, -0.4F);
		this.leftfootClaw3.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(leftfootClaw3, -0.7853981633974483F, 0.0F, 0.0F);
		this.mouth3 = new ModelRenderer(this, 36, 0);
		this.mouth3.setRotationPoint(0.0F, -2.0F, -2.700000047683716F);
		this.mouth3.addBox(-1.0F, -1.0F, -3.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(mouth3, 0.17453292012214658F, -0.0F, 0.0F);
		this.rightarm1 = new ModelRenderer(this, 73, 12);
		this.rightarm1.setRotationPoint(-5.400000095367432F, 2.0F, 0.0F);
		this.rightarm1.addBox(-4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
		this.setRotateAngle(rightarm1, 0.0F, -0.0F, 0.06981316953897475F);
		this.rightClaw20 = new ModelRenderer(this, 73, 44);
		this.rightClaw20.setRotationPoint(0.5F, 2.5F, 0.0F);
		this.rightClaw20.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw20, 0.0F, 0.0F, 0.3490658503988659F);
		this.rightClaw32 = new ModelRenderer(this, 73, 49);
		this.rightClaw32.setRotationPoint(-1.0F, 1.0F, 0.0F);
		this.rightClaw32.addBox(-1.0F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw32, 0.0F, 0.0F, -0.7853981633974483F);
		this.rightClaw21_1 = new ModelRenderer(this, 73, 49);
		this.rightClaw21_1.setRotationPoint(-0.5F, 2.95F, 0.0F);
		this.rightClaw21_1.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw21_1, 0.0F, 0.0F, 0.4363323129985824F);
		this.rightfootClaw3 = new ModelRenderer(this, 0, 27);
		this.rightfootClaw3.setRotationPoint(-0.6F, 0.4F, -0.4F);
		this.rightfootClaw3.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(rightfootClaw3, -0.7853981633974483F, 0.0F, 0.0F);
		this.body1 = new ModelRenderer(this, 17, 12);
		this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body1.addBox(-5.5F, 0.0F, -3.0F, 11, 17, 6, 0.0F);
		this.rightClaw11 = new ModelRenderer(this, 73, 49);
		this.rightClaw11.setRotationPoint(0.3F, 2.0F, 0.0F);
		this.rightClaw11.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw11, 0.0F, 0.0F, -0.4363323129985824F);
		this.leftarm2 = new ModelRenderer(this, 73, 25);
		this.leftarm2.setRotationPoint(2.0F, 5.6F, 0.0F);
		this.leftarm2.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.setRotateAngle(leftarm2, 0.0F, -0.0F, 0.06981317007977318F);
		this.rightClaw12 = new ModelRenderer(this, 73, 49);
		this.rightClaw12.setRotationPoint(-1.0F, 1.0F, 0.0F);
		this.rightClaw12.addBox(-1.0F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw12, 0.0F, 0.0F, -0.7853981633974483F);
		this.rightClaw41_1 = new ModelRenderer(this, 80, 48);
		this.rightClaw41_1.setRotationPoint(0.0F, 1.7F, -0.1F);
		this.rightClaw41_1.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightClaw41_1, 0.7740535232594852F, 0.0F, 0.0F);
		this.rightleg = new ModelRenderer(this, 0, 12);
		this.rightleg.setRotationPoint(-3.0F, 17.0F, 0.0F);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.leftfoot = new ModelRenderer(this, 0, 24);
		this.leftfoot.setRotationPoint(0.0F, 5.5F, -1.9F);
		this.leftfoot.addBox(-2.0F, 0.0F, -1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(leftfoot, 0.7853981633974483F, -0.0F, 0.0F);
		this.body3 = new ModelRenderer(this, 52, 12);
		this.body3.setRotationPoint(0.0F, 9.0F, -3.0F);
		this.body3.addBox(-4.5F, -8.5F, -1.0F, 9, 15, 1, 0.0F);
		this.rightClaw30 = new ModelRenderer(this, 73, 44);
		this.rightClaw30.setRotationPoint(0.5F, 2.5F, 1.5F);
		this.rightClaw30.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw30, 0.0F, 0.0F, 0.3490658503988659F);
		this.rightarm2 = new ModelRenderer(this, 73, 25);
		this.rightarm2.setRotationPoint(-2.0F, 5.6F, 0.0F);
		this.rightarm2.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.setRotateAngle(rightarm2, 0.0F, -0.0F, -0.06981317007977318F);
		this.rightfootClaw1 = new ModelRenderer(this, 0, 27);
		this.rightfootClaw1.setRotationPoint(1.5F, 0.4F, -0.4F);
		this.rightfootClaw1.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(rightfootClaw1, -0.7853981633974483F, -0.045553093477052F, 0.091106186954104F);
		this.rightClaw40 = new ModelRenderer(this, 80, 44);
		this.rightClaw40.mirror = true;
		this.rightClaw40.setRotationPoint(0.7F, 1.2F, -1.5F);
		this.rightClaw40.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightClaw40, -0.6981317007977318F, 0.0F, 0.0F);
		this.rightClaw22_1 = new ModelRenderer(this, 73, 49);
		this.rightClaw22_1.setRotationPoint(-0.5F, 2.0F, 0.0F);
		this.rightClaw22_1.addBox(-1.0F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw22_1, 0.0F, 0.0F, 0.9599310885968813F);
		this.head1 = new ModelRenderer(this, 0, 0);
		this.head1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head1.addBox(-3.0F, -5.0F, -3.0F, 6, 5, 6, 0.0F);
		this.righthand1 = new ModelRenderer(this, 73, 37);
		this.righthand1.setRotationPoint(-0.2F, 6.8F, 0.0F);
		this.righthand1.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 4, 0.0F);
		this.setRotateAngle(righthand1, 0.0F, 0.0F, -0.08726646259971647F);
		this.leftfootClaw2 = new ModelRenderer(this, 0, 27);
		this.leftfootClaw2.setRotationPoint(0.5F, 0.4F, -0.4F);
		this.leftfootClaw2.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(leftfootClaw2, -0.7853981633974483F, 0.0F, 0.0F);
		this.rightfootClaw4 = new ModelRenderer(this, 0, 27);
		this.rightfootClaw4.setRotationPoint(-1.4F, 0.4F, -0.4F);
		this.rightfootClaw4.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(rightfootClaw4, -0.7853981633974483F, 0.136659280431156F, -0.18203784098300857F);
		this.rightClaw40_1 = new ModelRenderer(this, 80, 44);
		this.rightClaw40_1.mirror = true;
		this.rightClaw40_1.setRotationPoint(0.7F, 1.2F, -1.5F);
		this.rightClaw40_1.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(rightClaw40_1, -0.6981317007977318F, 0.0F, 0.0F);
		this.righthand1_1 = new ModelRenderer(this, 73, 37);
		this.righthand1_1.setRotationPoint(0.0F, 6.8F, 0.0F);
		this.righthand1_1.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 4, 0.0F);
		this.setRotateAngle(righthand1_1, 0.0F, 0.0F, 0.08726646259971647F);
		this.rightClaw21_2 = new ModelRenderer(this, 73, 49);
		this.rightClaw21_2.setRotationPoint(-0.5F, 2.95F, 0.0F);
		this.rightClaw21_2.addBox(-2.0F, -1.0F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(rightClaw21_2, 0.0F, 0.0F, 0.4363323129985824F);
		this.leftfootClaw1 = new ModelRenderer(this, 0, 27);
		this.leftfootClaw1.setRotationPoint(1.5F, 0.4F, -0.4F);
		this.leftfootClaw1.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(leftfootClaw1, -0.7853981633974483F, -0.045553093477052F, 0.091106186954104F);
		this.mouth1 = new ModelRenderer(this, 25, 0);
		this.mouth1.setRotationPoint(-1.0F, 0.0F, 0.5F);
		this.mouth1.addBox(-1.0F, -1.0F, -3.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(mouth1, 0.0F, -0.3490658503988659F, 0.0F);
		this.rightfoot = new ModelRenderer(this, 0, 24);
		this.rightfoot.setRotationPoint(0.0F, 5.5F, -1.9F);
		this.rightfoot.addBox(-2.0F, 0.0F, -1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rightfoot, 0.7853981633974483F, -0.0F, 0.0F);
		this.mouth3.addChild(this.mouth4);
		this.righthand1_1.addChild(this.rightClaw20_2);
		this.rightClaw21_2.addChild(this.rightClaw22_2);
		this.rightClaw30.addChild(this.rightClaw31);
		this.righthand1_1.addChild(this.rightClaw20_1);
		this.rightfoot.addChild(this.rightfootClaw2);
		this.leftfoot.addChild(this.leftfootClaw4);
		this.righthand1.addChild(this.rightClaw10);
		this.rightClaw21.addChild(this.rightClaw22);
		this.mouth3.addChild(this.mouth2);
		this.righthand1_1.addChild(this.rightClaw10_1);
		this.rightClaw11_1.addChild(this.rightClaw12_1);
		this.rightClaw10_1.addChild(this.rightClaw11_1);
		this.rightClaw40.addChild(this.rightClaw41);
		this.rightClaw20.addChild(this.rightClaw21);
		this.body1.addChild(this.body2);
		this.leftfoot.addChild(this.leftfootClaw3);
		this.head1.addChild(this.mouth3);
		this.righthand1.addChild(this.rightClaw20);
		this.rightClaw31.addChild(this.rightClaw32);
		this.rightClaw20_1.addChild(this.rightClaw21_1);
		this.rightfoot.addChild(this.rightfootClaw3);
		this.rightClaw10.addChild(this.rightClaw11);
		this.leftarm1.addChild(this.leftarm2);
		this.rightClaw11.addChild(this.rightClaw12);
		this.rightClaw40_1.addChild(this.rightClaw41_1);
		this.leftleg.addChild(this.leftfoot);
		this.body2.addChild(this.body3);
		this.righthand1.addChild(this.rightClaw30);
		this.rightarm1.addChild(this.rightarm2);
		this.rightfoot.addChild(this.rightfootClaw1);
		this.righthand1.addChild(this.rightClaw40);
		this.rightClaw21_1.addChild(this.rightClaw22_1);
		this.rightarm2.addChild(this.righthand1);
		this.leftfoot.addChild(this.leftfootClaw2);
		this.rightfoot.addChild(this.rightfootClaw4);
		this.righthand1_1.addChild(this.rightClaw40_1);
		this.leftarm2.addChild(this.righthand1_1);
		this.rightClaw20_2.addChild(this.rightClaw21_2);
		this.leftfoot.addChild(this.leftfootClaw1);
		this.mouth3.addChild(this.mouth1);
		this.rightleg.addChild(this.rightfoot);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		this.leftarm1.render(f5);
		this.leftleg.render(f5);
		this.rightarm1.render(f5);
		this.body1.render(f5);
		this.rightleg.render(f5);
		this.head1.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
	{
		EntityLivingBase entity = ((EntityLivingBase) ent);

		this.head1.rotateAngleY = headYaw / (270F / (float) Math.PI);
		this.head1.rotateAngleX = headPitch / (360F / (float) Math.PI);

		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;

		this.rightarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		this.leftarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount;

		if (entity.isSwingInProgress)
		{
			this.rightarm1.rotateAngleX = MathHelper.sin(entity.swingProgress * 3.0F + (float) Math.PI) * 1.5F;
			this.rightarm1.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + (float) Math.PI) * -0.2F;
			this.rightarm1.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + (float) Math.PI) * 0.5F;
		}

		if (ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) <= 0.05F && !entity.isSwingInProgress)
		{
			this.rightarm1.rotateAngleX = 0;
			this.rightarm1.rotateAngleY = 0;
			this.rightarm1.rotateAngleZ = 0.1F;
		}
		else if (!entity.isSwingInProgress && ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) > 0)
		{
			this.rightarm1.rotateAngleY = 0;
			this.rightarm1.rotateAngleZ = 0.1F;
		}

	}
	
	public ModelRenderer getHandRenderer()
	{
		GL11.glScaled(1.2, 1.2, 1);
		GL11.glTranslated(-0.1, -0.14, 0.05);
		GL11.glRotated(-1, 1, 0, 0);
		GL11.glRotated(7, 0, 0, 1);
		GL11.glRotated(-35, 0, 1, 0);
		return this.righthand1;
	}
}
